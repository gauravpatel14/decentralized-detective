package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Zw implements Xw, Runnable {
    public Runnable t;
    public final /* synthetic */ C0384ax u;

    public Zw(C0384ax c0384ax, Runnable runnable) {
        this.u = c0384ax;
        this.t = runnable;
    }

    @Override // defpackage.Xw
    public final void cancel() {
        this.t = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.u) {
            try {
                Runnable runnable = this.t;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
