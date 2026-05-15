package defpackage;

/* JADX INFO: renamed from: q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1302q extends P implements InterfaceC0870iz {
    @Override // defpackage.P
    public final InterfaceC0805hr1 f() {
        InterfaceC0805hr1 interfaceC0805hr1F = super.f();
        if (interfaceC0805hr1F != null) {
            boolean z = interfaceC0805hr1F instanceof C1433sG;
        }
        return interfaceC0805hr1F;
    }

    public boolean i(C1059m c1059m) {
        int iV;
        PI0 pi0Q;
        boolean zJ = j();
        LI0 li0 = this.c;
        if (!zJ) {
            C1245p c1245p = new C1245p(c1059m, this);
            do {
                PI0 pi0Q2 = li0.q();
                if (pi0Q2 instanceof xE1) {
                    break;
                }
                iV = pi0Q2.v(c1059m, li0, c1245p);
                if (iV == 1) {
                    return true;
                }
            } while (iV != 2);
        } else {
            do {
                pi0Q = li0.q();
                if (pi0Q instanceof xE1) {
                }
            } while (!pi0Q.l(c1059m, li0));
            return true;
        }
        return false;
    }

    public abstract boolean j();

    public abstract boolean k();

    public Object l() {
        xE1 xe1G = g();
        return xe1G == null ? r.d : xe1G.w();
    }
}
