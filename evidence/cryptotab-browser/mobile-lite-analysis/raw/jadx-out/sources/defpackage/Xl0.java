package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Xl0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Yl0 u;
    public final /* synthetic */ int v;

    public /* synthetic */ Xl0(Yl0 yl0, int i, int i2) {
        this.t = i2;
        this.u = yl0;
        this.v = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                C0838iP0 c0838iP0 = this.u.f.c.c;
                if (c0838iP0 != null) {
                    c0838iP0.h(this.v);
                }
                break;
            default:
                C0838iP0 c0838iP02 = this.u.f.c.c;
                if (c0838iP02 != null) {
                    c0838iP02.i(this.v);
                }
                break;
        }
    }
}
