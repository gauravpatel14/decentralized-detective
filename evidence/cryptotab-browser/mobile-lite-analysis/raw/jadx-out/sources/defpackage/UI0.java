package defpackage;

import android.util.Log;
import android.util.Patterns;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UI0 {
    public static File a(File file, C1613vO c1613vO) {
        Log.i("cr_LogcatCrashExtractor", "Trying to extract logcat for minidump " + file.getName() + ".");
        try {
            file = new C0778hT0(c1613vO, file, b()).b();
            Log.i("cr_LogcatCrashExtractor", "Succeeded extracting logcat to " + file.getName() + ".");
            return file;
        } catch (IOException | InterruptedException e) {
            Log.w("cr_LogcatCrashExtractor", e.toString());
            return file;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.LinkedList, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    public static List b() throws IOException {
        Process processExec = Runtime.getRuntime().exec("logcat -d");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
        ?? linkedList = new LinkedList();
        Integer numValueOf = null;
        while (numValueOf == null) {
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        linkedList.add(line);
                        if (linkedList.size() > 1024) {
                            linkedList.removeFirst();
                        }
                    } else {
                        try {
                            break;
                        } catch (IllegalThreadStateException unused) {
                            Thread.sleep(500L);
                        }
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    throw th;
                }
            }
            numValueOf = Integer.valueOf(processExec.exitValue());
        }
        bufferedReader.close();
        if (numValueOf.intValue() != 0) {
            String str = "Logcat failed: " + numValueOf;
            Log.w("cr_LogcatCrashExtractor", str);
            throw new IOException(str);
        }
        int size = linkedList.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (((String) linkedList.get(size)).contains("-----BEGIN BREAKPAD MICRODUMP-----")) {
                linkedList = linkedList.subList(0, size);
                linkedList.add("-----SNIPPED OUT BREAKPAD MICRODUMP FOR THIS CRASH-----");
                break;
            }
            size--;
        }
        int size2 = linkedList.size();
        ?? SubList = linkedList;
        if (size2 > 256) {
            SubList = linkedList.subList(linkedList.size() - 256, linkedList.size());
        }
        ArrayList arrayList = new ArrayList(SubList.size());
        for (String str2 : SubList) {
            Pattern pattern = Pg1.a;
            arrayList.add(Pg1.d.matcher(Pg1.c.matcher(Patterns.IP_ADDRESS.matcher(Pg1.a(Patterns.EMAIL_ADDRESS.matcher(str2).replaceAll("XXX@EMAIL.ELIDED"))).replaceAll("1.2.3.4")).replaceAll("01:23:45:67:89:AB")).replaceAll("[ELIDED:CONSOLE(0)] ELIDED CONSOLE MESSAGE"));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
