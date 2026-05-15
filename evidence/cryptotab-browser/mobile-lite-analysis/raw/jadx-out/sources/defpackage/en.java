package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class en extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public C0435bn[] b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public en(int i) {
        super(16);
    }

    public static en d(ER0 er0) {
        C0965kV c0965kV = new C0965kV(er0);
        c0965kV.b();
        try {
            en enVar = new en(c0965kV.c(c).b);
            C0965kV c0965kVR = c0965kV.r(8, false);
            int i = c0965kVR.h(-1, 8L).b;
            enVar.b = new C0435bn[i];
            for (int i2 = 0; i2 < i; i2++) {
                enVar.b[i2] = C0435bn.d(c0965kVR.r((i2 * 8) + 8, false));
            }
            return enVar;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(d);
        C0435bn[] c0435bnArr = this.b;
        if (c0435bnArr == null) {
            i70VarS.p(8, false);
            return;
        }
        i70 i70VarQ = i70VarS.q(8, c0435bnArr.length, 8, -1);
        int i = 0;
        while (true) {
            C0435bn[] c0435bnArr2 = this.b;
            if (i >= c0435bnArr2.length) {
                return;
            }
            i70VarQ.j(c0435bnArr2[i], (i * 8) + 8, false);
            i++;
        }
    }
}
