package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Y62 {
    public static Object a(G62 g62) throws InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotGoogleApiHandlerThread();
        Preconditions.checkNotNull(g62, "Task must not be null");
        if (g62.j()) {
            return f(g62);
        }
        JC2 jc2 = new JC2();
        ExecutorC1709x23 executorC1709x23 = K62.b;
        g62.e(executorC1709x23, jc2);
        g62.c(executorC1709x23, jc2);
        C0939k33 c0939k33 = (C0939k33) g62;
        c0939k33.b.a(new C1332qS2(executorC1709x23, jc2));
        c0939k33.s();
        jc2.a.await();
        return f(g62);
    }

    public static Object b(G62 g62, long j, TimeUnit timeUnit) throws TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotGoogleApiHandlerThread();
        Preconditions.checkNotNull(g62, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (g62.j()) {
            return f(g62);
        }
        JC2 jc2 = new JC2();
        ExecutorC1709x23 executorC1709x23 = K62.b;
        g62.e(executorC1709x23, jc2);
        g62.c(executorC1709x23, jc2);
        C0939k33 c0939k33 = (C0939k33) g62;
        c0939k33.b.a(new C1332qS2(executorC1709x23, jc2));
        c0939k33.s();
        if (jc2.a.await(j, timeUnit)) {
            return f(g62);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static C0939k33 c(Executor executor, Callable callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        C0939k33 c0939k33 = new C0939k33();
        executor.execute(new Q33(c0939k33, callable));
        return c0939k33;
    }

    public static C0939k33 d(Exception exc) {
        C0939k33 c0939k33 = new C0939k33();
        c0939k33.o(exc);
        return c0939k33;
    }

    public static C0939k33 e(Object obj) {
        C0939k33 c0939k33 = new C0939k33();
        c0939k33.p(obj);
        return c0939k33;
    }

    public static Object f(G62 g62) throws ExecutionException {
        if (g62.k()) {
            return g62.h();
        }
        if (((C0939k33) g62).d) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(g62.g());
    }
}
