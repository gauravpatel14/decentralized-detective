package defpackage;

import android.window.BackEvent;

/* JADX INFO: renamed from: am, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0375am {
    public final float a;
    public final float b;
    public final float c;
    public final int d;

    public C0375am(BackEvent backEvent) {
        float fC = AbstractC0655fa.c(backEvent);
        float fD = AbstractC0655fa.d(backEvent);
        float fA = AbstractC0655fa.a(backEvent);
        int iB = AbstractC0655fa.b(backEvent);
        this.a = fC;
        this.b = fD;
        this.c = fA;
        this.d = iB;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.a + ", touchY=" + this.b + ", progress=" + this.c + ", swipeEdge=" + this.d + '}';
    }
}
