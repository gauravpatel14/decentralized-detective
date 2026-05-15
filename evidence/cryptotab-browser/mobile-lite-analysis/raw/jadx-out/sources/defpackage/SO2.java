package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SO2 {
    public final C0693gF2 a;
    public final IQ2 b;
    public final IQ2 c;
    public final C0416bV2 d;

    public SO2() {
        C0693gF2 c0693gF2 = new C0693gF2();
        this.a = c0693gF2;
        IQ2 iq2 = new IQ2(null, c0693gF2);
        this.c = iq2;
        this.b = iq2.a();
        C0416bV2 c0416bV2 = new C0416bV2();
        this.d = c0416bV2;
        iq2.f("require", new C0751h33(c0416bV2));
        c0416bV2.a.put("internal.platform", XM2.a);
        iq2.f("runtime.counter", new C1369rD2(Double.valueOf(0.0d)));
    }

    public final InterfaceC1601vE2 a(IQ2 iq2, eS2... es2Arr) {
        InterfaceC1601vE2 interfaceC1601vE2A = InterfaceC1601vE2.l;
        for (eS2 es2 : es2Arr) {
            interfaceC1601vE2A = AbstractC0712gU2.a(es2);
            DS2.c(this.c);
            if ((interfaceC1601vE2A instanceof C1717xE2) || (interfaceC1601vE2A instanceof C1135nE2)) {
                interfaceC1601vE2A = this.a.a(iq2, interfaceC1601vE2A);
            }
        }
        return interfaceC1601vE2A;
    }
}
