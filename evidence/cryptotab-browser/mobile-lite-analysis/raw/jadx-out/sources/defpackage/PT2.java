package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PT2 implements Runnable {
    public final /* synthetic */ G62 t;
    public final /* synthetic */ C0585eV2 u;

    public PT2(C0585eV2 c0585eV2, G62 g62) {
        this.u = c0585eV2;
        this.t = g62;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.u.b) {
            try {
                N41 n41 = this.u.c;
                if (n41 != null) {
                    n41.onComplete(this.t);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
