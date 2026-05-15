package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: uF2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1547uF2 extends Binder implements IInterface {
    public AbstractBinderC1547uF2(String str) {
        attachInterface(this, str);
    }

    public abstract boolean W0(int i, Parcel parcel);

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return W0(i, parcel);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
