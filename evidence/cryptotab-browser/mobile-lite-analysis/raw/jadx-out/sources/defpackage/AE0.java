package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AE0 implements InterfaceC0564eF0 {
    public final /* synthetic */ AbstractC0514dF0 t;
    public final /* synthetic */ tz1 u;

    public AE0(AbstractC0514dF0 abstractC0514dF0, tz1 tz1Var) {
        this.t = abstractC0514dF0;
        this.u = tz1Var;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        if (bf0 == bF0.ON_START) {
            this.t.b(this);
            this.u.d();
        }
    }
}
