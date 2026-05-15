package defpackage;

import android.app.job.JobScheduler;
import android.content.Context;
import android.util.Log;
import org.chromium.base.TraceEvent;
import org.chromium.components.background_task_scheduler.TaskInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Gm {
    public final Jm a;

    public Gm(Jm jm) {
        this.a = jm;
    }

    public final void a(int i, Context context) {
        TraceEvent traceEventJ = TraceEvent.j("BackgroundTaskScheduler.cancel", Integer.toString(i));
        try {
            Lm lmD = Lm.d();
            int iE = Lm.e(i);
            lmD.getClass();
            Lm.a(iE, "Android.BackgroundTaskScheduler.TaskCanceled");
            try {
                ((JobScheduler) context.getSystemService("jobscheduler")).cancel(i);
            } catch (NullPointerException unused) {
                Log.e("cr_BkgrdTaskSchedulerJS", "Failed to cancel task: " + i);
            }
            if (traceEventJ != null) {
                traceEventJ.close();
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    public final boolean b(Context context, TaskInfo taskInfo) {
        if (CH.c().e("ignore-background-tasks")) {
            return true;
        }
        int i = taskInfo.a;
        TaskInfo.TimingInfo timingInfo = taskInfo.h;
        TraceEvent traceEventJ = TraceEvent.j("BackgroundTaskScheduler.schedule", Integer.toString(i));
        try {
            Fm fm = new Fm(this, context, taskInfo);
            timingInfo.a(fm);
            boolean z = fm.c;
            Lm lmD = Lm.d();
            int i2 = taskInfo.a;
            if (z) {
                int iE = Lm.e(i2);
                lmD.getClass();
                Lm.a(iE, "Android.BackgroundTaskScheduler.TaskScheduled.Success");
            } else {
                int iE2 = Lm.e(i2);
                lmD.getClass();
                Lm.a(iE2, "Android.BackgroundTaskScheduler.TaskScheduled.Failure");
            }
            timingInfo.a(new Em(i2));
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return z;
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
