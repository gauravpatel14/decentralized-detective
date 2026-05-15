package org.chromium.components.background_task_scheduler.internal;

import android.os.PersistableBundle;
import defpackage.M62;
import defpackage.N62;
import defpackage.O62;
import defpackage.P62;
import org.chromium.components.background_task_scheduler.TaskInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class TaskInfoBridge {
    public static TaskInfo.TimingInfo createOneOffInfo(long j, long j2, boolean z) {
        N62 n62 = new N62();
        n62.b = j2;
        n62.d = true;
        n62.e = z;
        if (j > 0) {
            n62.a = j;
            n62.c = true;
        }
        return new O62(n62);
    }

    public static TaskInfo.TimingInfo createPeriodicInfo(long j, long j2, boolean z) {
        P62 p62 = new P62();
        p62.b = j;
        p62.e = z;
        if (j2 > 0) {
            p62.c = j2;
            p62.d = true;
        }
        return new P62(p62);
    }

    public static TaskInfo createTaskInfo(int i, TaskInfo.TimingInfo timingInfo, String str, int i2, boolean z, boolean z2, boolean z3) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("serialized_task_extras", str);
        M62 m62 = new M62(i);
        m62.h = timingInfo;
        m62.c = i2;
        m62.d = z;
        m62.g = z3;
        m62.f = z2;
        m62.b = persistableBundle;
        return new TaskInfo(m62);
    }
}
