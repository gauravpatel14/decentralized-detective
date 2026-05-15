package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AO1 implements InterfaceC0314Zf {
    public final /* synthetic */ Resources a;

    public AO1(Resources resources) {
        this.a = resources;
    }

    @Override // defpackage.InterfaceC0314Zf
    public final C1841zO1 a(int i) {
        if (i <= 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        options.inPreferredConfig = config;
        Resources resources = this.a;
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, i, options);
        if (bitmapDecodeResource == null) {
            bitmapDecodeResource = null;
        } else if (bitmapDecodeResource.getConfig() != options.inPreferredConfig) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), options.inPreferredConfig);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeResource, 0.0f, 0.0f, (Paint) null);
            bitmapDecodeResource.recycle();
            bitmapDecodeResource = bitmapCreateBitmap;
        }
        if (bitmapDecodeResource == null) {
            try {
                Drawable drawableB = AbstractC0911ja.b(resources, i, 0);
                int iMax = Math.max(drawableB.getMinimumWidth(), Math.max(0, 1));
                int iMax2 = Math.max(drawableB.getMinimumHeight(), Math.max(0, 1));
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMax, iMax2, config);
                Canvas canvas = new Canvas(bitmapCreateBitmap2);
                drawableB.setBounds(0, 0, iMax, iMax2);
                drawableB.draw(canvas);
                bitmapDecodeResource = bitmapCreateBitmap2;
            } catch (Resources.NotFoundException unused) {
                bitmapDecodeResource = null;
            }
        }
        if (bitmapDecodeResource == null) {
            return null;
        }
        return new C1841zO1(bitmapDecodeResource);
    }
}
