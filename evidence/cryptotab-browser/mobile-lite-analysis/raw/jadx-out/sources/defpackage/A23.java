package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class A23 extends UY2 {
    public final /* synthetic */ ServiceConnectionC1001l33 u;

    public A23(ServiceConnectionC1001l33 serviceConnectionC1001l33) {
        this.u = serviceConnectionC1001l33;
    }

    @Override // defpackage.UY2
    public final void a() {
        ServiceConnectionC1001l33 serviceConnectionC1001l33 = this.u;
        n33 n33Var = serviceConnectionC1001l33.t;
        n33Var.b.b("unlinkToDeath", new Object[0]);
        n33Var.l.asBinder().unlinkToDeath(n33Var.i, 0);
        n33 n33Var2 = serviceConnectionC1001l33.t;
        n33Var2.l = null;
        n33Var2.g = false;
    }
}
