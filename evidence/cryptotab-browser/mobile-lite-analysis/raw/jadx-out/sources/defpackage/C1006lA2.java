package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: renamed from: lA2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1006lA2 implements BaseGmsClient.BaseOnConnectionFailedListener {
    public final /* synthetic */ OnConnectionFailedListener t;

    public C1006lA2(OnConnectionFailedListener onConnectionFailedListener) {
        this.t = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.t.onConnectionFailed(connectionResult);
    }
}
