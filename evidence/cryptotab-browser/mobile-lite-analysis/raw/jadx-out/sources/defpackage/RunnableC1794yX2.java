package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: renamed from: yX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1794yX2 implements Runnable {
    public final /* synthetic */ NZ2 t;
    public final /* synthetic */ AppMeasurementDynamiteService u;

    public RunnableC1794yX2(AppMeasurementDynamiteService appMeasurementDynamiteService, NZ2 nz2) {
        this.u = appMeasurementDynamiteService;
        this.t = nz2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IU2 iu2 = this.u.t.p;
        C1391rR2.j(iu2);
        NZ2 nz2 = this.t;
        iu2.g();
        iu2.h();
        NZ2 nz22 = iu2.d;
        if (nz2 != nz22) {
            Preconditions.checkState(nz22 == null, "EventInterceptor already set.");
        }
        iu2.d = nz2;
    }
}
