package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: zX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1853zX2 implements r13 {
    public final Executor a;
    public final Object b = new Object();
    public Q41 c;

    public C1853zX2(Executor executor, Q41 q41) {
        this.a = executor;
        this.c = q41;
    }

    @Override // defpackage.r13
    public final void b(G62 g62) {
        if (g62.k() || ((C0939k33) g62).d) {
            return;
        }
        synchronized (this.b) {
            try {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new RunnableC0715gW2(this, g62));
            } catch (Throwable th) {
                throw th;
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
