package defpackage;

import java.util.HashSet;
import java.util.Set;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class oU0 implements QG0, InterfaceC0546dn1 {
    public final Runnable t;
    public final QJ0 u;
    public final HashSet v;
    public Set w = new HashSet();

    public oU0(Runnable runnable, QJ0 qj0, HashSet hashSet) {
        this.t = runnable;
        this.u = qj0;
        this.v = hashSet;
        qj0.l(this);
        j(qj0, 0, qj0.u.size());
    }

    @Override // defpackage.InterfaceC0546dn1
    public final void a(PropertyModel propertyModel, AbstractC0197Qm1 abstractC0197Qm1) {
        if (this.v.contains(abstractC0197Qm1)) {
            this.t.run();
        }
    }

    @Override // defpackage.QG0
    public final void f(int i, int i2) {
        HashSet hashSet = new HashSet();
        int i3 = 0;
        while (true) {
            QJ0 qj0 = this.u;
            if (i3 >= qj0.u.size()) {
                break;
            }
            hashSet.add(((PJ0) qj0.u.get(i3)).b);
            i3++;
        }
        for (PropertyModel propertyModel : this.w) {
            if (!hashSet.contains(propertyModel)) {
                propertyModel.k(this);
            }
        }
        this.w = hashSet;
        this.t.run();
    }

    @Override // defpackage.QG0
    public final void j(SG0 sg0, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            PJ0 pj0 = (PJ0) this.u.u.get(i + i3);
            pj0.b.a(this);
            this.w.add(pj0.b);
        }
        this.t.run();
    }
}
