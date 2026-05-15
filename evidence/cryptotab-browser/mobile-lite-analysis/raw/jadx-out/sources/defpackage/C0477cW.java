package defpackage;

/* JADX INFO: renamed from: cW, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0477cW implements InterfaceC0564eF0 {
    public final InterfaceC0359aW t;
    public final InterfaceC0564eF0 u;

    public C0477cW(InterfaceC0359aW interfaceC0359aW, InterfaceC0564eF0 interfaceC0564eF0) {
        this.t = interfaceC0359aW;
        this.u = interfaceC0564eF0;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        int i = AbstractC0417bW.a[bf0.ordinal()];
        InterfaceC0359aW interfaceC0359aW = this.t;
        if (i == 3) {
            interfaceC0359aW.a();
        } else if (i == 6) {
            interfaceC0359aW.b(interfaceC0762hF0);
        } else if (i == 7) {
            throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0564eF0 interfaceC0564eF0 = this.u;
        if (interfaceC0564eF0 != null) {
            interfaceC0564eF0.c(interfaceC0762hF0, bf0);
        }
    }
}
