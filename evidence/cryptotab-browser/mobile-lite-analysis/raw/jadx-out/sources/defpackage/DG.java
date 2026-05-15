package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DG {
    public final CG a;

    public DG(CG cg) {
        gz0.a(cg, "output");
        this.a = cg;
        cg.a = this;
    }

    public final void a(int i, boolean z) {
        this.a.A(i, z);
    }

    public final void b(int i, C0199Qv c0199Qv) {
        this.a.C(i, c0199Qv);
    }

    public final void c(int i, double d) {
        CG cg = this.a;
        cg.getClass();
        cg.G(i, Double.doubleToRawLongBits(d));
    }

    public final void d(int i, int i2) {
        this.a.I(i, i2);
    }

    public final void e(int i, int i2) {
        this.a.E(i, i2);
    }

    public final void f(int i, long j) {
        this.a.G(i, j);
    }

    public final void g(int i, float f) {
        CG cg = this.a;
        cg.getClass();
        cg.E(i, Float.floatToRawIntBits(f));
    }

    public final void h(int i, Object obj, Cz1 cz1) {
        CG cg = this.a;
        cg.O(i, 3);
        cz1.a((InterfaceC1787yS0) obj, cg.a);
        cg.O(i, 4);
    }

    public final void i(int i, int i2) {
        this.a.I(i, i2);
    }

    public final void j(int i, long j) {
        this.a.R(i, j);
    }

    public final void k(int i, Object obj, Cz1 cz1) {
        this.a.K(i, (InterfaceC1787yS0) obj, cz1);
    }

    public final void l(int i, int i2) {
        this.a.E(i, i2);
    }

    public final void m(int i, long j) {
        this.a.G(i, j);
    }

    public final void n(int i, int i2) {
        this.a.P(i, (i2 >> 31) ^ (i2 << 1));
    }

    public final void o(int i, long j) {
        this.a.R(i, (j >> 63) ^ (j << 1));
    }

    public final void p(int i, int i2) {
        this.a.P(i, i2);
    }

    public final void q(int i, long j) {
        this.a.R(i, j);
    }
}
