package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dn extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public sq b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public dn(int i) {
        super(16);
    }

    public static dn d(ER0 er0) {
        C0965kV c0965kV = new C0965kV(er0);
        c0965kV.b();
        try {
            dn dnVar = new dn(c0965kV.c(c).b);
            dnVar.b = sq.d(c0965kV.r(8, false));
            return dnVar;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70Var.s(d).j(this.b, 8, false);
    }
}
