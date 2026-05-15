package defpackage;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class K23 {
    public final String a;
    public final boolean b;
    public final C0961kR2 c;
    public final BitSet d;
    public final BitSet e;
    public final gf f;
    public final gf g;
    public final /* synthetic */ C0334aC2 h;

    public K23(C0334aC2 c0334aC2, String str) {
        this.h = c0334aC2;
        this.a = str;
        this.b = true;
        this.d = new BitSet();
        this.e = new BitSet();
        this.f = new gf(0);
        this.g = new gf(0);
    }

    public final OP2 a(int i) {
        ArrayList arrayList;
        List listEmptyList;
        KP2 kp2L = OP2.l();
        if (kp2L.v) {
            kp2L.f();
            kp2L.v = false;
        }
        OP2.n((OP2) kp2L.u, i);
        if (kp2L.v) {
            kp2L.f();
            kp2L.v = false;
        }
        OP2.q((OP2) kp2L.u, this.b);
        C0961kR2 c0961kR2 = this.c;
        if (c0961kR2 != null) {
            if (kp2L.v) {
                kp2L.f();
                kp2L.v = false;
            }
            OP2.p((OP2) kp2L.u, c0961kR2);
        }
        C0840iR2 c0840iR2P = C0961kR2.p();
        ArrayList arrayListU = VX2.u(this.d);
        if (c0840iR2P.v) {
            c0840iR2P.f();
            c0840iR2P.v = false;
        }
        C0961kR2.y((C0961kR2) c0840iR2P.u, arrayListU);
        ArrayList arrayListU2 = VX2.u(this.e);
        if (c0840iR2P.v) {
            c0840iR2P.f();
            c0840iR2P.v = false;
        }
        C0961kR2.w((C0961kR2) c0840iR2P.u, arrayListU2);
        gf gfVar = this.f;
        if (gfVar == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(gfVar.v);
            for (Integer num : (df) gfVar.keySet()) {
                int iIntValue = num.intValue();
                Long l = (Long) gfVar.get(num);
                if (l != null) {
                    RP2 rp2N = XP2.n();
                    if (rp2N.v) {
                        rp2N.f();
                        rp2N.v = false;
                    }
                    XP2.o((XP2) rp2N.u, iIntValue);
                    long jLongValue = l.longValue();
                    if (rp2N.v) {
                        rp2N.f();
                        rp2N.v = false;
                    }
                    XP2.p((XP2) rp2N.u, jLongValue);
                    arrayList2.add((XP2) rp2N.d());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            if (c0840iR2P.v) {
                c0840iR2P.f();
                c0840iR2P.v = false;
            }
            C0961kR2.A((C0961kR2) c0840iR2P.u, arrayList);
        }
        gf gfVar2 = this.g;
        if (gfVar2 == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(gfVar2.v);
            for (Integer num2 : (df) gfVar2.keySet()) {
                nR2 nr2O = C1274pR2.o();
                int iIntValue2 = num2.intValue();
                if (nr2O.v) {
                    nr2O.f();
                    nr2O.v = false;
                }
                C1274pR2.p((C1274pR2) nr2O.u, iIntValue2);
                List list = (List) gfVar2.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    if (nr2O.v) {
                        nr2O.f();
                        nr2O.v = false;
                    }
                    C1274pR2.q((C1274pR2) nr2O.u, list);
                }
                arrayList3.add((C1274pR2) nr2O.d());
            }
            listEmptyList = arrayList3;
        }
        List list2 = listEmptyList;
        if (c0840iR2P.v) {
            c0840iR2P.f();
            c0840iR2P.v = false;
        }
        C0961kR2.D((C0961kR2) c0840iR2P.u, list2);
        if (kp2L.v) {
            kp2L.f();
            kp2L.v = false;
        }
        OP2.o((OP2) kp2L.u, (C0961kR2) c0840iR2P.d());
        return (OP2) kp2L.d();
    }

    public final void b(K33 k33) {
        int iA = k33.a();
        Boolean bool = k33.c;
        if (bool != null) {
            this.e.set(iA, bool.booleanValue());
        }
        Boolean bool2 = k33.d;
        if (bool2 != null) {
            this.d.set(iA, bool2.booleanValue());
        }
        if (k33.e != null) {
            Integer numValueOf = Integer.valueOf(iA);
            gf gfVar = this.f;
            Long l = (Long) gfVar.get(numValueOf);
            long jLongValue = k33.e.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                gfVar.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (k33.f != null) {
            gf gfVar2 = this.g;
            Integer numValueOf2 = Integer.valueOf(iA);
            List arrayList = (List) gfVar2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                gfVar2.put(numValueOf2, arrayList);
            }
            if (k33.c()) {
                arrayList.clear();
            }
            C0327a03.a();
            C0334aC2 c0334aC2 = this.h;
            C1009lD2 c1009lD2 = c0334aC2.a.g;
            C0467cO2 c0467cO2 = AbstractC0579eO2.W;
            String str = this.a;
            if (c1009lD2.p(str, c0467cO2) && k33.b()) {
                arrayList.clear();
            }
            C0327a03.a();
            if (!c0334aC2.a.g.p(str, c0467cO2)) {
                arrayList.add(Long.valueOf(k33.f.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(k33.f.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public K23(C0334aC2 c0334aC2, String str, C0961kR2 c0961kR2, BitSet bitSet, BitSet bitSet2, gf gfVar, gf gfVar2) {
        this.h = c0334aC2;
        this.a = str;
        this.d = bitSet;
        this.e = bitSet2;
        this.f = gfVar;
        this.g = new gf(0);
        for (Integer num : (df) gfVar2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) gfVar2.get(num));
            this.g.put(num, arrayList);
        }
        this.b = false;
        this.c = c0961kR2;
    }
}
