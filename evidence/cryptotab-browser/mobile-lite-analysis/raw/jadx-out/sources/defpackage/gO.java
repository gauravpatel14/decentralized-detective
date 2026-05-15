package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gO {
    public static final InterfaceC0577eO a(InterfaceC0577eO interfaceC0577eO, InterfaceC0577eO interfaceC0577eO2, boolean z) {
        Boolean bool = Boolean.FALSE;
        C0638fO c0638fO = C0638fO.w;
        boolean zBooleanValue = ((Boolean) interfaceC0577eO.p(bool, c0638fO)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) interfaceC0577eO2.p(bool, c0638fO)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return interfaceC0577eO.j(interfaceC0577eO2);
        }
        R60 r60 = R60.t;
        InterfaceC0577eO interfaceC0577eO3 = (InterfaceC0577eO) interfaceC0577eO.p(r60, new C0638fO(2, 2));
        Object objP = interfaceC0577eO2;
        if (zBooleanValue2) {
            objP = interfaceC0577eO2.p(r60, C0638fO.v);
        }
        return interfaceC0577eO3.j((InterfaceC0577eO) objP);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [yN] */
    /* JADX WARN: Type inference failed for: r2v1, types: [qO] */
    /* JADX WARN: Type inference failed for: r2v3, types: [qO] */
    public static final C0082Gj2 b(yN yNVar, InterfaceC0577eO interfaceC0577eO, Object obj) {
        C0082Gj2 c0082Gj2 = null;
        if (yNVar == 0) {
            return null;
        }
        if (interfaceC0577eO.l(C0103Ij2.t) != null) {
            while (true) {
                if ((yNVar instanceof f00) || (yNVar = yNVar.b()) == 0) {
                    break;
                }
                if (yNVar instanceof C0082Gj2) {
                    c0082Gj2 = (C0082Gj2) yNVar;
                    break;
                }
            }
            if (c0082Gj2 != null) {
                c0082Gj2.w.set(new I81(interfaceC0577eO, obj));
            }
        }
        return c0082Gj2;
    }
}
