package defpackage;

import android.os.RemoteException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HV2 implements Runnable {
    public final /* synthetic */ TU2 t;
    public final /* synthetic */ CW2 u;

    public HV2(CW2 cw2, TU2 tu2) {
        this.u = cw2;
        this.t = tu2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CW2 cw2 = this.u;
        InterfaceC1086mO2 interfaceC1086mO2 = cw2.d;
        C1391rR2 c1391rR2 = cw2.a;
        if (interfaceC1086mO2 == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.a("Failed to send current screen to service");
            return;
        }
        try {
            TU2 tu2 = this.t;
            if (tu2 == null) {
                interfaceC1086mO2.j(0L, null, null, c1391rR2.a.getPackageName());
            } else {
                interfaceC1086mO2.j(tu2.c, tu2.a, tu2.b, c1391rR2.a.getPackageName());
            }
            cw2.r();
        } catch (RemoteException e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.b(e, "Failed to send current screen to the service");
        }
    }
}
