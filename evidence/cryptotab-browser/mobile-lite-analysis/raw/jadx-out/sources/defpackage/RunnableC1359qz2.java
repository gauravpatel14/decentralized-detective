package defpackage;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.IAccountAccessor;

/* JADX INFO: renamed from: qz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1359qz2 implements Runnable {
    public final /* synthetic */ ConnectionResult t;
    public final /* synthetic */ C1418rz2 u;

    public RunnableC1359qz2(C1418rz2 c1418rz2, ConnectionResult connectionResult) {
        this.u = c1418rz2;
        this.t = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccountAccessor iAccountAccessor;
        C1418rz2 c1418rz2 = this.u;
        zabq zabqVar = (zabq) c1418rz2.f.zan.get(c1418rz2.b);
        if (zabqVar == null) {
            return;
        }
        ConnectionResult connectionResult = this.t;
        if (!connectionResult.isSuccess()) {
            zabqVar.zar(connectionResult, null);
            return;
        }
        c1418rz2.e = true;
        Api.Client client = c1418rz2.a;
        if (client.requiresSignIn()) {
            if (!c1418rz2.e || (iAccountAccessor = c1418rz2.c) == null) {
                return;
            }
            client.getRemoteService(iAccountAccessor, c1418rz2.d);
            return;
        }
        try {
            client.getRemoteService(null, client.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            client.disconnect("Failed to get service from broker.");
            zabqVar.zar(new ConnectionResult(10), null);
        }
    }
}
