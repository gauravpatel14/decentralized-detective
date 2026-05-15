package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzlo;
import com.google.android.gms.measurement.internal.zzq;
import java.util.List;

/* JADX INFO: renamed from: zV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1849zV2 implements Runnable {
    public final /* synthetic */ String t;
    public final /* synthetic */ String u;
    public final /* synthetic */ zzq v;
    public final /* synthetic */ boolean w;
    public final /* synthetic */ NI2 x;
    public final /* synthetic */ CW2 y;

    public RunnableC1849zV2(CW2 cw2, String str, String str2, zzq zzqVar, boolean z, NI2 ni2) {
        this.y = cw2;
        this.t = str;
        this.u = str2;
        this.v = zzqVar;
        this.w = z;
        this.x = ni2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzq zzqVar = this.v;
        String str = this.t;
        NI2 ni2 = this.x;
        CW2 cw2 = this.y;
        C1391rR2 c1391rR2 = cw2.a;
        Bundle bundle = new Bundle();
        try {
            try {
                InterfaceC1086mO2 interfaceC1086mO2 = cw2.d;
                String str2 = this.u;
                if (interfaceC1086mO2 == null) {
                    WO2 wo2 = c1391rR2.i;
                    C1391rR2.k(wo2);
                    wo2.f.c(str, str2, "Failed to get user properties; not connected to service");
                    C0653fY2 c0653fY2 = c1391rR2.l;
                    C1391rR2.i(c0653fY2);
                    c0653fY2.z(ni2, bundle);
                    return;
                }
                Preconditions.checkNotNull(zzqVar);
                List<zzlo> listQ = interfaceC1086mO2.Q(str, str2, this.w, zzqVar);
                Bundle bundle2 = new Bundle();
                if (listQ != null) {
                    for (zzlo zzloVar : listQ) {
                        String str3 = zzloVar.x;
                        String str4 = zzloVar.u;
                        if (str3 != null) {
                            bundle2.putString(str4, str3);
                        } else {
                            Long l = zzloVar.w;
                            if (l != null) {
                                bundle2.putLong(str4, l.longValue());
                            } else {
                                Double d = zzloVar.z;
                                if (d != null) {
                                    bundle2.putDouble(str4, d.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    cw2.r();
                    C0653fY2 c0653fY22 = c1391rR2.l;
                    C1391rR2.i(c0653fY22);
                    c0653fY22.z(ni2, bundle2);
                } catch (RemoteException e) {
                    e = e;
                    bundle = bundle2;
                    WO2 wo22 = c1391rR2.i;
                    C1391rR2.k(wo22);
                    wo22.f.c(str, e, "Failed to get user properties; remote exception");
                    C0653fY2 c0653fY23 = c1391rR2.l;
                    C1391rR2.i(c0653fY23);
                    c0653fY23.z(ni2, bundle);
                } catch (Throwable th) {
                    th = th;
                    bundle = bundle2;
                    C0653fY2 c0653fY24 = c1391rR2.l;
                    C1391rR2.i(c0653fY24);
                    c0653fY24.z(ni2, bundle);
                    throw th;
                }
            } catch (RemoteException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
