package defpackage;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class lO extends Thread {
    public static final /* synthetic */ AtomicIntegerFieldUpdater A = AtomicIntegerFieldUpdater.newUpdater(lO.class, "workerCtl");
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    public final C1873zw2 t;
    public int u;
    public long v;
    public long w;
    volatile /* synthetic */ int workerCtl;
    public int x;
    public boolean y;
    public final /* synthetic */ mO z;

    public lO(mO mOVar, int i) {
        this.z = mOVar;
        setDaemon(true);
        this.t = new C1873zw2();
        this.u = 4;
        this.workerCtl = 0;
        this.nextParkedWorker = mO.C;
        mq1.t.getClass();
        this.x = mq1.u.a().nextInt();
        f(i);
    }

    public final F62 a(boolean z) {
        F62 f62E;
        F62 f62E2;
        long j;
        F62 f62C;
        if (this.u != 1) {
            mO mOVar = this.z;
            do {
                j = mOVar.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    if (z) {
                        C1873zw2 c1873zw2 = this.t;
                        c1873zw2.getClass();
                        f62C = (F62) C1873zw2.b.getAndSet(c1873zw2, null);
                        if (f62C == null) {
                            f62C = c1873zw2.c();
                        }
                        if (f62C == null) {
                            f62C = (F62) this.z.x.d();
                        }
                    } else {
                        f62C = (F62) this.z.x.d();
                    }
                    return f62C == null ? i(true) : f62C;
                }
            } while (!mO.A.compareAndSet(mOVar, j, j - 4398046511104L));
            this.u = 1;
        }
        if (z) {
            boolean z2 = d(this.z.t * 2) == 0;
            if (z2 && (f62E2 = e()) != null) {
                return f62E2;
            }
            C1873zw2 c1873zw22 = this.t;
            c1873zw22.getClass();
            F62 f62 = (F62) C1873zw2.b.getAndSet(c1873zw22, null);
            F62 f62C2 = f62 == null ? c1873zw22.c() : f62;
            if (f62C2 != null) {
                return f62C2;
            }
            if (!z2 && (f62E = e()) != null) {
                return f62E;
            }
        } else {
            F62 f62E3 = e();
            if (f62E3 != null) {
                return f62E3;
            }
        }
        return i(false);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i2 = this.x;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.x = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i5 & i6 : (i5 & Api.BaseClientBuilder.API_PRIORITY_OTHER) % i;
    }

    public final F62 e() {
        int iD = d(2);
        mO mOVar = this.z;
        if (iD == 0) {
            F62 f62 = (F62) mOVar.w.d();
            return f62 != null ? f62 : (F62) mOVar.x.d();
        }
        F62 f622 = (F62) mOVar.x.d();
        return f622 != null ? f622 : (F62) mOVar.w.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder("DefaultDispatcher-worker-");
        this.z.getClass();
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i) {
        int i2 = this.u;
        boolean z = i2 == 1;
        if (z) {
            mO.A.addAndGet(this.z, 4398046511104L);
        }
        if (i2 != i) {
            this.u = i;
        }
        return z;
    }

    public final F62 i(boolean z) {
        long jE;
        int i = (int) (this.z.controlState & 2097151);
        if (i < 2) {
            return null;
        }
        int iD = d(i);
        mO mOVar = this.z;
        long jMin = Long.MAX_VALUE;
        for (int i2 = 0; i2 < i; i2++) {
            iD++;
            if (iD > i) {
                iD = 1;
            }
            lO lOVar = (lO) mOVar.y.b(iD);
            if (lOVar != null && lOVar != this) {
                if (z) {
                    jE = this.t.d(lOVar.t);
                } else {
                    C1873zw2 c1873zw2 = this.t;
                    C1873zw2 c1873zw22 = lOVar.t;
                    c1873zw2.getClass();
                    F62 f62C = c1873zw22.c();
                    if (f62C != null) {
                        F62 f62 = (F62) C1873zw2.b.getAndSet(c1873zw2, f62C);
                        if (f62 != null) {
                            c1873zw2.a(f62);
                        }
                        jE = -1;
                    } else {
                        jE = c1873zw2.e(c1873zw22, false);
                    }
                }
                if (jE == -1) {
                    C1873zw2 c1873zw23 = this.t;
                    c1873zw23.getClass();
                    F62 f622 = (F62) C1873zw2.b.getAndSet(c1873zw23, null);
                    return f622 == null ? c1873zw23.c() : f622;
                }
                if (jE > 0) {
                    jMin = Math.min(jMin, jE);
                }
            }
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.w = jMin;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        loop0: while (true) {
            boolean z = false;
            while (!this.z.isTerminated() && this.u != 5) {
                F62 f62A = a(this.y);
                if (f62A != null) {
                    this.w = 0L;
                    int i = f62A.u.a;
                    this.v = 0L;
                    if (this.u == 3) {
                        this.u = 2;
                    }
                    mO mOVar = this.z;
                    if (i != 0 && h(2) && !mOVar.j() && !mOVar.e(mOVar.controlState)) {
                        mOVar.j();
                    }
                    mOVar.getClass();
                    try {
                        f62A.run();
                    } catch (Throwable th) {
                        Thread threadCurrentThread = Thread.currentThread();
                        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                    }
                    if (i != 0) {
                        mO.A.addAndGet(mOVar, -2097152L);
                        if (this.u != 5) {
                            this.u = 4;
                        }
                    }
                } else {
                    this.y = false;
                    if (this.w != 0) {
                        if (z) {
                            h(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.w);
                            this.w = 0L;
                        } else {
                            z = true;
                        }
                    } else if (this.nextParkedWorker != mO.C) {
                        this.workerCtl = -1;
                        while (this.nextParkedWorker != mO.C && this.workerCtl == -1 && !this.z.isTerminated() && this.u != 5) {
                            h(3);
                            Thread.interrupted();
                            if (this.v == 0) {
                                this.v = System.nanoTime() + this.z.v;
                            }
                            LockSupport.parkNanos(this.z.v);
                            if (System.nanoTime() - this.v >= 0) {
                                this.v = 0L;
                                mO mOVar2 = this.z;
                                synchronized (mOVar2.y) {
                                    try {
                                        if (!mOVar2.isTerminated()) {
                                            if (((int) (mOVar2.controlState & 2097151)) > mOVar2.t) {
                                                if (A.compareAndSet(this, -1, 1)) {
                                                    int i2 = this.indexInArray;
                                                    f(0);
                                                    mOVar2.d(this, i2, 0);
                                                    int andDecrement = (int) (mO.A.getAndDecrement(mOVar2) & 2097151);
                                                    if (andDecrement != i2) {
                                                        lO lOVar = (lO) mOVar2.y.b(andDecrement);
                                                        mOVar2.y.c(i2, lOVar);
                                                        lOVar.f(i2);
                                                        mOVar2.d(lOVar, andDecrement, i2);
                                                    }
                                                    mOVar2.y.c(andDecrement, null);
                                                    this.u = 5;
                                                }
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        }
                    } else {
                        this.z.c(this);
                    }
                }
            }
            break loop0;
        }
        h(5);
    }
}
