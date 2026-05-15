package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: renamed from: fW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0650fW2 implements Runnable {
    public final /* synthetic */ NI2 t;
    public final /* synthetic */ String u;
    public final /* synthetic */ String v;
    public final /* synthetic */ boolean w;
    public final /* synthetic */ AppMeasurementDynamiteService x;

    public RunnableC0650fW2(AppMeasurementDynamiteService appMeasurementDynamiteService, NI2 ni2, String str, String str2, boolean z) {
        this.x = appMeasurementDynamiteService;
        this.t = ni2;
        this.u = str;
        this.v = str2;
        this.w = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CW2 cw2S = this.x.t.s();
        cw2S.g();
        cw2S.h();
        cw2S.s(new RunnableC1849zV2(cw2S, this.u, this.v, cw2S.p(false), this.w, this.t));
    }
}
