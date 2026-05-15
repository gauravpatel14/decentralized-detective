package defpackage;

/* JADX INFO: renamed from: ca0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0484ca0 extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public sq b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public C0484ca0(int i) {
        super(16);
    }

    public static C0484ca0 d(ER0 er0) {
        C0965kV c0965kV = new C0965kV(er0);
        c0965kV.b();
        try {
            C0484ca0 c0484ca0 = new C0484ca0(c0965kV.c(c).b);
            c0484ca0.b = sq.d(c0965kV.r(8, false));
            return c0484ca0;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70Var.s(d).j(this.b, 8, false);
    }
}
