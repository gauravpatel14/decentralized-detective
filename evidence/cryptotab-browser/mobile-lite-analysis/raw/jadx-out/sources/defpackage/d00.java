package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class d00 extends g00 implements qO, InterfaceC1670wN {
    public static final /* synthetic */ AtomicReferenceFieldUpdater A = AtomicReferenceFieldUpdater.newUpdater(d00.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;
    public final AbstractC0771hO w;
    public final yN x;
    public Object y;
    public final Object z;

    public d00(AbstractC0771hO abstractC0771hO, yN yNVar) {
        super(-1);
        this.w = abstractC0771hO;
        this.x = yNVar;
        this.y = AbstractC0554e00.a;
        this.z = yNVar.u.p(0, T82.v);
        this._reusableCancellableContinuation = null;
    }

    @Override // defpackage.g00
    public final void a(Object obj, CancellationException cancellationException) {
        if (obj instanceof PH) {
            ((PH) obj).b.j(cancellationException);
        }
    }

    @Override // defpackage.qO
    public final qO b() {
        yN yNVar = this.x;
        if (yNVar != null) {
            return yNVar;
        }
        return null;
    }

    @Override // defpackage.InterfaceC1670wN
    public final void d(Object obj) {
        yN yNVar = this.x;
        InterfaceC0577eO interfaceC0577eO = yNVar.u;
        Throwable thA = aw1.a(obj);
        Object oh = thA == null ? obj : new OH(thA, false);
        AbstractC0771hO abstractC0771hO = this.w;
        if (abstractC0771hO.d()) {
            this.y = oh;
            this.v = 0;
            abstractC0771hO.c(interfaceC0577eO, this);
            return;
        }
        p80 p80VarA = W82.a();
        if (p80VarA.u >= 4294967296L) {
            this.y = oh;
            this.v = 0;
            p80VarA.n(this);
            return;
        }
        p80VarA.t(true);
        try {
            InterfaceC0577eO interfaceC0577eO2 = yNVar.u;
            Object objB = U82.b(interfaceC0577eO2, this.z);
            try {
                yNVar.d(obj);
                while (p80VarA.z()) {
                }
            } finally {
                U82.a(interfaceC0577eO2, objB);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // defpackage.InterfaceC1670wN
    public final InterfaceC0577eO getContext() {
        return this.x.u;
    }

    @Override // defpackage.g00
    public final Object h() {
        Object obj = this.y;
        this.y = AbstractC0554e00.a;
        return obj;
    }

    public final C1703wx i() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            eT1 et1 = AbstractC0554e00.b;
            if (obj == null) {
                this._reusableCancellableContinuation = et1;
                return null;
            }
            if (obj instanceof C1703wx) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, et1)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return (C1703wx) obj;
            }
            if (obj != et1 && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final boolean j() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean k(CancellationException cancellationException) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            eT1 et1 = AbstractC0554e00.b;
            boolean zA = lz0.a(obj, et1);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
            if (zA) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, et1, cancellationException)) {
                    if (atomicReferenceFieldUpdater.get(this) != et1) {
                        break;
                    }
                }
                return true;
            }
            if (obj instanceof Throwable) {
                return true;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            return false;
        }
    }

    public final void l() {
        L00 l00;
        Object obj = this._reusableCancellableContinuation;
        C1703wx c1703wx = obj instanceof C1703wx ? (C1703wx) obj : null;
        if (c1703wx == null || (l00 = c1703wx.y) == null) {
            return;
        }
        l00.d();
        c1703wx.y = C1123n01.t;
    }

    public final Throwable m(C1703wx c1703wx) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            eT1 et1 = AbstractC0554e00.b;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
            if (obj == et1) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, et1, c1703wx)) {
                    if (atomicReferenceFieldUpdater.get(this) != et1) {
                        break;
                    }
                }
                return null;
            }
            if (!(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            return (Throwable) obj;
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.w + ", " + hV.b(this.x) + ']';
    }

    @Override // defpackage.g00
    public final InterfaceC1670wN c() {
        return this;
    }
}
