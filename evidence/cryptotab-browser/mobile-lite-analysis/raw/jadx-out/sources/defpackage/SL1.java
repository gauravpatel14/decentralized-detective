package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import org.chromium.base.Callback;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SL1 {
    public Bitmap a;

    public final boolean a(View view, Rect rect, float f, Jx jx, Callback callback) {
        Rect rect2 = null;
        TraceEvent traceEventJ = TraceEvent.j("SoftwareDraw:syncCaptureBitmap", null);
        try {
            int width = (int) (view.getWidth() * f);
            int height = (int) (view.getHeight() * f);
            boolean z = width == 0 || height == 0;
            if (z) {
                width = 1;
                height = 1;
            }
            Bitmap bitmap = this.a;
            if (bitmap != null && (bitmap.getWidth() != width || this.a.getHeight() != height)) {
                this.a.recycle();
                this.a = null;
            }
            if (this.a == null) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.setHasAlpha(true);
                this.a = bitmapCreateBitmap;
            }
            if (z) {
                this.a.setPixel(0, 0, 0);
            } else {
                Canvas canvas = new Canvas(this.a);
                if (!rect.isEmpty()) {
                    rect2 = rect;
                }
                jx.d(canvas, rect2);
                if (!rect.isEmpty()) {
                    canvas.clipRect(rect);
                }
                canvas.save();
                canvas.scale(f, f);
                view.draw(canvas);
                canvas.restore();
                jx.e();
            }
            callback.a0(this.a);
            boolean z2 = !z;
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return z2;
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
