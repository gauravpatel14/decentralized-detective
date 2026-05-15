package defpackage;

import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OH2 {
    public final DH2 a;

    public OH2(DH2 dh2) {
        Charset charset = WK2.a;
        this.a = dh2;
        dh2.a = this;
    }

    public final void a(int i, int i2) {
        this.a.l(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void b(int i, long j) {
        this.a.n(i, (j >> 63) ^ (j + j));
    }

    public final void c(int i, List list) {
        boolean z = list instanceof JL2;
        int i2 = 0;
        DH2 dh2 = this.a;
        if (!z) {
            while (i2 < list.size()) {
                dh2.j(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        JL2 jl2 = (JL2) list;
        while (i2 < list.size()) {
            Object objD = jl2.d(i2);
            if (objD instanceof String) {
                dh2.j(i, (String) objD);
            } else {
                dh2.c(i, (C0519dH2) objD);
            }
            i2++;
        }
    }

    public final void d(int i, int i2) {
        this.a.l(i, i2);
    }

    public final void e(int i, long j) {
        this.a.n(i, j);
    }

    public final void f(int i, boolean z) {
        DH2 dh2 = this.a;
        dh2.m(i << 3);
        dh2.a(z ? (byte) 1 : (byte) 0);
    }

    public final void g(int i, C0519dH2 c0519dH2) {
        this.a.c(i, c0519dH2);
    }

    public final void h(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.c(i, (C0519dH2) list.get(i2));
        }
    }

    public final void i(int i, double d) {
        this.a.f(i, Double.doubleToRawLongBits(d));
    }

    public final void j(int i, int i2) {
        this.a.h(i, i2);
    }

    public final void k(int i, int i2) {
        this.a.d(i, i2);
    }

    public final void l(int i, long j) {
        this.a.f(i, j);
    }

    public final void m(int i, float f) {
        this.a.d(i, Float.floatToRawIntBits(f));
    }

    public final void n(int i, Object obj, InterfaceC0773hO2 interfaceC0773hO2) {
        DH2 dh2 = this.a;
        dh2.k(i, 3);
        interfaceC0773hO2.h((AbstractC0948kF2) obj, dh2.a);
        dh2.k(i, 4);
    }

    public final void o(int i, int i2) {
        this.a.h(i, i2);
    }

    public final void p(int i, long j) {
        this.a.n(i, j);
    }

    public final void q(int i, Object obj, InterfaceC0773hO2 interfaceC0773hO2) {
        AbstractC0948kF2 abstractC0948kF2 = (AbstractC0948kF2) obj;
        DH2 dh2 = this.a;
        dh2.m((i << 3) | 2);
        dh2.m(abstractC0948kF2.a(interfaceC0773hO2));
        interfaceC0773hO2.h(abstractC0948kF2, dh2.a);
    }

    public final void r(int i, int i2) {
        this.a.d(i, i2);
    }

    public final void s(int i, long j) {
        this.a.f(i, j);
    }
}
