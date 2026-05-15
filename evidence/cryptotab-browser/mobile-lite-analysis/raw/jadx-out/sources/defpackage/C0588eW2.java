package defpackage;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: eW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0588eW2 extends AbstractC1823zD2 {
    public final C0944kC2 v;

    public C0588eW2(C0944kC2 c0944kC2) {
        super("internal.eventLogger");
        this.v = c0944kC2;
    }

    @Override // defpackage.AbstractC1823zD2
    public final InterfaceC1601vE2 a(IQ2 iq2, List list) {
        DS2.g(this.t, 3, list);
        String strZzi = iq2.b.a(iq2, (InterfaceC1601vE2) list.get(0)).zzi();
        InterfaceC1601vE2 interfaceC1601vE2 = (InterfaceC1601vE2) list.get(1);
        C0693gF2 c0693gF2 = iq2.b;
        long jA = (long) DS2.a(c0693gF2.a(iq2, interfaceC1601vE2).b().doubleValue());
        InterfaceC1601vE2 interfaceC1601vE2A = c0693gF2.a(iq2, (InterfaceC1601vE2) list.get(2));
        HashMap mapF = interfaceC1601vE2A instanceof C0394bE2 ? DS2.f((C0394bE2) interfaceC1601vE2A) : new HashMap();
        C0944kC2 c0944kC2 = this.v;
        c0944kC2.getClass();
        c0944kC2.c.add(new XB2(strZzi, jA, mapF));
        return InterfaceC1601vE2.l;
    }
}
