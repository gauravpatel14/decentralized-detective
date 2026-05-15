package defpackage;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/* JADX INFO: renamed from: eN2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0576eN2 {
    public final long a;
    public final Context b;
    public File c;

    public C0576eN2(Context context) {
        this.b = context;
        this.a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    public static void c(File file) throws IOException {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                c(file2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(BN0.a("Failed to delete '", file.getAbsolutePath(), "'"));
        }
    }

    public static File d(File file, String str) {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    public static void e(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IllegalArgumentException("File input must be directory when it exists.");
            }
        } else {
            file.mkdirs();
            if (!file.isDirectory()) {
                throw new IOException("Unable to create directory: ".concat(String.valueOf(file.getAbsolutePath())));
            }
        }
    }

    public final HashSet a() throws IOException {
        File file = new File(g(), "verified-splits");
        e(file);
        HashSet hashSet = new HashSet();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.getName().endsWith(".apk") && !file2.canWrite()) {
                    hashSet.add(new GF2(file2, file2.getName().substring(0, r6.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    public final void b() throws IOException {
        File fileF = f();
        String[] list = fileF.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.a))) {
                    File file = new File(fileF, str);
                    file.toString();
                    c(file);
                }
            }
        }
    }

    public final File f() throws IOException {
        if (this.c == null) {
            Context context = this.b;
            if (context == null) {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
            this.c = context.getFilesDir();
        }
        File file = new File(this.c, "splitcompat");
        e(file);
        return file;
    }

    public final File g() throws IOException {
        File file = new File(f(), Long.toString(this.a));
        e(file);
        return file;
    }
}
