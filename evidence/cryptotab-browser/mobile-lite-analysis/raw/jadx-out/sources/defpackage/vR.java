package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class vR {
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Integer d;

    public vR(Integer num, Integer num2, Integer num3, Integer num4) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
    }

    public static vR a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(0);
        }
        return new vR((Integer) bundle.get("android.support.customtabs.extra.TOOLBAR_COLOR"), (Integer) bundle.get("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR"), (Integer) bundle.get("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR"), (Integer) bundle.get("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR"));
    }
}
