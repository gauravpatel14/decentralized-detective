package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;

/* JADX INFO: renamed from: fz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0678fz2 implements GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ StatusPendingResult t;

    public C0678fz2(StatusPendingResult statusPendingResult) {
        this.t = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.t.setResult(new Status(8));
    }
}
