package defpackage;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: og, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1230og {
    public FH0 a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public Executor f;
    public volatile RunnableC1164ng g;
    public volatile RunnableC1164ng h;

    public final void a() {
        if (this.g != null) {
            boolean z = this.b;
            if (!z) {
                if (z) {
                    c();
                } else {
                    this.e = true;
                }
            }
            if (this.h != null) {
                this.g.getClass();
                this.g = null;
                return;
            }
            this.g.getClass();
            RunnableC1164ng runnableC1164ng = this.g;
            runnableC1164ng.v.set(true);
            if (runnableC1164ng.t.cancel(false)) {
                this.h = this.g;
            }
            this.g = null;
        }
    }

    public final void b() {
        if (this.h != null || this.g == null) {
            return;
        }
        this.g.getClass();
        if (this.f == null) {
            this.f = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        RunnableC1164ng runnableC1164ng = this.g;
        Executor executor = this.f;
        if (runnableC1164ng.u == 1) {
            runnableC1164ng.u = 2;
            executor.execute(runnableC1164ng.t);
            return;
        }
        int iB = aM1.b(runnableC1164ng.u);
        if (iB == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (iB == 2) {
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        throw new IllegalStateException("We should never reach this state");
    }

    public final void c() {
        a();
        this.g = new RunnableC1164ng(this);
        b();
    }

    public abstract void d();

    public abstract void e();

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" id=0}");
        return sb.toString();
    }
}
