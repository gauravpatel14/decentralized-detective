package defpackage;

/* JADX INFO: renamed from: Ij2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0103Ij2 implements InterfaceC0405bO, InterfaceC0465cO {
    public static final C0103Ij2 t = new C0103Ij2();

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0577eO j(InterfaceC0577eO interfaceC0577eO) {
        return aO.b(this, interfaceC0577eO);
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0405bO l(InterfaceC0465cO interfaceC0465cO) {
        if (lz0.a(this, interfaceC0465cO)) {
            return this;
        }
        return null;
    }

    @Override // defpackage.InterfaceC0577eO
    public final Object p(Object obj, xk0 xk0Var) {
        return xk0Var.i(obj, this);
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0577eO q(InterfaceC0465cO interfaceC0465cO) {
        return aO.a(this, interfaceC0465cO);
    }

    @Override // defpackage.InterfaceC0405bO
    public final InterfaceC0465cO getKey() {
        return this;
    }
}
