package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DT2 implements Runnable {
    public final /* synthetic */ long t;
    public final /* synthetic */ IU2 u;

    public DT2(IU2 iu2, long j) {
        this.u = iu2;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IU2 iu2 = this.u;
        TP2 tp2 = iu2.a.h;
        C1391rR2.i(tp2);
        FP2 fp2 = tp2.j;
        long j = this.t;
        fp2.b(j);
        WO2 wo2 = iu2.a.i;
        C1391rR2.k(wo2);
        wo2.m.b(Long.valueOf(j), "Session timeout duration set");
    }
}
