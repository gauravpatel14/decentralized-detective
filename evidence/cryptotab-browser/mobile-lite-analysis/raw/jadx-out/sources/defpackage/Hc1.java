package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Hc1 extends WQ1 {
    public static final MT[] d;
    public static final MT e;
    public String b;
    public String c;

    static {
        MT[] mtArr = {new MT(24, 0)};
        d = mtArr;
        e = mtArr[0];
    }

    public Hc1(int i) {
        super(24);
    }

    public static Hc1 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            Hc1 hc1 = new Hc1(c0965kV.c(d).b);
            hc1.b = c0965kV.u(8, false);
            hc1.c = c0965kV.u(16, false);
            return hc1;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(e);
        i70VarS.l(this.b, 8, false);
        i70VarS.l(this.c, 16, false);
    }
}
