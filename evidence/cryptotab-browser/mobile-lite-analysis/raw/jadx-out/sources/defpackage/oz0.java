package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class oz0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static InterfaceC1670wN a(InterfaceC1670wN interfaceC1670wN, InterfaceC1670wN interfaceC1670wN2, xk0 xk0Var) {
        if (xk0Var instanceof AbstractC1864zn) {
            return ((AbstractC1864zn) xk0Var).a(interfaceC1670wN, interfaceC1670wN2);
        }
        InterfaceC0577eO context = interfaceC1670wN2.getContext();
        return context == R60.t ? new mz0(interfaceC1670wN2, interfaceC1670wN, xk0Var) : new nz0(interfaceC1670wN2, context, xk0Var, interfaceC1670wN);
    }

    public static InterfaceC1670wN b(InterfaceC1670wN interfaceC1670wN) {
        yN yNVar = interfaceC1670wN instanceof yN ? (yN) interfaceC1670wN : null;
        if (yNVar == null) {
            return interfaceC1670wN;
        }
        InterfaceC1670wN interfaceC1670wN2 = yNVar.v;
        if (interfaceC1670wN2 != null) {
            return interfaceC1670wN2;
        }
        AN an = (AN) yNVar.u.l(zN.t);
        InterfaceC1670wN d00Var = an != null ? new d00((AbstractC0771hO) an, yNVar) : yNVar;
        yNVar.v = d00Var;
        return d00Var;
    }
}
