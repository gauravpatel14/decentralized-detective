package defpackage;

import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OZ2 implements Runnable {
    public final /* synthetic */ G62 t;
    public final /* synthetic */ D03 u;

    public OZ2(D03 d03, G62 g62) {
        this.u = d03;
        this.t = g62;
    }

    @Override // java.lang.Runnable
    public final void run() {
        D03 d03 = this.u;
        try {
            G62 g62Then = d03.b.then(this.t.h());
            if (g62Then == null) {
                d03.d(new NullPointerException("Continuation returned null"));
                return;
            }
            ExecutorC1709x23 executorC1709x23 = K62.b;
            g62Then.e(executorC1709x23, d03);
            g62Then.c(executorC1709x23, d03);
            C0939k33 c0939k33 = (C0939k33) g62Then;
            c0939k33.b.a(new C1332qS2(executorC1709x23, d03));
            c0939k33.s();
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                d03.d((Exception) e.getCause());
            } else {
                d03.d(e);
            }
        } catch (CancellationException unused) {
            d03.c();
        } catch (Exception e2) {
            d03.d(e2);
        }
    }
}
