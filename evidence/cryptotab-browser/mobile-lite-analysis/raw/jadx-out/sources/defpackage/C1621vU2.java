package defpackage;

/* JADX INFO: renamed from: vU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1621vU2 implements InterfaceC1394rU2 {
    public volatile InterfaceC1394rU2 t;
    public volatile boolean u;
    public Object v;

    public final String toString() {
        Object obj = this.t;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.v + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    @Override // defpackage.InterfaceC1394rU2
    public final Object zza() {
        if (!this.u) {
            synchronized (this) {
                try {
                    if (!this.u) {
                        InterfaceC1394rU2 interfaceC1394rU2 = this.t;
                        interfaceC1394rU2.getClass();
                        Object objZza = interfaceC1394rU2.zza();
                        this.v = objZza;
                        this.u = true;
                        this.t = null;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.v;
    }
}
