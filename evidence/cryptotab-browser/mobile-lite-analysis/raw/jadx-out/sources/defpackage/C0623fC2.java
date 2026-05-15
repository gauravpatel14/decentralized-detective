package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;

/* JADX INFO: renamed from: fC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0623fC2 extends P23 {
    public final /* synthetic */ IBinder u;
    public final /* synthetic */ LC2 v;

    public C0623fC2(LC2 lc2, IBinder iBinder) {
        this.v = lc2;
        this.u = iBinder;
    }

    @Override // defpackage.P23
    public final void a() {
        InterfaceC0889jH2 c0342aH2;
        LC2 lc2 = this.v;
        C0562eD2 c0562eD2 = lc2.t;
        int i = AbstractBinderC0629fH2.t;
        IBinder iBinder = this.u;
        if (iBinder == null) {
            c0342aH2 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
            c0342aH2 = iInterfaceQueryLocalInterface instanceof InterfaceC0889jH2 ? (InterfaceC0889jH2) iInterfaceQueryLocalInterface : new C0342aH2(iBinder);
        }
        c0562eD2.l = c0342aH2;
        C0562eD2 c0562eD22 = lc2.t;
        c0562eD22.b.c("linkToDeath", new Object[0]);
        try {
            c0562eD22.l.asBinder().linkToDeath(c0562eD22.i, 0);
        } catch (RemoteException e) {
            c0562eD22.b.b(e, "linkToDeath failed", new Object[0]);
        }
        c0562eD22.g = false;
        Iterator it = c0562eD22.d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        c0562eD22.d.clear();
    }
}
