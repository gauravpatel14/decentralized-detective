package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.browser.customtabs.CustomTabsSessionToken;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Mi1 implements ServiceConnection {
    public final Object t = new Object();
    public final InterfaceC0671fr0 u;
    public InterfaceC1111ms0 v;
    public String w;
    public boolean x;

    public Mi1(CustomTabsSessionToken customTabsSessionToken) {
        InterfaceC0671fr0 interfaceC0671fr0 = customTabsSessionToken.a;
        IBinder iBinderAsBinder = interfaceC0671fr0 == null ? null : interfaceC0671fr0.asBinder();
        if (iBinderAsBinder == null) {
            throw new IllegalArgumentException("Provided session must have binder.");
        }
        this.u = dr0.W0(iBinderAsBinder);
    }

    public final boolean a() {
        if (this.v == null) {
            return false;
        }
        synchronized (this.t) {
            try {
                try {
                    this.v.J0(this.u, null);
                } catch (RemoteException unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        InterfaceC1111ms0 interfaceC1111ms0;
        int i = Li1.t;
        if (iBinder == null) {
            interfaceC1111ms0 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC1111ms0.g);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1111ms0)) {
                C1052ls0 c1052ls0 = new C1052ls0();
                c1052ls0.t = iBinder;
                interfaceC1111ms0 = c1052ls0;
            } else {
                interfaceC1111ms0 = (InterfaceC1111ms0) iInterfaceQueryLocalInterface;
            }
        }
        this.v = interfaceC1111ms0;
        if (this.x) {
            a();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.v = null;
    }
}
