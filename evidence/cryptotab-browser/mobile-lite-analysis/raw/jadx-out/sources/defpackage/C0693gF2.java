package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: gF2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0693gF2 {
    public final HashMap a = new HashMap();
    public final QG2 b = new QG2();

    public C0693gF2() {
        YE2 ye2 = new YE2();
        ArrayList arrayList = ye2.a;
        arrayList.add(VG2.y);
        arrayList.add(VG2.z);
        arrayList.add(VG2.A);
        arrayList.add(VG2.B);
        arrayList.add(VG2.C);
        arrayList.add(VG2.D);
        arrayList.add(VG2.E);
        b(ye2);
        C0887jF2 c0887jF2 = new C0887jF2();
        ArrayList arrayList2 = c0887jF2.a;
        arrayList2.add(VG2.P);
        arrayList2.add(VG2.c0);
        arrayList2.add(VG2.d0);
        arrayList2.add(VG2.e0);
        arrayList2.add(VG2.f0);
        arrayList2.add(VG2.h0);
        arrayList2.add(VG2.i0);
        arrayList2.add(VG2.n0);
        b(c0887jF2);
        C1197oF2 c1197oF2 = new C1197oF2();
        ArrayList arrayList3 = c1197oF2.a;
        arrayList3.add(VG2.w);
        arrayList3.add(VG2.F);
        arrayList3.add(VG2.G);
        arrayList3.add(VG2.H);
        arrayList3.add(VG2.M);
        arrayList3.add(VG2.f5J);
        arrayList3.add(VG2.N);
        arrayList3.add(VG2.R);
        arrayList3.add(VG2.g0);
        arrayList3.add(VG2.s0);
        arrayList3.add(VG2.v0);
        arrayList3.add(VG2.y0);
        arrayList3.add(VG2.z0);
        b(c1197oF2);
        C0567eG2 c0567eG2 = new C0567eG2();
        ArrayList arrayList4 = c0567eG2.a;
        arrayList4.add(VG2.v);
        arrayList4.add(VG2.m0);
        arrayList4.add(VG2.p0);
        b(c0567eG2);
        HG2 hg2 = new HG2();
        ArrayList arrayList5 = hg2.a;
        arrayList5.add(VG2.S);
        arrayList5.add(VG2.T);
        arrayList5.add(VG2.U);
        arrayList5.add(VG2.V);
        arrayList5.add(VG2.W);
        arrayList5.add(VG2.X);
        arrayList5.add(VG2.Y);
        arrayList5.add(VG2.D0);
        b(hg2);
        MG2 mg2 = new MG2();
        ArrayList arrayList6 = mg2.a;
        arrayList6.add(VG2.u);
        arrayList6.add(VG2.O);
        arrayList6.add(VG2.j0);
        arrayList6.add(VG2.k0);
        arrayList6.add(VG2.l0);
        arrayList6.add(VG2.q0);
        arrayList6.add(VG2.r0);
        arrayList6.add(VG2.t0);
        arrayList6.add(VG2.u0);
        arrayList6.add(VG2.x0);
        b(mg2);
        RG2 rg2 = new RG2();
        ArrayList arrayList7 = rg2.a;
        arrayList7.add(VG2.x);
        arrayList7.add(VG2.I);
        arrayList7.add(VG2.K);
        arrayList7.add(VG2.L);
        arrayList7.add(VG2.Q);
        arrayList7.add(VG2.Z);
        arrayList7.add(VG2.a0);
        arrayList7.add(VG2.b0);
        arrayList7.add(VG2.o0);
        arrayList7.add(VG2.w0);
        arrayList7.add(VG2.A0);
        arrayList7.add(VG2.B0);
        arrayList7.add(VG2.C0);
        b(rg2);
    }

    public final InterfaceC1601vE2 a(IQ2 iq2, InterfaceC1601vE2 interfaceC1601vE2) {
        DS2.c(iq2);
        if (!(interfaceC1601vE2 instanceof C1717xE2)) {
            return interfaceC1601vE2;
        }
        C1717xE2 c1717xE2 = (C1717xE2) interfaceC1601vE2;
        ArrayList arrayList = c1717xE2.u;
        HashMap map = this.a;
        String str = c1717xE2.t;
        return (map.containsKey(str) ? (AbstractC0515dF2) map.get(str) : this.b).a(str, iq2, arrayList);
    }

    public final void b(AbstractC0515dF2 abstractC0515dF2) {
        Iterator it = abstractC0515dF2.a.iterator();
        while (it.hasNext()) {
            this.a.put(Integer.valueOf(((VG2) it.next()).t).toString(), abstractC0515dF2);
        }
    }
}
