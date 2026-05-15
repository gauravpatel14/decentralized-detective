package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HG2 extends AbstractC0515dF2 {
    public static InterfaceC1601vE2 c(InterfaceC1661wG2 interfaceC1661wG2, Iterator it, InterfaceC1601vE2 interfaceC1601vE2) {
        if (it != null) {
            while (it.hasNext()) {
                InterfaceC1601vE2 interfaceC1601vE2C = interfaceC1661wG2.a((InterfaceC1601vE2) it.next()).c((PC2) interfaceC1601vE2);
                if (interfaceC1601vE2C instanceof C0823iD2) {
                    C0823iD2 c0823iD2 = (C0823iD2) interfaceC1601vE2C;
                    if ("break".equals(c0823iD2.u)) {
                        return InterfaceC1601vE2.l;
                    }
                    if ("return".equals(c0823iD2.u)) {
                        return c0823iD2;
                    }
                }
            }
        }
        return InterfaceC1601vE2.l;
    }

    public static InterfaceC1601vE2 d(InterfaceC1661wG2 interfaceC1661wG2, InterfaceC1601vE2 interfaceC1601vE2, InterfaceC1601vE2 interfaceC1601vE22) {
        if (interfaceC1601vE2 instanceof Iterable) {
            return c(interfaceC1661wG2, ((Iterable) interfaceC1601vE2).iterator(), interfaceC1601vE22);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    @Override // defpackage.AbstractC0515dF2
    public final InterfaceC1601vE2 a(String str, IQ2 iq2, ArrayList arrayList) {
        VG2 vg2 = VG2.u;
        int iOrdinal = DS2.d(str).ordinal();
        if (iOrdinal == 65) {
            DS2.g("WHILE", 4, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2 = (InterfaceC1601vE2) arrayList.get(0);
            InterfaceC1601vE2 interfaceC1601vE22 = (InterfaceC1601vE2) arrayList.get(1);
            InterfaceC1601vE2 interfaceC1601vE23 = (InterfaceC1601vE2) arrayList.get(2);
            InterfaceC1601vE2 interfaceC1601vE2A = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(3));
            C0693gF2 c0693gF2 = iq2.b;
            if (c0693gF2.a(iq2, interfaceC1601vE23).zzg().booleanValue()) {
                InterfaceC1601vE2 interfaceC1601vE2C = iq2.c((PC2) interfaceC1601vE2A);
                if (interfaceC1601vE2C instanceof C0823iD2) {
                    C0823iD2 c0823iD2 = (C0823iD2) interfaceC1601vE2C;
                    if ("break".equals(c0823iD2.u)) {
                        return InterfaceC1601vE2.l;
                    }
                    if ("return".equals(c0823iD2.u)) {
                        return c0823iD2;
                    }
                }
            }
            while (c0693gF2.a(iq2, interfaceC1601vE2).zzg().booleanValue()) {
                InterfaceC1601vE2 interfaceC1601vE2C2 = iq2.c((PC2) interfaceC1601vE2A);
                if (interfaceC1601vE2C2 instanceof C0823iD2) {
                    C0823iD2 c0823iD22 = (C0823iD2) interfaceC1601vE2C2;
                    if ("break".equals(c0823iD22.u)) {
                        return InterfaceC1601vE2.l;
                    }
                    if ("return".equals(c0823iD22.u)) {
                        return c0823iD22;
                    }
                }
                iq2.b(interfaceC1601vE22);
            }
            return InterfaceC1601vE2.l;
        }
        switch (iOrdinal) {
            case 26:
                DS2.g("FOR_IN", 3, arrayList);
                if (!(arrayList.get(0) instanceof OE2)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                }
                String strZzi = ((InterfaceC1601vE2) arrayList.get(0)).zzi();
                InterfaceC1601vE2 interfaceC1601vE2A2 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
                InterfaceC1601vE2 interfaceC1601vE2A3 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(2));
                Iterator itF = interfaceC1601vE2A2.f();
                if (itF != null) {
                    while (itF.hasNext()) {
                        iq2.e(strZzi, (InterfaceC1601vE2) itF.next());
                        InterfaceC1601vE2 interfaceC1601vE2C3 = iq2.c((PC2) interfaceC1601vE2A3);
                        if (interfaceC1601vE2C3 instanceof C0823iD2) {
                            C0823iD2 c0823iD23 = (C0823iD2) interfaceC1601vE2C3;
                            if ("break".equals(c0823iD23.u)) {
                                return InterfaceC1601vE2.l;
                            }
                            if ("return".equals(c0823iD23.u)) {
                                return c0823iD23;
                            }
                        }
                    }
                }
                return InterfaceC1601vE2.l;
            case 27:
                DS2.g("FOR_IN_CONST", 3, arrayList);
                if (!(arrayList.get(0) instanceof OE2)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                }
                return c(new C0950kG2(iq2, ((InterfaceC1601vE2) arrayList.get(0)).zzi()), iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).f(), iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(2)));
            case 28:
                DS2.g("FOR_IN_LET", 3, arrayList);
                if (!(arrayList.get(0) instanceof OE2)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                }
                String strZzi2 = ((InterfaceC1601vE2) arrayList.get(0)).zzi();
                InterfaceC1601vE2 interfaceC1601vE2A4 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
                InterfaceC1601vE2 interfaceC1601vE2A5 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(2));
                Iterator itF2 = interfaceC1601vE2A4.f();
                if (itF2 != null) {
                    while (itF2.hasNext()) {
                        InterfaceC1601vE2 interfaceC1601vE24 = (InterfaceC1601vE2) itF2.next();
                        IQ2 iq2A = iq2.a();
                        iq2A.e(strZzi2, interfaceC1601vE24);
                        InterfaceC1601vE2 interfaceC1601vE2C4 = iq2A.c((PC2) interfaceC1601vE2A5);
                        if (interfaceC1601vE2C4 instanceof C0823iD2) {
                            C0823iD2 c0823iD24 = (C0823iD2) interfaceC1601vE2C4;
                            if ("break".equals(c0823iD24.u)) {
                                return InterfaceC1601vE2.l;
                            }
                            if ("return".equals(c0823iD24.u)) {
                                return c0823iD24;
                            }
                        }
                    }
                }
                return InterfaceC1601vE2.l;
            case 29:
                DS2.g("FOR_LET", 4, arrayList);
                InterfaceC1601vE2 interfaceC1601vE2A6 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
                if (!(interfaceC1601vE2A6 instanceof PC2)) {
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                }
                PC2 pc2 = (PC2) interfaceC1601vE2A6;
                InterfaceC1601vE2 interfaceC1601vE25 = (InterfaceC1601vE2) arrayList.get(1);
                InterfaceC1601vE2 interfaceC1601vE26 = (InterfaceC1601vE2) arrayList.get(2);
                InterfaceC1601vE2 interfaceC1601vE27 = (InterfaceC1601vE2) arrayList.get(3);
                C0693gF2 c0693gF22 = iq2.b;
                InterfaceC1601vE2 interfaceC1601vE2A7 = c0693gF22.a(iq2, interfaceC1601vE27);
                IQ2 iq2A2 = iq2.a();
                for (int i = 0; i < pc2.j(); i++) {
                    String strZzi3 = pc2.k(i).zzi();
                    iq2A2.f(strZzi3, iq2.d(strZzi3));
                }
                while (c0693gF22.a(iq2, interfaceC1601vE25).zzg().booleanValue()) {
                    InterfaceC1601vE2 interfaceC1601vE2C5 = iq2.c((PC2) interfaceC1601vE2A7);
                    if (interfaceC1601vE2C5 instanceof C0823iD2) {
                        C0823iD2 c0823iD25 = (C0823iD2) interfaceC1601vE2C5;
                        if ("break".equals(c0823iD25.u)) {
                            return InterfaceC1601vE2.l;
                        }
                        if ("return".equals(c0823iD25.u)) {
                            return c0823iD25;
                        }
                    }
                    IQ2 iq2A3 = iq2.a();
                    for (int i2 = 0; i2 < pc2.j(); i2++) {
                        String strZzi4 = pc2.k(i2).zzi();
                        iq2A3.f(strZzi4, iq2A2.d(strZzi4));
                    }
                    iq2A3.b(interfaceC1601vE26);
                    iq2A2 = iq2A3;
                }
                return InterfaceC1601vE2.l;
            case 30:
                DS2.g("FOR_OF", 3, arrayList);
                if (!(arrayList.get(0) instanceof OE2)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                }
                return d(new GG2(iq2, ((InterfaceC1601vE2) arrayList.get(0)).zzi()), iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)), iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(2)));
            case 31:
                DS2.g("FOR_OF_CONST", 3, arrayList);
                if (!(arrayList.get(0) instanceof OE2)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                }
                return d(new C0950kG2(iq2, ((InterfaceC1601vE2) arrayList.get(0)).zzi()), iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)), iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(2)));
            case 32:
                DS2.g("FOR_OF_LET", 3, arrayList);
                if (!(arrayList.get(0) instanceof OE2)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                }
                return d(new C1317qG2(iq2, ((InterfaceC1601vE2) arrayList.get(0)).zzi()), iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)), iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(2)));
            default:
                b(str);
                throw null;
        }
    }
}
