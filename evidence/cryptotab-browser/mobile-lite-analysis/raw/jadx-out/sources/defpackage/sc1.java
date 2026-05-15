package defpackage;

import android.content.Context;
import android.system.Os;
import android.util.Log;
import java.io.File;
import java.util.concurrent.Callable;
import org.chromium.base.PathUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sc1 implements Callable {
    @Override // java.util.concurrent.Callable
    public final Object call() {
        String[] strArr = new String[3];
        Context context = AbstractC1499tM.a;
        File dir = context.getDir(PathUtils.c, 0);
        File dir2 = context.getDir("textures", 0);
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            strArr[2] = cacheDir.getPath();
        }
        String path = dir.getPath();
        strArr[0] = path;
        try {
            Os.chmod(path, 448);
        } catch (Exception unused) {
            Log.e("cr_PathUtils", "Failed to set permissions for path \"" + path + "\"");
        }
        strArr[1] = dir2.getPath();
        return strArr;
    }
}
