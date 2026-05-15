package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.view.Surface;
import org.chromium.base.UnguessableToken;
import org.chromium.content.common.SurfaceWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ar0 extends Binder implements Br0 {
    public static final /* synthetic */ int t = 0;

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("org.chromium.content.common.IGpuProcessCallback");
        }
        if (i == 1598968902) {
            parcel2.writeString("org.chromium.content.common.IGpuProcessCallback");
            return true;
        }
        if (i == 1) {
            P((UnguessableToken) (parcel.readInt() != 0 ? UnguessableToken.CREATOR.createFromParcel(parcel) : null), (Surface) (parcel.readInt() != 0 ? Surface.CREATOR.createFromParcel(parcel) : null));
        } else {
            if (i != 2) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            SurfaceWrapper surfaceWrapperE0 = e0(parcel.readInt());
            parcel2.writeNoException();
            if (surfaceWrapperE0 != null) {
                parcel2.writeInt(1);
                surfaceWrapperE0.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
        }
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
