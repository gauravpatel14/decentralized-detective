package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class QY2 implements Runnable {
    public final /* synthetic */ NI2 t;
    public final /* synthetic */ AppMeasurementDynamiteService u;

    public QY2(AppMeasurementDynamiteService appMeasurementDynamiteService, NI2 ni2) {
        this.u = appMeasurementDynamiteService;
        this.t = ni2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppMeasurementDynamiteService appMeasurementDynamiteService = this.u;
        C0653fY2 c0653fY2 = appMeasurementDynamiteService.t.l;
        C1391rR2.i(c0653fY2);
        C1391rR2 c1391rR2 = appMeasurementDynamiteService.t;
        c0653fY2.x(this.t, c1391rR2.A != null && c1391rR2.A.booleanValue());
    }
}
