package defpackage;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaw;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LV2 implements Runnable {
    public final /* synthetic */ zzaw t;
    public final /* synthetic */ String u;
    public final /* synthetic */ NI2 v;
    public final /* synthetic */ CW2 w;

    public LV2(CW2 cw2, zzaw zzawVar, String str, NI2 ni2) {
        this.w = cw2;
        this.t = zzawVar;
        this.u = str;
        this.v = ni2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NI2 ni2 = this.v;
        CW2 cw2 = this.w;
        C1391rR2 c1391rR2 = cw2.a;
        try {
            InterfaceC1086mO2 interfaceC1086mO2 = cw2.d;
            if (interfaceC1086mO2 == null) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.f.a("Discarding data. Failed to send event to service to bundle");
            } else {
                byte[] bArrG = interfaceC1086mO2.G(this.t, this.u);
                cw2.r();
                C0653fY2 c0653fY2 = c1391rR2.l;
                C1391rR2.i(c0653fY2);
                c0653fY2.A(ni2, bArrG);
            }
        } catch (RemoteException e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.b(e, "Failed to send event to the service to bundle");
        } finally {
            C0653fY2 c0653fY22 = c1391rR2.l;
            C1391rR2.i(c0653fY22);
            c0653fY22.A(ni2, null);
        }
    }
}
