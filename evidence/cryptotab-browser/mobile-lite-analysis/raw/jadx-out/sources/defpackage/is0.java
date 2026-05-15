package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class is0 implements InterfaceC0991ks0 {
    public IBinder t;

    public final void W0() {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("org.chromium.components.payments.IPaymentDetailsUpdateServiceCallback");
            this.t.transact(2, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    public final void X0(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("org.chromium.components.payments.IPaymentDetailsUpdateServiceCallback");
            parcelObtain.writeInt(1);
            bundle.writeToParcel(parcelObtain, 0);
            this.t.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.t;
    }
}
