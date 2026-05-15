package org.chromium.base;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import defpackage.AbstractC1103mg;
import defpackage.AbstractC1499tM;
import defpackage.ExecutorC0859ig;
import defpackage.LP1;
import defpackage.sc1;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PathUtils {
    public static final AtomicBoolean a = new AtomicBoolean();
    public static FutureTask b;
    public static String c;

    public static String a(int i) {
        if (!b.isDone()) {
            LP1 lp1D = LP1.d();
            try {
                b.run();
                lp1D.close();
            } catch (Throwable th) {
                try {
                    lp1D.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
        return ((String[]) b.get())[i];
    }

    public static void b() {
        if (a.getAndSet(true)) {
            return;
        }
        c = "chrome";
        b = new FutureTask(new sc1());
        ExecutorC0859ig executorC0859ig = AbstractC1103mg.e;
        PostTask.c(1, b);
    }

    public static String[] c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file != null && !TextUtils.isEmpty(file.getAbsolutePath())) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] getAllPrivateDownloadsDirectories() {
        List arrayList = new ArrayList();
        LP1 lp1D = LP1.d();
        try {
            File[] externalFilesDirs = AbstractC1499tM.a.getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);
            if (externalFilesDirs != null) {
                arrayList = Arrays.asList(externalFilesDirs);
            }
            lp1D.close();
            return c(arrayList);
        } catch (Throwable th) {
            try {
                lp1D.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public static String getCacheDirectory() {
        return a(2);
    }

    public static String getDataDirectory() {
        return a(0);
    }

    public static String getDownloadsDirectory() {
        LP1 lp1C = LP1.c();
        try {
            if (Build.VERSION.SDK_INT < 29) {
                String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                lp1C.close();
                return path;
            }
            String[] allPrivateDownloadsDirectories = getAllPrivateDownloadsDirectories();
            String str = allPrivateDownloadsDirectories.length == 0 ? "" : allPrivateDownloadsDirectories[0];
            lp1C.close();
            return str;
        } finally {
            try {
                lp1C.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String[] getExternalDownloadVolumesNames() {
        ArrayList arrayList = new ArrayList();
        for (String str : MediaStore.getExternalVolumeNames(AbstractC1499tM.a)) {
            if (!TextUtils.isEmpty(str) && !str.contains("external_primary")) {
                File directory = ((StorageManager) AbstractC1499tM.a.getSystemService(StorageManager.class)).getStorageVolume(MediaStore.Files.getContentUri(str)).getDirectory();
                File file = new File(directory, Environment.DIRECTORY_DOWNLOADS);
                if (!file.isDirectory()) {
                    Log.w("cr_PathUtils", "Download dir missing: " + file.getAbsolutePath() + ", parent dir:" + directory.getAbsolutePath() + ", isDirectory:" + directory.isDirectory());
                }
                arrayList.add(file);
            }
        }
        return c(arrayList);
    }

    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getNativeLibraryDirectory() {
        ApplicationInfo applicationInfo = AbstractC1499tM.a.getApplicationInfo();
        int i = applicationInfo.flags;
        return ((i & 128) != 0 || (i & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
    }

    public static String getThumbnailCacheDirectory() {
        return a(1);
    }
}
