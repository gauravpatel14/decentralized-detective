package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class aI implements InterfaceC0564eF0 {
    public final /* synthetic */ iI t;

    public aI(iI iIVar) {
        this.t = iIVar;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        iI iIVar = this.t;
        if (iIVar.x == null) {
            cI cIVar = (cI) iIVar.getLastNonConfigurationInstance();
            if (cIVar != null) {
                iIVar.x = cIVar.a;
            }
            if (iIVar.x == null) {
                iIVar.x = new C0094Ho2();
            }
        }
        iIVar.getLifecycle().b(this);
    }
}
