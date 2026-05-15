package defpackage;

/* JADX INFO: renamed from: v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1590v implements InterfaceC0405bO {
    public final InterfaceC0465cO t;

    public AbstractC1590v(InterfaceC0465cO interfaceC0465cO) {
        this.t = interfaceC0465cO;
    }

    @Override // defpackage.InterfaceC0405bO
    public final InterfaceC0465cO getKey() {
        return this.t;
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0577eO j(InterfaceC0577eO interfaceC0577eO) {
        return aO.b(this, interfaceC0577eO);
    }

    @Override // defpackage.InterfaceC0577eO
    public InterfaceC0405bO l(InterfaceC0465cO interfaceC0465cO) {
        if (lz0.a(getKey(), interfaceC0465cO)) {
            return this;
        }
        return null;
    }

    @Override // defpackage.InterfaceC0577eO
    public final Object p(Object obj, xk0 xk0Var) {
        return xk0Var.i(obj, this);
    }

    @Override // defpackage.InterfaceC0577eO
    public InterfaceC0577eO q(InterfaceC0465cO interfaceC0465cO) {
        return aO.a(this, interfaceC0465cO);
    }
}
