package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: eG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0567eG2 extends AbstractC0515dF2 {
    @Override // defpackage.AbstractC0515dF2
    public final InterfaceC1601vE2 a(String str, IQ2 iq2, ArrayList arrayList) {
        VG2 vg2 = VG2.u;
        int iOrdinal = DS2.d(str).ordinal();
        if (iOrdinal == 1) {
            DS2.g("AND", 2, arrayList);
            InterfaceC1601vE2 interfaceC1601vE2A = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
            if (!interfaceC1601vE2A.zzg().booleanValue()) {
                return interfaceC1601vE2A;
            }
            return iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
        }
        if (iOrdinal == 47) {
            DS2.g("NOT", 1, arrayList);
            return new ZC2(Boolean.valueOf(!iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).zzg().booleanValue()));
        }
        if (iOrdinal != 50) {
            b(str);
            throw null;
        }
        DS2.g("OR", 2, arrayList);
        InterfaceC1601vE2 interfaceC1601vE2A2 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
        if (interfaceC1601vE2A2.zzg().booleanValue()) {
            return interfaceC1601vE2A2;
        }
        return iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
    }
}
