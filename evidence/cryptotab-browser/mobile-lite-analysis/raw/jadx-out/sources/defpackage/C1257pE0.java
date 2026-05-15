package defpackage;

import java.util.HashSet;
import java.util.Iterator;
import org.chromium.base.Callback;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: renamed from: pE0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1257pE0 implements InterfaceC0546dn1 {
    public final HashSet A;
    public final PropertyModel t;
    public final C0257Vm1 u;
    public final C1134nE0 v;
    public final InterfaceC1350qp2 w;
    public final InterfaceC0436bn1 x;
    public boolean y;
    public Object z;

    public C1257pE0(PropertyModel propertyModel, C0257Vm1 c0257Vm1, C1134nE0 c1134nE0, InterfaceC1350qp2 interfaceC1350qp2, InterfaceC0436bn1 interfaceC0436bn1) {
        HashSet hashSet = new HashSet();
        this.A = hashSet;
        this.t = propertyModel;
        this.u = c0257Vm1;
        this.v = c1134nE0;
        this.w = interfaceC1350qp2;
        this.x = interfaceC0436bn1;
        hashSet.addAll(propertyModel.i());
        interfaceC1350qp2.a(new Callback() { // from class: oE0
            @Override // org.chromium.base.Callback
            /* JADX INFO: renamed from: onResult */
            public final void a0(Object obj) {
                C1257pE0 c1257pE0 = this.t;
                c1257pE0.z = obj;
                c1257pE0.y = false;
                c1257pE0.b();
            }
        });
        propertyModel.a(this);
    }

    @Override // defpackage.InterfaceC0546dn1
    public final void a(PropertyModel propertyModel, AbstractC0197Qm1 abstractC0197Qm1) {
        this.A.add(abstractC0197Qm1);
        if (this.t.h(this.v.a) || abstractC0197Qm1 == this.u) {
            if (this.z != null) {
                b();
            } else {
                if (this.y) {
                    return;
                }
                this.y = true;
                this.w.b();
            }
        }
    }

    public final void b() {
        PropertyModel propertyModel;
        InterfaceC0436bn1 interfaceC0436bn1;
        C0257Vm1 c0257Vm1;
        HashSet hashSet = this.A;
        Iterator it = hashSet.iterator();
        boolean z = false;
        while (true) {
            boolean zHasNext = it.hasNext();
            propertyModel = this.t;
            interfaceC0436bn1 = this.x;
            c0257Vm1 = this.u;
            if (!zHasNext) {
                break;
            }
            Object next = it.next();
            if (next == c0257Vm1) {
                z = true;
            } else {
                interfaceC0436bn1.f(propertyModel, this.z, next);
            }
        }
        if (z) {
            interfaceC0436bn1.f(propertyModel, this.z, c0257Vm1);
        }
        hashSet.clear();
    }
}
