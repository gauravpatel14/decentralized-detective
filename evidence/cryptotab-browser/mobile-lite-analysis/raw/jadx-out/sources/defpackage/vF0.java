package defpackage;

import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class vF0 {
    public A51 a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;

    public vF0() {
        d();
    }

    public final void a() {
        this.c = this.d ? this.a.g() : this.a.j();
    }

    public final void b(View view, int i) {
        if (this.d) {
            this.c = this.a.l() + this.a.b(view);
        } else {
            this.c = this.a.e(view);
        }
        this.b = i;
    }

    public final void c(View view, int i) {
        int iL = this.a.l();
        if (iL >= 0) {
            b(view, i);
            return;
        }
        this.b = i;
        if (!this.d) {
            int iE = this.a.e(view);
            int iJ = iE - this.a.j();
            this.c = iE;
            if (iJ > 0) {
                int iG = (this.a.g() - Math.min(0, (this.a.g() - iL) - this.a.b(view))) - (this.a.c(view) + iE);
                if (iG < 0) {
                    this.c -= Math.min(iJ, -iG);
                    return;
                }
                return;
            }
            return;
        }
        int iG2 = (this.a.g() - iL) - this.a.b(view);
        this.c = this.a.g() - iG2;
        if (iG2 > 0) {
            int iC = this.c - this.a.c(view);
            int iJ2 = this.a.j();
            int iMin = iC - (Math.min(this.a.e(view) - iJ2, 0) + iJ2);
            if (iMin < 0) {
                this.c = Math.min(iG2, -iMin) + this.c;
            }
        }
    }

    public final void d() {
        this.b = -1;
        this.c = Integer.MIN_VALUE;
        this.d = false;
        this.e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
    }
}
