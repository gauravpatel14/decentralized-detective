package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class xc1 extends WQ1 {
    public static final MT[] l;
    public static final MT m;
    public String b;
    public String[] c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;

    static {
        MT[] mtArr = {new MT(88, 0)};
        l = mtArr;
        m = mtArr[0];
    }

    public xc1(int i) {
        super(88);
    }

    public static xc1 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            xc1 xc1Var = new xc1(c0965kV.c(l).b);
            xc1Var.b = c0965kV.u(8, false);
            C0965kV c0965kVR = c0965kV.r(16, false);
            int i = c0965kVR.h(-1, 8L).b;
            xc1Var.c = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                xc1Var.c[i2] = c0965kVR.u((i2 * 8) + 8, false);
            }
            xc1Var.d = c0965kV.u(24, false);
            xc1Var.e = c0965kV.u(32, false);
            xc1Var.f = c0965kV.u(40, false);
            xc1Var.g = c0965kV.u(48, false);
            xc1Var.h = c0965kV.u(56, false);
            xc1Var.i = c0965kV.u(64, false);
            xc1Var.j = c0965kV.u(72, false);
            xc1Var.k = c0965kV.u(80, false);
            c0965kV.a();
            return xc1Var;
        } catch (Throwable th) {
            c0965kV.a();
            throw th;
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(m);
        i70VarS.l(this.b, 8, false);
        String[] strArr = this.c;
        if (strArr != null) {
            i70 i70VarQ = i70VarS.q(8, strArr.length, 16, -1);
            int i = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i >= strArr2.length) {
                    break;
                }
                i70VarQ.l(strArr2[i], (i * 8) + 8, false);
                i++;
            }
        } else {
            i70VarS.p(16, false);
        }
        i70VarS.l(this.d, 24, false);
        i70VarS.l(this.e, 32, false);
        i70VarS.l(this.f, 40, false);
        i70VarS.l(this.g, 48, false);
        i70VarS.l(this.h, 56, false);
        i70VarS.l(this.i, 64, false);
        i70VarS.l(this.j, 72, false);
        i70VarS.l(this.k, 80, false);
    }
}
