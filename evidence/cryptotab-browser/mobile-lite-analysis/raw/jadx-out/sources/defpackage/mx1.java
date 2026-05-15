package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mx1 extends AbstractC0287Xj2 {
    public Zo1 b;
    public C0043Dg0 c;

    public static final mx1 b(C0965kV c0965kV) {
        MT mtJ = c0965kV.j(8);
        Zo1 zo1 = null;
        C0043Dg0 c0043Dg0 = null;
        if (mtJ.a == 0) {
            return null;
        }
        mx1 mx1Var = new mx1();
        int i = mtJ.b;
        if (i == 0) {
            C0965kV c0965kVR = c0965kV.r(16, false);
            MT[] mtArr = Zo1.b;
            if (c0965kVR != null) {
                c0965kVR.b();
                try {
                    c0965kVR.c(Zo1.b);
                    zo1 = new Zo1(8);
                } finally {
                }
            }
            mx1Var.b = zo1;
            mx1Var.a = 0;
        } else if (i == 1) {
            C0965kV c0965kVR2 = c0965kV.r(16, false);
            MT[] mtArr2 = C0043Dg0.b;
            if (c0965kVR2 != null) {
                c0965kVR2.b();
                try {
                    c0965kVR2.c(C0043Dg0.b);
                    c0043Dg0 = new C0043Dg0(8);
                } finally {
                }
            }
            mx1Var.c = c0043Dg0;
            mx1Var.a = 1;
        }
        return mx1Var;
    }

    @Override // defpackage.AbstractC0287Xj2
    public final void a(i70 i70Var, int i) {
        i70Var.b(16, i);
        i70Var.b(this.a, i + 4);
        int i2 = this.a;
        if (i2 == 0) {
            i70Var.j(this.b, i + 8, false);
        } else {
            if (i2 != 1) {
                return;
            }
            i70Var.j(this.c, i + 8, false);
        }
    }
}
