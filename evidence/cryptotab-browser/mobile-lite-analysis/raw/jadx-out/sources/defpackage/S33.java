package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class S33 extends P23 {
    public final /* synthetic */ C0562eD2 u;

    public S33(C0562eD2 c0562eD2) {
        this.u = c0562eD2;
    }

    @Override // defpackage.P23
    public final void a() {
        C0562eD2 c0562eD2 = this.u;
        if (c0562eD2.l != null) {
            c0562eD2.b.c("Unbind from service.", new Object[0]);
            c0562eD2.a.unbindService(c0562eD2.k);
            c0562eD2.g = false;
            c0562eD2.l = null;
            c0562eD2.k = null;
        }
        c0562eD2.e();
    }
}
