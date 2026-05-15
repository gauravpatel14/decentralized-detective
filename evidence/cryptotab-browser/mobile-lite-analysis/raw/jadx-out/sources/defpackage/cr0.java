package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class cr0 implements InterfaceC0671fr0 {
    public IBinder t;

    public final Bundle W0() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(InterfaceC0671fr0.a);
            parcelObtain.writeString("finishAndRemoveTask");
            parcelObtain.writeInt(0);
            this.t.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return (Bundle) (parcelObtain2.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcelObtain2) : null);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final void X0(int i, int i2, int i3, int i4, int i5, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(InterfaceC0671fr0.a);
            parcelObtain.writeInt(i);
            parcelObtain.writeInt(i2);
            parcelObtain.writeInt(i3);
            parcelObtain.writeInt(i4);
            parcelObtain.writeInt(i5);
            AbstractC0605er0.a(parcelObtain, bundle);
            this.t.transact(10, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.t;
    }
}
