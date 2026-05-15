package defpackage;

import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.CompletionHandlerException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u extends YA0 implements InterfaceC1670wN, nO {
    public final InterfaceC0577eO u;

    public u(InterfaceC0577eO interfaceC0577eO, boolean z) {
        super(z);
        A((RA0) interfaceC0577eO.l(QA0.t));
        this.u = interfaceC0577eO.j(this);
    }

    @Override // defpackage.YA0
    public final void H(Object obj) {
        if (obj instanceof OH) {
            Throwable th = ((OH) obj).a;
        }
    }

    public final void M(int i, u uVar, xk0 xk0Var) {
        int iB = aM1.b(i);
        if (iB == 0) {
            zx.a(xk0Var, uVar, this);
            return;
        }
        if (iB != 1) {
            if (iB == 2) {
                oz0.b(oz0.a(uVar, this, xk0Var)).d(C0302Yj2.a);
                return;
            }
            if (iB != 3) {
                throw new NoWhenBranchMatchedException();
            }
            try {
                InterfaceC0577eO interfaceC0577eO = this.u;
                Object objB = U82.b(interfaceC0577eO, null);
                try {
                    AbstractC0222Si2.a(2, xk0Var);
                    Object objI = xk0Var.i(uVar, this);
                    if (objI != pO.t) {
                        d(objI);
                    }
                } finally {
                    U82.a(interfaceC0577eO, objB);
                }
            } catch (Throwable th) {
                d(new Zv1(th));
            }
        }
    }

    @Override // defpackage.nO
    public final InterfaceC0577eO c() {
        return this.u;
    }

    @Override // defpackage.InterfaceC1670wN
    public final void d(Object obj) {
        Throwable thA = aw1.a(obj);
        if (thA != null) {
            obj = new OH(thA, false);
        }
        Object objD = D(obj);
        if (objD == ZA0.b) {
            return;
        }
        f(objD);
    }

    @Override // defpackage.InterfaceC1670wN
    public final InterfaceC0577eO getContext() {
        return this.u;
    }

    @Override // defpackage.YA0
    public final String i() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // defpackage.YA0
    public final void z(CompletionHandlerException completionHandlerException) {
        kO.a(this.u, completionHandlerException);
    }
}
