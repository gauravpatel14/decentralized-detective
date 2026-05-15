package org.chromium.ui.base;

import android.content.Context;
import defpackage.AbstractC0163Np1;
import defpackage.AbstractC1499tM;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DeviceFormFactor {
    public static boolean a(Context context) {
        return context.getResources().getInteger(AbstractC0163Np1.min_screen_width_bucket) >= 2;
    }

    public static boolean b(WindowAndroid windowAndroid) {
        Context context = (Context) windowAndroid.z.get();
        return (context == null ? 0 : context.getResources().getInteger(AbstractC0163Np1.min_screen_width_bucket)) >= 2;
    }

    @Deprecated
    public static boolean isTablet() {
        return AbstractC1499tM.a.getResources().getInteger(AbstractC0163Np1.min_screen_width_bucket) >= 2;
    }
}
