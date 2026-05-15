package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Kr1 extends WQ1 {
    public static final MT[] f;
    public static final MT g;
    public float b;
    public float c;
    public float d;
    public float e;

    static {
        MT[] mtArr = {new MT(24, 0)};
        f = mtArr;
        g = mtArr[0];
    }

    public Kr1(int i) {
        super(24);
    }

    public static Kr1 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            Kr1 kr1 = new Kr1(c0965kV.c(f).b);
            kr1.b = c0965kV.l(8);
            kr1.c = c0965kV.l(12);
            kr1.d = c0965kV.l(16);
            kr1.e = c0965kV.l(20);
            return kr1;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(g);
        i70VarS.a(8, this.b);
        i70VarS.a(12, this.c);
        i70VarS.a(16, this.d);
        i70VarS.a(20, this.e);
    }
}
