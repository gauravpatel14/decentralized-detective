package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class T82 extends RC0 implements xk0 {
    public static final T82 v = new T82(2, 0);
    public static final T82 w = new T82(2, 1);
    public static final T82 x = new T82(2, 2);
    public final /* synthetic */ int u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ T82(int i, int i2) {
        super(i);
        this.u = i2;
    }

    @Override // defpackage.xk0
    public final Object i(Object obj, Object obj2) {
        switch (this.u) {
            case 0:
                InterfaceC0405bO interfaceC0405bO = (InterfaceC0405bO) obj2;
                if (!(interfaceC0405bO instanceof V82)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? interfaceC0405bO : Integer.valueOf(iIntValue + 1);
            case 1:
                V82 v82 = (V82) obj;
                InterfaceC0405bO interfaceC0405bO2 = (InterfaceC0405bO) obj2;
                if (v82 != null) {
                    return v82;
                }
                if (interfaceC0405bO2 instanceof V82) {
                    return (V82) interfaceC0405bO2;
                }
                return null;
            default:
                a92 a92Var = (a92) obj;
                InterfaceC0405bO interfaceC0405bO3 = (InterfaceC0405bO) obj2;
                if (interfaceC0405bO3 instanceof V82) {
                    V82 v822 = (V82) interfaceC0405bO3;
                    Object objB = v822.b(a92Var.a);
                    int i = a92Var.d;
                    a92Var.b[i] = objB;
                    a92Var.d = i + 1;
                    a92Var.c[i] = v822;
                }
                return a92Var;
        }
    }
}
