package defpackage;

import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Oy0 {
    public static boolean a(CoreImpl coreImpl, Ly0 ly0, SE1 se1, KS0 ks0) {
        ER0 er0B = se1.b();
        MT[] mtArr = nx1.c;
        C0965kV c0965kV = new C0965kV(er0B);
        c0965kV.b();
        try {
            c0965kV.c(nx1.c);
            nx1 nx1Var = new nx1(24);
            nx1Var.b = mx1.b(c0965kV);
            c0965kV.a();
            C1534tx1 c1534tx1 = new C1534tx1(24);
            C1475sx1 c1475sx1 = new C1475sx1();
            c1534tx1.b = c1475sx1;
            if (nx1Var.b.a == 0) {
                ap1 ap1Var = new ap1(16);
                c1475sx1.a = 0;
                c1475sx1.b = ap1Var;
                ap1 ap1Var2 = c1534tx1.b.b;
                ly0.getClass();
                ap1Var2.b = 0;
            } else {
                c1534tx1.b = null;
            }
            return ks0.g(c1534tx1.c(coreImpl, new wS0(-1, 2, se1.d.d)));
        } catch (Throwable th) {
            c0965kV.a();
            throw th;
        }
    }

    public static boolean b(Ly0 ly0, SE1 se1) {
        ER0 er0B = se1.b();
        MT[] mtArr = C1416rx1.c;
        C0965kV c0965kV = new C0965kV(er0B);
        c0965kV.b();
        try {
            c0965kV.c(C1416rx1.c);
            C1416rx1 c1416rx1 = new C1416rx1(24);
            c1416rx1.b = C1357qx1.b(c0965kV);
            c0965kV.a();
            C1357qx1 c1357qx1 = c1416rx1.b;
            if (c1357qx1.a != 0) {
                return false;
            }
            int i = c1357qx1.b.b;
            ly0.getClass();
            return i <= 0;
        } catch (Throwable th) {
            c0965kV.a();
            throw th;
        }
    }
}
