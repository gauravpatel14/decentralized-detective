package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mz0 extends Yv1 {
    public int u;
    public final /* synthetic */ xk0 v;
    public final /* synthetic */ InterfaceC1670wN w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mz0(InterfaceC1670wN interfaceC1670wN, InterfaceC1670wN interfaceC1670wN2, xk0 xk0Var) {
        super(interfaceC1670wN);
        this.v = xk0Var;
        this.w = interfaceC1670wN2;
    }

    @Override // defpackage.AbstractC1864zn
    public final Object l(Object obj) throws Throwable {
        int i = this.u;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.u = 2;
            bw1.a(obj);
            return obj;
        }
        this.u = 1;
        bw1.a(obj);
        xk0 xk0Var = this.v;
        AbstractC0222Si2.a(2, xk0Var);
        return xk0Var.i(this.w, this);
    }
}
