package defpackage;

import android.view.WindowInsets;

/* JADX INFO: renamed from: Wv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0278Wv2 extends C0263Vv2 {
    public bx0 n;
    public bx0 o;
    public bx0 p;

    public C0278Wv2(C0383aw2 c0383aw2, WindowInsets windowInsets) {
        super(c0383aw2, windowInsets);
        this.n = null;
        this.o = null;
        this.p = null;
    }

    @Override // defpackage.C0307Yv2
    public final bx0 g() {
        if (this.o == null) {
            this.o = bx0.c(this.c.getMandatorySystemGestureInsets());
        }
        return this.o;
    }

    @Override // defpackage.C0307Yv2
    public final bx0 i() {
        if (this.n == null) {
            this.n = bx0.c(this.c.getSystemGestureInsets());
        }
        return this.n;
    }

    @Override // defpackage.C0307Yv2
    public final bx0 k() {
        if (this.p == null) {
            this.p = bx0.c(this.c.getTappableElementInsets());
        }
        return this.p;
    }

    @Override // defpackage.C0241Tv2, defpackage.C0307Yv2
    public final C0383aw2 l(int i, int i2, int i3, int i4) {
        return C0383aw2.g(null, this.c.inset(i, i2, i3, i4));
    }

    @Override // defpackage.C0241Tv2, defpackage.C0307Yv2
    public final void r(bx0 bx0Var) {
    }
}
