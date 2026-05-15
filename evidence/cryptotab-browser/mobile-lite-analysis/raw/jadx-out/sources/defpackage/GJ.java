package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GJ implements ServiceConnection {
    public final RunnableC0316Zh2 t;
    public final FJ u;
    public int v;
    public C0300Yh2 w;
    public final ArrayList x;
    public Exception y;

    public GJ(RunnableC0316Zh2 runnableC0316Zh2) {
        FJ fj = new FJ();
        this.v = 0;
        this.x = new ArrayList();
        this.t = runnableC0316Zh2;
        this.u = fj;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        us0 us0Var;
        this.u.getClass();
        int i = AbstractBinderC1470ss0.t;
        if (iBinder == null) {
            us0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(us0.j);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof us0)) {
                C1412rs0 c1412rs0 = new C1412rs0();
                c1412rs0.t = iBinder;
                us0Var = c1412rs0;
            } else {
                us0Var = (us0) iInterfaceQueryLocalInterface;
            }
        }
        this.w = new C0300Yh2(us0Var, componentName);
        ArrayList arrayList = this.x;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C0440bx) it.next()).a(this.w);
        }
        arrayList.clear();
        this.v = 1;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.w = null;
        this.t.run();
        this.v = 2;
    }
}
