package defpackage;

import J.N;
import org.chromium.base.EarlyTraceEvent;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: wA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1654wA0 implements Runnable {
    public final /* synthetic */ RunnableC1713xA0 t;

    public RunnableC1654wA0(RunnableC1713xA0 runnableC1713xA0) {
        this.t = runnableC1713xA0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TraceEvent traceEvent = (EarlyTraceEvent.d() || TraceEvent.u) ? new TraceEvent(this.t.u.a) : null;
        try {
            RunnableC1713xA0 runnableC1713xA0 = this.t;
            C1542uA0 c1542uA0 = runnableC1713xA0.x;
            C1597vA0 c1597vA0E = c1542uA0 == null ? runnableC1713xA0.t.e(runnableC1713xA0.u, -1L) : runnableC1713xA0.t.e(runnableC1713xA0.u, c1542uA0.a);
            long[] jArr = c1597vA0E.a;
            if (jArr.length == 0) {
                TraceEvent.d("no metrics");
                if (traceEvent != null) {
                    traceEvent.close();
                    return;
                }
                return;
            }
            long j = jArr[0] / 1000000;
            long j2 = jArr[jArr.length - 1] / 1000000;
            long[] jArr2 = c1597vA0E.b;
            N._V_IJJOO(0, this.t.u.a, j, (j2 - j) + (jArr2[jArr2.length - 1] / 1000000), jArr2, c1597vA0E.c);
            if (traceEvent != null) {
                traceEvent.close();
            }
        } catch (Throwable th) {
            if (traceEvent != null) {
                try {
                    traceEvent.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
