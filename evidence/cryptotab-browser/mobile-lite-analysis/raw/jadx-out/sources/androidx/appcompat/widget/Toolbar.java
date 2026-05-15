package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.customview.view.AbsSavedState;
import defpackage.AQ0;
import defpackage.AbstractC0305Yp1;
import defpackage.AbstractC0596eb2;
import defpackage.AbstractC0604eo2;
import defpackage.BQ0;
import defpackage.C0366ab2;
import defpackage.C0539db2;
import defpackage.C0600ei0;
import defpackage.C0660fb2;
import defpackage.C0724gb2;
import defpackage.C0791hd2;
import defpackage.C0856ib2;
import defpackage.C0977kb2;
import defpackage.C1039lb2;
import defpackage.C1285pb;
import defpackage.C1342qa2;
import defpackage.C3;
import defpackage.DQ0;
import defpackage.Ep1;
import defpackage.InterfaceC0790hb2;
import defpackage.Jp2;
import defpackage.MenuC0775hQ0;
import defpackage.ZR1;
import defpackage.Za2;
import defpackage.bb2;
import defpackage.kx1;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements AQ0 {
    public C1285pb A;
    public View B;
    public Context C;
    public int D;
    public int E;
    public int F;
    public final int G;
    public final int H;
    public final int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f14J;
    public final int K;
    public final int L;
    public kx1 M;
    public final int N;
    public final int O;
    public final int P;
    public CharSequence Q;
    public CharSequence R;
    public final ColorStateList S;
    public final ColorStateList T;
    public boolean U;
    public boolean V;
    public final ArrayList W;
    public final ArrayList a0;
    public final int[] b0;
    public final BQ0 c0;
    public ArrayList d0;
    public InterfaceC0790hb2 e0;
    public final C0366ab2 f0;
    public C0791hd2 g0;
    public C3 h0;
    public C0660fb2 i0;
    public C1039lb2 j0;
    public C0977kb2 k0;
    public boolean l0;
    public C0539db2 m0;
    public OnBackInvokedDispatcher n0;
    public boolean o0;
    public final bb2 p0;
    public ActionMenuView t;
    public AppCompatTextView u;
    public AppCompatTextView v;
    public C1285pb w;
    public AppCompatImageView x;
    public final Drawable y;
    public final CharSequence z;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR = new C0856ib2();
        public int v;
        public boolean w;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.v = parcel.readInt();
            this.w = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.v);
            parcel.writeInt(this.w ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Ep1.toolbarStyle);
    }

    public static C0724gb2 h() {
        C0724gb2 c0724gb2 = new C0724gb2(-2, -2);
        c0724gb2.b = 0;
        c0724gb2.a = 8388627;
        return c0724gb2;
    }

    public static C0724gb2 i(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof C0724gb2;
        if (z) {
            C0724gb2 c0724gb2 = (C0724gb2) layoutParams;
            C0724gb2 c0724gb22 = new C0724gb2(c0724gb2);
            c0724gb22.b = 0;
            c0724gb22.b = c0724gb2.b;
            return c0724gb22;
        }
        if (z) {
            C0724gb2 c0724gb23 = new C0724gb2((C0724gb2) layoutParams);
            c0724gb23.b = 0;
            return c0724gb23;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            C0724gb2 c0724gb24 = new C0724gb2(layoutParams);
            c0724gb24.b = 0;
            return c0724gb24;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        C0724gb2 c0724gb25 = new C0724gb2(marginLayoutParams);
        c0724gb25.b = 0;
        ((ViewGroup.MarginLayoutParams) c0724gb25).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) c0724gb25).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) c0724gb25).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) c0724gb25).bottomMargin = marginLayoutParams.bottomMargin;
        return c0724gb25;
    }

    public static int n(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int q(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void A(Drawable drawable) {
        if (drawable != null) {
            if (this.x == null) {
                this.x = new AppCompatImageView(getContext(), null);
            }
            if (!t(this.x)) {
                b(this.x, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.x;
            if (appCompatImageView != null && t(appCompatImageView)) {
                removeView(this.x);
                this.a0.remove(this.x);
            }
        }
        AppCompatImageView appCompatImageView2 = this.x;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public final void B(int i) {
        C(i != 0 ? getContext().getText(i) : null);
    }

    public final void C(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        C1285pb c1285pb = this.w;
        if (c1285pb != null) {
            c1285pb.setContentDescription(charSequence);
            this.w.setTooltipText(charSequence);
        }
    }

    public void D(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!t(this.w)) {
                b(this.w, true);
            }
        } else {
            C1285pb c1285pb = this.w;
            if (c1285pb != null && t(c1285pb)) {
                removeView(this.w);
                this.a0.remove(this.w);
            }
        }
        C1285pb c1285pb2 = this.w;
        if (c1285pb2 != null) {
            c1285pb2.setImageDrawable(drawable);
        }
    }

    public final void E(View.OnClickListener onClickListener) {
        g();
        this.w.setOnClickListener(onClickListener);
    }

    public final void F(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.v;
            if (appCompatTextView != null && t(appCompatTextView)) {
                removeView(this.v);
                this.a0.remove(this.v);
            }
        } else {
            if (this.v == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.v = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.v.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.F;
                if (i != 0) {
                    this.v.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.T;
                if (colorStateList != null) {
                    this.v.setTextColor(colorStateList);
                }
            }
            if (!t(this.v)) {
                b(this.v, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.v;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.R = charSequence;
    }

    public void G(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.u;
            if (appCompatTextView != null && t(appCompatTextView)) {
                removeView(this.u);
                this.a0.remove(this.u);
            }
        } else {
            if (this.u == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.u = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.u.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.E;
                if (i != 0) {
                    this.u.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.S;
                if (colorStateList != null) {
                    this.u.setTextColor(colorStateList);
                }
            }
            if (!t(this.u)) {
                b(this.u, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.u;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.Q = charSequence;
    }

    public final boolean H(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean I() {
        C3 c3;
        ActionMenuView actionMenuView = this.t;
        return (actionMenuView == null || (c3 = actionMenuView.M) == null || !c3.l()) ? false : true;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [db2] */
    public final void J() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = AbstractC0596eb2.a(this);
            C0660fb2 c0660fb2 = this.i0;
            boolean z = (c0660fb2 == null || c0660fb2.u == null || onBackInvokedDispatcherA == null || !isAttachedToWindow() || !this.o0) ? false : true;
            if (z && this.n0 == null) {
                if (this.m0 == null) {
                    final Za2 za2 = new Za2(this, 0);
                    this.m0 = new OnBackInvokedCallback() { // from class: db2
                        public final void onBackInvoked() {
                            za2.run();
                        }
                    };
                }
                AbstractC0596eb2.b(onBackInvokedDispatcherA, this.m0);
                this.n0 = onBackInvokedDispatcherA;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.n0) == null) {
                return;
            }
            AbstractC0596eb2.c(onBackInvokedDispatcher, this.m0);
            this.n0 = null;
        }
    }

    public final void a(int i, ArrayList arrayList) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C0724gb2 c0724gb2 = (C0724gb2) childAt.getLayoutParams();
                if (c0724gb2.b == 0 && H(childAt)) {
                    int i3 = c0724gb2.a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            C0724gb2 c0724gb22 = (C0724gb2) childAt2.getLayoutParams();
            if (c0724gb22.b == 0 && H(childAt2)) {
                int i5 = c0724gb22.a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        C0724gb2 c0724gb2H = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (C0724gb2) layoutParams;
        c0724gb2H.b = 1;
        if (!z || this.B == null) {
            addView(view, c0724gb2H);
        } else {
            view.setLayoutParams(c0724gb2H);
            this.a0.add(view);
        }
    }

    public final void c() {
        if (this.M == null) {
            kx1 kx1Var = new kx1();
            kx1Var.a = 0;
            kx1Var.b = 0;
            kx1Var.c = Integer.MIN_VALUE;
            kx1Var.d = Integer.MIN_VALUE;
            kx1Var.e = 0;
            kx1Var.f = 0;
            kx1Var.g = false;
            kx1Var.h = false;
            this.M = kx1Var;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0724gb2);
    }

    public final void d() {
        f();
        ActionMenuView actionMenuView = this.t;
        if (actionMenuView.I == null) {
            MenuC0775hQ0 menuC0775hQ0O = actionMenuView.o();
            if (this.i0 == null) {
                this.i0 = new C0660fb2(this);
            }
            this.t.M.f1J = true;
            menuC0775hQ0O.b(this.i0, this.C);
            J();
        }
    }

    public final void f() {
        if (this.t == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.t = actionMenuView;
            int i = this.D;
            if (actionMenuView.K != i) {
                actionMenuView.K = i;
                if (i == 0) {
                    actionMenuView.f11J = actionMenuView.getContext();
                } else {
                    actionMenuView.f11J = new ContextThemeWrapper(actionMenuView.getContext(), i);
                }
            }
            ActionMenuView actionMenuView2 = this.t;
            actionMenuView2.T = this.f0;
            C1039lb2 c1039lb2 = this.j0;
            C0366ab2 c0366ab2 = new C0366ab2(this);
            actionMenuView2.N = c1039lb2;
            actionMenuView2.O = c0366ab2;
            C0724gb2 c0724gb2H = h();
            c0724gb2H.a = (this.G & 112) | 8388613;
            this.t.setLayoutParams(c0724gb2H);
            b(this.t, false);
        }
    }

    public final void g() {
        if (this.w == null) {
            this.w = new C1285pb(getContext(), null, Ep1.toolbarNavigationButtonStyle);
            C0724gb2 c0724gb2H = h();
            c0724gb2H.a = (this.G & 112) | 8388611;
            this.w.setLayoutParams(c0724gb2H);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public final int j(View view, int i) {
        C0724gb2 c0724gb2 = (C0724gb2) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = c0724gb2.a & 112;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.P & 112;
        }
        if (i3 == 48) {
            return getPaddingTop() - i2;
        }
        if (i3 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) c0724gb2).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) c0724gb2).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) c0724gb2).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    public final int k() {
        MenuC0775hQ0 menuC0775hQ0;
        ActionMenuView actionMenuView = this.t;
        int i = 0;
        if (actionMenuView != null && (menuC0775hQ0 = actionMenuView.I) != null && menuC0775hQ0.hasVisibleItems()) {
            kx1 kx1Var = this.M;
            return Math.max(kx1Var != null ? kx1Var.g ? kx1Var.a : kx1Var.b : 0, Math.max(this.O, 0));
        }
        kx1 kx1Var2 = this.M;
        if (kx1Var2 != null) {
            i = kx1Var2.g ? kx1Var2.a : kx1Var2.b;
        }
        return i;
    }

    @Override // defpackage.AQ0
    public final void k0(C0600ei0 c0600ei0) {
        BQ0 bq0 = this.c0;
        bq0.b.add(c0600ei0);
        bq0.a.run();
    }

    public final int l() {
        int i = 0;
        if (p() != null) {
            kx1 kx1Var = this.M;
            return Math.max(kx1Var != null ? kx1Var.g ? kx1Var.b : kx1Var.a : 0, Math.max(this.N, 0));
        }
        kx1 kx1Var2 = this.M;
        if (kx1Var2 != null) {
            i = kx1Var2.g ? kx1Var2.b : kx1Var2.a;
        }
        return i;
    }

    public final ArrayList m() {
        ArrayList arrayList = new ArrayList();
        MenuC0775hQ0 menuC0775hQ0O = o();
        for (int i = 0; i < menuC0775hQ0O.f.size(); i++) {
            arrayList.add(menuC0775hQ0O.getItem(i));
        }
        return arrayList;
    }

    public final MenuC0775hQ0 o() {
        d();
        return this.t.o();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        J();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.p0);
        J();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.V = false;
        }
        if (!this.V) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.V = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.V = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x029f A[LOOP:0: B:115:0x029d->B:116:0x029f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02bd A[LOOP:1: B:118:0x02bb->B:119:0x02bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02d9 A[LOOP:2: B:121:0x02d7->B:122:0x02d9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0327 A[LOOP:3: B:130:0x0325->B:131:0x0327, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c4  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 824
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        char c;
        char c2;
        int iN;
        int iMax;
        int iCombineMeasuredStates;
        int iN2;
        int iQ;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean z = Jp2.a;
        int i3 = 0;
        if (getLayoutDirection() == 1) {
            c2 = 1;
            c = 0;
        } else {
            c = 1;
            c2 = 0;
        }
        if (H(this.w)) {
            z(this.w, i, 0, i2, this.H);
            iN = n(this.w) + this.w.getMeasuredWidth();
            iMax = Math.max(0, q(this.w) + this.w.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.w.getMeasuredState());
        } else {
            iN = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (H(this.A)) {
            z(this.A, i, 0, i2, this.H);
            iN = n(this.A) + this.A.getMeasuredWidth();
            iMax = Math.max(iMax, q(this.A) + this.A.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.A.getMeasuredState());
        }
        int iL = l();
        int iMax3 = Math.max(iL, iN);
        int iMax4 = Math.max(0, iL - iN);
        int[] iArr = this.b0;
        iArr[c2] = iMax4;
        if (H(this.t)) {
            z(this.t, i, iMax3, i2, this.H);
            iN2 = n(this.t) + this.t.getMeasuredWidth();
            iMax = Math.max(iMax, q(this.t) + this.t.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.t.getMeasuredState());
        } else {
            iN2 = 0;
        }
        int iK = k();
        int iMax5 = iMax3 + Math.max(iK, iN2);
        iArr[c] = Math.max(0, iK - iN2);
        if (H(this.B)) {
            iMax5 += y(this.B, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, q(this.B) + this.B.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.B.getMeasuredState());
        }
        if (H(this.x)) {
            iMax5 += y(this.x, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, q(this.x) + this.x.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.x.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((C0724gb2) childAt.getLayoutParams()).b == 0 && H(childAt)) {
                iMax5 += y(childAt, i, iMax5, i2, 0, iArr);
                iMax = Math.max(iMax, q(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i5 = this.K + this.L;
        int i6 = this.I + this.f14J;
        if (H(this.u)) {
            y(this.u, i, iMax5 + i6, i2, i5, iArr);
            int iN3 = n(this.u) + this.u.getMeasuredWidth();
            iQ = q(this.u) + this.u.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.u.getMeasuredState());
            iMax2 = iN3;
        } else {
            iQ = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (H(this.v)) {
            iMax2 = Math.max(iMax2, y(this.v, i, iMax5 + i6, i2, iQ + i5, iArr));
            iQ = q(this.v) + this.v.getMeasuredHeight() + iQ;
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.v.getMeasuredState());
        }
        int iMax6 = Math.max(iMax, iQ);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax6;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + iMax5 + iMax2, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (!this.l0) {
            i3 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            View childAt2 = getChildAt(i7);
            if (H(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i3 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i3);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.t);
        ActionMenuView actionMenuView = this.t;
        MenuC0775hQ0 menuC0775hQ0 = actionMenuView != null ? actionMenuView.I : null;
        int i = savedState.v;
        if (i != 0 && this.i0 != null && menuC0775hQ0 != null && (menuItemFindItem = menuC0775hQ0.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.w) {
            bb2 bb2Var = this.p0;
            removeCallbacks(bb2Var);
            post(bb2Var);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        c();
        kx1 kx1Var = this.M;
        boolean z = i == 1;
        if (z == kx1Var.g) {
            return;
        }
        kx1Var.g = z;
        if (!kx1Var.h) {
            kx1Var.a = kx1Var.e;
            kx1Var.b = kx1Var.f;
            return;
        }
        if (z) {
            int i2 = kx1Var.d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = kx1Var.e;
            }
            kx1Var.a = i2;
            int i3 = kx1Var.c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = kx1Var.f;
            }
            kx1Var.b = i3;
            return;
        }
        int i4 = kx1Var.c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = kx1Var.e;
        }
        kx1Var.a = i4;
        int i5 = kx1Var.d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = kx1Var.f;
        }
        kx1Var.b = i5;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        DQ0 dq0;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        C0660fb2 c0660fb2 = this.i0;
        if (c0660fb2 != null && (dq0 = c0660fb2.u) != null) {
            savedState.v = dq0.a;
        }
        savedState.w = u();
        return savedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.U = false;
        }
        if (!this.U) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.U = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.U = false;
        }
        return true;
    }

    public final Drawable p() {
        C1285pb c1285pb = this.w;
        if (c1285pb != null) {
            return c1285pb.getDrawable();
        }
        return null;
    }

    public final boolean r() {
        C3 c3;
        ActionMenuView actionMenuView = this.t;
        return (actionMenuView == null || (c3 = actionMenuView.M) == null || !c3.g()) ? false : true;
    }

    public void s(int i) {
        new ZR1(getContext()).inflate(i, o());
    }

    public final boolean t(View view) {
        return view.getParent() == this || this.a0.contains(view);
    }

    public final boolean u() {
        C3 c3;
        ActionMenuView actionMenuView = this.t;
        return (actionMenuView == null || (c3 = actionMenuView.M) == null || !c3.k()) ? false : true;
    }

    public final int v(View view, int i, int i2, int[] iArr) {
        C0724gb2 c0724gb2 = (C0724gb2) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) c0724gb2).leftMargin - iArr[0];
        int iMax = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int iJ = j(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iJ, iMax + measuredWidth, view.getMeasuredHeight() + iJ);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) c0724gb2).rightMargin + iMax;
    }

    @Override // defpackage.AQ0
    public final void w(C0600ei0 c0600ei0) {
        BQ0 bq0 = this.c0;
        bq0.b.remove(c0600ei0);
        if (bq0.c.remove(c0600ei0) != null) {
            throw new ClassCastException();
        }
        bq0.a.run();
    }

    public final int x(View view, int i, int i2, int[] iArr) {
        C0724gb2 c0724gb2 = (C0724gb2) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) c0724gb2).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iJ = j(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iJ, iMax, view.getMeasuredHeight() + iJ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) c0724gb2).leftMargin);
    }

    public final int y(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void z(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.P = 8388627;
        this.W = new ArrayList();
        this.a0 = new ArrayList();
        this.b0 = new int[2];
        this.c0 = new BQ0(new Za2(this, 1));
        this.d0 = new ArrayList();
        this.f0 = new C0366ab2(this);
        this.p0 = new bb2(this);
        C1342qa2 c1342qa2F = C1342qa2.f(getContext(), attributeSet, AbstractC0305Yp1.Toolbar, i);
        AbstractC0604eo2.n(this, context, AbstractC0305Yp1.Toolbar, attributeSet, c1342qa2F.b, i, 0);
        int i2 = AbstractC0305Yp1.Toolbar_titleTextAppearance;
        TypedArray typedArray = c1342qa2F.b;
        this.E = typedArray.getResourceId(i2, 0);
        this.F = typedArray.getResourceId(AbstractC0305Yp1.Toolbar_subtitleTextAppearance, 0);
        this.P = typedArray.getInteger(AbstractC0305Yp1.Toolbar_android_gravity, 8388627);
        this.G = typedArray.getInteger(AbstractC0305Yp1.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_titleMargin, 0);
        dimensionPixelOffset = typedArray.hasValue(AbstractC0305Yp1.Toolbar_titleMargins) ? typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_titleMargins, dimensionPixelOffset) : dimensionPixelOffset;
        this.L = dimensionPixelOffset;
        this.K = dimensionPixelOffset;
        this.f14J = dimensionPixelOffset;
        this.I = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.I = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f14J = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.K = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.L = dimensionPixelOffset5;
        }
        this.H = typedArray.getDimensionPixelSize(AbstractC0305Yp1.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(AbstractC0305Yp1.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(AbstractC0305Yp1.Toolbar_contentInsetRight, 0);
        c();
        kx1 kx1Var = this.M;
        kx1Var.h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            kx1Var.e = dimensionPixelSize;
            kx1Var.a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            kx1Var.f = dimensionPixelSize2;
            kx1Var.b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            kx1Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.N = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.O = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.y = c1342qa2F.b(AbstractC0305Yp1.Toolbar_collapseIcon);
        this.z = typedArray.getText(AbstractC0305Yp1.Toolbar_collapseContentDescription);
        CharSequence text = typedArray.getText(AbstractC0305Yp1.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            G(text);
        }
        CharSequence text2 = typedArray.getText(AbstractC0305Yp1.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            F(text2);
        }
        this.C = getContext();
        int resourceId = typedArray.getResourceId(AbstractC0305Yp1.Toolbar_popupTheme, 0);
        if (this.D != resourceId) {
            this.D = resourceId;
            if (resourceId == 0) {
                this.C = getContext();
            } else {
                this.C = new ContextThemeWrapper(getContext(), resourceId);
            }
        }
        Drawable drawableB = c1342qa2F.b(AbstractC0305Yp1.Toolbar_navigationIcon);
        if (drawableB != null) {
            D(drawableB);
        }
        CharSequence text3 = typedArray.getText(AbstractC0305Yp1.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            C(text3);
        }
        Drawable drawableB2 = c1342qa2F.b(AbstractC0305Yp1.Toolbar_logo);
        if (drawableB2 != null) {
            A(drawableB2);
        }
        CharSequence text4 = typedArray.getText(AbstractC0305Yp1.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            if (!TextUtils.isEmpty(text4) && this.x == null) {
                this.x = new AppCompatImageView(getContext(), null);
            }
            AppCompatImageView appCompatImageView = this.x;
            if (appCompatImageView != null) {
                appCompatImageView.setContentDescription(text4);
            }
        }
        if (typedArray.hasValue(AbstractC0305Yp1.Toolbar_titleTextColor)) {
            ColorStateList colorStateListA = c1342qa2F.a(AbstractC0305Yp1.Toolbar_titleTextColor);
            this.S = colorStateListA;
            AppCompatTextView appCompatTextView = this.u;
            if (appCompatTextView != null) {
                appCompatTextView.setTextColor(colorStateListA);
            }
        }
        if (typedArray.hasValue(AbstractC0305Yp1.Toolbar_subtitleTextColor)) {
            ColorStateList colorStateListA2 = c1342qa2F.a(AbstractC0305Yp1.Toolbar_subtitleTextColor);
            this.T = colorStateListA2;
            AppCompatTextView appCompatTextView2 = this.v;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setTextColor(colorStateListA2);
            }
        }
        if (typedArray.hasValue(AbstractC0305Yp1.Toolbar_menu)) {
            s(typedArray.getResourceId(AbstractC0305Yp1.Toolbar_menu, 0));
        }
        c1342qa2F.g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        C0724gb2 c0724gb2 = new C0724gb2(context, attributeSet);
        c0724gb2.a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.ActionBarLayout);
        c0724gb2.a = typedArrayObtainStyledAttributes.getInt(AbstractC0305Yp1.ActionBarLayout_android_layout_gravity, 0);
        typedArrayObtainStyledAttributes.recycle();
        c0724gb2.b = 0;
        return c0724gb2;
    }
}
