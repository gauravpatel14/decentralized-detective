package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OT2 implements Runnable {
    public final /* synthetic */ NI2 t;
    public final /* synthetic */ AppMeasurementDynamiteService u;

    public OT2(AppMeasurementDynamiteService appMeasurementDynamiteService, NI2 ni2) {
        this.u = appMeasurementDynamiteService;
        this.t = ni2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CW2 cw2S = this.u.t.s();
        cw2S.g();
        cw2S.h();
        cw2S.s(new EV2(cw2S, cw2S.p(false), this.t));
    }
}
