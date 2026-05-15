package defpackage;

import android.os.Binder;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;
import org.chromium.base.task.PostTask;

/* JADX INFO: renamed from: mg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1103mg {
    public static final ExecutorC0859ig e = new ExecutorC0859ig();
    public static final NE1 f = new NE1();
    public static final RejectedExecutionHandlerC1041lg g = new RejectedExecutionHandlerC1041lg();
    public final C0980kg a;
    public volatile int b = 0;
    public final AtomicBoolean c = new AtomicBoolean();
    public final AtomicBoolean d = new AtomicBoolean();

    /* JADX WARN: Type inference failed for: r0v4, types: [gg] */
    public AbstractC1103mg() {
        Object obj = PostTask.a;
        this.a = new C0980kg(this, new Callable() { // from class: gg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object objB;
                AbstractC1103mg abstractC1103mg = this.a;
                abstractC1103mg.d.set(true);
                try {
                    objB = abstractC1103mg.b();
                    try {
                        Binder.flushPendingCommands();
                        return objB;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            abstractC1103mg.c.set(true);
                            throw th;
                        } finally {
                            abstractC1103mg.m(objB);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objB = null;
                }
            }
        });
    }

    public final boolean a(boolean z) {
        this.c.set(true);
        return this.a.cancel(z);
    }

    public abstract Object b();

    public final void c(Executor executor) {
        f();
        executor.execute(this.a);
    }

    public final void d(U62 u62) {
        f();
        ((X62) u62).f(this.a);
    }

    public final void e(int i) {
        f();
        PostTask.c(i, this.a);
    }

    public final void f() {
        if (this.b != 0) {
            int i = this.b;
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.b = 1;
        l();
    }

    public final Object g() {
        String str;
        int i = (this.b != 1 || this.d.get()) ? this.b : 0;
        C0980kg c0980kg = this.a;
        if (i == 2 || !ThreadUtils.f()) {
            return c0980kg.get();
        }
        Gr1.h(i, 3, "Android.Jank.AsyncTaskGetOnUiThreadStatus");
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        if (stackTrace.length > 1) {
            str = stackTrace[1].getClassName() + "." + stackTrace[1].getMethodName() + ".";
        } else {
            str = "";
        }
        TraceEvent traceEventJ = TraceEvent.j(str + "AsyncTask.get", null);
        try {
            Object obj = c0980kg.get();
            if (traceEventJ == null) {
                return obj;
            }
            traceEventJ.close();
            return obj;
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    public final Object h(long j, TimeUnit timeUnit) {
        String str;
        int i = (this.b != 1 || this.d.get()) ? this.b : 0;
        C0980kg c0980kg = this.a;
        if (i == 2 || !ThreadUtils.f()) {
            return c0980kg.get(j, timeUnit);
        }
        Gr1.h(i, 3, "Android.Jank.AsyncTaskGetOnUiThreadStatus");
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        if (stackTrace.length > 1) {
            str = stackTrace[1].getClassName() + "." + stackTrace[1].getMethodName() + ".";
        } else {
            str = "";
        }
        TraceEvent traceEventJ = TraceEvent.j(str + "AsyncTask.get", null);
        try {
            Object obj = c0980kg.get(j, timeUnit);
            if (traceEventJ == null) {
                return obj;
            }
            traceEventJ.close();
            return obj;
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    public void j(Object obj) {
        i();
    }

    public abstract void k(Object obj);

    public final void m(final Object obj) {
        if (this instanceof AbstractC1408rm) {
            this.b = 2;
        } else {
            Object obj2 = PostTask.a;
            ThreadUtils.d(new Runnable() { // from class: jg
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC1103mg abstractC1103mg = this.t;
                    Object obj3 = obj;
                    if (abstractC1103mg.c.get()) {
                        abstractC1103mg.j(obj3);
                    } else {
                        abstractC1103mg.k(obj3);
                    }
                    abstractC1103mg.b = 2;
                }
            });
        }
    }

    public void i() {
    }

    public void l() {
    }
}
