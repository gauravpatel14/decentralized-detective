package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class QG2 extends AbstractC0515dF2 {
    @Override // defpackage.AbstractC0515dF2
    public final InterfaceC1601vE2 a(String str, IQ2 iq2, ArrayList arrayList) {
        if (str == null || str.isEmpty() || !iq2.g(str)) {
            throw new IllegalArgumentException(Xd0.a("Command not found: ", str));
        }
        InterfaceC1601vE2 interfaceC1601vE2D = iq2.d(str);
        if (interfaceC1601vE2D instanceof AbstractC1823zD2) {
            return ((AbstractC1823zD2) interfaceC1601vE2D).a(iq2, arrayList);
        }
        throw new IllegalArgumentException(BN0.a("Function ", str, " is not defined"));
    }
}
