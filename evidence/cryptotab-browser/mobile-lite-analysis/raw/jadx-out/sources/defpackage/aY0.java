package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class aY0 implements Runnable {
    public final /* synthetic */ long t;
    public final /* synthetic */ int u;
    public final /* synthetic */ boolean v;
    public final /* synthetic */ fY0 w;

    public aY0(fY0 fy0, long j, int i, boolean z) {
        this.w = fy0;
        this.t = j;
        this.u = i;
        this.v = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        fY0 fy0 = this.w;
        hY0 hy0 = fy0.b.d;
        long j = this.t;
        int i = this.u;
        hy0.b(i, j);
        if (this.v) {
            fy0.b.d.a(i);
            fy0.b.d.e(new long[]{j});
        }
    }
}
