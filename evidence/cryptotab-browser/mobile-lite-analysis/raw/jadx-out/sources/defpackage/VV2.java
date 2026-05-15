package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VV2 implements Runnable {
    public final /* synthetic */ String t;
    public final /* synthetic */ String u;
    public final /* synthetic */ zzq v;
    public final /* synthetic */ NI2 w;
    public final /* synthetic */ CW2 x;

    public VV2(CW2 cw2, String str, String str2, zzq zzqVar, NI2 ni2) {
        this.x = cw2;
        this.t = str;
        this.u = str2;
        this.v = zzqVar;
        this.w = ni2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzq zzqVar = this.v;
        String str = this.u;
        String str2 = this.t;
        NI2 ni2 = this.w;
        CW2 cw2 = this.x;
        C1391rR2 c1391rR2 = cw2.a;
        ArrayList arrayList = new ArrayList();
        try {
            InterfaceC1086mO2 interfaceC1086mO2 = cw2.d;
            if (interfaceC1086mO2 == null) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.f.c(str2, str, "Failed to get conditional properties; not connected to service");
            } else {
                Preconditions.checkNotNull(zzqVar);
                ArrayList arrayListP = C0653fY2.p(interfaceC1086mO2.T0(str2, str, zzqVar));
                cw2.r();
                C0653fY2 c0653fY2 = c1391rR2.l;
                C1391rR2.i(c0653fY2);
                c0653fY2.y(ni2, arrayListP);
            }
        } catch (RemoteException e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.d("Failed to get conditional properties; remote exception", str2, str, e);
        } finally {
            C0653fY2 c0653fY22 = c1391rR2.l;
            C1391rR2.i(c0653fY22);
            c0653fY22.y(ni2, arrayList);
        }
    }
}
