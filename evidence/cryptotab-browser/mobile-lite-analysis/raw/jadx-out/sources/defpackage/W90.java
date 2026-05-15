package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class W90 extends WQ1 {
    public static final MT[] d;
    public static final MT e;
    public bz0 b;
    public C0974ka0 c;

    static {
        MT[] mtArr = {new MT(24, 0)};
        d = mtArr;
        e = mtArr[0];
    }

    public W90(int i) {
        super(24);
    }

    public static W90 d(ER0 er0) {
        C0974ka0 c0974ka0;
        C0965kV c0965kV = new C0965kV(er0);
        c0965kV.b();
        try {
            W90 w90 = new W90(c0965kV.c(d).b);
            w90.b = c0965kV.o(8);
            C0965kV c0965kVR = c0965kV.r(16, false);
            MT[] mtArr = C0974ka0.d;
            if (c0965kVR == null) {
                c0974ka0 = null;
            } else {
                c0965kVR.b();
                try {
                    C0974ka0 c0974ka02 = new C0974ka0(c0965kVR.c(C0974ka0.d).b);
                    c0974ka02.b = c0965kVR.n(8);
                    c0974ka02.c = c0965kVR.d(12, 0);
                    c0965kVR.a();
                    c0974ka0 = c0974ka02;
                } catch (Throwable th) {
                    c0965kVR.a();
                    throw th;
                }
            }
            w90.c = c0974ka0;
            return w90;
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
