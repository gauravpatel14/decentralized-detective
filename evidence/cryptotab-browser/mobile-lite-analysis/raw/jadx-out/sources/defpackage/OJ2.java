package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.zzae;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OJ2 extends GmsClient {
    public static final YL2 Q = new YL2("CastClientImpl");
    public static final Object R = new Object();
    public static final Object S = new Object();
    public String A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public double F;
    public zzae G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final AtomicLong f3J;
    public String K;
    public String L;
    public Bundle M;
    public final HashMap N;
    public yy O;
    public C1156nW2 P;
    public ApplicationMetadata t;
    public final CastDevice u;
    public final Ky v;
    public final HashMap w;
    public final long x;
    public final Bundle y;
    public WJ2 z;

    public OJ2(Context context, Looper looper, ClientSettings clientSettings, CastDevice castDevice, long j, Ky ky, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.u = castDevice;
        this.v = ky;
        this.x = j;
        this.y = bundle;
        this.w = new HashMap();
        this.f3J = new AtomicLong(0L);
        this.N = new HashMap();
        this.E = false;
        this.H = -1;
        this.I = -1;
        this.t = null;
        this.A = null;
        this.F = 0.0d;
        l();
        this.B = false;
        this.G = null;
        l();
    }

    public final void c(String str) {
        xy xyVar;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.w) {
            xyVar = (xy) this.w.remove(str);
        }
        if (xyVar != null) {
            try {
                C1836zL2 c1836zL2 = (C1836zL2) getService();
                Parcel parcelW0 = c1836zL2.W0();
                parcelW0.writeString(str);
                c1836zL2.Z0(12, parcelW0);
            } catch (IllegalStateException e) {
                YL2 yl2 = Q;
                e.getMessage();
                yl2.getClass();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return iInterfaceQueryLocalInterface instanceof C1836zL2 ? (C1836zL2) iInterfaceQueryLocalInterface : new C1836zL2(iBinder, "com.google.android.gms.cast.internal.ICastDeviceController");
    }

    public final void d(String str, xy xyVar) {
        AbstractC0700gL2.d(str);
        c(str);
        synchronized (this.w) {
            this.w.put(str, xyVar);
        }
        C1836zL2 c1836zL2 = (C1836zL2) getService();
        if (k()) {
            Parcel parcelW0 = c1836zL2.W0();
            parcelW0.writeString(str);
            c1836zL2.Z0(11, parcelW0);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        isConnected();
        Q.getClass();
        WJ2 wj2 = this.z;
        OJ2 oj2 = null;
        this.z = null;
        if (wj2 != null) {
            OJ2 oj22 = (OJ2) wj2.t.getAndSet(null);
            if (oj22 != null) {
                oj22.E = false;
                oj22.H = -1;
                oj22.I = -1;
                oj22.t = null;
                oj22.A = null;
                oj22.F = 0.0d;
                oj22.l();
                oj22.B = false;
                oj22.G = null;
                oj2 = oj22;
            }
            if (oj2 == null) {
                return;
            }
            j();
            try {
                try {
                    C1836zL2 c1836zL2 = (C1836zL2) getService();
                    c1836zL2.Z0(1, c1836zL2.W0());
                } finally {
                    super.disconnect();
                }
            } catch (RemoteException | IllegalStateException e) {
                e.getMessage();
            }
        }
    }

    public final void e(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Volume cannot be ");
            sb.append(d);
            throw new IllegalArgumentException(sb.toString());
        }
        C1836zL2 c1836zL2 = (C1836zL2) getService();
        if (k()) {
            double d2 = this.F;
            boolean z = this.B;
            Parcel parcelW0 = c1836zL2.W0();
            parcelW0.writeDouble(d);
            parcelW0.writeDouble(d2);
            int i = QK2.a;
            parcelW0.writeInt(z ? 1 : 0);
            c1836zL2.Z0(7, parcelW0);
        }
    }

    public final void f(yy yyVar) {
        synchronized (R) {
            try {
                yy yyVar2 = this.O;
                if (yyVar2 != null) {
                    yyVar2.setResult((Object) new C0401bK2(new Status(2002)));
                }
                this.O = yyVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(String str, String str2, UO2 uo2) {
        HashMap map = this.N;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() > 524288) {
            YL2 yl2 = Q;
            Log.w(yl2.a, yl2.b("Message send failed. Message exceeds maximum size", new Object[0]));
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        AbstractC0700gL2.d(str);
        long jIncrementAndGet = this.f3J.incrementAndGet();
        try {
            map.put(Long.valueOf(jIncrementAndGet), uo2);
            C1836zL2 c1836zL2 = (C1836zL2) getService();
            if (!k()) {
                i(2016, jIncrementAndGet);
                return;
            }
            Parcel parcelW0 = c1836zL2.W0();
            parcelW0.writeString(str);
            parcelW0.writeString(str2);
            parcelW0.writeLong(jIncrementAndGet);
            c1836zL2.Z0(9, parcelW0);
        } catch (Throwable th) {
            map.remove(Long.valueOf(jIncrementAndGet));
            throw th;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        Bundle bundle = this.M;
        if (bundle == null) {
            return super.getConnectionHint();
        }
        this.M = null;
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        Q.getClass();
        CastDevice castDevice = this.u;
        castDevice.getClass();
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", castDevice);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.x);
        Bundle bundle2 = this.y;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        WJ2 wj2 = new WJ2(this);
        this.z = wj2;
        bundle.putParcelable(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, new BinderWrapper(wj2));
        String str = this.K;
        if (str != null) {
            bundle.putString("last_application_id", str);
            String str2 = this.L;
            if (str2 != null) {
                bundle.putString("last_session_id", str2);
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    public final void h(String str, C1156nW2 c1156nW2) {
        synchronized (S) {
            try {
                if (this.P != null) {
                    c1156nW2.setResult((Object) new Status(2001));
                } else {
                    this.P = c1156nW2;
                }
            } finally {
            }
        }
        C1836zL2 c1836zL2 = (C1836zL2) getService();
        if (!k()) {
            n(2016);
            return;
        }
        Parcel parcelW0 = c1836zL2.W0();
        parcelW0.writeString(str);
        c1836zL2.Z0(5, parcelW0);
    }

    public final void i(int i, long j) {
        BaseImplementation.ResultHolder resultHolder;
        synchronized (this.N) {
            resultHolder = (BaseImplementation.ResultHolder) this.N.remove(Long.valueOf(j));
        }
        if (resultHolder != null) {
            resultHolder.setResult(new Status(i));
        }
    }

    public final void j() {
        Q.getClass();
        synchronized (this.w) {
            this.w.clear();
        }
    }

    public final boolean k() {
        WJ2 wj2;
        return (!this.E || (wj2 = this.z) == null || wj2.t.get() == null) ? false : true;
    }

    public final void l() {
        CastDevice castDevice = this.u;
        if (castDevice.g2(2048) || !castDevice.g2(4) || castDevice.g2(1)) {
            return;
        }
        "Chromecast Audio".equals(castDevice.x);
    }

    public final void m(int i) {
        synchronized (R) {
            try {
                yy yyVar = this.O;
                if (yyVar != null) {
                    yyVar.setResult((Object) new C0401bK2(new Status(i)));
                    this.O = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(int i) {
        synchronized (S) {
            try {
                C1156nW2 c1156nW2 = this.P;
                if (c1156nW2 != null) {
                    c1156nW2.setResult((Object) new Status(i));
                    this.P = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        j();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        Q.getClass();
        if (i == 0 || i == 1001) {
            this.E = true;
            this.C = true;
            this.D = true;
        } else {
            this.E = false;
        }
        if (i == 1001) {
            Bundle bundle2 = new Bundle();
            this.M = bundle2;
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            i = 0;
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }
}
