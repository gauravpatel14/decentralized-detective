package defpackage;

/* JADX INFO: renamed from: mw, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1115mw implements Runnable {
    public final /* synthetic */ AbstractC1701wu1 t;
    public final /* synthetic */ C1176nw u;

    public RunnableC1115mw(C1176nw c1176nw, AbstractC1701wu1 abstractC1701wu1) {
        this.u = c1176nw;
        this.t = abstractC1701wu1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.u.u.put(this.t);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
