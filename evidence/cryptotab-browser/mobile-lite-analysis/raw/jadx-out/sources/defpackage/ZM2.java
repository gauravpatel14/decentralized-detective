package defpackage;

import com.google.android.gms.tasks.RuntimeExecutionException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZM2 implements Runnable {
    public final /* synthetic */ G62 t;
    public final /* synthetic */ FO2 u;

    public ZM2(FO2 fo2, G62 g62) {
        this.u = fo2;
        this.t = g62;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FO2 fo2 = this.u;
        try {
            G62 g62 = (G62) fo2.b.a(this.t);
            if (g62 == null) {
                fo2.d(new NullPointerException("Continuation returned null"));
                return;
            }
            ExecutorC1709x23 executorC1709x23 = K62.b;
            g62.e(executorC1709x23, fo2);
            g62.c(executorC1709x23, fo2);
            C0939k33 c0939k33 = (C0939k33) g62;
            c0939k33.b.a(new C1332qS2(executorC1709x23, fo2));
            c0939k33.s();
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                fo2.c.o((Exception) e.getCause());
            } else {
                fo2.c.o(e);
            }
        } catch (Exception e2) {
            fo2.c.o(e2);
        }
    }
}
