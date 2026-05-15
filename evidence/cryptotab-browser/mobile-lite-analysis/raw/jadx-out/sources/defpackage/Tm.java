package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Tm extends WQ1 {
    public static final MT[] d;
    public static final MT e;
    public bz0 b;
    public ln c;

    static {
        MT[] mtArr = {new MT(24, 0)};
        d = mtArr;
        e = mtArr[0];
    }

    public Tm(int i) {
        super(24);
    }

    public static Tm d(ER0 er0) {
        C0965kV c0965kV = new C0965kV(er0);
        c0965kV.b();
        try {
            Tm tm = new Tm(c0965kV.c(d).b);
            tm.b = c0965kV.o(8);
            tm.c = ln.d(c0965kV.r(16, false));
            return tm;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(e);
        i70VarS.e(8, this.b);
        i70VarS.j(this.c, 16, false);
    }
}
