package defpackage;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class N implements InterfaceFutureC1199oH0 {
    public static final boolean w = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final G x;
    public static final Object y;
    public volatile Object t;
    public volatile J u;
    public volatile M v;

    static {
        G l;
        try {
            l = new K(AtomicReferenceFieldUpdater.newUpdater(M.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(M.class, M.class, "b"), AtomicReferenceFieldUpdater.newUpdater(N.class, M.class, "v"), AtomicReferenceFieldUpdater.newUpdater(N.class, J.class, "u"), AtomicReferenceFieldUpdater.newUpdater(N.class, Object.class, "t"));
        } catch (Throwable unused) {
            l = new L();
        }
        x = l;
        y = new Object();
    }

    public static void c(N n) {
        M m;
        J j;
        J j2;
        J j3;
        do {
            m = n.v;
        } while (!x.c(n, m, M.c));
        while (true) {
            j = null;
            if (m == null) {
                break;
            }
            Thread thread = m.a;
            if (thread != null) {
                m.a = null;
                LockSupport.unpark(thread);
            }
            m = m.b;
        }
        do {
            j2 = n.u;
        } while (!x.a(n, j2, J.d));
        while (true) {
            j3 = j;
            j = j2;
            if (j == null) {
                break;
            }
            j2 = j.c;
            j.c = j3;
        }
        while (j3 != null) {
            J j4 = j3.c;
            Runnable runnable = j3.a;
            Executor executor = j3.b;
            try {
                executor.execute(runnable);
            } catch (RuntimeException unused) {
                Objects.toString(runnable);
                Objects.toString(executor);
            }
            j3 = j4;
        }
    }

    public static Object d(Object obj) throws ExecutionException {
        if (obj instanceof H) {
            CancellationException cancellationException = ((H) obj).a;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof I) {
            throw new ExecutionException(((I) obj).a);
        }
        if (obj == y) {
            return null;
        }
        return obj;
    }

    public static Object e(N n) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = n.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override // defpackage.InterfaceFutureC1199oH0
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        J j = this.u;
        J j2 = J.d;
        if (j != j2) {
            J j3 = new J(runnable, executor);
            do {
                j3.c = j;
                if (x.a(this, j, j3)) {
                    return;
                } else {
                    j = this.u;
                }
            } while (j != j2);
        }
        try {
            executor.execute(runnable);
        } catch (RuntimeException unused) {
            Objects.toString(runnable);
            Objects.toString(executor);
        }
    }

    public final void b(StringBuilder sb) {
        try {
            Object objE = e(this);
            sb.append("SUCCESS, result=[");
            sb.append(objE == this ? "this future" : String.valueOf(objE));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.t;
        if (obj != null) {
            return false;
        }
        if (!x.b(this, obj, w ? new H(z, new CancellationException("Future.cancel() was called.")) : z ? H.b : H.c)) {
            return false;
        }
        c(this);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String f() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void g(M m) {
        m.a = null;
        while (true) {
            M m2 = this.v;
            if (m2 == M.c) {
                return;
            }
            M m3 = null;
            while (m2 != null) {
                M m4 = m2.b;
                if (m2.a != null) {
                    m3 = m2;
                } else if (m3 != null) {
                    m3.b = m4;
                    if (m3.a == null) {
                        break;
                    }
                } else if (!x.c(this, m2, m4)) {
                    break;
                }
                m2 = m4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.t;
        if (obj != null) {
            return d(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            M m = this.v;
            M m2 = M.c;
            if (m != m2) {
                M m3 = new M();
                do {
                    G g = x;
                    g.d(m3, m);
                    if (g.c(this, m, m3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                g(m3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.t;
                            if (obj2 != null) {
                                return d(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        g(m3);
                    } else {
                        m = this.v;
                    }
                } while (m != m2);
            }
            return d(this.t);
        }
        while (nanos > 0) {
            Object obj3 = this.t;
            if (obj3 != null) {
                return d(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strA = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strA2 = F.a(strA, " (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strA3 = strA2 + jConvert + " " + lowerCase;
                if (z) {
                    strA3 = F.a(strA3, ",");
                }
                strA2 = F.a(strA3, " ");
            }
            if (z) {
                strA2 = strA2 + nanos2 + " nanoseconds ";
            }
            strA = F.a(strA2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(F.a(strA, " but future completed as timeout expired"));
        }
        throw new TimeoutException(F.b(strA, " for ", string));
    }

    public boolean h(Throwable th) {
        th.getClass();
        if (!x.b(this, null, new I(th))) {
            return false;
        }
        c(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.t instanceof H;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.t != null;
    }

    public final String toString() {
        String strF;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.t instanceof H) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                strF = f();
            } catch (RuntimeException e) {
                strF = "Exception thrown from implementation: " + e.getClass();
            }
            if (strF != null && !strF.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strF);
                sb.append("]");
            } else if (isDone()) {
                b(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.t;
            if (obj2 != null) {
                return d(obj2);
            }
            M m = this.v;
            M m2 = M.c;
            if (m != m2) {
                M m3 = new M();
                do {
                    G g = x;
                    g.d(m3, m);
                    if (g.c(this, m, m3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.t;
                            } else {
                                g(m3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return d(obj);
                    }
                    m = this.v;
                } while (m != m2);
            }
            return d(this.t);
        }
        throw new InterruptedException();
    }
}
