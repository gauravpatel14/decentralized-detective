package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: cG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0457cG2 {
    public static PC2 a(PC2 pc2, IQ2 iq2, C1135nE2 c1135nE2, Boolean bool, Boolean bool2) {
        PC2 pc22 = new PC2();
        Iterator itM = pc2.m();
        while (itM.hasNext()) {
            int iIntValue = ((Integer) itM.next()).intValue();
            if (pc2.r(iIntValue)) {
                InterfaceC1601vE2 interfaceC1601vE2A = c1135nE2.a(iq2, Arrays.asList(pc2.k(iIntValue), new C1369rD2(Double.valueOf(iIntValue)), pc2));
                if (interfaceC1601vE2A.zzg().equals(bool)) {
                    return pc22;
                }
                if (bool2 == null || interfaceC1601vE2A.zzg().equals(bool2)) {
                    pc22.p(iIntValue, interfaceC1601vE2A);
                }
            }
        }
        return pc22;
    }

    public static InterfaceC1601vE2 b(PC2 pc2, IQ2 iq2, ArrayList arrayList, boolean z) {
        InterfaceC1601vE2 interfaceC1601vE2A;
        DS2.h("reduce", 1, arrayList);
        DS2.i(2, "reduce", arrayList);
        InterfaceC1601vE2 interfaceC1601vE2A2 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
        if (!(interfaceC1601vE2A2 instanceof AbstractC1823zD2)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (arrayList.size() == 2) {
            interfaceC1601vE2A = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
            if (interfaceC1601vE2A instanceof C0823iD2) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (pc2.j() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            interfaceC1601vE2A = null;
        }
        AbstractC1823zD2 abstractC1823zD2 = (AbstractC1823zD2) interfaceC1601vE2A2;
        int iJ = pc2.j();
        int i = z ? 0 : iJ - 1;
        int i2 = z ? iJ - 1 : 0;
        int i3 = true == z ? 1 : -1;
        if (interfaceC1601vE2A == null) {
            interfaceC1601vE2A = pc2.k(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (pc2.r(i)) {
                interfaceC1601vE2A = abstractC1823zD2.a(iq2, Arrays.asList(interfaceC1601vE2A, pc2.k(i), new C1369rD2(Double.valueOf(i)), pc2));
                if (interfaceC1601vE2A instanceof C0823iD2) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return interfaceC1601vE2A;
    }
}
