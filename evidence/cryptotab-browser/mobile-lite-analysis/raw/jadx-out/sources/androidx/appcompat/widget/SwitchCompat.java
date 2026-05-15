package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0275Wp1;
import defpackage.AbstractC0305Yp1;
import defpackage.AbstractC0604eo2;
import defpackage.C0273Wn2;
import defpackage.C0474cT1;
import defpackage.C1162nb;
import defpackage.C1342qa2;
import defpackage.Ep1;
import defpackage.F82;
import defpackage.J30;
import defpackage.Jp2;
import defpackage.Mb;
import defpackage.Q82;
import defpackage.U3;
import defpackage.v6;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final C0474cT1 m0 = new C0474cT1(Float.class, "thumbPos");
    public static final int[] n0 = {R.attr.state_checked};
    public final PorterDuff.Mode A;
    public boolean B;
    public final boolean C;
    public final int D;
    public int E;
    public final int F;
    public final boolean G;
    public CharSequence H;
    public CharSequence I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public CharSequence f13J;
    public CharSequence K;
    public final boolean L;
    public int M;
    public final int N;
    public float O;
    public float P;
    public final VelocityTracker Q;
    public final int R;
    public float S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int a0;
    public int b0;
    public int c0;
    public boolean d0;
    public final TextPaint e0;
    public final ColorStateList f0;
    public StaticLayout g0;
    public StaticLayout h0;
    public final v6 i0;
    public ObjectAnimator j0;
    public C1162nb k0;
    public final Rect l0;
    public Drawable t;
    public ColorStateList u;
    public final PorterDuff.Mode v;
    public boolean w;
    public final boolean x;
    public Drawable y;
    public ColorStateList z;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Ep1.switchStyle);
    }

    public final void a() {
        Drawable drawable = this.t;
        if (drawable != null) {
            boolean z = this.w;
            boolean z2 = this.x;
            if (z || z2) {
                Drawable drawableMutate = drawable.mutate();
                this.t = drawableMutate;
                if (this.w) {
                    drawableMutate.setTintList(this.u);
                }
                if (z2) {
                    this.t.setTintMode(this.v);
                }
                if (this.t.isStateful()) {
                    this.t.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.y;
        if (drawable != null) {
            boolean z = this.B;
            boolean z2 = this.C;
            if (z || z2) {
                Drawable drawableMutate = drawable.mutate();
                this.y = drawableMutate;
                if (this.B) {
                    drawableMutate.setTintList(this.z);
                }
                if (z2) {
                    this.y.setTintMode(this.A);
                }
                if (this.y.isStateful()) {
                    this.y.setState(getDrawableState());
                }
            }
        }
    }

    public final C1162nb c() {
        if (this.k0 == null) {
            this.k0 = new C1162nb(this);
        }
        return this.k0;
    }

    public final int d() {
        boolean z = Jp2.a;
        return (int) (((getLayoutDirection() == 1 ? 1.0f - this.S : this.S) * e()) + 0.5f);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = this.W;
        int i4 = this.a0;
        int i5 = this.b0;
        int i6 = this.c0;
        int iD = d() + i3;
        Drawable drawable = this.t;
        Rect rectB = drawable != null ? J30.b(drawable) : J30.c;
        Drawable drawable2 = this.y;
        Rect rect = this.l0;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i7 = rect.left;
            iD += i7;
            if (rectB != null) {
                int i8 = rectB.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rectB.top;
                int i10 = rect.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rectB.right;
                int i12 = rect.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rectB.bottom;
                int i14 = rect.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                }
                this.y.setBounds(i3, i, i5, i2);
            } else {
                i = i4;
            }
            i2 = i6;
            this.y.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.t;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i15 = iD - rect.left;
            int i16 = iD + this.V + rect.right;
            this.t.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
        Drawable drawable2 = this.y;
        if (drawable2 != null) {
            drawable2.setHotspot(f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.t;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.y;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final int e() {
        Drawable drawable = this.y;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.l0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.t;
        Rect rectB = drawable2 != null ? J30.b(drawable2) : J30.c;
        return ((((this.T - this.V) - rect.left) - rect.right) - rectB.left) - rectB.right;
    }

    public final void f(Typeface typeface) {
        TextPaint textPaint = this.e0;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public final void g(CharSequence charSequence) {
        this.f13J = charSequence;
        C1162nb c1162nbC = c();
        TransformationMethod transformationMethodE = c1162nbC.b.a.e(this.i0);
        if (transformationMethodE != null) {
            charSequence = transformationMethodE.getTransformation(charSequence, this);
        }
        this.K = charSequence;
        this.h0 = null;
        if (this.L) {
            this.k0.b.a.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public final int getCompoundPaddingLeft() {
        boolean z = Jp2.a;
        if (getLayoutDirection() != 1) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.T;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.F : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public final int getCompoundPaddingRight() {
        boolean z = Jp2.a;
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.T;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.F : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public final ActionMode.Callback getCustomSelectionActionModeCallback() {
        return F82.d(super.getCustomSelectionActionModeCallback());
    }

    public final void h(CharSequence charSequence) {
        this.H = charSequence;
        C1162nb c1162nbC = c();
        TransformationMethod transformationMethodE = c1162nbC.b.a.e(this.i0);
        if (transformationMethodE != null) {
            charSequence = transformationMethodE.getTransformation(charSequence, this);
        }
        this.I = charSequence;
        this.g0 = null;
        if (this.L) {
            this.k0.b.a.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.y;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.j0;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.j0.end();
        this.j0 = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, n0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.y;
        Rect rect = this.l0;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.a0;
        int i2 = this.c0;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.t;
        if (drawable != null) {
            if (!this.G || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectB = J30.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectB.left;
                rect.right -= rectB.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = this.S > 0.5f ? this.g0 : this.h0;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f0;
            TextPaint textPaint = this.e0;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i3 + i4) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.H : this.f13J;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z, i, i2, i3, i4);
        int iMax2 = 0;
        if (this.t != null) {
            Drawable drawable = this.y;
            Rect rect = this.l0;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectB = J30.b(this.t);
            iMax = Math.max(0, rectB.left - rect.left);
            iMax2 = Math.max(0, rectB.right - rect.right);
        } else {
            iMax = 0;
        }
        boolean z2 = Jp2.a;
        if (getLayoutDirection() == 1) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.T + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.T) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i5 = this.U;
            int i6 = height2 - (i5 / 2);
            height = i5 + i6;
            paddingTop = i6;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.U + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.U;
        }
        this.W = paddingLeft;
        this.a0 = paddingTop;
        this.c0 = height;
        this.b0 = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        boolean z = this.L;
        int intrinsicHeight2 = 0;
        if (z) {
            StaticLayout staticLayout = this.g0;
            TextPaint textPaint = this.e0;
            if (staticLayout == null) {
                CharSequence charSequence = this.I;
                this.g0 = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.h0 == null) {
                CharSequence charSequence2 = this.K;
                this.h0 = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.t;
        Rect rect = this.l0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.t.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.t.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.V = Math.max(z ? (this.D * 2) + Math.max(this.g0.getWidth(), this.h0.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.y;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.y.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.t;
        if (drawable3 != null) {
            Rect rectB = J30.b(drawable3);
            iMax = Math.max(iMax, rectB.left);
            iMax2 = Math.max(iMax2, rectB.right);
        }
        int iMax3 = this.d0 ? Math.max(this.E, (this.V * 2) + iMax + iMax2) : this.E;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.T = iMax3;
        this.U = iMax4;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.H : this.f13J;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public final void setAllCaps(boolean z) {
        super.setAllCaps(z);
        c().c(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object string = this.H;
                if (string == null) {
                    string = getResources().getString(AbstractC0275Wp1.abc_capital_on);
                }
                Object obj = string;
                WeakHashMap weakHashMap = AbstractC0604eo2.a;
                new C0273Wn2(AbstractC0132Lp1.tag_state_description, CharSequence.class, 64, 30, 2).a(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object string2 = this.f13J;
            if (string2 == null) {
                string2 = getResources().getString(AbstractC0275Wp1.abc_capital_off);
            }
            Object obj2 = string2;
            WeakHashMap weakHashMap2 = AbstractC0604eo2.a;
            new C0273Wn2(AbstractC0132Lp1.tag_state_description, CharSequence.class, 64, 30, 2).a(this, obj2);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.j0;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            this.S = zIsChecked ? 1.0f : 0.0f;
            invalidate();
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, m0, zIsChecked ? 1.0f : 0.0f);
        this.j0 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.j0.setAutoCancel(true);
        this.j0.start();
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(F82.e(callback, this));
    }

    @Override // android.widget.TextView
    public final void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(c().a(inputFilterArr));
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.t || drawable == this.y;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        super(context, attributeSet, i);
        this.u = null;
        this.v = null;
        this.w = false;
        this.x = false;
        this.z = null;
        this.A = null;
        this.B = false;
        this.C = false;
        this.Q = VelocityTracker.obtain();
        this.d0 = true;
        this.l0 = new Rect();
        Q82.a(getContext(), this);
        TextPaint textPaint = new TextPaint(1);
        this.e0 = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        C1342qa2 c1342qa2F = C1342qa2.f(context, attributeSet, AbstractC0305Yp1.SwitchCompat, i);
        AbstractC0604eo2.n(this, context, AbstractC0305Yp1.SwitchCompat, attributeSet, c1342qa2F.b, i, 0);
        Drawable drawableB = c1342qa2F.b(AbstractC0305Yp1.SwitchCompat_android_thumb);
        this.t = drawableB;
        if (drawableB != null) {
            drawableB.setCallback(this);
        }
        Drawable drawableB2 = c1342qa2F.b(AbstractC0305Yp1.SwitchCompat_track);
        this.y = drawableB2;
        if (drawableB2 != null) {
            drawableB2.setCallback(this);
        }
        int i2 = AbstractC0305Yp1.SwitchCompat_android_textOn;
        TypedArray typedArray = c1342qa2F.b;
        h(typedArray.getText(i2));
        g(typedArray.getText(AbstractC0305Yp1.SwitchCompat_android_textOff));
        this.L = typedArray.getBoolean(AbstractC0305Yp1.SwitchCompat_showText, true);
        this.D = typedArray.getDimensionPixelSize(AbstractC0305Yp1.SwitchCompat_thumbTextPadding, 0);
        this.E = typedArray.getDimensionPixelSize(AbstractC0305Yp1.SwitchCompat_switchMinWidth, 0);
        this.F = typedArray.getDimensionPixelSize(AbstractC0305Yp1.SwitchCompat_switchPadding, 0);
        this.G = typedArray.getBoolean(AbstractC0305Yp1.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListA = c1342qa2F.a(AbstractC0305Yp1.SwitchCompat_thumbTint);
        if (colorStateListA != null) {
            this.u = colorStateListA;
            this.w = true;
        }
        PorterDuff.Mode modeC = J30.c(typedArray.getInt(AbstractC0305Yp1.SwitchCompat_thumbTintMode, -1), null);
        if (modeC != null) {
            this.v = modeC;
            this.x = true;
        }
        if (this.w || this.x) {
            a();
        }
        ColorStateList colorStateListA2 = c1342qa2F.a(AbstractC0305Yp1.SwitchCompat_trackTint);
        if (colorStateListA2 != null) {
            this.z = colorStateListA2;
            this.B = true;
        }
        PorterDuff.Mode modeC2 = J30.c(typedArray.getInt(AbstractC0305Yp1.SwitchCompat_trackTintMode, -1), null);
        if (modeC2 != null) {
            this.A = modeC2;
            this.C = true;
        }
        if (this.B || this.C) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(AbstractC0305Yp1.SwitchCompat_switchTextAppearance, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId2, AbstractC0305Yp1.TextAppearance);
            int i3 = AbstractC0305Yp1.TextAppearance_android_textColor;
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes.hasValue(i3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(i3, 0)) == 0 || (colorStateList = U3.b(resourceId, context)) == null) ? typedArrayObtainStyledAttributes.getColorStateList(i3) : colorStateList;
            if (colorStateList != null) {
                this.f0 = colorStateList;
            } else {
                this.f0 = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.TextAppearance_android_textSize, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != textPaint.getTextSize()) {
                    textPaint.setTextSize(f);
                    requestLayout();
                }
            }
            int i4 = typedArrayObtainStyledAttributes.getInt(AbstractC0305Yp1.TextAppearance_android_typeface, -1);
            int i5 = typedArrayObtainStyledAttributes.getInt(AbstractC0305Yp1.TextAppearance_android_textStyle, -1);
            Typeface typeface = i4 != 1 ? i4 != 2 ? i4 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i5 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i5) : Typeface.create(typeface, i5);
                f(typefaceDefaultFromStyle);
                int i6 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i5;
                textPaint.setFakeBoldText((i6 & 1) != 0);
                textPaint.setTextSkewX((i6 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                f(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.TextAppearance_textAllCaps, false)) {
                Context context2 = getContext();
                v6 v6Var = new v6();
                v6Var.a = context2.getResources().getConfiguration().locale;
                this.i0 = v6Var;
            } else {
                this.i0 = null;
            }
            h(this.H);
            g(this.f13J);
            typedArrayObtainStyledAttributes.recycle();
        }
        new Mb(this).e(attributeSet, i);
        c1342qa2F.g();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.N = viewConfiguration.getScaledTouchSlop();
        this.R = viewConfiguration.getScaledMinimumFlingVelocity();
        c().b(attributeSet, i);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
