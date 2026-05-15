package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class sK2 implements Runnable {
    public final /* synthetic */ OJ2 t;
    public final /* synthetic */ String u;
    public final /* synthetic */ String v;

    public sK2(OJ2 oj2, String str, String str2) {
        this.t = oj2;
        this.u = str;
        this.v = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        xy xyVar;
        synchronized (this.t.w) {
            xyVar = (xy) this.t.w.get(this.u);
        }
        if (xyVar != null) {
            xyVar.a(this.t.u, this.u, this.v);
        } else {
            OJ2.Q.getClass();
        }
    }
}
