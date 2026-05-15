package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RV2 implements Runnable {
    public final /* synthetic */ zzq t;
    public final /* synthetic */ boolean u;
    public final /* synthetic */ zzaw v;
    public final /* synthetic */ CW2 w;

    public RV2(CW2 cw2, zzq zzqVar, boolean z, zzaw zzawVar) {
        this.w = cw2;
        this.t = zzqVar;
        this.u = z;
        this.v = zzawVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        CW2 cw2 = this.w;
        InterfaceC1086mO2 interfaceC1086mO2 = cw2.d;
        if (interfaceC1086mO2 == null) {
            WO2 wo2 = cw2.a.i;
            C1391rR2.k(wo2);
            wo2.f.a("Discarding data. Failed to send event to service");
        } else {
            zzq zzqVar = this.t;
            Preconditions.checkNotNull(zzqVar);
            cw2.k(interfaceC1086mO2, this.u ? null : this.v, zzqVar);
            cw2.r();
        }
    }
}
