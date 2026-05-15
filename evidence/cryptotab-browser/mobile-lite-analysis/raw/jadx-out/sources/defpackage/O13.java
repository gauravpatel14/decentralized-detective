package defpackage;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class O13 implements Handler.Callback {
    public final /* synthetic */ C0445c23 t;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.t.a) {
                try {
                    zzo zzoVar = (zzo) message.obj;
                    ServiceConnectionC1649w03 serviceConnectionC1649w03 = (ServiceConnectionC1649w03) this.t.a.get(zzoVar);
                    if (serviceConnectionC1649w03 != null && serviceConnectionC1649w03.t.isEmpty()) {
                        if (serviceConnectionC1649w03.v) {
                            serviceConnectionC1649w03.z.c.removeMessages(1, serviceConnectionC1649w03.x);
                            C0445c23 c0445c23 = serviceConnectionC1649w03.z;
                            c0445c23.e.unbindService(c0445c23.b, serviceConnectionC1649w03);
                            serviceConnectionC1649w03.v = false;
                            serviceConnectionC1649w03.u = 2;
                        }
                        this.t.a.remove(zzoVar);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.t.a) {
            try {
                zzo zzoVar2 = (zzo) message.obj;
                ServiceConnectionC1649w03 serviceConnectionC1649w032 = (ServiceConnectionC1649w03) this.t.a.get(zzoVar2);
                if (serviceConnectionC1649w032 != null && serviceConnectionC1649w032.u == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(zzoVar2)), new Exception());
                    ComponentName componentName = serviceConnectionC1649w032.y;
                    if (componentName == null) {
                        componentName = zzoVar2.zza();
                    }
                    if (componentName == null) {
                        String strZzc = zzoVar2.zzc();
                        Preconditions.checkNotNull(strZzc);
                        componentName = new ComponentName(strZzc, "unknown");
                    }
                    serviceConnectionC1649w032.onServiceDisconnected(componentName);
                }
            } finally {
            }
        }
        return true;
    }
}
