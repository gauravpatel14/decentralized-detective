package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.commons.InstallReferrerCommons;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class hx0 implements ServiceConnection {
    public final InstallReferrerStateListener t;
    public final /* synthetic */ ix0 u;

    public hx0(ix0 ix0Var, InstallReferrerStateListener installReferrerStateListener) {
        this.u = ix0Var;
        if (installReferrerStateListener == null) {
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }
        this.t = installReferrerStateListener;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        yr0 c1699wr0;
        InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service connected.");
        int i = AbstractBinderC1756xr0.t;
        if (iBinder == null) {
            c1699wr0 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            c1699wr0 = iInterfaceQueryLocalInterface instanceof yr0 ? (yr0) iInterfaceQueryLocalInterface : new C1699wr0(iBinder);
        }
        ix0 ix0Var = this.u;
        ix0Var.c = c1699wr0;
        ix0Var.a = 2;
        this.t.onInstallReferrerSetupFinished(0);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        InstallReferrerCommons.logWarn("InstallReferrerClient", "Install Referrer service disconnected.");
        ix0 ix0Var = this.u;
        ix0Var.c = null;
        ix0Var.a = 0;
        this.t.onInstallReferrerServiceDisconnected();
    }
}
