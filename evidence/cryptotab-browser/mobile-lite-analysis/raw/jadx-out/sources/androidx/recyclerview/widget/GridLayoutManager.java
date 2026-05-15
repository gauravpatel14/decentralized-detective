package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import defpackage.AbstractC0256Vm0;
import defpackage.AbstractC0306Yr1;
import defpackage.AbstractC0604eo2;
import defpackage.AbstractC1214oR1;
import defpackage.C0235Tm0;
import defpackage.C0247Um0;
import defpackage.C0321Zr1;
import defpackage.C0738gs1;
import defpackage.C0814i0;
import defpackage.Pr1;
import defpackage.m0;
import defpackage.ms1;
import defpackage.ol0;
import defpackage.vF0;
import defpackage.xF0;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static final Set P = Collections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, 130)));
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final SparseIntArray f18J;
    public AbstractC0256Vm0 K;
    public final Rect L;
    public int M;
    public int N;
    public int O;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.f18J = new SparseIntArray();
        this.K = new C0235Tm0();
        this.L = new Rect();
        this.M = -1;
        this.N = -1;
        this.O = -1;
        x1(AbstractC0306Yr1.J(context, attributeSet, i, i2).b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public boolean F0() {
        return this.z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void H0(ms1 ms1Var, xF0 xf0, ol0 ol0Var) {
        int i;
        int iC = this.F;
        for (int i2 = 0; i2 < this.F && (i = xf0.d) >= 0 && i < ms1Var.b() && iC > 0; i2++) {
            int i3 = xf0.d;
            ol0Var.a(i3, Math.max(0, xf0.g));
            iC -= this.K.c(i3);
            xf0.d += xf0.e;
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int K(C0738gs1 c0738gs1, ms1 ms1Var) {
        if (this.p == 0) {
            return Math.min(this.F, D());
        }
        if (ms1Var.b() < 1) {
            return 0;
        }
        return t1(ms1Var.b() - 1, c0738gs1, ms1Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View U0(C0738gs1 c0738gs1, ms1 ms1Var, boolean z, boolean z2) {
        int i;
        int iV;
        int iV2 = v();
        int i2 = 1;
        if (z2) {
            iV = v() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iV2;
            iV = 0;
        }
        int iB = ms1Var.b();
        M0();
        int iJ = this.r.j();
        int iG = this.r.g();
        View view = null;
        View view2 = null;
        while (iV != i) {
            View viewU = u(iV);
            int I = AbstractC0306Yr1.I(viewU);
            if (I >= 0 && I < iB && u1(I, c0738gs1, ms1Var) == 0) {
                if (((C0321Zr1) viewU.getLayoutParams()).a.m()) {
                    if (view2 == null) {
                        view2 = viewU;
                    }
                } else {
                    if (this.r.e(viewU) < iG && this.r.b(viewU) >= iJ) {
                        return viewU;
                    }
                    if (view == null) {
                        view = viewU;
                    }
                }
            }
            iV += i2;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00df, code lost:
    
        if (r13 == (r2 > r15)) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011e  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View V(android.view.View r23, int r24, defpackage.C0738gs1 r25, defpackage.ms1 r26) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.V(android.view.View, int, gs1, ms1):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public final void X(C0738gs1 c0738gs1, ms1 ms1Var, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.X(c0738gs1, ms1Var, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.k(GridView.class.getName());
        Pr1 pr1 = this.b.F;
        if (pr1 == null || pr1.b() <= 1) {
            return;
        }
        accessibilityNodeInfoCompat.b(C0814i0.K);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void Y(C0738gs1 c0738gs1, ms1 ms1Var, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C0247Um0)) {
            Z(view, accessibilityNodeInfoCompat);
            return;
        }
        C0247Um0 c0247Um0 = (C0247Um0) layoutParams;
        int iT1 = t1(c0247Um0.a.f(), c0738gs1, ms1Var);
        if (this.p == 0) {
            accessibilityNodeInfoCompat.l(m0.a(false, c0247Um0.e, c0247Um0.f, iT1, 1));
        } else {
            accessibilityNodeInfoCompat.l(m0.a(false, iT1, 1, c0247Um0.e, c0247Um0.f));
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void a0(int i, int i2) {
        this.K.d();
        this.K.b.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v37 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a1(defpackage.C0738gs1 r19, defpackage.ms1 r20, defpackage.xF0 r21, defpackage.wF0 r22) {
        /*
            Method dump skipped, instruction units count: 654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a1(gs1, ms1, xF0, wF0):void");
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void b0() {
        this.K.d();
        this.K.b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void b1(C0738gs1 c0738gs1, ms1 ms1Var, vF0 vf0, int i) {
        y1();
        if (ms1Var.b() > 0 && !ms1Var.g) {
            boolean z = i == 1;
            int iU1 = u1(vf0.b, c0738gs1, ms1Var);
            if (z) {
                while (iU1 > 0) {
                    int i2 = vf0.b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    vf0.b = i3;
                    iU1 = u1(i3, c0738gs1, ms1Var);
                }
            } else {
                int iB = ms1Var.b() - 1;
                int i4 = vf0.b;
                while (i4 < iB) {
                    int i5 = i4 + 1;
                    int iU12 = u1(i5, c0738gs1, ms1Var);
                    if (iU12 <= iU1) {
                        break;
                    }
                    i4 = i5;
                    iU1 = iU12;
                }
                vf0.b = i4;
            }
        }
        n1();
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void c0(int i, int i2) {
        this.K.d();
        this.K.b.clear();
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void d0(int i, int i2) {
        this.K.d();
        this.K.b.clear();
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void e0(int i, int i2) {
        this.K.d();
        this.K.b.clear();
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean f(C0321Zr1 c0321Zr1) {
        return c0321Zr1 instanceof C0247Um0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public void f0(C0738gs1 c0738gs1, ms1 ms1Var) {
        boolean z = ms1Var.g;
        SparseIntArray sparseIntArray = this.f18J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                C0247Um0 c0247Um0 = (C0247Um0) u(i).getLayoutParams();
                int iF = c0247Um0.a.f();
                sparseIntArray2.put(iF, c0247Um0.f);
                sparseIntArray.put(iF, c0247Um0.e);
            }
        }
        super.f0(c0738gs1, ms1Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public void g0(ms1 ms1Var) {
        View viewQ;
        super.g0(ms1Var);
        this.E = false;
        int i = this.M;
        if (i == -1 || (viewQ = q(i)) == null) {
            return;
        }
        viewQ.sendAccessibilityEvent(67108864);
        this.M = -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void i1(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.i1(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public final int k(ms1 ms1Var) {
        return J0(ms1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a4 A[EDGE_INSN: B:207:0x01a4->B:122:0x01a4 BREAK  A[LOOP:2: B:126:0x01b4->B:135:0x01dd, LOOP_LABEL: LOOP:2: B:126:0x01b4->B:135:0x01dd], EDGE_INSN: B:214:0x01a4->B:122:0x01a4 BREAK  A[LOOP:5: B:148:0x021c->B:159:0x024c, LOOP_LABEL: LOOP:5: B:148:0x021c->B:159:0x024c]] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0279  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k0(int r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instruction units count: 725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.k0(int, android.os.Bundle):boolean");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public final int l(ms1 ms1Var) {
        return K0(ms1Var);
    }

    public final void m1(int i) {
        int i2;
        int[] iArr = this.G;
        int i3 = this.F;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.G = iArr;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public final int n(ms1 ms1Var) {
        return J0(ms1Var);
    }

    public final void n1() {
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public final int o(ms1 ms1Var) {
        return K0(ms1Var);
    }

    public final int o1(int i) {
        if (this.p == 0) {
            RecyclerView recyclerView = this.b;
            return t1(i, recyclerView.v, recyclerView.B0);
        }
        RecyclerView recyclerView2 = this.b;
        return u1(i, recyclerView2.v, recyclerView2.B0);
    }

    public final int p1(int i) {
        if (this.p == 1) {
            RecyclerView recyclerView = this.b;
            return t1(i, recyclerView.v, recyclerView.B0);
        }
        RecyclerView recyclerView2 = this.b;
        return u1(i, recyclerView2.v, recyclerView2.B0);
    }

    public final HashSet q1(int i) {
        return r1(p1(i), i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public final C0321Zr1 r() {
        return this.p == 0 ? new C0247Um0(-2, -1) : new C0247Um0(-1, -2);
    }

    public final HashSet r1(int i, int i2) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.b;
        int iV1 = v1(i2, recyclerView.v, recyclerView.B0);
        for (int i3 = i; i3 < i + iV1; i3++) {
            hashSet.add(Integer.valueOf(i3));
        }
        return hashSet;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final C0321Zr1 s(Context context, AttributeSet attributeSet) {
        C0247Um0 c0247Um0 = new C0247Um0(context, attributeSet);
        c0247Um0.e = -1;
        c0247Um0.f = 0;
        return c0247Um0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public final int s0(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        y1();
        n1();
        return super.s0(i, c0738gs1, ms1Var);
    }

    public final int s1(int i, int i2) {
        if (this.p != 1 || !Z0()) {
            int[] iArr = this.G;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.G;
        int i3 = this.F;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    @Override // defpackage.AbstractC0306Yr1
    public final C0321Zr1 t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            C0247Um0 c0247Um0 = new C0247Um0((ViewGroup.MarginLayoutParams) layoutParams);
            c0247Um0.e = -1;
            c0247Um0.f = 0;
            return c0247Um0;
        }
        C0247Um0 c0247Um02 = new C0247Um0(layoutParams);
        c0247Um02.e = -1;
        c0247Um02.f = 0;
        return c0247Um02;
    }

    public final int t1(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        if (!ms1Var.g) {
            return this.K.a(i, this.F);
        }
        int iB = c0738gs1.b(i);
        if (iB != -1) {
            return this.K.a(iB, this.F);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.AbstractC0306Yr1
    public final int u0(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        y1();
        n1();
        return super.u0(i, c0738gs1, ms1Var);
    }

    public final int u1(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        if (!ms1Var.g) {
            return this.K.b(i, this.F);
        }
        int i2 = this.f18J.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = c0738gs1.b(i);
        if (iB != -1) {
            return this.K.b(iB, this.F);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public final int v1(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        if (!ms1Var.g) {
            return this.K.c(i);
        }
        int i2 = this.I.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = c0738gs1.b(i);
        if (iB != -1) {
            return this.K.c(iB);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    public final void w1(View view, int i, boolean z) {
        int iW;
        int iW2;
        C0247Um0 c0247Um0 = (C0247Um0) view.getLayoutParams();
        Rect rect = c0247Um0.b;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) c0247Um0).topMargin + ((ViewGroup.MarginLayoutParams) c0247Um0).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) c0247Um0).leftMargin + ((ViewGroup.MarginLayoutParams) c0247Um0).rightMargin;
        int iS1 = s1(c0247Um0.e, c0247Um0.f);
        if (this.p == 1) {
            iW2 = AbstractC0306Yr1.w(false, iS1, i, i3, ((ViewGroup.MarginLayoutParams) c0247Um0).width);
            iW = AbstractC0306Yr1.w(true, this.r.k(), this.m, i2, ((ViewGroup.MarginLayoutParams) c0247Um0).height);
        } else {
            int iW3 = AbstractC0306Yr1.w(false, iS1, i, i2, ((ViewGroup.MarginLayoutParams) c0247Um0).height);
            int iW4 = AbstractC0306Yr1.w(true, this.r.k(), this.l, i3, ((ViewGroup.MarginLayoutParams) c0247Um0).width);
            iW = iW3;
            iW2 = iW4;
        }
        C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
        if (z ? C0(view, iW2, iW, c0321Zr1) : A0(view, iW2, iW, c0321Zr1)) {
            view.measure(iW2, iW);
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int x(C0738gs1 c0738gs1, ms1 ms1Var) {
        if (this.p == 1) {
            return Math.min(this.F, D());
        }
        if (ms1Var.b() < 1) {
            return 0;
        }
        return t1(ms1Var.b() - 1, c0738gs1, ms1Var) + 1;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void x0(Rect rect, int i, int i2) {
        int iG;
        int iG2;
        if (this.G == null) {
            super.x0(rect, i, i2);
        }
        int iG3 = G() + F();
        int iE = E() + H();
        if (this.p == 1) {
            int iHeight = rect.height() + iE;
            RecyclerView recyclerView = this.b;
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            iG2 = AbstractC0306Yr1.g(i2, iHeight, recyclerView.getMinimumHeight());
            int[] iArr = this.G;
            iG = AbstractC0306Yr1.g(i, iArr[iArr.length - 1] + iG3, this.b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iG3;
            RecyclerView recyclerView2 = this.b;
            WeakHashMap weakHashMap2 = AbstractC0604eo2.a;
            iG = AbstractC0306Yr1.g(i, iWidth, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.G;
            iG2 = AbstractC0306Yr1.g(i2, iArr2[iArr2.length - 1] + iE, this.b.getMinimumHeight());
        }
        this.b.setMeasuredDimension(iG, iG2);
    }

    public final void x1(int i) {
        if (i == this.F) {
            return;
        }
        this.E = true;
        if (i < 1) {
            throw new IllegalArgumentException(AbstractC1214oR1.a(i, "Span count should be at least 1. Provided "));
        }
        this.F = i;
        this.K.d();
        r0();
    }

    public final void y1() {
        int iE;
        int iH;
        if (this.p == 1) {
            iE = this.n - G();
            iH = F();
        } else {
            iE = this.o - E();
            iH = H();
        }
        m1(iE - iH);
    }

    public GridLayoutManager() {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.f18J = new SparseIntArray();
        this.K = new C0235Tm0();
        this.L = new Rect();
        this.M = -1;
        this.N = -1;
        this.O = -1;
        x1(1);
    }

    public GridLayoutManager(int i) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.f18J = new SparseIntArray();
        this.K = new C0235Tm0();
        this.L = new Rect();
        this.M = -1;
        this.N = -1;
        this.O = -1;
        x1(i);
    }
}
