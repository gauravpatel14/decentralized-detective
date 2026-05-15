package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.view.Surface;
import org.chromium.base.UnguessableToken;
import org.chromium.content.common.SurfaceWrapper;

/* JADX INFO: renamed from: zr0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1869zr0 implements Br0 {
    public IBinder t;

    @Override // defpackage.Br0
    public final void P(UnguessableToken unguessableToken, Surface surface) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("org.chromium.content.common.IGpuProcessCallback");
            if (unguessableToken != null) {
                parcelObtain.writeInt(1);
                unguessableToken.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (surface != null) {
                parcelObtain.writeInt(1);
                surface.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.t.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.t;
    }

    @Override // defpackage.Br0
    public final SurfaceWrapper e0(int i) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("org.chromium.content.common.IGpuProcessCallback");
            parcelObtain.writeInt(i);
            this.t.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return (SurfaceWrapper) (parcelObtain2.readInt() != 0 ? SurfaceWrapper.CREATOR.createFromParcel(parcelObtain2) : null);
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
