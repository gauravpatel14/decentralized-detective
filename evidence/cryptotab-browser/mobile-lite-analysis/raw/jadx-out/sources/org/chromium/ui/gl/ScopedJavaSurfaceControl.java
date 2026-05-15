package org.chromium.ui.gl;

import android.view.SurfaceControl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ScopedJavaSurfaceControl {
    public static void releaseSurfaceControl(SurfaceControl surfaceControl) {
        surfaceControl.release();
    }
}
