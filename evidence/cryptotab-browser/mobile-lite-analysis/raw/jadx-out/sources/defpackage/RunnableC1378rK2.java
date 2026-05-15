package defpackage;

/* JADX INFO: renamed from: rK2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1378rK2 implements Runnable {
    public final /* synthetic */ OJ2 t;
    public final /* synthetic */ int u;

    public RunnableC1378rK2(OJ2 oj2, int i) {
        this.t = oj2;
        this.u = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OJ2 oj2 = this.t;
        oj2.v.b(this.u);
    }
}
