package defpackage;

/* JADX INFO: renamed from: dO, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0525dO extends RC0 implements xk0 {
    public static final C0525dO u = new C0525dO(2);

    @Override // defpackage.xk0
    public final Object i(Object obj, Object obj2) {
        C1830zH c1830zH;
        InterfaceC0405bO interfaceC0405bO = (InterfaceC0405bO) obj2;
        InterfaceC0577eO interfaceC0577eOQ = ((InterfaceC0577eO) obj).q(interfaceC0405bO.getKey());
        R60 r60 = R60.t;
        if (interfaceC0577eOQ == r60) {
            return interfaceC0405bO;
        }
        zN zNVar = zN.t;
        AN an = (AN) interfaceC0577eOQ.l(zNVar);
        if (an == null) {
            c1830zH = new C1830zH(interfaceC0577eOQ, interfaceC0405bO);
        } else {
            InterfaceC0577eO interfaceC0577eOQ2 = interfaceC0577eOQ.q(zNVar);
            if (interfaceC0577eOQ2 == r60) {
                return new C1830zH(interfaceC0405bO, an);
            }
            c1830zH = new C1830zH(new C1830zH(interfaceC0577eOQ2, interfaceC0405bO), an);
        }
        return c1830zH;
    }
}
