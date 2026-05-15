package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RH2 extends AbstractBinderC0458cH2 implements NI2 {
    public final AtomicReference t;
    public boolean u;

    public RH2() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        this.t = new AtomicReference();
    }

    public static final Object Z0(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            Log.w("AM", "Unexpected object type. Expected, Received: " + cls.getCanonicalName() + ", " + obj.getClass().getCanonicalName(), e);
            throw e;
        }
    }

    @Override // defpackage.AbstractBinderC0458cH2
    public final boolean W0(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) hH2.a(parcel, Bundle.CREATOR);
        hH2.b(parcel);
        e(bundle);
        parcel2.writeNoException();
        return true;
    }

    public final Bundle X0(long j) {
        Bundle bundle;
        synchronized (this.t) {
            if (!this.u) {
                try {
                    this.t.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.t.get();
        }
        return bundle;
    }

    public final String Y0(long j) {
        return (String) Z0(X0(j), String.class);
    }

    @Override // defpackage.NI2
    public final void e(Bundle bundle) {
        synchronized (this.t) {
            try {
                try {
                    this.t.set(bundle);
                    this.u = true;
                } finally {
                    this.t.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
