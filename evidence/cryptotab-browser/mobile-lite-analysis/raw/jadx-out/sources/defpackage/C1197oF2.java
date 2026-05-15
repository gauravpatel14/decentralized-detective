package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: oF2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1197oF2 extends AbstractC0515dF2 {
    public static C1135nE2 c(IQ2 iq2, ArrayList arrayList) {
        VG2 vg2 = VG2.u;
        DS2.h("FN", 2, arrayList);
        InterfaceC1601vE2 interfaceC1601vE2A = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0));
        InterfaceC1601vE2 interfaceC1601vE2A2 = iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(1));
        if (!(interfaceC1601vE2A2 instanceof PC2)) {
            throw new IllegalArgumentException(Xd0.a("FN requires an ArrayValue of parameter names found ", interfaceC1601vE2A2.getClass().getCanonicalName()));
        }
        ArrayList arrayListN = ((PC2) interfaceC1601vE2A2).n();
        List arrayList2 = new ArrayList();
        if (arrayList.size() > 2) {
            arrayList2 = arrayList.subList(2, arrayList.size());
        }
        return new C1135nE2(interfaceC1601vE2A.zzi(), arrayListN, arrayList2, iq2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0120, code lost:
    
        if (r10.equals("continue") == false) goto L64;
     */
    @Override // defpackage.AbstractC0515dF2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.InterfaceC1601vE2 a(java.lang.String r10, defpackage.IQ2 r11, java.util.ArrayList r12) {
        /*
            Method dump skipped, instruction units count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1197oF2.a(java.lang.String, IQ2, java.util.ArrayList):vE2");
    }
}
