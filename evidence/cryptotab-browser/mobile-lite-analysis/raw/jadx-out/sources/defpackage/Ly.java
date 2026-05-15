package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.HashSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ly extends AbstractC0338aF1 {
    public static final YL2 k = new YL2("CastSession");
    public final Context c;
    public final HashSet d;
    public final InterfaceC1221oW2 e;
    public final ty f;
    public final C1256pD2 g;
    public GoogleApiClient h;
    public Nt1 i;
    public CastDevice j;

    public Ly(Context context, String str, String str2, CastOptions castOptions, ty tyVar, C1256pD2 c1256pD2) {
        InterfaceC1221oW2 c1570uY2;
        super(context, str, str2);
        this.d = new HashSet();
        this.c = context.getApplicationContext();
        this.f = tyVar;
        this.g = c1256pD2;
        Zr0 zr0C = c();
        Hy hy = new Hy(this);
        BS2 bs2A = SM2.a(context);
        InterfaceC1221oW2 interfaceC1221oW2 = null;
        try {
            Parcel parcelW0 = bs2A.W0();
            QK2.c(parcelW0, castOptions);
            QK2.b(parcelW0, zr0C);
            QK2.b(parcelW0, hy);
            Parcel parcelX0 = bs2A.X0(3, parcelW0);
            IBinder strongBinder = parcelX0.readStrongBinder();
            int i = AbstractBinderC0479cW2.t;
            if (strongBinder == null) {
                c1570uY2 = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastSession");
                c1570uY2 = iInterfaceQueryLocalInterface instanceof InterfaceC1221oW2 ? (InterfaceC1221oW2) iInterfaceQueryLocalInterface : new C1570uY2(strongBinder, "com.google.android.gms.cast.framework.ICastSession");
            }
            parcelX0.recycle();
            interfaceC1221oW2 = c1570uY2;
        } catch (RemoteException unused) {
            SM2.a.getClass();
        }
        this.e = interfaceC1221oW2;
    }

    public static void j(Ly ly) {
        ly.g.getClass();
        GoogleApiClient googleApiClient = ly.h;
        if (googleApiClient != null) {
            googleApiClient.disconnect();
            ly.h = null;
        }
        ly.j = null;
        Nt1 nt1 = ly.i;
        if (nt1 != null) {
            nt1.q(null);
            ly.i = null;
        }
    }

    public final ApplicationMetadata d() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        GoogleApiClient googleApiClient = this.h;
        if (googleApiClient == null) {
            return null;
        }
        this.f.getClass();
        OJ2 oj2 = (OJ2) googleApiClient.getClient(ML2.a);
        oj2.checkConnected();
        return oj2.t;
    }

    public final CastDevice e() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.j;
    }

    public final Nt1 f() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.i;
    }

    public final double g() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        GoogleApiClient googleApiClient = this.h;
        if (googleApiClient == null) {
            return 0.0d;
        }
        this.f.getClass();
        OJ2 oj2 = (OJ2) googleApiClient.getClient(ML2.a);
        oj2.checkConnected();
        return oj2.F;
    }

    public final void h(boolean z) throws IOException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        GoogleApiClient googleApiClient = this.h;
        if (googleApiClient != null) {
            this.f.getClass();
            try {
                OJ2 oj2 = (OJ2) googleApiClient.getClient(ML2.a);
                C1836zL2 c1836zL2 = (C1836zL2) oj2.getService();
                if (oj2.k()) {
                    double d = oj2.F;
                    boolean z2 = oj2.B;
                    Parcel parcelW0 = c1836zL2.W0();
                    int i = QK2.a;
                    parcelW0.writeInt(z ? 1 : 0);
                    parcelW0.writeDouble(d);
                    parcelW0.writeInt(z2 ? 1 : 0);
                    c1836zL2.Z0(8, parcelW0);
                }
            } catch (RemoteException unused) {
                throw new IOException("service error");
            }
        }
    }

    public final void i(double d) throws IOException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        GoogleApiClient googleApiClient = this.h;
        if (googleApiClient != null) {
            this.f.getClass();
            try {
                ((OJ2) googleApiClient.getClient(ML2.a)).e(d);
            } catch (RemoteException unused) {
                throw new IOException("service error");
            }
        }
    }

    public final void k(Bundle bundle) {
        YL2 yl2 = AbstractC0338aF1.b;
        InterfaceC0878j23 interfaceC0878j23 = this.a;
        CastDevice castDeviceF2 = CastDevice.f2(bundle);
        this.j = castDeviceF2;
        boolean z = false;
        if (castDeviceF2 == null) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            try {
                M23 m23 = (M23) interfaceC0878j23;
                Parcel parcelX0 = m23.X0(9, m23.W0());
                int i = QK2.a;
                boolean z2 = parcelX0.readInt() != 0;
                parcelX0.recycle();
                z = z2;
            } catch (RemoteException unused) {
                yl2.getClass();
            }
            if (z) {
                try {
                    M23 m232 = (M23) interfaceC0878j23;
                    Parcel parcelW0 = m232.W0();
                    parcelW0.writeInt(8);
                    m232.Y0(15, parcelW0);
                    return;
                } catch (RemoteException unused2) {
                    yl2.getClass();
                    return;
                }
            }
            try {
                M23 m233 = (M23) interfaceC0878j23;
                Parcel parcelW02 = m233.W0();
                parcelW02.writeInt(8);
                m233.Y0(12, parcelW02);
                return;
            } catch (RemoteException unused3) {
                yl2.getClass();
                return;
            }
        }
        GoogleApiClient googleApiClient = this.h;
        if (googleApiClient != null) {
            googleApiClient.disconnect();
            this.h = null;
        }
        k.getClass();
        Jy jy = new Jy(this);
        CastDevice castDevice = this.j;
        Ky ky = new Ky(this);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", false);
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", false);
        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.c);
        Api api = AbstractC1874zy.a;
        uy uyVar = new uy();
        Preconditions.checkNotNull(castDevice, "CastDevice parameter cannot be null");
        Preconditions.checkNotNull(ky, "CastListener parameter cannot be null");
        uyVar.a = castDevice;
        uyVar.b = ky;
        uyVar.c = bundle2;
        GoogleApiClient googleApiClientBuild = builder.addApi(api, new vy(uyVar)).addConnectionCallbacks(jy).addOnConnectionFailedListener(jy).build();
        this.h = googleApiClientBuild;
        googleApiClientBuild.connect();
    }
}
