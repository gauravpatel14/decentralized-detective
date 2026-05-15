package org.chromium.chrome.browser.crash;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import defpackage.AbstractC0702gN1;
import defpackage.C0962kT0;
import defpackage.RunnableC0901jT0;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ChromeMinidumpUploadJobService extends JobService {
    public static final /* synthetic */ int A = 0;
    public C0962kT0 u;
    public JobParameters v;
    public long w;
    public boolean x;
    public AbstractC0702gN1 z;
    public final Object t = new Object();
    public String y = "hD";

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Context contextB = SplitChromeApplication.b(context);
        AbstractC0702gN1 abstractC0702gN1 = (AbstractC0702gN1) BundleUtils.g(contextB, this.y);
        this.z = abstractC0702gN1;
        abstractC0702gN1.a = this;
        super.attachBaseContext(contextB);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        synchronized (this.t) {
            try {
                boolean z = this.u != null;
                this.x = z;
                if (z) {
                    return false;
                }
                this.u = this.z.a(jobParameters.getExtras());
                this.v = jobParameters;
                this.w = SystemClock.uptimeMillis();
                C0962kT0 c0962kT0 = this.u;
                c0962kT0.b = false;
                c0962kT0.a.d(new RunnableC0901jT0(c0962kT0, this, 0));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        boolean z;
        Log.i("cr_MinidumpJobService", "Canceling pending uploads due to change in networking status.");
        synchronized (this.t) {
            C0962kT0 c0962kT0 = this.u;
            z = true;
            if (c0962kT0 != null) {
                c0962kT0.b = true;
            } else if (!this.x) {
                z = false;
            }
        }
        return z;
    }
}
