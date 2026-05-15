package defpackage;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: vm2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1635vm2 {
    public HashMap a;

    public C1635vm2() {
        int i = AbstractC1872zv.a;
        this.a = new HashMap();
    }

    public final void a() {
        int i = AbstractC1872zv.a;
        if (this.a == null) {
            throw new IllegalStateException("Operation is not allowed after destroy().");
        }
    }

    public final void b() {
        a();
        HashMap map = this.a;
        this.a = null;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((InterfaceC1579um2) it.next()).destroy();
        }
    }

    public final InterfaceC1579um2 c(Class cls) {
        a();
        if (cls != null) {
            return (InterfaceC1579um2) cls.cast(this.a.get(cls));
        }
        throw new IllegalArgumentException("Neither key nor object of UserDataHost can be null.");
    }

    public final void d(Class cls) {
        a();
        if (!this.a.containsKey(cls)) {
            throw new IllegalStateException("UserData for the key is not present.");
        }
    }

    public final InterfaceC1579um2 e(Class cls, InterfaceC1579um2 interfaceC1579um2) {
        a();
        if (cls == null || interfaceC1579um2 == null) {
            throw new IllegalArgumentException("Neither key nor object of UserDataHost can be null.");
        }
        this.a.put(cls, interfaceC1579um2);
        return c(cls);
    }
}
