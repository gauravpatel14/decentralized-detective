package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.mediarouter.app.d;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FO0 extends AsyncTask {
    public final Bitmap a;
    public final Uri b;
    public int c;
    public long d;
    public final /* synthetic */ d e;

    public FO0(d dVar) {
        this.e = dVar;
        MediaDescriptionCompat mediaDescriptionCompat = dVar.o0;
        Bitmap bitmap = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.x;
        if (bitmap != null && bitmap.isRecycled()) {
            Log.w("MediaRouteCtrlDialog", "Can't fetch the given art bitmap because it's already recycled.");
            bitmap = null;
        }
        this.a = bitmap;
        MediaDescriptionCompat mediaDescriptionCompat2 = dVar.o0;
        this.b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.y : null;
    }

    public final BufferedInputStream a(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream;
        String lowerCase = uri.getScheme().toLowerCase();
        if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
            inputStreamOpenInputStream = this.e.C.getContentResolver().openInputStream(uri);
        } else {
            URLConnection uRLConnectionOpenConnection = new URL(uri.toString()).openConnection();
            int i = d.I0;
            uRLConnectionOpenConnection.setConnectTimeout(i);
            uRLConnectionOpenConnection.setReadTimeout(i);
            inputStreamOpenInputStream = uRLConnectionOpenConnection.getInputStream();
        }
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        return new BufferedInputStream(inputStreamOpenInputStream);
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0034: MOVE (r6 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:53), block:B:14:0x0034 */
    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) throws Throwable {
        Bitmap bitmap;
        int iMax;
        SparseBooleanArray sparseBooleanArray;
        Bitmap bitmap2;
        ArrayList arrayList;
        int i;
        int i2;
        boolean z;
        int i3;
        InputStream inputStream;
        BufferedInputStream bufferedInputStreamA;
        InputStream inputStream2 = null;
        Bitmap bitmapDecodeStream = this.a;
        if (bitmapDecodeStream == null) {
            Uri uri = this.b;
            try {
                if (uri != null) {
                    try {
                        bufferedInputStreamA = a(uri);
                        try {
                            if (bufferedInputStreamA == null) {
                                Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri);
                                if (bufferedInputStreamA == null) {
                                    return null;
                                }
                            } else {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(bufferedInputStreamA, null, options);
                                if (options.outWidth != 0 && options.outHeight != 0) {
                                    try {
                                        bufferedInputStreamA.reset();
                                    } catch (IOException unused) {
                                        bufferedInputStreamA.close();
                                        bufferedInputStreamA = a(uri);
                                        if (bufferedInputStreamA == null) {
                                            Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri);
                                            if (bufferedInputStreamA == null) {
                                                return null;
                                            }
                                        }
                                        bufferedInputStreamA.close();
                                        return null;
                                    }
                                    options.inJustDecodeBounds = false;
                                    options.inSampleSize = Math.max(1, Integer.highestOneBit(options.outHeight / this.e.o(options.outWidth, options.outHeight)));
                                    if (!isCancelled()) {
                                        bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStreamA, null, options);
                                        try {
                                            bufferedInputStreamA.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                }
                            }
                            try {
                                bufferedInputStreamA.close();
                                return null;
                            } catch (IOException unused3) {
                                return null;
                            }
                        } catch (IOException e) {
                            e = e;
                            Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri, e);
                            if (bufferedInputStreamA != null) {
                                try {
                                    bufferedInputStreamA.close();
                                } catch (IOException unused4) {
                                }
                            }
                            bitmapDecodeStream = null;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedInputStreamA = null;
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException unused5) {
                            }
                        }
                        throw th;
                    }
                } else {
                    bitmapDecodeStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
            }
        }
        if (bitmapDecodeStream != null && bitmapDecodeStream.isRecycled()) {
            Log.w("MediaRouteCtrlDialog", "Can't use recycled bitmap: " + bitmapDecodeStream);
            return null;
        }
        if (bitmapDecodeStream == null || bitmapDecodeStream.getWidth() >= bitmapDecodeStream.getHeight()) {
            bitmap = bitmapDecodeStream;
        } else {
            M81 m81 = new M81(bitmapDecodeStream);
            m81.c = 1;
            Bitmap bitmap3 = m81.a;
            if (bitmap3 == null) {
                throw new AssertionError();
            }
            int i4 = m81.d;
            double dSqrt = -1.0d;
            if (i4 > 0) {
                int height = bitmap3.getHeight() * bitmap3.getWidth();
                if (height > i4) {
                    dSqrt = Math.sqrt(((double) i4) / ((double) height));
                }
            } else {
                int i5 = m81.e;
                if (i5 > 0 && (iMax = Math.max(bitmap3.getWidth(), bitmap3.getHeight())) > i5) {
                    dSqrt = ((double) i5) / ((double) iMax);
                }
            }
            int i6 = 0;
            Bitmap bitmapCreateScaledBitmap = dSqrt <= 0.0d ? bitmap3 : Bitmap.createScaledBitmap(bitmap3, (int) Math.ceil(((double) bitmap3.getWidth()) * dSqrt), (int) Math.ceil(((double) bitmap3.getHeight()) * dSqrt), false);
            int width = bitmapCreateScaledBitmap.getWidth();
            int height2 = bitmapCreateScaledBitmap.getHeight();
            int[] iArr = new int[width * height2];
            bitmapCreateScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height2);
            int i7 = m81.c;
            ArrayList arrayList2 = m81.f;
            WG wg = new WG(iArr, i7, arrayList2.isEmpty() ? null : (L81[]) arrayList2.toArray(new L81[arrayList2.size()]));
            if (bitmapCreateScaledBitmap != bitmap3) {
                bitmapCreateScaledBitmap.recycle();
            }
            ArrayList arrayList3 = wg.c;
            ArrayList arrayList4 = m81.b;
            O81 o81 = new O81(arrayList3, arrayList4);
            int size = arrayList4.size();
            int i8 = 0;
            while (true) {
                sparseBooleanArray = o81.c;
                if (i8 >= size) {
                    break;
                }
                C1596v62 c1596v62 = (C1596v62) arrayList4.get(i8);
                float[] fArr = c1596v62.c;
                int length = fArr.length;
                float f = 0.0f;
                for (int i9 = i6; i9 < length; i9++) {
                    float f2 = fArr[i9];
                    if (f2 > 0.0f) {
                        f += f2;
                    }
                }
                if (f != 0.0f) {
                    int length2 = fArr.length;
                    for (int i10 = i6; i10 < length2; i10++) {
                        float f3 = fArr[i10];
                        if (f3 > 0.0f) {
                            fArr[i10] = f3 / f;
                        }
                    }
                }
                UJ1 uj1 = o81.b;
                ArrayList arrayList5 = o81.a;
                int size2 = arrayList5.size();
                int i11 = i6;
                float f4 = 0.0f;
                N81 n81 = null;
                while (i11 < size2) {
                    N81 n812 = (N81) arrayList5.get(i11);
                    float[] fArrB = n812.b();
                    float f5 = fArrB[1];
                    float[] fArr2 = c1596v62.a;
                    if (f5 < fArr2[i6] || f5 > fArr2[2]) {
                        bitmap2 = bitmapDecodeStream;
                    } else {
                        float f6 = fArrB[2];
                        bitmap2 = bitmapDecodeStream;
                        float[] fArr3 = c1596v62.b;
                        if (f6 >= fArr3[i6] && f6 <= fArr3[2]) {
                            if (sparseBooleanArray.get(n812.d)) {
                                arrayList = arrayList4;
                                i = size;
                                i2 = 0;
                            } else {
                                float[] fArrB2 = n812.b();
                                arrayList = arrayList4;
                                N81 n813 = o81.d;
                                if (n813 != null) {
                                    i3 = n813.e;
                                    i = size;
                                } else {
                                    i = size;
                                    i3 = 1;
                                }
                                float[] fArr4 = c1596v62.c;
                                i2 = 0;
                                float f7 = fArr4[0];
                                float fAbs = f7 > 0.0f ? (1.0f - Math.abs(fArrB2[1] - fArr2[1])) * f7 : 0.0f;
                                float f8 = fArr4[1];
                                float fAbs2 = f8 > 0.0f ? (1.0f - Math.abs(fArrB2[2] - fArr3[1])) * f8 : 0.0f;
                                float f9 = fArr4[2];
                                z = false;
                                float f10 = fAbs + fAbs2 + (f9 > 0.0f ? (n812.e / i3) * f9 : 0.0f);
                                if (n81 == null || f10 > f4) {
                                    f4 = f10;
                                    n81 = n812;
                                }
                                i11++;
                                i6 = i2;
                                bitmapDecodeStream = bitmap2;
                                arrayList4 = arrayList;
                                size = i;
                            }
                        }
                        z = false;
                        i11++;
                        i6 = i2;
                        bitmapDecodeStream = bitmap2;
                        arrayList4 = arrayList;
                        size = i;
                    }
                    arrayList = arrayList4;
                    i = size;
                    i2 = i6;
                    z = false;
                    i11++;
                    i6 = i2;
                    bitmapDecodeStream = bitmap2;
                    arrayList4 = arrayList;
                    size = i;
                }
                Bitmap bitmap4 = bitmapDecodeStream;
                ArrayList arrayList6 = arrayList4;
                int i12 = size;
                int i13 = i6;
                if (n81 != null) {
                    sparseBooleanArray.append(n81.d, true);
                }
                uj1.put(c1596v62, n81);
                i8++;
                i6 = i13;
                bitmapDecodeStream = bitmap4;
                arrayList4 = arrayList6;
                size = i12;
            }
            bitmap = bitmapDecodeStream;
            sparseBooleanArray.clear();
            ArrayList arrayList7 = o81.a;
            this.c = Collections.unmodifiableList(arrayList7).isEmpty() ? 0 : ((N81) Collections.unmodifiableList(arrayList7).get(0)).d;
        }
        return bitmap;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        d dVar = this.e;
        dVar.p0 = null;
        Bitmap bitmap2 = dVar.q0;
        Bitmap bitmap3 = this.a;
        boolean zEquals = Objects.equals(bitmap2, bitmap3);
        Uri uri = this.b;
        if (zEquals && Objects.equals(dVar.r0, uri)) {
            return;
        }
        dVar.q0 = bitmap3;
        dVar.t0 = bitmap;
        dVar.r0 = uri;
        dVar.u0 = this.c;
        dVar.s0 = true;
        dVar.t(SystemClock.uptimeMillis() - this.d > 120);
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        this.d = SystemClock.uptimeMillis();
        d dVar = this.e;
        dVar.s0 = false;
        dVar.t0 = null;
        dVar.u0 = 0;
    }
}
