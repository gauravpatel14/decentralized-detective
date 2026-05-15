package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzaj;
import com.google.android.gms.internal.vision.zzs;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: z82, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1817z82 extends tX {
    public final C0761hE2 c;

    public C1817z82(C0761hE2 c0761hE2) {
        this.c = c0761hE2;
    }

    @Override // defpackage.tX
    public final SparseArray a(aj0 aj0Var) {
        zzah[] zzahVarArr;
        int i;
        byte[] bArrArray;
        zzaj zzajVar = new zzaj(new Rect());
        if (aj0Var == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        zzs zzsVarF2 = zzs.f2(aj0Var);
        Bitmap bitmapDecodeByteArray = aj0Var.c;
        Zi0 zi0 = aj0Var.a;
        if (bitmapDecodeByteArray == null) {
            ByteBuffer byteBuffer = (ByteBuffer) Preconditions.checkNotNull(aj0Var.a());
            int i2 = zi0.f;
            int i3 = zzsVarF2.t;
            int i4 = zzsVarF2.u;
            if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
                bArrArray = byteBuffer.array();
            } else {
                byte[] bArr = new byte[byteBuffer.capacity()];
                byteBuffer.get(bArr);
                bArrArray = bArr;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new YuvImage(bArrArray, i2, i3, i4, null).compressToJpeg(new Rect(0, 0, i3, i4), 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        Bitmap bitmapCreateBitmap = (Bitmap) Preconditions.checkNotNull(bitmapDecodeByteArray);
        int width = bitmapCreateBitmap.getWidth();
        int height = bitmapCreateBitmap.getHeight();
        if (zzsVarF2.x != 0) {
            Matrix matrix = new Matrix();
            int i5 = zzsVarF2.x;
            if (i5 == 0) {
                i = 0;
            } else if (i5 == 1) {
                i = 90;
            } else if (i5 == 2) {
                i = 180;
            } else {
                if (i5 != 3) {
                    throw new IllegalArgumentException("Unsupported rotation degree.");
                }
                i = 270;
            }
            matrix.postRotate(i);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, width, height, matrix, false);
        }
        int i6 = zzsVarF2.x;
        if (i6 == 1 || i6 == 3) {
            zzsVarF2.t = height;
            zzsVarF2.u = width;
        }
        Rect rect = zzajVar.t;
        if (!rect.isEmpty()) {
            int i7 = zi0.a;
            int i8 = zi0.b;
            int i9 = zzsVarF2.x;
            rect.set(i9 != 1 ? i9 != 2 ? i9 != 3 ? rect : new Rect(rect.top, i7 - rect.right, rect.bottom, i7 - rect.left) : new Rect(i7 - rect.right, i8 - rect.bottom, i7 - rect.left, i8 - rect.top) : new Rect(i8 - rect.bottom, rect.left, i8 - rect.top, rect.right));
        }
        zzsVarF2.x = 0;
        C0761hE2 c0761hE2 = this.c;
        if (c0761hE2.c()) {
            try {
                ObjectWrapper objectWrapper = new ObjectWrapper(bitmapCreateBitmap);
                C1656wC2 c1656wC2 = (C1656wC2) Preconditions.checkNotNull((C1656wC2) c0761hE2.e());
                Parcel parcelW0 = c1656wC2.W0();
                AbstractC1777yK2.a(parcelW0, objectWrapper);
                AbstractC1777yK2.b(parcelW0, zzsVarF2);
                AbstractC1777yK2.b(parcelW0, zzajVar);
                Parcel parcelX0 = c1656wC2.X0(3, parcelW0);
                zzah[] zzahVarArr2 = (zzah[]) parcelX0.createTypedArray(zzah.CREATOR);
                parcelX0.recycle();
                zzahVarArr = zzahVarArr2;
            } catch (RemoteException e) {
                Log.e("TextNativeHandle", "Error calling native text recognizer", e);
                zzahVarArr = new zzah[0];
            }
        } else {
            zzahVarArr = new zzah[0];
        }
        SparseArray sparseArray = new SparseArray();
        for (zzah zzahVar : zzahVarArr) {
            SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzahVar.C);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sparseArray.append(zzahVar.C, sparseArray2);
            }
            sparseArray2.append(zzahVar.D, zzahVar);
        }
        SparseArray sparseArray3 = new SparseArray(sparseArray.size());
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int iKeyAt = sparseArray.keyAt(i10);
            SparseArray sparseArray4 = (SparseArray) sparseArray.valueAt(i10);
            u72 u72Var = new u72();
            u72Var.a = new zzah[sparseArray4.size()];
            int i11 = 0;
            while (true) {
                zzah[] zzahVarArr3 = u72Var.a;
                if (i11 < zzahVarArr3.length) {
                    zzahVarArr3[i11] = (zzah) sparseArray4.valueAt(i11);
                    i11++;
                }
            }
            sparseArray3.append(iKeyAt, u72Var);
        }
        return sparseArray3;
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
