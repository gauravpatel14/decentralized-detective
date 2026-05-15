package defpackage;

/* JADX INFO: renamed from: Gj2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0082Gj2 extends Kz1 {
    public ThreadLocal w;

    public final boolean N() {
        ThreadLocal threadLocal = this.w;
        if (threadLocal.get() == null) {
            return false;
        }
        threadLocal.set(null);
        return true;
    }

    @Override // defpackage.Kz1, defpackage.YA0
    public final void f(Object obj) {
        ThreadLocal threadLocal = this.w;
        I81 i81 = (I81) threadLocal.get();
        if (i81 != null) {
            U82.a((InterfaceC0577eO) i81.t, i81.u);
            threadLocal.set(null);
        }
        Object objA = QH.a(obj);
        yN yNVar = this.v;
        InterfaceC0577eO interfaceC0577eO = yNVar.u;
        Object objB = U82.b(interfaceC0577eO, null);
        C0082Gj2 c0082Gj2B = objB != U82.a ? gO.b(yNVar, interfaceC0577eO, objB) : null;
        try {
            yNVar.d(objA);
        } finally {
            if (c0082Gj2B == null || c0082Gj2B.N()) {
                U82.a(interfaceC0577eO, objB);
            }
        }
    }
}
