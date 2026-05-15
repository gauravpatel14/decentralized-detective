package defpackage;

/* JADX INFO: renamed from: Me1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0141Me1 extends WQ1 {
    public static final MT[] e;
    public static final MT f;
    public String b;
    public wc1 c;
    public e6 d;

    static {
        MT[] mtArr = {new MT(32, 0)};
        e = mtArr;
        f = mtArr[0];
    }

    public static C0141Me1 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(e);
            C0141Me1 c0141Me1 = new C0141Me1(32);
            c0141Me1.b = c0965kV.u(8, false);
            c0141Me1.c = wc1.d(c0965kV.r(16, false));
            c0141Me1.d = e6.d(c0965kV.r(24, false));
            return c0141Me1;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(f);
        i70VarS.l(this.b, 8, false);
        i70VarS.j(this.c, 16, false);
        i70VarS.j(this.d, 24, false);
    }
}
