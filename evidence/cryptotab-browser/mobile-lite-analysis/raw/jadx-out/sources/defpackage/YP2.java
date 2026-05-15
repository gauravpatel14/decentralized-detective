package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YP2 implements ServiceConnection {
    public final String t;
    public final /* synthetic */ C0411bQ2 u;

    public YP2(C0411bQ2 c0411bQ2, String str) {
        this.u = c0411bQ2;
        this.t = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1391rR2 c1391rR2 = this.u.a;
        if (iBinder == null) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.i.a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i = AbstractBinderC1319qH2.t;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            InterfaceC1436sH2 c1015lH2 = iInterfaceQueryLocalInterface instanceof InterfaceC1436sH2 ? (InterfaceC1436sH2) iInterfaceQueryLocalInterface : new C1015lH2(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (c1015lH2 == null) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.i.a("Install Referrer Service implementation was not found");
            } else {
                WO2 wo23 = c1391rR2.i;
                C1391rR2.k(wo23);
                wo23.n.a("Install Referrer Service connected");
                C0899jR2 c0899jR2 = c1391rR2.j;
                C1391rR2.k(c0899jR2);
                c0899jR2.o(new WP2(this, c1015lH2, this));
            }
        } catch (RuntimeException e) {
            WO2 wo24 = c1391rR2.i;
            C1391rR2.k(wo24);
            wo24.i.b(e, "Exception occurred while calling Install Referrer API");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        WO2 wo2 = this.u.a.i;
        C1391rR2.k(wo2);
        wo2.n.a("Install Referrer Service disconnected");
    }
}
