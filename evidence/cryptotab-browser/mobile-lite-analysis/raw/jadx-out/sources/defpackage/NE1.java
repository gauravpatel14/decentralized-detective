package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NE1 implements Executor {
    public final ArrayDeque t = new ArrayDeque();
    public Runnable u;

    public final synchronized void a() {
        Runnable runnable = (Runnable) this.t.poll();
        this.u = runnable;
        if (runnable != null) {
            ExecutorC0859ig executorC0859ig = AbstractC1103mg.e;
            PostTask.c(1, runnable);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(final Runnable runnable) {
        this.t.offer(new Runnable() { // from class: ME1
            @Override // java.lang.Runnable
            public final void run() {
                Runnable runnable2 = runnable;
                NE1 ne1 = this.t;
                ne1.getClass();
                try {
                    runnable2.run();
                } finally {
                    ne1.a();
                }
            }
        });
        if (this.u == null) {
            a();
        }
    }
}
