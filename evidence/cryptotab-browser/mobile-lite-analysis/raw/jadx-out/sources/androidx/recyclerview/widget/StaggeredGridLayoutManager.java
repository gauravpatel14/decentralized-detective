package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.api.Api;
import defpackage.A51;
import defpackage.AF0;
import defpackage.AbstractC0306Yr1;
import defpackage.AbstractC0604eo2;
import defpackage.C0294Xr1;
import defpackage.C0321Zr1;
import defpackage.C0738gs1;
import defpackage.FA1;
import defpackage.IN1;
import defpackage.InterfaceC1053ls1;
import defpackage.JN1;
import defpackage.KN1;
import defpackage.LN1;
import defpackage.MN1;
import defpackage.NN1;
import defpackage.eE0;
import defpackage.m0;
import defpackage.ms1;
import defpackage.ol0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends AbstractC0306Yr1 implements InterfaceC1053ls1 {
    public final MN1 B;
    public final int C;
    public boolean D;
    public boolean E;
    public SavedState F;
    public final Rect G;
    public final JN1 H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int[] f20J;
    public final IN1 K;
    public final int p;
    public final NN1[] q;
    public final A51 r;
    public final A51 s;
    public final int t;
    public int u;
    public final eE0 v;
    public boolean w;
    public final BitSet y;
    public boolean x = false;
    public int z = -1;
    public int A = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SuppressLint({"BanParcelableUsage"})
    public class SavedState implements Parcelable {
        public static final Parcelable.Creator CREATOR = new LN1(1);
        public boolean A;
        public boolean B;
        public boolean C;
        public int t;
        public int u;
        public int v;
        public int[] w;
        public int x;
        public int[] y;
        public ArrayList z;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.t);
            parcel.writeInt(this.u);
            parcel.writeInt(this.v);
            if (this.v > 0) {
                parcel.writeIntArray(this.w);
            }
            parcel.writeInt(this.x);
            if (this.x > 0) {
                parcel.writeIntArray(this.y);
            }
            parcel.writeInt(this.A ? 1 : 0);
            parcel.writeInt(this.B ? 1 : 0);
            parcel.writeInt(this.C ? 1 : 0);
            parcel.writeList(this.z);
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = -1;
        this.w = false;
        MN1 mn1 = new MN1();
        this.B = mn1;
        this.C = 2;
        this.G = new Rect();
        this.H = new JN1(this);
        this.I = true;
        this.K = new IN1(this);
        C0294Xr1 c0294Xr1J = AbstractC0306Yr1.J(context, attributeSet, i, i2);
        int i3 = c0294Xr1J.a;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i3 != this.t) {
            this.t = i3;
            A51 a51 = this.r;
            this.r = this.s;
            this.s = a51;
            r0();
        }
        int i4 = c0294Xr1J.b;
        c(null);
        if (i4 != this.p) {
            mn1.a();
            r0();
            this.p = i4;
            this.y = new BitSet(this.p);
            this.q = new NN1[this.p];
            for (int i5 = 0; i5 < this.p; i5++) {
                this.q[i5] = new NN1(this, i5);
            }
            r0();
        }
        boolean z = c0294Xr1J.c;
        c(null);
        SavedState savedState = this.F;
        if (savedState != null && savedState.A != z) {
            savedState.A = z;
        }
        this.w = z;
        r0();
        eE0 ee0 = new eE0();
        ee0.a = true;
        ee0.f = 0;
        ee0.g = 0;
        this.v = ee0;
        this.r = A51.a(this, this.t);
        this.s = A51.a(this, 1 - this.t);
    }

    public static int j1(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void D0(int i, RecyclerView recyclerView) {
        AF0 af0 = new AF0(recyclerView.getContext());
        af0.a = i;
        E0(af0);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean F0() {
        return this.F == null;
    }

    public final int G0(int i) {
        if (v() == 0) {
            return this.x ? 1 : -1;
        }
        return (i < Q0()) != this.x ? -1 : 1;
    }

    public final boolean H0() {
        int iQ0;
        if (v() != 0 && this.C != 0 && this.g) {
            if (this.x) {
                iQ0 = R0();
                Q0();
            } else {
                iQ0 = Q0();
                R0();
            }
            MN1 mn1 = this.B;
            if (iQ0 == 0 && V0() != null) {
                mn1.a();
                this.f = true;
                r0();
                return true;
            }
        }
        return false;
    }

    public final int I0(ms1 ms1Var) {
        if (v() == 0) {
            return 0;
        }
        A51 a51 = this.r;
        boolean z = !this.I;
        return FA1.a(ms1Var, a51, N0(z), M0(z), this, this.I);
    }

    public final int J0(ms1 ms1Var) {
        if (v() == 0) {
            return 0;
        }
        A51 a51 = this.r;
        boolean z = !this.I;
        return FA1.b(ms1Var, a51, N0(z), M0(z), this, this.I, this.x);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int K(C0738gs1 c0738gs1, ms1 ms1Var) {
        if (this.t == 0) {
            return Math.min(this.p, ms1Var.b());
        }
        return -1;
    }

    public final int K0(ms1 ms1Var) {
        if (v() == 0) {
            return 0;
        }
        A51 a51 = this.r;
        boolean z = !this.I;
        return FA1.c(ms1Var, a51, N0(z), M0(z), this, this.I);
    }

    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean, int] */
    public final int L0(C0738gs1 c0738gs1, eE0 ee0, ms1 ms1Var) {
        NN1 nn1;
        ?? r6;
        int i;
        int iH;
        int iC;
        int iJ;
        int iC2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 1;
        this.y.set(0, this.p, true);
        eE0 ee02 = this.v;
        int i8 = ee02.i ? ee0.e == 1 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : Integer.MIN_VALUE : ee0.e == 1 ? ee0.g + ee0.b : ee0.f - ee0.b;
        int i9 = ee0.e;
        for (int i10 = 0; i10 < this.p; i10++) {
            if (!this.q[i10].a.isEmpty()) {
                i1(this.q[i10], i9, i8);
            }
        }
        int iG = this.x ? this.r.g() : this.r.j();
        boolean z = false;
        while (true) {
            int i11 = ee0.c;
            if (((i11 < 0 || i11 >= ms1Var.b()) ? i6 : i7) == 0 || (!ee02.i && this.y.isEmpty())) {
                break;
            }
            View view = c0738gs1.k(ee0.c, Long.MAX_VALUE).t;
            ee0.c += ee0.d;
            KN1 kn1 = (KN1) view.getLayoutParams();
            int iF = kn1.a.f();
            MN1 mn1 = this.B;
            int[] iArr = mn1.a;
            int i12 = (iArr == null || iF >= iArr.length) ? -1 : iArr[iF];
            if (i12 == -1) {
                if (Z0(ee0.e)) {
                    i5 = this.p - i7;
                    i4 = -1;
                    i3 = -1;
                } else {
                    i3 = i7;
                    i4 = this.p;
                    i5 = i6;
                }
                NN1 nn12 = null;
                if (ee0.e == i7) {
                    int iJ2 = this.r.j();
                    int i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    while (i5 != i4) {
                        NN1 nn13 = this.q[i5];
                        int iF2 = nn13.f(iJ2);
                        if (iF2 < i13) {
                            i13 = iF2;
                            nn12 = nn13;
                        }
                        i5 += i3;
                    }
                } else {
                    int iG2 = this.r.g();
                    int i14 = Integer.MIN_VALUE;
                    while (i5 != i4) {
                        NN1 nn14 = this.q[i5];
                        int iH2 = nn14.h(iG2);
                        if (iH2 > i14) {
                            nn12 = nn14;
                            i14 = iH2;
                        }
                        i5 += i3;
                    }
                }
                nn1 = nn12;
                mn1.b(iF);
                mn1.a[iF] = nn1.e;
            } else {
                nn1 = this.q[i12];
            }
            kn1.e = nn1;
            if (ee0.e == 1) {
                r6 = 0;
                b(view, -1, false);
            } else {
                r6 = 0;
                b(view, 0, false);
            }
            if (this.t == 1) {
                i = 1;
                X0(view, AbstractC0306Yr1.w(r6, this.u, this.l, r6, ((ViewGroup.MarginLayoutParams) kn1).width), AbstractC0306Yr1.w(true, this.o, this.m, E() + H(), ((ViewGroup.MarginLayoutParams) kn1).height));
            } else {
                i = 1;
                X0(view, AbstractC0306Yr1.w(true, this.n, this.l, G() + F(), ((ViewGroup.MarginLayoutParams) kn1).width), AbstractC0306Yr1.w(false, this.u, this.m, 0, ((ViewGroup.MarginLayoutParams) kn1).height));
            }
            if (ee0.e == i) {
                iC = nn1.f(iG);
                iH = this.r.c(view) + iC;
            } else {
                iH = nn1.h(iG);
                iC = iH - this.r.c(view);
            }
            if (ee0.e == 1) {
                NN1 nn15 = kn1.e;
                nn15.getClass();
                KN1 kn12 = (KN1) view.getLayoutParams();
                kn12.e = nn15;
                ArrayList arrayList = nn15.a;
                arrayList.add(view);
                nn15.c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    nn15.b = Integer.MIN_VALUE;
                }
                if (kn12.a.m() || kn12.a.p()) {
                    nn15.d = nn15.f.r.c(view) + nn15.d;
                }
            } else {
                NN1 nn16 = kn1.e;
                nn16.getClass();
                KN1 kn13 = (KN1) view.getLayoutParams();
                kn13.e = nn16;
                ArrayList arrayList2 = nn16.a;
                arrayList2.add(0, view);
                nn16.b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    nn16.c = Integer.MIN_VALUE;
                }
                if (kn13.a.m() || kn13.a.p()) {
                    nn16.d = nn16.f.r.c(view) + nn16.d;
                }
            }
            if (W0() && this.t == 1) {
                iC2 = this.s.g() - (((this.p - 1) - nn1.e) * this.u);
                iJ = iC2 - this.s.c(view);
            } else {
                iJ = this.s.j() + (nn1.e * this.u);
                iC2 = this.s.c(view) + iJ;
            }
            if (this.t == 1) {
                AbstractC0306Yr1.P(view, iJ, iC, iC2, iH);
            } else {
                AbstractC0306Yr1.P(view, iC, iJ, iH, iC2);
            }
            i1(nn1, ee02.e, i8);
            b1(c0738gs1, ee02);
            if (ee02.h && view.hasFocusable()) {
                i2 = 0;
                this.y.set(nn1.e, false);
            } else {
                i2 = 0;
            }
            i6 = i2;
            i7 = 1;
            z = true;
        }
        int i15 = i6;
        if (!z) {
            b1(c0738gs1, ee02);
        }
        int iJ3 = ee02.e == -1 ? this.r.j() - T0(this.r.j()) : S0(this.r.g()) - this.r.g();
        return iJ3 > 0 ? Math.min(ee0.b, iJ3) : i15;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean M() {
        return this.C != 0;
    }

    public final View M0(boolean z) {
        int iJ = this.r.j();
        int iG = this.r.g();
        View view = null;
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            int iE = this.r.e(viewU);
            int iB = this.r.b(viewU);
            if (iB > iJ && iE < iG) {
                if (iB <= iG || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean N() {
        return this.w;
    }

    public final View N0(boolean z) {
        int iJ = this.r.j();
        int iG = this.r.g();
        int iV = v();
        View view = null;
        for (int i = 0; i < iV; i++) {
            View viewU = u(i);
            int iE = this.r.e(viewU);
            if (this.r.b(viewU) > iJ && iE < iG) {
                if (iE >= iJ || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final void O0(C0738gs1 c0738gs1, ms1 ms1Var, boolean z) {
        int iG;
        int iS0 = S0(Integer.MIN_VALUE);
        if (iS0 != Integer.MIN_VALUE && (iG = this.r.g() - iS0) > 0) {
            int i = iG - (-f1(-iG, c0738gs1, ms1Var));
            if (!z || i <= 0) {
                return;
            }
            this.r.o(i);
        }
    }

    public final void P0(C0738gs1 c0738gs1, ms1 ms1Var, boolean z) {
        int iJ;
        int iT0 = T0(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (iT0 != Integer.MAX_VALUE && (iJ = iT0 - this.r.j()) > 0) {
            int iF1 = iJ - f1(iJ, c0738gs1, ms1Var);
            if (!z || iF1 <= 0) {
                return;
            }
            this.r.o(-iF1);
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void Q(int i) {
        super.Q(i);
        for (int i2 = 0; i2 < this.p; i2++) {
            NN1 nn1 = this.q[i2];
            int i3 = nn1.b;
            if (i3 != Integer.MIN_VALUE) {
                nn1.b = i3 + i;
            }
            int i4 = nn1.c;
            if (i4 != Integer.MIN_VALUE) {
                nn1.c = i4 + i;
            }
        }
    }

    public final int Q0() {
        if (v() == 0) {
            return 0;
        }
        return AbstractC0306Yr1.I(u(0));
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void R(int i) {
        super.R(i);
        for (int i2 = 0; i2 < this.p; i2++) {
            NN1 nn1 = this.q[i2];
            int i3 = nn1.b;
            if (i3 != Integer.MIN_VALUE) {
                nn1.b = i3 + i;
            }
            int i4 = nn1.c;
            if (i4 != Integer.MIN_VALUE) {
                nn1.c = i4 + i;
            }
        }
    }

    public final int R0() {
        int iV = v();
        if (iV == 0) {
            return 0;
        }
        return AbstractC0306Yr1.I(u(iV - 1));
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void S() {
        this.B.a();
        for (int i = 0; i < this.p; i++) {
            this.q[i].b();
        }
    }

    public final int S0(int i) {
        int iF = this.q[0].f(i);
        for (int i2 = 1; i2 < this.p; i2++) {
            int iF2 = this.q[i2].f(i);
            if (iF2 > iF) {
                iF = iF2;
            }
        }
        return iF;
    }

    public final int T0(int i) {
        int iH = this.q[0].h(i);
        for (int i2 = 1; i2 < this.p; i2++) {
            int iH2 = this.q[i2].h(i);
            if (iH2 < iH) {
                iH = iH2;
            }
        }
        return iH;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void U(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.K);
        }
        for (int i = 0; i < this.p; i++) {
            this.q[i].b();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U0(int r11, int r12, int r13) {
        /*
            r10 = this;
            boolean r0 = r10.x
            if (r0 == 0) goto L9
            int r0 = r10.R0()
            goto Ld
        L9:
            int r0 = r10.Q0()
        Ld:
            r1 = 8
            if (r13 != r1) goto L1b
            if (r11 >= r12) goto L17
            int r2 = r12 + 1
        L15:
            r3 = r11
            goto L1e
        L17:
            int r2 = r11 + 1
            r3 = r12
            goto L1e
        L1b:
            int r2 = r11 + r12
            goto L15
        L1e:
            MN1 r4 = r10.B
            int[] r5 = r4.a
            r6 = -1
            if (r5 != 0) goto L27
            goto L9b
        L27:
            int r5 = r5.length
            if (r3 < r5) goto L2c
            goto L9b
        L2c:
            java.util.ArrayList r5 = r4.b
            if (r5 != 0) goto L32
        L30:
            r5 = r6
            goto L81
        L32:
            r7 = 0
            if (r5 != 0) goto L36
            goto L4f
        L36:
            int r5 = r5.size()
            int r5 = r5 + (-1)
        L3c:
            if (r5 < 0) goto L4f
            java.util.ArrayList r8 = r4.b
            java.lang.Object r8 = r8.get(r5)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) r8
            int r9 = r8.t
            if (r9 != r3) goto L4c
            r7 = r8
            goto L4f
        L4c:
            int r5 = r5 + (-1)
            goto L3c
        L4f:
            if (r7 == 0) goto L56
            java.util.ArrayList r5 = r4.b
            r5.remove(r7)
        L56:
            java.util.ArrayList r5 = r4.b
            int r5 = r5.size()
            r7 = 0
        L5d:
            if (r7 >= r5) goto L6f
            java.util.ArrayList r8 = r4.b
            java.lang.Object r8 = r8.get(r7)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) r8
            int r8 = r8.t
            if (r8 < r3) goto L6c
            goto L70
        L6c:
            int r7 = r7 + 1
            goto L5d
        L6f:
            r7 = r6
        L70:
            if (r7 == r6) goto L30
            java.util.ArrayList r5 = r4.b
            java.lang.Object r5 = r5.get(r7)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r5 = (androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) r5
            java.util.ArrayList r8 = r4.b
            r8.remove(r7)
            int r5 = r5.t
        L81:
            if (r5 != r6) goto L8d
            int[] r5 = r4.a
            int r7 = r5.length
            java.util.Arrays.fill(r5, r3, r7, r6)
            int[] r5 = r4.a
            int r5 = r5.length
            goto L9b
        L8d:
            int r5 = r5 + 1
            int[] r7 = r4.a
            int r7 = r7.length
            int r5 = java.lang.Math.min(r5, r7)
            int[] r7 = r4.a
            java.util.Arrays.fill(r7, r3, r5, r6)
        L9b:
            r5 = 1
            if (r13 == r5) goto Laf
            r6 = 2
            if (r13 == r6) goto Lab
            if (r13 == r1) goto La4
            goto Lb2
        La4:
            r4.d(r11, r5)
            r4.c(r12, r5)
            goto Lb2
        Lab:
            r4.d(r11, r12)
            goto Lb2
        Laf:
            r4.c(r11, r12)
        Lb2:
            if (r2 > r0) goto Lb5
            return
        Lb5:
            boolean r11 = r10.x
            if (r11 == 0) goto Lbe
            int r11 = r10.Q0()
            goto Lc2
        Lbe:
            int r11 = r10.R0()
        Lc2:
            if (r3 > r11) goto Lc7
            r10.r0()
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U0(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0061  */
    @Override // defpackage.AbstractC0306Yr1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View V(android.view.View r9, int r10, defpackage.C0738gs1 r11, defpackage.ms1 r12) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.V(android.view.View, int, gs1, ms1):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View V0() {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.V0():android.view.View");
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void W(AccessibilityEvent accessibilityEvent) {
        super.W(accessibilityEvent);
        if (v() > 0) {
            View viewN0 = N0(false);
            View viewM0 = M0(false);
            if (viewN0 == null || viewM0 == null) {
                return;
            }
            int I = AbstractC0306Yr1.I(viewN0);
            int I2 = AbstractC0306Yr1.I(viewM0);
            if (I < I2) {
                accessibilityEvent.setFromIndex(I);
                accessibilityEvent.setToIndex(I2);
            } else {
                accessibilityEvent.setFromIndex(I2);
                accessibilityEvent.setToIndex(I);
            }
        }
    }

    public final boolean W0() {
        return this.b.getLayoutDirection() == 1;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void X(C0738gs1 c0738gs1, ms1 ms1Var, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.X(c0738gs1, ms1Var, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.k("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    public final void X0(View view, int i, int i2) {
        RecyclerView recyclerView = this.b;
        Rect rect = this.G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.P(view));
        }
        KN1 kn1 = (KN1) view.getLayoutParams();
        int iJ1 = j1(i, ((ViewGroup.MarginLayoutParams) kn1).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) kn1).rightMargin + rect.right);
        int iJ12 = j1(i2, ((ViewGroup.MarginLayoutParams) kn1).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) kn1).bottomMargin + rect.bottom);
        if (A0(view, iJ1, iJ12, kn1)) {
            view.measure(iJ1, iJ12);
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void Y(C0738gs1 c0738gs1, ms1 ms1Var, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof KN1)) {
            Z(view, accessibilityNodeInfoCompat);
            return;
        }
        KN1 kn1 = (KN1) layoutParams;
        if (this.t == 0) {
            NN1 nn1 = kn1.e;
            accessibilityNodeInfoCompat.l(m0.a(false, nn1 == null ? -1 : nn1.e, 1, -1, -1));
        } else {
            NN1 nn12 = kn1.e;
            accessibilityNodeInfoCompat.l(m0.a(false, -1, -1, nn12 == null ? -1 : nn12.e, 1));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0405  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y0(defpackage.C0738gs1 r17, defpackage.ms1 r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 1056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Y0(gs1, ms1, boolean):void");
    }

    public final boolean Z0(int i) {
        if (this.t == 0) {
            return (i == -1) != this.x;
        }
        return ((i == -1) == this.x) == W0();
    }

    @Override // defpackage.InterfaceC1053ls1
    public final PointF a(int i) {
        int iG0 = G0(i);
        PointF pointF = new PointF();
        if (iG0 == 0) {
            return null;
        }
        if (this.t == 0) {
            pointF.x = iG0;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iG0;
        }
        return pointF;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void a0(int i, int i2) {
        U0(i, i2, 1);
    }

    public final void a1(int i, ms1 ms1Var) {
        int iQ0;
        int i2;
        if (i > 0) {
            iQ0 = R0();
            i2 = 1;
        } else {
            iQ0 = Q0();
            i2 = -1;
        }
        eE0 ee0 = this.v;
        ee0.a = true;
        h1(iQ0, ms1Var);
        g1(i2);
        ee0.c = iQ0 + ee0.d;
        ee0.b = Math.abs(i);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void b0() {
        this.B.a();
        r0();
    }

    public final void b1(C0738gs1 c0738gs1, eE0 ee0) {
        if (!ee0.a || ee0.i) {
            return;
        }
        if (ee0.b == 0) {
            if (ee0.e == -1) {
                c1(c0738gs1, ee0.g);
                return;
            } else {
                d1(c0738gs1, ee0.f);
                return;
            }
        }
        int i = 1;
        if (ee0.e == -1) {
            int i2 = ee0.f;
            int iH = this.q[0].h(i2);
            while (i < this.p) {
                int iH2 = this.q[i].h(i2);
                if (iH2 > iH) {
                    iH = iH2;
                }
                i++;
            }
            int i3 = i2 - iH;
            c1(c0738gs1, i3 < 0 ? ee0.g : ee0.g - Math.min(i3, ee0.b));
            return;
        }
        int i4 = ee0.g;
        int iF = this.q[0].f(i4);
        while (i < this.p) {
            int iF2 = this.q[i].f(i4);
            if (iF2 < iF) {
                iF = iF2;
            }
            i++;
        }
        int i5 = iF - ee0.g;
        d1(c0738gs1, i5 < 0 ? ee0.f : Math.min(i5, ee0.b) + ee0.f);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void c0(int i, int i2) {
        U0(i, i2, 8);
    }

    public final void c1(C0738gs1 c0738gs1, int i) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            if (this.r.e(viewU) < i || this.r.n(viewU) < i) {
                return;
            }
            KN1 kn1 = (KN1) viewU.getLayoutParams();
            kn1.getClass();
            if (kn1.e.a.size() == 1) {
                return;
            }
            NN1 nn1 = kn1.e;
            ArrayList arrayList = nn1.a;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            KN1 kn12 = (KN1) view.getLayoutParams();
            kn12.e = null;
            if (kn12.a.m() || kn12.a.p()) {
                nn1.d -= nn1.f.r.c(view);
            }
            if (size == 1) {
                nn1.b = Integer.MIN_VALUE;
            }
            nn1.c = Integer.MIN_VALUE;
            o0(viewU);
            c0738gs1.h(viewU);
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean d() {
        return this.t == 0;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void d0(int i, int i2) {
        U0(i, i2, 2);
    }

    public final void d1(C0738gs1 c0738gs1, int i) {
        while (v() > 0) {
            View viewU = u(0);
            if (this.r.b(viewU) > i || this.r.m(viewU) > i) {
                return;
            }
            KN1 kn1 = (KN1) viewU.getLayoutParams();
            kn1.getClass();
            if (kn1.e.a.size() == 1) {
                return;
            }
            NN1 nn1 = kn1.e;
            ArrayList arrayList = nn1.a;
            View view = (View) arrayList.remove(0);
            KN1 kn12 = (KN1) view.getLayoutParams();
            kn12.e = null;
            if (arrayList.size() == 0) {
                nn1.c = Integer.MIN_VALUE;
            }
            if (kn12.a.m() || kn12.a.p()) {
                nn1.d -= nn1.f.r.c(view);
            }
            nn1.b = Integer.MIN_VALUE;
            o0(viewU);
            c0738gs1.h(viewU);
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean e() {
        return this.t == 1;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void e0(int i, int i2) {
        U0(i, i2, 4);
    }

    public final void e1() {
        if (this.t == 1 || !W0()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final boolean f(C0321Zr1 c0321Zr1) {
        return c0321Zr1 instanceof KN1;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void f0(C0738gs1 c0738gs1, ms1 ms1Var) {
        Y0(c0738gs1, ms1Var, true);
    }

    public final int f1(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        a1(i, ms1Var);
        eE0 ee0 = this.v;
        int iL0 = L0(c0738gs1, ee0, ms1Var);
        if (ee0.b >= iL0) {
            i = i < 0 ? -iL0 : iL0;
        }
        this.r.o(-i);
        this.D = this.x;
        ee0.b = 0;
        b1(c0738gs1, ee0);
        return i;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void g0(ms1 ms1Var) {
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    public final void g1(int i) {
        eE0 ee0 = this.v;
        ee0.e = i;
        ee0.d = this.x != (i == -1) ? -1 : 1;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void h(int i, int i2, ms1 ms1Var, ol0 ol0Var) {
        eE0 ee0;
        int iF;
        int iH;
        if (this.t != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        a1(i, ms1Var);
        int[] iArr = this.f20J;
        if (iArr == null || iArr.length < this.p) {
            this.f20J = new int[this.p];
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = this.p;
            ee0 = this.v;
            if (i3 >= i5) {
                break;
            }
            if (ee0.d == -1) {
                iF = ee0.f;
                iH = this.q[i3].h(iF);
            } else {
                iF = this.q[i3].f(ee0.g);
                iH = ee0.g;
            }
            int i6 = iF - iH;
            if (i6 >= 0) {
                this.f20J[i4] = i6;
                i4++;
            }
            i3++;
        }
        Arrays.sort(this.f20J, 0, i4);
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = ee0.c;
            if (i8 < 0 || i8 >= ms1Var.b()) {
                return;
            }
            ol0Var.a(ee0.c, this.f20J[i7]);
            ee0.c += ee0.d;
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void h0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.F = savedState;
            if (this.z != -1) {
                savedState.w = null;
                savedState.v = 0;
                savedState.t = -1;
                savedState.u = -1;
                savedState.w = null;
                savedState.v = 0;
                savedState.x = 0;
                savedState.y = null;
                savedState.z = null;
            }
            r0();
        }
    }

    public final void h1(int i, ms1 ms1Var) {
        int iK;
        int iK2;
        int i2;
        eE0 ee0 = this.v;
        boolean z = false;
        ee0.b = 0;
        ee0.c = i;
        AF0 af0 = this.e;
        if (!(af0 != null && af0.e) || (i2 = ms1Var.a) == -1) {
            iK = 0;
            iK2 = 0;
        } else {
            if (this.x == (i2 < i)) {
                iK = this.r.k();
                iK2 = 0;
            } else {
                iK2 = this.r.k();
                iK = 0;
            }
        }
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || !recyclerView.A) {
            ee0.g = this.r.f() + iK;
            ee0.f = -iK2;
        } else {
            ee0.f = this.r.j() - iK2;
            ee0.g = this.r.g() + iK;
        }
        ee0.h = false;
        ee0.a = true;
        if (this.r.i() == 0 && this.r.f() == 0) {
            z = true;
        }
        ee0.i = z;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final Parcelable i0() {
        int iH;
        int iJ;
        int[] iArr;
        SavedState savedState = this.F;
        if (savedState != null) {
            SavedState savedState2 = new SavedState();
            savedState2.v = savedState.v;
            savedState2.t = savedState.t;
            savedState2.u = savedState.u;
            savedState2.w = savedState.w;
            savedState2.x = savedState.x;
            savedState2.y = savedState.y;
            savedState2.A = savedState.A;
            savedState2.B = savedState.B;
            savedState2.C = savedState.C;
            savedState2.z = savedState.z;
            return savedState2;
        }
        SavedState savedState3 = new SavedState();
        savedState3.A = this.w;
        savedState3.B = this.D;
        savedState3.C = this.E;
        MN1 mn1 = this.B;
        if (mn1 == null || (iArr = mn1.a) == null) {
            savedState3.x = 0;
        } else {
            savedState3.y = iArr;
            savedState3.x = iArr.length;
            savedState3.z = mn1.b;
        }
        if (v() > 0) {
            savedState3.t = this.D ? R0() : Q0();
            View viewM0 = this.x ? M0(true) : N0(true);
            savedState3.u = viewM0 != null ? AbstractC0306Yr1.I(viewM0) : -1;
            int i = this.p;
            savedState3.v = i;
            savedState3.w = new int[i];
            for (int i2 = 0; i2 < this.p; i2++) {
                if (this.D) {
                    iH = this.q[i2].f(Integer.MIN_VALUE);
                    if (iH != Integer.MIN_VALUE) {
                        iJ = this.r.g();
                        iH -= iJ;
                    }
                } else {
                    iH = this.q[i2].h(Integer.MIN_VALUE);
                    if (iH != Integer.MIN_VALUE) {
                        iJ = this.r.j();
                        iH -= iJ;
                    }
                }
                savedState3.w[i2] = iH;
            }
        } else {
            savedState3.t = -1;
            savedState3.u = -1;
            savedState3.v = 0;
        }
        return savedState3;
    }

    public final void i1(NN1 nn1, int i, int i2) {
        int i3 = nn1.d;
        int i4 = nn1.e;
        if (i != -1) {
            int i5 = nn1.c;
            if (i5 == Integer.MIN_VALUE) {
                nn1.a();
                i5 = nn1.c;
            }
            if (i5 - i3 >= i2) {
                this.y.set(i4, false);
                return;
            }
            return;
        }
        int i6 = nn1.b;
        if (i6 == Integer.MIN_VALUE) {
            View view = (View) nn1.a.get(0);
            KN1 kn1 = (KN1) view.getLayoutParams();
            nn1.b = nn1.f.r.e(view);
            kn1.getClass();
            i6 = nn1.b;
        }
        if (i6 + i3 <= i2) {
            this.y.set(i4, false);
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int j(ms1 ms1Var) {
        return I0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void j0(int i) {
        if (i == 0) {
            H0();
        }
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int k(ms1 ms1Var) {
        return J0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int l(ms1 ms1Var) {
        return K0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int m(ms1 ms1Var) {
        return I0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int n(ms1 ms1Var) {
        return J0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int o(ms1 ms1Var) {
        return K0(ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final C0321Zr1 r() {
        return this.t == 0 ? new KN1(-2, -1) : new KN1(-1, -2);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final C0321Zr1 s(Context context, AttributeSet attributeSet) {
        return new KN1(context, attributeSet);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int s0(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        return f1(i, c0738gs1, ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final C0321Zr1 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new KN1((ViewGroup.MarginLayoutParams) layoutParams) : new KN1(layoutParams);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void t0(int i) {
        SavedState savedState = this.F;
        if (savedState != null && savedState.t != i) {
            savedState.w = null;
            savedState.v = 0;
            savedState.t = -1;
            savedState.u = -1;
        }
        this.z = i;
        this.A = Integer.MIN_VALUE;
        r0();
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int u0(int i, C0738gs1 c0738gs1, ms1 ms1Var) {
        return f1(i, c0738gs1, ms1Var);
    }

    @Override // defpackage.AbstractC0306Yr1
    public final int x(C0738gs1 c0738gs1, ms1 ms1Var) {
        if (this.t == 1) {
            return Math.min(this.p, ms1Var.b());
        }
        return -1;
    }

    @Override // defpackage.AbstractC0306Yr1
    public final void x0(Rect rect, int i, int i2) {
        int iG;
        int iG2;
        int i3 = this.p;
        int iG3 = G() + F();
        int iE = E() + H();
        if (this.t == 1) {
            int iHeight = rect.height() + iE;
            RecyclerView recyclerView = this.b;
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            iG2 = AbstractC0306Yr1.g(i2, iHeight, recyclerView.getMinimumHeight());
            iG = AbstractC0306Yr1.g(i, (this.u * i3) + iG3, this.b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iG3;
            RecyclerView recyclerView2 = this.b;
            WeakHashMap weakHashMap2 = AbstractC0604eo2.a;
            iG = AbstractC0306Yr1.g(i, iWidth, recyclerView2.getMinimumWidth());
            iG2 = AbstractC0306Yr1.g(i2, (this.u * i3) + iE, this.b.getMinimumHeight());
        }
        this.b.setMeasuredDimension(iG, iG2);
    }
}
