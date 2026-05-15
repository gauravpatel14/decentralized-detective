package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class nz0 extends yN {
    public int w;
    public final /* synthetic */ xk0 x;
    public final /* synthetic */ InterfaceC1670wN y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nz0(InterfaceC1670wN interfaceC1670wN, InterfaceC0577eO interfaceC0577eO, xk0 xk0Var, InterfaceC1670wN interfaceC1670wN2) {
        super(interfaceC1670wN, interfaceC0577eO);
        this.x = xk0Var;
        this.y = interfaceC1670wN2;
    }

    @Override // defpackage.AbstractC1864zn
    public final Object l(Object obj) throws Throwable {
        int i = this.w;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.w = 2;
            bw1.a(obj);
            return obj;
        }
        this.w = 1;
        bw1.a(obj);
        xk0 xk0Var = this.x;
        AbstractC0222Si2.a(2, xk0Var);
        return xk0Var.i(this.y, this);
    }
}
