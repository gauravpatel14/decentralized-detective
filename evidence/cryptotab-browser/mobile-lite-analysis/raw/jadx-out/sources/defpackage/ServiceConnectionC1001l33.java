package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: renamed from: l33, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC1001l33 implements ServiceConnection {
    public final /* synthetic */ n33 t;

    public /* synthetic */ ServiceConnectionC1001l33(n33 n33Var) {
        this.t = n33Var;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        n33 n33Var = this.t;
        n33Var.b.b("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        n33Var.a().post(new C1000l23(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        n33 n33Var = this.t;
        n33Var.b.b("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        n33Var.a().post(new A23(this));
    }
}
