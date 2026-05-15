package defpackage;

import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.FrameMetrics;
import android.view.Window;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class cj0 implements Window.OnFrameMetricsAvailableListener {
    public final dj0 a;
    public final AtomicBoolean b;
    public long c;

    public cj0(dj0 dj0Var) {
        bj0 bj0Var = new bj0(this);
        this.b = new AtomicBoolean(false);
        this.a = dj0Var;
        ((DisplayManager) AbstractC1499tM.a.getSystemService("display")).registerDisplayListener(bj0Var, null);
        a();
    }

    public final void a() {
        Display display = ((DisplayManager) AbstractC1499tM.a.getSystemService("display")).getDisplay(0);
        if (display == null) {
            return;
        }
        long refreshRate = 1000000 / ((long) display.getRefreshRate());
        this.c = refreshRate;
        TraceEvent.e("FrameMetricsListener.maybeUpdateRefreshRate", Long.toString(refreshRate));
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
        int i2;
        if (this.b.get()) {
            long metric = frameMetrics.getMetric(8);
            long metric2 = frameMetrics.getMetric(11);
            TraceEvent traceEventJ = TraceEvent.j("onFrameMetricsAvailable", Long.toString(metric));
            try {
                long metric3 = frameMetrics.getMetric(13);
                if (metric >= metric3) {
                    long j = this.c;
                    i2 = (int) ((((metric - metric3) / 1000) + j) / j);
                } else {
                    i2 = 0;
                }
                dj0 dj0Var = this.a;
                dj0Var.getClass();
                int i3 = AbstractC1872zv.a;
                dj0Var.c.add(Long.valueOf(metric));
                dj0Var.d.add(Integer.valueOf(i2));
                dj0Var.b.add(Long.valueOf(metric2));
                dj0Var.a = metric2;
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
}
