package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DB2 implements Runnable {
    public final /* synthetic */ String t;
    public final /* synthetic */ long u;
    public final /* synthetic */ AK2 v;

    public DB2(AK2 ak2, String str, long j) {
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
        boolean zIsEmpty = gfVar.isEmpty();
        long j = this.u;
        if (zIsEmpty) {
            ak2.d = j;
        }
        Integer num = (Integer) gfVar.get(str);
        if (num != null) {
            gfVar.put(str, Integer.valueOf(num.intValue() + 1));
            return;
        }
        if (gfVar.v >= 100) {
            WO2 wo2 = ak2.a.i;
            C1391rR2.k(wo2);
            wo2.i.a("Too many ads visible");
        } else {
            gfVar.put(str, 1);
            ak2.b.put(str, Long.valueOf(j));
        }
    }
}
