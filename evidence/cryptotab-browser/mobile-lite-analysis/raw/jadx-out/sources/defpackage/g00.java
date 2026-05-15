package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutinesInternalError;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g00 extends F62 {
    public int v;

    public g00(int i) {
        super(0L, Z62.f);
        this.v = i;
    }

    public abstract void a(Object obj, CancellationException cancellationException);

    public abstract InterfaceC1670wN c();

    public Throwable e(Object obj) {
        OH oh = obj instanceof OH ? (OH) obj : null;
        if (oh != null) {
            return oh.a;
        }
        return null;
    }

    public final void g(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            z80.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kO.a(c().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object h();

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        Object zv1 = C0302Yj2.a;
        I62 i62 = this.u;
        try {
            d00 d00Var = (d00) c();
            yN yNVar = d00Var.x;
            Object obj = d00Var.z;
            InterfaceC0577eO interfaceC0577eO = yNVar.u;
            Object objB = U82.b(interfaceC0577eO, obj);
            C0082Gj2 c0082Gj2B = objB != U82.a ? gO.b(yNVar, interfaceC0577eO, objB) : null;
            try {
                InterfaceC0577eO interfaceC0577eO2 = yNVar.u;
                Object objH = h();
                Throwable thE = e(objH);
                RA0 ra0 = (thE == null && AbstractC0746h00.a(this.v)) ? (RA0) interfaceC0577eO2.l(QA0.t) : null;
                if (ra0 != null && !ra0.a()) {
                    CancellationException cancellationExceptionR = ((YA0) ra0).r();
                    a(objH, cancellationExceptionR);
                    yNVar.d(new Zv1(cancellationExceptionR));
                } else if (thE != null) {
                    yNVar.d(new Zv1(thE));
                } else {
                    yNVar.d(f(objH));
                }
                if (c0082Gj2B == null || c0082Gj2B.N()) {
                    U82.a(interfaceC0577eO, objB);
                }
                try {
                    i62.getClass();
                } catch (Throwable th) {
                    zv1 = new Zv1(th);
                }
                g(null, aw1.a(zv1));
            } catch (Throwable th2) {
                if (c0082Gj2B == null || c0082Gj2B.N()) {
                    U82.a(interfaceC0577eO, objB);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                i62.getClass();
            } catch (Throwable th4) {
                zv1 = new Zv1(th4);
            }
            g(th3, aw1.a(zv1));
        }
    }

    public Object f(Object obj) {
        return obj;
    }
}
