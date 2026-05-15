package defpackage;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: ef2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0598ef2 extends C0542df2 implements MessageQueue.IdleHandler {
    public long b;
    public long c;
    public int d;
    public int e;
    public int f;
    public boolean g;

    @Override // defpackage.C0542df2
    public final void a(String str) {
        if (this.f == 0) {
            TraceEvent.b("Looper.queueIdle");
        }
        this.c = SystemClock.elapsedRealtime();
        c();
        super.a(str);
    }

    @Override // defpackage.C0542df2
    public final void b(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        if (jElapsedRealtime > 16) {
            String str2 = "observed a task that took " + jElapsedRealtime + "ms: " + str;
            TraceEvent.e("TraceEvent.LooperMonitor:IdleStats", str2);
            Log.println(5, "TraceEvt_LooperMonitor", str2);
        }
        super.b(str);
        c();
        this.d++;
        this.f++;
    }

    public final void c() {
        if (TraceEvent.u && !this.g) {
            this.b = SystemClock.elapsedRealtime();
            Looper.myQueue().addIdleHandler(this);
            this.g = true;
        } else {
            if (!this.g || TraceEvent.u) {
                return;
            }
            Looper.myQueue().removeIdleHandler(this);
            this.g = false;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.b == 0) {
            this.b = jElapsedRealtime;
        }
        long j = jElapsedRealtime - this.b;
        this.e++;
        TraceEvent.a("Looper.queueIdle", this.f + " tasks since last idle.");
        if (j > 48) {
            String str = this.d + " tasks and " + this.e + " idles processed so far, " + this.f + " tasks bursted and " + j + "ms elapsed since last idle";
            TraceEvent.e("TraceEvent.LooperMonitor:IdleStats", str);
            Log.println(3, "TraceEvt_LooperMonitor", str);
        }
        this.b = jElapsedRealtime;
        this.f = 0;
        return true;
    }
}
