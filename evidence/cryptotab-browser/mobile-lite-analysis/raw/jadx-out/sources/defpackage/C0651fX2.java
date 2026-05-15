package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: fX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0651fX2 extends AbstractC0906jX2 {
    public final AlarmManager d;
    public C0590eX2 e;
    public Integer f;

    public C0651fX2(QX2 qx2) {
        super(qx2);
        this.d = (AlarmManager) this.a.a.getSystemService("alarm");
    }

    @Override // defpackage.AbstractC0906jX2
    public final void j() {
        C1391rR2 c1391rR2 = this.a;
        AlarmManager alarmManager = this.d;
        if (alarmManager != null) {
            Context context = c1391rR2.a;
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), AbstractC1663wH2.a));
        }
        JobScheduler jobScheduler = (JobScheduler) c1391rR2.a.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(l());
        }
    }

    public final void k() {
        h();
        C1391rR2 c1391rR2 = this.a;
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.n.a("Unscheduling upload");
        AlarmManager alarmManager = this.d;
        if (alarmManager != null) {
            Context context = c1391rR2.a;
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), AbstractC1663wH2.a));
        }
        m().a();
        JobScheduler jobScheduler = (JobScheduler) c1391rR2.a.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(l());
        }
    }

    public final int l() {
        if (this.f == null) {
            this.f = Integer.valueOf("measurement".concat(String.valueOf(this.a.a.getPackageName())).hashCode());
        }
        return this.f.intValue();
    }

    public final AbstractC1546uE2 m() {
        if (this.e == null) {
            this.e = new C0590eX2(this, this.b.l);
        }
        return this.e;
    }
}
