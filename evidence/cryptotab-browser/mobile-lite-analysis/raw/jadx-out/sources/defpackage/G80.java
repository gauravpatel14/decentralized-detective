package defpackage;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class G80 extends F80 implements DW {
    public final Executor u;

    public G80(Executor executor) {
        Method method;
        this.u = executor;
        Method method2 = cJ.a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor != null && (method = cJ.a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // defpackage.DW
    public final L00 b(long j, RunnableC0853ia2 runnableC0853ia2, InterfaceC0577eO interfaceC0577eO) {
        Executor executor = this.u;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnableC0853ia2, j, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                RA0 ra0 = (RA0) interfaceC0577eO.l(QA0.t);
                if (ra0 != null) {
                    ((YA0) ra0).g(cancellationException);
                }
            }
        }
        return scheduledFutureSchedule != null ? new K00(scheduledFutureSchedule) : LV.A.b(j, runnableC0853ia2, interfaceC0577eO);
    }

    @Override // defpackage.AbstractC0771hO
    public final void c(InterfaceC0577eO interfaceC0577eO, Runnable runnable) {
        try {
            this.u.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            RA0 ra0 = (RA0) interfaceC0577eO.l(QA0.t);
            if (ra0 != null) {
                ((YA0) ra0).g(cancellationException);
            }
            j00.b.c(interfaceC0577eO, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.u;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof G80) && ((G80) obj).u == this.u;
    }

    public final int hashCode() {
        return System.identityHashCode(this.u);
    }

    @Override // defpackage.F80
    public final Executor k() {
        return this.u;
    }

    @Override // defpackage.AbstractC0771hO
    public final String toString() {
        return this.u.toString();
    }
}
