package defpackage;

import java.util.Iterator;
import java.util.List;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: renamed from: Km1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0119Km1 extends LG0 {
    public final C0113Jm1 v = new InterfaceC0546dn1() { // from class: Jm1
        @Override // defpackage.InterfaceC0546dn1
        public final void a(PropertyModel propertyModel, AbstractC0197Qm1 abstractC0197Qm1) {
            C0119Km1 c0119Km1 = this.t;
            c0119Km1.n(c0119Km1.u.indexOf(propertyModel), 1, abstractC0197Qm1);
        }
    };

    @Override // defpackage.LG0
    public final Object w(int i) {
        PropertyModel propertyModel = (PropertyModel) super.w(i);
        propertyModel.k(this.v);
        return propertyModel;
    }

    @Override // defpackage.LG0
    public final void x(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            ((PropertyModel) this.u.get(i3)).k(this.v);
        }
        super.x(0, i2);
    }

    @Override // defpackage.LG0
    public final void y(List list) {
        C0113Jm1 c0113Jm1;
        Iterator it = this.u.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            c0113Jm1 = this.v;
            if (!zHasNext) {
                break;
            } else {
                ((PropertyModel) it.next()).k(c0113Jm1);
            }
        }
        super.y(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ((PropertyModel) it2.next()).a(c0113Jm1);
        }
    }
}
