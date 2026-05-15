package defpackage;

/* JADX INFO: renamed from: pE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1258pE2 implements Runnable {
    public final /* synthetic */ WS2 t;
    public final /* synthetic */ AbstractC1546uE2 u;

    public RunnableC1258pE2(AbstractC1546uE2 abstractC1546uE2, WS2 ws2) {
        this.u = abstractC1546uE2;
        this.t = ws2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.f();
        if (C1070mC2.a()) {
            this.t.b().o(this);
            return;
        }
        boolean z = this.u.c != 0;
        this.u.c = 0L;
        if (z) {
            this.u.b();
        }
    }
}
