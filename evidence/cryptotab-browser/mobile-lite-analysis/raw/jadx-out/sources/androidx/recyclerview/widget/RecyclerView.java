package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.common.api.Api;
import defpackage.A81;
import defpackage.AF0;
import defpackage.AY;
import defpackage.AbstractC0262Vr1;
import defpackage.AbstractC0305Yp1;
import defpackage.AbstractC0306Yr1;
import defpackage.AbstractC0604eo2;
import defpackage.C0178Or1;
import defpackage.C0217Rz;
import defpackage.C0251Ur1;
import defpackage.C0321Zr1;
import defpackage.C0606es1;
import defpackage.C0738gs1;
import defpackage.C1163nb0;
import defpackage.C1638vo2;
import defpackage.C1695wo2;
import defpackage.C1861zi1;
import defpackage.EJ0;
import defpackage.Ep1;
import defpackage.Hp1;
import defpackage.InterfaceC0382as1;
import defpackage.Mr1;
import defpackage.Nr1;
import defpackage.OG;
import defpackage.OX0;
import defpackage.PX0;
import defpackage.Pr1;
import defpackage.RunnableC1349ql0;
import defpackage.S4;
import defpackage.T4;
import defpackage.UJ1;
import defpackage.WJ1;
import defpackage.ZV;
import defpackage.aM1;
import defpackage.bs1;
import defpackage.cs1;
import defpackage.hs1;
import defpackage.is1;
import defpackage.js1;
import defpackage.ms1;
import defpackage.ns1;
import defpackage.ol0;
import defpackage.os1;
import defpackage.ps1;
import defpackage.rs1;
import defpackage.u50;
import defpackage.xi1;
import defpackage.yi1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements OX0 {
    public static final int[] W0 = {R.attr.nestedScrollingEnabled};
    public static final float X0 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean Y0 = true;
    public static final boolean Z0 = true;
    public static final Class[] a1;
    public static final Nr1 b1;
    public static final ns1 c1;
    public boolean A;
    public final ol0 A0;
    public final Mr1 B;
    public final ms1 B0;
    public final Rect C;
    public cs1 C0;
    public final Rect D;
    public ArrayList D0;
    public final RectF E;
    public boolean E0;
    public Pr1 F;
    public boolean F0;
    public AbstractC0306Yr1 G;
    public final C0178Or1 G0;
    public hs1 H;
    public boolean H0;
    public final ArrayList I;
    public rs1 I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ArrayList f19J;
    public final int[] J0;
    public final ArrayList K;
    public PX0 K0;
    public bs1 L;
    public final int[] L0;
    public boolean M;
    public final int[] M0;
    public boolean N;
    public final int[] N0;
    public boolean O;
    public final ArrayList O0;
    public int P;
    public final Mr1 P0;
    public boolean Q;
    public boolean Q0;
    public boolean R;
    public int R0;
    public boolean S;
    public int S0;
    public int T;
    public final boolean T0;
    public boolean U;
    public final C0178Or1 U0;
    public final AccessibilityManager V;
    public final AY V0;
    public ArrayList W;
    public boolean a0;
    public boolean b0;
    public int c0;
    public int d0;
    public final ns1 e0;
    public EdgeEffect f0;
    public EdgeEffect g0;
    public EdgeEffect h0;
    public EdgeEffect i0;
    public WJ1 j0;
    public int k0;
    public int l0;
    public VelocityTracker m0;
    public int n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0;
    public A81 s0;
    public final float t;
    public final int t0;
    public final is1 u;
    public final int u0;
    public final C0738gs1 v;
    public final float v0;
    public SavedState w;
    public final float w0;
    public final T4 x;
    public final boolean x0;
    public final C0217Rz y;
    public final os1 y0;
    public final C1695wo2 z;
    public RunnableC1349ql0 z0;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR = new js1();
        public Parcelable v;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.v = parcel.readParcelable(classLoader == null ? AbstractC0306Yr1.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.v, 0);
        }
    }

    static {
        Class cls = Integer.TYPE;
        a1 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        b1 = new Nr1();
        c1 = new ns1();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Ep1.recyclerViewStyle);
    }

    public static RecyclerView G(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewG = G(viewGroup.getChildAt(i));
            if (recyclerViewG != null) {
                return recyclerViewG;
            }
        }
        return null;
    }

    public static int L(View view) {
        ps1 ps1VarN = N(view);
        if (ps1VarN != null) {
            return ps1VarN.d();
        }
        return -1;
    }

    public static ps1 N(View view) {
        if (view == null) {
            return null;
        }
        return ((C0321Zr1) view.getLayoutParams()).a;
    }

    public static void O(Rect rect, View view) {
        C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
        Rect rect2 = c0321Zr1.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) c0321Zr1).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) c0321Zr1).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) c0321Zr1).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) c0321Zr1).bottomMargin);
    }

    public static long Q() {
        if (Z0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public static void m(ps1 ps1Var) {
        WeakReference weakReference = ps1Var.u;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == ps1Var.t) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            ps1Var.u = null;
        }
    }

    public static int p(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i2) {
        if (i > 0 && edgeEffect != null && u50.a(edgeEffect) != 0.0f) {
            int iRound = Math.round(u50.b(edgeEffect, ((-i) * 4.0f) / i2, 0.5f) * ((-i2) / 4.0f));
            if (iRound != i) {
                edgeEffect.finish();
            }
            return i - iRound;
        }
        if (i >= 0 || edgeEffect2 == null || u50.a(edgeEffect2) == 0.0f) {
            return i;
        }
        float f = i2;
        int iRound2 = Math.round(u50.b(edgeEffect2, (i * 4.0f) / f, 0.5f) * (f / 4.0f));
        if (iRound2 != i) {
            edgeEffect2.finish();
        }
        return i - iRound2;
    }

    public final void A() {
        if (this.g0 != null) {
            return;
        }
        this.e0.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.g0 = edgeEffect;
        if (this.A) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void A0() {
        int i = this.P + 1;
        this.P = i;
        if (i != 1 || this.R) {
            return;
        }
        this.Q = false;
    }

    public final String B() {
        return " " + super.toString() + ", adapter:" + this.F + ", layout:" + this.G + ", context:" + getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B0(int i) {
        boolean zD = this.G.d();
        int i2 = zD;
        if (this.G.e()) {
            i2 = (zD ? 1 : 0) | 2;
        }
        R().g(i2, i);
    }

    public final void C(ms1 ms1Var) {
        if (this.k0 != 2) {
            ms1Var.getClass();
            return;
        }
        OverScroller overScroller = this.y0.v;
        overScroller.getFinalX();
        overScroller.getCurrX();
        ms1Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final void C0(boolean z) {
        if (this.P < 1) {
            this.P = 1;
        }
        if (!z && !this.R) {
            this.Q = false;
        }
        if (this.P == 1) {
            if (z && this.Q && !this.R && this.G != null && this.F != null) {
                t();
            }
            if (!this.R) {
                this.Q = false;
            }
        }
        this.P--;
    }

    public final View D(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final void D0() {
        AF0 af0;
        w0(0);
        os1 os1Var = this.y0;
        os1Var.z.removeCallbacks(os1Var);
        os1Var.v.abortAnimation();
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 == null || (af0 = abstractC0306Yr1.e) == null) {
            return;
        }
        af0.i();
    }

    public final boolean E(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bs1 bs1Var = (bs1) arrayList.get(i);
            if (bs1Var.b(motionEvent) && action != 3) {
                this.L = bs1Var;
                return true;
            }
        }
        return false;
    }

    public final void F(int[] iArr) {
        int iE = this.y.e();
        if (iE == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iE; i3++) {
            ps1 ps1VarN = N(this.y.d(i3));
            if (!ps1VarN.t()) {
                int iF = ps1VarN.f();
                if (iF < i) {
                    i = iF;
                }
                if (iF > i2) {
                    i2 = iF;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public final ps1 H(int i) {
        ps1 ps1Var = null;
        if (this.a0) {
            return null;
        }
        int iH = this.y.h();
        for (int i2 = 0; i2 < iH; i2++) {
            ps1 ps1VarN = N(this.y.g(i2));
            if (ps1VarN != null && !ps1VarN.m() && J(ps1VarN) == i) {
                if (!this.y.c.contains(ps1VarN.t)) {
                    return ps1VarN;
                }
                ps1Var = ps1VarN;
            }
        }
        return ps1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f5  */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean I(int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.I(int, int, int, int):boolean");
    }

    public final int J(ps1 ps1Var) {
        if (ps1Var.h(524) || !ps1Var.j()) {
            return -1;
        }
        T4 t4 = this.x;
        int i = ps1Var.v;
        ArrayList arrayList = t4.b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            S4 s4 = (S4) arrayList.get(i2);
            int i3 = s4.a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = s4.b;
                    if (i4 <= i) {
                        int i5 = s4.d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = s4.b;
                    if (i6 == i) {
                        i = s4.d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (s4.d <= i) {
                            i++;
                        }
                    }
                }
            } else if (s4.b <= i) {
                i += s4.d;
            }
        }
        return i;
    }

    public final long K(ps1 ps1Var) {
        return this.F.u ? ps1Var.x : ps1Var.v;
    }

    public final ps1 M(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return N(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect P(View view) {
        C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
        boolean z = c0321Zr1.c;
        Rect rect = c0321Zr1.b;
        if (!z) {
            return rect;
        }
        ms1 ms1Var = this.B0;
        if (ms1Var.g && (c0321Zr1.a.p() || c0321Zr1.a.k())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.f19J;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Rect rect2 = this.C;
            rect2.set(0, 0, 0, 0);
            ((AbstractC0262Vr1) arrayList.get(i)).g(rect2, view, this, ms1Var);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        c0321Zr1.c = false;
        return rect;
    }

    public final PX0 R() {
        if (this.K0 == null) {
            this.K0 = new PX0(this);
        }
        return this.K0;
    }

    public final boolean S() {
        return !this.O || this.a0 || this.x.g();
    }

    public final void T() {
        if (this.f19J.size() == 0) {
            return;
        }
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null) {
            abstractC0306Yr1.c("Cannot invalidate item decorations during a scroll or layout");
        }
        W();
        requestLayout();
    }

    public final boolean U() {
        return this.c0 > 0;
    }

    public final void V(int i) {
        if (this.G == null) {
            return;
        }
        w0(2);
        this.G.t0(i);
        awakenScrollBars();
    }

    public final void W() {
        int iH = this.y.h();
        for (int i = 0; i < iH; i++) {
            ((C0321Zr1) this.y.g(i).getLayoutParams()).c = true;
        }
        ArrayList arrayList = this.v.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0321Zr1 c0321Zr1 = (C0321Zr1) ((ps1) arrayList.get(i2)).t.getLayoutParams();
            if (c0321Zr1 != null) {
                c0321Zr1.c = true;
            }
        }
    }

    public final void X(int i, boolean z, int i2) {
        int i3 = i + i2;
        int iH = this.y.h();
        for (int i4 = 0; i4 < iH; i4++) {
            ps1 ps1VarN = N(this.y.g(i4));
            if (ps1VarN != null && !ps1VarN.t()) {
                int i5 = ps1VarN.v;
                ms1 ms1Var = this.B0;
                if (i5 >= i3) {
                    ps1VarN.q(-i2, z);
                    ms1Var.f = true;
                } else if (i5 >= i) {
                    ps1VarN.c(8);
                    ps1VarN.q(-i2, z);
                    ps1VarN.v = i - 1;
                    ms1Var.f = true;
                }
            }
        }
        C0738gs1 c0738gs1 = this.v;
        ArrayList arrayList = c0738gs1.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ps1 ps1Var = (ps1) arrayList.get(size);
            if (ps1Var != null) {
                int i6 = ps1Var.v;
                if (i6 >= i3) {
                    ps1Var.q(-i2, z);
                } else if (i6 >= i) {
                    ps1Var.c(8);
                    c0738gs1.g(size);
                }
            }
        }
        requestLayout();
    }

    public final void a0() {
        this.c0++;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null) {
            abstractC0306Yr1.getClass();
        }
        super.addFocusables(arrayList, i, i2);
    }

    public final void b0(boolean z) {
        int i;
        AccessibilityManager accessibilityManager;
        int i2 = this.c0 - 1;
        this.c0 = i2;
        if (i2 < 1) {
            this.c0 = 0;
            if (z) {
                int i3 = this.T;
                this.T = 0;
                if (i3 != 0 && (accessibilityManager = this.V) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i3);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.O0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ps1 ps1Var = (ps1) arrayList.get(size);
                    if (ps1Var.t.getParent() == this && !ps1Var.t() && (i = ps1Var.f34J) != -1) {
                        ps1Var.t.setImportantForAccessibility(i);
                        ps1Var.f34J = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void c0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.l0) {
            int i = actionIndex == 0 ? 1 : 0;
            this.l0 = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.p0 = x;
            this.n0 = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.q0 = y;
            this.o0 = y;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0321Zr1) && this.G.f((C0321Zr1) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null && abstractC0306Yr1.d()) {
            return this.G.j(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null && abstractC0306Yr1.d()) {
            return this.G.k(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null && abstractC0306Yr1.d()) {
            return this.G.l(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null && abstractC0306Yr1.e()) {
            return this.G.m(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null && abstractC0306Yr1.e()) {
            return this.G.n(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null && abstractC0306Yr1.e()) {
            return this.G.o(this.B0);
        }
        return 0;
    }

    public final void d0() {
        if (this.H0 || !this.M) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        postOnAnimation(this.P0);
        this.H0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        int iB = 0;
        if (abstractC0306Yr1 == null) {
            return false;
        }
        if (abstractC0306Yr1.e()) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 92 || keyCode == 93) {
                int measuredHeight = getMeasuredHeight();
                if (keyCode == 93) {
                    y0(0, false, measuredHeight);
                } else {
                    y0(0, false, -measuredHeight);
                }
                return true;
            }
            if (keyCode == 122 || keyCode == 123) {
                boolean zN = abstractC0306Yr1.N();
                if (keyCode == 122) {
                    if (zN) {
                        iB = this.F.b();
                    }
                } else if (!zN) {
                    iB = this.F.b();
                }
                z0(iB);
                return true;
            }
        } else if (abstractC0306Yr1.d()) {
            int keyCode2 = keyEvent.getKeyCode();
            if (keyCode2 == 92 || keyCode2 == 93) {
                int measuredWidth = getMeasuredWidth();
                if (keyCode2 == 93) {
                    y0(measuredWidth, false, 0);
                } else {
                    y0(-measuredWidth, false, 0);
                }
                return true;
            }
            if (keyCode2 == 122 || keyCode2 == 123) {
                boolean zN2 = abstractC0306Yr1.N();
                if (keyCode2 == 122) {
                    if (zN2) {
                        iB = this.F.b();
                    }
                } else if (!zN2) {
                    iB = this.F.b();
                }
                z0(iB);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return R().a(f, f2, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return R().b(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return R().c(i, i2, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return R().d(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        ArrayList arrayList = this.f19J;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            ((AbstractC0262Vr1) arrayList.get(i)).i(canvas, this);
        }
        EdgeEffect edgeEffect = this.f0;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.A ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f0;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.g0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.A) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.g0;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.h0;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.A ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.h0;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.i0;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.A) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.i0;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.j0 == null || arrayList.size() <= 0 || !this.j0.k()) ? z : true) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public final void e0() {
        boolean z;
        boolean z2 = false;
        if (this.a0) {
            T4 t4 = this.x;
            t4.k(t4.b);
            t4.k(t4.c);
            t4.f = 0;
            if (this.b0) {
                this.G.b0();
            }
        }
        if (this.j0 == null || !this.G.F0()) {
            this.x.c();
        } else {
            this.x.j();
        }
        boolean z3 = this.E0 || this.F0;
        boolean z4 = this.O && this.j0 != null && ((z = this.a0) || z3 || this.G.f) && (!z || this.F.u);
        ms1 ms1Var = this.B0;
        ms1Var.j = z4;
        if (z4 && z3 && !this.a0 && this.j0 != null && this.G.F0()) {
            z2 = true;
        }
        ms1Var.k = z2;
    }

    public final void f0(boolean z) {
        this.b0 = z | this.b0;
        this.a0 = true;
        int iH = this.y.h();
        for (int i = 0; i < iH; i++) {
            ps1 ps1VarN = N(this.y.g(i));
            if (ps1VarN != null && !ps1VarN.t()) {
                ps1VarN.c(6);
            }
        }
        W();
        C0738gs1 c0738gs1 = this.v;
        ArrayList arrayList = c0738gs1.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ps1 ps1Var = (ps1) arrayList.get(i2);
            if (ps1Var != null) {
                ps1Var.c(6);
                ps1Var.c(1024);
            }
        }
        Pr1 pr1 = c0738gs1.h.F;
        if (pr1 == null || !pr1.u) {
            c0738gs1.f();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instruction units count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g0(ps1 ps1Var, C0251Ur1 c0251Ur1) {
        ps1Var.C &= -8193;
        boolean z = this.B0.h;
        C1695wo2 c1695wo2 = this.z;
        if (z && ps1Var.p() && !ps1Var.m() && !ps1Var.t()) {
            c1695wo2.b.e(K(ps1Var), ps1Var);
        }
        UJ1 uj1 = c1695wo2.a;
        C1638vo2 c1638vo2A = (C1638vo2) uj1.get(ps1Var);
        if (c1638vo2A == null) {
            c1638vo2A = C1638vo2.a();
            uj1.put(ps1Var, c1638vo2A);
        }
        c1638vo2A.b = c0251Ur1;
        c1638vo2A.a |= 4;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null) {
            return abstractC0306Yr1.r();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + B());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null) {
            return abstractC0306Yr1.s(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + B());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Override // android.view.View
    public final int getBaseline() {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 == null) {
            return super.getBaseline();
        }
        abstractC0306Yr1.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        return super.getChildDrawingOrder(i, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean getClipToPadding() {
        return this.A;
    }

    public final void h(ps1 ps1Var) {
        View view = ps1Var.t;
        boolean z = view.getParent() == this;
        this.v.l(M(view));
        if (ps1Var.o()) {
            this.y.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            this.y.a(view, -1, true);
            return;
        }
        C0217Rz c0217Rz = this.y;
        int iIndexOfChild = c0217Rz.a.a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            c0217Rz.b.h(iIndexOfChild);
            c0217Rz.i(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void h0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f0;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f0.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.g0;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.g0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.h0;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.h0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.i0;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.i0.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return R().f(0);
    }

    public final void i(AbstractC0262Vr1 abstractC0262Vr1) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null) {
            abstractC0306Yr1.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f19J;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(abstractC0262Vr1);
        W();
        requestLayout();
    }

    public final int i0(int i, float f) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.f0;
        float f2 = 0.0f;
        if (edgeEffect == null || u50.a(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.h0;
            if (edgeEffect2 != null && u50.a(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.h0.onRelease();
                } else {
                    float fB = u50.b(this.h0, width, height);
                    if (u50.a(this.h0) == 0.0f) {
                        this.h0.onRelease();
                    }
                    f2 = fB;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.f0.onRelease();
            } else {
                float f3 = -u50.b(this.f0, -width, 1.0f - height);
                if (u50.a(this.f0) == 0.0f) {
                    this.f0.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getWidth());
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.M;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.R;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return R().d;
    }

    public final void j(InterfaceC0382as1 interfaceC0382as1) {
        if (this.W == null) {
            this.W = new ArrayList();
        }
        this.W.add(interfaceC0382as1);
    }

    public final int j0(int i, float f) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.g0;
        float f2 = 0.0f;
        if (edgeEffect == null || u50.a(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.i0;
            if (edgeEffect2 != null && u50.a(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.i0.onRelease();
                } else {
                    float fB = u50.b(this.i0, height, 1.0f - width);
                    if (u50.a(this.i0) == 0.0f) {
                        this.i0.onRelease();
                    }
                    f2 = fB;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.g0.onRelease();
            } else {
                float f3 = -u50.b(this.g0, -height, width);
                if (u50.a(this.g0) == 0.0f) {
                    this.g0.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getHeight());
    }

    public final void k(cs1 cs1Var) {
        if (this.D0 == null) {
            this.D0 = new ArrayList();
        }
        this.D0.add(cs1Var);
    }

    public final void k0(AbstractC0262Vr1 abstractC0262Vr1) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null) {
            abstractC0306Yr1.c("Cannot remove item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f19J;
        arrayList.remove(abstractC0262Vr1);
        if (arrayList.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        W();
        requestLayout();
    }

    public final void l(String str) {
        if (U()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + B());
        }
        if (this.d0 > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + B()));
        }
    }

    public final void l0(bs1 bs1Var) {
        this.K.remove(bs1Var);
        if (this.L == bs1Var) {
            this.L = null;
        }
    }

    public final void m0(cs1 cs1Var) {
        ArrayList arrayList = this.D0;
        if (arrayList != null) {
            arrayList.remove(cs1Var);
        }
    }

    public final void n() {
        int iH = this.y.h();
        for (int i = 0; i < iH; i++) {
            ps1 ps1VarN = N(this.y.g(i));
            if (!ps1VarN.t()) {
                ps1VarN.w = -1;
                ps1VarN.z = -1;
            }
        }
        C0738gs1 c0738gs1 = this.v;
        ArrayList arrayList = c0738gs1.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ps1 ps1Var = (ps1) arrayList.get(i2);
            ps1Var.w = -1;
            ps1Var.z = -1;
        }
        ArrayList arrayList2 = c0738gs1.a;
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ps1 ps1Var2 = (ps1) arrayList2.get(i3);
            ps1Var2.w = -1;
            ps1Var2.z = -1;
        }
        ArrayList arrayList3 = c0738gs1.b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ps1 ps1Var3 = (ps1) c0738gs1.b.get(i4);
                ps1Var3.w = -1;
                ps1Var3.z = -1;
            }
        }
    }

    public final void n0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.C;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C0321Zr1) {
            C0321Zr1 c0321Zr1 = (C0321Zr1) layoutParams;
            if (!c0321Zr1.c) {
                int i = rect.left;
                Rect rect2 = c0321Zr1.b;
                rect.left = i - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.G.q0(this, view, this.C, !this.O, view2 == null);
    }

    public final void o(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f0;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.f0.onRelease();
            zIsFinished = this.f0.isFinished();
        }
        EdgeEffect edgeEffect2 = this.h0;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.h0.onRelease();
            zIsFinished |= this.h0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.g0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.g0.onRelease();
            zIsFinished |= this.g0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.i0;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.i0.onRelease();
            zIsFinished |= this.i0.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o0(int r20, int r21, android.view.MotionEvent r22, int r23) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o0(int, int, android.view.MotionEvent, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.c0 = r0
            r1 = 1
            r5.M = r1
            boolean r2 = r5.O
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.O = r2
            gs1 r2 = r5.v
            r2.d()
            Yr1 r2 = r5.G
            if (r2 == 0) goto L26
            r2.g = r1
            r2.T(r5)
        L26:
            r5.H0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.Z0
            if (r0 == 0) goto L70
            java.lang.ThreadLocal r0 = defpackage.RunnableC1349ql0.x
            java.lang.Object r1 = r0.get()
            ql0 r1 = (defpackage.RunnableC1349ql0) r1
            r5.z0 = r1
            if (r1 != 0) goto L66
            ql0 r1 = new ql0
            r1.<init>()
            r5.z0 = r1
            java.util.WeakHashMap r1 = defpackage.AbstractC0604eo2.a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L58
            if (r1 == 0) goto L58
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L58
            goto L5a
        L58:
            r1 = 1114636288(0x42700000, float:60.0)
        L5a:
            ql0 r2 = r5.z0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.v = r3
            r0.set(r2)
        L66:
            ql0 r0 = r5.z0
            r0.getClass()
            java.util.ArrayList r0 = r0.t
            r0.add(r5)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        C0738gs1 c0738gs1;
        RunnableC1349ql0 runnableC1349ql0;
        super.onDetachedFromWindow();
        WJ1 wj1 = this.j0;
        if (wj1 != null) {
            wj1.j();
        }
        D0();
        int i = 0;
        this.M = false;
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null) {
            abstractC0306Yr1.g = false;
            abstractC0306Yr1.U(this);
        }
        this.O0.clear();
        removeCallbacks(this.P0);
        this.z.getClass();
        while (C1638vo2.d.a() != null) {
        }
        int i2 = 0;
        while (true) {
            c0738gs1 = this.v;
            ArrayList arrayList = c0738gs1.c;
            if (i2 >= arrayList.size()) {
                break;
            }
            xi1.a(((ps1) arrayList.get(i2)).t);
            i2++;
        }
        c0738gs1.e(c0738gs1.h.F, false);
        int i3 = xi1.a;
        while (i < getChildCount()) {
            int i4 = i + 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            int i5 = xi1.a;
            C1861zi1 c1861zi1 = (C1861zi1) childAt.getTag(i5);
            if (c1861zi1 == null) {
                c1861zi1 = new C1861zi1();
                childAt.setTag(i5, c1861zi1);
            }
            ArrayList arrayList2 = c1861zi1.a;
            int iC = OG.c(arrayList2);
            if (-1 < iC) {
                yi1.a(arrayList2.get(iC));
                throw null;
            }
            i = i4;
        }
        if (!Z0 || (runnableC1349ql0 = this.z0) == null) {
            return;
        }
        runnableC1349ql0.t.remove(this);
        this.z0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f19J;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC0262Vr1) arrayList.get(i)).h(canvas, this);
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i;
        boolean z;
        float axisValue;
        if (this.G != null && !this.R && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                float f = this.G.e() ? -motionEvent.getAxisValue(9) : 0.0f;
                z = false;
                axisValue = this.G.d() ? motionEvent.getAxisValue(10) : 0.0f;
                f = f;
                i = 0;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                i = 26;
                axisValue = motionEvent.getAxisValue(26);
                if (this.G.e()) {
                    float f2 = -axisValue;
                    axisValue = 0.0f;
                    f = f2;
                } else if (!this.G.d()) {
                    axisValue = 0.0f;
                }
                z = this.T0;
            } else {
                i = 0;
                z = false;
                axisValue = 0.0f;
            }
            int i2 = (int) (f * this.w0);
            int i3 = (int) (axisValue * this.v0);
            if (z) {
                OverScroller overScroller = this.y0.v;
                y0((overScroller.getFinalX() - overScroller.getCurrX()) + i3, true, (overScroller.getFinalY() - overScroller.getCurrY()) + i2);
            } else {
                AbstractC0306Yr1 abstractC0306Yr1 = this.G;
                if (abstractC0306Yr1 == null) {
                    Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                } else if (!this.R) {
                    int[] iArr = this.N0;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    boolean zD = abstractC0306Yr1.d();
                    boolean zE = this.G.e();
                    int i4 = zE ? (zD ? 1 : 0) | 2 : zD ? 1 : 0;
                    float y = motionEvent.getY();
                    float x = motionEvent.getX();
                    int iI0 = i3 - i0(i3, y);
                    int iJ0 = i2 - j0(i2, x);
                    R().g(i4, 1);
                    if (R().c(zD ? iI0 : 0, zE ? iJ0 : 0, 1, this.N0, this.L0)) {
                        iI0 -= iArr[0];
                        iJ0 -= iArr[1];
                    }
                    o0(zD ? iI0 : 0, zE ? iJ0 : 0, motionEvent, 1);
                    RunnableC1349ql0 runnableC1349ql0 = this.z0;
                    if (runnableC1349ql0 != null && (iI0 != 0 || iJ0 != 0)) {
                        runnableC1349ql0.a(this, iI0, iJ0);
                    }
                    R().h(1);
                }
            }
            if (i != 0 && !z) {
                this.V0.a(motionEvent, i);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (this.R) {
            return false;
        }
        this.L = null;
        if (E(motionEvent)) {
            VelocityTracker velocityTracker = this.m0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
            R().h(0);
            h0();
            w0(0);
            return true;
        }
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 == null) {
            return false;
        }
        boolean zD = abstractC0306Yr1.d();
        boolean zE = this.G.e();
        if (this.m0 == null) {
            this.m0 = VelocityTracker.obtain();
        }
        this.m0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.S) {
                this.S = false;
            }
            this.l0 = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.p0 = x;
            this.n0 = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.q0 = y;
            this.o0 = y;
            EdgeEffect edgeEffect = this.f0;
            if (edgeEffect == null || u50.a(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                z = false;
            } else {
                u50.b(this.f0, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                z = true;
            }
            EdgeEffect edgeEffect2 = this.h0;
            if (edgeEffect2 != null && u50.a(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
                u50.b(this.h0, 0.0f, motionEvent.getY() / getHeight());
                z = true;
            }
            EdgeEffect edgeEffect3 = this.g0;
            if (edgeEffect3 != null && u50.a(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
                u50.b(this.g0, 0.0f, motionEvent.getX() / getWidth());
                z = true;
            }
            EdgeEffect edgeEffect4 = this.i0;
            if (edgeEffect4 != null && u50.a(edgeEffect4) != 0.0f && !canScrollVertically(1)) {
                u50.b(this.i0, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                z = true;
            }
            if (z || this.k0 == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                w0(1);
                R().h(1);
            }
            int[] iArr = this.M0;
            iArr[1] = 0;
            iArr[0] = 0;
            B0(0);
        } else if (actionMasked == 1) {
            this.m0.clear();
            R().h(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.l0);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.l0 + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.k0 != 1) {
                int i = x2 - this.n0;
                int i2 = y2 - this.o0;
                if (!zD || Math.abs(i) <= this.r0) {
                    z2 = false;
                } else {
                    this.p0 = x2;
                    z2 = true;
                }
                if (zE && Math.abs(i2) > this.r0) {
                    this.q0 = y2;
                    z2 = true;
                }
                if (z2) {
                    w0(1);
                }
            }
        } else if (actionMasked == 3) {
            VelocityTracker velocityTracker2 = this.m0;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
            R().h(0);
            h0();
            w0(0);
        } else if (actionMasked == 5) {
            this.l0 = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.p0 = x3;
            this.n0 = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.q0 = y3;
            this.o0 = y3;
        } else if (actionMasked == 6) {
            c0(motionEvent);
        }
        return this.k0 == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Trace.beginSection("RV OnLayout");
        t();
        Trace.endSection();
        this.O = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 == null) {
            r(i, i2);
            return;
        }
        boolean zM = abstractC0306Yr1.M();
        boolean z = false;
        ms1 ms1Var = this.B0;
        if (zM) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.G.b.r(i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.Q0 = z;
            if (z || this.F == null) {
                return;
            }
            if (ms1Var.d == 1) {
                u();
            }
            this.G.w0(i, i2);
            ms1Var.i = true;
            v();
            this.G.y0(i, i2);
            if (this.G.B0()) {
                this.G.w0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                ms1Var.i = true;
                v();
                this.G.y0(i, i2);
            }
            this.R0 = getMeasuredWidth();
            this.S0 = getMeasuredHeight();
            return;
        }
        if (this.N) {
            this.G.b.r(i, i2);
            return;
        }
        if (this.U) {
            A0();
            a0();
            e0();
            b0(true);
            if (ms1Var.k) {
                ms1Var.g = true;
            } else {
                this.x.c();
                ms1Var.g = false;
            }
            this.U = false;
            C0(false);
        } else if (ms1Var.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Pr1 pr1 = this.F;
        if (pr1 != null) {
            ms1Var.e = pr1.b();
        } else {
            ms1Var.e = 0;
        }
        A0();
        this.G.b.r(i, i2);
        C0(false);
        ms1Var.g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (U()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.w = savedState;
        super.onRestoreInstanceState(savedState.t);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.w;
        if (savedState2 != null) {
            savedState.v = savedState2.v;
        } else {
            AbstractC0306Yr1 abstractC0306Yr1 = this.G;
            if (abstractC0306Yr1 != null) {
                savedState.v = abstractC0306Yr1.i0();
            } else {
                savedState.v = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        this.i0 = null;
        this.g0 = null;
        this.h0 = null;
        this.f0 = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0119 A[PHI: r8
      0x0119: PHI (r8v7 int) = (r8v2 int), (r8v11 int) binds: [B:56:0x0102, B:60:0x0115] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0132  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r20) {
        /*
            Method dump skipped, instruction units count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p0(int i, int i2, int[] iArr) {
        ps1 ps1Var;
        A0();
        a0();
        Trace.beginSection("RV Scroll");
        ms1 ms1Var = this.B0;
        C(ms1Var);
        C0738gs1 c0738gs1 = this.v;
        int iS0 = i != 0 ? this.G.s0(i, c0738gs1, ms1Var) : 0;
        int iU0 = i2 != 0 ? this.G.u0(i2, c0738gs1, ms1Var) : 0;
        Trace.endSection();
        int iE = this.y.e();
        for (int i3 = 0; i3 < iE; i3++) {
            View viewD = this.y.d(i3);
            ps1 ps1VarM = M(viewD);
            if (ps1VarM != null && (ps1Var = ps1VarM.B) != null) {
                int left = viewD.getLeft();
                int top = viewD.getTop();
                View view = ps1Var.t;
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        b0(true);
        C0(false);
        if (iArr != null) {
            iArr[0] = iS0;
            iArr[1] = iU0;
        }
    }

    public final void q() {
        if (!this.O || this.a0) {
            Trace.beginSection("RV FullInvalidate");
            t();
            Trace.endSection();
            return;
        }
        if (this.x.g()) {
            T4 t4 = this.x;
            int i = t4.f;
            if ((i & 4) == 0 || (i & 11) != 0) {
                if (t4.g()) {
                    Trace.beginSection("RV FullInvalidate");
                    t();
                    Trace.endSection();
                    return;
                }
                return;
            }
            Trace.beginSection("RV PartialInvalidate");
            A0();
            a0();
            this.x.j();
            if (!this.Q) {
                int iE = this.y.e();
                int i2 = 0;
                while (true) {
                    if (i2 < iE) {
                        ps1 ps1VarN = N(this.y.d(i2));
                        if (ps1VarN != null && !ps1VarN.t() && ps1VarN.p()) {
                            t();
                            break;
                        }
                        i2++;
                    } else {
                        this.x.b();
                        break;
                    }
                }
            }
            C0(true);
            b0(true);
            Trace.endSection();
        }
    }

    public final void q0(int i) {
        if (this.R) {
            return;
        }
        D0();
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC0306Yr1.t0(i);
            awakenScrollBars();
        }
    }

    public final void r(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        setMeasuredDimension(AbstractC0306Yr1.g(i, paddingRight, getMinimumWidth()), AbstractC0306Yr1.g(i2, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void r0(Pr1 pr1) {
        suppressLayout(false);
        s0(pr1, false);
        f0(false);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        ps1 ps1VarN = N(view);
        if (ps1VarN != null) {
            if (ps1VarN.o()) {
                ps1VarN.C &= -257;
            } else if (!ps1VarN.t()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + ps1VarN + B());
            }
        }
        view.clearAnimation();
        s(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        AF0 af0 = this.G.e;
        if ((af0 == null || !af0.e) && !U() && view2 != null) {
            n0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.G.q0(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((bs1) arrayList.get(i)).e(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.P != 0 || this.R) {
            this.Q = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s(View view) {
        N(view);
        Z(view);
        ArrayList arrayList = this.W;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((InterfaceC0382as1) this.W.get(size)).d(view);
            }
        }
    }

    public final void s0(Pr1 pr1, boolean z) {
        Pr1 pr12 = this.F;
        is1 is1Var = this.u;
        if (pr12 != null) {
            pr12.v(is1Var);
            this.F.p(this);
        }
        WJ1 wj1 = this.j0;
        if (wj1 != null) {
            wj1.j();
        }
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        C0738gs1 c0738gs1 = this.v;
        if (abstractC0306Yr1 != null) {
            abstractC0306Yr1.m0(c0738gs1);
            this.G.n0(c0738gs1);
        }
        c0738gs1.a.clear();
        c0738gs1.f();
        T4 t4 = this.x;
        t4.k(t4.b);
        t4.k(t4.c);
        t4.f = 0;
        Pr1 pr13 = this.F;
        this.F = pr1;
        if (pr1 != null) {
            pr1.t(is1Var);
            pr1.l(this);
        }
        AbstractC0306Yr1 abstractC0306Yr12 = this.G;
        if (abstractC0306Yr12 != null) {
            abstractC0306Yr12.S();
        }
        Pr1 pr14 = this.F;
        c0738gs1.a.clear();
        c0738gs1.f();
        c0738gs1.e(pr13, true);
        C0606es1 c0606es1C = c0738gs1.c();
        if (pr13 != null) {
            c0606es1C.b--;
        }
        if (!z && c0606es1C.b == 0) {
            c0606es1C.a();
        }
        if (pr14 != null) {
            c0606es1C.b++;
        } else {
            c0606es1C.getClass();
        }
        c0738gs1.d();
        this.B0.f = true;
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i2) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.R) {
            return;
        }
        boolean zD = abstractC0306Yr1.d();
        boolean zE = this.G.e();
        if (zD || zE) {
            if (!zD) {
                i = 0;
            }
            if (!zE) {
                i2 = 0;
            }
            o0(i, i2, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!U()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.T |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    @Override // android.view.ViewGroup
    public final void setClipToPadding(boolean z) {
        if (z != this.A) {
            this.i0 = null;
            this.g0 = null;
            this.h0 = null;
            this.f0 = null;
        }
        this.A = z;
        super.setClipToPadding(z);
        if (this.O) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public final void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public final void setNestedScrollingEnabled(boolean z) {
        PX0 px0R = R();
        if (px0R.d) {
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            px0R.c.stopNestedScroll();
        }
        px0R.d = z;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return R().g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        R().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.R) {
            l("Do not suppressLayout in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.R = true;
                this.S = true;
                D0();
                return;
            }
            this.R = false;
            if (this.Q && this.G != null && this.F != null) {
                requestLayout();
            }
            this.Q = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03d0  */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [int] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            Method dump skipped, instruction units count: 1077
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.t():void");
    }

    public final void t0(WJ1 wj1) {
        WJ1 wj12 = this.j0;
        if (wj12 != null) {
            wj12.j();
            this.j0.a = null;
        }
        this.j0 = wj1;
        if (wj1 != null) {
            wj1.a = this.G0;
        }
    }

    public final void u() {
        C1638vo2 c1638vo2;
        View viewD;
        ms1 ms1Var = this.B0;
        ms1Var.a(1);
        C(ms1Var);
        ms1Var.i = false;
        A0();
        C1695wo2 c1695wo2 = this.z;
        c1695wo2.a.clear();
        EJ0 ej0 = c1695wo2.b;
        ej0.a();
        a0();
        e0();
        ps1 ps1VarM = null;
        View focusedChild = (this.x0 && hasFocus() && this.F != null) ? getFocusedChild() : null;
        if (focusedChild != null && (viewD = D(focusedChild)) != null) {
            ps1VarM = M(viewD);
        }
        if (ps1VarM == null) {
            ms1Var.m = -1L;
            ms1Var.l = -1;
            ms1Var.n = -1;
        } else {
            ms1Var.m = this.F.u ? ps1VarM.x : -1L;
            ms1Var.l = this.a0 ? -1 : ps1VarM.m() ? ps1VarM.w : ps1VarM.d();
            View focusedChild2 = ps1VarM.t;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            ms1Var.n = id;
        }
        ms1Var.h = ms1Var.j && this.F0;
        this.F0 = false;
        this.E0 = false;
        ms1Var.g = ms1Var.k;
        ms1Var.e = this.F.b();
        F(this.J0);
        boolean z = ms1Var.j;
        UJ1 uj1 = c1695wo2.a;
        if (z) {
            int iE = this.y.e();
            for (int i = 0; i < iE; i++) {
                ps1 ps1VarN = N(this.y.d(i));
                if (!ps1VarN.t() && (!ps1VarN.k() || this.F.u)) {
                    WJ1 wj1 = this.j0;
                    WJ1.e(ps1VarN);
                    ps1VarN.g();
                    wj1.getClass();
                    C0251Ur1 c0251Ur1 = new C0251Ur1();
                    c0251Ur1.a(ps1VarN);
                    C1638vo2 c1638vo2A = (C1638vo2) uj1.get(ps1VarN);
                    if (c1638vo2A == null) {
                        c1638vo2A = C1638vo2.a();
                        uj1.put(ps1VarN, c1638vo2A);
                    }
                    c1638vo2A.b = c0251Ur1;
                    c1638vo2A.a |= 4;
                    if (ms1Var.h && ps1VarN.p() && !ps1VarN.m() && !ps1VarN.t() && !ps1VarN.k()) {
                        ej0.e(K(ps1VarN), ps1VarN);
                    }
                }
            }
        }
        if (ms1Var.k) {
            int iH = this.y.h();
            for (int i2 = 0; i2 < iH; i2++) {
                ps1 ps1VarN2 = N(this.y.g(i2));
                if (!ps1VarN2.t() && ps1VarN2.w == -1) {
                    ps1VarN2.w = ps1VarN2.v;
                }
            }
            boolean z2 = ms1Var.f;
            ms1Var.f = false;
            this.G.f0(this.v, ms1Var);
            ms1Var.f = z2;
            for (int i3 = 0; i3 < this.y.e(); i3++) {
                ps1 ps1VarN3 = N(this.y.d(i3));
                if (!ps1VarN3.t() && ((c1638vo2 = (C1638vo2) uj1.get(ps1VarN3)) == null || (c1638vo2.a & 4) == 0)) {
                    WJ1.e(ps1VarN3);
                    boolean zH = ps1VarN3.h(8192);
                    WJ1 wj12 = this.j0;
                    ps1VarN3.g();
                    wj12.getClass();
                    C0251Ur1 c0251Ur12 = new C0251Ur1();
                    c0251Ur12.a(ps1VarN3);
                    if (zH) {
                        g0(ps1VarN3, c0251Ur12);
                    } else {
                        C1638vo2 c1638vo2A2 = (C1638vo2) uj1.get(ps1VarN3);
                        if (c1638vo2A2 == null) {
                            c1638vo2A2 = C1638vo2.a();
                            uj1.put(ps1VarN3, c1638vo2A2);
                        }
                        c1638vo2A2.a |= 2;
                        c1638vo2A2.b = c0251Ur12;
                    }
                }
            }
            n();
        } else {
            n();
        }
        b0(true);
        C0(false);
        ms1Var.d = 2;
    }

    public final void u0(AbstractC0306Yr1 abstractC0306Yr1) {
        RecyclerView recyclerView;
        if (abstractC0306Yr1 == this.G) {
            return;
        }
        D0();
        AbstractC0306Yr1 abstractC0306Yr12 = this.G;
        C0738gs1 c0738gs1 = this.v;
        if (abstractC0306Yr12 != null) {
            WJ1 wj1 = this.j0;
            if (wj1 != null) {
                wj1.j();
            }
            this.G.m0(c0738gs1);
            this.G.n0(c0738gs1);
            c0738gs1.a.clear();
            c0738gs1.f();
            if (this.M) {
                AbstractC0306Yr1 abstractC0306Yr13 = this.G;
                abstractC0306Yr13.g = false;
                abstractC0306Yr13.U(this);
            }
            this.G.z0(null);
            this.G = null;
        } else {
            c0738gs1.a.clear();
            c0738gs1.f();
        }
        C0217Rz c0217Rz = this.y;
        c0217Rz.b.g();
        ArrayList arrayList = c0217Rz.c;
        int size = arrayList.size() - 1;
        while (true) {
            recyclerView = c0217Rz.a.a;
            if (size < 0) {
                break;
            }
            ps1 ps1VarN = N((View) arrayList.get(size));
            if (ps1VarN != null) {
                int i = ps1VarN.I;
                if (recyclerView.U()) {
                    ps1VarN.f34J = i;
                    recyclerView.O0.add(ps1VarN);
                } else {
                    ps1VarN.t.setImportantForAccessibility(i);
                }
                ps1VarN.I = 0;
            }
            arrayList.remove(size);
            size--;
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            recyclerView.s(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.G = abstractC0306Yr1;
        if (abstractC0306Yr1 != null) {
            if (abstractC0306Yr1.b != null) {
                throw new IllegalArgumentException("LayoutManager " + abstractC0306Yr1 + " is already attached to a RecyclerView:" + abstractC0306Yr1.b.B());
            }
            abstractC0306Yr1.z0(this);
            if (this.M) {
                AbstractC0306Yr1 abstractC0306Yr14 = this.G;
                abstractC0306Yr14.g = true;
                abstractC0306Yr14.T(this);
            }
        }
        c0738gs1.m();
        requestLayout();
    }

    public final void v() {
        A0();
        a0();
        ms1 ms1Var = this.B0;
        ms1Var.a(6);
        this.x.c();
        ms1Var.e = this.F.b();
        ms1Var.c = 0;
        if (this.w != null) {
            Pr1 pr1 = this.F;
            int iB = aM1.b(pr1.v);
            if (iB == 1 ? pr1.b() > 0 : iB != 2) {
                Parcelable parcelable = this.w.v;
                if (parcelable != null) {
                    this.G.h0(parcelable);
                }
                this.w = null;
            }
        }
        ms1Var.g = false;
        this.G.f0(this.v, ms1Var);
        ms1Var.f = false;
        ms1Var.j = ms1Var.j && this.j0 != null;
        ms1Var.d = 4;
        b0(true);
        C0(false);
    }

    public final void v0(C0606es1 c0606es1) {
        C0738gs1 c0738gs1 = this.v;
        RecyclerView recyclerView = c0738gs1.h;
        c0738gs1.e(recyclerView.F, false);
        if (c0738gs1.g != null) {
            r2.b--;
        }
        c0738gs1.g = c0606es1;
        if (c0606es1 != null && recyclerView.F != null) {
            c0606es1.b++;
        }
        c0738gs1.d();
    }

    public final void w(int i, int i2) {
        this.d0++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        cs1 cs1Var = this.C0;
        if (cs1Var != null) {
            cs1Var.b(this, i, i2);
        }
        ArrayList arrayList = this.D0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((cs1) this.D0.get(size)).b(this, i, i2);
            }
        }
        this.d0--;
    }

    public final void w0(int i) {
        AF0 af0;
        if (i == this.k0) {
            return;
        }
        this.k0 = i;
        if (i != 2) {
            os1 os1Var = this.y0;
            os1Var.z.removeCallbacks(os1Var);
            os1Var.v.abortAnimation();
            AbstractC0306Yr1 abstractC0306Yr1 = this.G;
            if (abstractC0306Yr1 != null && (af0 = abstractC0306Yr1.e) != null) {
                af0.i();
            }
        }
        AbstractC0306Yr1 abstractC0306Yr12 = this.G;
        if (abstractC0306Yr12 != null) {
            abstractC0306Yr12.j0(i);
        }
        ArrayList arrayList = this.D0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((cs1) this.D0.get(size)).a(i);
            }
        }
    }

    public final void x() {
        if (this.i0 != null) {
            return;
        }
        this.e0.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.i0 = edgeEffect;
        if (this.A) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final boolean x0(EdgeEffect edgeEffect, int i, int i2) {
        if (i > 0) {
            return true;
        }
        float fA = u50.a(edgeEffect) * i2;
        float fAbs = Math.abs(-i) * 0.35f;
        float f = this.t * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d = X0;
        return ((float) (Math.exp((d / (d - 1.0d)) * dLog) * ((double) f))) < fA;
    }

    public final void y() {
        if (this.f0 != null) {
            return;
        }
        this.e0.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f0 = edgeEffect;
        if (this.A) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void y0(int i, boolean z, int i2) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.R) {
            return;
        }
        if (!abstractC0306Yr1.d()) {
            i = 0;
        }
        if (!this.G.e()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (z) {
            int i3 = i != 0 ? 1 : 0;
            if (i2 != 0) {
                i3 |= 2;
            }
            R().g(i3, 1);
        }
        this.y0.c(i, i2, Integer.MIN_VALUE, null);
    }

    public final void z() {
        if (this.h0 != null) {
            return;
        }
        this.e0.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.h0 = edgeEffect;
        if (this.A) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void z0(int i) {
        if (this.R) {
            return;
        }
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC0306Yr1.D0(i, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        char c;
        Constructor constructor;
        Object[] objArr;
        super(context, attributeSet, i);
        int i2 = 1;
        this.u = new is1(this);
        this.v = new C0738gs1(this);
        this.z = new C1695wo2();
        this.B = new Mr1(0, this);
        this.C = new Rect();
        this.D = new Rect();
        this.E = new RectF();
        this.I = new ArrayList();
        this.f19J = new ArrayList();
        this.K = new ArrayList();
        this.P = 0;
        this.a0 = false;
        this.b0 = false;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = c1;
        ZV zv = new ZV();
        zv.h = new ArrayList();
        zv.i = new ArrayList();
        zv.j = new ArrayList();
        zv.k = new ArrayList();
        zv.l = new ArrayList();
        zv.m = new ArrayList();
        zv.n = new ArrayList();
        zv.o = new ArrayList();
        zv.p = new ArrayList();
        zv.q = new ArrayList();
        zv.r = new ArrayList();
        this.j0 = zv;
        this.k0 = 0;
        this.l0 = -1;
        this.v0 = Float.MIN_VALUE;
        this.w0 = Float.MIN_VALUE;
        this.x0 = true;
        this.y0 = new os1(this);
        this.A0 = Z0 ? new ol0() : null;
        ms1 ms1Var = new ms1();
        ms1Var.a = -1;
        ms1Var.b = 0;
        ms1Var.c = 0;
        ms1Var.d = 1;
        ms1Var.e = 0;
        ms1Var.f = false;
        ms1Var.g = false;
        ms1Var.h = false;
        ms1Var.i = false;
        ms1Var.j = false;
        ms1Var.k = false;
        this.B0 = ms1Var;
        this.E0 = false;
        this.F0 = false;
        C0178Or1 c0178Or1 = new C0178Or1(this);
        this.G0 = c0178Or1;
        this.H0 = false;
        this.J0 = new int[2];
        this.L0 = new int[2];
        this.M0 = new int[2];
        this.N0 = new int[2];
        this.O0 = new ArrayList();
        this.P0 = new Mr1(i2, this);
        this.R0 = 0;
        this.S0 = 0;
        this.U0 = new C0178Or1(this);
        this.V0 = new AY(getContext(), new C0178Or1(this));
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.r0 = viewConfiguration.getScaledTouchSlop();
        this.v0 = viewConfiguration.getScaledHorizontalScrollFactor();
        this.w0 = viewConfiguration.getScaledVerticalScrollFactor();
        this.t0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.u0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.t = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.j0.a = c0178Or1;
        this.x = new T4(new C0178Or1(this));
        this.y = new C0217Rz(new C0178Or1(this));
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        if (getImportantForAutofill() == 0) {
            setImportantForAutofill(8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.V = (AccessibilityManager) getContext().getSystemService("accessibility");
        rs1 rs1Var = new rs1(this);
        this.I0 = rs1Var;
        AbstractC0604eo2.o(this, rs1Var);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.RecyclerView, i, 0);
        AbstractC0604eo2.n(this, context, AbstractC0305Yp1.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        String string = typedArrayObtainStyledAttributes.getString(AbstractC0305Yp1.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(AbstractC0305Yp1.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.A = typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.RecyclerView_android_clipToPadding, true);
        if (typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.RecyclerView_fastScrollEnabled, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(AbstractC0305Yp1.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(AbstractC0305Yp1.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(AbstractC0305Yp1.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(AbstractC0305Yp1.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + B());
            }
            Resources resources = getContext().getResources();
            c = 2;
            new C1163nb0(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(Hp1.fastscroll_default_thickness), resources.getDimensionPixelSize(Hp1.fastscroll_minimum_range), resources.getDimensionPixelOffset(Hp1.fastscroll_margin));
        } else {
            c = 2;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.T0 = context.getPackageManager().hasSystemFeature("android.hardware.rotaryencoder.lowres");
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(AbstractC0306Yr1.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(a1);
                        objArr = new Object[4];
                        objArr[0] = context;
                        objArr[1] = attributeSet;
                        objArr[c] = Integer.valueOf(i);
                        objArr[3] = 0;
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = clsAsSubclass.getConstructor(null);
                            objArr = null;
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    u0((AbstractC0306Yr1) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                }
            }
        }
        int[] iArr = W0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        AbstractC0604eo2.n(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i, 0);
        boolean z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z);
        setTag(xi1.b, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.G;
        if (abstractC0306Yr1 != null) {
            return abstractC0306Yr1.t(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + B());
    }

    public void Y(View view) {
    }

    public void Z(View view) {
    }
}
