package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: w03, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC1649w03 implements ServiceConnection, zzt {
    public final HashMap t = new HashMap();
    public int u = 2;
    public boolean v;
    public IBinder w;
    public final zzo x;
    public ComponentName y;
    public final /* synthetic */ C0445c23 z;

    public ServiceConnectionC1649w03(C0445c23 c0445c23, zzo zzoVar) {
        this.z = c0445c23;
        this.x = zzoVar;
    }

    public final void a(String str, Executor executor) {
        this.u = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.isAtLeastS()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            C0445c23 c0445c23 = this.z;
            ConnectionTracker connectionTracker = c0445c23.e;
            Context context = c0445c23.b;
            boolean zZza = connectionTracker.zza(context, str, this.x.zzb(context), this, 4225, executor);
            this.v = zZza;
            if (zZza) {
                this.z.c.sendMessageDelayed(this.z.c.obtainMessage(1, this.x), this.z.g);
            } else {
                this.u = 2;
                try {
                    C0445c23 c0445c232 = this.z;
                    c0445c232.e.unbindService(c0445c232.b, this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th) {
            StrictMode.setVmPolicy(vmPolicy);
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.z.a) {
            try {
                this.z.c.removeMessages(1, this.x);
                this.w = iBinder;
                this.y = componentName;
                Iterator it = this.t.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.u = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.z.a) {
            try {
                this.z.c.removeMessages(1, this.x);
                this.w = null;
                this.y = componentName;
                Iterator it = this.t.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.u = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
