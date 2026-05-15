package defpackage;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import org.chromium.base.Callback;
import org.chromium.base.ContentUriUtils;
import org.chromium.base.PathUtils;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class J10 {
    public boolean a;
    public boolean b;
    public E10 c;
    public ArrayList d;
    public String e;
    public ArrayList f;

    public static File b() {
        String downloadsDirectory = PathUtils.getDownloadsDirectory();
        if (TextUtils.isEmpty(downloadsDirectory)) {
            return null;
        }
        File file = new File(downloadsDirectory);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (SecurityException e) {
                Log.e("cr_DownloadDirectory", "Exception when creating download directory.", e);
            }
        }
        return file;
    }

    public static boolean c(String str) {
        if (!ContentUriUtils.d(str) && str != null) {
            String[] allPrivateDownloadsDirectories = PathUtils.getAllPrivateDownloadsDirectories();
            for (int i = 1; i < allPrivateDownloadsDirectories.length; i++) {
                if (str.startsWith(allPrivateDownloadsDirectories[i])) {
                    return true;
                }
            }
            if (Build.VERSION.SDK_INT >= 30) {
                for (String str2 : PathUtils.getExternalDownloadVolumesNames()) {
                    if (str.startsWith(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void a(Callback callback) {
        if (!this.b && this.a) {
            PostTask.c(7, callback.c0(this.d));
            return;
        }
        this.f.add(callback);
        if (this.c != null) {
            return;
        }
        E10 e10 = new E10(this, new F10());
        this.c = e10;
        e10.c(AbstractC1103mg.e);
    }
}
