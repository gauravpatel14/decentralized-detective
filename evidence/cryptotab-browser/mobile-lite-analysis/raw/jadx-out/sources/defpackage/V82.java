package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class V82 implements InterfaceC0405bO {
    public final Object t;
    public final ThreadLocal u;
    public final X82 v;

    public V82(Object obj, ThreadLocal threadLocal) {
        this.t = obj;
        this.u = threadLocal;
        this.v = new X82(threadLocal);
    }

    public final Object b(InterfaceC0577eO interfaceC0577eO) {
        ThreadLocal threadLocal = this.u;
        Object obj = threadLocal.get();
        threadLocal.set(this.t);
        return obj;
    }

    @Override // defpackage.InterfaceC0405bO
    public final InterfaceC0465cO getKey() {
        return this.v;
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0577eO j(InterfaceC0577eO interfaceC0577eO) {
        return aO.b(this, interfaceC0577eO);
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0405bO l(InterfaceC0465cO interfaceC0465cO) {
        if (this.v.equals(interfaceC0465cO)) {
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
        return this.v.equals(interfaceC0465cO) ? R60.t : this;
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.t + ", threadLocal = " + this.u + ')';
    }
}
