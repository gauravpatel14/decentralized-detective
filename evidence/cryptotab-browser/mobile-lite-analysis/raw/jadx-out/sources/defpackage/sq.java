package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class sq extends WQ1 {
    public static final MT[] d;
    public static final MT e;
    public tq b;
    public qp c;

    static {
        MT[] mtArr = {new MT(32, 0)};
        d = mtArr;
        e = mtArr[0];
    }

    public static sq d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(d);
            sq sqVar = new sq(32);
            sqVar.b = tq.d(c0965kV.r(8, false));
            sqVar.c = qp.b(c0965kV, 16);
            return sqVar;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(e);
        i70VarS.j(this.b, 8, false);
        i70VarS.k(this.c, 16, false);
    }
}
