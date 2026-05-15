package defpackage;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzaw;

/* JADX INFO: renamed from: dV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0532dV2 implements Runnable {
    public final /* synthetic */ NI2 t;
    public final /* synthetic */ zzaw u;
    public final /* synthetic */ String v;
    public final /* synthetic */ AppMeasurementDynamiteService w;

    public RunnableC0532dV2(AppMeasurementDynamiteService appMeasurementDynamiteService, NI2 ni2, zzaw zzawVar, String str) {
        this.w = appMeasurementDynamiteService;
        this.t = ni2;
        this.u = zzawVar;
        this.v = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CW2 cw2S = this.w.t.s();
        cw2S.g();
        cw2S.h();
        C1391rR2 c1391rR2 = cw2S.a;
        C0653fY2 c0653fY2 = c1391rR2.l;
        C1391rR2.i(c0653fY2);
        int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(c0653fY2.a.a, 12451000);
        NI2 ni2 = this.t;
        if (iIsGooglePlayServicesAvailable == 0) {
            cw2S.s(new LV2(cw2S, this.u, this.v, ni2));
            return;
        }
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.i.a("Not bundling data. Service unavailable or out of date");
        C0653fY2 c0653fY22 = c1391rR2.l;
        C1391rR2.i(c0653fY22);
        c0653fY22.A(ni2, new byte[0]);
    }
}
