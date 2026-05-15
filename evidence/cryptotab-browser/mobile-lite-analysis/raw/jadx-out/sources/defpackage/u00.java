package defpackage;

import android.view.DisplayCutout;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u00 {
    public static int a(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int b(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int c(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int d(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }
}
