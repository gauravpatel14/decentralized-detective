package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class GD2 {
    public static InterfaceC1601vE2 a(SD2 sd2, OE2 oe2, IQ2 iq2, ArrayList arrayList) {
        String str = oe2.t;
        if (sd2.e(str)) {
            InterfaceC1601vE2 interfaceC1601vE2G = sd2.g(str);
            if (interfaceC1601vE2G instanceof AbstractC1823zD2) {
                return ((AbstractC1823zD2) interfaceC1601vE2G).a(iq2, arrayList);
            }
            throw new IllegalArgumentException(F.a(str, " is not a function"));
        }
        if (!"hasOwnProperty".equals(str)) {
            throw new IllegalArgumentException(Xd0.a("Object has no function ", str));
        }
        DS2.g("hasOwnProperty", 1, arrayList);
        return sd2.e(iq2.b.a(iq2, (InterfaceC1601vE2) arrayList.get(0)).zzi()) ? InterfaceC1601vE2.q : InterfaceC1601vE2.r;
    }
}
