package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EV2 implements Runnable {
    public final /* synthetic */ zzq t;
    public final /* synthetic */ NI2 u;
    public final /* synthetic */ CW2 v;

    public EV2(CW2 cw2, zzq zzqVar, NI2 ni2) {
        this.v = cw2;
        this.t = zzqVar;
        this.u = ni2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzq zzqVar = this.t;
        NI2 ni2 = this.u;
        CW2 cw2 = this.v;
        C1391rR2 c1391rR2 = cw2.a;
        try {
            TP2 tp2 = c1391rR2.h;
            C1391rR2.i(tp2);
            if (!tp2.l().f(EnumC1486tD2.ANALYTICS_STORAGE)) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.k.a("Analytics storage consent denied; will not get app instance id");
                IU2 iu2 = c1391rR2.p;
                C1391rR2.j(iu2);
                iu2.g.set(null);
                TP2 tp22 = c1391rR2.h;
                C1391rR2.i(tp22);
                tp22.f.b(null);
                return;
            }
            InterfaceC1086mO2 interfaceC1086mO2 = cw2.d;
            if (interfaceC1086mO2 == null) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.f.a("Failed to get app instance id");
                return;
            }
            Preconditions.checkNotNull(zzqVar);
            String strS = interfaceC1086mO2.S(zzqVar);
            if (strS != null) {
                IU2 iu22 = c1391rR2.p;
                C1391rR2.j(iu22);
                iu22.g.set(strS);
                TP2 tp23 = c1391rR2.h;
                C1391rR2.i(tp23);
                tp23.f.b(strS);
            }
            cw2.r();
            C0653fY2 c0653fY2 = c1391rR2.l;
            C1391rR2.i(c0653fY2);
            c0653fY2.D(strS, ni2);
        } catch (RemoteException e) {
            WO2 wo23 = c1391rR2.i;
            C1391rR2.k(wo23);
            wo23.f.b(e, "Failed to get app instance id");
        } finally {
            C0653fY2 c0653fY22 = c1391rR2.l;
            C1391rR2.i(c0653fY22);
            c0653fY22.D(null, ni2);
        }
    }
}
