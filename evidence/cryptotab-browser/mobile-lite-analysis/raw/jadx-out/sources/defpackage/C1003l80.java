package defpackage;

/* JADX INFO: renamed from: l80, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1003l80 extends m80 {
    public final RunnableC0853ia2 v;

    public C1003l80(long j, RunnableC0853ia2 runnableC0853ia2) {
        this.t = j;
        this.u = -1;
        this.v = runnableC0853ia2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.v.run();
    }

    @Override // defpackage.m80
    public final String toString() {
        return super.toString() + this.v;
    }
}
