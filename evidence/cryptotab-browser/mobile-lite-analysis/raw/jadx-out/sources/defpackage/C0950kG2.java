package defpackage;

/* JADX INFO: renamed from: kG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0950kG2 implements InterfaceC1661wG2 {
    public final IQ2 a;
    public final String b;

    public C0950kG2(IQ2 iq2, String str) {
        this.a = iq2;
        this.b = str;
    }

    @Override // defpackage.InterfaceC1661wG2
    public final IQ2 a(InterfaceC1601vE2 interfaceC1601vE2) {
        IQ2 iq2A = this.a.a();
        String str = this.b;
        iq2A.e(str, interfaceC1601vE2);
        iq2A.d.put(str, Boolean.TRUE);
        return iq2A;
    }
}
