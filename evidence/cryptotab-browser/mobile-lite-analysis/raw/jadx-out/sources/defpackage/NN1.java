package defpackage;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NN1 {
    public final ArrayList a = new ArrayList();
    public int b = Integer.MIN_VALUE;
    public int c = Integer.MIN_VALUE;
    public int d = 0;
    public final int e;
    public final /* synthetic */ StaggeredGridLayoutManager f;

    public NN1(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f = staggeredGridLayoutManager;
        this.e = i;
    }

    public final void a() {
        View view = (View) this.a.get(r0.size() - 1);
        KN1 kn1 = (KN1) view.getLayoutParams();
        this.c = this.f.r.b(view);
        kn1.getClass();
    }

    public final void b() {
        this.a.clear();
        this.b = Integer.MIN_VALUE;
        this.c = Integer.MIN_VALUE;
        this.d = 0;
    }

    public final int c() {
        return this.f.w ? e(r1.size() - 1, -1) : e(0, this.a.size());
    }

    public final int d() {
        return this.f.w ? e(0, this.a.size()) : e(r1.size() - 1, -1);
    }

    public final int e(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f;
        int iJ = staggeredGridLayoutManager.r.j();
        int iG = staggeredGridLayoutManager.r.g();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = (View) this.a.get(i);
            int iE = staggeredGridLayoutManager.r.e(view);
            int iB = staggeredGridLayoutManager.r.b(view);
            boolean z = iE <= iG;
            boolean z2 = iB >= iJ;
            if (z && z2 && (iE < iJ || iB > iG)) {
                return AbstractC0306Yr1.I(view);
            }
            i += i3;
        }
        return -1;
    }

    public final int f(int i) {
        int i2 = this.c;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.a.size() == 0) {
            return i;
        }
        a();
        return this.c;
    }

    public final View g(int i, int i2) {
        ArrayList arrayList = this.a;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f;
        View view = null;
        if (i2 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.w && AbstractC0306Yr1.I(view2) >= i) || ((!staggeredGridLayoutManager.w && AbstractC0306Yr1.I(view2) <= i) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                View view3 = (View) arrayList.get(i3);
                if ((staggeredGridLayoutManager.w && AbstractC0306Yr1.I(view3) <= i) || ((!staggeredGridLayoutManager.w && AbstractC0306Yr1.I(view3) >= i) || !view3.hasFocusable())) {
                    break;
                }
                i3++;
                view = view3;
            }
        }
        return view;
    }

    public final int h(int i) {
        int i2 = this.b;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.a.size() == 0) {
            return i;
        }
        View view = (View) this.a.get(0);
        KN1 kn1 = (KN1) view.getLayoutParams();
        this.b = this.f.r.e(view);
        kn1.getClass();
        return this.b;
    }
}
