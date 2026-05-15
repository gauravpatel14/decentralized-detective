package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jy implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ Ly t;

    public Jy(Ly ly) {
        this.t = ly;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Ly ly = this.t;
        try {
            Nt1 nt1 = ly.i;
            if (nt1 != null) {
                try {
                    GoogleApiClient googleApiClient = nt1.f;
                    if (googleApiClient != null) {
                        Preconditions.checkMainThread("Must be called from the main thread.");
                        nt1.c.getClass();
                        String str = UL2.s;
                        nt1.e.getClass();
                        try {
                            ((OJ2) googleApiClient.getClient(ML2.a)).d(str, nt1);
                        } catch (RemoteException unused) {
                            throw new IOException("service error");
                        }
                    }
                    ly.i.l();
                } catch (IOException e) {
                    YL2 yl2 = Ly.k;
                    Log.e(yl2.a, yl2.b("Exception when setting GoogleApiClient.", new Object[0]), e);
                    ly.i = null;
                }
            }
            C1570uY2 c1570uY2 = (C1570uY2) ly.e;
            Parcel parcelW0 = c1570uY2.W0();
            QK2.c(parcelW0, bundle);
            c1570uY2.Y0(1, parcelW0);
        } catch (RemoteException unused2) {
            Ly.k.getClass();
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            C1570uY2 c1570uY2 = (C1570uY2) this.t.e;
            Parcel parcelW0 = c1570uY2.W0();
            QK2.c(parcelW0, connectionResult);
            c1570uY2.Y0(3, parcelW0);
        } catch (RemoteException unused) {
            Ly.k.getClass();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            C1570uY2 c1570uY2 = (C1570uY2) this.t.e;
            Parcel parcelW0 = c1570uY2.W0();
            parcelW0.writeInt(i);
            c1570uY2.Y0(2, parcelW0);
        } catch (RemoteException unused) {
            Ly.k.getClass();
        }
    }
}
