package defpackage;

import android.view.WindowInsets;

/* JADX INFO: renamed from: Pv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0192Pv2 extends AbstractC0228Sv2 {
    public final WindowInsets.Builder c;

    public C0192Pv2() {
        this.c = AbstractC0181Ov2.b();
    }

    @Override // defpackage.AbstractC0228Sv2
    public final C0383aw2 b() {
        a();
        C0383aw2 c0383aw2G = C0383aw2.g(null, this.c.build());
        c0383aw2G.a.p(this.b);
        return c0383aw2G;
    }

    @Override // defpackage.AbstractC0228Sv2
    public final void d(bx0 bx0Var) {
        this.c.setMandatorySystemGestureInsets(bx0Var.d());
    }

    @Override // defpackage.AbstractC0228Sv2
    public final void e(bx0 bx0Var) {
        this.c.setStableInsets(bx0Var.d());
    }

    @Override // defpackage.AbstractC0228Sv2
    public final void f(bx0 bx0Var) {
        this.c.setSystemGestureInsets(bx0Var.d());
    }

    @Override // defpackage.AbstractC0228Sv2
    public final void g(bx0 bx0Var) {
        this.c.setSystemWindowInsets(bx0Var.d());
    }

    @Override // defpackage.AbstractC0228Sv2
    public final void h(bx0 bx0Var) {
        this.c.setTappableElementInsets(bx0Var.d());
    }

    public C0192Pv2(C0383aw2 c0383aw2) {
        WindowInsets.Builder builderB;
        super(c0383aw2);
        WindowInsets windowInsetsF = c0383aw2.f();
        if (windowInsetsF != null) {
            builderB = AbstractC0181Ov2.c(windowInsetsF);
        } else {
            builderB = AbstractC0181Ov2.b();
        }
        this.c = builderB;
    }
}
