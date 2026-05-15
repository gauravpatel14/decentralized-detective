package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RG2 extends AbstractC0515dF2 {
    @Override // defpackage.AbstractC0515dF2
    public final InterfaceC1601vE2 a(String str, IQ2 iq2, ArrayList arrayList) {
        String str2;
        VG2 vg2 = VG2.u;
        int iOrdinal = DS2.d(str).ordinal();
        int i = 0;
        if (iOrdinal == 3) {
            DS2.g("ASSIGN", 2, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2A = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
            if (!(interfaceC1601vE2A instanceof OE2)) {
                throw new IllegalArgumentException(Xd0.a("Expected string for assign var. got ", interfaceC1601vE2A.getClass().getCanonicalName()));
            }
            OE2 oe2 = (OE2) interfaceC1601vE2A;
            boolean zG = iq2.g(oe2.t);
            String str3 = oe2.t;
            if (!zG) {
                throw new IllegalArgumentException(Xd0.a("Attempting to assign undefined value ", str3));
            }
            InterfaceC1601vE2 interfaceC1601vE2A2 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
            iq2.f(str3, interfaceC1601vE2A2);
            return interfaceC1601vE2A2;
        }
        if (iOrdinal == 14) {
            DS2.h("CONST", 2, arrayList);
            if (arrayList.size() % 2 != 0) {
                throw new IllegalArgumentException(AbstractC1214oR1.a(arrayList.size(), "CONST requires an even number of arguments, found "));
            }
            while (i < arrayList.size() - 1) {
                InterfaceC1601vE2 interfaceC1601vE2A3 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(i));
                if (!(interfaceC1601vE2A3 instanceof OE2)) {
                    throw new IllegalArgumentException(Xd0.a("Expected string for const name. got ", interfaceC1601vE2A3.getClass().getCanonicalName()));
                }
                String str4 = ((OE2) interfaceC1601vE2A3).t;
                iq2.e(str4, iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(i + 1)));
                iq2.d.put(str4, Boolean.TRUE);
                i += 2;
            }
            return InterfaceC1601vE2.l;
        }
        if (iOrdinal == 24) {
            DS2.h("EXPRESSION_LIST", 1, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2A4 = InterfaceC1601vE2.l;
            while (i < arrayList.size()) {
                interfaceC1601vE2A4 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(i));
                if (interfaceC1601vE2A4 instanceof C0823iD2) {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
                i++;
            }
            return interfaceC1601vE2A4;
        }
        if (iOrdinal == 33) {
            DS2.g("GET", 1, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2A5 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
            if (interfaceC1601vE2A5 instanceof OE2) {
                return iq2.d(((OE2) interfaceC1601vE2A5).t);
            }
            throw new IllegalArgumentException(Xd0.a("Expected string for get var. got ", interfaceC1601vE2A5.getClass().getCanonicalName()));
        }
        if (iOrdinal == 49) {
            DS2.g("NULL", 0, arrayList);
            return InterfaceC1601vE2.m;
        }
        if (iOrdinal == 58) {
            DS2.g("SET_PROPERTY", 3, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2A6 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
            InterfaceC1601vE2 interfaceC1601vE2 = (InterfaceC1601vE2) arrayList.get(1);
            C0693gF2 c0693gF2 = iq2.b;
            InterfaceC1601vE2 interfaceC1601vE2A7 = c0693gF2.a(iq2, interfaceC1601vE2);
            InterfaceC1601vE2 interfaceC1601vE2A8 = c0693gF2.a(iq2, (InterfaceC1601vE2) arrayList.get(2));
            if (interfaceC1601vE2A6 != InterfaceC1601vE2.l && interfaceC1601vE2A6 != InterfaceC1601vE2.m) {
                if ((interfaceC1601vE2A6 instanceof PC2) && (interfaceC1601vE2A7 instanceof C1369rD2)) {
                    ((PC2) interfaceC1601vE2A6).p(((C1369rD2) interfaceC1601vE2A7).t.intValue(), interfaceC1601vE2A8);
                } else if (interfaceC1601vE2A6 instanceof SD2) {
                    ((SD2) interfaceC1601vE2A6).h(interfaceC1601vE2A7.zzi(), interfaceC1601vE2A8);
                }
                return interfaceC1601vE2A8;
            }
            throw new IllegalStateException("Can't set property " + interfaceC1601vE2A7.zzi() + " of " + interfaceC1601vE2A6.zzi());
        }
        if (iOrdinal == 17) {
            if (arrayList.isEmpty()) {
                return new PC2();
            }
            PC2 pc2 = new PC2();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                InterfaceC1601vE2 interfaceC1601vE2A9 = iq2.b.a(iq2, (InterfaceC1601vE2) it.next());
                if (interfaceC1601vE2A9 instanceof C0823iD2) {
                    throw new IllegalStateException("Failed to evaluate array element");
                }
                pc2.p(i, interfaceC1601vE2A9);
                i++;
            }
            return pc2;
        }
        if (iOrdinal == 18) {
            if (arrayList.isEmpty()) {
                return new C0394bE2();
            }
            if (arrayList.size() % 2 != 0) {
                throw new IllegalArgumentException(AbstractC1214oR1.a(arrayList.size(), "CREATE_OBJECT requires an even number of arguments, found "));
            }
            C0394bE2 c0394bE2 = new C0394bE2();
            while (i < arrayList.size() - 1) {
                InterfaceC1601vE2 interfaceC1601vE2A10 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(i));
                InterfaceC1601vE2 interfaceC1601vE2A11 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(i + 1));
                if ((interfaceC1601vE2A10 instanceof C0823iD2) || (interfaceC1601vE2A11 instanceof C0823iD2)) {
                    throw new IllegalStateException("Failed to evaluate map entry");
                }
                c0394bE2.h(interfaceC1601vE2A10.zzi(), interfaceC1601vE2A11);
                i += 2;
            }
            return c0394bE2;
        }
        if (iOrdinal == 35 || iOrdinal == 36) {
            DS2.g("GET_PROPERTY", 2, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2A12 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
            InterfaceC1601vE2 interfaceC1601vE2A13 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
            if ((interfaceC1601vE2A12 instanceof PC2) && DS2.j(interfaceC1601vE2A13)) {
                return ((PC2) interfaceC1601vE2A12).k(interfaceC1601vE2A13.b().intValue());
            }
            if (interfaceC1601vE2A12 instanceof SD2) {
                return ((SD2) interfaceC1601vE2A12).g(interfaceC1601vE2A13.zzi());
            }
            if (interfaceC1601vE2A12 instanceof OE2) {
                if ("length".equals(interfaceC1601vE2A13.zzi())) {
                    return new C1369rD2(Double.valueOf(((OE2) interfaceC1601vE2A12).t.length()));
                }
                if (DS2.j(interfaceC1601vE2A13)) {
                    OE2 oe22 = (OE2) interfaceC1601vE2A12;
                    if (interfaceC1601vE2A13.b().doubleValue() < oe22.t.length()) {
                        return new OE2(String.valueOf(oe22.t.charAt(interfaceC1601vE2A13.b().intValue())));
                    }
                }
            }
            return InterfaceC1601vE2.l;
        }
        switch (iOrdinal) {
            case 62:
                DS2.g("TYPEOF", 1, arrayList);
                InterfaceC1601vE2 interfaceC1601vE2A14 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
                if (interfaceC1601vE2A14 instanceof UE2) {
                    str2 = "undefined";
                } else if (interfaceC1601vE2A14 instanceof ZC2) {
                    str2 = "boolean";
                } else if (interfaceC1601vE2A14 instanceof C1369rD2) {
                    str2 = "number";
                } else if (interfaceC1601vE2A14 instanceof OE2) {
                    str2 = "string";
                } else if (interfaceC1601vE2A14 instanceof C1135nE2) {
                    str2 = "function";
                } else {
                    if ((interfaceC1601vE2A14 instanceof C1717xE2) || (interfaceC1601vE2A14 instanceof C0823iD2)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", interfaceC1601vE2A14));
                    }
                    str2 = "object";
                }
                return new OE2(str2);
            case 63:
                DS2.g("UNDEFINED", 0, arrayList);
                return InterfaceC1601vE2.l;
            case 64:
                DS2.h("VAR", 1, arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    InterfaceC1601vE2 interfaceC1601vE2A15 = iq2.b.a(iq2, (InterfaceC1601vE2) it2.next());
                    if (!(interfaceC1601vE2A15 instanceof OE2)) {
                        throw new IllegalArgumentException(Xd0.a("Expected string for var name. got ", interfaceC1601vE2A15.getClass().getCanonicalName()));
                    }
                    iq2.e(((OE2) interfaceC1601vE2A15).t, InterfaceC1601vE2.l);
                }
                return InterfaceC1601vE2.l;
            default:
                b(str);
                throw null;
        }
    }
}
