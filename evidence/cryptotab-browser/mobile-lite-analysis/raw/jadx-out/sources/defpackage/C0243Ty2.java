package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: renamed from: Ty2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0243Ty2 implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ zaaw t;

    public /* synthetic */ C0243Ty2(zaaw zaawVar) {
        this.t = zaawVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zaaw zaawVar = this.t;
        ((InterfaceC0254Uz2) Preconditions.checkNotNull(zaawVar.zak)).b(new BinderC0229Sy2(zaawVar));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zaaw zaawVar = this.t;
        zaawVar.zab.lock();
        try {
            if (zaawVar.zaI(connectionResult)) {
                zaawVar.zaA();
                zaawVar.zaF();
            } else {
                zaawVar.zaD(connectionResult);
            }
            zaawVar.zab.unlock();
        } catch (Throwable th) {
            zaawVar.zab.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
