package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XU2 implements Runnable {
    public final /* synthetic */ TU2 t;
    public final /* synthetic */ TU2 u;
    public final /* synthetic */ long v;
    public final /* synthetic */ boolean w;
    public final /* synthetic */ C1791yV2 x;

    public XU2(C1791yV2 c1791yV2, TU2 tu2, TU2 tu22, long j, boolean z) {
        this.x = c1791yV2;
        this.t = tu2;
        this.u = tu22;
        this.v = j;
        this.w = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.x.l(this.t, this.u, this.v, this.w, null);
    }
}
