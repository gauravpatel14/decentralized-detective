package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: renamed from: bn, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0435bn extends WQ1 {
    public static final MT[] f;
    public static final MT g;
    public String b;
    public Kr1 c;
    public int d;
    public C0492ci1[] e;

    static {
        MT[] mtArr = {new MT(40, 0)};
        f = mtArr;
        g = mtArr[0];
    }

    public C0435bn(int i) {
        super(40);
    }

    public static C0435bn d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            C0435bn c0435bn = new C0435bn(c0965kV.c(f).b);
            c0435bn.b = c0965kV.u(8, false);
            c0435bn.c = Kr1.d(c0965kV.r(16, false));
            int iN = c0965kV.n(24);
            c0435bn.d = iN;
            if (iN < 0 || iN > 13) {
                throw new DeserializationException("Invalid enum value.");
            }
            c0435bn.d = iN;
            C0965kV c0965kVR = c0965kV.r(32, false);
            int i = c0965kVR.h(-1, 8L).b;
            c0435bn.e = new C0492ci1[i];
            for (int i2 = 0; i2 < i; i2++) {
                c0435bn.e[i2] = C0492ci1.d(c0965kVR.r((i2 * 8) + 8, false));
            }
            return c0435bn;
        } finally {
            c0965kV.a();
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(g);
        i70VarS.l(this.b, 8, false);
        i70VarS.j(this.c, 16, false);
        i70VarS.b(this.d, 24);
        C0492ci1[] c0492ci1Arr = this.e;
        if (c0492ci1Arr == null) {
            i70VarS.p(32, false);
            return;
        }
        i70 i70VarQ = i70VarS.q(8, c0492ci1Arr.length, 32, -1);
        int i = 0;
        while (true) {
            C0492ci1[] c0492ci1Arr2 = this.e;
            if (i >= c0492ci1Arr2.length) {
                return;
            }
            i70VarQ.j(c0492ci1Arr2[i], (i * 8) + 8, false);
            i++;
        }
    }
}
