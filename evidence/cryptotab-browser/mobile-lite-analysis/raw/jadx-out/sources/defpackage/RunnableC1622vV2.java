package defpackage;

/* JADX INFO: renamed from: vV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1622vV2 implements Runnable {
    public final /* synthetic */ TU2 t;
    public final /* synthetic */ long u;
    public final /* synthetic */ C1791yV2 v;

    public RunnableC1622vV2(C1791yV2 c1791yV2, TU2 tu2, long j) {
        this.v = c1791yV2;
        this.t = tu2;
        this.u = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TU2 tu2 = this.t;
        long j = this.u;
        C1791yV2 c1791yV2 = this.v;
        c1791yV2.m(tu2, false, j);
        c1791yV2.e = null;
        CW2 cw2S = c1791yV2.a.s();
        cw2S.g();
        cw2S.h();
        cw2S.s(new HV2(cw2S, null));
    }
}
