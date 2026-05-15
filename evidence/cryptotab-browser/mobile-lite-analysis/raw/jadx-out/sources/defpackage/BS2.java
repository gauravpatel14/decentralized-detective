package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BS2 extends rF2 {
    public final InterfaceC0904jV2 a1(ObjectWrapper objectWrapper, CastOptions castOptions, V23 v23, HashMap map) {
        InterfaceC0904jV2 ax2;
        Parcel parcelW0 = W0();
        QK2.b(parcelW0, objectWrapper);
        QK2.c(parcelW0, castOptions);
        QK2.b(parcelW0, v23);
        parcelW0.writeMap(map);
        Parcel parcelX0 = X0(1, parcelW0);
        IBinder strongBinder = parcelX0.readStrongBinder();
        int i = YU2.t;
        if (strongBinder == null) {
            ax2 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastContext");
            ax2 = iInterfaceQueryLocalInterface instanceof InterfaceC0904jV2 ? (InterfaceC0904jV2) iInterfaceQueryLocalInterface : new AX2(strongBinder, "com.google.android.gms.cast.framework.ICastContext");
        }
        parcelX0.recycle();
        return ax2;
    }
}
