package defpackage;

import android.os.StrictMode;
import java.io.Closeable;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LP1 implements Closeable {
    public final StrictMode.ThreadPolicy t;
    public final StrictMode.VmPolicy u;

    public LP1(StrictMode.ThreadPolicy threadPolicy, StrictMode.VmPolicy vmPolicy) {
        TraceEvent.k(hashCode(), "StrictModeContext");
        this.t = threadPolicy;
        this.u = vmPolicy;
    }

    public static LP1 a() {
        TraceEvent traceEventJ = TraceEvent.j("StrictModeContext.allowAllThreadPolicies", null);
        try {
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            LP1 lp1 = new LP1(threadPolicy, null);
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return lp1;
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

    public static LP1 b() {
        TraceEvent traceEventJ = TraceEvent.j("StrictModeContext.allowAllVmPolicies", null);
        try {
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
            LP1 lp1 = new LP1(null, vmPolicy);
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return lp1;
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

    public static LP1 c() {
        TraceEvent traceEventJ = TraceEvent.j("StrictModeContext.allowDiskReads", null);
        try {
            LP1 lp1 = new LP1(StrictMode.allowThreadDiskReads(), null);
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return lp1;
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

    public static LP1 d() {
        TraceEvent traceEventJ = TraceEvent.j("StrictModeContext.allowDiskWrites", null);
        try {
            LP1 lp1 = new LP1(StrictMode.allowThreadDiskWrites(), null);
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return lp1;
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        StrictMode.ThreadPolicy threadPolicy = this.t;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        StrictMode.VmPolicy vmPolicy = this.u;
        if (vmPolicy != null) {
            StrictMode.setVmPolicy(vmPolicy);
        }
        TraceEvent.c(hashCode(), "StrictModeContext");
    }
}
