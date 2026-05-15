package defpackage;

/* JADX INFO: renamed from: cl2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0496cl2 extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public String b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public C0496cl2(int i) {
        super(16);
    }

    public static C0496cl2 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            C0496cl2 c0496cl2 = new C0496cl2(c0965kV.c(c).b);
            c0496cl2.b = c0965kV.u(8, false);
            return c0496cl2;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70Var.s(d).l(this.b, 8, false);
    }
}
