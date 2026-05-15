package defpackage;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WP2 implements Runnable {
    public final /* synthetic */ InterfaceC1436sH2 t;
    public final /* synthetic */ YP2 u;

    public WP2(YP2 yp2, InterfaceC1436sH2 interfaceC1436sH2, YP2 yp22) {
        this.u = yp2;
        this.t = interfaceC1436sH2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        YP2 yp2 = this.u;
        C0411bQ2 c0411bQ2 = yp2.u;
        InterfaceC1436sH2 interfaceC1436sH2 = this.t;
        C1391rR2 c1391rR2 = c0411bQ2.a;
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.g();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", yp2.t);
        try {
            C1015lH2 c1015lH2 = (C1015lH2) interfaceC1436sH2;
            Parcel parcelW0 = c1015lH2.W0();
            hH2.c(parcelW0, bundle);
            Parcel parcelX0 = c1015lH2.X0(1, parcelW0);
            Bundle bundle2 = (Bundle) hH2.a(parcelX0, Bundle.CREATOR);
            parcelX0.recycle();
            if (bundle2 == null) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.f.a("Install Referrer Service returned a null response");
            }
        } catch (Exception e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.b(e.getMessage(), "Exception occurred while retrieving the Install Referrer");
        }
        C0899jR2 c0899jR22 = c1391rR2.j;
        C1391rR2.k(c0899jR22);
        c0899jR22.g();
        throw new IllegalStateException("Unexpected call on client side");
    }
}
