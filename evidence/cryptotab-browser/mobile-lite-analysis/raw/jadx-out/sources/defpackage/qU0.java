package defpackage;

import android.util.Log;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class qU0 extends FutureTask {
    public final /* synthetic */ RunnableC1164ng t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qU0(RunnableC1164ng runnableC1164ng, pU0 pu0) {
        super(pu0);
        this.t = runnableC1164ng;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        RunnableC1164ng runnableC1164ng = this.t;
        try {
            Object obj = get();
            if (runnableC1164ng.w.get()) {
                return;
            }
            runnableC1164ng.a(obj);
        } catch (InterruptedException e) {
            Log.w("AsyncTask", e);
        } catch (CancellationException unused) {
            if (runnableC1164ng.w.get()) {
                return;
            }
            runnableC1164ng.a(null);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occurred while executing doInBackground()", th);
        }
    }
}
