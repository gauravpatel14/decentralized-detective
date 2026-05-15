package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class O33 {
    public final TreeMap a = new TreeMap();
    public final TreeMap b = new TreeMap();

    public final void a(IQ2 iq2, C0944kC2 c0944kC2) {
        C1740xX2 c1740xX2 = new C1740xX2(c0944kC2);
        TreeMap treeMap = this.a;
        for (Integer num : treeMap.keySet()) {
            XB2 xb2Clone = c0944kC2.b.clone();
            InterfaceC1601vE2 interfaceC1601vE2A = ((C1135nE2) treeMap.get(num)).a(iq2, Collections.singletonList(c1740xX2));
            int iB = interfaceC1601vE2A instanceof C1369rD2 ? DS2.b(((C1369rD2) interfaceC1601vE2A).t.doubleValue()) : -1;
            if (iB == 2 || iB == -1) {
                c0944kC2.b = xb2Clone;
            }
        }
        TreeMap treeMap2 = this.b;
        Iterator it = treeMap2.keySet().iterator();
        while (it.hasNext()) {
            InterfaceC1601vE2 interfaceC1601vE2A2 = ((C1135nE2) treeMap2.get((Integer) it.next())).a(iq2, Collections.singletonList(c1740xX2));
            if (interfaceC1601vE2A2 instanceof C1369rD2) {
                DS2.b(((C1369rD2) interfaceC1601vE2A2).t.doubleValue());
            }
        }
    }
}
