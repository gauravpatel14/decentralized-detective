package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Looper;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: c23, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0445c23 extends GmsClientSupervisor {
    public final HashMap a = new HashMap();
    public final Context b;
    public volatile HandlerC0531dU2 c;
    public final O13 d;
    public final ConnectionTracker e;
    public final long f;
    public final long g;
    public volatile Executor h;

    public C0445c23(Context context, Looper looper, Executor executor) {
        O13 o13 = new O13(this);
        this.d = o13;
        this.b = context.getApplicationContext();
        this.c = new HandlerC0531dU2(looper, o13);
        this.e = ConnectionTracker.getInstance();
        this.f = 5000L;
        this.g = 300000L;
        this.h = executor;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zza(zzo zzoVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.a) {
            try {
                ServiceConnectionC1649w03 serviceConnectionC1649w03 = (ServiceConnectionC1649w03) this.a.get(zzoVar);
                if (serviceConnectionC1649w03 == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + zzoVar.toString());
                }
                if (!serviceConnectionC1649w03.t.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzoVar.toString());
                }
                serviceConnectionC1649w03.t.remove(serviceConnection);
                if (serviceConnectionC1649w03.t.isEmpty()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, zzoVar), this.f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zzc(zzo zzoVar, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean z;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.a) {
            try {
                ServiceConnectionC1649w03 serviceConnectionC1649w03 = (ServiceConnectionC1649w03) this.a.get(zzoVar);
                if (executor == null) {
                    executor = this.h;
                }
                if (serviceConnectionC1649w03 == null) {
                    serviceConnectionC1649w03 = new ServiceConnectionC1649w03(this, zzoVar);
                    serviceConnectionC1649w03.t.put(serviceConnection, serviceConnection);
                    serviceConnectionC1649w03.a(str, executor);
                    this.a.put(zzoVar, serviceConnectionC1649w03);
                } else {
                    this.c.removeMessages(0, zzoVar);
                    if (serviceConnectionC1649w03.t.containsKey(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzoVar.toString());
                    }
                    serviceConnectionC1649w03.t.put(serviceConnection, serviceConnection);
                    int i = serviceConnectionC1649w03.u;
                    if (i == 1) {
                        serviceConnection.onServiceConnected(serviceConnectionC1649w03.y, serviceConnectionC1649w03.w);
                    } else if (i == 2) {
                        serviceConnectionC1649w03.a(str, executor);
                    }
                }
                z = serviceConnectionC1649w03.v;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
