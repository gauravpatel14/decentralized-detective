package defpackage;

/* JADX INFO: renamed from: vM2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRunnableC1610vM2 implements Runnable {
    public final long t;
    public final long u;
    public final boolean v;
    public final /* synthetic */ AN2 w;

    public AbstractRunnableC1610vM2(AN2 an2, boolean z) {
        this.w = an2;
        this.t = an2.a.currentTimeMillis();
        this.u = an2.a.elapsedRealtime();
        this.v = z;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        AN2 an2 = this.w;
        if (an2.e) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e) {
            an2.a(e, false, this.v);
            b();
        }
    }

    public void b() {
    }
}
