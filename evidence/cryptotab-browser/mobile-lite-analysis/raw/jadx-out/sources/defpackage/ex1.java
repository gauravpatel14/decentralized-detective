package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ex1 implements KS0 {
    public final /* synthetic */ gx1 t;

    public ex1(gx1 gx1Var) {
        this.t = gx1Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        My0 my0 = this.t.u;
        if (my0 != null) {
            my0.close();
        }
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        gx1 gx1Var = this.t;
        gx1Var.getClass();
        wS0 ws0 = er0.a().d;
        if (ws0.a(1)) {
            My0 my0 = gx1Var.u;
            if (my0 != null) {
                return my0.N(er0, new fx1(gx1Var));
            }
            gx1Var.close();
            return false;
        }
        if (!ws0.a(2)) {
            My0 my02 = gx1Var.u;
            if (my02 != null) {
                return my02.g(er0);
            }
            return false;
        }
        long j = ws0.d;
        HashMap map = gx1Var.w;
        KS0 ks0 = (KS0) map.get(Long.valueOf(j));
        if (ks0 == null) {
            return false;
        }
        map.remove(Long.valueOf(j));
        return ks0.g(er0);
    }
}
