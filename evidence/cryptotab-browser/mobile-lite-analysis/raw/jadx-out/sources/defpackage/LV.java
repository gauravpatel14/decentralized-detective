package defpackage;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LV extends o80 implements Runnable {
    public static final LV A;
    public static final long B;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l;
        LV lv = new LV();
        A = lv;
        lv.t(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        B = timeUnit.toNanos(l.longValue());
    }

    @Override // defpackage.p80
    public final void C(long j, m80 m80Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // defpackage.o80
    public final void F(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.F(runnable);
    }

    public final synchronized void R() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            O();
            notifyAll();
        }
    }

    @Override // defpackage.o80, defpackage.DW
    public final L00 b(long j, RunnableC0853ia2 runnableC0853ia2, InterfaceC0577eO interfaceC0577eO) {
        long j2 = j > 0 ? j >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j : 0L;
        if (j2 >= 4611686018427387903L) {
            return C1123n01.t;
        }
        long jNanoTime = System.nanoTime();
        C1003l80 c1003l80 = new C1003l80(j2 + jNanoTime, runnableC0853ia2);
        P(jNanoTime, c1003l80);
        return c1003l80;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0072, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r14 = this;
            java.lang.ThreadLocal r0 = defpackage.W82.a
            r0.set(r14)
            r0 = 0
            monitor-enter(r14)     // Catch: java.lang.Throwable -> L37
            int r1 = defpackage.LV.debugStatus     // Catch: java.lang.Throwable -> L73
            r2 = 2
            if (r1 == r2) goto L75
            r3 = 3
            if (r1 != r3) goto L11
            goto L75
        L11:
            r1 = 1
            defpackage.LV.debugStatus = r1     // Catch: java.lang.Throwable -> L73
            r14.notifyAll()     // Catch: java.lang.Throwable -> L73
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L37
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = r4
        L1e:
            java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L37
            long r8 = r14.y()     // Catch: java.lang.Throwable -> L37
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            r10 = 0
            if (r1 != 0) goto L54
            long r12 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L37
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L39
            long r6 = defpackage.LV.B     // Catch: java.lang.Throwable -> L37
            long r6 = r6 + r12
            goto L39
        L37:
            r1 = move-exception
            goto L87
        L39:
            long r12 = r6 - r12
            int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r1 > 0) goto L4e
            defpackage.LV._thread = r0
            r14.R()
            boolean r0 = r14.M()
            if (r0 != 0) goto L4d
            r14.s()
        L4d:
            return
        L4e:
            int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r1 <= 0) goto L55
            r8 = r12
            goto L55
        L54:
            r6 = r4
        L55:
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 <= 0) goto L1e
            int r1 = defpackage.LV.debugStatus     // Catch: java.lang.Throwable -> L37
            if (r1 == r2) goto L64
            if (r1 != r3) goto L60
            goto L64
        L60:
            java.util.concurrent.locks.LockSupport.parkNanos(r14, r8)     // Catch: java.lang.Throwable -> L37
            goto L1e
        L64:
            defpackage.LV._thread = r0
            r14.R()
            boolean r0 = r14.M()
            if (r0 != 0) goto L72
            r14.s()
        L72:
            return
        L73:
            r1 = move-exception
            goto L85
        L75:
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L37
            defpackage.LV._thread = r0
            r14.R()
            boolean r0 = r14.M()
            if (r0 != 0) goto L84
            r14.s()
        L84:
            return
        L85:
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L73
            throw r1     // Catch: java.lang.Throwable -> L37
        L87:
            defpackage.LV._thread = r0
            r14.R()
            boolean r0 = r14.M()
            if (r0 != 0) goto L95
            r14.s()
        L95:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.LV.run():void");
    }

    @Override // defpackage.p80
    public final Thread s() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    @Override // defpackage.o80, defpackage.p80
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
