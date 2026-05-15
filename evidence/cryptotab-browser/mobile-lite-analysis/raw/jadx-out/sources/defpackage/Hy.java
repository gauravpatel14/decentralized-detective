package defpackage;

import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Hy extends AbstractBinderC1598vB2 {
    public final /* synthetic */ Ly t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hy(Ly ly) {
        super("com.google.android.gms.cast.framework.ICastConnectionController");
        this.t = ly;
    }

    @Override // defpackage.AbstractBinderC1598vB2
    public final boolean W0(int i, Parcel parcel, Parcel parcel2) {
        Ly ly = this.t;
        if (i == 1) {
            String string = parcel.readString();
            String string2 = parcel.readString();
            GoogleApiClient googleApiClient = ly.h;
            if (googleApiClient != null) {
                ly.f.getClass();
                googleApiClient.execute(new C1452sV2(googleApiClient, string, string2)).setResultCallback(new Iy(ly, "joinApplication"));
            }
            parcel2.writeNoException();
        } else if (i == 2) {
            String string3 = parcel.readString();
            LaunchOptions launchOptions = (LaunchOptions) QK2.a(parcel, LaunchOptions.CREATOR);
            GoogleApiClient googleApiClient2 = ly.h;
            if (googleApiClient2 != null) {
                ly.f.getClass();
                googleApiClient2.execute(new DQ2(googleApiClient2, string3, launchOptions)).setResultCallback(new Iy(ly, "launchApplication"));
            }
            parcel2.writeNoException();
        } else if (i == 3) {
            String string4 = parcel.readString();
            GoogleApiClient googleApiClient3 = ly.h;
            if (googleApiClient3 != null) {
                ly.f.getClass();
                googleApiClient3.execute(new C1156nW2(googleApiClient3, string4));
            }
            parcel2.writeNoException();
        } else if (i == 4) {
            parcel.readInt();
            Ly.j(ly);
            parcel2.writeNoException();
        } else {
            if (i != 5) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(12451009);
        }
        return true;
    }
}
