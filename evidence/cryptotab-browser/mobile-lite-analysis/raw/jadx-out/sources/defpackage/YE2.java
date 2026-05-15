package defpackage;

import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YE2 extends AbstractC0515dF2 {
    @Override // defpackage.AbstractC0515dF2
    public final InterfaceC1601vE2 a(String str, IQ2 iq2, ArrayList arrayList) {
        VG2 vg2 = VG2.u;
        switch (DS2.d(str).ordinal()) {
            case 4:
                DS2.g("BITWISE_AND", 2, arrayList);
                return new C1369rD2(Double.valueOf(DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue()) & DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue())));
            case 5:
                DS2.g("BITWISE_LEFT_SHIFT", 2, arrayList);
                return new C1369rD2(Double.valueOf(DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue()) << ((int) (((long) DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue())) & 31))));
            case 6:
                DS2.g("BITWISE_NOT", 1, arrayList);
                return new C1369rD2(Double.valueOf(~DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue())));
            case 7:
                DS2.g("BITWISE_OR", 2, arrayList);
                return new C1369rD2(Double.valueOf(DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue()) | DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue())));
            case 8:
                DS2.g("BITWISE_RIGHT_SHIFT", 2, arrayList);
                return new C1369rD2(Double.valueOf(DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue()) >> ((int) (((long) DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue())) & 31))));
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                DS2.g("BITWISE_UNSIGNED_RIGHT_SHIFT", 2, arrayList);
                return new C1369rD2(Double.valueOf((((long) DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue())) & 4294967295L) >>> ((int) (((long) DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue())) & 31))));
            case 10:
                DS2.g("BITWISE_XOR", 2, arrayList);
                return new C1369rD2(Double.valueOf(DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).b().doubleValue()) ^ DS2.b(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1)).b().doubleValue())));
            default:
                b(str);
                throw null;
        }
    }
}
