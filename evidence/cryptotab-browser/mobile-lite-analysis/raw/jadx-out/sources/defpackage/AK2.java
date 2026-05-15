package defpackage;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AK2 extends YM2 {
    public final gf b;
    public final gf c;
    public long d;

    public AK2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.c = new gf(0);
        this.b = new gf(0);
    }

    public final void h(long j, String str) {
        C1391rR2 c1391rR2 = this.a;
        if (str == null || str.length() == 0) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.a("Ad unit id must be a non-empty string");
        } else {
            C0899jR2 c0899jR2 = c1391rR2.j;
            C1391rR2.k(c0899jR2);
            c0899jR2.o(new DB2(this, str, j));
        }
    }

    public final void i(long j, String str) {
        C1391rR2 c1391rR2 = this.a;
        if (str == null || str.length() == 0) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.a("Ad unit id must be a non-empty string");
        } else {
            C0899jR2 c0899jR2 = c1391rR2.j;
            C1391rR2.k(c0899jR2);
            c0899jR2.o(new AF2(this, str, j));
        }
    }

    public final void j(long j) {
        C1791yV2 c1791yV2 = this.a.o;
        C1391rR2.j(c1791yV2);
        TU2 tu2N = c1791yV2.n(false);
        gf gfVar = this.b;
        for (String str : (df) gfVar.keySet()) {
            l(str, j - ((Long) gfVar.get(str)).longValue(), tu2N);
        }
        if (!gfVar.isEmpty()) {
            k(j - this.d, tu2N);
        }
        m(j);
    }

    public final void k(long j, TU2 tu2) {
        C1391rR2 c1391rR2 = this.a;
        if (tu2 == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.a("Not logging ad exposure. No active activity");
        } else {
            if (j < 1000) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.n.b(Long.valueOf(j), "Not logging ad exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            C0653fY2.s(tu2, bundle, true);
            IU2 iu2 = c1391rR2.p;
            C1391rR2.j(iu2);
            iu2.n("am", "_xa", bundle);
        }
    }

    public final void l(String str, long j, TU2 tu2) {
        C1391rR2 c1391rR2 = this.a;
        if (tu2 == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.a("Not logging ad unit exposure. No active activity");
        } else {
            if (j < 1000) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.n.b(Long.valueOf(j), "Not logging ad unit exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            C0653fY2.s(tu2, bundle, true);
            IU2 iu2 = c1391rR2.p;
            C1391rR2.j(iu2);
            iu2.n("am", "_xu", bundle);
        }
    }

    public final void m(long j) {
        gf gfVar = this.b;
        Iterator it = ((df) gfVar.keySet()).iterator();
        while (it.hasNext()) {
            gfVar.put((String) it.next(), Long.valueOf(j));
        }
        if (gfVar.isEmpty()) {
            return;
        }
        this.d = j;
    }
}
