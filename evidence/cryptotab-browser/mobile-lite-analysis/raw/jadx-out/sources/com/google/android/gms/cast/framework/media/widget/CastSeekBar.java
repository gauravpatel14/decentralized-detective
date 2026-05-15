package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import defpackage.AbstractC0292Xp1;
import defpackage.AbstractC0305Yp1;
import defpackage.Ep1;
import defpackage.Fy;
import defpackage.Gy;
import defpackage.Hp1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class CastSeekBar extends View {
    public static final /* synthetic */ int C = 0;
    public final int A;
    public final int B;
    public final Fy t;
    public final ArrayList u;
    public final float v;
    public final float w;
    public final float x;
    public final Paint y;
    public final int z;

    public CastSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.u = new ArrayList();
        setAccessibilityDelegate(new Gy(this));
        Paint paint = new Paint(1);
        this.y = paint;
        paint.setStyle(Paint.Style.FILL);
        this.v = context.getResources().getDimension(Hp1.cast_seek_bar_minimum_width);
        this.w = context.getResources().getDimension(Hp1.cast_seek_bar_minimum_height);
        this.x = context.getResources().getDimension(Hp1.cast_seek_bar_progress_height) / 2.0f;
        context.getResources().getDimension(Hp1.cast_seek_bar_thumb_size);
        context.getResources().getDimension(Hp1.cast_seek_bar_ad_break_radius);
        Fy fy = new Fy();
        this.t = fy;
        fy.a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC0305Yp1.CastExpandedController, Ep1.castExpandedControllerStyle, AbstractC0292Xp1.CastExpandedController);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.CastExpandedController_castSeekBarProgressAndThumbColor, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.CastExpandedController_castSeekBarSecondaryProgressColor, 0);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.CastExpandedController_castSeekBarUnseekableProgressColor, 0);
        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.CastExpandedController_castAdBreakMarkerColor, 0);
        this.z = context.getResources().getColor(resourceId);
        context.getResources().getColor(resourceId2);
        this.A = context.getResources().getColor(resourceId3);
        this.B = context.getResources().getColor(resourceId4);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(Canvas canvas, int i, int i2, int i3, int i4) {
        Paint paint = this.y;
        paint.setColor(i4);
        float f = this.t.a;
        float f2 = i3;
        float f3 = this.x;
        canvas.drawRect(((i * 1.0f) / f) * f2, -f3, ((i2 * 1.0f) / f) * f2, f3, paint);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.t.getClass();
        int iSave2 = canvas.save();
        canvas.translate(0.0f, measuredHeight / 2);
        Fy fy = this.t;
        fy.getClass();
        int iMax = Math.max(0, 0);
        if (iMax > 0) {
            a(canvas, 0, iMax, measuredWidth, this.A);
        }
        if (iMax < 0) {
            a(canvas, iMax, 0, measuredWidth, this.z);
        }
        int i = fy.a;
        if (i > 0) {
            a(canvas, 0, i, measuredWidth, this.A);
        }
        canvas.restoreToCount(iSave2);
        ArrayList arrayList = this.u;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.y.setColor(this.B);
            getMeasuredWidth();
            getPaddingLeft();
            getPaddingRight();
            getMeasuredHeight();
            getPaddingTop();
            getPaddingBottom();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
            }
        }
        isEnabled();
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSizeAndState((int) (this.v + getPaddingLeft() + getPaddingRight()), i, 0), View.resolveSizeAndState((int) (this.w + getPaddingTop() + getPaddingBottom()), i2, 0));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        this.t.getClass();
        return false;
    }
}
