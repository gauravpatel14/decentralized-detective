package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class B51 extends WQ1 {
    public static final MT[] f;
    public static final MT g;
    public String b;
    public String c;
    public short d;
    public C0270Wj2 e;

    static {
        MT[] mtArr = {new MT(40, 0)};
        f = mtArr;
        g = mtArr[0];
    }

    public static B51 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(f);
            B51 b51 = new B51(40);
            b51.b = c0965kV.u(8, false);
            b51.c = c0965kV.u(16, false);
            b51.d = c0965kV.t(24);
            b51.e = C0270Wj2.d(c0965kV.r(32, true));
            return b51;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(g);
        i70VarS.l(this.b, 8, false);
        i70VarS.l(this.c, 16, false);
        i70VarS.m(this.d, 24);
        i70VarS.j(this.e, 32, true);
    }
}
