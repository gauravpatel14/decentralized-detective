package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class QW2 implements Runnable {
    public final /* synthetic */ long t;
    public final /* synthetic */ C0420bX2 u;

    public QW2(C0420bX2 c0420bX2, long j) {
        this.u = c0420bX2;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0420bX2 c0420bX2 = this.u;
        c0420bX2.g();
        c0420bX2.k();
        C1391rR2 c1391rR2 = c0420bX2.a;
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        long j = this.t;
        wo2.n.b(Long.valueOf(j), "Activity paused, time");
        UW2 uw2 = c0420bX2.f;
        C0420bX2 c0420bX22 = uw2.b;
        TW2 tw2 = new TW2(uw2, c0420bX22.a.n.currentTimeMillis(), j);
        uw2.a = tw2;
        c0420bX22.c.postDelayed(tw2, 2000L);
        if (c1391rR2.g.r()) {
            c0420bX2.e.c.a();
        }
    }
}
