package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RY2 implements r13 {
    public final Executor a;
    public final Object b = new Object();
    public U41 c;

    public RY2(Executor executor, U41 u41) {
        this.a = executor;
        this.c = u41;
    }

    @Override // defpackage.r13
    public final void b(G62 g62) {
        if (g62.k()) {
            synchronized (this.b) {
                try {
                    if (this.c == null) {
                        return;
                    }
                    this.a.execute(new RunnableC0971kY2(this, g62));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // defpackage.r13
    public final void zzc() {
        synchronized (this.b) {
            this.c = null;
        }
    }
}
