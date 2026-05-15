package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: q13, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1304q13 implements InterfaceC0818i23, IInterface {
    public final IBinder t;

    public C1304q13(IBinder iBinder) {
        this.t = iBinder;
    }

    public final int W0(int i, String str, String str2, Bundle bundle) {
        Parcel parcelY0 = Y0();
        parcelY0.writeInt(i);
        parcelY0.writeString(str);
        parcelY0.writeString(str2);
        int i2 = x33.a;
        parcelY0.writeInt(1);
        bundle.writeToParcel(parcelY0, 0);
        Parcel parcelZ0 = Z0(10, parcelY0);
        int i3 = parcelZ0.readInt();
        parcelZ0.recycle();
        return i3;
    }

    public final Bundle X0(int i, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcelY0 = Y0();
        parcelY0.writeInt(i);
        parcelY0.writeString(str);
        parcelY0.writeString(str2);
        int i2 = x33.a;
        parcelY0.writeInt(1);
        bundle.writeToParcel(parcelY0, 0);
        parcelY0.writeInt(1);
        bundle2.writeToParcel(parcelY0, 0);
        Parcel parcelZ0 = Z0(901, parcelY0);
        Bundle bundle3 = (Bundle) x33.a(parcelZ0, Bundle.CREATOR);
        parcelZ0.recycle();
        return bundle3;
    }

    public final Parcel Y0() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        return parcelObtain;
    }

    public final Parcel Z0(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.t.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.t;
    }
}
