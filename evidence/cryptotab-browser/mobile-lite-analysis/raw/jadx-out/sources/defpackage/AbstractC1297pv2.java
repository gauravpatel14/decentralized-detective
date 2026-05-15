package defpackage;

import android.view.View;
import android.view.Window;

/* JADX INFO: renamed from: pv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1297pv2 {
    public static void a(Window window, boolean z) {
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 256);
        window.setDecorFitsSystemWindows(z);
    }

    public static void b(Window window, boolean z) {
        window.setDecorFitsSystemWindows(z);
    }
}
