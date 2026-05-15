package defpackage;

import android.app.job.JobInfo;
import android.os.PersistableBundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Im implements Q62 {
    public final JobInfo.Builder a;
    public final PersistableBundle b;

    public Im(JobInfo.Builder builder, PersistableBundle persistableBundle) {
        this.a = builder;
        this.b = persistableBundle;
    }

    @Override // defpackage.Q62
    public final void a(O62 o62) {
        boolean z = o62.e;
        PersistableBundle persistableBundle = this.b;
        long j = o62.b;
        if (z) {
            persistableBundle.putLong("_background_task_schedule_time", System.currentTimeMillis());
            persistableBundle.putLong("_background_task_end_time", j);
        }
        JobInfo.Builder builder = this.a;
        builder.setExtras(persistableBundle);
        if (o62.c) {
            builder.setMinimumLatency(o62.a);
        }
        if (o62.d) {
            if (o62.e) {
                j += 1000;
            }
            builder.setOverrideDeadline(j);
        }
    }

    @Override // defpackage.Q62
    public final void b(P62 p62) {
        boolean z = p62.e;
        PersistableBundle persistableBundle = this.b;
        long j = p62.c;
        boolean z2 = p62.d;
        long j2 = p62.b;
        if (z) {
            persistableBundle.putLong("_background_task_schedule_time", System.currentTimeMillis());
            persistableBundle.putLong("_background_task_interval_time", j2);
            if (z2) {
                persistableBundle.putLong("_background_task_flex_time", j);
            }
        }
        JobInfo.Builder builder = this.a;
        builder.setExtras(persistableBundle);
        if (z2) {
            builder.setPeriodic(j2, j);
        } else {
            builder.setPeriodic(j2);
        }
    }
}
