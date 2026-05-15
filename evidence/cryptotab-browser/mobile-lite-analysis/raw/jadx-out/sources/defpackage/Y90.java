package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Y90 extends My0 {
    @Override // defpackage.LS0
    public final boolean N(ER0 er0, KS0 ks0) {
        try {
            SE1 se1A = er0.a();
            wS0 ws0 = se1A.d;
            if (ws0.b(ws0.a(4) ? 5 : 1) && ws0.b == -1) {
                return Oy0.a(this.t, Z90.a, se1A, ks0);
            }
            return false;
        } catch (DeserializationException e) {
            System.err.println(e.toString());
            return false;
        }
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) {
        try {
            SE1 se1A = er0.a();
            wS0 ws0 = se1A.d;
            int i = 4;
            if (!ws0.a(4)) {
                i = 0;
            }
            if (!ws0.b(i)) {
                return false;
            }
            int i2 = ws0.b;
            if (i2 == -2) {
                return Oy0.b(Z90.a, se1A);
            }
            if (i2 != 0) {
                return false;
            }
            W90 w90D = W90.d(se1A.b());
            ((T90) this.u).H1(w90D.b, w90D.c);
            return true;
        } catch (DeserializationException e) {
            System.err.println(e.toString());
            return false;
        }
    }
}
