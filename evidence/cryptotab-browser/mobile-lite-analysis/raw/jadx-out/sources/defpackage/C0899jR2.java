package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: jR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0899jR2 extends US2 {
    public static final AtomicLong k = new AtomicLong(Long.MIN_VALUE);
    public C0777hR2 c;
    public C0777hR2 d;
    public final PriorityBlockingQueue e;
    public final LinkedBlockingQueue f;
    public final C0472cR2 g;
    public final C0472cR2 h;
    public final Object i;
    public final Semaphore j;

    public C0899jR2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.i = new Object();
        this.j = new Semaphore(2);
        this.e = new PriorityBlockingQueue();
        this.f = new LinkedBlockingQueue();
        this.g = new C0472cR2(this, "Thread death: Uncaught exception on worker thread");
        this.h = new C0472cR2(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // defpackage.QS2
    public final void g() {
        if (Thread.currentThread() != this.c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // defpackage.US2
    public final boolean h() {
        return false;
    }

    public final void k() {
        if (Thread.currentThread() != this.d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final Object l(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            C0899jR2 c0899jR2 = this.a.j;
            C1391rR2.k(c0899jR2);
            c0899jR2.o(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                WO2 wo2 = this.a.i;
                C1391rR2.k(wo2);
                wo2.i.a("Interrupted waiting for ".concat(str));
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            WO2 wo22 = this.a.i;
            C1391rR2.k(wo22);
            wo22.i.a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final C0582eR2 m(Callable callable) {
        i();
        Preconditions.checkNotNull(callable);
        C0582eR2 c0582eR2 = new C0582eR2(this, callable, false);
        if (Thread.currentThread() == this.c) {
            if (!this.e.isEmpty()) {
                WO2 wo2 = this.a.i;
                C1391rR2.k(wo2);
                wo2.i.a("Callable skipped the worker queue.");
            }
            c0582eR2.run();
        } else {
            r(c0582eR2);
        }
        return c0582eR2;
    }

    public final void n(Runnable runnable) {
        i();
        Preconditions.checkNotNull(runnable);
        C0582eR2 c0582eR2 = new C0582eR2(this, runnable, false, "Task exception on network thread");
        synchronized (this.i) {
            try {
                this.f.add(c0582eR2);
                C0777hR2 c0777hR2 = this.d;
                if (c0777hR2 == null) {
                    C0777hR2 c0777hR22 = new C0777hR2(this, "Measurement Network", this.f);
                    this.d = c0777hR22;
                    c0777hR22.setUncaughtExceptionHandler(this.h);
                    this.d.start();
                } else {
                    synchronized (c0777hR2.t) {
                        c0777hR2.t.notifyAll();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o(Runnable runnable) {
        i();
        Preconditions.checkNotNull(runnable);
        r(new C0582eR2(this, runnable, false, "Task exception on worker thread"));
    }

    public final void p(Runnable runnable) {
        i();
        Preconditions.checkNotNull(runnable);
        r(new C0582eR2(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean q() {
        return Thread.currentThread() == this.c;
    }

    public final void r(C0582eR2 c0582eR2) {
        synchronized (this.i) {
            try {
                this.e.add(c0582eR2);
                C0777hR2 c0777hR2 = this.c;
                if (c0777hR2 == null) {
                    C0777hR2 c0777hR22 = new C0777hR2(this, "Measurement Worker", this.e);
                    this.c = c0777hR22;
                    c0777hR22.setUncaughtExceptionHandler(this.g);
                    this.c.start();
                } else {
                    synchronized (c0777hR2.t) {
                        c0777hR2.t.notifyAll();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
