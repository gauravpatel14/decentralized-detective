package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: jF2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0887jF2 extends AbstractC0515dF2 {
    public static boolean c(InterfaceC1601vE2 interfaceC1601vE2, InterfaceC1601vE2 interfaceC1601vE22) {
        if (interfaceC1601vE2.getClass().equals(interfaceC1601vE22.getClass())) {
            if ((interfaceC1601vE2 instanceof UE2) || (interfaceC1601vE2 instanceof C0691gE2)) {
                return true;
            }
            return interfaceC1601vE2 instanceof C1369rD2 ? (Double.isNaN(interfaceC1601vE2.b().doubleValue()) || Double.isNaN(interfaceC1601vE22.b().doubleValue()) || interfaceC1601vE2.b().doubleValue() != interfaceC1601vE22.b().doubleValue()) ? false : true : interfaceC1601vE2 instanceof OE2 ? interfaceC1601vE2.zzi().equals(interfaceC1601vE22.zzi()) : interfaceC1601vE2 instanceof ZC2 ? interfaceC1601vE2.zzg().equals(interfaceC1601vE22.zzg()) : interfaceC1601vE2 == interfaceC1601vE22;
        }
        if (((interfaceC1601vE2 instanceof UE2) || (interfaceC1601vE2 instanceof C0691gE2)) && ((interfaceC1601vE22 instanceof UE2) || (interfaceC1601vE22 instanceof C0691gE2))) {
            return true;
        }
        boolean z = interfaceC1601vE2 instanceof C1369rD2;
        if (z && (interfaceC1601vE22 instanceof OE2)) {
            return c(interfaceC1601vE2, new C1369rD2(interfaceC1601vE22.b()));
        }
        boolean z2 = interfaceC1601vE2 instanceof OE2;
        if (z2 && (interfaceC1601vE22 instanceof C1369rD2)) {
            return c(new C1369rD2(interfaceC1601vE2.b()), interfaceC1601vE22);
        }
        if (interfaceC1601vE2 instanceof ZC2) {
            return c(new C1369rD2(interfaceC1601vE2.b()), interfaceC1601vE22);
        }
        if (interfaceC1601vE22 instanceof ZC2) {
            return c(interfaceC1601vE2, new C1369rD2(interfaceC1601vE22.b()));
        }
        if ((z2 || z) && (interfaceC1601vE22 instanceof SD2)) {
            return c(interfaceC1601vE2, new OE2(interfaceC1601vE22.zzi()));
        }
        if ((interfaceC1601vE2 instanceof SD2) && ((interfaceC1601vE22 instanceof OE2) || (interfaceC1601vE22 instanceof C1369rD2))) {
            return c(new OE2(interfaceC1601vE2.zzi()), interfaceC1601vE22);
        }
        return false;
    }

    public static boolean d(InterfaceC1601vE2 interfaceC1601vE2, InterfaceC1601vE2 interfaceC1601vE22) {
        if (interfaceC1601vE2 instanceof SD2) {
            interfaceC1601vE2 = new OE2(interfaceC1601vE2.zzi());
        }
        if (interfaceC1601vE22 instanceof SD2) {
            interfaceC1601vE22 = new OE2(interfaceC1601vE22.zzi());
        }
        if ((interfaceC1601vE2 instanceof OE2) && (interfaceC1601vE22 instanceof OE2)) {
            return ((OE2) interfaceC1601vE2).t.compareTo(((OE2) interfaceC1601vE22).t) < 0;
        }
        double dDoubleValue = interfaceC1601vE2.b().doubleValue();
        double dDoubleValue2 = interfaceC1601vE22.b().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || ((dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    public static boolean e(InterfaceC1601vE2 interfaceC1601vE2, InterfaceC1601vE2 interfaceC1601vE22) {
        if (interfaceC1601vE2 instanceof SD2) {
            interfaceC1601vE2 = new OE2(interfaceC1601vE2.zzi());
        }
        if (interfaceC1601vE22 instanceof SD2) {
            interfaceC1601vE22 = new OE2(interfaceC1601vE22.zzi());
        }
        return (((interfaceC1601vE2 instanceof OE2) && (interfaceC1601vE22 instanceof OE2)) || !(Double.isNaN(interfaceC1601vE2.b().doubleValue()) || Double.isNaN(interfaceC1601vE22.b().doubleValue()))) && !d(interfaceC1601vE22, interfaceC1601vE2);
    }

    @Override // defpackage.AbstractC0515dF2
    public final InterfaceC1601vE2 a(String str, IQ2 iq2, ArrayList arrayList) {
        boolean zC;
        boolean zC2;
        DS2.g(DS2.d(str).name(), 2, arrayList);
        InterfaceC1601vE2 interfaceC1601vE2A = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
        InterfaceC1601vE2 interfaceC1601vE2A2 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
        int iOrdinal = DS2.d(str).ordinal();
        if (iOrdinal != 23) {
            if (iOrdinal == 48) {
                zC2 = c(interfaceC1601vE2A, interfaceC1601vE2A2);
            } else if (iOrdinal == 42) {
                zC = d(interfaceC1601vE2A, interfaceC1601vE2A2);
            } else if (iOrdinal != 43) {
                switch (iOrdinal) {
                    case 37:
                        zC = d(interfaceC1601vE2A2, interfaceC1601vE2A);
                        break;
                    case 38:
                        zC = e(interfaceC1601vE2A2, interfaceC1601vE2A);
                        break;
                    case 39:
                        zC = DS2.k(interfaceC1601vE2A, interfaceC1601vE2A2);
                        break;
                    case 40:
                        zC2 = DS2.k(interfaceC1601vE2A, interfaceC1601vE2A2);
                        break;
                    default:
                        b(str);
                        throw null;
                }
            } else {
                zC = e(interfaceC1601vE2A, interfaceC1601vE2A2);
            }
            zC = !zC2;
        } else {
            zC = c(interfaceC1601vE2A, interfaceC1601vE2A2);
        }
        return zC ? InterfaceC1601vE2.q : InterfaceC1601vE2.r;
    }
}
