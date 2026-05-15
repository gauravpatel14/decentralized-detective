package org.chromium.components.background_task_scheduler.internal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import defpackage.AbstractC1499tM;
import defpackage.C1854zY;
import defpackage.InterfaceC1751xm;
import defpackage.Jm;
import defpackage.Lm;
import defpackage.S62;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class BackgroundTaskJobService extends JobService {
    public final C1854zY t = new C1854zY();
    public final HashMap u = new HashMap();

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r2 >= (r4.getLong("_background_task_end_time") + r5)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        if (r9 < r7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        r0 = defpackage.Lm.d();
        r13 = defpackage.Lm.e(r13.getJobId());
        r0.getClass();
        defpackage.Lm.a(r13, "Android.BackgroundTaskScheduler.TaskExpired");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
    
        return false;
     */
    @Override // android.app.job.JobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStartJob(android.app.job.JobParameters r13) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.components.background_task_scheduler.internal.BackgroundTaskJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        HashMap map = this.u;
        if (!map.containsKey(Integer.valueOf(jobParameters.getJobId()))) {
            Log.w("cr_BkgrdTaskJS", "Failed to stop job, because job with job id " + jobParameters.getJobId() + " does not exist.");
            return false;
        }
        InterfaceC1751xm interfaceC1751xm = (InterfaceC1751xm) map.get(Integer.valueOf(jobParameters.getJobId()));
        S62 s62A = Jm.a(jobParameters);
        Lm lmD = Lm.d();
        int iE = Lm.e(s62A.a);
        lmD.getClass();
        Lm.a(iE, "Android.BackgroundTaskScheduler.TaskStopped");
        boolean zA = interfaceC1751xm.a(AbstractC1499tM.a, s62A);
        map.remove(Integer.valueOf(jobParameters.getJobId()));
        return zA;
    }
}
