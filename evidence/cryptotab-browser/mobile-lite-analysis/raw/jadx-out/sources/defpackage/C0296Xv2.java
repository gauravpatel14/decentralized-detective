package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: renamed from: Xv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0296Xv2 extends C0278Wv2 {
    public static final C0383aw2 q = C0383aw2.g(null, WindowInsets.CONSUMED);

    @Override // defpackage.C0241Tv2, defpackage.C0307Yv2
    public final bx0 f(int i) {
        return bx0.c(this.c.getInsets(AbstractC0322Zv2.a(i)));
    }

    @Override // defpackage.C0241Tv2, defpackage.C0307Yv2
    public final boolean o(int i) {
        return this.c.isVisible(AbstractC0322Zv2.a(i));
    }

    @Override // defpackage.C0241Tv2, defpackage.C0307Yv2
    public final void d(View view) {
    }
}
