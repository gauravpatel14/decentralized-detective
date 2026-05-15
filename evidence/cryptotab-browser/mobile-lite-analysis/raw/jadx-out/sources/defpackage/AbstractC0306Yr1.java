package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: Yr1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0306Yr1 {
    public C0217Rz a;
    public RecyclerView b;
    public final C0258Vn2 c;
    public final C0258Vn2 d;
    public AF0 e;
    public boolean f;
    public boolean g;
    public final boolean h;
    public final boolean i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;

    public AbstractC0306Yr1() {
        C0277Wr1 c0277Wr1 = new C0277Wr1(this, 0);
        C0277Wr1 c0277Wr12 = new C0277Wr1(this, 1);
        this.c = new C0258Vn2(c0277Wr1);
        this.d = new C0258Vn2(c0277Wr12);
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = true;
    }

    public static int A(View view) {
        return view.getLeft() - ((C0321Zr1) view.getLayoutParams()).b.left;
    }

    public static int B(View view) {
        return view.getRight() + ((C0321Zr1) view.getLayoutParams()).b.right;
    }

    public static int C(View view) {
        return view.getTop() - ((C0321Zr1) view.getLayoutParams()).b.top;
    }

    public static int I(View view) {
        return ((C0321Zr1) view.getLayoutParams()).a.f();
    }

    public static C0294Xr1 J(Context context, AttributeSet attributeSet, int i, int i2) {
        C0294Xr1 c0294Xr1 = new C0294Xr1();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.RecyclerView, i, i2);
        c0294Xr1.a = typedArrayObtainStyledAttributes.getInt(AbstractC0305Yp1.RecyclerView_android_orientation, 1);
        c0294Xr1.b = typedArrayObtainStyledAttributes.getInt(AbstractC0305Yp1.RecyclerView_spanCount, 1);
        c0294Xr1.c = typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.RecyclerView_reverseLayout, false);
        c0294Xr1.d = typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.RecyclerView_stackFromEnd, false);
        typedArrayObtainStyledAttributes.recycle();
        return c0294Xr1;
    }

    public static boolean O(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    public static void P(View view, int i, int i2, int i3, int i4) {
        C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
        Rect rect = c0321Zr1.b;
        view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) c0321Zr1).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) c0321Zr1).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) c0321Zr1).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) c0321Zr1).bottomMargin);
    }

    public static int g(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L1d
            if (r8 < 0) goto L12
        L10:
            r6 = r3
            goto L30
        L12:
            if (r8 != r1) goto L1a
            if (r6 == r2) goto L22
            if (r6 == 0) goto L1a
            if (r6 == r3) goto L22
        L1a:
            r6 = r7
            r8 = r6
            goto L30
        L1d:
            if (r8 < 0) goto L20
            goto L10
        L20:
            if (r8 != r1) goto L24
        L22:
            r8 = r5
            goto L30
        L24:
            if (r8 != r0) goto L1a
            if (r6 == r2) goto L2e
            if (r6 != r3) goto L2b
            goto L2e
        L2b:
            r8 = r5
            r6 = r7
            goto L30
        L2e:
            r8 = r5
            r6 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC0306Yr1.w(boolean, int, int, int, int):int");
    }

    public static int y(View view) {
        return view.getBottom() + ((C0321Zr1) view.getLayoutParams()).b.bottom;
    }

    public final boolean A0(View view, int i, int i2, C0321Zr1 c0321Zr1) {
        return (!view.isLayoutRequested() && this.h && O(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) c0321Zr1).width) && O(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) c0321Zr1).height)) ? false : true;
    }

    public boolean B0() {
        return false;
    }

    public final boolean C0(View view, int i, int i2, C0321Zr1 c0321Zr1) {
        return (this.h && O(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) c0321Zr1).width) && O(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) c0321Zr1).height)) ? false : true;
    }

    public final int D() {
        RecyclerView recyclerView = this.b;
        Pr1 pr1 = recyclerView != null ? recyclerView.F : null;
        if (pr1 != null) {
            return pr1.b();
        }
        return 0;
    }

    public abstract void D0(int i, RecyclerView recyclerView);

    public final int E() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final void E0(AF0 af0) {
        AF0 af02 = this.e;
        if (af02 != null && af0 != af02 && af02.e) {
            af02.i();
        }
        this.e = af0;
        RecyclerView recyclerView = this.b;
        os1 os1Var = recyclerView.y0;
        os1Var.z.removeCallbacks(os1Var);
        os1Var.v.abortAnimation();
        if (af0.h) {
            Log.w("RecyclerView", "An instance of " + af0.getClass().getSimpleName() + " was started more than once. Each instance of" + af0.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        af0.b = recyclerView;
        af0.c = this;
        int i = af0.a;
        if (i == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.B0.a = i;
        af0.e = true;
        af0.d = true;
        af0.f = recyclerView.G.q(i);
        af0.b.y0.b();
        af0.h = true;
    }

    public final int F() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public boolean F0() {
        return false;
    }

    public final int G() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int H() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int K(C0738gs1 c0738gs1, ms1 ms1Var) {
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || recyclerView.F == null || !e()) {
            return 1;
        }
        return this.b.F.b();
    }

    public final void L(Rect rect, View view) {
        Matrix matrix;
        Rect rect2 = ((C0321Zr1) view.getLayoutParams()).b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.b.E;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public boolean M() {
        return false;
    }

    public boolean N() {
        return false;
    }

    public void Q(int i) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            int iE = recyclerView.y.e();
            for (int i2 = 0; i2 < iE; i2++) {
                recyclerView.y.d(i2).offsetLeftAndRight(i);
            }
        }
    }

    public void R(int i) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            int iE = recyclerView.y.e();
            for (int i2 = 0; i2 < iE; i2++) {
                recyclerView.y.d(i2).offsetTopAndBottom(i);
            }
        }
    }

    public abstract void U(RecyclerView recyclerView);

    public abstract View V(View view, int i, C0738gs1 c0738gs1, ms1 ms1Var);

    public void W(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.b;
        C0738gs1 c0738gs1 = recyclerView.v;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z = true;
        if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
            z = false;
        }
        accessibilityEvent.setScrollable(z);
        Pr1 pr1 = this.b.F;
        if (pr1 != null) {
            accessibilityEvent.setItemCount(pr1.b());
        }
    }

    public void X(C0738gs1 c0738gs1, ms1 ms1Var, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
            accessibilityNodeInfoCompat.a(8192);
            accessibilityNodeInfoCompat.m(true);
            accessibilityNodeInfoCompat.i(67108864, true);
        }
        if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
            accessibilityNodeInfoCompat.a(4096);
            accessibilityNodeInfoCompat.m(true);
            accessibilityNodeInfoCompat.i(67108864, true);
        }
        accessibilityNodeInfoCompat.a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(K(c0738gs1, ms1Var), x(c0738gs1, ms1Var), false, 0));
    }

    public void Y(C0738gs1 c0738gs1, ms1 ms1Var, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        accessibilityNodeInfoCompat.l(m0.a(false, e() ? I(view) : 0, 1, d() ? I(view) : 0, 1));
    }

    public final void Z(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ps1 ps1VarN = RecyclerView.N(view);
        if (ps1VarN == null || ps1VarN.m() || this.a.c.contains(ps1VarN.t)) {
            return;
        }
        RecyclerView recyclerView = this.b;
        Y(recyclerView.v, recyclerView.B0, view, accessibilityNodeInfoCompat);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.view.View r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC0306Yr1.b(android.view.View, int, boolean):void");
    }

    public void c(String str) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.l(str);
        }
    }

    public abstract boolean d();

    public abstract boolean e();

    public boolean f(C0321Zr1 c0321Zr1) {
        return c0321Zr1 != null;
    }

    public abstract void f0(C0738gs1 c0738gs1, ms1 ms1Var);

    public abstract void g0(ms1 ms1Var);

    public Parcelable i0() {
        return null;
    }

    public abstract int j(ms1 ms1Var);

    public abstract int k(ms1 ms1Var);

    public boolean k0(int i, Bundle bundle) {
        RecyclerView recyclerView = this.b;
        return l0(recyclerView.v, recyclerView.B0, i, bundle);
    }

    public abstract int l(ms1 ms1Var);

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[PHI: r8
      0x0061: PHI (r8v8 int) = (r8v5 int), (r8v17 int) binds: [B:27:0x007d, B:19:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l0(defpackage.C0738gs1 r8, defpackage.ms1 r9, int r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC0306Yr1.l0(gs1, ms1, int, android.os.Bundle):boolean");
    }

    public abstract int m(ms1 ms1Var);

    public final void m0(C0738gs1 c0738gs1) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            if (!RecyclerView.N(u(iV)).t()) {
                View viewU = u(iV);
                p0(iV);
                c0738gs1.h(viewU);
            }
        }
    }

    public abstract int n(ms1 ms1Var);

    public final void n0(C0738gs1 c0738gs1) {
        ArrayList arrayList;
        int size = c0738gs1.a.size();
        int i = size - 1;
        while (true) {
            arrayList = c0738gs1.a;
            if (i < 0) {
                break;
            }
            View view = ((ps1) arrayList.get(i)).t;
            ps1 ps1VarN = RecyclerView.N(view);
            if (!ps1VarN.t()) {
                ps1VarN.s(false);
                if (ps1VarN.o()) {
                    this.b.removeDetachedView(view, false);
                }
                WJ1 wj1 = this.b.j0;
                if (wj1 != null) {
                    wj1.i(ps1VarN);
                }
                ps1VarN.s(true);
                ps1 ps1VarN2 = RecyclerView.N(view);
                ps1VarN2.G = null;
                ps1VarN2.H = false;
                ps1VarN2.C &= -33;
                c0738gs1.i(ps1VarN2);
            }
            i--;
        }
        arrayList.clear();
        ArrayList arrayList2 = c0738gs1.b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.b.invalidate();
        }
    }

    public abstract int o(ms1 ms1Var);

    public final void o0(View view) {
        C0217Rz c0217Rz = this.a;
        C0178Or1 c0178Or1 = c0217Rz.a;
        int i = c0217Rz.d;
        if (i == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            c0217Rz.d = 1;
            c0217Rz.e = view;
            int iIndexOfChild = c0178Or1.a.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (c0217Rz.b.f(iIndexOfChild)) {
                    c0217Rz.j(view);
                }
                c0178Or1.k(iIndexOfChild);
            }
            c0217Rz.d = 0;
            c0217Rz.e = null;
        } catch (Throwable th) {
            c0217Rz.d = 0;
            c0217Rz.e = null;
            throw th;
        }
    }

    public final void p(C0738gs1 c0738gs1) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            ps1 ps1VarN = RecyclerView.N(viewU);
            if (!ps1VarN.t()) {
                if (!ps1VarN.k() || ps1VarN.m() || this.b.F.u) {
                    u(iV);
                    this.a.c(iV);
                    c0738gs1.j(viewU);
                    this.b.z.c(ps1VarN);
                } else {
                    p0(iV);
                    c0738gs1.i(ps1VarN);
                }
            }
        }
    }

    public final void p0(int i) {
        if (u(i) != null) {
            C0217Rz c0217Rz = this.a;
            C0178Or1 c0178Or1 = c0217Rz.a;
            int i2 = c0217Rz.d;
            if (i2 == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            try {
                int iF = c0217Rz.f(i);
                View childAt = c0178Or1.a.getChildAt(iF);
                if (childAt != null) {
                    c0217Rz.d = 1;
                    c0217Rz.e = childAt;
                    if (c0217Rz.b.f(iF)) {
                        c0217Rz.j(childAt);
                    }
                    c0178Or1.k(iF);
                }
            } finally {
                c0217Rz.d = 0;
                c0217Rz.e = null;
            }
        }
    }

    public View q(int i) {
        int iV = v();
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = u(i2);
            ps1 ps1VarN = RecyclerView.N(viewU);
            if (ps1VarN != null && ps1VarN.f() == i && !ps1VarN.t() && (this.b.B0.g || !ps1VarN.m())) {
                return viewU;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean q0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.F()
            int r1 = r8.H()
            int r2 = r8.n
            int r3 = r8.G()
            int r2 = r2 - r3
            int r3 = r8.o
            int r4 = r8.E()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            androidx.recyclerview.widget.RecyclerView r3 = r8.b
            int r3 = r3.getLayoutDirection()
            r7 = 1
            if (r3 != r7) goto L5e
            if (r2 == 0) goto L59
            goto L66
        L59:
            int r2 = java.lang.Math.max(r6, r10)
            goto L66
        L5e:
            if (r6 == 0) goto L61
            goto L65
        L61:
            int r6 = java.lang.Math.min(r4, r2)
        L65:
            r2 = r6
        L66:
            if (r1 == 0) goto L69
            goto L6d
        L69:
            int r1 = java.lang.Math.min(r5, r11)
        L6d:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lb0
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7e
            goto Lb5
        L7e:
            int r1 = r8.F()
            int r2 = r8.H()
            int r3 = r8.n
            int r4 = r8.G()
            int r3 = r3 - r4
            int r4 = r8.o
            int r5 = r8.E()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.b
            android.graphics.Rect r5 = r5.C
            r8.z(r5, r13)
            int r13 = r5.left
            int r13 = r13 - r11
            if (r13 >= r3) goto Lb5
            int r13 = r5.right
            int r13 = r13 - r11
            if (r13 <= r1) goto Lb5
            int r13 = r5.top
            int r13 = r13 - r10
            if (r13 >= r4) goto Lb5
            int r13 = r5.bottom
            int r13 = r13 - r10
            if (r13 > r2) goto Lb0
            goto Lb5
        Lb0:
            if (r11 != 0) goto Lb6
            if (r10 == 0) goto Lb5
            goto Lb6
        Lb5:
            return r0
        Lb6:
            if (r12 == 0) goto Lbc
            r9.scrollBy(r11, r10)
            goto Lbf
        Lbc:
            r9.y0(r11, r0, r10)
        Lbf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC0306Yr1.q0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public abstract C0321Zr1 r();

    public final void r0() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public C0321Zr1 s(Context context, AttributeSet attributeSet) {
        return new C0321Zr1(context, attributeSet);
    }

    public abstract int s0(int i, C0738gs1 c0738gs1, ms1 ms1Var);

    public C0321Zr1 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0321Zr1 ? new C0321Zr1((C0321Zr1) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0321Zr1((ViewGroup.MarginLayoutParams) layoutParams) : new C0321Zr1(layoutParams);
    }

    public abstract void t0(int i);

    public final View u(int i) {
        C0217Rz c0217Rz = this.a;
        if (c0217Rz != null) {
            return c0217Rz.d(i);
        }
        return null;
    }

    public abstract int u0(int i, C0738gs1 c0738gs1, ms1 ms1Var);

    public final int v() {
        C0217Rz c0217Rz = this.a;
        if (c0217Rz != null) {
            return c0217Rz.e();
        }
        return 0;
    }

    public final void v0(RecyclerView recyclerView) {
        w0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final void w0(int i, int i2) {
        this.n = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        this.l = mode;
        if (mode == 0 && !RecyclerView.Y0) {
            this.n = 0;
        }
        this.o = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.m = mode2;
        if (mode2 != 0 || RecyclerView.Y0) {
            return;
        }
        this.o = 0;
    }

    public int x(C0738gs1 c0738gs1, ms1 ms1Var) {
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || recyclerView.F == null || !d()) {
            return 1;
        }
        return this.b.F.b();
    }

    public void x0(Rect rect, int i, int i2) {
        int iG = G() + F() + rect.width();
        int iE = E() + H() + rect.height();
        RecyclerView recyclerView = this.b;
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        this.b.setMeasuredDimension(g(i, iG, recyclerView.getMinimumWidth()), g(i2, iE, this.b.getMinimumHeight()));
    }

    public final void y0(int i, int i2) {
        int iV = v();
        if (iV == 0) {
            this.b.r(i, i2);
            return;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < iV; i7++) {
            View viewU = u(i7);
            Rect rect = this.b.C;
            z(rect, viewU);
            int i8 = rect.left;
            if (i8 < i6) {
                i6 = i8;
            }
            int i9 = rect.right;
            if (i9 > i3) {
                i3 = i9;
            }
            int i10 = rect.top;
            if (i10 < i4) {
                i4 = i10;
            }
            int i11 = rect.bottom;
            if (i11 > i5) {
                i5 = i11;
            }
        }
        this.b.C.set(i6, i4, i3, i5);
        x0(this.b.C, i, i2);
    }

    public void z(Rect rect, View view) {
        RecyclerView.O(rect, view);
    }

    public final void z0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.b = null;
            this.a = null;
            this.n = 0;
            this.o = 0;
        } else {
            this.b = recyclerView;
            this.a = recyclerView.y;
            this.n = recyclerView.getWidth();
            this.o = recyclerView.getHeight();
        }
        this.l = 1073741824;
        this.m = 1073741824;
    }

    public void S() {
    }

    public void b0() {
    }

    public void T(RecyclerView recyclerView) {
    }

    public void h0(Parcelable parcelable) {
    }

    public void j0(int i) {
    }

    public void a0(int i, int i2) {
    }

    public void c0(int i, int i2) {
    }

    public void d0(int i, int i2) {
    }

    public void e0(int i, int i2) {
    }

    public void i(int i, ol0 ol0Var) {
    }

    public void h(int i, int i2, ms1 ms1Var, ol0 ol0Var) {
    }
}
