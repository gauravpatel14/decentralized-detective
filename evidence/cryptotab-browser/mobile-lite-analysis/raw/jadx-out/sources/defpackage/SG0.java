package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SG0 implements RG0 {
    public final M21 t = new M21();

    public void f(int i, int i2) {
        p(i, i2);
    }

    public final void l(QG0 qg0) {
        this.t.e(qg0);
    }

    public final void m(int i, int i2) {
        Iterator it = this.t.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((QG0) l21.next()).h(i, i2);
            }
        }
    }

    public void n(int i, int i2, Object obj) {
        Iterator it = this.t.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((QG0) l21.next()).e(this, i, i2, obj);
            }
        }
    }

    public void o(int i, int i2) {
        Iterator it = this.t.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((QG0) l21.next()).j(this, i, i2);
            }
        }
    }

    public void p(int i, int i2) {
        Iterator it = this.t.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((QG0) l21.next()).f(i, i2);
            }
        }
    }

    public final void r(QG0 qg0) {
        this.t.g(qg0);
    }
}
