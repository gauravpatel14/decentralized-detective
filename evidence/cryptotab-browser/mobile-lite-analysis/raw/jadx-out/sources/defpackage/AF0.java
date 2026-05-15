package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AF0 {
    public int a = -1;
    public RecyclerView b;
    public AbstractC0306Yr1 c;
    public boolean d;
    public boolean e;
    public View f;
    public final ks1 g;
    public boolean h;
    public final LinearInterpolator i;
    public final DecelerateInterpolator j;
    public PointF k;
    public final DisplayMetrics l;
    public boolean m;
    public float n;
    public int o;
    public int p;

    public AF0(Context context) {
        ks1 ks1Var = new ks1();
        ks1Var.d = -1;
        ks1Var.f = false;
        ks1Var.g = 0;
        ks1Var.a = 0;
        ks1Var.b = 0;
        ks1Var.c = Integer.MIN_VALUE;
        ks1Var.e = null;
        this.g = ks1Var;
        this.i = new LinearInterpolator();
        this.j = new DecelerateInterpolator();
        this.m = false;
        this.o = 0;
        this.p = 0;
        this.l = context.getResources().getDisplayMetrics();
    }

    public static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int b(View view, int i) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.c;
        if (abstractC0306Yr1 == null || !abstractC0306Yr1.d()) {
            return 0;
        }
        C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
        return a(AbstractC0306Yr1.A(view) - ((ViewGroup.MarginLayoutParams) c0321Zr1).leftMargin, AbstractC0306Yr1.B(view) + ((ViewGroup.MarginLayoutParams) c0321Zr1).rightMargin, abstractC0306Yr1.F(), abstractC0306Yr1.n - abstractC0306Yr1.G(), i);
    }

    public int c(View view, int i) {
        AbstractC0306Yr1 abstractC0306Yr1 = this.c;
        if (abstractC0306Yr1 == null || !abstractC0306Yr1.e()) {
            return 0;
        }
        C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
        return a(AbstractC0306Yr1.C(view) - ((ViewGroup.MarginLayoutParams) c0321Zr1).topMargin, AbstractC0306Yr1.y(view) + ((ViewGroup.MarginLayoutParams) c0321Zr1).bottomMargin, abstractC0306Yr1.H(), abstractC0306Yr1.o - abstractC0306Yr1.E(), i);
    }

    public float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int e(int i) {
        float fAbs = Math.abs(i);
        if (!this.m) {
            this.n = d(this.l);
            this.m = true;
        }
        return (int) Math.ceil(fAbs * this.n);
    }

    public PointF f(int i) {
        Object obj = this.c;
        if (obj instanceof InterfaceC1053ls1) {
            return ((InterfaceC1053ls1) obj).a(i);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + InterfaceC1053ls1.class.getCanonicalName());
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AF0.g(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.view.View r7, defpackage.ks1 r8) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r6.k
            r1 = 1
            r2 = 0
            r3 = -1
            r4 = 0
            if (r0 == 0) goto L15
            float r0 = r0.x
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto Lf
            goto L15
        Lf:
            if (r0 <= 0) goto L13
            r0 = r1
            goto L16
        L13:
            r0 = r3
            goto L16
        L15:
            r0 = r2
        L16:
            int r0 = r6.b(r7, r0)
            android.graphics.PointF r5 = r6.k
            if (r5 == 0) goto L2a
            float r5 = r5.y
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L25
            goto L2a
        L25:
            if (r4 <= 0) goto L29
            r2 = r1
            goto L2a
        L29:
            r2 = r3
        L2a:
            int r7 = r6.c(r7, r2)
            int r2 = r0 * r0
            int r3 = r7 * r7
            int r3 = r3 + r2
            double r2 = (double) r3
            double r2 = java.lang.Math.sqrt(r2)
            int r2 = (int) r2
            int r2 = r6.e(r2)
            double r2 = (double) r2
            r4 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r2 = r2 / r4
            double r2 = java.lang.Math.ceil(r2)
            int r2 = (int) r2
            if (r2 <= 0) goto L59
            int r0 = -r0
            int r7 = -r7
            android.view.animation.DecelerateInterpolator r3 = r6.j
            r8.a = r0
            r8.b = r7
            r8.c = r2
            r8.e = r3
            r8.f = r1
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AF0.h(android.view.View, ks1):void");
    }

    public final void i() {
        if (this.e) {
            this.e = false;
            this.p = 0;
            this.o = 0;
            this.k = null;
            this.b.B0.a = -1;
            this.f = null;
            this.a = -1;
            this.d = false;
            AbstractC0306Yr1 abstractC0306Yr1 = this.c;
            if (abstractC0306Yr1.e == this) {
                abstractC0306Yr1.e = null;
            }
            this.c = null;
            this.b = null;
        }
    }
}
