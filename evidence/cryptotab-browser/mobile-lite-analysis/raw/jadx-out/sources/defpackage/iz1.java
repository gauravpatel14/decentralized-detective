package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class iz1 implements InterfaceC0564eF0 {
    public final oz1 t;

    public iz1(oz1 oz1Var) {
        this.t = oz1Var;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        if (bf0 == bF0.ON_CREATE) {
            interfaceC0762hF0.getLifecycle().b(this);
            this.t.b();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + bf0).toString());
        }
    }
}
