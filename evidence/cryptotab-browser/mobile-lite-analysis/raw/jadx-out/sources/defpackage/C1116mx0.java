package defpackage;

import android.util.Log;
import com.android.installreferrer.api.InstallReferrerStateListener;

/* JADX INFO: renamed from: mx0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1116mx0 implements InstallReferrerStateListener {
    public final /* synthetic */ C1178nx0 a;

    public C1116mx0(C1178nx0 c1178nx0) {
        this.a = c1178nx0;
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
        Log.i("cr_InstallReferrerService", "On disconnected");
        this.a.b.startConnection(this);
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        String installReferrer;
        Log.i("cr_InstallReferrerService", "On setup finished with response code: " + i);
        C1178nx0 c1178nx0 = this.a;
        if (i == 0) {
            try {
                installReferrer = c1178nx0.b.getInstallReferrer().getInstallReferrer();
            } catch (Exception e) {
                e = e;
                installReferrer = null;
            }
            try {
                Log.i("cr_InstallReferrerService", "Setup finished with install referrer: " + installReferrer);
                c1178nx0.b.endConnection();
            } catch (Exception e2) {
                e = e2;
                Log.e("cr_InstallReferrerService", "Response error", e);
            }
        } else {
            installReferrer = null;
        }
        jx0 jx0Var = c1178nx0.a;
        if (jx0Var != null) {
            jx0Var.a0(installReferrer);
            c1178nx0.a = null;
        }
    }
}
