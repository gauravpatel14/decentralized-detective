package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class H72 extends WQ1 {
    public static final MT[] c;
    public static final MT d;
    public C72[] b;

    static {
        MT[] mtArr = {new MT(16, 0)};
        c = mtArr;
        d = mtArr[0];
    }

    public H72(int i) {
        super(16);
    }

    public static H72 d(ER0 er0) {
        C0965kV c0965kV = new C0965kV(er0);
        c0965kV.b();
        try {
            H72 h72 = new H72(c0965kV.c(c).b);
            C0965kV c0965kVR = c0965kV.r(8, false);
            int i = c0965kVR.h(-1, 8L).b;
            h72.b = new C72[i];
            for (int i2 = 0; i2 < i; i2++) {
                h72.b[i2] = C72.d(c0965kVR.r((i2 * 8) + 8, false));
            }
            return h72;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(d);
        C72[] c72Arr = this.b;
        if (c72Arr == null) {
            i70VarS.p(8, false);
            return;
        }
        i70 i70VarQ = i70VarS.q(8, c72Arr.length, 8, -1);
        int i = 0;
        while (true) {
            C72[] c72Arr2 = this.b;
            if (i >= c72Arr2.length) {
                return;
            }
            i70VarQ.j(c72Arr2[i], (i * 8) + 8, false);
            i++;
        }
    }
}
