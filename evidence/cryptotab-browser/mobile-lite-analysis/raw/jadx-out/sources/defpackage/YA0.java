package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class YA0 implements RA0, e91 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater t = AtomicReferenceFieldUpdater.newUpdater(YA0.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    public YA0(boolean z) {
        this._state = z ? ZA0.g : ZA0.f;
        this._parentHandle = null;
    }

    public static Pz F(PI0 pi0) {
        while (pi0.s()) {
            pi0 = pi0.q();
        }
        while (true) {
            pi0 = pi0.p();
            if (!pi0.s()) {
                if (pi0 instanceof Pz) {
                    return (Pz) pi0;
                }
                if (pi0 instanceof m01) {
                    return null;
                }
            }
        }
    }

    public static String K(Object obj) {
        if (!(obj instanceof WA0)) {
            return obj instanceof Vv0 ? ((Vv0) obj).a() ? "Active" : "New" : obj instanceof OH ? "Cancelled" : "Completed";
        }
        WA0 wa0 = (WA0) obj;
        return wa0.d() ? "Cancelling" : wa0.e() ? "Completing" : "Active";
    }

    public final void A(RA0 ra0) {
        byte b;
        C1123n01 c1123n01 = C1123n01.t;
        if (ra0 == null) {
            this._parentHandle = c1123n01;
            return;
        }
        YA0 ya0 = (YA0) ra0;
        do {
            Object objX = ya0.x();
            boolean z = objX instanceof K60;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t;
            b = 0;
            if (z) {
                if (!((K60) objX).t) {
                    K60 k60 = ZA0.g;
                    while (!atomicReferenceFieldUpdater.compareAndSet(ya0, objX, k60)) {
                        if (atomicReferenceFieldUpdater.get(ya0) != objX) {
                            b = -1;
                            break;
                        }
                    }
                    ya0.getClass();
                    b = 1;
                }
            } else if (objX instanceof C1352qu0) {
                m01 m01Var = ((C1352qu0) objX).t;
                while (!atomicReferenceFieldUpdater.compareAndSet(ya0, objX, m01Var)) {
                    if (atomicReferenceFieldUpdater.get(ya0) != objX) {
                        b = -1;
                        break;
                    }
                }
                ya0.getClass();
                b = 1;
            }
            if (b == 0) {
                break;
            }
        } while (b != 1);
        Oz oz = (Oz) PA0.a(ya0, true, new Pz(this), 2);
        this._parentHandle = oz;
        if (x() instanceof Vv0) {
            return;
        }
        oz.d();
        this._parentHandle = c1123n01;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.L00 B(boolean r10, boolean r11, defpackage.InterfaceC0926jk0 r12) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.YA0.B(boolean, boolean, jk0):L00");
    }

    public boolean C() {
        return this instanceof Zq;
    }

    public final Object D(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objL;
        do {
            objL = L(x(), obj);
            if (objL == ZA0.a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                OH oh = obj instanceof OH ? (OH) obj : null;
                throw new IllegalStateException(str, oh != null ? oh.a : null);
            }
        } while (objL == ZA0.c);
        return objL;
    }

    public String E() {
        return getClass().getSimpleName();
    }

    public final void G(m01 m01Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        CompletionHandlerException completionHandlerException = null;
        for (PI0 pi0P = (PI0) m01Var.o(); !lz0.a(pi0P, m01Var); pi0P = pi0P.p()) {
            if (pi0P instanceof SA0) {
                UA0 ua0 = (UA0) pi0P;
                try {
                    ua0.x(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        z80.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + ua0 + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            z(completionHandlerException);
        }
        h(th);
    }

    public final void J(UA0 ua0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        m01 m01Var = new m01();
        ua0.getClass();
        PI0.u.lazySet(m01Var, ua0);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = PI0.t;
        atomicReferenceFieldUpdater2.lazySet(m01Var, ua0);
        loop0: while (true) {
            if (ua0.o() == ua0) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(ua0, ua0, m01Var)) {
                    if (atomicReferenceFieldUpdater2.get(ua0) != ua0) {
                        break;
                    }
                }
                m01Var.n(ua0);
                break loop0;
            }
            break;
        }
        PI0 pi0P = ua0.p();
        do {
            atomicReferenceFieldUpdater = t;
            if (atomicReferenceFieldUpdater.compareAndSet(this, ua0, pi0P)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == ua0);
    }

    public final Object L(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof Vv0)) {
            return ZA0.a;
        }
        if (((obj instanceof K60) || (obj instanceof UA0)) && !(obj instanceof Pz) && !(obj2 instanceof OH)) {
            Vv0 vv0 = (Vv0) obj;
            Object wv0 = obj2 instanceof Vv0 ? new Wv0((Vv0) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = t;
                if (atomicReferenceFieldUpdater.compareAndSet(this, vv0, wv0)) {
                    H(obj2);
                    m(vv0, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == vv0);
            return ZA0.c;
        }
        Vv0 vv02 = (Vv0) obj;
        m01 m01VarV = v(vv02);
        if (m01VarV == null) {
            return ZA0.c;
        }
        Pz pzF = null;
        WA0 wa0 = vv02 instanceof WA0 ? (WA0) vv02 : null;
        if (wa0 == null) {
            wa0 = new WA0(m01VarV, null);
        }
        synchronized (wa0) {
            if (wa0.e()) {
                return ZA0.a;
            }
            wa0.h();
            if (wa0 != vv02) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = t;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, vv02, wa0)) {
                    if (atomicReferenceFieldUpdater2.get(this) != vv02) {
                        return ZA0.c;
                    }
                }
            }
            boolean zD = wa0.d();
            OH oh = obj2 instanceof OH ? (OH) obj2 : null;
            if (oh != null) {
                wa0.b(oh.a);
            }
            Throwable thC = wa0.c();
            if (zD) {
                thC = null;
            }
            if (thC != null) {
                G(m01VarV, thC);
            }
            Pz pz = vv02 instanceof Pz ? (Pz) vv02 : null;
            if (pz == null) {
                m01 m01VarK = vv02.k();
                if (m01VarK != null) {
                    pzF = F(m01VarK);
                }
            } else {
                pzF = pz;
            }
            if (pzF != null) {
                while (PA0.a(pzF.x, false, new VA0(this, wa0, pzF, obj2), 1) == C1123n01.t) {
                    pzF = F(pzF);
                    if (pzF == null) {
                    }
                }
                return ZA0.b;
            }
            return o(wa0, obj2);
        }
    }

    @Override // defpackage.RA0
    public boolean a() {
        Object objX = x();
        return (objX instanceof Vv0) && ((Vv0) objX).a();
    }

    public void f(Object obj) {
        e(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r0 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.YA0.g(java.lang.Object):boolean");
    }

    @Override // defpackage.InterfaceC0405bO
    public final InterfaceC0465cO getKey() {
        return QA0.t;
    }

    public final boolean h(Throwable th) {
        if (C()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        Oz oz = (Oz) this._parentHandle;
        return (oz == null || oz == C1123n01.t) ? z : oz.h(th) || z;
    }

    public String i() {
        return "Job was cancelled";
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0577eO j(InterfaceC0577eO interfaceC0577eO) {
        return aO.b(this, interfaceC0577eO);
    }

    public boolean k(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return g(th) && t();
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0405bO l(InterfaceC0465cO interfaceC0465cO) {
        if (lz0.a(QA0.t, interfaceC0465cO)) {
            return this;
        }
        return null;
    }

    public final void m(Vv0 vv0, Object obj) throws IllegalAccessException, InvocationTargetException {
        Oz oz = (Oz) this._parentHandle;
        if (oz != null) {
            oz.d();
            this._parentHandle = C1123n01.t;
        }
        CompletionHandlerException completionHandlerException = null;
        OH oh = obj instanceof OH ? (OH) obj : null;
        Throwable th = oh != null ? oh.a : null;
        if (vv0 instanceof UA0) {
            try {
                ((UA0) vv0).x(th);
                return;
            } catch (Throwable th2) {
                z(new CompletionHandlerException("Exception in completion handler " + vv0 + " for " + this, th2));
                return;
            }
        }
        m01 m01VarK = vv0.k();
        if (m01VarK != null) {
            for (PI0 pi0P = (PI0) m01VarK.o(); !lz0.a(pi0P, m01VarK); pi0P = pi0P.p()) {
                if (pi0P instanceof UA0) {
                    UA0 ua0 = (UA0) pi0P;
                    try {
                        ua0.x(th);
                    } catch (Throwable th3) {
                        if (completionHandlerException != null) {
                            z80.a(completionHandlerException, th3);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + ua0 + " for " + this, th3);
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                z(completionHandlerException);
            }
        }
    }

    public final Throwable n(Object obj) {
        Throwable thC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        YA0 ya0 = (YA0) ((e91) obj);
        Object objX = ya0.x();
        if (objX instanceof WA0) {
            thC = ((WA0) objX).c();
        } else if (objX instanceof OH) {
            thC = ((OH) objX).a;
        } else {
            if (objX instanceof Vv0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objX).toString());
            }
            thC = null;
        }
        CancellationException jobCancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (jobCancellationException == null) {
            jobCancellationException = new JobCancellationException("Parent job is ".concat(K(objX)), thC, ya0);
        }
        return jobCancellationException;
    }

    public final Object o(WA0 wa0, Object obj) throws IllegalAccessException, InvocationTargetException {
        Throwable thS;
        OH oh = obj instanceof OH ? (OH) obj : null;
        Throwable th = oh != null ? oh.a : null;
        synchronized (wa0) {
            wa0.d();
            ArrayList<Throwable> arrayListG = wa0.g(th);
            thS = s(wa0, arrayListG);
            if (thS != null && arrayListG.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListG.size()));
                for (Throwable th2 : arrayListG) {
                    if (th2 != thS && th2 != thS && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        z80.a(thS, th2);
                    }
                }
            }
        }
        if (thS != null && thS != th) {
            obj = new OH(thS, false);
        }
        if (thS != null && (h(thS) || y(thS))) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            }
            OH.b.compareAndSet((OH) obj, 0, 1);
        }
        H(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t;
        Object wv0 = obj instanceof Vv0 ? new Wv0((Vv0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, wa0, wv0) && atomicReferenceFieldUpdater.get(this) == wa0) {
        }
        m(wa0, obj);
        return obj;
    }

    @Override // defpackage.InterfaceC0577eO
    public final Object p(Object obj, xk0 xk0Var) {
        return xk0Var.i(obj, this);
    }

    @Override // defpackage.InterfaceC0577eO
    public final InterfaceC0577eO q(InterfaceC0465cO interfaceC0465cO) {
        return aO.a(this, interfaceC0465cO);
    }

    public final CancellationException r() {
        CancellationException cancellationException;
        Object objX = x();
        if (!(objX instanceof WA0)) {
            if (objX instanceof Vv0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(objX instanceof OH)) {
                return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((OH) objX).a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new JobCancellationException(i(), th, this) : cancellationException;
        }
        Throwable thC = ((WA0) objX).c();
        if (thC == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = i();
        }
        return new JobCancellationException(strConcat, thC, this);
    }

    public final Throwable s(WA0 wa0, ArrayList arrayList) {
        Object next;
        Object obj = null;
        if (arrayList.isEmpty()) {
            if (wa0.d()) {
                return new JobCancellationException(i(), null, this);
            }
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean t() {
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(E() + '{' + K(x()) + '}');
        sb.append('@');
        sb.append(hV.a(this));
        return sb.toString();
    }

    public boolean u() {
        return false;
    }

    public final m01 v(Vv0 vv0) {
        m01 m01VarK = vv0.k();
        if (m01VarK != null) {
            return m01VarK;
        }
        if (vv0 instanceof K60) {
            return new m01();
        }
        if (vv0 instanceof UA0) {
            J((UA0) vv0);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + vv0).toString());
    }

    public final Oz w() {
        return (Oz) this._parentHandle;
    }

    public final Object x() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof h51)) {
                return obj;
            }
            ((h51) obj).a(this);
        }
    }

    public boolean y(Throwable th) {
        return false;
    }

    public void I() {
    }

    public void H(Object obj) {
    }

    public void e(Object obj) {
    }

    public void z(CompletionHandlerException completionHandlerException) {
        throw completionHandlerException;
    }
}
