package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZE1 extends AbstractBinderC1598vB2 {
    public final /* synthetic */ AbstractC0338aF1 t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZE1(AbstractC0338aF1 abstractC0338aF1) {
        super("com.google.android.gms.cast.framework.ISessionProxy");
        this.t = abstractC0338aF1;
    }

    @Override // defpackage.AbstractBinderC1598vB2
    public final boolean W0(int i, Parcel parcel, Parcel parcel2) {
        AbstractC0338aF1 abstractC0338aF1 = this.t;
        switch (i) {
            case 1:
                ObjectWrapper objectWrapper = new ObjectWrapper(abstractC0338aF1);
                parcel2.writeNoException();
                QK2.b(parcel2, objectWrapper);
                return true;
            case 2:
                ((Ly) abstractC0338aF1).k((Bundle) QK2.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
                ((Ly) abstractC0338aF1).k((Bundle) QK2.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                int i2 = QK2.a;
                int i3 = parcel.readInt() != 0 ? 1 : 0;
                Ly ly = (Ly) abstractC0338aF1;
                ly.getClass();
                try {
                    C1570uY2 c1570uY2 = (C1570uY2) ly.e;
                    Parcel parcelW0 = c1570uY2.W0();
                    parcelW0.writeInt(i3);
                    parcelW0.writeInt(0);
                    c1570uY2.Y0(6, parcelW0);
                    break;
                } catch (RemoteException unused) {
                    Ly.k.getClass();
                }
                ly.b(0);
                parcel2.writeNoException();
                return true;
            case 5:
                Ly ly2 = (Ly) abstractC0338aF1;
                ly2.getClass();
                Preconditions.checkMainThread("Must be called from the main thread.");
                Nt1 nt1 = ly2.i;
                long jE = nt1 == null ? 0L : nt1.e() - ly2.i.b();
                parcel2.writeNoException();
                parcel2.writeLong(jE);
                return true;
            case 6:
                parcel2.writeNoException();
                parcel2.writeInt(12451009);
                return true;
            case 7:
                Bundle bundle = (Bundle) QK2.a(parcel, Bundle.CREATOR);
                Ly ly3 = (Ly) abstractC0338aF1;
                ly3.getClass();
                ly3.j = CastDevice.f2(bundle);
                parcel2.writeNoException();
                return true;
            case 8:
                Bundle bundle2 = (Bundle) QK2.a(parcel, Bundle.CREATOR);
                Ly ly4 = (Ly) abstractC0338aF1;
                ly4.getClass();
                ly4.j = CastDevice.f2(bundle2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
