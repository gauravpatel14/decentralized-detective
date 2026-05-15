package org.chromium.ui.gfx;

import android.provider.Settings;
import defpackage.AbstractC1499tM;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Animation {
    public static boolean prefersReducedMotion() {
        return ((double) Settings.Global.getFloat(AbstractC1499tM.a.getContentResolver(), "animator_duration_scale", 1.0f)) == 0.0d;
    }
}
