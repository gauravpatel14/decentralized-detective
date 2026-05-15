package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jx1 extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public Wd0 b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public static Jx1 d(C0965kV c0965kV) {
        Wd0 wd0 = null;
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(c);
            Jx1 jx1 = new Jx1(16);
            C0965kV c0965kVR = c0965kV.r(8, false);
            MT[] mtArr = Wd0.c;
            if (c0965kVR != null) {
                c0965kVR.b();
                try {
                    c0965kVR.c(Wd0.c);
                    wd0 = new Wd0(16);
                    wd0.b = c0965kVR.u(8, false);
                } finally {
                    c0965kVR.a();
                }
            }
            jx1.b = wd0;
            return jx1;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70Var.s(d).j(this.b, 8, false);
    }
}
