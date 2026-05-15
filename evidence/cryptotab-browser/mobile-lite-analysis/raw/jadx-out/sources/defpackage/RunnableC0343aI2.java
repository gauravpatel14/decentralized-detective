package defpackage;

import com.google.android.gms.tasks.RuntimeExecutionException;

/* JADX INFO: renamed from: aI2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0343aI2 implements Runnable {
    public final /* synthetic */ G62 t;
    public final /* synthetic */ BK2 u;

    public RunnableC0343aI2(BK2 bk2, G62 g62) {
        this.u = bk2;
        this.t = g62;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (((C0939k33) this.t).d) {
            this.u.c.q();
            return;
        }
        try {
            this.u.c.p(this.u.b.a(this.t));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.u.c.o((Exception) e.getCause());
            } else {
                this.u.c.o(e);
            }
        } catch (Exception e2) {
            this.u.c.o(e2);
        }
    }
}
