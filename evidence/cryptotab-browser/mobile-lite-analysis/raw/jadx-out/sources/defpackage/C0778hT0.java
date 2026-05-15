package defpackage;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: hT0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0778hT0 {
    public final C1613vO a;
    public final File b;
    public final List c;

    public C0778hT0(C1613vO c1613vO, File file, List list) {
        this.a = c1613vO;
        this.b = file;
        this.c = list;
    }

    public static void a(File file, File file2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            byte[] bArr = new byte[256];
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                while (true) {
                    try {
                        int i = bufferedInputStream2.read(bArr);
                        if (i == -1) {
                            bufferedInputStream2.close();
                            bufferedOutputStream.close();
                            return;
                        }
                        bufferedOutputStream.write(bArr, 0, i);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public static void c(File file, List list, String str) throws Throwable {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, false));
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.write("Content-Disposition: form-data; name=\"logcat\"; filename=\"logcat\"");
            bufferedWriter.newLine();
            bufferedWriter.write("Content-Type: text/plain");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bufferedWriter.write((String) it.next());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            throw th;
        }
    }

    public final File b() throws Throwable {
        BufferedReader bufferedReader;
        boolean z;
        List list = this.c;
        boolean zIsEmpty = list.isEmpty();
        File file = this.b;
        if (zIsEmpty) {
            return file;
        }
        String strA = F.a(file.getName(), ".try0");
        File fileB = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (IOException e) {
                Log.w("cr_LogcatPrepender", String.format(Locale.US, "Error while trying to annotate minidump file %s with logcat data", file.getAbsoluteFile()), e);
                if (0 != 0) {
                    C1613vO.c(null);
                }
                z = false;
            }
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                if (line == null) {
                    return file;
                }
                fileB = this.a.b(strA);
                c(fileB, list, line);
                a(file, fileB);
                z = true;
                if (!z) {
                    return file;
                }
                if (!file.delete()) {
                    Log.w("cr_LogcatPrepender", "Failed to delete minidump file: " + file.getName());
                }
                return fileB;
            } catch (Throwable th) {
                th = th;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }
}
