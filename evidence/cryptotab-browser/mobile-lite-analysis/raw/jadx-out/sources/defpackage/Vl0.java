package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Vl0 {
    public final /* synthetic */ bm0 a;

    public /* synthetic */ Vl0(bm0 bm0Var) {
        this.a = bm0Var;
    }

    public void a(UO0 uo0, OO0 oo0, ArrayList arrayList) {
        bm0 bm0Var = this.a;
        if (uo0 != bm0Var.v || oo0 == null) {
            if (uo0 == bm0Var.d) {
                if (oo0 != null) {
                    bm0Var.l(bm0Var.c, oo0);
                }
                bm0Var.c.l(arrayList);
                return;
            }
            return;
        }
        hP0 hp0 = bm0Var.u.a;
        String strD = oo0.d();
        C0838iP0 c0838iP0 = new C0838iP0(hp0, strD, bm0Var.b(hp0, strD), false);
        c0838iP0.g(oo0);
        if (bm0Var.c == c0838iP0) {
            return;
        }
        UO0 uo02 = bm0Var.v;
        C0838iP0 c0838iP02 = bm0Var.u;
        gP0 gp0 = bm0Var.e;
        if (gp0 != null) {
            if (!gp0.i && !gp0.j) {
                gp0.j = true;
                XO0 xo0 = gp0.a;
                if (xo0 != null) {
                    xo0.h(0);
                    xo0.d();
                }
            }
            bm0Var.e = null;
        }
        gP0 gp02 = new gP0(bm0Var, c0838iP0, uo02, 3, true, c0838iP02, arrayList);
        bm0Var.e = gp02;
        gp02.a();
        bm0Var.u = null;
        bm0Var.v = null;
    }
}
