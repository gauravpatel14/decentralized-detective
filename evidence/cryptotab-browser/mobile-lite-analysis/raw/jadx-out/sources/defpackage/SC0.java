package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SC0 extends WQ1 {
    public static final MT[] d;
    public static final MT e;
    public C0492ci1[] b;
    public int c;

    static {
        MT[] mtArr = {new MT(24, 0)};
        d = mtArr;
        e = mtArr[0];
    }

    public SC0(int i) {
        super(24);
    }

    public static SC0 d(C0965kV c0965kV) {
        if (c0965kV == null) {
            return null;
        }
        c0965kV.b();
        try {
            SC0 sc0 = new SC0(c0965kV.c(d).b);
            C0965kV c0965kVR = c0965kV.r(8, false);
            int i = c0965kVR.h(-1, 8L).b;
            sc0.b = new C0492ci1[i];
            for (int i2 = 0; i2 < i; i2++) {
                sc0.b[i2] = C0492ci1.d(c0965kVR.r((i2 * 8) + 8, false));
            }
            int iN = c0965kV.n(16);
            sc0.c = iN;
            if (iN < 0 || iN > 2) {
                throw new DeserializationException("Invalid enum value.");
            }
            sc0.c = iN;
            c0965kV.a();
            return sc0;
        } catch (Throwable th) {
            c0965kV.a();
            throw th;
        }
    }

    @Override // defpackage.WQ1
    public final void a(i70 i70Var) {
        i70 i70VarS = i70Var.s(e);
        C0492ci1[] c0492ci1Arr = this.b;
        if (c0492ci1Arr != null) {
            i70 i70VarQ = i70VarS.q(8, c0492ci1Arr.length, 8, -1);
            int i = 0;
            while (true) {
                C0492ci1[] c0492ci1Arr2 = this.b;
                if (i >= c0492ci1Arr2.length) {
                    break;
                }
                i70VarQ.j(c0492ci1Arr2[i], (i * 8) + 8, false);
                i++;
            }
        } else {
            i70VarS.p(8, false);
        }
        i70VarS.b(this.c, 16);
    }
}
