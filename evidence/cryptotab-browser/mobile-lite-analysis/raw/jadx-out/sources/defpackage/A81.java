package defpackage;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class A81 {
    public RecyclerView a;
    public final NL1 b = new NL1(this);
    public A51 c;
    public A51 d;

    public static int c(View view, A51 a51) {
        return ((a51.c(view) / 2) + a51.e(view)) - ((a51.k() / 2) + a51.j());
    }

    public static View d(AbstractC0306Yr1 abstractC0306Yr1, A51 a51) {
        int iV = abstractC0306Yr1.v();
        View view = null;
        if (iV == 0) {
            return null;
        }
        int iK = (a51.k() / 2) + a51.j();
        int i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = abstractC0306Yr1.u(i2);
            int iAbs = Math.abs(((a51.c(viewU) / 2) + a51.e(viewU)) - iK);
            if (iAbs < i) {
                view = viewU;
                i = iAbs;
            }
        }
        return view;
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        NL1 nl1 = this.b;
        if (recyclerView2 != null) {
            recyclerView2.m0(nl1);
            this.a.s0 = null;
        }
        this.a = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.s0 != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            recyclerView.k(nl1);
            this.a.s0 = this;
            new Scroller(this.a.getContext(), new DecelerateInterpolator());
            h();
        }
    }

    public final int[] b(AbstractC0306Yr1 abstractC0306Yr1, View view) {
        int[] iArr = new int[2];
        if (abstractC0306Yr1.d()) {
            iArr[0] = c(view, f(abstractC0306Yr1));
        } else {
            iArr[0] = 0;
        }
        if (abstractC0306Yr1.e()) {
            iArr[1] = c(view, g(abstractC0306Yr1));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View e(AbstractC0306Yr1 abstractC0306Yr1) {
        if (abstractC0306Yr1.e()) {
            return d(abstractC0306Yr1, g(abstractC0306Yr1));
        }
        if (abstractC0306Yr1.d()) {
            return d(abstractC0306Yr1, f(abstractC0306Yr1));
        }
        return null;
    }

    public final A51 f(AbstractC0306Yr1 abstractC0306Yr1) {
        A51 a51 = this.d;
        if (a51 == null || a51.a != abstractC0306Yr1) {
            this.d = new A51(abstractC0306Yr1, 0);
        }
        return this.d;
    }

    public final A51 g(AbstractC0306Yr1 abstractC0306Yr1) {
        A51 a51 = this.c;
        if (a51 == null || a51.a != abstractC0306Yr1) {
            this.c = new A51(abstractC0306Yr1, 1);
        }
        return this.c;
    }

    public final void h() {
        AbstractC0306Yr1 abstractC0306Yr1;
        View viewE;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || (abstractC0306Yr1 = recyclerView.G) == null || (viewE = e(abstractC0306Yr1)) == null) {
            return;
        }
        int[] iArrB = b(abstractC0306Yr1, viewE);
        int i = iArrB[0];
        if (i == 0 && iArrB[1] == 0) {
            return;
        }
        this.a.y0(i, false, iArrB[1]);
    }
}
