package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Qx1 extends Tx1 implements Iterator {
    public Rx1 t;
    public Rx1 u;
    public final /* synthetic */ int v;

    public Qx1(Rx1 rx1, Rx1 rx12, int i) {
        this.v = i;
        this.t = rx12;
        this.u = rx1;
    }

    @Override // defpackage.Tx1
    public final void a(Rx1 rx1) {
        Rx1 rx12;
        Rx1 rx1B = null;
        if (this.t == rx1 && rx1 == this.u) {
            this.u = null;
            this.t = null;
        }
        Rx1 rx13 = this.t;
        if (rx13 == rx1) {
            switch (this.v) {
                case 0:
                    rx12 = rx13.w;
                    break;
                default:
                    rx12 = rx13.v;
                    break;
            }
            this.t = rx12;
        }
        Rx1 rx14 = this.u;
        if (rx14 == rx1) {
            Rx1 rx15 = this.t;
            if (rx14 != rx15 && rx15 != null) {
                rx1B = b(rx14);
            }
            this.u = rx1B;
        }
    }

    public final Rx1 b(Rx1 rx1) {
        switch (this.v) {
            case 0:
                return rx1.v;
            default:
                return rx1.w;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.u != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Rx1 rx1 = this.u;
        Rx1 rx12 = this.t;
        this.u = (rx1 == rx12 || rx12 == null) ? null : b(rx1);
        return rx1;
    }
}
