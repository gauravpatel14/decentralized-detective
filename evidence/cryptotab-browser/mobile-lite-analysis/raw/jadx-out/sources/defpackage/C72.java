package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C72 extends WQ1 {
    public static final MT[] e;
    public static final MT f;
    public String b;
    public Kr1 c;
    public C0492ci1[] d;

    static {
        MT[] mtArr = {new MT(32, 0)};
        e = mtArr;
        f = mtArr[0];
    }

    public C72(int i) {
        super(32);
    }

    public static C72 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            C72 c72 = new C72(c0965kV.c(e).b);
            c72.b = c0965kV.u(8, false);
            c72.c = Kr1.d(c0965kV.r(16, false));
            C0965kV c0965kVR = c0965kV.r(24, false);
            int i = c0965kVR.h(-1, 8L).b;
            c72.d = new C0492ci1[i];
            for (int i2 = 0; i2 < i; i2++) {
                c72.d[i2] = C0492ci1.d(c0965kVR.r((i2 * 8) + 8, false));
            }
            return c72;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(f);
        i70VarS.l(this.b, 8, false);
        i70VarS.j(this.c, 16, false);
        C0492ci1[] c0492ci1Arr = this.d;
        if (c0492ci1Arr == null) {
            i70VarS.p(24, false);
            return;
        }
        i70 i70VarQ = i70VarS.q(8, c0492ci1Arr.length, 24, -1);
        int i = 0;
        while (true) {
            C0492ci1[] c0492ci1Arr2 = this.d;
            if (i >= c0492ci1Arr2.length) {
                return;
            }
            i70VarQ.j(c0492ci1Arr2[i], (i * 8) + 8, false);
            i++;
        }
    }
}
