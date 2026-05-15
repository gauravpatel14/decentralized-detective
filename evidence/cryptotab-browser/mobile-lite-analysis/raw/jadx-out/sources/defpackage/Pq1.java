package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Pq1 extends WQ1 {
    public static final MT[] d;
    public static final MT e;
    public InterfaceC1749xk2 b;
    public boolean c;

    static {
        MT[] mtArr = {new MT(16, 0)};
        d = mtArr;
        e = mtArr[0];
    }

    public Pq1(int i) {
        super(16);
        this.b = pz0.t;
    }

    public static Pq1 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            Pq1 pq1 = new Pq1(c0965kV.c(d).b);
            pq1.b = c0965kV.v(8, false);
            pq1.c = c0965kV.d(12, 0);
            return pq1;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(e);
        i70VarS.h(this.b, 8, false);
        i70VarS.f(12, this.c, 0);
    }
}
