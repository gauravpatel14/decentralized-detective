package defpackage;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FF2 extends Binder implements IInterface {
    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        PZ2 pz2 = (PZ2) this;
        if (i == 2) {
            Parcelable.Creator creator = Bundle.CREATOR;
            int i3 = AbstractC0630fI2.a;
            Bundle bundle = (Bundle) (parcel.readInt() != 0 ? (Parcelable) creator.createFromParcel(parcel) : null);
            int iDataAvail = parcel.dataAvail();
            if (iDataAvail > 0) {
                throw new BadParcelableException(AbstractC1214oR1.a(iDataAvail, "Parcel data not fully consumed, unread size: "));
            }
            pz2.b(bundle);
            return true;
        }
        if (i != 3) {
            return false;
        }
        Parcelable.Creator creator2 = Bundle.CREATOR;
        int i4 = AbstractC0630fI2.a;
        Bundle bundle2 = (Bundle) (parcel.readInt() != 0 ? (Parcelable) creator2.createFromParcel(parcel) : null);
        int iDataAvail2 = parcel.dataAvail();
        if (iDataAvail2 > 0) {
            throw new BadParcelableException(AbstractC1214oR1.a(iDataAvail2, "Parcel data not fully consumed, unread size: "));
        }
        pz2.zzb(bundle2);
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
