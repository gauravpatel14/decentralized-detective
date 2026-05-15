package defpackage;

import android.os.Handler;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: xA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1713xA0 implements Runnable {
    public final dj0 t;
    public final BA0 u;
    public final boolean v;
    public final Handler w;
    public final C1542uA0 x;

    public RunnableC1713xA0(dj0 dj0Var, BA0 ba0, boolean z, Handler handler, C1542uA0 c1542uA0) {
        this.t = dj0Var;
        this.u = ba0;
        this.v = z;
        this.w = handler;
        this.x = c1542uA0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.v;
        String string = Boolean.toString(z);
        BA0 ba0 = this.u;
        TraceEvent traceEventJ = TraceEvent.j("StartingOrStoppingJankScenario", "StartingScenario:" + string + ",Scenario:" + Integer.toString(ba0.a));
        dj0 dj0Var = this.t;
        try {
            if (z) {
                if (dj0Var == null) {
                    TraceEvent.d("StartTrackingScenario metrics store null");
                    if (traceEventJ != null) {
                        traceEventJ.close();
                        return;
                    }
                    return;
                }
                dj0Var.d(ba0);
                if (traceEventJ != null) {
                    traceEventJ.close();
                    return;
                }
                return;
            }
            C1542uA0 c1542uA0 = this.x;
            if (c1542uA0 != null) {
                long j = c1542uA0.a;
                dj0Var.getClass();
                int i = AbstractC1872zv.a;
                if (dj0Var.a > j) {
                    new RunnableC1654wA0(this).run();
                } else {
                    this.w.postDelayed(new RunnableC1654wA0(this), 100L);
                }
            } else {
                new RunnableC1654wA0(this).run();
            }
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
    }
}
