package defpackage;

import java.util.List;
import java.util.TreeMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class X23 extends AbstractC1823zD2 {
    public final O33 v;

    public X23(O33 o33) {
        super("internal.registerCallback");
        this.v = o33;
    }

    @Override // defpackage.AbstractC1823zD2
    public final InterfaceC1601vE2 a(IQ2 iq2, List list) {
        TreeMap treeMap;
        DS2.g(this.t, 3, list);
        iq2.b.a(iq2, (InterfaceC1601vE2) list.get(0)).zzi();
        InterfaceC1601vE2 interfaceC1601vE2 = (InterfaceC1601vE2) list.get(1);
        C0693gF2 c0693gF2 = iq2.b;
        InterfaceC1601vE2 interfaceC1601vE2A = c0693gF2.a(iq2, interfaceC1601vE2);
        if (!(interfaceC1601vE2A instanceof C1135nE2)) {
            throw new IllegalArgumentException("Invalid callback type");
        }
        InterfaceC1601vE2 interfaceC1601vE2A2 = c0693gF2.a(iq2, (InterfaceC1601vE2) list.get(2));
        if (!(interfaceC1601vE2A2 instanceof C0394bE2)) {
            throw new IllegalArgumentException("Invalid callback params");
        }
        C0394bE2 c0394bE2 = (C0394bE2) interfaceC1601vE2A2;
        if (!c0394bE2.t.containsKey("type")) {
            throw new IllegalArgumentException("Undefined rule type");
        }
        String strZzi = c0394bE2.g("type").zzi();
        int iB = c0394bE2.t.containsKey("priority") ? DS2.b(c0394bE2.g("priority").b().doubleValue()) : 1000;
        C1135nE2 c1135nE2 = (C1135nE2) interfaceC1601vE2A;
        O33 o33 = this.v;
        o33.getClass();
        if ("create".equals(strZzi)) {
            treeMap = o33.b;
        } else {
            if (!"edit".equals(strZzi)) {
                throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(strZzi)));
            }
            treeMap = o33.a;
        }
        if (treeMap.containsKey(Integer.valueOf(iB))) {
            iB = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(iB), c1135nE2);
        return InterfaceC1601vE2.l;
    }
}
