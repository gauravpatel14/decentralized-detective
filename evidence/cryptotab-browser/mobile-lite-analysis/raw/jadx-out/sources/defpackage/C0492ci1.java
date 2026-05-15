package defpackage;

/* JADX INFO: renamed from: ci1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0492ci1 extends WQ1 {
    public static final MT[] d;
    public static final MT e;
    public float b;
    public float c;

    static {
        MT[] mtArr = {new MT(16, 0)};
        d = mtArr;
        e = mtArr[0];
    }

    public C0492ci1(int i) {
        super(16);
    }

    public static C0492ci1 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            C0492ci1 c0492ci1 = new C0492ci1(c0965kV.c(d).b);
            c0492ci1.b = c0965kV.l(8);
            c0492ci1.c = c0965kV.l(12);
            return c0492ci1;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(e);
        i70VarS.a(8, this.b);
        i70VarS.a(12, this.c);
    }
}
