package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AF2 implements Runnable {
    public final /* synthetic */ String t;
    public final /* synthetic */ long u;
    public final /* synthetic */ AK2 v;

    public AF2(AK2 ak2, String str, long j) {
        this.v = ak2;
        this.t = str;
        this.u = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AK2 ak2 = this.v;
        ak2.g();
        String str = this.t;
        Preconditions.checkNotEmpty(str);
        gf gfVar = ak2.c;
        Integer num = (Integer) gfVar.get(str);
        C1391rR2 c1391rR2 = ak2.a;
        if (num == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.b(str, "Call to endAdUnitExposure for unknown ad unit id");
            return;
        }
        C1791yV2 c1791yV2 = c1391rR2.o;
        C1391rR2.j(c1791yV2);
        TU2 tu2N = c1791yV2.n(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            gfVar.put(str, Integer.valueOf(iIntValue));
            return;
        }
        gfVar.remove(str);
        gf gfVar2 = ak2.b;
        Long l = (Long) gfVar2.get(str);
        long j = this.u;
        WO2 wo22 = c1391rR2.i;
        if (l == null) {
            C1391rR2.k(wo22);
            wo22.f.a("First ad unit exposure time was never set");
        } else {
            long jLongValue = l.longValue();
            gfVar2.remove(str);
            ak2.l(str, j - jLongValue, tu2N);
        }
        if (gfVar.isEmpty()) {
            long j2 = ak2.d;
            if (j2 == 0) {
                C1391rR2.k(wo22);
                wo22.f.a("First ad exposure time was never set");
            } else {
                ak2.k(j - j2, tu2N);
                ak2.d = 0L;
            }
        }
    }
}
