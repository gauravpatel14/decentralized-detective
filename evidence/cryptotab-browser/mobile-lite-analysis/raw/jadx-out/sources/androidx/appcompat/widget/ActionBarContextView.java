package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0189Pp1;
import defpackage.AbstractC0305Yp1;
import defpackage.AbstractC0604eo2;
import defpackage.AbstractC1686wb;
import defpackage.C0813i;
import defpackage.C1050lp2;
import defpackage.C1710x3;
import defpackage.C3;
import defpackage.Ep1;
import defpackage.H3;
import defpackage.Jp2;
import defpackage.MenuC0775hQ0;
import defpackage.ViewOnClickListenerC0617f3;
import defpackage.WQ0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {
    public boolean A;
    public CharSequence B;
    public CharSequence C;
    public View D;
    public View E;
    public View F;
    public LinearLayout G;
    public TextView H;
    public TextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f9J;
    public final int K;
    public boolean L;
    public final int M;
    public final C0813i t;
    public final Context u;
    public ActionMenuView v;
    public C3 w;
    public int x;
    public C1050lp2 y;
    public boolean z;

    /* JADX WARN: Illegal instructions before constructor call */
    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        int i = Ep1.actionModeStyle;
        super(context, attributeSet, i);
        this.t = new C0813i(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(Ep1.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.u = context;
        } else {
            this.u = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.ActionMode, i, 0);
        int i2 = AbstractC0305Yp1.ActionMode_background;
        setBackground((!typedArrayObtainStyledAttributes.hasValue(i2) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(i2) : AbstractC1686wb.a(resourceId, context));
        this.f9J = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.ActionMode_titleTextStyle, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.ActionMode_subtitleTextStyle, 0);
        this.x = typedArrayObtainStyledAttributes.getLayoutDimension(AbstractC0305Yp1.ActionMode_height, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.ActionMode_closeItemLayout, AbstractC0189Pp1.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int f(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int g(int i, int i2, int i3, View view, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public final void c(H3 h3) {
        View view = this.D;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.M, (ViewGroup) this, false);
            this.D = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.D);
        }
        View viewFindViewById = this.D.findViewById(AbstractC0132Lp1.action_mode_close_button);
        this.E = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0617f3(h3));
        MenuC0775hQ0 menuC0775hQ0E = h3.e();
        C3 c3 = this.w;
        if (c3 != null) {
            c3.g();
            C1710x3 c1710x3 = c3.M;
            if (c1710x3 != null && c1710x3.b()) {
                c1710x3.i.dismiss();
            }
        }
        C3 c32 = new C3(getContext());
        this.w = c32;
        c32.E = true;
        c32.F = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuC0775hQ0E.b(this.w, this.u);
        C3 c33 = this.w;
        WQ0 wq0 = c33.A;
        if (wq0 == null) {
            WQ0 wq02 = (WQ0) c33.w.inflate(c33.y, (ViewGroup) this, false);
            c33.A = wq02;
            wq02.c(c33.v);
            c33.f();
        }
        WQ0 wq03 = c33.A;
        if (wq0 != wq03) {
            ActionMenuView actionMenuView = (ActionMenuView) wq03;
            actionMenuView.M = c33;
            c33.A = actionMenuView;
            actionMenuView.I = c33.v;
        }
        ActionMenuView actionMenuView2 = (ActionMenuView) wq03;
        this.v = actionMenuView2;
        actionMenuView2.setBackground(null);
        addView(this.v, layoutParams);
    }

    public final void d() {
        if (this.G == null) {
            LayoutInflater.from(getContext()).inflate(AbstractC0189Pp1.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.G = linearLayout;
            this.H = (TextView) linearLayout.findViewById(AbstractC0132Lp1.action_bar_title);
            this.I = (TextView) this.G.findViewById(AbstractC0132Lp1.action_bar_subtitle);
            int i = this.f9J;
            if (i != 0) {
                this.H.setTextAppearance(getContext(), i);
            }
            int i2 = this.K;
            if (i2 != 0) {
                this.I.setTextAppearance(getContext(), i2);
            }
        }
        this.H.setText(this.B);
        this.I.setText(this.C);
        boolean zIsEmpty = TextUtils.isEmpty(this.B);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.C);
        this.I.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.G.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.G.getParent() == null) {
            addView(this.G);
        }
    }

    public final void e() {
        removeAllViews();
        this.F = null;
        this.v = null;
        this.w = null;
        View view = this.E;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public final void h(View view) {
        LinearLayout linearLayout;
        View view2 = this.F;
        if (view2 != null) {
            removeView(view2);
        }
        this.F = view;
        if (view != null && (linearLayout = this.G) != null) {
            removeView(linearLayout);
            this.G = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public final C1050lp2 i(int i, long j) {
        C1050lp2 c1050lp2 = this.y;
        if (c1050lp2 != null) {
            c1050lp2.b();
        }
        C0813i c0813i = this.t;
        if (i != 0) {
            C1050lp2 c1050lp2A = AbstractC0604eo2.a(this);
            c1050lp2A.a(0.0f);
            c1050lp2A.c(j);
            c0813i.c.y = c1050lp2A;
            c0813i.b = i;
            c1050lp2A.d(c0813i);
            return c1050lp2A;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        C1050lp2 c1050lp2A2 = AbstractC0604eo2.a(this);
        c1050lp2A2.a(1.0f);
        c1050lp2A2.c(j);
        c0813i.c.y = c1050lp2A2;
        c0813i.b = i;
        c1050lp2A2.d(c0813i);
        return c1050lp2A2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC0305Yp1.ActionBar, Ep1.actionBarStyle, 0);
        this.x = typedArrayObtainStyledAttributes.getLayoutDimension(AbstractC0305Yp1.ActionBar_height, 0);
        typedArrayObtainStyledAttributes.recycle();
        C3 c3 = this.w;
        if (c3 != null) {
            Configuration configuration2 = c3.u.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i2 = configuration2.screenHeightDp;
            c3.I = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
            MenuC0775hQ0 menuC0775hQ0 = c3.v;
            if (menuC0775hQ0 != null) {
                menuC0775hQ0.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C3 c3 = this.w;
        if (c3 != null) {
            c3.g();
            C1710x3 c1710x3 = this.w.M;
            if (c1710x3 == null || !c1710x3.b()) {
                return;
            }
            c1710x3.i.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.A = false;
        }
        if (!this.A) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.A = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.A = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = Jp2.a;
        boolean z3 = getLayoutDirection() == 1;
        int paddingRight = z3 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.D;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.D.getLayoutParams();
            int i5 = z3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = z3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i7 = z3 ? paddingRight - i5 : paddingRight + i5;
            int iG = g(i7, paddingTop, paddingTop2, this.D, z3) + i7;
            paddingRight = z3 ? iG - i6 : iG + i6;
        }
        LinearLayout linearLayout = this.G;
        if (linearLayout != null && this.F == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(paddingRight, paddingTop, paddingTop2, this.G, z3);
        }
        View view2 = this.F;
        if (view2 != null) {
            g(paddingRight, paddingTop, paddingTop2, view2, z3);
        }
        int paddingLeft = z3 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.v;
        if (actionMenuView != null) {
            g(paddingLeft, paddingTop, paddingTop2, actionMenuView, !z3);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.x;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i2);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.D;
        if (view != null) {
            int iF = f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.D.getLayoutParams();
            paddingLeft = iF - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.v;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.v, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.G;
        if (linearLayout != null && this.F == null) {
            if (this.L) {
                this.G.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.G.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.G.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.F;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i3 = layoutParams.width;
            int i4 = i3 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i3 >= 0) {
                paddingLeft = Math.min(i3, paddingLeft);
            }
            int i5 = layoutParams.height;
            int i6 = i5 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i5 >= 0) {
                iMin = Math.min(i5, iMin);
            }
            this.F.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(iMin, i6));
        }
        if (this.x > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i7) {
                i7 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i7);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.z = false;
        }
        if (!this.z) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.z = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.z = false;
        }
        return true;
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            C1050lp2 c1050lp2 = this.y;
            if (c1050lp2 != null) {
                c1050lp2.b();
            }
            super.setVisibility(i);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
