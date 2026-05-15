package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Sx1 extends Tx1 implements Iterator {
    public Rx1 t;
    public boolean u = true;
    public final /* synthetic */ Ux1 v;

    public Sx1(Ux1 ux1) {
        this.v = ux1;
    }

    @Override // defpackage.Tx1
    public final void a(Rx1 rx1) {
        Rx1 rx12 = this.t;
        if (rx1 == rx12) {
            Rx1 rx13 = rx12.w;
            this.t = rx13;
            this.u = rx13 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.u) {
            return this.v.t != null;
        }
        Rx1 rx1 = this.t;
        return (rx1 == null || rx1.v == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.u) {
            this.u = false;
            this.t = this.v.t;
        } else {
            Rx1 rx1 = this.t;
            this.t = rx1 != null ? rx1.v : null;
        }
        return this.t;
    }
}
