package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: zS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1846zS2 implements IInterface {
    public final IBinder t;
    public final String u;

    public C1846zS2(IBinder iBinder, String str) {
        this.t = iBinder;
        this.u = str;
    }

    public final void W0(int i) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.u);
        parcelObtain.writeInt(i);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.t.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.t;
    }
}
