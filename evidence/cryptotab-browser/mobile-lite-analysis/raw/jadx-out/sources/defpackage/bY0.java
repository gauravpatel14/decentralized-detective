package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bY0 implements Runnable {
    public final /* synthetic */ long t;
    public final /* synthetic */ int u;
    public final /* synthetic */ fY0 v;

    public bY0(fY0 fy0, long j, int i) {
        this.v = fy0;
        this.t = j;
        this.u = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.v.b.d.b(this.u, this.t);
    }
}
