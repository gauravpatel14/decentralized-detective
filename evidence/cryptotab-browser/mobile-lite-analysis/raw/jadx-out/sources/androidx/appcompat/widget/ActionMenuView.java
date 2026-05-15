package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.google.android.gms.common.api.Api;
import defpackage.C0366ab2;
import defpackage.C1039lb2;
import defpackage.C1489tF0;
import defpackage.C1710x3;
import defpackage.C3;
import defpackage.D3;
import defpackage.DQ0;
import defpackage.E3;
import defpackage.F3;
import defpackage.G3;
import defpackage.InterfaceC0641fQ0;
import defpackage.InterfaceC0706gQ0;
import defpackage.Jp2;
import defpackage.MenuC0775hQ0;
import defpackage.SQ0;
import defpackage.WQ0;
import defpackage.uF0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends uF0 implements InterfaceC0706gQ0, WQ0 {
    public MenuC0775hQ0 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Context f11J;
    public int K;
    public boolean L;
    public C3 M;
    public C1039lb2 N;
    public InterfaceC0641fQ0 O;
    public boolean P;
    public int Q;
    public final int R;
    public final int S;
    public C0366ab2 T;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.t = false;
        float f = context.getResources().getDisplayMetrics().density;
        this.R = (int) (56.0f * f);
        this.S = (int) (f * 4.0f);
        this.f11J = context;
        this.K = 0;
    }

    public static F3 m() {
        F3 f3 = new F3(-2, -2);
        f3.a = false;
        ((LinearLayout.LayoutParams) f3).gravity = 16;
        return f3;
    }

    public static F3 n(ViewGroup.LayoutParams layoutParams) {
        F3 f3;
        if (layoutParams == null) {
            return m();
        }
        if (layoutParams instanceof F3) {
            F3 f32 = (F3) layoutParams;
            f3 = new F3(f32);
            f3.a = f32.a;
        } else {
            f3 = new F3(layoutParams);
        }
        if (((LinearLayout.LayoutParams) f3).gravity <= 0) {
            ((LinearLayout.LayoutParams) f3).gravity = 16;
        }
        return f3;
    }

    @Override // defpackage.InterfaceC0706gQ0
    public final boolean a(DQ0 dq0) {
        return this.I.q(dq0, null, 0);
    }

    @Override // defpackage.WQ0
    public final void c(MenuC0775hQ0 menuC0775hQ0) {
        this.I = menuC0775hQ0;
    }

    @Override // defpackage.uF0, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof F3;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // defpackage.uF0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m();
    }

    @Override // defpackage.uF0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return n(layoutParams);
    }

    @Override // defpackage.uF0
    /* JADX INFO: renamed from: i */
    public final /* bridge */ /* synthetic */ C1489tF0 generateDefaultLayoutParams() {
        return m();
    }

    @Override // defpackage.uF0
    /* JADX INFO: renamed from: j */
    public final C1489tF0 generateLayoutParams(AttributeSet attributeSet) {
        return new F3(getContext(), attributeSet);
    }

    @Override // defpackage.uF0
    /* JADX INFO: renamed from: k */
    public final /* bridge */ /* synthetic */ C1489tF0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return n(layoutParams);
    }

    public final MenuC0775hQ0 o() {
        if (this.I == null) {
            Context context = getContext();
            MenuC0775hQ0 menuC0775hQ0 = new MenuC0775hQ0(context);
            this.I = menuC0775hQ0;
            menuC0775hQ0.e = new G3(this);
            C3 c3 = new C3(context);
            this.M = c3;
            c3.E = true;
            c3.F = true;
            SQ0 e3 = this.N;
            if (e3 == null) {
                e3 = new E3();
            }
            c3.x = e3;
            this.I.b(c3, this.f11J);
            C3 c32 = this.M;
            c32.A = this;
            this.I = c32.v;
        }
        return this.I;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3 c3 = this.M;
        if (c3 != null) {
            c3.f();
            if (this.M.k()) {
                this.M.g();
                this.M.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C3 c3 = this.M;
        if (c3 != null) {
            c3.g();
            C1710x3 c1710x3 = c3.M;
            if (c1710x3 == null || !c1710x3.b()) {
                return;
            }
            c1710x3.i.dismiss();
        }
    }

    @Override // defpackage.uF0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.P) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int i6 = this.E;
        int i7 = i3 - i;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean z2 = Jp2.a;
        boolean z3 = getLayoutDirection() == 1;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                F3 f3 = (F3) childAt.getLayoutParams();
                if (f3.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (p(i10)) {
                        measuredWidth += i6;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z3) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) f3).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) f3).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i11 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) f3).leftMargin) + ((LinearLayout.LayoutParams) f3).rightMargin;
                    p(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int iMax = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (z3) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                F3 f32 = (F3) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !f32.a) {
                    int i16 = width2 - ((LinearLayout.LayoutParams) f32).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + ((LinearLayout.LayoutParams) f32).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            F3 f33 = (F3) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !f33.a) {
                int i19 = paddingLeft2 + ((LinearLayout.LayoutParams) f33).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) f33).rightMargin + iMax + i19;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v36 */
    @Override // defpackage.uF0, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        ?? r4;
        int i8;
        int i9;
        int i10;
        MenuC0775hQ0 menuC0775hQ0;
        boolean z3 = this.P;
        boolean z4 = View.MeasureSpec.getMode(i) == 1073741824;
        this.P = z4;
        if (z3 != z4) {
            this.Q = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.P && (menuC0775hQ0 = this.I) != null && size != this.Q) {
            this.Q = size;
            menuC0775hQ0.p(true);
        }
        int childCount = getChildCount();
        if (!this.P || childCount <= 0) {
            for (int i11 = 0; i11 < childCount; i11++) {
                F3 f3 = (F3) getChildAt(i11).getLayoutParams();
                ((LinearLayout.LayoutParams) f3).rightMargin = 0;
                ((LinearLayout.LayoutParams) f3).leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i12 = size2 - paddingRight;
        int i13 = this.R;
        int i14 = i12 / i13;
        int i15 = i12 % i13;
        if (i14 == 0) {
            setMeasuredDimension(i12, 0);
            return;
        }
        int i16 = (i15 / i14) + i13;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i17 = 0;
        int iMax2 = 0;
        int i18 = 0;
        boolean z5 = false;
        int i19 = 0;
        long j = 0;
        while (true) {
            i3 = this.S;
            if (i18 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i18);
            int i20 = size3;
            int i21 = i12;
            if (childAt.getVisibility() == 8) {
                i8 = mode;
                i9 = paddingBottom;
            } else {
                boolean z6 = childAt instanceof ActionMenuItemView;
                int i22 = i17 + 1;
                if (z6) {
                    childAt.setPadding(i3, 0, i3, 0);
                }
                F3 f32 = (F3) childAt.getLayoutParams();
                f32.f = false;
                f32.c = 0;
                f32.b = 0;
                f32.d = false;
                ((LinearLayout.LayoutParams) f32).leftMargin = 0;
                ((LinearLayout.LayoutParams) f32).rightMargin = 0;
                f32.e = z6 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i23 = f32.a ? 1 : i14;
                F3 f33 = (F3) childAt.getLayoutParams();
                i8 = mode;
                i9 = paddingBottom;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z6 ? (ActionMenuItemView) childAt : null;
                boolean z7 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                if (i23 <= 0 || (z7 && i23 < 2)) {
                    i10 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i23 * i16, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i10 = measuredWidth / i16;
                    if (measuredWidth % i16 != 0) {
                        i10++;
                    }
                    if (z7 && i10 < 2) {
                        i10 = 2;
                    }
                }
                f33.d = !f33.a && z7;
                f33.b = i10;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i10 * i16, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i10);
                if (f32.d) {
                    i19++;
                }
                if (f32.a) {
                    z5 = true;
                }
                i14 -= i10;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i10 == 1) {
                    j |= (long) (1 << i18);
                }
                i17 = i22;
            }
            i18++;
            size3 = i20;
            i12 = i21;
            paddingBottom = i9;
            mode = i8;
        }
        int i24 = mode;
        int i25 = i12;
        int i26 = size3;
        boolean z8 = z5 && i17 == 2;
        boolean z9 = false;
        while (i19 > 0 && i14 > 0) {
            int i27 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i28 = 0;
            int i29 = 0;
            long j2 = 0;
            while (i29 < childCount2) {
                F3 f34 = (F3) getChildAt(i29).getLayoutParams();
                boolean z10 = z9;
                if (f34.d) {
                    int i30 = f34.b;
                    if (i30 < i27) {
                        j2 = 1 << i29;
                        i27 = i30;
                        i28 = 1;
                    } else if (i30 == i27) {
                        j2 |= 1 << i29;
                        i28++;
                    }
                }
                i29++;
                z9 = z10;
            }
            z = z9;
            j |= j2;
            if (i28 > i14) {
                break;
            }
            int i31 = i27 + 1;
            int i32 = 0;
            while (i32 < childCount2) {
                View childAt2 = getChildAt(i32);
                F3 f35 = (F3) childAt2.getLayoutParams();
                int i33 = iMax;
                int i34 = childMeasureSpec;
                int i35 = childCount2;
                long j3 = 1 << i32;
                if ((j2 & j3) != 0) {
                    if (z8 && f35.e) {
                        r4 = 1;
                        r4 = 1;
                        if (i14 == 1) {
                            childAt2.setPadding(i3 + i16, 0, i3, 0);
                        }
                    } else {
                        r4 = 1;
                    }
                    f35.b += r4;
                    f35.f = r4;
                    i14--;
                } else if (f35.b == i31) {
                    j |= j3;
                }
                i32++;
                childMeasureSpec = i34;
                iMax = i33;
                childCount2 = i35;
            }
            z9 = true;
        }
        z = z9;
        int i36 = iMax;
        int i37 = childMeasureSpec;
        int i38 = childCount2;
        boolean z11 = !z5 && i17 == 1;
        if (i14 <= 0 || j == 0 || (i14 >= i17 - 1 && !z11 && iMax2 <= 1)) {
            i4 = i38;
            z2 = z;
        } else {
            float fBitCount = Long.bitCount(j);
            if (!z11) {
                if ((j & 1) != 0 && !((F3) getChildAt(0).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
                int i39 = i38 - 1;
                if ((j & ((long) (1 << i39))) != 0 && !((F3) getChildAt(i39).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
            }
            int i40 = fBitCount > 0.0f ? (int) ((i14 * i16) / fBitCount) : 0;
            boolean z12 = z;
            i4 = i38;
            for (int i41 = 0; i41 < i4; i41++) {
                if ((j & ((long) (1 << i41))) != 0) {
                    View childAt3 = getChildAt(i41);
                    F3 f36 = (F3) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        f36.c = i40;
                        f36.f = true;
                        if (i41 == 0 && !f36.e) {
                            ((LinearLayout.LayoutParams) f36).leftMargin = (-i40) / 2;
                        }
                        z12 = true;
                    } else {
                        if (f36.a) {
                            f36.c = i40;
                            f36.f = true;
                            ((LinearLayout.LayoutParams) f36).rightMargin = (-i40) / 2;
                            z12 = true;
                        } else {
                            if (i41 != 0) {
                                ((LinearLayout.LayoutParams) f36).leftMargin = i40 / 2;
                            }
                            if (i41 != i4 - 1) {
                                ((LinearLayout.LayoutParams) f36).rightMargin = i40 / 2;
                            }
                        }
                    }
                }
            }
            z2 = z12;
        }
        if (z2) {
            int i42 = 0;
            while (i42 < i4) {
                View childAt4 = getChildAt(i42);
                F3 f37 = (F3) childAt4.getLayoutParams();
                if (f37.f) {
                    i7 = i37;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((f37.b * i16) + f37.c, 1073741824), i7);
                } else {
                    i7 = i37;
                }
                i42++;
                i37 = i7;
            }
        }
        if (i24 != 1073741824) {
            i6 = i25;
            i5 = i36;
        } else {
            i5 = i26;
            i6 = i25;
        }
        setMeasuredDimension(i6, i5);
    }

    public final boolean p(int i) {
        boolean zA = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof D3)) {
            zA = ((D3) childAt).a();
        }
        return (i <= 0 || !(childAt2 instanceof D3)) ? zA : zA | ((D3) childAt2).b();
    }

    @Override // defpackage.uF0, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new F3(getContext(), attributeSet);
    }
}
