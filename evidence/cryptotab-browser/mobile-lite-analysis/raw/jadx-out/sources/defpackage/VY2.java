package defpackage;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VY2 {
    public static final Pattern b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    public final C0576eN2 a;

    public VY2(C0576eN2 c0576eN2) {
        this.a = c0576eN2;
    }

    public static void b(GF2 gf2, InterfaceC0967kW2 interfaceC0967kW2) throws IllegalAccessException, IOException, InvocationTargetException {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(gf2.a);
            try {
                HashMap map = new HashMap();
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    Matcher matcher = b.matcher(zipEntryNextElement.getName());
                    if (matcher.matches()) {
                        String strGroup = matcher.group(1);
                        String strGroup2 = matcher.group(2);
                        Set hashSet = (Set) map.get(strGroup);
                        if (hashSet == null) {
                            hashSet = new HashSet();
                            map.put(strGroup, hashSet);
                        }
                        hashSet.add(new C1281pY2(zipEntryNextElement, strGroup2));
                    }
                }
                HashMap map2 = new HashMap();
                for (String str : Build.SUPPORTED_ABIS) {
                    if (map.containsKey(str)) {
                        for (C1281pY2 c1281pY2 : (Set) map.get(str)) {
                            boolean zContainsKey = map2.containsKey(c1281pY2.a);
                            String str2 = c1281pY2.a;
                            if (!zContainsKey) {
                                map2.put(str2, c1281pY2);
                            }
                        }
                    }
                }
                interfaceC0967kW2.a(zipFile, new HashSet(map2.values()));
                zipFile.close();
            } catch (IOException e) {
                e = e;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(e, e2);
                    }
                }
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
        }
    }

    public final HashSet a() throws IllegalAccessException, IOException, InvocationTargetException {
        C0576eN2 c0576eN2 = this.a;
        HashSet<GF2> hashSetA = c0576eN2.a();
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(c0576eN2.g(), "native-libraries");
        C0576eN2.e(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        for (String str : arrayList) {
            Iterator it = hashSetA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Log.i("SplitCompat", "NativeLibraryExtractor: extracted split '" + str + "' has no corresponding split; deleting");
                    File file3 = new File(c0576eN2.g(), "native-libraries");
                    C0576eN2.e(file3);
                    File fileD = C0576eN2.d(file3, str);
                    C0576eN2.e(fileD);
                    C0576eN2.c(fileD);
                    break;
                }
                if (((GF2) it.next()).b.equals(str)) {
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (GF2 gf2 : hashSetA) {
            HashSet hashSet2 = new HashSet();
            b(gf2, new UT2(this, hashSet2, gf2));
            HashSet<File> hashSet3 = new HashSet();
            File file4 = new File(c0576eN2.g(), "native-libraries");
            C0576eN2.e(file4);
            String str2 = gf2.b;
            File fileD2 = C0576eN2.d(file4, str2);
            C0576eN2.e(fileD2);
            File[] fileArrListFiles2 = fileD2.listFiles();
            if (fileArrListFiles2 != null) {
                for (File file5 : fileArrListFiles2) {
                    if (file5.isFile()) {
                        hashSet3.add(file5);
                    }
                }
            }
            for (File file6 : hashSet3) {
                if (!hashSet2.contains(file6)) {
                    Log.i("SplitCompat", "NativeLibraryExtractor: file '" + file6.getAbsolutePath() + "' found in split '" + str2 + "' that is not in the split file '" + gf2.a.getAbsolutePath() + "'; removing");
                    File parentFile = file6.getParentFile().getParentFile();
                    File file7 = new File(c0576eN2.g(), "native-libraries");
                    C0576eN2.e(file7);
                    if (!parentFile.equals(file7)) {
                        throw new IllegalStateException("File to remove is not a native library");
                    }
                    C0576eN2.c(file6);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    public final void c(GF2 gf2, HashSet hashSet, InterfaceC1157nX2 interfaceC1157nX2) throws IOException {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            C1281pY2 c1281pY2 = (C1281pY2) it.next();
            String str = gf2.b;
            String str2 = c1281pY2.a;
            C0576eN2 c0576eN2 = this.a;
            c0576eN2.getClass();
            File file = new File(c0576eN2.g(), "native-libraries");
            C0576eN2.e(file);
            File fileD = C0576eN2.d(file, str);
            C0576eN2.e(fileD);
            File fileD2 = C0576eN2.d(fileD, str2);
            boolean z = false;
            if (fileD2.exists() && fileD2.length() == c1281pY2.b.getSize() && !fileD2.canWrite()) {
                z = true;
            }
            interfaceC1157nX2.a(c1281pY2, fileD2, z);
        }
    }
}
