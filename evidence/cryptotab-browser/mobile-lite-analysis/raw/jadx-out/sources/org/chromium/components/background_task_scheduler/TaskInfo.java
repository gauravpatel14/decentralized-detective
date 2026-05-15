package org.chromium.components.background_task_scheduler;

import android.os.PersistableBundle;
import defpackage.M62;
import defpackage.N62;
import defpackage.O62;
import defpackage.Q62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TaskInfo {
    public final int a;
    public final PersistableBundle b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final TimingInfo h;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public interface TimingInfo {
        void a(Q62 q62);
    }

    public TaskInfo(M62 m62) {
        this.a = m62.a;
        PersistableBundle persistableBundle = m62.b;
        this.b = persistableBundle == null ? new PersistableBundle() : persistableBundle;
        this.c = m62.c;
        this.d = m62.d;
        this.e = m62.e;
        this.f = m62.f;
        this.g = m62.g;
        TimingInfo timingInfo = m62.h;
        this.h = timingInfo;
        boolean z = timingInfo instanceof O62;
    }

    public static M62 a(int i, long j, long j2) {
        N62 n62 = new N62();
        n62.a = j;
        n62.c = true;
        n62.b = j2;
        n62.d = true;
        O62 o62 = new O62(n62);
        M62 m62 = new M62(i);
        m62.h = o62;
        return m62;
    }

    public final String toString() {
        return "{taskId: " + this.a + ", extras: " + this.b + ", requiredNetworkType: " + this.c + ", requiresCharging: " + this.d + ", userInitiated: " + this.e + ", isPersisted: " + this.f + ", updateCurrent: " + this.g + ", timingInfo: " + this.h + "}";
    }
}
