package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Iy implements ResultCallback {
    public final /* synthetic */ Ly a;

    public Iy(Ly ly, String str) {
        this.a = ly;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        sy syVar = (sy) result;
        YL2 yl2 = Ly.k;
        Ly ly = this.a;
        ly.getClass();
        try {
            boolean zIsSuccess = syVar.getStatus().isSuccess();
            InterfaceC1221oW2 interfaceC1221oW2 = ly.e;
            if (!zIsSuccess) {
                Ly.k.getClass();
                int statusCode = syVar.getStatus().getStatusCode();
                C1570uY2 c1570uY2 = (C1570uY2) interfaceC1221oW2;
                Parcel parcelW0 = c1570uY2.W0();
                parcelW0.writeInt(statusCode);
                c1570uY2.Y0(5, parcelW0);
                return;
            }
            Ly.k.getClass();
            Nt1 nt1 = new Nt1(new UL2(), ly.f);
            ly.i = nt1;
            try {
                nt1.q(ly.h);
                Nt1 nt12 = ly.i;
                GoogleApiClient googleApiClient = nt12.f;
                if (googleApiClient != null) {
                    Preconditions.checkMainThread("Must be called from the main thread.");
                    nt12.c.getClass();
                    String str = UL2.s;
                    nt12.e.getClass();
                    try {
                        ((OJ2) googleApiClient.getClient(ML2.a)).d(str, nt12);
                    } catch (RemoteException unused) {
                        throw new IOException("service error");
                    }
                }
                ly.i.l();
                C1256pD2 c1256pD2 = ly.g;
                ly.e();
                c1256pD2.getClass();
            } catch (IOException e) {
                YL2 yl22 = Ly.k;
                Log.e(yl22.a, yl22.b("Exception when setting GoogleApiClient.", new Object[0]), e);
                ly.i = null;
            }
            ApplicationMetadata applicationMetadataC2 = syVar.c2();
            String strJ = syVar.J();
            String strG1 = syVar.g1();
            boolean zN = syVar.n();
            C1570uY2 c1570uY22 = (C1570uY2) interfaceC1221oW2;
            Parcel parcelW02 = c1570uY22.W0();
            QK2.c(parcelW02, applicationMetadataC2);
            parcelW02.writeString(strJ);
            parcelW02.writeString(strG1);
            parcelW02.writeInt(zN ? 1 : 0);
            c1570uY22.Y0(4, parcelW02);
        } catch (RemoteException unused2) {
            Ly.k.getClass();
        }
    }
}
