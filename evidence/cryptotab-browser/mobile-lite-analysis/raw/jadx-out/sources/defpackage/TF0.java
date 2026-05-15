package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TF0 extends AbstractC1302q {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.P
    public final Object e(Object obj) {
        InterfaceC0805hr1 interfaceC0805hr1;
        do {
            Object objE = super.e(obj);
            eT1 et1 = r.b;
            if (objE == et1) {
                return et1;
            }
            if (objE != r.c) {
                if (objE instanceof C1433sG) {
                    return objE;
                }
                throw new IllegalStateException(("Invalid offerInternal result " + objE).toString());
            }
            LI0 li0 = this.c;
            O o = new O(obj);
            while (true) {
                PI0 pi0Q = li0.q();
                if (pi0Q instanceof InterfaceC0805hr1) {
                    interfaceC0805hr1 = (InterfaceC0805hr1) pi0Q;
                    break;
                }
                if (pi0Q.l(o, li0)) {
                    interfaceC0805hr1 = null;
                    break;
                }
            }
            if (interfaceC0805hr1 == null) {
                return et1;
            }
        } while (!(interfaceC0805hr1 instanceof C1433sG));
        return interfaceC0805hr1;
    }

    @Override // defpackage.AbstractC1302q
    public final boolean j() {
        return true;
    }

    @Override // defpackage.AbstractC1302q
    public final boolean k() {
        return true;
    }
}
