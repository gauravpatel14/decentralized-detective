package defpackage;

import android.app.Notification;
import android.app.job.JobParameters;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.HashMap;
import org.chromium.base.task.PostTask;
import org.chromium.components.background_task_scheduler.internal.BackgroundTaskJobService;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Cm implements InterfaceC1692wm {
    public final BackgroundTaskJobService a;
    public final InterfaceC1751xm b;
    public final JobParameters c;
    public final long d = SystemClock.uptimeMillis();

    public Cm(BackgroundTaskJobService backgroundTaskJobService, InterfaceC1751xm interfaceC1751xm, JobParameters jobParameters) {
        this.a = backgroundTaskJobService;
        this.b = interfaceC1751xm;
        this.c = jobParameters;
    }

    @Override // defpackage.InterfaceC1692wm
    public final void a(boolean z) {
        PostTask.e(new Bm(this, z));
    }

    @Override // defpackage.InterfaceC1692wm
    public final void b(final int i, final Notification notification) {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        PostTask.e(new Runnable() { // from class: Am
            @Override // java.lang.Runnable
            public final void run() {
                Cm cm = this.t;
                HashMap map = cm.a.u;
                JobParameters jobParameters = cm.c;
                if (map.get(Integer.valueOf(jobParameters.getJobId())) != cm.b) {
                    Log.e("cr_BkgrdTaskJS", "Tried attaching notification for non-current BackgroundTask.");
                    return;
                }
                cm.a.setNotification(jobParameters, i, notification, 0);
                Lm lmD = Lm.d();
                int jobId = jobParameters.getJobId();
                long jUptimeMillis = SystemClock.uptimeMillis() - cm.d;
                lmD.getClass();
                Gr1.g(Xd0.a("Android.BackgroundTaskScheduler.SetNotification.", Lm.c(jobId)), jUptimeMillis, 1L, 86400000L, 50);
            }
        });
    }
}
