package defpackage;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mO implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    volatile /* synthetic */ long controlState;
    private volatile /* synthetic */ long parkedWorkersStack;
    public final int t;
    public final int u;
    public final long v;
    public final C0800hm0 w;
    public final C0800hm0 x;
    public final Vu1 y;
    public static final eT1 C = new eT1("NOT_IN_STACK");
    public static final /* synthetic */ AtomicLongFieldUpdater z = AtomicLongFieldUpdater.newUpdater(mO.class, "parkedWorkersStack");
    public static final /* synthetic */ AtomicLongFieldUpdater A = AtomicLongFieldUpdater.newUpdater(mO.class, "controlState");
    public static final /* synthetic */ AtomicIntegerFieldUpdater B = AtomicIntegerFieldUpdater.newUpdater(mO.class, "_isTerminated");

    public mO(int i, int i2, long j) {
        this.t = i;
        this.u = i2;
        this.v = j;
        if (i < 1) {
            throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(Vx1.a(i2, i, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.w = new C0800hm0();
        this.x = new C0800hm0();
        this.parkedWorkersStack = 0L;
        this.y = new Vu1(i + 1);
        this.controlState = ((long) i) << 42;
        this._isTerminated = 0;
    }

    public final int a() {
        synchronized (this.y) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            int i2 = i - ((int) ((j & 4398044413952L) >> 21));
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 >= this.t) {
                return 0;
            }
            if (i >= this.u) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 <= 0 || this.y.b(i3) != null) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            lO lOVar = new lO(this, i3);
            this.y.c(i3, lOVar);
            if (i3 != ((int) (2097151 & A.incrementAndGet(this)))) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            lOVar.start();
            return i2 + 1;
        }
    }

    public final void b(Runnable runnable, I62 i62, boolean z2) {
        F62 l62;
        int i;
        Z62.e.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof F62) {
            l62 = (F62) runnable;
            l62.t = jNanoTime;
            l62.u = i62;
        } else {
            l62 = new L62(runnable, jNanoTime, i62);
        }
        Thread threadCurrentThread = Thread.currentThread();
        F62 f62A = null;
        lO lOVar = threadCurrentThread instanceof lO ? (lO) threadCurrentThread : null;
        if (lOVar == null || !lz0.a(lOVar.z, this)) {
            lOVar = null;
        }
        if (lOVar == null || (i = lOVar.u) == 5 || (l62.u.a == 0 && i == 2)) {
            f62A = l62;
        } else {
            lOVar.y = true;
            C1873zw2 c1873zw2 = lOVar.t;
            if (z2) {
                f62A = c1873zw2.a(l62);
            } else {
                c1873zw2.getClass();
                F62 f62 = (F62) C1873zw2.b.getAndSet(c1873zw2, l62);
                if (f62 != null) {
                    f62A = c1873zw2.a(f62);
                }
            }
        }
        if (f62A != null) {
            if (!(f62A.u.a == 1 ? this.x.a(f62A) : this.w.a(f62A))) {
                throw new RejectedExecutionException("DefaultDispatcher was terminated");
            }
        }
        boolean z3 = z2 && lOVar != null;
        if (l62.u.a == 0) {
            if (z3 || j() || e(this.controlState)) {
                return;
            }
            j();
            return;
        }
        long jAddAndGet = A.addAndGet(this, 2097152L);
        if (z3 || j() || e(jAddAndGet)) {
            return;
        }
        j();
    }

    public final void c(lO lOVar) {
        long j;
        int iB;
        if (lOVar.c() != C) {
            return;
        }
        do {
            j = this.parkedWorkersStack;
            iB = lOVar.b();
            lOVar.g(this.y.b((int) (2097151 & j)));
        } while (!z.compareAndSet(this, j, iB | ((2097152 + j) & (-2097152))));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = defpackage.mO.B
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lc
            goto La2
        Lc:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof defpackage.lO
            r3 = 0
            if (r1 == 0) goto L18
            lO r0 = (defpackage.lO) r0
            goto L19
        L18:
            r0 = r3
        L19:
            if (r0 == 0) goto L24
            mO r1 = r0.z
            boolean r1 = defpackage.lz0.a(r1, r8)
            if (r1 == 0) goto L24
            goto L25
        L24:
            r0 = r3
        L25:
            Vu1 r1 = r8.y
            monitor-enter(r1)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lb4
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L70
            r1 = r2
        L33:
            Vu1 r5 = r8.y
            java.lang.Object r5 = r5.b(r1)
            lO r5 = (defpackage.lO) r5
            if (r5 == r0) goto L6b
        L3d:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L4c
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L3d
        L4c:
            zw2 r5 = r5.t
            hm0 r6 = r8.x
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = defpackage.C1873zw2.b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            F62 r7 = (defpackage.F62) r7
            if (r7 == 0) goto L60
            r6.a(r7)
        L60:
            F62 r7 = r5.c()
            if (r7 != 0) goto L67
            goto L6b
        L67:
            r6.a(r7)
            goto L60
        L6b:
            if (r1 == r4) goto L70
            int r1 = r1 + 1
            goto L33
        L70:
            hm0 r1 = r8.x
            r1.b()
            hm0 r1 = r8.w
            r1.b()
        L7a:
            if (r0 == 0) goto L82
            F62 r1 = r0.a(r2)
            if (r1 != 0) goto La3
        L82:
            hm0 r1 = r8.w
            java.lang.Object r1 = r1.d()
            F62 r1 = (defpackage.F62) r1
            if (r1 != 0) goto La3
            hm0 r1 = r8.x
            java.lang.Object r1 = r1.d()
            F62 r1 = (defpackage.F62) r1
            if (r1 != 0) goto La3
            if (r0 == 0) goto L9c
            r1 = 5
            r0.h(r1)
        L9c:
            r0 = 0
            r8.parkedWorkersStack = r0
            r8.controlState = r0
        La2:
            return
        La3:
            r1.run()     // Catch: java.lang.Throwable -> La7
            goto L7a
        La7:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L7a
        Lb4:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mO.close():void");
    }

    public final void d(lO lOVar, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    Object objC = lOVar.c();
                    while (true) {
                        if (objC == C) {
                            i3 = -1;
                            break;
                        }
                        if (objC == null) {
                            i3 = 0;
                            break;
                        }
                        lO lOVar2 = (lO) objC;
                        int iB = lOVar2.b();
                        if (iB != 0) {
                            i3 = iB;
                            break;
                        }
                        objC = lOVar2.c();
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                if (z.compareAndSet(this, j, j2 | ((long) i3))) {
                    return;
                }
            }
        }
    }

    public final boolean e(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.t;
        if (i < i2) {
            int iA = a();
            if (iA == 1 && i2 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable, Z62.f, false);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean j() {
        eT1 et1;
        int iB;
        while (true) {
            long j = this.parkedWorkersStack;
            lO lOVar = (lO) this.y.b((int) (2097151 & j));
            if (lOVar == null) {
                lOVar = null;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object objC = lOVar.c();
                while (true) {
                    et1 = C;
                    if (objC == et1) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    lO lOVar2 = (lO) objC;
                    iB = lOVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = lOVar2.c();
                }
                if (iB >= 0) {
                    if (z.compareAndSet(this, j, ((long) iB) | j2)) {
                        lOVar.g(et1);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (lOVar == null) {
                return false;
            }
            if (lO.A.compareAndSet(lOVar, -1, 0)) {
                LockSupport.unpark(lOVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.y.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iA; i6++) {
            lO lOVar = (lO) this.y.b(i6);
            if (lOVar != null) {
                int iB = lOVar.t.b();
                int iB2 = aM1.b(lOVar.u);
                if (iB2 == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iB);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iB2 == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iB);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iB2 == 2) {
                    i3++;
                } else if (iB2 == 3) {
                    i4++;
                    if (iB > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iB);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iB2 == 4) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        return "DefaultDispatcher@" + hV.a(this) + "[Pool Size {core = " + this.t + ", max = " + this.u + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.w.c() + ", global blocking queue size = " + this.x.c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.t - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }
}
