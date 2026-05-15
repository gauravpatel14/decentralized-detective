package defpackage;

/* JADX INFO: renamed from: a33, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0330a33 implements Runnable {
    public final /* synthetic */ IB2 t;
    public final /* synthetic */ int u;
    public final /* synthetic */ int v;
    public final /* synthetic */ C1189o33 w;

    public RunnableC0330a33(C1189o33 c1189o33, IB2 ib2, int i, int i2) {
        this.w = c1189o33;
        this.t = ib2;
        this.u = i;
        this.v = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IB2 ib2 = this.t;
        this.w.c(new IB2(ib2.a, this.u, this.v, ib2.d, ib2.e, ib2.f, ib2.g, ib2.h, ib2.i));
    }
}
