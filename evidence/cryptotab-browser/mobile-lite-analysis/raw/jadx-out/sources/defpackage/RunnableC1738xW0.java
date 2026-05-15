package defpackage;

/* JADX INFO: renamed from: xW0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1738xW0 implements Runnable {
    public final /* synthetic */ boolean t;
    public final /* synthetic */ RunnableC1851zW0 u;
    public final /* synthetic */ RunnableC1792yW0 v;
    public final /* synthetic */ AW0 w;

    public RunnableC1738xW0(AW0 aw0, boolean z, RunnableC1851zW0 runnableC1851zW0, RunnableC1792yW0 runnableC1792yW0) {
        this.w = aw0;
        this.t = z;
        this.u = runnableC1851zW0;
        this.v = runnableC1792yW0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AW0 aw0 = this.w;
        if (aw0.b) {
            return;
        }
        if (!this.t) {
            Lm lmB = aw0.d.b();
            int iE = Lm.e(aw0.a);
            lmB.getClass();
            Lm.a(iE, "Android.BackgroundTaskScheduler.TaskLoadedNative");
        }
        BW0 bw0 = aw0.d;
        boolean z = aw0.c;
        bw0.a(this.v, this.u, z);
    }
}
