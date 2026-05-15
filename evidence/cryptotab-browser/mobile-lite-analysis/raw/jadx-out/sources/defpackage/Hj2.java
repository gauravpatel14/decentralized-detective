package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Hj2 {
    public static final Object a(Kz1 kz1, Kz1 kz12, xk0 xk0Var) throws Throwable {
        Object oh;
        Object objD;
        try {
            AbstractC0222Si2.a(2, xk0Var);
            oh = xk0Var.i(kz12, kz1);
        } catch (Throwable th) {
            oh = new OH(th, false);
        }
        pO pOVar = pO.t;
        if (oh == pOVar || (objD = kz1.D(oh)) == ZA0.b) {
            return pOVar;
        }
        if (objD instanceof OH) {
            throw ((OH) objD).a;
        }
        return ZA0.a(objD);
    }
}
