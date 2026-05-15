package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class A51 {
    public final AbstractC0306Yr1 a;
    public int b = Integer.MIN_VALUE;
    public final Rect c = new Rect();
    public final /* synthetic */ int d;

    public A51(AbstractC0306Yr1 abstractC0306Yr1, int i) {
        this.d = i;
        this.a = abstractC0306Yr1;
    }

    public static A51 a(AbstractC0306Yr1 abstractC0306Yr1, int i) {
        if (i == 0) {
            return new A51(abstractC0306Yr1, 0);
        }
        if (i == 1) {
            return new A51(abstractC0306Yr1, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public final int b(View view) {
        switch (this.d) {
            case 0:
                C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
                this.a.getClass();
                return AbstractC0306Yr1.B(view) + ((ViewGroup.MarginLayoutParams) c0321Zr1).rightMargin;
            default:
                C0321Zr1 c0321Zr12 = (C0321Zr1) view.getLayoutParams();
                this.a.getClass();
                return AbstractC0306Yr1.y(view) + ((ViewGroup.MarginLayoutParams) c0321Zr12).bottomMargin;
        }
    }

    public final int c(View view) {
        switch (this.d) {
            case 0:
                C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
                this.a.getClass();
                Rect rect = ((C0321Zr1) view.getLayoutParams()).b;
                return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) c0321Zr1).leftMargin + ((ViewGroup.MarginLayoutParams) c0321Zr1).rightMargin;
            default:
                C0321Zr1 c0321Zr12 = (C0321Zr1) view.getLayoutParams();
                this.a.getClass();
                Rect rect2 = ((C0321Zr1) view.getLayoutParams()).b;
                return view.getMeasuredHeight() + rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) c0321Zr12).topMargin + ((ViewGroup.MarginLayoutParams) c0321Zr12).bottomMargin;
        }
    }

    public final int d(View view) {
        switch (this.d) {
            case 0:
                C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
                this.a.getClass();
                Rect rect = ((C0321Zr1) view.getLayoutParams()).b;
                return view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) c0321Zr1).topMargin + ((ViewGroup.MarginLayoutParams) c0321Zr1).bottomMargin;
            default:
                C0321Zr1 c0321Zr12 = (C0321Zr1) view.getLayoutParams();
                this.a.getClass();
                Rect rect2 = ((C0321Zr1) view.getLayoutParams()).b;
                return view.getMeasuredWidth() + rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) c0321Zr12).leftMargin + ((ViewGroup.MarginLayoutParams) c0321Zr12).rightMargin;
        }
    }

    public final int e(View view) {
        switch (this.d) {
            case 0:
                C0321Zr1 c0321Zr1 = (C0321Zr1) view.getLayoutParams();
                this.a.getClass();
                return AbstractC0306Yr1.A(view) - ((ViewGroup.MarginLayoutParams) c0321Zr1).leftMargin;
            default:
                C0321Zr1 c0321Zr12 = (C0321Zr1) view.getLayoutParams();
                this.a.getClass();
                return AbstractC0306Yr1.C(view) - ((ViewGroup.MarginLayoutParams) c0321Zr12).topMargin;
        }
    }

    public final int f() {
        switch (this.d) {
            case 0:
                return this.a.n;
            default:
                return this.a.o;
        }
    }

    public final int g() {
        switch (this.d) {
            case 0:
                AbstractC0306Yr1 abstractC0306Yr1 = this.a;
                return abstractC0306Yr1.n - abstractC0306Yr1.G();
            default:
                AbstractC0306Yr1 abstractC0306Yr12 = this.a;
                return abstractC0306Yr12.o - abstractC0306Yr12.E();
        }
    }

    public final int h() {
        switch (this.d) {
            case 0:
                return this.a.G();
            default:
                return this.a.E();
        }
    }

    public final int i() {
        switch (this.d) {
            case 0:
                return this.a.l;
            default:
                return this.a.m;
        }
    }

    public final int j() {
        switch (this.d) {
            case 0:
                return this.a.F();
            default:
                return this.a.H();
        }
    }

    public final int k() {
        switch (this.d) {
            case 0:
                AbstractC0306Yr1 abstractC0306Yr1 = this.a;
                return (abstractC0306Yr1.n - abstractC0306Yr1.F()) - abstractC0306Yr1.G();
            default:
                AbstractC0306Yr1 abstractC0306Yr12 = this.a;
                return (abstractC0306Yr12.o - abstractC0306Yr12.H()) - abstractC0306Yr12.E();
        }
    }

    public final int l() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return k() - this.b;
    }

    public final int m(View view) {
        switch (this.d) {
            case 0:
                AbstractC0306Yr1 abstractC0306Yr1 = this.a;
                Rect rect = this.c;
                abstractC0306Yr1.L(rect, view);
                return rect.right;
            default:
                AbstractC0306Yr1 abstractC0306Yr12 = this.a;
                Rect rect2 = this.c;
                abstractC0306Yr12.L(rect2, view);
                return rect2.bottom;
        }
    }

    public final int n(View view) {
        switch (this.d) {
            case 0:
                AbstractC0306Yr1 abstractC0306Yr1 = this.a;
                Rect rect = this.c;
                abstractC0306Yr1.L(rect, view);
                return rect.left;
            default:
                AbstractC0306Yr1 abstractC0306Yr12 = this.a;
                Rect rect2 = this.c;
                abstractC0306Yr12.L(rect2, view);
                return rect2.top;
        }
    }

    public final void o(int i) {
        switch (this.d) {
            case 0:
                this.a.Q(i);
                break;
            default:
                this.a.R(i);
                break;
        }
    }
}
