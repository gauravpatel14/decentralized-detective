package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IV2 implements Runnable {
    public final /* synthetic */ zzq t;
    public final /* synthetic */ Bundle u;
    public final /* synthetic */ CW2 v;

    public IV2(CW2 cw2, zzq zzqVar, Bundle bundle) {
        this.v = cw2;
        this.t = zzqVar;
        this.u = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzq zzqVar = this.t;
        CW2 cw2 = this.v;
        InterfaceC1086mO2 interfaceC1086mO2 = cw2.d;
        if (interfaceC1086mO2 == null) {
            WO2 wo2 = cw2.a.i;
            C1391rR2.k(wo2);
            wo2.f.a("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(zzqVar);
            interfaceC1086mO2.x(this.u, zzqVar);
        } catch (RemoteException e) {
            WO2 wo22 = cw2.a.i;
            C1391rR2.k(wo22);
            wo22.f.b(e, "Failed to send default event parameters to service");
        }
    }
}
