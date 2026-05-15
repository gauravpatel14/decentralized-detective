package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class G41 implements InterfaceC0564eF0, vx {
    public final AbstractC0514dF0 t;
    public final AbstractC1815z41 u;
    public H41 v;
    public final /* synthetic */ J41 w;

    public G41(J41 j41, AbstractC0514dF0 abstractC0514dF0, AbstractC1815z41 abstractC1815z41) {
        this.w = j41;
        this.t = abstractC0514dF0;
        this.u = abstractC1815z41;
        abstractC0514dF0.a(this);
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        if (bf0 == bF0.ON_START) {
            this.v = this.w.b(this.u);
            return;
        }
        if (bf0 != bF0.ON_STOP) {
            if (bf0 == bF0.ON_DESTROY) {
                cancel();
            }
        } else {
            H41 h41 = this.v;
            if (h41 != null) {
                h41.cancel();
            }
        }
    }

    @Override // defpackage.vx
    public final void cancel() {
        this.t.b(this);
        this.u.b.remove(this);
        H41 h41 = this.v;
        if (h41 != null) {
            h41.cancel();
        }
        this.v = null;
    }
}
