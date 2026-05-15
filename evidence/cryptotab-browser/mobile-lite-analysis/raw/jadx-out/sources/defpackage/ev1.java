package defpackage;

import android.content.res.Resources;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ev1 {
    public static float a(Resources resources, int i) {
        return resources.getFloat(i);
    }

    public static void b(Resources.Theme theme) {
        theme.rebase();
    }
}
