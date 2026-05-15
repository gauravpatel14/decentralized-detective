package defpackage;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class yb extends C1521tb {
    public final C1744xb d;
    public Drawable e;
    public ColorStateList f;
    public PorterDuff.Mode g;
    public boolean h;
    public boolean i;

    public yb(C1744xb c1744xb) {
        super(c1744xb);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.d = c1744xb;
    }

    @Override // defpackage.C1521tb
    public final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        C1744xb c1744xb = this.d;
        C1342qa2 c1342qa2F = C1342qa2.f(c1744xb.getContext(), attributeSet, AbstractC0305Yp1.AppCompatSeekBar, i);
        AbstractC0604eo2.n(c1744xb, c1744xb.getContext(), AbstractC0305Yp1.AppCompatSeekBar, attributeSet, c1342qa2F.b, i, 0);
        Drawable drawableC = c1342qa2F.c(AbstractC0305Yp1.AppCompatSeekBar_android_thumb);
        if (drawableC != null) {
            c1744xb.setThumb(drawableC);
        }
        Drawable drawableB = c1342qa2F.b(AbstractC0305Yp1.AppCompatSeekBar_tickMark);
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.e = drawableB;
        if (drawableB != null) {
            drawableB.setCallback(c1744xb);
            drawableB.setLayoutDirection(c1744xb.getLayoutDirection());
            if (drawableB.isStateful()) {
                drawableB.setState(c1744xb.getDrawableState());
            }
            c();
        }
        c1744xb.invalidate();
        int i2 = AbstractC0305Yp1.AppCompatSeekBar_tickMarkTintMode;
        TypedArray typedArray = c1342qa2F.b;
        if (typedArray.hasValue(i2)) {
            this.g = J30.c(typedArray.getInt(AbstractC0305Yp1.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (typedArray.hasValue(AbstractC0305Yp1.AppCompatSeekBar_tickMarkTint)) {
            this.f = c1342qa2F.a(AbstractC0305Yp1.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        c1342qa2F.g();
        c();
    }

    public final void c() {
        Drawable drawable = this.e;
        if (drawable != null) {
            if (this.h || this.i) {
                Drawable drawableMutate = drawable.mutate();
                this.e = drawableMutate;
                if (this.h) {
                    drawableMutate.setTintList(this.f);
                }
                if (this.i) {
                    this.e.setTintMode(this.g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.e != null) {
            int max = this.d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i, -i2, i, i2);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
