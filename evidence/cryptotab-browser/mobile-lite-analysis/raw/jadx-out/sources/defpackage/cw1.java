package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class cw1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        os0 os0Var;
        ResultReceiver resultReceiver = new ResultReceiver();
        IBinder strongBinder = parcel.readStrongBinder();
        int i = dw1.u;
        if (strongBinder == null) {
            os0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(os0.h);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof os0)) {
                ns0 ns0Var = new ns0();
                ns0Var.t = strongBinder;
                os0Var = ns0Var;
            } else {
                os0Var = (os0) iInterfaceQueryLocalInterface;
            }
        }
        resultReceiver.t = os0Var;
        return resultReceiver;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ResultReceiver[i];
    }
}
