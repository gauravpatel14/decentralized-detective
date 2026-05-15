package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class tq extends WQ1 {
    public static final MT[] g;
    public static final MT h;
    public int b;
    public int c;
    public int d;
    public float[] e;
    public float[] f;

    static {
        MT[] mtArr = {new MT(40, 0)};
        g = mtArr;
        h = mtArr[0];
    }

    public static tq d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            c0965kV.c(g);
            tq tqVar = new tq(40);
            int iN = c0965kV.n(8);
            tqVar.b = iN;
            if (iN < 0 || iN > 3) {
                iN = 0;
            }
            tqVar.b = iN;
            tqVar.c = c0965kV.n(12);
            tqVar.d = c0965kV.n(16);
            tqVar.e = c0965kV.m(24, 7);
            tqVar.f = c0965kV.m(32, 9);
            return tqVar;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(h);
        i70VarS.b(this.b, 8);
        i70VarS.b(this.c, 12);
        i70VarS.b(this.d, 16);
        float[] fArr = this.e;
        if (fArr == null) {
            i70VarS.p(24, Ip.a(1));
        } else {
            i70VarS.r(4, fArr.length, 24, 7).b.b.asFloatBuffer().put(fArr);
        }
        float[] fArr2 = this.f;
        if (fArr2 == null) {
            i70VarS.p(32, Ip.a(1));
        } else {
            i70VarS.r(4, fArr2.length, 32, 9).b.b.asFloatBuffer().put(fArr2);
        }
    }
}
