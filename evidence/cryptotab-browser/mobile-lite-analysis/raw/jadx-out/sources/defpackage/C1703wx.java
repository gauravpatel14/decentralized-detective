package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.CompletionHandlerException;

/* JADX INFO: renamed from: wx, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1703wx extends g00 implements InterfaceC1670wN, qO {
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;
    public final InterfaceC1670wN w;
    public final InterfaceC0577eO x;
    public L00 y;
    public static final /* synthetic */ AtomicIntegerFieldUpdater z = AtomicIntegerFieldUpdater.newUpdater(C1703wx.class, "_decision");
    public static final /* synthetic */ AtomicReferenceFieldUpdater A = AtomicReferenceFieldUpdater.newUpdater(C1703wx.class, Object.class, "_state");

    public C1703wx(InterfaceC1670wN interfaceC1670wN, int i) {
        super(i);
        this.w = interfaceC1670wN;
        this.x = interfaceC1670wN.getContext();
        this._decision = 0;
        this._state = P3.t;
    }

    public static void s(InterfaceC0926jk0 interfaceC0926jk0, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + interfaceC0926jk0 + ", already has " + obj).toString());
    }

    public static Object v(InterfaceC1184o01 interfaceC1184o01, Object obj, int i, InterfaceC0926jk0 interfaceC0926jk0) {
        if ((obj instanceof OH) || !AbstractC0746h00.a(i)) {
            return obj;
        }
        if (interfaceC0926jk0 != null || ((interfaceC1184o01 instanceof AbstractC1474sx) && !(interfaceC1184o01 instanceof np))) {
            return new MH(obj, interfaceC1184o01 instanceof AbstractC1474sx ? (AbstractC1474sx) interfaceC1184o01 : null, interfaceC0926jk0, (CancellationException) null, 16);
        }
        return obj;
    }

    @Override // defpackage.g00
    public final void a(Object obj, CancellationException cancellationException) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof InterfaceC1184o01) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof OH) {
                return;
            }
            boolean z2 = obj2 instanceof MH;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
            if (!z2) {
                MH mh = new MH(obj2, (AbstractC1474sx) null, (InterfaceC0926jk0) null, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, mh)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            MH mh2 = (MH) obj2;
            if (mh2.e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            MH mhA = MH.a(mh2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, mhA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            AbstractC1474sx abstractC1474sx = mh2.b;
            if (abstractC1474sx != null) {
                i(abstractC1474sx, cancellationException);
            }
            InterfaceC0926jk0 interfaceC0926jk0 = mh2.c;
            if (interfaceC0926jk0 != null) {
                k(interfaceC0926jk0, cancellationException);
                return;
            }
            return;
        }
    }

    @Override // defpackage.qO
    public final qO b() {
        InterfaceC1670wN interfaceC1670wN = this.w;
        if (interfaceC1670wN instanceof qO) {
            return (qO) interfaceC1670wN;
        }
        return null;
    }

    @Override // defpackage.g00
    public final InterfaceC1670wN c() {
        return this.w;
    }

    @Override // defpackage.InterfaceC1670wN
    public final void d(Object obj) {
        Throwable thA = aw1.a(obj);
        if (thA != null) {
            obj = new OH(thA, false);
        }
        u(obj, this.v, null);
    }

    @Override // defpackage.g00
    public final Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // defpackage.g00
    public final Object f(Object obj) {
        return obj instanceof MH ? ((MH) obj).a : obj;
    }

    @Override // defpackage.InterfaceC1670wN
    public final InterfaceC0577eO getContext() {
        return this.x;
    }

    @Override // defpackage.g00
    public final Object h() {
        return this._state;
    }

    public final void i(AbstractC1474sx abstractC1474sx, Throwable th) {
        try {
            abstractC1474sx.a(th);
        } catch (Throwable th2) {
            kO.a(this.x, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void j(InterfaceC0926jk0 interfaceC0926jk0, Throwable th) {
        try {
            interfaceC0926jk0.j(th);
        } catch (Throwable th2) {
            kO.a(this.x, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(InterfaceC0926jk0 interfaceC0926jk0, Throwable th) {
        try {
            interfaceC0926jk0.j(th);
        } catch (Throwable th2) {
            kO.a(this.x, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void l(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        L00 l00;
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof InterfaceC1184o01)) {
                return;
            }
            boolean z2 = obj instanceof AbstractC1474sx;
            Ex ex = new Ex(this, th, z2);
            do {
                atomicReferenceFieldUpdater = A;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, ex)) {
                    AbstractC1474sx abstractC1474sx = z2 ? (AbstractC1474sx) obj : null;
                    if (abstractC1474sx != null) {
                        i(abstractC1474sx, th);
                    }
                    if (!r() && (l00 = this.y) != null) {
                        l00.d();
                        this.y = C1123n01.t;
                    }
                    m(this.v);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    public final void m(int i) {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                InterfaceC1670wN interfaceC1670wN = this.w;
                boolean z2 = i == 4;
                if (z2 || !(interfaceC1670wN instanceof d00) || AbstractC0746h00.a(i) != AbstractC0746h00.a(this.v)) {
                    AbstractC0746h00.b(this, interfaceC1670wN, z2);
                    return;
                }
                AbstractC0771hO abstractC0771hO = ((d00) interfaceC1670wN).w;
                InterfaceC0577eO interfaceC0577eO = ((d00) interfaceC1670wN).x.u;
                if (abstractC0771hO.d()) {
                    abstractC0771hO.c(interfaceC0577eO, this);
                    return;
                }
                p80 p80VarA = W82.a();
                if (p80VarA.u >= 4294967296L) {
                    p80VarA.n(this);
                    return;
                }
                p80VarA.t(true);
                try {
                    AbstractC0746h00.b(this, this.w, true);
                    do {
                    } while (p80VarA.z());
                } finally {
                    try {
                    } finally {
                    }
                }
                return;
            }
        } while (!z.compareAndSet(this, 0, 2));
    }

    public final Object n() {
        C1123n01 c1123n01;
        RA0 ra0;
        d00 d00Var;
        Throwable thM;
        Throwable thM2;
        boolean zR = r();
        do {
            int i = this._decision;
            c1123n01 = C1123n01.t;
            if (i != 0) {
                if (i != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zR) {
                    InterfaceC1670wN interfaceC1670wN = this.w;
                    d00Var = interfaceC1670wN instanceof d00 ? (d00) interfaceC1670wN : null;
                    if (d00Var != null && (thM = d00Var.m(this)) != null) {
                        L00 l00 = this.y;
                        if (l00 != null) {
                            l00.d();
                            this.y = c1123n01;
                        }
                        l(thM);
                    }
                }
                Object obj = this._state;
                if (obj instanceof OH) {
                    throw ((OH) obj).a;
                }
                if (!AbstractC0746h00.a(this.v) || (ra0 = (RA0) this.x.l(QA0.t)) == null || ra0.a()) {
                    return f(obj);
                }
                CancellationException cancellationExceptionR = ((YA0) ra0).r();
                a(obj, cancellationExceptionR);
                throw cancellationExceptionR;
            }
        } while (!z.compareAndSet(this, 0, 1));
        if (this.y == null) {
            p();
        }
        if (zR) {
            InterfaceC1670wN interfaceC1670wN2 = this.w;
            d00Var = interfaceC1670wN2 instanceof d00 ? (d00) interfaceC1670wN2 : null;
            if (d00Var != null && (thM2 = d00Var.m(this)) != null) {
                L00 l002 = this.y;
                if (l002 != null) {
                    l002.d();
                    this.y = c1123n01;
                }
                l(thM2);
            }
        }
        return pO.t;
    }

    public final void o() {
        L00 l00P = p();
        if (l00P == null || (this._state instanceof InterfaceC1184o01)) {
            return;
        }
        l00P.d();
        this.y = C1123n01.t;
    }

    public final L00 p() {
        RA0 ra0 = (RA0) this.x.l(QA0.t);
        if (ra0 == null) {
            return null;
        }
        L00 l00A = PA0.a(ra0, true, new C0168Nz(this), 2);
        this.y = l00A;
        return l00A;
    }

    public final void q(InterfaceC0926jk0 interfaceC0926jk0) {
        AbstractC1474sx yz0Var = interfaceC0926jk0 instanceof AbstractC1474sx ? (AbstractC1474sx) interfaceC0926jk0 : new yz0(interfaceC0926jk0);
        while (true) {
            Object obj = this._state;
            boolean z2 = obj instanceof P3;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
            if (z2) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, yz0Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            if (obj instanceof AbstractC1474sx) {
                s(interfaceC0926jk0, obj);
                throw null;
            }
            if (obj instanceof OH) {
                OH oh = (OH) obj;
                oh.getClass();
                if (!OH.b.compareAndSet(oh, 0, 1)) {
                    s(interfaceC0926jk0, obj);
                    throw null;
                }
                if (obj instanceof Ex) {
                    if (!(obj instanceof OH)) {
                        oh = null;
                    }
                    j(interfaceC0926jk0, oh != null ? oh.a : null);
                    return;
                }
                return;
            }
            if (!(obj instanceof MH)) {
                if (yz0Var instanceof np) {
                    return;
                }
                MH mh = new MH(obj, yz0Var, (InterfaceC0926jk0) null, (CancellationException) null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mh)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            MH mh2 = (MH) obj;
            if (mh2.b != null) {
                s(interfaceC0926jk0, obj);
                throw null;
            }
            if (yz0Var instanceof np) {
                return;
            }
            Throwable th = mh2.e;
            if (th != null) {
                j(interfaceC0926jk0, th);
                return;
            }
            MH mhA = MH.a(mh2, yz0Var, null, 29);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mhA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            return;
        }
    }

    public final boolean r() {
        return this.v == 2 && ((d00) this.w).j();
    }

    public final boolean t() {
        Object obj = this._state;
        if (!(obj instanceof MH) || ((MH) obj).d == null) {
            this._decision = 0;
            this._state = P3.t;
            return true;
        }
        L00 l00 = this.y;
        if (l00 != null) {
            l00.d();
            this.y = C1123n01.t;
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CancellableContinuation(");
        sb.append(hV.b(this.w));
        sb.append("){");
        Object obj = this._state;
        sb.append(obj instanceof InterfaceC1184o01 ? "Active" : obj instanceof Ex ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(hV.a(this));
        return sb.toString();
    }

    public final void u(Object obj, int i, InterfaceC0926jk0 interfaceC0926jk0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        L00 l00;
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof InterfaceC1184o01)) {
                if (obj2 instanceof Ex) {
                    Ex ex = (Ex) obj2;
                    ex.getClass();
                    if (Ex.c.compareAndSet(ex, 0, 1)) {
                        if (interfaceC0926jk0 != null) {
                            k(interfaceC0926jk0, ex.a);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
            Object objV = v((InterfaceC1184o01) obj2, obj, i, interfaceC0926jk0);
            do {
                atomicReferenceFieldUpdater = A;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, objV)) {
                    if (!r() && (l00 = this.y) != null) {
                        l00.d();
                        this.y = C1123n01.t;
                    }
                    m(i);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }

    public final eT1 w(InterfaceC0926jk0 interfaceC0926jk0, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        L00 l00;
        while (true) {
            Object obj2 = this._state;
            boolean z2 = obj2 instanceof InterfaceC1184o01;
            eT1 et1 = xx.a;
            if (!z2) {
                boolean z3 = obj2 instanceof MH;
                return null;
            }
            Object objV = v((InterfaceC1184o01) obj2, obj, this.v, interfaceC0926jk0);
            do {
                atomicReferenceFieldUpdater = A;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, objV)) {
                    if (r() || (l00 = this.y) == null) {
                        return et1;
                    }
                    l00.d();
                    this.y = C1123n01.t;
                    return et1;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }
}
