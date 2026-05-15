package defpackage;

/* JADX INFO: renamed from: kY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0971kY2 implements Runnable {
    public final /* synthetic */ G62 t;
    public final /* synthetic */ RY2 u;

    public RunnableC0971kY2(RY2 ry2, G62 g62) {
        this.u = ry2;
        this.t = g62;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.u.b) {
            try {
                U41 u41 = this.u.c;
                if (u41 != null) {
                    u41.a(this.t.h());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
