package defpackage;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: gs1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0738gs1 {
    public final ArrayList a;
    public ArrayList b;
    public final ArrayList c;
    public final List d;
    public final int e;
    public int f;
    public C0606es1 g;
    public final /* synthetic */ RecyclerView h;

    public C0738gs1(RecyclerView recyclerView) {
        this.h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = null;
        this.c = new ArrayList();
        this.d = Collections.unmodifiableList(arrayList);
        this.e = 2;
        this.f = 2;
    }

    public final void a(ps1 ps1Var, boolean z) {
        RecyclerView.m(ps1Var);
        RecyclerView recyclerView = this.h;
        rs1 rs1Var = recyclerView.I0;
        if (rs1Var != null) {
            W wJ = rs1Var.j();
            boolean z2 = wJ instanceof C1351qs1;
            View view = ps1Var.t;
            AbstractC0604eo2.o(view, z2 ? (W) ((C1351qs1) wJ).e.remove(view) : null);
        }
        if (z) {
            hs1 hs1Var = recyclerView.H;
            if (hs1Var != null) {
                hs1Var.b(ps1Var);
            }
            ArrayList arrayList = recyclerView.I;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((hs1) arrayList.get(i)).b(ps1Var);
            }
            Pr1 pr1 = recyclerView.F;
            if (pr1 != null) {
                pr1.s(ps1Var);
            }
            if (recyclerView.B0 != null) {
                recyclerView.z.d(ps1Var);
            }
            int[] iArr = RecyclerView.W0;
        }
        ps1Var.L = null;
        ps1Var.K = null;
        c().d(ps1Var);
    }

    public final int b(int i) {
        RecyclerView recyclerView = this.h;
        if (i >= 0 && i < recyclerView.B0.b()) {
            return !recyclerView.B0.g ? i : recyclerView.x.f(i, 0);
        }
        StringBuilder sbA = AbstractC0672fs1.a(i, "invalid position ", ". State item count is ");
        sbA.append(recyclerView.B0.b());
        sbA.append(recyclerView.B());
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    public final C0606es1 c() {
        if (this.g == null) {
            this.g = new C0606es1();
            d();
        }
        return this.g;
    }

    public final void d() {
        RecyclerView recyclerView;
        Pr1 pr1;
        C0606es1 c0606es1 = this.g;
        if (c0606es1 == null || (pr1 = (recyclerView = this.h).F) == null || !recyclerView.M) {
            return;
        }
        c0606es1.c.add(pr1);
    }

    public final void e(Pr1 pr1, boolean z) {
        C0606es1 c0606es1 = this.g;
        if (c0606es1 == null) {
            return;
        }
        Set set = c0606es1.c;
        set.remove(pr1);
        if (set.size() != 0 || z) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = c0606es1.a;
            if (i >= sparseArray.size()) {
                return;
            }
            ArrayList arrayList = ((ds1) sparseArray.get(sparseArray.keyAt(i))).a;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                xi1.a(((ps1) arrayList.get(i2)).t);
            }
            i++;
        }
    }

    public final void f() {
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g(size);
        }
        arrayList.clear();
        if (RecyclerView.Z0) {
            ol0 ol0Var = this.h.A0;
            int[] iArr = ol0Var.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            ol0Var.d = 0;
        }
    }

    public final void g(int i) {
        int[] iArr = RecyclerView.W0;
        ArrayList arrayList = this.c;
        a((ps1) arrayList.get(i), true);
        arrayList.remove(i);
    }

    public final void h(View view) {
        ps1 ps1VarN = RecyclerView.N(view);
        boolean zO = ps1VarN.o();
        RecyclerView recyclerView = this.h;
        if (zO) {
            recyclerView.removeDetachedView(view, false);
        }
        if (ps1VarN.n()) {
            ps1VarN.G.l(ps1VarN);
        } else if (ps1VarN.u()) {
            ps1VarN.C &= -33;
        }
        i(ps1VarN);
        if (recyclerView.j0 == null || ps1VarN.l()) {
            return;
        }
        recyclerView.j0.i(ps1VarN);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a8, code lost:
    
        r6 = r6 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(defpackage.ps1 r13) {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0738gs1.i(ps1):void");
    }

    public final void j(View view) {
        WJ1 wj1;
        ps1 ps1VarN = RecyclerView.N(view);
        boolean zH = ps1VarN.h(12);
        RecyclerView recyclerView = this.h;
        if (!zH && ps1VarN.p() && (wj1 = recyclerView.j0) != null && !wj1.f(ps1VarN, ps1VarN.g())) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            ps1VarN.G = this;
            ps1VarN.H = true;
            this.b.add(ps1VarN);
            return;
        }
        if (ps1VarN.k() && !ps1VarN.m() && !recyclerView.F.u) {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + recyclerView.B());
        }
        ps1VarN.G = this;
        ps1VarN.H = false;
        this.a.add(ps1VarN);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x051e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.ps1 k(int r22, long r23) {
        /*
            Method dump skipped, instruction units count: 1367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0738gs1.k(int, long):ps1");
    }

    public final void l(ps1 ps1Var) {
        if (ps1Var.H) {
            this.b.remove(ps1Var);
        } else {
            this.a.remove(ps1Var);
        }
        ps1Var.G = null;
        ps1Var.H = false;
        ps1Var.C &= -33;
    }

    public final void m() {
        AbstractC0306Yr1 abstractC0306Yr1 = this.h.G;
        this.f = this.e + (abstractC0306Yr1 != null ? abstractC0306Yr1.j : 0);
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f; size--) {
            g(size);
        }
    }
}
