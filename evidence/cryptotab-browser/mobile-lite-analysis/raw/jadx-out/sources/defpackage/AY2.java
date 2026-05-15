package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.internal.vision.zzk;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AY2 extends AbstractC1651w23 {
    public final zzk i;

    public AY2(Context context, zzk zzkVar) {
        super(context, "BarcodeNativeHandle", "barcode");
        this.i = zzkVar;
        e();
    }

    @Override // defpackage.AbstractC1651w23
    public final Object a(m50 m50Var, Context context) throws DynamiteModule$LoadingException {
        A03 a03;
        IBinder iBinderB = m50Var.b("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
        MZ2 mz2 = null;
        if (iBinderB == null) {
            a03 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
            a03 = iInterfaceQueryLocalInterface instanceof A03 ? (A03) iInterfaceQueryLocalInterface : new A03(iBinderB, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
        }
        if (a03 == null) {
            return null;
        }
        ObjectWrapper objectWrapper = new ObjectWrapper(context);
        zzk zzkVar = (zzk) Preconditions.checkNotNull(this.i);
        Parcel parcelW0 = a03.W0();
        AbstractC1777yK2.a(parcelW0, objectWrapper);
        AbstractC1777yK2.b(parcelW0, zzkVar);
        Parcel parcelX0 = a03.X0(1, parcelW0);
        IBinder strongBinder = parcelX0.readStrongBinder();
        if (strongBinder != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            mz2 = iInterfaceQueryLocalInterface2 instanceof MZ2 ? (MZ2) iInterfaceQueryLocalInterface2 : new MZ2(strongBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
        }
        parcelX0.recycle();
        return mz2;
    }

    @Override // defpackage.AbstractC1651w23
    public final void b() {
        if (c()) {
            MZ2 mz2 = (MZ2) Preconditions.checkNotNull((MZ2) e());
            mz2.Y0(3, mz2.W0());
        }
    }
}
