package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import defpackage.A51;
import defpackage.AF0;
import defpackage.AbstractC0306Yr1;
import defpackage.AbstractC1214oR1;
import defpackage.C0294Xr1;
import defpackage.C0321Zr1;
import defpackage.C0738gs1;
import defpackage.C0814i0;
import defpackage.FA1;
import defpackage.InterfaceC1053ls1;
import defpackage.Pr1;
import defpackage.ms1;
import defpackage.ol0;
import defpackage.vF0;
import defpackage.wF0;
import defpackage.xF0;
import defpackage.yF0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends AbstractC0306Yr1 implements InterfaceC1053ls1 {
    public final vF0 A;
    public final wF0 B;
    public final int C;
    public final int[] D;
    public int p;
    public xF0 q;
    public A51 r;
    public boolean s;
    public final boolean t;
    public boolean u;
    public boolean v;
    public final boolean w;
    public int x;
    public int y;
    public SavedState z;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SuppressLint({"BanParcelableUsage"})
    public class SavedState implements Parcelable {
        public static final Parcelable.Creator CREATOR = new yF0();
        public int t;
        public int u;
        public boolean v;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.t);
            parcel.writeInt(this.u);
            parcel.writeInt(this.v ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.z = null;
        this.A = new vF0();
        this.B = new wF0();
        this.C = 2;
        this.D = new int[2];
        h1(i);
        c(null);
        if (this.t) {
            this.t = false;
            r0();
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean B0() {
        if (this.m == 1073741824 || this.l == 1073741824) {
            return false;
        }
        int iV = v();
        for (int i = 0; i < iV; i++) {
            ViewGroup.LayoutParams layoutParams = u(i).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void D0(int i, RecyclerView recyclerView) {
        AF0 af0 = new AF0(recyclerView.getContext());
        af0.a = i;
        E0(af0);
    }

    @Override // defpackage.AbstractC0306Yr1
    public boolean F0() {
        return this.z == null && this.s == this.v;
    }

    public void G0(ms1 ms1Var, int[] iArr) {
        int i;
        int iK = ms1Var.a != -1 ? this.r.k() : 0;
        if (this.q.f == -1) {
            i = 0;
        } else {
            i = iK;
            iK = 0;
        }
        iArr[0] = iK;
        iArr[1] = i;
    }

    public void H0(ms1 ms1Var, xF0 xf0, ol0 ol0Var) {
        int i = xf0.d;
        if (i < 0 || i >= ms1Var.b()) {
            return;
        }
        ol0Var.a(i, Math.max(0, xf0.g));
    }

    public final int I0(ms1 ms1Var) {
        if (v() == 0) {
            return 0;
        }
        M0();
        A51 a51 = this.r;
        boolean z = !this.w;
        return FA1.a(ms1Var, a51, P0(z), O0(z), this, this.w);
    }

    public final int J0(ms1 ms1Var) {
        if (v() == 0) {
            return 0;
        }
        M0();
        A51 a51 = this.r;
        boolean z = !this.w;
        return FA1.b(ms1Var, a51, P0(z), O0(z), this, this.w, this.u);
    }

    public final int K0(ms1 ms1Var) {
        if (v() == 0) {
            return 0;
        }
        M0();
        A51 a51 = this.r;
        boolean z = !this.w;
        return FA1.c(ms1Var, a51, P0(z), O0(z), this, this.w);
    }

    public final int L0(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.p == 1) ? 1 : Integer.MIN_VALUE : this.p == 0 ? 1 : Integer.MIN_VALUE : this.p == 1 ? -1 : Integer.MIN_VALUE : this.p == 0 ? -1 : Integer.MIN_VALUE : (this.p != 1 && Z0()) ? -1 : 1 : (this.p != 1 && Z0()) ? 1 : -1;
    }

    @Override // defpackage.AbstractC0306Yr1
    public boolean M() {
        return true;
    }

    public final void M0() {
        if (this.q == null) {
            xF0 xf0 = new xF0();
            xf0.a = true;
            xf0.h = 0;
            xf0.i = 0;
            xf0.k = null;
            this.q = xf0;
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean N() {
        return this.t;
    }

    public final int N0(C0738gs1 c0738gs1, xF0 xf0, ms1 ms1Var, boolean z) {
        int i;
        int i2 = xf0.c;
        int i3 = xf0.g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                xf0.g = i3 + i2;
            }
            c1(c0738gs1, xf0);
        }
        int i4 = xf0.c + xf0.h;
        while (true) {
            if ((!xf0.l && i4 <= 0) || (i = xf0.d) < 0 || i >= ms1Var.b()) {
                break;
            }
            wF0 wf0 = this.B;
            wf0.a = 0;
            wf0.b = false;
            wf0.c = false;
            wf0.d = false;
            a1(c0738gs1, ms1Var, xf0, wf0);
            if (!wf0.b) {
                int i5 = xf0.b;
                int i6 = wf0.a;
                xf0.b = (xf0.f * i6) + i5;
                if (!wf0.c || xf0.k != null || !ms1Var.g) {
                    xf0.c -= i6;
                    i4 -= i6;
                }
                int i7 = xf0.g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + i6;
                    xf0.g = i8;
                    int i9 = xf0.c;
                    if (i9 < 0) {
                        xf0.g = i8 + i9;
                    }
                    c1(c0738gs1, xf0);
                }
                if (z && wf0.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - xf0.c;
    }

    public final View O0(boolean z) {
        return this.u ? T0(0, v(), z, true) : T0(v() - 1, -1, z, true);
    }

    public final View P0(boolean z) {
        return this.u ? T0(v() - 1, -1, z, true) : T0(0, v(), z, true);
    }

    public final int Q0() {
        View viewT0 = T0(0, v(), false, true);
        if (viewT0 == null) {
            return -1;
        }
        return AbstractC0306Yr1.I(viewT0);
    }

    public final int R0() {
        View viewT0 = T0(v() - 1, -1, false, true);
        if (viewT0 == null) {
            return -1;
        }
        return AbstractC0306Yr1.I(viewT0);
    }

    public final View S0(int i, int i2) {
        int i3;
        int i4;
        M0();
        if (i2 <= i && i2 >= i) {
            return u(i);
        }
        if (this.r.e(u(i)) < this.r.j()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.p == 0 ? this.c.a(i, i2, i3, i4) : this.d.a(i, i2, i3, i4);
    }

    public final View T0(int i, int i2, boolean z, boolean z2) {
        M0();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.p == 0 ? this.c.a(i, i2, i3, i4) : this.d.a(i, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View U0(defpackage.C0738gs1 r17, defpackage.ms1 r18, boolean r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r16.M0()
            int r1 = r16.v()
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L15
            int r1 = r16.v()
            int r1 = r1 - r3
            r4 = -1
            r5 = r4
            goto L18
        L15:
            r4 = r1
            r1 = r2
            r5 = r3
        L18:
            int r6 = r18.b()
            A51 r7 = r0.r
            int r7 = r7.j()
            A51 r8 = r0.r
            int r8 = r8.g()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7c
            android.view.View r12 = r0.u(r1)
            int r13 = defpackage.AbstractC0306Yr1.I(r12)
            A51 r14 = r0.r
            int r14 = r14.e(r12)
            A51 r15 = r0.r
            int r15 = r15.b(r12)
            if (r13 < 0) goto L7a
            if (r13 >= r6) goto L7a
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            Zr1 r13 = (defpackage.C0321Zr1) r13
            ps1 r13 = r13.a
            boolean r13 = r13.m()
            if (r13 == 0) goto L57
            if (r11 != 0) goto L7a
            r11 = r12
            goto L7a
        L57:
            if (r15 > r7) goto L5d
            if (r14 >= r7) goto L5d
            r13 = r3
            goto L5e
        L5d:
            r13 = r2
        L5e:
            if (r14 < r8) goto L64
            if (r15 <= r8) goto L64
            r14 = r3
            goto L65
        L64:
            r14 = r2
        L65:
            if (r13 != 0) goto L6b
            if (r14 == 0) goto L6a
            goto L6b
        L6a:
            return r12
        L6b:
            if (r19 == 0) goto L73
            if (r14 == 0) goto L70
            goto L75
        L70:
            if (r9 != 0) goto L7a
            goto L79
        L73:
            if (r13 == 0) goto L77
        L75:
            r10 = r12
            goto L7a
        L77:
            if (r9 != 0) goto L7a
        L79:
            r9 = r12
        L7a:
            int r1 = r1 + r5
            goto L2b
        L7c:
            if (r9 == 0) goto L7f
            goto L84
        L7f:
            if (r10 == 0) goto L83
            r9 = r10
            goto L84
        L83:
            r9 = r11
        L84:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.U0(gs1, ms1, boolean, boolean):android.view.View");
    }

    @Override // defpackage.AbstractC0306Yr1
    public View V(View view, int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        int iL0;
        e1();
        if (v() == 0 || (iL0 = L0(i)) == Integer.MIN_VALUE) {
            return null;
        }
        M0();
        j1(iL0, (int) (this.r.k() * 0.33333334f), false, ms1Var);
        xF0 xf0 = this.q;
        xf0.g = Integer.MIN_VALUE;
        xf0.a = false;
        N0(c0738gs1, xf0, ms1Var, true);
        View viewS0 = iL0 == -1 ? this.u ? S0(v() - 1, -1) : S0(0, v()) : this.u ? S0(0, v()) : S0(v() - 1, -1);
        View viewY0 = iL0 == -1 ? Y0() : X0();
        if (!viewY0.hasFocusable()) {
            return viewS0;
        }
        if (viewS0 == null) {
            return null;
        }
        return viewY0;
    }

    public final int V0(int i, C0738gs1 c0738gs1, ms1 ms1Var, boolean z) {
        int iG;
        int iG2 = this.r.g() - i;
        if (iG2 <= 0) {
            return 0;
        }
        int i2 = -f1(-iG2, c0738gs1, ms1Var);
        int i3 = i + i2;
        if (!z || (iG = this.r.g() - i3) <= 0) {
            return i2;
        }
        this.r.o(iG);
        return iG + i2;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void W(AccessibilityEvent accessibilityEvent) {
        super.W(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(Q0());
            accessibilityEvent.setToIndex(R0());
        }
    }

    public final int W0(int i, C0738gs1 c0738gs1, ms1 ms1Var, boolean z) {
        int iJ;
        int iJ2 = i - this.r.j();
        if (iJ2 <= 0) {
            return 0;
        }
        int i2 = -f1(iJ2, c0738gs1, ms1Var);
        int i3 = i + i2;
        if (!z || (iJ = i3 - this.r.j()) <= 0) {
            return i2;
        }
        this.r.o(-iJ);
        return i2 - iJ;
    }

    @Override // defpackage.AbstractC0306Yr1
    public void X(C0738gs1 c0738gs1, ms1 ms1Var, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.X(c0738gs1, ms1Var, accessibilityNodeInfoCompat);
        Pr1 pr1 = this.b.F;
        if (pr1 == null || pr1.b() <= 0) {
            return;
        }
        accessibilityNodeInfoCompat.b(C0814i0.y);
    }

    public final View X0() {
        return u(this.u ? 0 : v() - 1);
    }

    public final View Y0() {
        return u(this.u ? v() - 1 : 0);
    }

    public final boolean Z0() {
        return this.b.getLayoutDirection() == 1;
    }

    @Override // defpackage.InterfaceC1053ls1
    public final PointF a(int i) {
        if (v() == 0) {
            return null;
        }
        int i2 = (i < AbstractC0306Yr1.I(u(0))) != this.u ? -1 : 1;
        return this.p == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    public void a1(C0738gs1 c0738gs1, ms1 ms1Var, xF0 xf0, wF0 wf0) {
        int iF;
        int i;
        int i2;
        int iD;
        View viewB = xf0.b(c0738gs1);
        if (viewB == null) {
            wf0.b = true;
            return;
        }
        C0321Zr1 c0321Zr1 = (C0321Zr1) viewB.getLayoutParams();
        if (xf0.k == null) {
            if (this.u == (xf0.f == -1)) {
                b(viewB, -1, false);
            } else {
                b(viewB, 0, false);
            }
        } else {
            if (this.u == (xf0.f == -1)) {
                b(viewB, -1, true);
            } else {
                b(viewB, 0, true);
            }
        }
        C0321Zr1 c0321Zr12 = (C0321Zr1) viewB.getLayoutParams();
        Rect rectP = this.b.P(viewB);
        int i3 = rectP.left + rectP.right;
        int i4 = rectP.top + rectP.bottom;
        int iW = AbstractC0306Yr1.w(d(), this.n, this.l, G() + F() + ((ViewGroup.MarginLayoutParams) c0321Zr12).leftMargin + ((ViewGroup.MarginLayoutParams) c0321Zr12).rightMargin + i3, ((ViewGroup.MarginLayoutParams) c0321Zr12).width);
        int iW2 = AbstractC0306Yr1.w(e(), this.o, this.m, E() + H() + ((ViewGroup.MarginLayoutParams) c0321Zr12).topMargin + ((ViewGroup.MarginLayoutParams) c0321Zr12).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) c0321Zr12).height);
        if (A0(viewB, iW, iW2, c0321Zr12)) {
            viewB.measure(iW, iW2);
        }
        wf0.a = this.r.c(viewB);
        if (this.p == 1) {
            if (Z0()) {
                iD = this.n - G();
                iF = iD - this.r.d(viewB);
            } else {
                iF = F();
                iD = this.r.d(viewB) + iF;
            }
            if (xf0.f == -1) {
                i = xf0.b;
                i2 = i - wf0.a;
            } else {
                i2 = xf0.b;
                i = wf0.a + i2;
            }
        } else {
            int iH = H();
            int iD2 = this.r.d(viewB) + iH;
            if (xf0.f == -1) {
                int i5 = xf0.b;
                int i6 = i5 - wf0.a;
                iD = i5;
                i = iD2;
                iF = i6;
                i2 = iH;
            } else {
                int i7 = xf0.b;
                int i8 = wf0.a + i7;
                iF = i7;
                i = iD2;
                i2 = iH;
                iD = i8;
            }
        }
        AbstractC0306Yr1.P(viewB, iF, i2, iD, i);
        if (c0321Zr1.a.m() || c0321Zr1.a.p()) {
            wf0.c = true;
        }
        wf0.d = viewB.hasFocusable();
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void c(String str) {
        if (this.z == null) {
            super.c(str);
        }
    }

    public final void c1(C0738gs1 c0738gs1, xF0 xf0) {
        if (!xf0.a || xf0.l) {
            return;
        }
        int i = xf0.g;
        int i2 = xf0.i;
        if (xf0.f == -1) {
            int iV = v();
            if (i < 0) {
                return;
            }
            int iF = (this.r.f() - i) + i2;
            if (this.u) {
                for (int i3 = 0; i3 < iV; i3++) {
                    View viewU = u(i3);
                    if (this.r.e(viewU) < iF || this.r.n(viewU) < iF) {
                        d1(c0738gs1, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = iV - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View viewU2 = u(i5);
                if (this.r.e(viewU2) < iF || this.r.n(viewU2) < iF) {
                    d1(c0738gs1, i4, i5);
                    return;
                }
            }
            return;
        }
        if (i < 0) {
            return;
        }
        int i6 = i - i2;
        int iV2 = v();
        if (!this.u) {
            for (int i7 = 0; i7 < iV2; i7++) {
                View viewU3 = u(i7);
                if (this.r.b(viewU3) > i6 || this.r.m(viewU3) > i6) {
                    d1(c0738gs1, 0, i7);
                    return;
                }
            }
            return;
        }
        int i8 = iV2 - 1;
        for (int i9 = i8; i9 >= 0; i9--) {
            View viewU4 = u(i9);
            if (this.r.b(viewU4) > i6 || this.r.m(viewU4) > i6) {
                d1(c0738gs1, i8, i9);
                return;
            }
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean d() {
        return this.p == 0;
    }

    public final void d1(C0738gs1 c0738gs1, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                View viewU = u(i);
                p0(i);
                c0738gs1.h(viewU);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            View viewU2 = u(i3);
            p0(i3);
            c0738gs1.h(viewU2);
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean e() {
        return this.p == 1;
    }

    public final void e1() {
        if (this.p == 1 || !Z0()) {
            this.u = this.t;
        } else {
            this.u = !this.t;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018a  */
    @Override // defpackage.AbstractC0306Yr1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f0(defpackage.C0738gs1 r18, defpackage.ms1 r19) {
        /*
            Method dump skipped, instruction units count: 1074
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.f0(gs1, ms1):void");
    }

    public final int f1(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        M0();
        this.q.a = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        j1(i2, iAbs, true, ms1Var);
        xF0 xf0 = this.q;
        int iN0 = N0(c0738gs1, xf0, ms1Var, false) + xf0.g;
        if (iN0 < 0) {
            return 0;
        }
        if (iAbs > iN0) {
            i = i2 * iN0;
        }
        this.r.o(-i);
        this.q.j = i;
        return i;
    }

    @Override // defpackage.AbstractC0306Yr1
    public void g0(ms1 ms1Var) {
        this.z = null;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.A.d();
    }

    public final void g1(int i, int i2) {
        this.x = i;
        this.y = i2;
        SavedState savedState = this.z;
        if (savedState != null) {
            savedState.t = -1;
        }
        r0();
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void h(int i, int i2, ms1 ms1Var, ol0 ol0Var) {
        if (this.p != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        M0();
        j1(i > 0 ? 1 : -1, Math.abs(i), true, ms1Var);
        H0(ms1Var, this.q, ol0Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void h0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.z = savedState;
            if (this.x != -1) {
                savedState.t = -1;
            }
            r0();
        }
    }

    public final void h1(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(AbstractC1214oR1.a(i, "invalid orientation:"));
        }
        c(null);
        if (i != this.p || this.r == null) {
            A51 a51A = A51.a(this, i);
            this.r = a51A;
            this.A.a = a51A;
            this.p = i;
            r0();
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void i(int i, ol0 ol0Var) {
        boolean z;
        int i2;
        SavedState savedState = this.z;
        if (savedState == null || (i2 = savedState.t) < 0) {
            e1();
            z = this.u;
            i2 = this.x;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = savedState.v;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.C && i2 >= 0 && i2 < i; i4++) {
            ol0Var.a(i2, 0);
            i2 += i3;
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final Parcelable i0() {
        SavedState savedState = this.z;
        if (savedState != null) {
            SavedState savedState2 = new SavedState();
            savedState2.t = savedState.t;
            savedState2.u = savedState.u;
            savedState2.v = savedState.v;
            return savedState2;
        }
        SavedState savedState3 = new SavedState();
        if (v() > 0) {
            M0();
            boolean z = this.s ^ this.u;
            savedState3.v = z;
            if (z) {
                View viewX0 = X0();
                savedState3.u = this.r.g() - this.r.b(viewX0);
                savedState3.t = AbstractC0306Yr1.I(viewX0);
            } else {
                View viewY0 = Y0();
                savedState3.t = AbstractC0306Yr1.I(viewY0);
                savedState3.u = this.r.e(viewY0) - this.r.j();
            }
        } else {
            savedState3.t = -1;
        }
        return savedState3;
    }

    public void i1(boolean z) {
        c(null);
        if (this.v == z) {
            return;
        }
        this.v = z;
        r0();
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int j(ms1 ms1Var) {
        return I0(ms1Var);
    }

    public final void j1(int i, int i2, boolean z, ms1 ms1Var) {
        int iJ;
        this.q.l = this.r.i() == 0 && this.r.f() == 0;
        this.q.f = i;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        G0(ms1Var, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z2 = i == 1;
        xF0 xf0 = this.q;
        int i3 = z2 ? iMax2 : iMax;
        xf0.h = i3;
        if (!z2) {
            iMax = iMax2;
        }
        xf0.i = iMax;
        if (z2) {
            xf0.h = this.r.h() + i3;
            View viewX0 = X0();
            xF0 xf02 = this.q;
            xf02.e = this.u ? -1 : 1;
            int I = AbstractC0306Yr1.I(viewX0);
            xF0 xf03 = this.q;
            xf02.d = I + xf03.e;
            xf03.b = this.r.b(viewX0);
            iJ = this.r.b(viewX0) - this.r.g();
        } else {
            View viewY0 = Y0();
            xF0 xf04 = this.q;
            xf04.h = this.r.j() + xf04.h;
            xF0 xf05 = this.q;
            xf05.e = this.u ? 1 : -1;
            int I2 = AbstractC0306Yr1.I(viewY0);
            xF0 xf06 = this.q;
            xf05.d = I2 + xf06.e;
            xf06.b = this.r.e(viewY0);
            iJ = (-this.r.e(viewY0)) + this.r.j();
        }
        xF0 xf07 = this.q;
        xf07.c = i2;
        if (z) {
            xf07.c = i2 - iJ;
        }
        xf07.g = iJ;
    }

    @Override // defpackage.AbstractC0306Yr1
    public int k(ms1 ms1Var) {
        return J0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public boolean k0(int i, Bundle bundle) {
        int iMin;
        if (super.k0(i, bundle)) {
            return true;
        }
        if (i == 16908343 && bundle != null) {
            if (this.p == 1) {
                int i2 = bundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
                if (i2 < 0) {
                    return false;
                }
                RecyclerView recyclerView = this.b;
                iMin = Math.min(i2, K(recyclerView.v, recyclerView.B0) - 1);
            } else {
                int i3 = bundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
                if (i3 < 0) {
                    return false;
                }
                RecyclerView recyclerView2 = this.b;
                iMin = Math.min(i3, x(recyclerView2.v, recyclerView2.B0) - 1);
            }
            if (iMin >= 0) {
                g1(iMin, 0);
                return true;
            }
        }
        return false;
    }

    public final void k1(int i, int i2) {
        this.q.c = this.r.g() - i2;
        xF0 xf0 = this.q;
        xf0.e = this.u ? -1 : 1;
        xf0.d = i;
        xf0.f = 1;
        xf0.b = i2;
        xf0.g = Integer.MIN_VALUE;
    }

    @Override // defpackage.AbstractC0306Yr1
    public int l(ms1 ms1Var) {
        return K0(ms1Var);
    }

    public final void l1(int i, int i2) {
        this.q.c = i2 - this.r.j();
        xF0 xf0 = this.q;
        xf0.d = i;
        xf0.e = this.u ? 1 : -1;
        xf0.f = -1;
        xf0.b = i2;
        xf0.g = Integer.MIN_VALUE;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int m(ms1 ms1Var) {
        return I0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public int n(ms1 ms1Var) {
        return J0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public int o(ms1 ms1Var) {
        return K0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final View q(int i) {
        int iV = v();
        if (iV == 0) {
            return null;
        }
        int I = i - AbstractC0306Yr1.I(u(0));
        if (I >= 0 && I < iV) {
            View viewU = u(I);
            if (AbstractC0306Yr1.I(viewU) == i) {
                return viewU;
            }
        }
        return super.q(i);
    }

    @Override // defpackage.AbstractC0306Yr1
    public C0321Zr1 r() {
        return new C0321Zr1(-2, -2);
    }

    @Override // defpackage.AbstractC0306Yr1
    public int s0(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        if (this.p == 1) {
            return 0;
        }
        return f1(i, c0738gs1, ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void t0(int i) {
        this.x = i;
        this.y = Integer.MIN_VALUE;
        SavedState savedState = this.z;
        if (savedState != null) {
            savedState.t = -1;
        }
        r0();
    }

    @Override // defpackage.AbstractC0306Yr1
    public int u0(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        if (this.p == 0) {
            return 0;
        }
        return f1(i, c0738gs1, ms1Var);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.z = null;
        this.A = new vF0();
        this.B = new wF0();
        this.C = 2;
        this.D = new int[2];
        C0294Xr1 c0294Xr1J = AbstractC0306Yr1.J(context, attributeSet, i, i2);
        h1(c0294Xr1J.a);
        boolean z = c0294Xr1J.c;
        c(null);
        if (z != this.t) {
            this.t = z;
            r0();
        }
        i1(c0294Xr1J.d);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void U(RecyclerView recyclerView) {
    }

    public void b1(C0738gs1 c0738gs1, ms1 ms1Var, vF0 vf0, int i) {
    }
}
