package defpackage;

import android.app.job.JobParameters;
import android.os.SystemClock;
import android.util.Log;
import java.util.HashMap;
import org.chromium.components.background_task_scheduler.internal.BackgroundTaskJobService;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Bm implements Runnable {
    public final /* synthetic */ boolean t;
    public final /* synthetic */ Cm u;

    public Bm(Cm cm, boolean z) {
        this.u = cm;
        this.t = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Cm cm = this.u;
        HashMap map = cm.a.u;
        JobParameters jobParameters = cm.c;
        if (map.get(Integer.valueOf(jobParameters.getJobId())) != cm.b) {
            Log.e("cr_BkgrdTaskJS", "Tried finishing non-current BackgroundTask.");
            return;
        }
        BackgroundTaskJobService backgroundTaskJobService = cm.a;
        backgroundTaskJobService.u.remove(Integer.valueOf(jobParameters.getJobId()));
        backgroundTaskJobService.jobFinished(jobParameters, this.t);
        Lm lmD = Lm.d();
        int jobId = jobParameters.getJobId();
        long jUptimeMillis = SystemClock.uptimeMillis() - cm.d;
        lmD.getClass();
        Gr1.g(Xd0.a("Android.BackgroundTaskScheduler.TaskFinished.", Lm.c(jobId)), jUptimeMillis, 1L, 86400000L, 50);
    }
}
