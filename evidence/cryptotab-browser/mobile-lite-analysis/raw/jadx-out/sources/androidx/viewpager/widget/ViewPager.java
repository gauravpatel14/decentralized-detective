package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.customview.view.AbsSavedState;
import defpackage.AbstractC0604eo2;
import defpackage.C0131Lo2;
import defpackage.C0175Oo2;
import defpackage.C0210Ro2;
import defpackage.C0225So2;
import defpackage.C0259Vo2;
import defpackage.C0274Wo2;
import defpackage.InterfaceC0188Po2;
import defpackage.InterfaceC0238To2;
import defpackage.InterfaceC0249Uo2;
import defpackage.InterpolatorC0148Mo2;
import defpackage.Qo2;
import defpackage.RunnableC0162No2;
import defpackage.u50;
import defpackage.y81;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    public static final int[] m0 = {R.attr.layout_gravity};
    public static final C0131Lo2 n0 = new C0131Lo2();
    public static final InterpolatorC0148Mo2 o0 = new InterpolatorC0148Mo2();
    public Parcelable A;
    public final Scroller B;
    public boolean C;
    public C0259Vo2 D;
    public float E;
    public float F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f21J;
    public boolean K;
    public boolean L;
    public final int M;
    public int N;
    public final int O;
    public final boolean P;
    public float Q;
    public float R;
    public float S;
    public float T;
    public int U;
    public VelocityTracker V;
    public final int W;
    public final int a0;
    public final int b0;
    public final int c0;
    public final EdgeEffect d0;
    public final EdgeEffect e0;
    public boolean f0;
    public boolean g0;
    public int h0;
    public ArrayList i0;
    public ArrayList j0;
    public final RunnableC0162No2 k0;
    public int l0;
    public int t;
    public final ArrayList u;
    public final Qo2 v;
    public final Rect w;
    public y81 x;
    public int y;
    public int z;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR = new C0274Wo2();
        public int v;
        public Parcelable w;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.v = parcel.readInt();
            this.w = parcel.readParcelable(classLoader);
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.v + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.v);
            parcel.writeParcelable(this.w, i);
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = new ArrayList();
        this.v = new Qo2();
        this.w = new Rect();
        this.z = -1;
        this.E = -3.4028235E38f;
        this.F = Float.MAX_VALUE;
        this.f21J = 1;
        this.P = true;
        this.U = -1;
        this.f0 = true;
        this.k0 = new RunnableC0162No2(this);
        this.l0 = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        this.B = new Scroller(context, o0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.O = viewConfiguration.getScaledPagingTouchSlop();
        this.W = (int) (400.0f * f);
        this.a0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.d0 = new EdgeEffect(context);
        this.e0 = new EdgeEffect(context);
        this.b0 = (int) (25.0f * f);
        this.c0 = (int) (2.0f * f);
        this.M = (int) (f * 16.0f);
        AbstractC0604eo2.o(this, new C0225So2(this));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        AbstractC0604eo2.q(this, new C0175Oo2(this));
    }

    public static boolean d(int i, int i2, int i3, View view, boolean z) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && d(i, i5 - childAt.getLeft(), i4 - childAt.getTop(), childAt, true)) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    public final Qo2 a(int i, int i2) {
        Qo2 qo2 = new Qo2();
        qo2.b = i;
        qo2.a = this.x.g(this, i);
        this.x.getClass();
        qo2.d = 1.0f;
        ArrayList arrayList = this.u;
        if (i2 < 0 || i2 >= arrayList.size()) {
            arrayList.add(qo2);
        } else {
            arrayList.add(i2, qo2);
        }
        return qo2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        Qo2 qo2J;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (qo2J = j(childAt)) != null && qo2J.b == this.y) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList arrayList) {
        Qo2 qo2J;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (qo2J = j(childAt)) != null && qo2J.b == this.y) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        C0210Ro2 c0210Ro2 = (C0210Ro2) layoutParams;
        boolean z = c0210Ro2.a | (view.getClass().getAnnotation(InterfaceC0188Po2.class) != null);
        c0210Ro2.a = z;
        if (!this.G) {
            super.addView(view, i, layoutParams);
        } else {
            if (z) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c0210Ro2.d = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    public final void b(InterfaceC0249Uo2 interfaceC0249Uo2) {
        if (this.i0 == null) {
            this.i0 = new ArrayList();
        }
        this.i0.add(interfaceC0249Uo2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(int r8) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.c(int):boolean");
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        if (this.x == null) {
            return false;
        }
        int i2 = i();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) i2) * this.E)) : i > 0 && scrollX < ((int) (((float) i2) * this.F));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0210Ro2) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.C = true;
        if (this.B.isFinished() || !this.B.computeScrollOffset()) {
            e(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.B.getCurrX();
        int currY = this.B.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!p(currX)) {
                this.B.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 1
            if (r0 != 0) goto L66
            int r0 = r6.getAction()
            r2 = 0
            if (r0 != 0) goto L61
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L48
            r3 = 22
            if (r0 == r3) goto L36
            r3 = 61
            if (r0 == r3) goto L20
            goto L61
        L20:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L2b
            boolean r6 = r5.c(r4)
            goto L62
        L2b:
            boolean r6 = r6.hasModifiers(r1)
            if (r6 == 0) goto L61
            boolean r6 = r5.c(r1)
            goto L62
        L36:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L41
            boolean r6 = r5.o()
            goto L62
        L41:
            r6 = 66
            boolean r6 = r5.c(r6)
            goto L62
        L48:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L5a
            int r6 = r5.y
            if (r6 <= 0) goto L61
            int r6 = r6 - r1
            r5.I = r2
            r5.x(r6, r2, r1, r2)
            r6 = r1
            goto L62
        L5a:
            r6 = 17
            boolean r6 = r5.c(r6)
            goto L62
        L61:
            r6 = r2
        L62:
            if (r6 == 0) goto L65
            goto L66
        L65:
            r1 = r2
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Qo2 qo2J;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (qo2J = j(childAt)) != null && qo2J.b == this.y && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        y81 y81Var;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (y81Var = this.x) != null && y81Var.c() > 1)) {
            if (!this.d0.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.E * width);
                this.d0.setSize(height, width);
                zDraw = this.d0.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.e0.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.F + 1.0f)) * width2);
                this.e0.setSize(height2, width2);
                zDraw |= this.e0.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.d0.finish();
            this.e0.finish();
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public final void e(boolean z) {
        Scroller scroller = this.B;
        boolean z2 = this.l0 == 2;
        if (z2) {
            z(false);
            if (!scroller.isFinished()) {
                scroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = scroller.getCurrX();
                int currY = scroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        p(currX);
                    }
                }
            }
        }
        this.I = false;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.u;
            if (i >= arrayList.size()) {
                break;
            }
            Qo2 qo2 = (Qo2) arrayList.get(i);
            if (qo2.c) {
                qo2.c = false;
                z2 = true;
            }
            i++;
        }
        if (z2) {
            RunnableC0162No2 runnableC0162No2 = this.k0;
            if (!z) {
                runnableC0162No2.run();
            } else {
                WeakHashMap weakHashMap = AbstractC0604eo2.a;
                postOnAnimation(runnableC0162No2);
            }
        }
    }

    public final void f() {
        int iC = this.x.c();
        this.t = iC;
        ArrayList arrayList = this.u;
        boolean z = arrayList.size() < (this.f21J * 2) + 1 && arrayList.size() < iC;
        int iMax = this.y;
        int i = 0;
        boolean z2 = false;
        while (i < arrayList.size()) {
            Qo2 qo2 = (Qo2) arrayList.get(i);
            int iF = this.x.f(qo2.a);
            if (iF != -1) {
                if (iF == -2) {
                    arrayList.remove(i);
                    i--;
                    if (!z2) {
                        this.x.getClass();
                        z2 = true;
                    }
                    this.x.a(this, qo2.a);
                    int i2 = this.y;
                    if (i2 == qo2.b) {
                        iMax = Math.max(0, Math.min(i2, iC - 1));
                    }
                } else {
                    int i3 = qo2.b;
                    if (i3 != iF) {
                        if (i3 == this.y) {
                            iMax = iF;
                        }
                        qo2.b = iF;
                    }
                }
                z = true;
            }
            i++;
        }
        if (z2) {
            this.x.getClass();
        }
        Collections.sort(arrayList, n0);
        if (z) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                C0210Ro2 c0210Ro2 = (C0210Ro2) getChildAt(i4).getLayoutParams();
                if (!c0210Ro2.a) {
                    c0210Ro2.c = 0.0f;
                }
            }
            x(iMax, 0, false, true);
            requestLayout();
        }
    }

    public final void g(int i) {
        ArrayList arrayList = this.i0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0249Uo2 interfaceC0249Uo2 = (InterfaceC0249Uo2) this.i0.get(i2);
                if (interfaceC0249Uo2 != null) {
                    interfaceC0249Uo2.b(i);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        C0210Ro2 c0210Ro2 = new C0210Ro2(-1, -1);
        c0210Ro2.c = 0.0f;
        return c0210Ro2;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        throw null;
    }

    public final Rect h(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public final int i() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final Qo2 j(View view) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.u;
            if (i >= arrayList.size()) {
                return null;
            }
            Qo2 qo2 = (Qo2) arrayList.get(i);
            if (this.x.h(view, qo2.a)) {
                return qo2;
            }
            i++;
        }
    }

    public final Qo2 k() {
        Qo2 qo2;
        int i;
        int i2 = i();
        float f = 0.0f;
        float scrollX = i2 > 0 ? getScrollX() / i2 : 0.0f;
        float f2 = i2 > 0 ? 0 / i2 : 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z = true;
        Qo2 qo22 = null;
        float f3 = 0.0f;
        while (true) {
            ArrayList arrayList = this.u;
            if (i4 >= arrayList.size()) {
                return qo22;
            }
            Qo2 qo23 = (Qo2) arrayList.get(i4);
            if (z || qo23.b == (i = i3 + 1)) {
                qo2 = qo23;
            } else {
                float f4 = f + f3 + f2;
                qo2 = this.v;
                qo2.e = f4;
                qo2.b = i;
                this.x.getClass();
                qo2.d = 1.0f;
                i4--;
            }
            f = qo2.e;
            float f5 = qo2.d + f + f2;
            if (!z && scrollX < f) {
                return qo22;
            }
            if (scrollX < f5 || i4 == arrayList.size() - 1) {
                break;
            }
            i3 = qo2.b;
            i4++;
            z = false;
            qo22 = qo2;
            f3 = qo2.d;
        }
        return qo2;
    }

    public final Qo2 l(int i) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.u;
            if (i2 >= arrayList.size()) {
                return null;
            }
            Qo2 qo2 = (Qo2) arrayList.get(i2);
            if (qo2.b == i) {
                return qo2;
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(float r13, int r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.h0
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6c
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6c
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            Ro2 r9 = (defpackage.C0210Ro2) r9
            boolean r10 = r9.a
            if (r10 != 0) goto L2c
            goto L69
        L2c:
            int r9 = r9.b
            r9 = r9 & 7
            if (r9 == r2) goto L50
            r10 = 3
            if (r9 == r10) goto L4a
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5d
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L46:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L5d
        L4a:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5d
        L50:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L46
        L5d:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L68
            r8.offsetLeftAndRight(r3)
        L68:
            r3 = r9
        L69:
            int r7 = r7 + 1
            goto L1b
        L6c:
            java.util.ArrayList r0 = r12.i0
            if (r0 == 0) goto L86
            int r0 = r0.size()
        L74:
            if (r1 >= r0) goto L86
            java.util.ArrayList r3 = r12.i0
            java.lang.Object r3 = r3.get(r1)
            Uo2 r3 = (defpackage.InterfaceC0249Uo2) r3
            if (r3 == 0) goto L83
            r3.c(r13, r14, r15)
        L83:
            int r1 = r1 + 1
            goto L74
        L86:
            r12.g0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.m(float, int, int):void");
    }

    public final void n(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.U) {
            int i = actionIndex == 0 ? 1 : 0;
            this.Q = motionEvent.getX(i);
            this.U = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.V;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean o() {
        y81 y81Var = this.x;
        if (y81Var == null || this.y >= y81Var.c() - 1) {
            return false;
        }
        int i = this.y + 1;
        this.I = false;
        x(i, 0, true, false);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.k0);
        Scroller scroller = this.B;
        if (scroller != null && !scroller.isFinished()) {
            this.B.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            t();
            return false;
        }
        if (action != 0) {
            if (this.K) {
                return true;
            }
            if (this.L) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.S = x;
            this.Q = x;
            float y = motionEvent.getY();
            this.T = y;
            this.R = y;
            this.U = motionEvent.getPointerId(0);
            this.L = false;
            this.C = true;
            this.B.computeScrollOffset();
            if (this.l0 == 2 && Math.abs(this.B.getFinalX() - this.B.getCurrX()) > this.c0) {
                this.B.abortAnimation();
                this.I = false;
                r();
                this.K = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                y(1);
            } else if (u50.a(this.d0) == 0.0f && u50.a(this.e0) == 0.0f) {
                e(false);
                this.K = false;
            } else {
                this.K = true;
                y(1);
                if (u50.a(this.d0) != 0.0f) {
                    u50.b(this.d0, 0.0f, 1.0f - (this.R / getHeight()));
                }
                if (u50.a(this.e0) != 0.0f) {
                    u50.b(this.e0, 0.0f, this.R / getHeight());
                }
            }
        } else if (action == 2) {
            int i = this.U;
            if (i != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f = x2 - this.Q;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.T);
                if (f != 0.0f) {
                    float f2 = this.Q;
                    if ((this.P || ((f2 >= this.N || f <= 0.0f) && (f2 <= getWidth() - this.N || f >= 0.0f))) && d((int) f, (int) x2, (int) y2, this, false)) {
                        this.Q = x2;
                        this.R = y2;
                        this.L = true;
                        return false;
                    }
                }
                float f3 = this.O;
                if (fAbs > f3 && fAbs * 0.5f > fAbs2) {
                    this.K = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    y(1);
                    this.Q = f > 0.0f ? this.S + this.O : this.S - this.O;
                    this.R = y2;
                    z(true);
                } else if (fAbs2 > f3) {
                    this.L = true;
                }
                if (this.K && q(x2, y2)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            n(motionEvent);
        }
        if (this.V == null) {
            this.V = VelocityTracker.obtain();
        }
        this.V.addMovement(motionEvent);
        return this.K;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        C0210Ro2 c0210Ro2;
        C0210Ro2 c0210Ro22;
        int i3;
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.N = Math.min(measuredWidth / 10, this.M);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            boolean z = true;
            int i5 = 1073741824;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && (c0210Ro22 = (C0210Ro2) childAt.getLayoutParams()) != null && c0210Ro22.a) {
                int i6 = c0210Ro22.b;
                int i7 = i6 & 7;
                int i8 = i6 & 112;
                boolean z2 = i8 == 48 || i8 == 80;
                if (i7 != 3 && i7 != 5) {
                    z = false;
                }
                int i9 = Integer.MIN_VALUE;
                if (z2) {
                    i3 = Integer.MIN_VALUE;
                    i9 = 1073741824;
                } else {
                    i3 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i10 = ((ViewGroup.LayoutParams) c0210Ro22).width;
                if (i10 != -2) {
                    if (i10 == -1) {
                        i10 = paddingLeft;
                    }
                    i9 = 1073741824;
                } else {
                    i10 = paddingLeft;
                }
                int i11 = ((ViewGroup.LayoutParams) c0210Ro22).height;
                if (i11 == -2) {
                    i11 = measuredHeight;
                    i5 = i3;
                } else if (i11 == -1) {
                    i11 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i10, i9), View.MeasureSpec.makeMeasureSpec(i11, i5));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i4++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.G = true;
        r();
        this.G = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((c0210Ro2 = (C0210Ro2) childAt2.getLayoutParams()) == null || !c0210Ro2.a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * c0210Ro2.c), 1073741824), iMakeMeasureSpec);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        Qo2 qo2J;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (qo2J = j(childAt)) != null && qo2J.b == this.y && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.t);
        if (this.x != null) {
            x(savedState.v, 0, false, true);
        } else {
            this.z = savedState.v;
            this.A = savedState.w;
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.v = this.y;
        y81 y81Var = this.x;
        if (y81Var != null) {
            y81Var.getClass();
            savedState.w = null;
        }
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            if (i3 > 0 && !this.u.isEmpty()) {
                if (!this.B.isFinished()) {
                    this.B.setFinalX(i() * this.y);
                    return;
                } else {
                    scrollTo((int) ((getScrollX() / ((i3 - getPaddingLeft()) - getPaddingRight())) * ((i - getPaddingLeft()) - getPaddingRight())), getScrollY());
                    return;
                }
            }
            Qo2 qo2L = l(this.y);
            int iMin = (int) ((qo2L != null ? Math.min(qo2L.e, this.F) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
            if (iMin != getScrollX()) {
                e(false);
                scrollTo(iMin, getScrollY());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00dd  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instruction units count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean p(int i) {
        if (this.u.size() == 0) {
            if (this.f0) {
                return false;
            }
            this.g0 = false;
            m(0.0f, 0, 0);
            if (this.g0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        Qo2 qo2K = k();
        float fI = i();
        int i2 = qo2K.b;
        float f = ((i / fI) - qo2K.e) / (qo2K.d + (0 / fI));
        this.g0 = false;
        m(f, i2, (int) (fI * f));
        if (this.g0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean q(float f, float f2) {
        boolean z;
        float f3 = this.Q - f;
        this.Q = f;
        float height = f2 / getHeight();
        float width = f3 / getWidth();
        float fB = (u50.a(this.d0) != 0.0f ? -u50.b(this.d0, -width, 1.0f - height) : u50.a(this.e0) != 0.0f ? u50.b(this.e0, width, height) : 0.0f) * getWidth();
        float f4 = f3 - fB;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = fB != 0.0f;
        if (Math.abs(f4) < 1.0E-4f) {
            return z4;
        }
        float scrollX = getScrollX() + f4;
        float fI = i();
        float f5 = this.E * fI;
        float f6 = this.F * fI;
        ArrayList arrayList = this.u;
        Qo2 qo2 = (Qo2) arrayList.get(0);
        Qo2 qo22 = (Qo2) arrayList.get(arrayList.size() - 1);
        if (qo2.b != 0) {
            f5 = qo2.e * fI;
            z = false;
        } else {
            z = true;
        }
        if (qo22.b != this.x.c() - 1) {
            f6 = qo22.e * fI;
        } else {
            z3 = true;
        }
        if (scrollX < f5) {
            if (z) {
                u50.b(this.d0, (f5 - scrollX) / fI, 1.0f - (f2 / getHeight()));
            } else {
                z2 = z4;
            }
            z4 = z2;
            scrollX = f5;
        } else if (scrollX > f6) {
            if (z3) {
                u50.b(this.e0, (scrollX - f6) / fI, f2 / getHeight());
            } else {
                z2 = z4;
            }
            z4 = z2;
            scrollX = f6;
        }
        int i = (int) scrollX;
        this.Q = (scrollX - i) + this.Q;
        scrollTo(i, getScrollY());
        p(i);
        return z4;
    }

    public final void r() {
        s(this.y);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.G) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bc A[PHI: r7 r11 r15
      0x00bc: PHI (r7v18 int) = (r7v17 int), (r7v6 int), (r7v21 int) binds: [B:61:0x00de, B:58:0x00ca, B:50:0x00b3] A[DONT_GENERATE, DONT_INLINE]
      0x00bc: PHI (r11v35 int) = (r11v1 int), (r11v34 int), (r11v38 int) binds: [B:61:0x00de, B:58:0x00ca, B:50:0x00b3] A[DONT_GENERATE, DONT_INLINE]
      0x00bc: PHI (r15v6 float) = (r15v4 float), (r15v5 float), (r15v3 float) binds: [B:61:0x00de, B:58:0x00ca, B:50:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013c A[PHI: r1 r12
      0x013c: PHI (r1v39 float) = (r1v37 float), (r1v38 float), (r1v36 float) binds: [B:95:0x0163, B:92:0x014d, B:85:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x013c: PHI (r12v25 int) = (r12v23 int), (r12v24 int), (r12v22 int) binds: [B:95:0x0163, B:92:0x014d, B:85:0x0133] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(int r18) {
        /*
            Method dump skipped, instruction units count: 866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.s(int):void");
    }

    public final boolean t() {
        this.U = -1;
        this.K = false;
        this.L = false;
        VelocityTracker velocityTracker = this.V;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.V = null;
        }
        this.d0.onRelease();
        this.e0.onRelease();
        return (this.d0.isFinished() && this.e0.isFinished()) ? false : true;
    }

    public final void u(int i, int i2, boolean z, boolean z2) {
        int scrollX;
        int iAbs;
        Qo2 qo2L = l(i);
        int iMax = qo2L != null ? (int) (Math.max(this.E, Math.min(qo2L.e, this.F)) * i()) : 0;
        if (!z) {
            if (z2) {
                g(i);
            }
            e(false);
            scrollTo(iMax, 0);
            p(iMax);
            return;
        }
        if (getChildCount() == 0) {
            z(false);
        } else {
            Scroller scroller = this.B;
            if (scroller == null || scroller.isFinished()) {
                scrollX = getScrollX();
            } else {
                scrollX = this.C ? this.B.getCurrX() : this.B.getStartX();
                this.B.abortAnimation();
                z(false);
            }
            int i3 = scrollX;
            int scrollY = getScrollY();
            int i4 = iMax - i3;
            int i5 = 0 - scrollY;
            if (i4 == 0 && i5 == 0) {
                e(false);
                r();
                y(0);
            } else {
                z(true);
                y(2);
                int i6 = i();
                int i7 = i6 / 2;
                float f = i6;
                float f2 = i7;
                float fSin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i4) * 1.0f) / f) - 0.5f) * 0.47123894f)) * f2) + f2;
                int iAbs2 = Math.abs(i2);
                if (iAbs2 > 0) {
                    iAbs = Math.round(Math.abs(fSin / iAbs2) * 1000.0f) * 4;
                } else {
                    this.x.getClass();
                    iAbs = (int) (((Math.abs(i4) / ((f * 1.0f) + 0)) + 1.0f) * 100.0f);
                }
                int iMin = Math.min(iAbs, 600);
                this.C = false;
                this.B.startScroll(i3, scrollY, i4, i5, iMin);
                postInvalidateOnAnimation();
            }
        }
        if (z2) {
            g(i);
        }
    }

    public final void v(y81 y81Var) {
        ArrayList arrayList;
        y81 y81Var2 = this.x;
        if (y81Var2 != null) {
            synchronized (y81Var2) {
                y81Var2.b = null;
            }
            this.x.getClass();
            int i = 0;
            while (true) {
                arrayList = this.u;
                if (i >= arrayList.size()) {
                    break;
                }
                Qo2 qo2 = (Qo2) arrayList.get(i);
                y81 y81Var3 = this.x;
                int i2 = qo2.b;
                y81Var3.a(this, qo2.a);
                i++;
            }
            this.x.getClass();
            arrayList.clear();
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (!((C0210Ro2) getChildAt(i3).getLayoutParams()).a) {
                    removeViewAt(i3);
                    i3--;
                }
                i3++;
            }
            this.y = 0;
            scrollTo(0, 0);
        }
        this.x = y81Var;
        this.t = 0;
        if (this.D == null) {
            this.D = new C0259Vo2(this);
        }
        y81 y81Var4 = this.x;
        C0259Vo2 c0259Vo2 = this.D;
        synchronized (y81Var4) {
            y81Var4.b = c0259Vo2;
        }
        this.I = false;
        boolean z = this.f0;
        this.f0 = true;
        this.t = this.x.c();
        if (this.z >= 0) {
            this.x.getClass();
            x(this.z, 0, false, true);
            this.z = -1;
        } else if (z) {
            requestLayout();
        } else {
            r();
        }
        ArrayList arrayList2 = this.j0;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        int size = this.j0.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((InterfaceC0238To2) this.j0.get(i4)).a(this, y81Var);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == null;
    }

    public void w(int i) {
        this.I = false;
        x(i, 0, !this.f0, false);
    }

    public final void x(int i, int i2, boolean z, boolean z2) {
        y81 y81Var = this.x;
        if (y81Var == null || y81Var.c() <= 0) {
            z(false);
            return;
        }
        ArrayList arrayList = this.u;
        if (!z2 && this.y == i && arrayList.size() != 0) {
            z(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.x.c()) {
            i = this.x.c() - 1;
        }
        int i3 = this.y;
        int i4 = this.f21J;
        if (i > i3 + i4 || i < i3 - i4) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                ((Qo2) arrayList.get(i5)).c = true;
            }
        }
        boolean z3 = this.y != i;
        if (!this.f0) {
            s(i);
            u(i, i2, z, z3);
        } else {
            this.y = i;
            if (z3) {
                g(i);
            }
            requestLayout();
        }
    }

    public final void y(int i) {
        if (this.l0 == i) {
            return;
        }
        this.l0 = i;
        ArrayList arrayList = this.i0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0249Uo2 interfaceC0249Uo2 = (InterfaceC0249Uo2) this.i0.get(i2);
                if (interfaceC0249Uo2 != null) {
                    interfaceC0249Uo2.a(i);
                }
            }
        }
    }

    public final void z(boolean z) {
        if (this.H != z) {
            this.H = z;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        C0210Ro2 c0210Ro2 = new C0210Ro2(context, attributeSet);
        c0210Ro2.c = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m0);
        c0210Ro2.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
        return c0210Ro2;
    }
}
