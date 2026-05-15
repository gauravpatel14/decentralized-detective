package org.chromium.components.background_task_scheduler.internal;

import defpackage.AbstractC1499tM;
import defpackage.Dm;
import org.chromium.components.background_task_scheduler.TaskInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class NativeTaskScheduler {
    public static void cancel(int i) {
        Dm.a().a(i, AbstractC1499tM.a);
    }

    public static boolean schedule(TaskInfo taskInfo) {
        return Dm.a().b(AbstractC1499tM.a, taskInfo);
    }
}
