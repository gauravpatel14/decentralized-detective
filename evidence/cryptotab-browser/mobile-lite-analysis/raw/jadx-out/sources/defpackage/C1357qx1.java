package defpackage;

/* JADX INFO: renamed from: qx1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1357qx1 extends AbstractC0287Xj2 {
    public Tu1 b;
    public f70 c;
    public FR0 d;
    public i21 e;

    public static final C1357qx1 b(C0965kV c0965kV) {
        MT mtJ = c0965kV.j(8);
        Tu1 tu1 = null;
        i21 i21Var = null;
        FR0 fr0 = null;
        f70 f70Var = null;
        if (mtJ.a == 0) {
            return null;
        }
        C1357qx1 c1357qx1 = new C1357qx1();
        int i = mtJ.b;
        if (i == 0) {
            C0965kV c0965kVR = c0965kV.r(16, false);
            MT[] mtArr = Tu1.c;
            if (c0965kVR != null) {
                c0965kVR.b();
                try {
                    c0965kVR.c(Tu1.c);
                    tu1 = new Tu1(16);
                    tu1.b = c0965kVR.n(8);
                } finally {
                }
            }
            c1357qx1.b = tu1;
            c1357qx1.a = 0;
        } else if (i == 1) {
            C0965kV c0965kVR2 = c0965kV.r(16, false);
            MT[] mtArr2 = f70.c;
            if (c0965kVR2 != null) {
                c0965kVR2.b();
                try {
                    c0965kVR2.c(f70.c);
                    f70Var = new f70(16);
                    f70Var.b = c0965kVR2.q(8);
                } finally {
                }
            }
            c1357qx1.c = f70Var;
            c1357qx1.a = 1;
        } else if (i == 2) {
            C0965kV c0965kVR3 = c0965kV.r(16, false);
            MT[] mtArr3 = FR0.b;
            if (c0965kVR3 != null) {
                c0965kVR3.b();
                try {
                    c0965kVR3.c(FR0.b);
                    fr0 = new FR0(8);
                } finally {
                }
            }
            c1357qx1.d = fr0;
            c1357qx1.a = 2;
        } else if (i == 3) {
            C0965kV c0965kVR4 = c0965kV.r(16, false);
            MT[] mtArr4 = i21.b;
            if (c0965kVR4 != null) {
                c0965kVR4.b();
                try {
                    c0965kVR4.c(i21.b);
                    i21Var = new i21(8);
                } finally {
                }
            }
            c1357qx1.e = i21Var;
            c1357qx1.a = 3;
        }
        return c1357qx1;
    }

    @Override // defpackage.AbstractC0287Xj2
    public final void a(i70 i70Var, int i) {
        i70Var.b(16, i);
        i70Var.b(this.a, i + 4);
        int i2 = this.a;
        if (i2 == 0) {
            i70Var.j(this.b, i + 8, false);
            return;
        }
        if (i2 == 1) {
            i70Var.j(this.c, i + 8, false);
        } else if (i2 == 2) {
            i70Var.j(this.d, i + 8, false);
        } else {
            if (i2 != 3) {
                return;
            }
            i70Var.j(this.e, i + 8, false);
        }
    }
}
