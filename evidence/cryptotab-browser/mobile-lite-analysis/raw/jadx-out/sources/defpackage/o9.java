package defpackage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.ThumbnailUtils;
import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class o9 extends View.DragShadowBuilder {
    public static final /* synthetic */ int p = 0;
    public final C1004l9 a = new C1004l9("progress");
    public final float b;
    public final float c;
    public final Paint d;
    public final Paint e;
    public final RectF f;
    public final Matrix g;
    public final View h;
    public final int i;
    public final RectF j;
    public final RectF k;
    public final RectF l;
    public final RectF m;
    public final RectF n;
    public float o;

    public o9(View view, Context context, Bitmap bitmap, float f, float f2, n9 n9Var) {
        RectF rectF = new RectF();
        this.j = rectF;
        RectF rectF2 = new RectF();
        this.k = rectF2;
        this.l = new RectF();
        this.m = new RectF();
        RectF rectF3 = new RectF();
        this.n = rectF3;
        this.h = view;
        int i = n9Var.a;
        int i2 = n9Var.b;
        Bitmap bitmapExtractThumbnail = ThumbnailUtils.extractThumbnail(bitmap, i, i2, 2);
        float f3 = n9Var.c;
        float f4 = i;
        float f5 = f3 / f4;
        Resources resources = context.getResources();
        this.o = 0.0f;
        rectF.set(0.0f, 0.0f, f4, i2);
        rectF2.set(0.0f, 0.0f, f3, n9Var.d);
        rectF2.offset(f - rectF2.centerX(), f2 - rectF2.centerY());
        rectF3.set(rectF);
        rectF3.union(rectF2);
        int dimensionPixelSize = resources.getDimensionPixelSize(Hp1.drag_shadow_border_size);
        this.i = dimensionPixelSize;
        float f6 = dimensionPixelSize;
        float f7 = rectF3.left - f6;
        rectF3.left = f7;
        float f8 = rectF3.top - f6;
        rectF3.top = f8;
        rectF3.right += f6;
        rectF3.bottom += f6;
        float f9 = -f7;
        float f10 = -f8;
        rectF3.offset(f9, f10);
        rectF.offset(f9, f10);
        rectF2.offset(f9, f10);
        float dimensionPixelSize2 = resources.getDimensionPixelSize(Hp1.drag_shadow_border_corner_radius);
        this.b = dimensionPixelSize2;
        this.c = dimensionPixelSize2 / f5;
        this.f = new RectF(0.0f, 0.0f, bitmapExtractThumbnail.getWidth(), bitmapExtractThumbnail.getHeight());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapExtractThumbnail, tileMode, tileMode);
        Paint paint = new Paint();
        this.d = paint;
        paint.setShader(bitmapShader);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(f6);
        paint2.setColor(context.getColor(AbstractC0084Gp1.drag_shadow_outline_color));
        this.g = new Matrix();
    }

    @Override // android.view.View.DragShadowBuilder
    public final void onDrawShadow(Canvas canvas) {
        RectF rectF = this.l;
        RectF rectF2 = this.j;
        float f = rectF2.left;
        RectF rectF3 = this.k;
        float f2 = rectF3.left;
        float f3 = this.o;
        float fA = AbstractC0146Mm2.a(f2, f, f3, f);
        float f4 = rectF2.top;
        float fA2 = AbstractC0146Mm2.a(rectF3.top, f4, f3, f4);
        float f5 = rectF2.right;
        float fA3 = AbstractC0146Mm2.a(rectF3.right, f5, f3, f5);
        float f6 = rectF2.bottom;
        rectF.set(fA, fA2, fA3, AbstractC0146Mm2.a(rectF3.bottom, f6, f3, f6));
        Matrix matrix = this.g;
        matrix.setRectToRect(this.f, rectF, Matrix.ScaleToFit.CENTER);
        Paint paint = this.d;
        paint.getShader().setLocalMatrix(matrix);
        float f7 = this.o;
        float f8 = this.b;
        float f9 = this.c;
        float fA4 = AbstractC0146Mm2.a(f8, f9, f7, f9);
        paint.setAlpha(Math.round((1.0f - (f7 * 0.39999998f)) * 255.0f));
        canvas.drawRoundRect(rectF, fA4, fA4, paint);
        RectF rectF4 = this.m;
        float f10 = this.i / 2.0f;
        rectF4.set(rectF.left - f10, rectF.top - f10, rectF.right + f10, f10 + rectF.bottom);
        canvas.drawRoundRect(rectF4, fA4, fA4, this.e);
    }

    @Override // android.view.View.DragShadowBuilder
    public final void onProvideShadowMetrics(Point point, Point point2) {
        RectF rectF = this.n;
        point.set(Math.round(rectF.width()), Math.round(rectF.height()));
        RectF rectF2 = this.k;
        point2.set(Math.round(rectF2.centerX()), Math.round(rectF2.centerY()));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, this.a, 1.0f);
        objectAnimatorOfFloat.setAutoCancel(true);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }
}
