package defpackage;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class rr0 implements tr0 {
    public IBinder t;

    public final void W0(BinderC0662ff0 binderC0662ff0, String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
            parcelObtain.writeStrongBinder(binderC0662ff0);
            parcelObtain.writeString(str);
            this.t.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.t;
    }
}
