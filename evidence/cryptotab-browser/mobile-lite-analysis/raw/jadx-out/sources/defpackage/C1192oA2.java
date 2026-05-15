package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zak;

/* JADX INFO: renamed from: oA2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1192oA2 implements GoogleApiClient.OnConnectionFailedListener {
    public final int t;
    public final GoogleApiClient u;
    public final GoogleApiClient.OnConnectionFailedListener v;
    public final /* synthetic */ zak w;

    public C1192oA2(zak zakVar, int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.w = zakVar;
        this.t = i;
        this.u = googleApiClient;
        this.v = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        "beginFailureResolution for ".concat(String.valueOf(connectionResult));
        this.w.zah(connectionResult, this.t);
    }
}
