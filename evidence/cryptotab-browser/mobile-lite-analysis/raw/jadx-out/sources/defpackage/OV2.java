package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OV2 implements Runnable {
    public final /* synthetic */ zzq t;
    public final /* synthetic */ CW2 u;

    public OV2(CW2 cw2, zzq zzqVar) {
        this.u = cw2;
        this.t = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzq zzqVar = this.t;
        CW2 cw2 = this.u;
        InterfaceC1086mO2 interfaceC1086mO2 = cw2.d;
        C1391rR2 c1391rR2 = cw2.a;
        if (interfaceC1086mO2 == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(zzqVar);
            interfaceC1086mO2.o(zzqVar);
            cw2.r();
        } catch (RemoteException e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.b(e, "Failed to send measurementEnabled to the service");
        }
    }
}
