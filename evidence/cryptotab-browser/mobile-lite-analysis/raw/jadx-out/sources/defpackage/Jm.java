package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Log;
import java.util.Iterator;
import org.chromium.components.background_task_scheduler.TaskInfo;
import org.chromium.components.background_task_scheduler.internal.BackgroundTaskJobService;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jm {
    public static S62 a(JobParameters jobParameters) {
        R62 r62 = new R62(jobParameters.getJobId());
        PersistableBundle persistableBundle = jobParameters.getExtras().getPersistableBundle("_background_task_extras");
        PersistableBundle persistableBundle2 = new PersistableBundle();
        persistableBundle2.putAll(persistableBundle);
        r62.b = persistableBundle2;
        return new S62(r62);
    }

    public final boolean b(Context context, TaskInfo taskInfo) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putPersistableBundle("_background_task_extras", taskInfo.b);
        ComponentName componentName = new ComponentName(context, (Class<?>) BackgroundTaskJobService.class);
        int i = taskInfo.a;
        JobInfo.Builder requiredNetworkType = new JobInfo.Builder(i, componentName).setPersisted(taskInfo.f).setRequiresCharging(taskInfo.d).setRequiredNetworkType(taskInfo.c);
        if (AbstractC1808yv.b()) {
            requiredNetworkType.setUserInitiated(taskInfo.e);
        }
        taskInfo.h.a(new Im(requiredNetworkType, persistableBundle));
        JobInfo jobInfoBuild = requiredNetworkType.build();
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (!taskInfo.g) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (it.hasNext()) {
                if (it.next().getId() == i) {
                    return true;
                }
            }
        }
        try {
            return jobScheduler.schedule(jobInfoBuild) == 1;
        } catch (Exception e) {
            Log.e("cr_BkgrdTaskSchedulerJS", "Unable to schedule with Android.", e);
            return false;
        }
    }
}
