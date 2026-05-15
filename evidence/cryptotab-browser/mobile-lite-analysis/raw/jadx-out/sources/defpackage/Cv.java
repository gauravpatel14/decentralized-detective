package defpackage;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Cv {
    public static C1737xW a(C1205oM c1205oM, xk0 xk0Var) {
        InterfaceC0577eO interfaceC0577eOA = gO.a(c1205oM.c(), R60.t, true);
        C0649fW c0649fW = j00.a;
        if (interfaceC0577eOA != c0649fW && interfaceC0577eOA.l(zN.t) == null) {
            interfaceC0577eOA = interfaceC0577eOA.j(c0649fW);
        }
        C1737xW c1737xW = new C1737xW(interfaceC0577eOA, true);
        c1737xW.M(1, c1737xW, xk0Var);
        return c1737xW;
    }

    public static PN1 b(nO nOVar, xk0 xk0Var) {
        InterfaceC0577eO interfaceC0577eOA = gO.a(nOVar.c(), R60.t, true);
        C0649fW c0649fW = j00.a;
        if (interfaceC0577eOA != c0649fW && interfaceC0577eOA.l(zN.t) == null) {
            interfaceC0577eOA = interfaceC0577eOA.j(c0649fW);
        }
        PN1 pn1 = new PN1(interfaceC0577eOA, true);
        pn1.M(1, pn1, xk0Var);
        return pn1;
    }

    public static void c(xk0 xk0Var) throws Throwable {
        R60 r60 = R60.t;
        Thread threadCurrentThread = Thread.currentThread();
        zN zNVar = zN.t;
        p80 p80VarA = W82.a();
        InterfaceC0577eO interfaceC0577eOA = gO.a(r60, p80VarA, true);
        C0649fW c0649fW = j00.a;
        if (interfaceC0577eOA != c0649fW && interfaceC0577eOA.l(zNVar) == null) {
            interfaceC0577eOA = interfaceC0577eOA.j(c0649fW);
        }
        Zq zq = new Zq(interfaceC0577eOA, threadCurrentThread, p80VarA);
        zq.M(1, zq, xk0Var);
        p80 p80Var = zq.w;
        if (p80Var != null) {
            int i = p80.x;
            p80Var.t(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jY = p80Var != null ? p80Var.y() : Long.MAX_VALUE;
                if (!(zq.x() instanceof Vv0)) {
                    if (p80Var != null) {
                        int i2 = p80.x;
                        p80Var.k(false);
                    }
                    Object objA = ZA0.a(zq.x());
                    OH oh = objA instanceof OH ? (OH) objA : null;
                    if (oh != null) {
                        throw oh.a;
                    }
                    return;
                }
                LockSupport.parkNanos(zq, jY);
            } catch (Throwable th) {
                if (p80Var != null) {
                    int i3 = p80.x;
                    p80Var.k(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        zq.g(interruptedException);
        throw interruptedException;
    }

    public static final Object d(InterfaceC0577eO interfaceC0577eO, xk0 xk0Var, InterfaceC1670wN interfaceC1670wN) {
        yN yNVar = (yN) interfaceC1670wN;
        InterfaceC0577eO interfaceC0577eO2 = yNVar.u;
        InterfaceC0577eO interfaceC0577eOJ = !((Boolean) interfaceC0577eO.p(Boolean.FALSE, C0638fO.w)).booleanValue() ? interfaceC0577eO2.j(interfaceC0577eO) : gO.a(interfaceC0577eO2, interfaceC0577eO, false);
        RA0 ra0 = (RA0) interfaceC0577eOJ.l(QA0.t);
        if (ra0 != null && !ra0.a()) {
            throw ((YA0) ra0).r();
        }
        if (interfaceC0577eOJ == interfaceC0577eO2) {
            Kz1 kz1 = new Kz1(interfaceC0577eOJ, yNVar);
            return Hj2.a(kz1, kz1, xk0Var);
        }
        zN zNVar = zN.t;
        if (!lz0.a(interfaceC0577eOJ.l(zNVar), interfaceC0577eO2.l(zNVar))) {
            f00 f00Var = new f00(interfaceC1670wN, interfaceC0577eOJ);
            zx.a(xk0Var, f00Var, f00Var);
            return f00Var.N();
        }
        C0103Ij2 c0103Ij2 = C0103Ij2.t;
        C0082Gj2 c0082Gj2 = new C0082Gj2(interfaceC0577eOJ.l(c0103Ij2) == null ? interfaceC0577eOJ.j(c0103Ij2) : interfaceC0577eOJ, yNVar);
        c0082Gj2.w = new ThreadLocal();
        if (!(interfaceC0577eO2.l(zNVar) instanceof AbstractC0771hO)) {
            Object objB = U82.b(interfaceC0577eOJ, null);
            U82.a(interfaceC0577eOJ, objB);
            c0082Gj2.w.set(new I81(interfaceC0577eOJ, objB));
        }
        Object objB2 = U82.b(interfaceC0577eOJ, null);
        try {
            return Hj2.a(c0082Gj2, c0082Gj2, xk0Var);
        } finally {
            U82.a(interfaceC0577eOJ, objB2);
        }
    }
}
