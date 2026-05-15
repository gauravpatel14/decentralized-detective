package defpackage;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FV2 {
    public final BV2 a;

    public FV2(BV2 bv2) {
        Charset charset = NW2.a;
        this.a = bv2;
        bv2.a = this;
    }

    public final void a(int i, int i2) {
        int i3 = (i2 >> 31) ^ (i2 + i2);
        BV2 bv2 = this.a;
        bv2.l(i << 3);
        bv2.l(i3);
    }

    public final void b(int i, long j) {
        this.a.m(i, (j >> 63) ^ (j + j));
    }

    public final void c(int i, int i2) {
        BV2 bv2 = this.a;
        bv2.l(i << 3);
        bv2.l(i2);
    }

    public final void d(int i, long j) {
        this.a.m(i, j);
    }

    public final void e(int i, boolean z) {
        BV2 bv2 = this.a;
        bv2.l(i << 3);
        bv2.c(z ? (byte) 1 : (byte) 0);
    }

    public final void f(int i, WU2 wu2) {
        this.a.e(i, wu2);
    }

    public final void g(int i, double d) {
        this.a.h(i, Double.doubleToRawLongBits(d));
    }

    public final void h(int i, int i2) {
        BV2 bv2 = this.a;
        bv2.l(i << 3);
        if (i2 >= 0) {
            bv2.l(i2);
        } else {
            bv2.n(i2);
        }
    }

    public final void i(int i, int i2) {
        this.a.f(i, i2);
    }

    public final void j(int i, long j) {
        this.a.h(i, j);
    }

    public final void k(int i, float f) {
        this.a.f(i, Float.floatToRawIntBits(f));
    }

    public final void l(int i, Object obj, InterfaceC0784hY2 interfaceC0784hY2) {
        BV2 bv2 = this.a;
        bv2.k(i, 3);
        interfaceC0784hY2.e((CU2) obj, bv2.a);
        bv2.k(i, 4);
    }

    public final void m(int i, int i2) {
        BV2 bv2 = this.a;
        bv2.l(i << 3);
        if (i2 >= 0) {
            bv2.l(i2);
        } else {
            bv2.n(i2);
        }
    }

    public final void n(int i, long j) {
        this.a.m(i, j);
    }

    public final void o(int i, Object obj, InterfaceC0784hY2 interfaceC0784hY2) {
        CU2 cu2 = (CU2) obj;
        BV2 bv2 = this.a;
        bv2.l((i << 3) | 2);
        AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) cu2;
        int iC = abstractC1852zW2.zzd;
        if (iC == -1) {
            iC = interfaceC0784hY2.c(cu2);
            abstractC1852zW2.zzd = iC;
        }
        bv2.l(iC);
        interfaceC0784hY2.e(cu2, bv2.a);
    }

    public final void p(int i, int i2) {
        this.a.f(i, i2);
    }

    public final void q(int i, long j) {
        this.a.h(i, j);
    }
}
