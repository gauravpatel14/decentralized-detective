package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MG2 extends AbstractC0515dF2 {
    @Override // defpackage.AbstractC0515dF2
    public final InterfaceC1601vE2 a(String str, IQ2 iq2, ArrayList arrayList) {
        VG2 vg2 = VG2.u;
        int iOrdinal = DS2.d(str).ordinal();
        if (iOrdinal == 0) {
            DS2.g("ADD", 2, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2A = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
            InterfaceC1601vE2 interfaceC1601vE2A2 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
            if ((interfaceC1601vE2A instanceof SD2) || (interfaceC1601vE2A instanceof OE2) || (interfaceC1601vE2A2 instanceof SD2) || (interfaceC1601vE2A2 instanceof OE2)) {
                return new OE2(String.valueOf(interfaceC1601vE2A.zzi()).concat(String.valueOf(interfaceC1601vE2A2.zzi())));
            }
            return new C1369rD2(Double.valueOf(interfaceC1601vE2A2.b().doubleValue() + interfaceC1601vE2A.b().doubleValue()));
        }
        if (iOrdinal == 21) {
            DS2.g("DIVIDE", 2, arrayList);
            return new C1369rD2(Double.valueOf(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue() / iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue()));
        }
        if (iOrdinal == 59) {
            DS2.g("SUBTRACT", 2, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2A3 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
            return new C1369rD2(Double.valueOf(interfaceC1601vE2A3.b().doubleValue() + (-iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue())));
        }
        if (iOrdinal == 52 || iOrdinal == 53) {
            DS2.g(str, 2, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2A4 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
            iq2.b((InterfaceC1601vE2) arrayList.get(1));
            return interfaceC1601vE2A4;
        }
        if (iOrdinal == 55 || iOrdinal == 56) {
            DS2.g(str, 1, arrayList);
            return iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
        }
        switch (iOrdinal) {
            case 44:
                DS2.g("MODULUS", 2, arrayList);
                return new C1369rD2(Double.valueOf(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue() % iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue()));
            case 45:
                DS2.g("MULTIPLY", 2, arrayList);
                return new C1369rD2(Double.valueOf(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue() * iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue()));
            case 46:
                DS2.g("NEGATE", 1, arrayList);
                return new C1369rD2(Double.valueOf(-iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue()));
            default:
                b(str);
                throw null;
        }
    }
}
