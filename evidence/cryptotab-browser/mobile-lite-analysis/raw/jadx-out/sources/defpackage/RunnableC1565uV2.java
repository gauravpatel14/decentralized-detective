package defpackage;

/* JADX INFO: renamed from: uV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1565uV2 implements Runnable {
    public final /* synthetic */ long t;
    public final /* synthetic */ C1791yV2 u;

    public RunnableC1565uV2(C1791yV2 c1791yV2, long j) {
        this.u = c1791yV2;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1791yV2 c1791yV2 = this.u;
        c1791yV2.a.m().j(this.t);
        c1791yV2.e = null;
    }
}
