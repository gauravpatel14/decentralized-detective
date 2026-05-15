package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class qp extends AbstractC0287Xj2 {
    public byte[] b;
    public rp c;
    public boolean d;

    public static final qp b(C0965kV c0965kV, int i) {
        MT mtJ = c0965kV.j(i);
        rp rpVar = null;
        if (mtJ.a == 0) {
            return null;
        }
        qp qpVar = new qp();
        int i2 = mtJ.b;
        if (i2 == 0) {
            qpVar.b = c0965kV.e(i + 8, 0, -1);
            qpVar.a = 0;
        } else if (i2 == 1) {
            C0965kV c0965kVR = c0965kV.r(i + 8, false);
            MT[] mtArr = rp.d;
            if (c0965kVR != null) {
                c0965kVR.b();
                try {
                    c0965kVR.c(rp.d);
                    rpVar = new rp(16);
                    rpVar.b = pz0.t;
                    rpVar.b = c0965kVR.v(8, false).w0();
                    rpVar.c = c0965kVR.n(12);
                } finally {
                    c0965kVR.a();
                }
            }
            qpVar.c = rpVar;
            qpVar.a = 1;
        } else if (i2 == 2) {
            qpVar.d = c0965kV.d(i + 8, 0);
            qpVar.a = 2;
        }
        return qpVar;
    }

    @Override // defpackage.AbstractC0287Xj2
    public final void a(i70 i70Var, int i) {
        i70Var.b(16, i);
        i70Var.b(this.a, i + 4);
        int i2 = this.a;
        if (i2 == 0) {
            i70Var.n(this.b, i + 8, 0, -1);
            return;
        }
        if (i2 == 1) {
            i70Var.j(this.c, i + 8, false);
        } else {
            if (i2 != 2) {
                return;
            }
            i70Var.f(i + 8, this.d, 0);
        }
    }
}
