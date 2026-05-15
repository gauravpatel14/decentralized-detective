package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DA implements ServiceConnection {
    public boolean A;
    public final Context t;
    public final Intent u;
    public final int v;
    public final Handler w;
    public final Wz x;
    public Zz y;
    public final String z;

    public DA(Context context, Intent intent, int i, Handler handler, Wz wz, Zz zz, String str) {
        this.t = context;
        this.u = intent;
        this.v = i;
        this.w = handler;
        this.x = wz;
        this.y = zz;
        this.z = str;
    }

    public final boolean a() {
        try {
            TraceEvent.a("ChildServiceConnectionImpl.bindServiceConnection", null);
            this.A = Ep.b(this.t, this.u, this, this.v, this.w, this.x, this.z);
            TraceEvent.b("ChildServiceConnectionImpl.bindServiceConnection");
            return this.A;
        } catch (Throwable th) {
            TraceEvent.b("ChildServiceConnectionImpl.bindServiceConnection");
            throw th;
        }
    }

    public final void b() {
        if (this.A) {
            this.t.unbindService(this);
            this.A = false;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        final Zz zz = this.y;
        if (zz == null) {
            Log.w("cr_ChildServiceConn", "onServiceConnected after timeout " + componentName);
        } else {
            C0619fA c0619fA = zz.a;
            if (c0619fA.b.getLooper() == Looper.myLooper()) {
                c0619fA.h(iBinder);
            } else {
                c0619fA.b.post(new Runnable() { // from class: Yz
                    @Override // java.lang.Runnable
                    public final void run() {
                        zz.a.h(iBinder);
                    }
                });
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Zz zz = this.y;
        if (zz != null) {
            C0619fA c0619fA = zz.a;
            if (c0619fA.b.getLooper() == Looper.myLooper()) {
                c0619fA.i();
            } else {
                c0619fA.b.post(new Vz(1, zz));
            }
        }
    }
}
