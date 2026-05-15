package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: renamed from: Rz, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0217Rz {
    public final C0178Or1 a;
    public View e;
    public int d = 0;
    public final C0203Qz b = new C0203Qz();
    public final ArrayList c = new ArrayList();

    public C0217Rz(C0178Or1 c0178Or1) {
        this.a = c0178Or1;
    }

    public final void a(View view, int i, boolean z) {
        RecyclerView recyclerView = this.a.a;
        int childCount = i < 0 ? recyclerView.getChildCount() : f(i);
        this.b.e(childCount, z);
        if (z) {
            i(view);
        }
        recyclerView.addView(view, childCount);
        ps1 ps1VarN = RecyclerView.N(view);
        recyclerView.Y(view);
        Pr1 pr1 = recyclerView.F;
        if (pr1 != null && ps1VarN != null) {
            pr1.r(ps1VarN);
        }
        ArrayList arrayList = recyclerView.W;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((InterfaceC0382as1) recyclerView.W.get(size)).c(view);
            }
        }
    }

    public final void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = this.a.a;
        int childCount = i < 0 ? recyclerView.getChildCount() : f(i);
        this.b.e(childCount, z);
        if (z) {
            i(view);
        }
        ps1 ps1VarN = RecyclerView.N(view);
        if (ps1VarN != null) {
            if (!ps1VarN.o() && !ps1VarN.t()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + ps1VarN + recyclerView.B());
            }
            ps1VarN.C &= -257;
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public final void c(int i) {
        int iF = f(i);
        this.b.f(iF);
        RecyclerView recyclerView = this.a.a;
        View childAt = recyclerView.getChildAt(iF);
        if (childAt != null) {
            ps1 ps1VarN = RecyclerView.N(childAt);
            if (ps1VarN != null) {
                if (ps1VarN.o() && !ps1VarN.t()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + ps1VarN + recyclerView.B());
                }
                ps1VarN.c(256);
            }
        } else {
            int[] iArr = RecyclerView.W0;
        }
        recyclerView.detachViewFromParent(iF);
    }

    public final View d(int i) {
        return this.a.a.getChildAt(f(i));
    }

    public final int e() {
        return this.a.a.getChildCount() - this.c.size();
    }

    public final int f(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.a.a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            C0203Qz c0203Qz = this.b;
            int iB = i - (i2 - c0203Qz.b(i2));
            if (iB == 0) {
                while (c0203Qz.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB;
        }
        return -1;
    }

    public final View g(int i) {
        return this.a.a.getChildAt(i);
    }

    public final int h() {
        return this.a.a.getChildCount();
    }

    public final void i(View view) {
        this.c.add(view);
        C0178Or1 c0178Or1 = this.a;
        ps1 ps1VarN = RecyclerView.N(view);
        if (ps1VarN != null) {
            int i = ps1VarN.f34J;
            View view2 = ps1VarN.t;
            if (i != -1) {
                ps1VarN.I = i;
            } else {
                ps1VarN.I = view2.getImportantForAccessibility();
            }
            RecyclerView recyclerView = c0178Or1.a;
            if (!recyclerView.U()) {
                view2.setImportantForAccessibility(4);
            } else {
                ps1VarN.f34J = 4;
                recyclerView.O0.add(ps1VarN);
            }
        }
    }

    public final void j(View view) {
        if (this.c.remove(view)) {
            C0178Or1 c0178Or1 = this.a;
            ps1 ps1VarN = RecyclerView.N(view);
            if (ps1VarN != null) {
                int i = ps1VarN.I;
                RecyclerView recyclerView = c0178Or1.a;
                if (recyclerView.U()) {
                    ps1VarN.f34J = i;
                    recyclerView.O0.add(ps1VarN);
                } else {
                    ps1VarN.t.setImportantForAccessibility(i);
                }
                ps1VarN.I = 0;
            }
        }
    }

    public final String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
