package org.chromium.ui.accessibility;

import android.os.Build;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityAutofillHelper {
    public static boolean shouldExposePasswordText() {
        if (Build.VERSION.SDK_INT < 28 ? false : !AccessibilityState.d()) {
            return true;
        }
        if (!AccessibilityState.k) {
            AccessibilityState.k();
        }
        return AccessibilityState.j.g;
    }

    public static boolean shouldRespectDisplayedPasswordText() {
        return !(Build.VERSION.SDK_INT < 28 ? false : !AccessibilityState.d());
    }
}
