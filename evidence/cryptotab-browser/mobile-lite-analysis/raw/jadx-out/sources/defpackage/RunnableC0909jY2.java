package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: renamed from: jY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0909jY2 implements Runnable {
    public final /* synthetic */ NI2 t;
    public final /* synthetic */ String u;
    public final /* synthetic */ String v;
    public final /* synthetic */ AppMeasurementDynamiteService w;

    public RunnableC0909jY2(AppMeasurementDynamiteService appMeasurementDynamiteService, NI2 ni2, String str, String str2) {
        this.w = appMeasurementDynamiteService;
        this.t = ni2;
        this.u = str;
        this.v = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CW2 cw2S = this.w.t.s();
        cw2S.g();
        cw2S.h();
        zzq zzqVarP = cw2S.p(false);
        cw2S.s(new VV2(cw2S, this.u, this.v, zzqVarP, this.t));
    }
}
