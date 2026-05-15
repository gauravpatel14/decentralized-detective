package defpackage;

/* JADX INFO: renamed from: aa0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0364aa0 extends WQ1 {
    public static final MT[] d;
    public static final MT e;
    public Kr1 b;
    public SC0[] c;

    static {
        MT[] mtArr = {new MT(24, 0)};
        d = mtArr;
        e = mtArr[0];
    }

    public C0364aa0(int i) {
        super(24);
    }

    public static C0364aa0 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            C0364aa0 c0364aa0 = new C0364aa0(c0965kV.c(d).b);
            c0364aa0.b = Kr1.d(c0965kV.r(8, false));
            C0965kV c0965kVR = c0965kV.r(16, false);
            int i = c0965kVR.h(-1, 8L).b;
            c0364aa0.c = new SC0[i];
            for (int i2 = 0; i2 < i; i2++) {
                c0364aa0.c[i2] = SC0.d(c0965kVR.r((i2 * 8) + 8, false));
            }
            return c0364aa0;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(e);
        i70VarS.j(this.b, 8, false);
        SC0[] sc0Arr = this.c;
        if (sc0Arr == null) {
            i70VarS.p(16, false);
            return;
        }
        i70 i70VarQ = i70VarS.q(8, sc0Arr.length, 16, -1);
        int i = 0;
        while (true) {
            SC0[] sc0Arr2 = this.c;
            if (i >= sc0Arr2.length) {
                return;
            }
            i70VarQ.j(sc0Arr2[i], (i * 8) + 8, false);
            i++;
        }
    }
}
