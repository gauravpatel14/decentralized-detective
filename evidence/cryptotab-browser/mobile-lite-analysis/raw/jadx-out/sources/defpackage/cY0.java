package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class cY0 implements Runnable {
    public final /* synthetic */ long t;
    public final /* synthetic */ fY0 u;

    public cY0(fY0 fy0, long j) {
        this.u = fy0;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.u.b.d.g(this.t);
    }
}
