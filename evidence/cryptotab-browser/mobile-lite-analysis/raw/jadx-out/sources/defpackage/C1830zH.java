package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: zH, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1830zH implements InterfaceC0577eO, Serializable {
    public final InterfaceC0577eO t;
    public final InterfaceC0405bO u;

    public C1830zH(InterfaceC0577eO interfaceC0577eO, InterfaceC0405bO interfaceC0405bO) {
        this.t = interfaceC0577eO;
        this.u = interfaceC0405bO;
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this != obj) {
            if (!(obj instanceof C1830zH)) {
                return false;
            }
            C1830zH c1830zH = (C1830zH) obj;
            c1830zH.getClass();
            int i = 2;
            C1830zH c1830zH2 = c1830zH;
            int i2 = 2;
            while (true) {
                InterfaceC0577eO interfaceC0577eO = c1830zH2.t;
                c1830zH2 = interfaceC0577eO instanceof C1830zH ? (C1830zH) interfaceC0577eO : null;
                if (c1830zH2 == null) {
                    break;
                }
                i2++;
            }
            C1830zH c1830zH3 = this;
            while (true) {
                InterfaceC0577eO interfaceC0577eO2 = c1830zH3.t;
                c1830zH3 = interfaceC0577eO2 instanceof C1830zH ? (C1830zH) interfaceC0577eO2 : null;
                if (c1830zH3 == null) {
                    break;
                }
                i++;
            }
            if (i2 != i) {
                return false;
            }
            C1830zH c1830zH4 = this;
            while (true) {
                InterfaceC0405bO interfaceC0405bO = c1830zH4.u;
                if (!lz0.a(c1830zH.l(interfaceC0405bO.getKey()), interfaceC0405bO)) {
                    zA = false;
                    break;
                }
                InterfaceC0577eO interfaceC0577eO3 = c1830zH4.t;
                if (!(interfaceC0577eO3 instanceof C1830zH)) {
                    InterfaceC0405bO interfaceC0405bO2 = (InterfaceC0405bO) interfaceC0577eO3;
                    zA = lz0.a(c1830zH.l(interfaceC0405bO2.getKey()), interfaceC0405bO2);
                    break;
                }
                c1830zH4 = (C1830zH) interfaceC0577eO3;
            }
            if (!zA) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.u.hashCode() + this.t.hashCode();
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0577eO j(InterfaceC0577eO interfaceC0577eO) {
        return aO.b(this, interfaceC0577eO);
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0405bO l(InterfaceC0465cO interfaceC0465cO) {
        C1830zH c1830zH = this;
        while (true) {
            InterfaceC0405bO interfaceC0405bOL = c1830zH.u.l(interfaceC0465cO);
            if (interfaceC0405bOL != null) {
                return interfaceC0405bOL;
            }
            InterfaceC0577eO interfaceC0577eO = c1830zH.t;
            if (!(interfaceC0577eO instanceof C1830zH)) {
                return interfaceC0577eO.l(interfaceC0465cO);
            }
            c1830zH = (C1830zH) interfaceC0577eO;
        }
    }

    @Override // defpackage.InterfaceC0577eO
    public final Object p(Object obj, xk0 xk0Var) {
        return xk0Var.i(this.t.p(obj, xk0Var), this.u);
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0577eO q(InterfaceC0465cO interfaceC0465cO) {
        InterfaceC0405bO interfaceC0405bO = this.u;
        InterfaceC0405bO interfaceC0405bOL = interfaceC0405bO.l(interfaceC0465cO);
        InterfaceC0577eO interfaceC0577eO = this.t;
        if (interfaceC0405bOL != null) {
            return interfaceC0577eO;
        }
        InterfaceC0577eO interfaceC0577eOQ = interfaceC0577eO.q(interfaceC0465cO);
        return interfaceC0577eOQ == interfaceC0577eO ? this : interfaceC0577eOQ == R60.t ? interfaceC0405bO : new C1830zH(interfaceC0577eOQ, interfaceC0405bO);
    }

    public final String toString() {
        return "[" + ((String) p("", C1774yH.u)) + ']';
    }
}
