package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: renamed from: xB2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1714xB2 implements IInterface {
    public final IBinder t;
    public final String u;

    public AbstractC1714xB2(IBinder iBinder, String str) {
        this.t = iBinder;
        this.u = str;
    }

    public final void W0(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.t.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.t;
    }
}
