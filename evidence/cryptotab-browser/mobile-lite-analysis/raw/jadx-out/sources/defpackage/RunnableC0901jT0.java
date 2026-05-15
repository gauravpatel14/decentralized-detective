package defpackage;

import android.app.job.JobParameters;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import org.chromium.base.task.PostTask;
import org.chromium.chrome.browser.crash.ChromeMinidumpUploadJobService;

/* JADX INFO: renamed from: jT0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0901jT0 implements Runnable {
    public final /* synthetic */ int t;
    public final ChromeMinidumpUploadJobService u;
    public final /* synthetic */ C0962kT0 v;

    public /* synthetic */ RunnableC0901jT0(C0962kT0 c0962kT0, ChromeMinidumpUploadJobService chromeMinidumpUploadJobService, int i) {
        this.t = i;
        this.v = c0962kT0;
        this.u = chromeMinidumpUploadJobService;
    }

    public void a(boolean z) {
        JobParameters jobParameters;
        long j;
        boolean z2;
        this.v.getClass();
        ChromeMinidumpUploadJobService chromeMinidumpUploadJobService = this.u;
        if (z) {
            Log.i("cr_MinidumpJobService", "Some minidumps remain un-uploaded; rescheduling.");
        }
        synchronized (chromeMinidumpUploadJobService.t) {
            try {
                jobParameters = chromeMinidumpUploadJobService.v;
                j = chromeMinidumpUploadJobService.w;
                z2 = z || chromeMinidumpUploadJobService.x;
                chromeMinidumpUploadJobService.u = null;
                chromeMinidumpUploadJobService.v = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        chromeMinidumpUploadJobService.jobFinished(jobParameters, z2);
        Gr1.g("Stability.Android.MinidumpUploadingTime", SystemClock.uptimeMillis() - j, 1L, 86400000L, 50);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                PostTask.c(1, new RunnableC0901jT0(this.v, this.u, 1));
                break;
            default:
                File fileE = this.v.a.e();
                if (fileE.isDirectory()) {
                    this.v.getClass();
                    C1613vO c1613vO = new C1613vO(fileE);
                    if (c1613vO.d().isDirectory()) {
                        File[] fileArrE = c1613vO.e();
                        Log.i("cr_MDUploadJobImpl", "Attempting to upload " + fileArrE.length + " minidumps.");
                        int length = fileArrE.length;
                        for (int i = 0; i < length; i++) {
                            File file = fileArrE[i];
                            Log.i("cr_MDUploadJobImpl", "Attempting to upload " + file.getName());
                            int iIntValue = new CallableC0842iT0(file, new File(c1613vO.d(), "uploads.log"), this.v.a.b()).call().intValue();
                            if (iIntValue == 0) {
                                this.v.a.c(file);
                            } else if (iIntValue == 1) {
                                int iH = C1613vO.h(file.getName());
                                if (iH < 0) {
                                    iH = 0;
                                }
                                if (iH + 1 == 3) {
                                    this.v.a.a(file);
                                }
                            }
                            if (this.v.b) {
                                this.v.getClass();
                            } else {
                                if (iIntValue == 1 && C1613vO.j(file) == null) {
                                    Log.w("cr_MDUploadJobImpl", "Failed to increment attempt number of " + file);
                                }
                            }
                            break;
                        }
                        c1613vO.a();
                        a(c1613vO.e().length > 0);
                    } else {
                        Log.e("cr_MDUploadJobImpl", "Crash directory doesn't exist!");
                        a(false);
                    }
                } else {
                    Log.e("cr_MDUploadJobImpl", "Parent crash directory doesn't exist!");
                    a(false);
                }
                break;
        }
    }
}
