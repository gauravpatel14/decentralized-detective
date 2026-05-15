package defpackage;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class kn extends tX {
    public final AY2 c;

    public kn(AY2 ay2) {
        this.c = ay2;
    }

    @Override // defpackage.tX
    public final SparseArray a(aj0 aj0Var) {
        Barcode[] barcodeArr;
        if (aj0Var == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        zzs zzsVarF2 = zzs.f2(aj0Var);
        Bitmap bitmap = aj0Var.c;
        AY2 ay2 = this.c;
        if (bitmap != null) {
            Bitmap bitmap2 = (Bitmap) Preconditions.checkNotNull(bitmap);
            if (ay2.c()) {
                try {
                    ObjectWrapper objectWrapper = new ObjectWrapper(bitmap2);
                    MZ2 mz2 = (MZ2) Preconditions.checkNotNull((MZ2) ay2.e());
                    Parcel parcelW0 = mz2.W0();
                    AbstractC1777yK2.a(parcelW0, objectWrapper);
                    AbstractC1777yK2.b(parcelW0, zzsVarF2);
                    Parcel parcelX0 = mz2.X0(2, parcelW0);
                    Barcode[] barcodeArr2 = (Barcode[]) parcelX0.createTypedArray(Barcode.CREATOR);
                    parcelX0.recycle();
                    barcodeArr = barcodeArr2;
                } catch (RemoteException e) {
                    Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
                    barcodeArr = new Barcode[0];
                }
            } else {
                barcodeArr = new Barcode[0];
            }
            if (barcodeArr == null) {
                throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
            }
        } else {
            ByteBuffer byteBuffer = (ByteBuffer) Preconditions.checkNotNull(aj0Var.a());
            if (ay2.c()) {
                try {
                    ObjectWrapper objectWrapper2 = new ObjectWrapper(byteBuffer);
                    MZ2 mz22 = (MZ2) Preconditions.checkNotNull((MZ2) ay2.e());
                    Parcel parcelW02 = mz22.W0();
                    AbstractC1777yK2.a(parcelW02, objectWrapper2);
                    AbstractC1777yK2.b(parcelW02, zzsVarF2);
                    Parcel parcelX02 = mz22.X0(1, parcelW02);
                    Barcode[] barcodeArr3 = (Barcode[]) parcelX02.createTypedArray(Barcode.CREATOR);
                    parcelX02.recycle();
                    barcodeArr = barcodeArr3;
                } catch (RemoteException e2) {
                    Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e2);
                    barcodeArr = new Barcode[0];
                }
            } else {
                barcodeArr = new Barcode[0];
            }
        }
        SparseArray sparseArray = new SparseArray(barcodeArr.length);
        for (Barcode barcode : barcodeArr) {
            sparseArray.append(barcode.u.hashCode(), barcode);
        }
        return sparseArray;
    }

    @Override // defpackage.tX
    public final boolean b() {
        return this.c.c();
    }

    @Override // defpackage.tX
    public final void d() {
        super.d();
        this.c.d();
    }
}
