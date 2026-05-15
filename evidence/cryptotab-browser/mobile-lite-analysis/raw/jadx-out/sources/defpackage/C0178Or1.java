package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: renamed from: Or1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0178Or1 implements BY {
    public final /* synthetic */ RecyclerView a;

    public /* synthetic */ C0178Or1(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override // defpackage.BY
    public boolean a(float f) {
        int i;
        int i2;
        RecyclerView recyclerView = this.a;
        if (recyclerView.G.e()) {
            i2 = (int) f;
            i = 0;
        } else if (recyclerView.G.d()) {
            i = (int) f;
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        recyclerView.D0();
        return recyclerView.I(i, i2, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // defpackage.BY
    public float b() {
        float f;
        RecyclerView recyclerView = this.a;
        if (recyclerView.G.e()) {
            f = recyclerView.w0;
        } else {
            if (!recyclerView.G.d()) {
                return 0.0f;
            }
            f = recyclerView.v0;
        }
        return -f;
    }

    @Override // defpackage.BY
    public void c() {
        this.a.D0();
    }

    public void d(S4 s4) {
        int i = s4.a;
        RecyclerView recyclerView = this.a;
        if (i == 1) {
            recyclerView.G.a0(s4.b, s4.d);
            return;
        }
        if (i == 2) {
            recyclerView.G.d0(s4.b, s4.d);
        } else if (i == 4) {
            recyclerView.G.e0(s4.b, s4.d);
        } else {
            if (i != 8) {
                return;
            }
            recyclerView.G.c0(s4.b, s4.d);
        }
    }

    public ps1 e(int i) {
        RecyclerView recyclerView = this.a;
        int iH = recyclerView.y.h();
        int i2 = 0;
        ps1 ps1Var = null;
        while (true) {
            if (i2 >= iH) {
                break;
            }
            ps1 ps1VarN = RecyclerView.N(recyclerView.y.g(i2));
            if (ps1VarN != null && !ps1VarN.m() && ps1VarN.v == i) {
                if (!recyclerView.y.c.contains(ps1VarN.t)) {
                    ps1Var = ps1VarN;
                    break;
                }
                ps1Var = ps1VarN;
            }
            i2++;
        }
        if (ps1Var == null) {
            return null;
        }
        if (!recyclerView.y.c.contains(ps1Var.t)) {
            return ps1Var;
        }
        int[] iArr = RecyclerView.W0;
        return null;
    }

    public void f(int i, int i2, Object obj) {
        int i3;
        int i4;
        RecyclerView recyclerView = this.a;
        int iH = recyclerView.y.h();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < iH; i6++) {
            View viewG = recyclerView.y.g(i6);
            ps1 ps1VarN = RecyclerView.N(viewG);
            if (ps1VarN != null && !ps1VarN.t() && (i4 = ps1VarN.v) >= i && i4 < i5) {
                ps1VarN.c(2);
                if (obj == null) {
                    ps1VarN.c(1024);
                } else if ((1024 & ps1VarN.C) == 0) {
                    if (ps1VarN.D == null) {
                        ArrayList arrayList = new ArrayList();
                        ps1VarN.D = arrayList;
                        ps1VarN.E = Collections.unmodifiableList(arrayList);
                    }
                    ps1VarN.D.add(obj);
                }
                ((C0321Zr1) viewG.getLayoutParams()).c = true;
            }
        }
        C0738gs1 c0738gs1 = recyclerView.v;
        ArrayList arrayList2 = c0738gs1.c;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            ps1 ps1Var = (ps1) arrayList2.get(size);
            if (ps1Var != null && (i3 = ps1Var.v) >= i && i3 < i5) {
                ps1Var.c(2);
                c0738gs1.g(size);
            }
        }
        recyclerView.F0 = true;
    }

    public void g(int i, int i2) {
        RecyclerView recyclerView = this.a;
        int iH = recyclerView.y.h();
        for (int i3 = 0; i3 < iH; i3++) {
            ps1 ps1VarN = RecyclerView.N(recyclerView.y.g(i3));
            if (ps1VarN != null && !ps1VarN.t() && ps1VarN.v >= i) {
                ps1VarN.q(i2, false);
                recyclerView.B0.f = true;
            }
        }
        ArrayList arrayList = recyclerView.v.c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ps1 ps1Var = (ps1) arrayList.get(i4);
            if (ps1Var != null && ps1Var.v >= i) {
                ps1Var.q(i2, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.E0 = true;
    }

    public void h(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        RecyclerView recyclerView = this.a;
        int iH = recyclerView.y.h();
        int i10 = -1;
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i11 = 0; i11 < iH; i11++) {
            ps1 ps1VarN = RecyclerView.N(recyclerView.y.g(i11));
            if (ps1VarN != null && (i9 = ps1VarN.v) >= i4 && i9 <= i3) {
                if (i9 == i) {
                    ps1VarN.q(i2 - i, false);
                } else {
                    ps1VarN.q(i5, false);
                }
                recyclerView.B0.f = true;
            }
        }
        C0738gs1 c0738gs1 = recyclerView.v;
        c0738gs1.getClass();
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        ArrayList arrayList = c0738gs1.c;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            ps1 ps1Var = (ps1) arrayList.get(i12);
            if (ps1Var != null && (i8 = ps1Var.v) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    ps1Var.q(i2 - i, false);
                } else {
                    ps1Var.q(i10, false);
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.E0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(defpackage.ps1 r9, defpackage.C0251Ur1 r10, defpackage.C0251Ur1 r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.a
            r0.getClass()
            r1 = 0
            r9.s(r1)
            WJ1 r2 = r0.j0
            if (r10 == 0) goto L26
            r2.getClass()
            int r4 = r10.a
            int r6 = r11.a
            if (r4 != r6) goto L1c
            int r1 = r10.b
            int r3 = r11.b
            if (r1 == r3) goto L26
        L1c:
            int r5 = r10.b
            int r7 = r11.b
            r3 = r9
            boolean r9 = r2.c(r3, r4, r5, r6, r7)
            goto L2a
        L26:
            r2.a(r9)
            r9 = 1
        L2a:
            if (r9 == 0) goto L2f
            r0.d0()
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0178Or1.i(ps1, Ur1, Ur1):void");
    }

    public void j(ps1 ps1Var, C0251Ur1 c0251Ur1, C0251Ur1 c0251Ur12) {
        boolean zD;
        RecyclerView recyclerView = this.a;
        recyclerView.v.l(ps1Var);
        recyclerView.h(ps1Var);
        ps1Var.s(false);
        WJ1 wj1 = recyclerView.j0;
        wj1.getClass();
        int i = c0251Ur1.a;
        int i2 = c0251Ur1.b;
        View view = ps1Var.t;
        int left = c0251Ur12 == null ? view.getLeft() : c0251Ur12.a;
        int top = c0251Ur12 == null ? view.getTop() : c0251Ur12.b;
        if (ps1Var.m() || (i == left && i2 == top)) {
            zD = wj1.d(ps1Var);
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zD = wj1.c(ps1Var, i, i2, left, top);
        }
        if (zD) {
            recyclerView.d0();
        }
    }

    public void k(int i) {
        RecyclerView recyclerView = this.a;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            recyclerView.s(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }
}
