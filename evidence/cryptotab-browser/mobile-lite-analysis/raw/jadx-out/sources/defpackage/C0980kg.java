package defpackage;

import android.util.Log;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: kg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0980kg extends FutureTask {
    public final /* synthetic */ AbstractC1103mg t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0980kg(AbstractC1103mg abstractC1103mg, CallableC0728gg callableC0728gg) {
        super(callableC0728gg);
        this.t = abstractC1103mg;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        AbstractC1103mg abstractC1103mg = this.t;
        try {
            Object obj = get();
            if (abstractC1103mg.d.get()) {
                return;
            }
            abstractC1103mg.m(obj);
        } catch (InterruptedException e) {
            Log.w("cr_AsyncTask", e.toString());
        } catch (CancellationException unused) {
            if (abstractC1103mg.d.get()) {
                return;
            }
            abstractC1103mg.m(null);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
        }
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        try {
            TraceEvent traceEventJ = TraceEvent.j("AsyncTask.run: ".concat(this.t.a.t.getClass().getName()), null);
            try {
                super.run();
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
            } catch (Throwable th) {
                if (traceEventJ != null) {
                    try {
                        traceEventJ.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } finally {
            Thread.interrupted();
        }
    }
}
