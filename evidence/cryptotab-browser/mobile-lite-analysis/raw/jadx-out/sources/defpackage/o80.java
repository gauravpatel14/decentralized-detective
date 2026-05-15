package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o80 extends p80 implements DW {
    public static final /* synthetic */ AtomicReferenceFieldUpdater y = AtomicReferenceFieldUpdater.newUpdater(o80.class, Object.class, "_queue");
    public static final /* synthetic */ AtomicReferenceFieldUpdater z = AtomicReferenceFieldUpdater.newUpdater(o80.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public static final boolean E(o80 o80Var) {
        return o80Var._isCompleted;
    }

    public void F(Runnable runnable) {
        if (!J(runnable)) {
            LV.A.F(runnable);
            return;
        }
        Thread threadS = s();
        if (Thread.currentThread() != threadS) {
            LockSupport.unpark(threadS);
        }
    }

    public final boolean J(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this._isCompleted != 0) {
                return false;
            }
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = y;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        break;
                    }
                }
                return true;
            }
            if (!(obj instanceof SI0)) {
                if (obj == q80.b) {
                    return false;
                }
                SI0 si0 = new SI0(8, true);
                si0.a((Runnable) obj);
                si0.a(runnable);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = y;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, si0)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
                return true;
            }
            SI0 si02 = (SI0) obj;
            int iA = si02.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = y;
                SI0 si0E = si02.e();
                while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj, si0E) && atomicReferenceFieldUpdater3.get(this) == obj) {
                }
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final boolean M() {
        C0792hf c0792hf = this.w;
        if (!(c0792hf == null || c0792hf.b == c0792hf.c)) {
            return false;
        }
        n80 n80Var = (n80) this._delayed;
        if (n80Var != null && !n80Var.b()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof SI0) {
                return ((SI0) obj).d();
            }
            if (obj != q80.b) {
                return false;
            }
        }
        return true;
    }

    public final void O() {
        this._queue = null;
        this._delayed = null;
    }

    public final void P(long j, m80 m80Var) {
        int iA;
        Thread threadS;
        if (this._isCompleted != 0) {
            iA = 1;
        } else {
            n80 n80Var = (n80) this._delayed;
            if (n80Var == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = z;
                n80 n80Var2 = new n80();
                n80Var2.b = j;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, n80Var2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                n80Var = (n80) this._delayed;
            }
            iA = m80Var.a(j, n80Var, this);
        }
        if (iA != 0) {
            if (iA == 1) {
                C(j, m80Var);
                return;
            } else {
                if (iA != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        n80 n80Var3 = (n80) this._delayed;
        if (n80Var3 != null) {
            synchronized (n80Var3) {
                m80[] m80VarArr = n80Var3.a;
                m80Var = m80VarArr != null ? m80VarArr[0] : null;
            }
        }
        if (m80Var != m80Var || Thread.currentThread() == (threadS = s())) {
            return;
        }
        LockSupport.unpark(threadS);
    }

    public L00 b(long j, RunnableC0853ia2 runnableC0853ia2, InterfaceC0577eO interfaceC0577eO) {
        return MV.a.b(j, runnableC0853ia2, interfaceC0577eO);
    }

    @Override // defpackage.AbstractC0771hO
    public final void c(InterfaceC0577eO interfaceC0577eO, Runnable runnable) {
        F(runnable);
    }

    @Override // defpackage.p80
    public void shutdown() {
        m80 m80VarD;
        W82.a.set(null);
        this._isCompleted = 1;
        loop0: while (true) {
            Object obj = this._queue;
            eT1 et1 = q80.b;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = y;
            if (obj != null) {
                if (!(obj instanceof SI0)) {
                    if (obj != et1) {
                        SI0 si0 = new SI0(8, true);
                        si0.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, si0)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((SI0) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, et1)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (y() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            n80 n80Var = (n80) this._delayed;
            if (n80Var == null || (m80VarD = n80Var.d()) == null) {
                return;
            } else {
                C(jNanoTime, m80VarD);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004b, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00c3  */
    @Override // defpackage.p80
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long y() {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o80.y():long");
    }
}
