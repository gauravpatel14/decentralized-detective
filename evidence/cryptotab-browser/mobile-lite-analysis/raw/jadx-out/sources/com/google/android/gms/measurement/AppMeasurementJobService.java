package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.common.ConnectionResult;
import defpackage.C1391rR2;
import defpackage.KW2;
import defpackage.MW2;
import defpackage.OW2;
import defpackage.QX2;
import defpackage.WO2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(ConnectionResult.API_DISABLED_FOR_CONNECTION)
public final class AppMeasurementJobService extends JobService implements MW2 {
    public OW2 t;

    @Override // defpackage.MW2
    public final boolean b(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.MW2
    public final void c(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public final OW2 d() {
        if (this.t == null) {
            this.t = new OW2(this);
        }
        return this.t;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        WO2 wo2 = C1391rR2.r(d().a, null, null).i;
        C1391rR2.k(wo2);
        wo2.n.a("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        WO2 wo2 = C1391rR2.r(d().a, null, null).i;
        C1391rR2.k(wo2);
        wo2.n.a("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        OW2 ow2D = d();
        if (intent == null) {
            ow2D.a().f.a("onRebind called with null intent");
            return;
        }
        ow2D.getClass();
        ow2D.a().n.b(intent.getAction(), "onRebind called. action");
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(final JobParameters jobParameters) {
        final OW2 ow2D = d();
        final WO2 wo2 = C1391rR2.r(ow2D.a, null, null).i;
        C1391rR2.k(wo2);
        String string = jobParameters.getExtras().getString("action");
        wo2.n.b(string, "Local AppMeasurementJobService called. action");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        Runnable runnable = new Runnable() { // from class: GW2
            @Override // java.lang.Runnable
            public final void run() {
                OW2 ow2 = ow2D;
                wo2.n.a("AppMeasurementJobService processed last upload request.");
                ((MW2) ow2.a).c(jobParameters);
            }
        };
        QX2 qx2N = QX2.N(ow2D.a);
        qx2N.b().o(new KW2(qx2N, runnable));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        OW2 ow2D = d();
        if (intent == null) {
            ow2D.a().f.a("onUnbind called with null intent");
            return true;
        }
        ow2D.getClass();
        ow2D.a().n.b(intent.getAction(), "onUnbind called for intent. action");
        return true;
    }

    @Override // defpackage.MW2
    public final void a(Intent intent) {
    }
}
