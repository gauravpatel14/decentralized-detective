package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class wc1 extends WQ1 {
    public static final MT[] e;
    public static final MT f;
    public String b;
    public String c;
    public String d;

    static {
        MT[] mtArr = {new MT(32, 0)};
        e = mtArr;
        f = mtArr[0];
    }

    public static wc1 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(e);
            wc1 wc1Var = new wc1(32);
            wc1Var.b = c0965kV.u(8, false);
            wc1Var.c = c0965kV.u(16, false);
            wc1Var.d = c0965kV.u(24, false);
            return wc1Var;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(f);
        i70VarS.l(this.b, 8, false);
        i70VarS.l(this.c, 16, false);
        i70VarS.l(this.d, 24, false);
    }
}
