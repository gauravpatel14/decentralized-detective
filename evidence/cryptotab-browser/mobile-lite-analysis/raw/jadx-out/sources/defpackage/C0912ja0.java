package defpackage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.vision.zzs;
import java.nio.ByteBuffer;
import java.util.HashSet;

/* JADX INFO: renamed from: ja0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0912ja0 extends tX {
    public final DF2 d;
    public final C0399bI2 c = new C0399bI2();
    public final Object e = new Object();
    public boolean f = true;

    public C0912ja0(DF2 df2) {
        this.d = df2;
    }

    @Override // defpackage.tX
    public final SparseArray a(aj0 aj0Var) {
        ByteBuffer byteBufferA;
        O90[] o90ArrF;
        int i;
        if (aj0Var == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        Bitmap bitmap = aj0Var.c;
        if (bitmap != null) {
            Bitmap bitmap2 = (Bitmap) Preconditions.checkNotNull(bitmap);
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            int i2 = width * height;
            byteBufferA = ByteBuffer.allocateDirect(((((height + 1) / 2) * ((width + 1) / 2)) << 1) + i2);
            int i3 = i2;
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = i4 % width;
                int i6 = i4 / width;
                int pixel = bitmap2.getPixel(i5, i6);
                float fRed = Color.red(pixel);
                float fGreen = Color.green(pixel);
                float fBlue = Color.blue(pixel);
                byteBufferA.put(i4, (byte) ((0.114f * fBlue) + (0.587f * fGreen) + (0.299f * fRed)));
                if (i6 % 2 == 0 && i5 % 2 == 0) {
                    float f = (fBlue * 0.5f) + ((-0.331f) * fGreen) + ((-0.169f) * fRed) + 128.0f;
                    float f2 = fBlue * (-0.081f);
                    int i7 = i3 + 1;
                    byteBufferA.put(i3, (byte) f);
                    i3 += 2;
                    byteBufferA.put(i7, (byte) (f2 + (fGreen * (-0.419f)) + (fRed * 0.5f) + 128.0f));
                }
            }
        } else {
            byteBufferA = aj0Var.a();
        }
        synchronized (this.e) {
            if (!this.f) {
                throw new IllegalStateException("Cannot use detector after release()");
            }
            o90ArrF = this.d.f((ByteBuffer) Preconditions.checkNotNull(byteBufferA), zzs.f2(aj0Var));
        }
        HashSet hashSet = new HashSet();
        SparseArray sparseArray = new SparseArray(o90ArrF.length);
        int iMax = 0;
        for (O90 o90 : o90ArrF) {
            int i8 = o90.a;
            iMax = Math.max(iMax, i8);
            if (hashSet.contains(Integer.valueOf(i8))) {
                i8 = iMax + 1;
                iMax = i8;
            }
            hashSet.add(Integer.valueOf(i8));
            C0399bI2 c0399bI2 = this.c;
            c0399bI2.getClass();
            synchronized (C0399bI2.c) {
                try {
                    i = c0399bI2.a.get(i8, -1);
                    if (i == -1) {
                        i = C0399bI2.d;
                        C0399bI2.d = i + 1;
                        c0399bI2.a.append(i8, i);
                        c0399bI2.b.append(i, i8);
                    }
                } finally {
                }
            }
            sparseArray.append(i, o90);
        }
        return sparseArray;
    }

    @Override // defpackage.tX
    public final boolean b() {
        return this.d.c();
    }

    @Override // defpackage.tX
    public final void d() {
        super.d();
        synchronized (this.e) {
            try {
                if (this.f) {
                    this.d.d();
                    this.f = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this.e) {
                try {
                    if (this.f) {
                        Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                        d();
                    }
                } finally {
                }
            }
        } finally {
            super.finalize();
        }
    }
}
