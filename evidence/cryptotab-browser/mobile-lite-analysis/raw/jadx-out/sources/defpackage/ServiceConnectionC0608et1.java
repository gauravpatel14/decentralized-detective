package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: et1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC0608et1 extends ZO0 implements ServiceConnection {
    public final ComponentName B;
    public final Zs1 C;
    public final ArrayList D;
    public boolean E;
    public boolean F;
    public Xs1 G;
    public boolean H;
    public C0674ft1 I;

    public ServiceConnectionC0608et1(Context context, ComponentName componentName) {
        super(context, new WO0(componentName));
        this.D = new ArrayList();
        this.B = componentName;
        this.C = new Zs1();
    }

    @Override // defpackage.ZO0
    public final UO0 a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
        }
        C0351aP0 c0351aP0 = this.z;
        if (c0351aP0 != null) {
            List list = c0351aP0.a;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((OO0) list.get(i)).d().equals(str)) {
                    C0502ct1 c0502ct1 = new C0502ct1(this, str);
                    this.D.add(c0502ct1);
                    if (this.H) {
                        c0502ct1.b(this.G);
                    }
                    k();
                    return c0502ct1;
                }
            }
        }
        return null;
    }

    @Override // defpackage.ZO0
    public final XO0 b(String str) {
        if (str != null) {
            return h(str, null);
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    @Override // defpackage.ZO0
    public final XO0 c(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return h(str, str2);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    @Override // defpackage.ZO0
    public final void d(RO0 ro0) {
        if (this.H) {
            Xs1 xs1 = this.G;
            int i = xs1.d;
            xs1.d = i + 1;
            xs1.b(10, i, 0, ro0 != null ? ro0.a : null, null);
        }
        k();
    }

    public final void g() {
        if (this.F) {
            return;
        }
        Intent intent = new Intent("android.media.MediaRouteProviderService");
        intent.setComponent(this.B);
        try {
            this.F = this.t.bindService(intent, this, Build.VERSION.SDK_INT >= 29 ? 4097 : 1);
        } catch (SecurityException unused) {
        }
    }

    public final C0549dt1 h(String str, String str2) {
        C0351aP0 c0351aP0 = this.z;
        if (c0351aP0 == null) {
            return null;
        }
        List list = c0351aP0.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((OO0) list.get(i)).d().equals(str)) {
                C0549dt1 c0549dt1 = new C0549dt1(this, str, str2);
                this.D.add(c0549dt1);
                if (this.H) {
                    c0549dt1.b(this.G);
                }
                k();
                return c0549dt1;
            }
        }
        return null;
    }

    public final void i() {
        if (this.G != null) {
            e(null);
            this.H = false;
            ArrayList arrayList = this.D;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Ys1) arrayList.get(i)).c();
            }
            Xs1 xs1 = this.G;
            xs1.b(2, 0, 0, null, null);
            xs1.b.a.clear();
            xs1.a.getBinder().unlinkToDeath(xs1, 0);
            xs1.i.C.post(new Ws1(xs1, 0));
            this.G = null;
        }
    }

    public final void j() {
        if (this.F) {
            this.F = false;
            i();
            try {
                this.t.unbindService(this);
            } catch (IllegalArgumentException e) {
                Log.e("MediaRouteProviderProxy", this + ": unbindService failed", e);
            }
        }
    }

    public final void k() {
        if (!this.E || (this.x == null && this.D.isEmpty())) {
            j();
        } else {
            g();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.F) {
            i();
            Messenger messenger = iBinder != null ? new Messenger(iBinder) : null;
            if (messenger != null) {
                try {
                    if (messenger.getBinder() != null) {
                        Xs1 xs1 = new Xs1(this, messenger);
                        int i = xs1.d;
                        xs1.d = i + 1;
                        xs1.g = i;
                        if (xs1.b(1, i, 4, null, null)) {
                            try {
                                xs1.a.getBinder().linkToDeath(xs1, 0);
                                this.G = xs1;
                                return;
                            } catch (RemoteException unused) {
                                xs1.binderDied();
                                return;
                            }
                        }
                        return;
                    }
                } catch (NullPointerException unused2) {
                }
            }
            Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        i();
    }

    public final String toString() {
        return "Service connection " + this.B.flattenToShortString();
    }
}
