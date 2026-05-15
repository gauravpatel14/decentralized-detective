package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.media.FaceDetector;
import android.util.Log;
import org.chromium.base.task.PostTask;
import org.chromium.mojo.system.MojoException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class R90 implements P90 {
    public final int t;

    public R90(C0974ka0 c0974ka0) {
        boolean z = c0974ka0.c;
        this.t = Math.min(c0974ka0.b, 32);
    }

    @Override // defpackage.P90
    public final void x0(sq sqVar, final C0656fa0 c0656fa0) {
        Bitmap bitmap;
        Bitmap bitmapA = vq.a(sqVar);
        if (bitmapA == null) {
            Log.e("cr_FaceDetectionImpl", "Error converting Mojom Bitmap to Android Bitmap");
            c0656fa0.a(new C0364aa0[0]);
            return;
        }
        tq tqVar = sqVar.b;
        int i = tqVar.c;
        final int i2 = (i % 2) + i;
        final int i3 = tqVar.d;
        if (i2 != i) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapA, 0.0f, 0.0f, (Paint) null);
            bitmap = bitmapCreateBitmap;
        } else {
            bitmap = bitmapA;
        }
        int[] iArr = new int[i2 * i3];
        bitmap.getPixels(iArr, 0, i2, 0, 0, i2, i3);
        final Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iArr, i2, i3, Bitmap.Config.RGB_565);
        PostTask.c(1, new Runnable() { // from class: Q90
            @Override // java.lang.Runnable
            public final void run() {
                R90 r90 = this.t;
                r90.getClass();
                int i4 = i2;
                int i5 = i3;
                int i6 = r90.t;
                FaceDetector faceDetector = new FaceDetector(i4, i5, i6);
                FaceDetector.Face[] faceArr = new FaceDetector.Face[i6];
                int iFindFaces = faceDetector.findFaces(bitmapCreateBitmap2, faceArr);
                C0364aa0[] c0364aa0Arr = new C0364aa0[iFindFaces];
                for (int i7 = 0; i7 < iFindFaces; i7++) {
                    c0364aa0Arr[i7] = new C0364aa0(0);
                    FaceDetector.Face face = faceArr[i7];
                    PointF pointF = new PointF();
                    face.getMidPoint(pointF);
                    float fEyesDistance = face.eyesDistance();
                    c0364aa0Arr[i7].b = new Kr1(0);
                    C0364aa0 c0364aa0 = c0364aa0Arr[i7];
                    Kr1 kr1 = c0364aa0.b;
                    kr1.b = pointF.x - fEyesDistance;
                    kr1.c = pointF.y - fEyesDistance;
                    float f = fEyesDistance * 2.0f;
                    kr1.d = f;
                    kr1.e = f;
                    c0364aa0.c = new SC0[0];
                }
                c0656fa0.a(c0364aa0Arr);
            }
        });
    }

    @Override // defpackage.Ny0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // defpackage.DJ
    public final void d(MojoException mojoException) {
    }
}
