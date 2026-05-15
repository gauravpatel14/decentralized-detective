package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class e6 extends WQ1 {
    public static final MT[] l;
    public static final MT m;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;

    static {
        MT[] mtArr = {new MT(88, 0)};
        l = mtArr;
        m = mtArr[0];
    }

    public static e6 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(l);
            e6 e6Var = new e6(88);
            e6Var.b = c0965kV.u(8, false);
            e6Var.c = c0965kV.u(16, false);
            e6Var.d = c0965kV.u(24, false);
            e6Var.e = c0965kV.u(32, false);
            e6Var.f = c0965kV.u(40, false);
            e6Var.g = c0965kV.u(48, false);
            e6Var.h = c0965kV.u(56, false);
            e6Var.i = c0965kV.u(64, false);
            e6Var.j = c0965kV.u(72, false);
            e6Var.k = c0965kV.u(80, false);
            return e6Var;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(m);
        i70VarS.l(this.b, 8, false);
        i70VarS.l(this.c, 16, false);
        i70VarS.l(this.d, 24, false);
        i70VarS.l(this.e, 32, false);
        i70VarS.l(this.f, 40, false);
        i70VarS.l(this.g, 48, false);
        i70VarS.l(this.h, 56, false);
        i70VarS.l(this.i, 64, false);
        i70VarS.l(this.j, 72, false);
        i70VarS.l(this.k, 80, false);
    }
}
