package defpackage;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Zm extends My0 {
    @Override // defpackage.LS0
    public final boolean N(ER0 er0, KS0 ks0) {
        try {
            SE1 se1A = er0.a();
            wS0 ws0 = se1A.d;
            if (!ws0.b(ws0.a(4) ? 5 : 1)) {
                return false;
            }
            int i = ws0.b;
            CoreImpl coreImpl = this.t;
            if (i == -1) {
                return Oy0.a(coreImpl, AbstractC0378an.a, se1A, ks0);
            }
            if (i != 1) {
                return false;
            }
            ER0 er0B = se1A.b();
            MT[] mtArr = Um.b;
            C0965kV c0965kV = new C0965kV(er0B);
            c0965kV.b();
            try {
                c0965kV.c(Um.b);
                c0965kV.a();
                ((Qm) this.u).L(new Xm(coreImpl, ks0, ws0.d));
                return true;
            } catch (Throwable th) {
                c0965kV.a();
                throw th;
            }
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
                return Oy0.b(AbstractC0378an.a, se1A);
            }
            if (i2 != 0) {
                return false;
            }
            Tm tmD = Tm.d(se1A.b());
            ((Qm) this.u).S0(tmD.b, tmD.c);
            return true;
        } catch (DeserializationException e) {
            System.err.println(e.toString());
            return false;
        }
    }
}
