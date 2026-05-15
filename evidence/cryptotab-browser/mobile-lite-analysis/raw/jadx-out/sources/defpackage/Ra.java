package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ra implements Executor {
    public final Object t = new Object();
    public final ArrayDeque u = new ArrayDeque();
    public final Sa v;
    public Runnable w;

    public Ra(Sa sa) {
        this.v = sa;
    }

    public final void a() {
        synchronized (this.t) {
            try {
                Runnable runnable = (Runnable) this.u.poll();
                this.w = runnable;
                if (runnable != null) {
                    this.v.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(final Runnable runnable) {
        synchronized (this.t) {
            try {
                this.u.add(new Runnable() { // from class: Qa
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable2 = runnable;
                        Ra ra = this.t;
                        ra.getClass();
                        try {
                            runnable2.run();
                        } finally {
                            ra.a();
                        }
                    }
                });
                if (this.w == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
