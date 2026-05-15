package androidx.mediarouter.app;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import defpackage.AbstractC0275Wp1;
import defpackage.AbstractC0305Yp1;
import defpackage.AbstractC0604eo2;
import defpackage.AbstractC1686wb;
import defpackage.C0468cP0;
import defpackage.C0838iP0;
import defpackage.C0896jO0;
import defpackage.C1087mP0;
import defpackage.Ep1;
import defpackage.PO0;
import defpackage.kO0;
import defpackage.oP0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MediaRouteButton extends View {
    public static final SparseArray G = new SparseArray(2);
    public static final int[] H = {R.attr.state_checked};
    public static final int[] I = {R.attr.state_checkable};
    public int A;
    public int B;
    public int C;
    public final ColorStateList D;
    public final int E;
    public final int F;
    public final C1087mP0 t;
    public final C0896jO0 u;
    public C0468cP0 v;
    public final PO0 w;
    public boolean x;
    public kO0 y;
    public Drawable z;

    public MediaRouteButton(Context context, AttributeSet attributeSet) {
        Drawable.ConstantState constantState;
        int i = Ep1.mediaRouteButtonStyle;
        int i2 = oP0.a;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, oP0.e(context));
        int iG = oP0.g(Ep1.mediaRouteTheme, contextThemeWrapper);
        super(iG != 0 ? new ContextThemeWrapper(contextThemeWrapper, iG) : contextThemeWrapper, attributeSet, i);
        this.v = C0468cP0.c;
        this.w = PO0.a;
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.MediaRouteButton, i, 0);
        AbstractC0604eo2.n(this, context2, AbstractC0305Yp1.MediaRouteButton, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        if (isInEditMode()) {
            this.t = null;
            this.u = null;
            this.z = AbstractC1686wb.a(typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.MediaRouteButton_externalRouteEnabledDrawableStatic, 0), context2);
            return;
        }
        this.t = C1087mP0.d(context2);
        this.u = new C0896jO0(this);
        C0838iP0 c0838iP0G = C1087mP0.g();
        int i3 = !c0838iP0G.b() ? c0838iP0G.i : 0;
        this.C = i3;
        this.B = i3;
        this.D = typedArrayObtainStyledAttributes.getColorStateList(AbstractC0305Yp1.MediaRouteButton_mediaRouteButtonTint);
        this.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.MediaRouteButton_android_minWidth, 0);
        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.MediaRouteButton_android_minHeight, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.MediaRouteButton_externalRouteEnabledDrawableStatic, 0);
        this.A = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.MediaRouteButton_externalRouteEnabledDrawable, 0);
        typedArrayObtainStyledAttributes.recycle();
        int i4 = this.A;
        SparseArray sparseArray = G;
        if (i4 != 0 && (constantState = (Drawable.ConstantState) sparseArray.get(i4)) != null) {
            Drawable drawableNewDrawable = constantState.newDrawable();
            this.A = 0;
            c(drawableNewDrawable);
        }
        if (this.z == null) {
            if (resourceId != 0) {
                Drawable.ConstantState constantState2 = (Drawable.ConstantState) sparseArray.get(resourceId);
                if (constantState2 != null) {
                    c(constantState2.newDrawable());
                } else {
                    kO0 ko0 = new kO0(this, resourceId, getContext());
                    this.y = ko0;
                    ko0.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
            } else {
                a();
            }
        }
        e();
        setClickable(true);
    }

    public final void a() {
        if (this.A > 0) {
            kO0 ko0 = this.y;
            if (ko0 != null) {
                ko0.cancel(false);
            }
            kO0 ko02 = new kO0(this, this.A, getContext());
            this.y = ko02;
            this.A = 0;
            ko02.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public final void b() {
        this.t.getClass();
        C0838iP0 c0838iP0G = C1087mP0.g();
        int i = !c0838iP0G.b() ? c0838iP0G.i : 0;
        if (this.C != i) {
            this.C = i;
            e();
            refreshDrawableState();
        }
        if (i == 1) {
            a();
        }
    }

    public final void c(Drawable drawable) {
        kO0 ko0 = this.y;
        if (ko0 != null) {
            ko0.cancel(false);
        }
        Drawable drawable2 = this.z;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.z);
        }
        if (drawable != null) {
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                drawable = drawable.mutate();
                drawable.setTintList(colorStateList);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
        }
        this.z = drawable;
        refreshDrawableState();
    }

    public final void d(C0468cP0 c0468cP0) {
        if (c0468cP0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.v.equals(c0468cP0)) {
            return;
        }
        if (this.x) {
            boolean zD = this.v.d();
            C0896jO0 c0896jO0 = this.u;
            C1087mP0 c1087mP0 = this.t;
            if (!zD) {
                c1087mP0.h(c0896jO0);
            }
            if (!c0468cP0.d()) {
                c1087mP0.a(c0468cP0, c0896jO0, 0);
            }
        }
        this.v = c0468cP0;
        b();
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.z != null) {
            this.z.setState(getDrawableState());
            if (this.z.getCurrent() instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) this.z.getCurrent();
                int i = this.C;
                if (i == 1 || this.B != i) {
                    if (!animationDrawable.isRunning()) {
                        animationDrawable.start();
                    }
                } else if (i == 2 && !animationDrawable.isRunning()) {
                    animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
                }
            }
            invalidate();
        }
        this.B = this.C;
    }

    public final void e() {
        int i = this.C;
        setContentDescription(getContext().getString(i != 1 ? i != 2 ? AbstractC0275Wp1.mr_cast_button_disconnected : AbstractC0275Wp1.mr_cast_button_connected : AbstractC0275Wp1.mr_cast_button_connecting));
        setTooltipText(null);
    }

    @Override // android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.z;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.x = true;
        if (!this.v.d()) {
            this.t.a(this.v, this.u, 0);
        }
        b();
    }

    @Override // android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.t == null) {
            return iArrOnCreateDrawableState;
        }
        int i2 = this.C;
        if (i2 == 1) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, I);
        } else if (i2 == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.x = false;
            if (!this.v.d()) {
                this.t.h(this.u);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.z != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int intrinsicWidth = this.z.getIntrinsicWidth();
            int intrinsicHeight = this.z.getIntrinsicHeight();
            int i = (((width - paddingLeft) - intrinsicWidth) / 2) + paddingLeft;
            int i2 = (((height - paddingTop) - intrinsicHeight) / 2) + paddingTop;
            this.z.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.z.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int paddingRight;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        Drawable drawable = this.z;
        int paddingBottom = 0;
        if (drawable != null) {
            paddingRight = getPaddingRight() + getPaddingLeft() + drawable.getIntrinsicWidth();
        } else {
            paddingRight = 0;
        }
        int iMax = Math.max(this.E, paddingRight);
        Drawable drawable2 = this.z;
        if (drawable2 != null) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + drawable2.getIntrinsicHeight();
        }
        int iMax2 = Math.max(this.F, paddingBottom);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, iMax);
        } else if (mode != 1073741824) {
            size = iMax;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, iMax2);
        } else if (mode2 != 1073741824) {
            size2 = iMax2;
        }
        setMeasuredDimension(size, size2);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean performClick() {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.MediaRouteButton.performClick():boolean");
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        super.setVisibility(i);
        Drawable drawable = this.z;
        if (drawable != null) {
            drawable.setVisible(i == 0, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.z;
    }
}
