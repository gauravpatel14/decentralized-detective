package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.android.volley.ParseError;

/* JADX INFO: renamed from: gt0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0739gt0 extends AbstractC1701wu1 {
    public static final Object N = new Object();
    public final Object H;
    public at0 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Bitmap.Config f28J;
    public final int K;
    public final int L;
    public final ImageView.ScaleType M;

    public C0739gt0(String str, at0 at0Var, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, at0 at0Var2) {
        super(0, str, at0Var2);
        this.H = new Object();
        this.D = new C0586eW(2.0f, 1000, 2);
        this.I = at0Var;
        this.f28J = config;
        this.K = i;
        this.L = i2;
        this.M = scaleType;
    }

    public static int o(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    @Override // defpackage.AbstractC1701wu1
    public final void a() {
        super.a();
        synchronized (this.H) {
            this.I = null;
        }
    }

    @Override // defpackage.AbstractC1701wu1
    public final void b(Object obj) {
        at0 at0Var;
        Bitmap bitmap = (Bitmap) obj;
        synchronized (this.H) {
            at0Var = this.I;
        }
        if (at0Var != null) {
            at0Var.a(bitmap);
        }
    }

    @Override // defpackage.AbstractC1701wu1
    public final int g() {
        return 1;
    }

    @Override // defpackage.AbstractC1701wu1
    public final ov1 l(C1223oY0 c1223oY0) {
        ov1 ov1VarN;
        synchronized (N) {
            try {
                try {
                    ov1VarN = n(c1223oY0);
                } catch (OutOfMemoryError e) {
                    AbstractC1583uq2.b("Caught OOM for %d byte image, url=%s", Integer.valueOf(c1223oY0.a.length), this.u);
                    return new ov1(new ParseError(e));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ov1VarN;
    }

    public final ov1 n(C1223oY0 c1223oY0) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        byte[] bArr = c1223oY0.a;
        int i = this.L;
        int i2 = this.K;
        if (i2 == 0 && i == 0) {
            options.inPreferredConfig = this.f28J;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            ImageView.ScaleType scaleType = this.M;
            int iO = o(i2, i, i3, i4, scaleType);
            int iO2 = o(i, i2, i4, i3, scaleType);
            options.inJustDecodeBounds = false;
            float f = 1.0f;
            while (true) {
                float f2 = 2.0f * f;
                if (f2 > Math.min(((double) i3) / ((double) iO), ((double) i4) / ((double) iO2))) {
                    break;
                }
                f = f2;
            }
            options.inSampleSize = (int) f;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iO || bitmapDecodeByteArray.getHeight() > iO2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iO, iO2, true);
                bitmapDecodeByteArray.recycle();
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        return bitmapDecodeByteArray == null ? new ov1(new ParseError()) : new ov1(bitmapDecodeByteArray, Pp0.a(c1223oY0));
    }
}
