package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.google.android.gms.common.api.Api;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0228Sv2;
import defpackage.AbstractC0604eo2;
import defpackage.C0151Mv2;
import defpackage.C0166Nv2;
import defpackage.C0192Pv2;
import defpackage.C0215Rv2;
import defpackage.C0307Yv2;
import defpackage.C0383aw2;
import defpackage.C0660fb2;
import defpackage.C0683g3;
import defpackage.C0791hd2;
import defpackage.C1173np2;
import defpackage.C1586uv2;
import defpackage.C3;
import defpackage.Ep1;
import defpackage.InterfaceC1513tV;
import defpackage.MenuC0775hQ0;
import defpackage.QX0;
import defpackage.RX0;
import defpackage.RunnableC0750h3;
import defpackage.SQ0;
import defpackage.SX0;
import defpackage.bx0;
import defpackage.i3;
import defpackage.j3;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC1513tV, QX0, RX0 {
    public static final Rect b0 = new Rect();
    public static final int[] c0 = {Ep1.actionBarSize, R.attr.windowContentOverlay};
    public static final C0383aw2 d0;
    public static final Rect e0;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public final Rect F;
    public final Rect G;
    public final Rect H;
    public final Rect I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Rect f10J;
    public boolean K;
    public boolean L;
    public C0383aw2 M;
    public C0383aw2 N;
    public C0383aw2 O;
    public C0383aw2 P;
    public C1586uv2 Q;
    public OverScroller R;
    public ViewPropertyAnimator S;
    public final C0683g3 T;
    public final RunnableC0750h3 U;
    public final RunnableC0750h3 V;
    public final SX0 W;
    public final j3 a0;
    public int t;
    public int u;
    public ContentFrameLayout v;
    public ActionBarContainer w;
    public C0791hd2 x;
    public Drawable y;
    public boolean z;

    static {
        C0151Mv2 c0151Mv2 = new C0151Mv2();
        bx0 bx0VarB = bx0.b(0, 1, 0, 1);
        AbstractC0228Sv2 abstractC0228Sv2 = c0151Mv2.a;
        abstractC0228Sv2.g(bx0VarB);
        d0 = abstractC0228Sv2.b();
        e0 = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = 0;
        this.F = new Rect();
        this.G = new Rect();
        this.H = new Rect();
        this.I = new Rect();
        this.f10J = new Rect();
        this.K = true;
        this.L = false;
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        C0383aw2 c0383aw2 = C0383aw2.b;
        this.M = c0383aw2;
        this.N = c0383aw2;
        this.O = c0383aw2;
        this.P = c0383aw2;
        this.T = new C0683g3(this);
        this.U = new RunnableC0750h3(this, 0);
        this.V = new RunnableC0750h3(this, 1);
        g(context);
        this.W = new SX0();
        j3 j3Var = new j3(context);
        j3Var.setWillNotDraw(true);
        this.a0 = j3Var;
        addView(j3Var);
    }

    public static boolean l(View view, Rect rect, boolean z) {
        boolean z2;
        i3 i3Var = (i3) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) i3Var).leftMargin;
        int i2 = rect.left;
        if (i != i2) {
            ((ViewGroup.MarginLayoutParams) i3Var).leftMargin = i2;
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = ((ViewGroup.MarginLayoutParams) i3Var).topMargin;
        int i4 = rect.top;
        if (i3 != i4) {
            ((ViewGroup.MarginLayoutParams) i3Var).topMargin = i4;
            z2 = true;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) i3Var).rightMargin;
        int i6 = rect.right;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) i3Var).rightMargin = i6;
            z2 = true;
        }
        if (z) {
            int i7 = ((ViewGroup.MarginLayoutParams) i3Var).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) i3Var).bottomMargin = i8;
                return true;
            }
        }
        return z2;
    }

    public static boolean n(Rect rect, View view) {
        if (view.getPaddingLeft() == rect.left && view.getPaddingTop() == rect.top && view.getPaddingRight() == rect.right) {
            return false;
        }
        view.setPadding(rect.left, rect.top, rect.right, view.getPaddingBottom());
        return true;
    }

    @Override // defpackage.QX0
    public final void a(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // defpackage.QX0
    public final void b(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof i3;
    }

    public final void d() {
        removeCallbacks(this.U);
        removeCallbacks(this.V);
        ViewPropertyAnimator viewPropertyAnimator = this.S;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.y != null) {
            if (this.w.getVisibility() == 0) {
                translationY = (int) (this.w.getTranslationY() + this.w.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.y.setBounds(0, translationY, getWidth(), this.y.getIntrinsicHeight() + translationY);
            this.y.draw(canvas);
        }
    }

    @Override // defpackage.RX0
    public final void e(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        f(view, i, i2, i3, i4, i5);
    }

    @Override // defpackage.QX0
    public final void f(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public final void g(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(c0);
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.y = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.R = new OverScroller(context);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new i3(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new i3(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final int getNestedScrollAxes() {
        SX0 sx0 = this.W;
        return sx0.b | sx0.a;
    }

    @Override // defpackage.QX0
    public final boolean h(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    public final void i(int i) {
        j();
        if (i == 2) {
            this.x.getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i == 5) {
            this.x.getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i != 109) {
                return;
            }
            this.z = true;
        }
    }

    public final void j() {
        if (this.v == null) {
            this.v = (ContentFrameLayout) findViewById(AbstractC0132Lp1.action_bar_activity_content);
            this.w = (ActionBarContainer) findViewById(AbstractC0132Lp1.action_bar_container);
            View viewFindViewById = findViewById(AbstractC0132Lp1.action_bar);
            if (!(viewFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(viewFindViewById.getClass().getSimpleName()));
            }
            Toolbar toolbar = (Toolbar) viewFindViewById;
            if (toolbar.g0 == null) {
                toolbar.g0 = new C0791hd2(toolbar, true);
            }
            this.x = toolbar.g0;
        }
    }

    public final void k(boolean z) {
        if (z != this.B) {
            this.B = z;
            if (z) {
                return;
            }
            d();
            d();
            this.w.setTranslationY(-Math.max(0, Math.min(0, this.w.getHeight())));
        }
    }

    public final void m(MenuC0775hQ0 menuC0775hQ0, SQ0 sq0) {
        j();
        C0791hd2 c0791hd2 = this.x;
        C3 c3 = c0791hd2.m;
        Toolbar toolbar = c0791hd2.a;
        if (c3 == null) {
            c0791hd2.m = new C3(toolbar.getContext());
        }
        C3 c32 = c0791hd2.m;
        c32.x = sq0;
        if (menuC0775hQ0 == null && toolbar.t == null) {
            return;
        }
        toolbar.f();
        MenuC0775hQ0 menuC0775hQ02 = toolbar.t.I;
        if (menuC0775hQ02 == menuC0775hQ0) {
            return;
        }
        if (menuC0775hQ02 != null) {
            menuC0775hQ02.r(toolbar.h0);
            menuC0775hQ02.r(toolbar.i0);
        }
        if (toolbar.i0 == null) {
            toolbar.i0 = new C0660fb2(toolbar);
        }
        c32.f1J = true;
        if (menuC0775hQ0 != null) {
            menuC0775hQ0.b(c32, toolbar.C);
            menuC0775hQ0.b(toolbar.i0, toolbar.C);
        } else {
            c32.h(toolbar.C, null);
            toolbar.i0.h(toolbar.C, null);
            c32.f();
            toolbar.i0.f();
        }
        ActionMenuView actionMenuView = toolbar.t;
        int i = toolbar.D;
        if (actionMenuView.K != i) {
            actionMenuView.K = i;
            if (i == 0) {
                actionMenuView.f11J = actionMenuView.getContext();
            } else {
                actionMenuView.f11J = new ContextThemeWrapper(actionMenuView.getContext(), i);
            }
        }
        ActionMenuView actionMenuView2 = toolbar.t;
        actionMenuView2.M = c32;
        c32.A = actionMenuView2;
        actionMenuView2.I = c32.v;
        toolbar.h0 = c32;
        toolbar.J();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        boolean zN;
        boolean zL;
        j();
        int windowSystemUiVisibility = getWindowSystemUiVisibility();
        boolean z = true;
        boolean z2 = (windowSystemUiVisibility & 256) != 0;
        boolean z3 = (windowSystemUiVisibility & 1536) != 0;
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        WindowInsets windowInsetsF = d0.f();
        Rect rect = this.f10J;
        if (windowInsetsF != null) {
            j3 j3Var = this.a0;
            C0383aw2.g(j3Var, j3Var.computeSystemWindowInsets(windowInsetsF, rect));
        } else {
            rect.setEmpty();
        }
        boolean zEquals = rect.equals(e0);
        this.K = !zEquals;
        boolean z4 = zEquals || (z2 && z3);
        this.L = z4;
        C1586uv2 c1586uv2 = this.Q;
        if (c1586uv2 != null) {
            c1586uv2.o = (z2 || z4) ? false : true;
        }
        C0383aw2 c0383aw2G = C0383aw2.g(this, windowInsets);
        int iB = c0383aw2G.b();
        int iD = c0383aw2G.d();
        int iC = c0383aw2G.c();
        int iA = c0383aw2G.a();
        Rect rect2 = this.I;
        rect2.set(iB, iD, iC, iA);
        ActionBarContainer actionBarContainer = this.w;
        boolean z5 = this.L;
        Rect rect3 = b0;
        if (z5) {
            zN = l(actionBarContainer, rect3, false);
            zL = n(rect2, actionBarContainer);
        } else {
            zN = n(rect3, actionBarContainer);
            zL = l(actionBarContainer, rect2, false);
        }
        boolean z6 = zL | zN;
        WindowInsets windowInsetsF2 = c0383aw2G.f();
        Rect rect4 = this.F;
        if (windowInsetsF2 != null) {
            C0383aw2.g(this, computeSystemWindowInsets(windowInsetsF2, rect4));
        } else {
            rect4.setEmpty();
        }
        int i = rect4.left;
        int i2 = rect4.top;
        int i3 = rect4.right;
        int i4 = rect4.bottom;
        C0307Yv2 c0307Yv2 = c0383aw2G.a;
        C0383aw2 c0383aw2L = c0307Yv2.l(i, i2, i3, i4);
        this.M = c0383aw2L;
        if (!this.N.equals(c0383aw2L)) {
            this.N = this.M;
            z6 = true;
        }
        Rect rect5 = this.G;
        if (rect5.equals(rect4)) {
            z = z6;
        } else {
            rect5.set(rect4);
        }
        if (z) {
            requestLayout();
        }
        return c0307Yv2.a().a.c().a.b().f();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g(getContext());
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                i3 i3Var = (i3) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) i3Var).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) i3Var).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int measuredHeight;
        AbstractC0228Sv2 c0192Pv2;
        j();
        measureChildWithMargins(this.w, i, 0, i2, 0);
        i3 i3Var = (i3) this.w.getLayoutParams();
        int iMax = Math.max(0, this.w.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) i3Var).leftMargin + ((ViewGroup.MarginLayoutParams) i3Var).rightMargin);
        int iMax2 = Math.max(0, this.w.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) i3Var).topMargin + ((ViewGroup.MarginLayoutParams) i3Var).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.w.getMeasuredState());
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        boolean z = (getWindowSystemUiVisibility() & 256) != 0;
        if (z) {
            measuredHeight = this.t;
            if (this.L) {
                measuredHeight += this.I.top;
            }
            if (this.A) {
                this.w.getClass();
            }
        } else {
            measuredHeight = this.w.getVisibility() != 8 ? this.w.getMeasuredHeight() : 0;
        }
        Rect rect = this.F;
        Rect rect2 = this.H;
        rect2.set(rect);
        C0383aw2 c0383aw2 = this.M;
        this.O = c0383aw2;
        if (this.z || z || !this.K) {
            bx0 bx0VarB = this.L ? bx0.b(c0383aw2.b(), Math.max(this.O.d(), measuredHeight), this.O.c(), Math.max(this.O.a(), 0)) : bx0.b(c0383aw2.b(), this.O.d() + measuredHeight, this.O.c(), this.O.a());
            C0383aw2 c0383aw22 = this.O;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                c0192Pv2 = new C0215Rv2(c0383aw22);
            } else if (i3 >= 29) {
                c0192Pv2 = new C0192Pv2(c0383aw22);
            } else {
                C0166Nv2 c0166Nv2 = new C0166Nv2(c0383aw22);
                c0166Nv2.c = c0383aw22.f();
                c0192Pv2 = c0166Nv2;
            }
            c0192Pv2.g(bx0VarB);
            this.O = c0192Pv2.b();
        } else {
            if (this.L) {
                rect2.top = Math.max(rect2.top, measuredHeight);
                rect2.bottom = Math.max(rect2.bottom, 0);
            } else {
                rect2.top += measuredHeight;
                rect2.bottom = rect2.bottom;
            }
            this.O = this.O.a.l(0, measuredHeight, 0, 0);
        }
        l(this.v, rect2, true);
        if (!this.P.equals(this.O)) {
            C0383aw2 c0383aw23 = this.O;
            this.P = c0383aw23;
            AbstractC0604eo2.b(this.v, c0383aw23);
        }
        measureChildWithMargins(this.v, i, 0, i2, 0);
        i3 i3Var2 = (i3) this.v.getLayoutParams();
        int iMax3 = Math.max(iMax, this.v.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) i3Var2).leftMargin + ((ViewGroup.MarginLayoutParams) i3Var2).rightMargin);
        int iMax4 = Math.max(iMax2, this.v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) i3Var2).topMargin + ((ViewGroup.MarginLayoutParams) i3Var2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.v.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.B || !z) {
            return false;
        }
        this.R.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (this.R.getFinalY() > this.w.getHeight()) {
            d();
            this.V.run();
        } else {
            d();
            this.U.run();
        }
        this.C = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.D = this.D + i2;
        d();
        this.w.setTranslationY(-Math.max(0, Math.min(r1, this.w.getHeight())));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        C1173np2 c1173np2;
        this.W.a = i;
        ActionBarContainer actionBarContainer = this.w;
        this.D = actionBarContainer != null ? -((int) actionBarContainer.getTranslationY()) : 0;
        d();
        C1586uv2 c1586uv2 = this.Q;
        if (c1586uv2 == null || (c1173np2 = c1586uv2.s) == null) {
            return;
        }
        c1173np2.a();
        c1586uv2.s = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.w.getVisibility() != 0) {
            return false;
        }
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.B || this.C) {
            return;
        }
        if (this.D <= this.w.getHeight()) {
            d();
            postDelayed(this.U, 600L);
        } else {
            d();
            postDelayed(this.V, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        j();
        int i2 = this.E ^ i;
        this.E = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        C1586uv2 c1586uv2 = this.Q;
        if (c1586uv2 != null) {
            c1586uv2.o = (z2 || this.L) ? false : true;
            if (z || !z2) {
                if (c1586uv2.p) {
                    c1586uv2.p = false;
                    c1586uv2.x(true);
                }
            } else if (!c1586uv2.p) {
                c1586uv2.p = true;
                c1586uv2.x(true);
            }
        }
        if ((i2 & 256) == 0 || this.Q == null) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        requestApplyInsets();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.u = i;
        C1586uv2 c1586uv2 = this.Q;
        if (c1586uv2 != null) {
            c1586uv2.n = i;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new i3(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // defpackage.QX0
    public final void c(View view, int i, int i2, int[] iArr, int i3) {
    }
}
