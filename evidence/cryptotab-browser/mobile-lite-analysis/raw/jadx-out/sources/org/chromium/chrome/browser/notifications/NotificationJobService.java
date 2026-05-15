package org.chromium.chrome.browser.notifications;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import defpackage.AbstractC0636fN1;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class NotificationJobService extends JobService {
    public String t = "U01";
    public AbstractC0636fN1 u;

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Context contextB = SplitChromeApplication.b(context);
        AbstractC0636fN1 abstractC0636fN1 = (AbstractC0636fN1) BundleUtils.g(contextB, this.t);
        this.u = abstractC0636fN1;
        abstractC0636fN1.getClass();
        super.attachBaseContext(contextB);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        this.u.a(jobParameters);
        return false;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        this.u.b(jobParameters);
        return false;
    }
}
