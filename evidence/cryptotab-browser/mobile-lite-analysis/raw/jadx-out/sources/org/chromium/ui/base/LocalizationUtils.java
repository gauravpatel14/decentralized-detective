package org.chromium.ui.base;

import defpackage.AbstractC1499tM;
import defpackage.C1233oj2;
import java.util.Locale;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class LocalizationUtils {
    public static String getDisplayNameForLocale(Locale locale, Locale locale2) {
        return locale.getDisplayName(locale2);
    }

    public static Locale getJavaLocale(String str, String str2, String str3) {
        return new Locale(str, str2, str3);
    }

    public static boolean isLayoutRtl() {
        return AbstractC1499tM.a.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static boolean shouldMirrorBackForwardGestures() {
        if (C1233oj2.b.f("MirrorBackForwardGesturesInRTL")) {
            return isLayoutRtl();
        }
        return false;
    }
}
