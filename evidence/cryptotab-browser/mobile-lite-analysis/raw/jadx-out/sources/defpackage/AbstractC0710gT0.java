package defpackage;

import android.os.Build;

/* JADX INFO: renamed from: gT0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0710gT0 {
    public static String a(int i) {
        if (Build.VERSION.SDK_INT < 33 || AbstractC1499tM.a.getApplicationInfo().targetSdkVersion < 33) {
            return "android.permission.READ_EXTERNAL_STORAGE";
        }
        if (i == 2) {
            return "android.permission.READ_MEDIA_IMAGES";
        }
        if (i == 3) {
            return "android.permission.READ_MEDIA_AUDIO";
        }
        if (i != 4) {
            return null;
        }
        return "android.permission.READ_MEDIA_VIDEO";
    }
}
