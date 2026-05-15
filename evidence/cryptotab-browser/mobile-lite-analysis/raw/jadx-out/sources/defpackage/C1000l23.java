package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;

/* JADX INFO: renamed from: l23, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1000l23 extends UY2 {
    public final /* synthetic */ IBinder u;
    public final /* synthetic */ ServiceConnectionC1001l33 v;

    public C1000l23(ServiceConnectionC1001l33 serviceConnectionC1001l33, IBinder iBinder) {
        this.v = serviceConnectionC1001l33;
        this.u = iBinder;
    }

    @Override // defpackage.UY2
    public final void a() {
        HO2 fk2;
        ServiceConnectionC1001l33 serviceConnectionC1001l33 = this.v;
        n33 n33Var = serviceConnectionC1001l33.t;
        int i = dN2.t;
        IBinder iBinder = this.u;
        if (iBinder == null) {
            fk2 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
            fk2 = iInterfaceQueryLocalInterface instanceof HO2 ? (HO2) iInterfaceQueryLocalInterface : new FK2(iBinder);
        }
        n33Var.l = fk2;
        n33 n33Var2 = serviceConnectionC1001l33.t;
        n33Var2.b.b("linkToDeath", new Object[0]);
        try {
            n33Var2.l.asBinder().linkToDeath(n33Var2.i, 0);
        } catch (RemoteException e) {
            n33Var2.b.a(e, "linkToDeath failed", new Object[0]);
        }
        n33Var2.g = false;
        Iterator it = n33Var2.d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        n33Var2.d.clear();
    }
}
