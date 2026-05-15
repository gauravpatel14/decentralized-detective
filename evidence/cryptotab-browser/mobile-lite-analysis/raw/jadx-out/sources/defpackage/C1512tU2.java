package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: tU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1512tU2 implements Serializable, InterfaceC1394rU2 {
    public final InterfaceC1394rU2 t;
    public volatile transient boolean u;
    public transient Object v;

    public C1512tU2(InterfaceC1394rU2 interfaceC1394rU2) {
        this.t = interfaceC1394rU2;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (this.u) {
            obj = "<supplier that returned " + this.v + ">";
        } else {
            obj = this.t;
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
                        Object objZza = this.t.zza();
                        this.v = objZza;
                        this.u = true;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.v;
    }
}
