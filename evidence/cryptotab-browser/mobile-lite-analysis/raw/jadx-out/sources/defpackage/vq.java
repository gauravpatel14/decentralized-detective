package defpackage;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vq {
    public static Bitmap a(sq sqVar) {
        sp spVar;
        qp qpVar = sqVar.c;
        if (qpVar == null) {
            return null;
        }
        tq tqVar = sqVar.b;
        int i = tqVar.c;
        int i2 = tqVar.d;
        long j = ((long) i) * ((long) i2);
        if (i <= 0 || i2 <= 0 || j > 2305843009213693951L) {
            return null;
        }
        if (qpVar.a == 0) {
            spVar = new sp(null, ByteBuffer.wrap(qpVar.b));
        } else {
            rp rpVar = qpVar.c;
            jH1 jh1 = rpVar.b;
            long j2 = rpVar.c;
            iH1 ih1 = iH1.c;
            spVar = new sp(rpVar.b, jh1.x(j2));
        }
        try {
            ByteBuffer byteBuffer = spVar.u;
            if (byteBuffer.capacity() <= 0) {
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.copyPixelsFromBuffer(byteBuffer);
            spVar.close();
            return bitmapCreateBitmap;
        } finally {
            try {
                spVar.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static aj0 b(sq sqVar) {
        Bitmap bitmapA = a(sqVar);
        if (bitmapA == null) {
            return null;
        }
        aj0 aj0Var = new aj0();
        int width = bitmapA.getWidth();
        int height = bitmapA.getHeight();
        aj0Var.c = bitmapA;
        Zi0 zi0 = aj0Var.a;
        zi0.a = width;
        zi0.b = height;
        return aj0Var;
    }
}
