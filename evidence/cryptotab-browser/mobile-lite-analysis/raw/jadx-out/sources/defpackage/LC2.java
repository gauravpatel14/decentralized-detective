package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LC2 implements ServiceConnection {
    public final /* synthetic */ C0562eD2 t;

    public /* synthetic */ LC2(C0562eD2 c0562eD2) {
        this.t = c0562eD2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0562eD2 c0562eD2 = this.t;
        c0562eD2.b.c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        c0562eD2.a().post(new C0623fC2(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C0562eD2 c0562eD2 = this.t;
        c0562eD2.b.c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        c0562eD2.a().post(new C1255pC2(this));
    }
}
