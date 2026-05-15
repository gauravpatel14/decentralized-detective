package defpackage;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* JADX INFO: renamed from: rz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1418rz2 implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {
    public final Api.Client a;
    public final ApiKey b;
    public IAccountAccessor c = null;
    public Set d = null;
    public boolean e = false;
    public final /* synthetic */ GoogleApiManager f;

    public C1418rz2(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.f = googleApiManager;
        this.a = client;
        this.b = apiKey;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.f.zar.post(new RunnableC1359qz2(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zae(ConnectionResult connectionResult) {
        zabq zabqVar = (zabq) this.f.zan.get(this.b);
        if (zabqVar != null) {
            zabqVar.zas(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zaf(IAccountAccessor iAccountAccessor, Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zae(new ConnectionResult(4));
            return;
        }
        this.c = iAccountAccessor;
        this.d = set;
        if (this.e) {
            this.a.getRemoteService(iAccountAccessor, set);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zag(int i) {
        zabq zabqVar = (zabq) this.f.zan.get(this.b);
        if (zabqVar != null) {
            if (zabqVar.zaj) {
                zabqVar.zas(new ConnectionResult(17));
            } else {
                zabqVar.onConnectionSuspended(i);
            }
        }
    }
}
