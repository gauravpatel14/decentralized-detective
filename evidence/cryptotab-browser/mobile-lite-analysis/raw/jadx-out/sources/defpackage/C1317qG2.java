package defpackage;

/* JADX INFO: renamed from: qG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1317qG2 implements InterfaceC1661wG2 {
    public final IQ2 a;
    public final String b;

    public C1317qG2(IQ2 iq2, String str) {
        this.a = iq2;
        this.b = str;
    }

    @Override // defpackage.InterfaceC1661wG2
    public final IQ2 a(InterfaceC1601vE2 interfaceC1601vE2) {
        IQ2 iq2A = this.a.a();
        iq2A.e(this.b, interfaceC1601vE2);
        return iq2A;
    }
}
