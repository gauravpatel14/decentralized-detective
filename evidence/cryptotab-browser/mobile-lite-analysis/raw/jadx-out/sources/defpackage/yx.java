package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yx {
    public static final C1703wx a(InterfaceC1670wN interfaceC1670wN) {
        if (!(interfaceC1670wN instanceof d00)) {
            return new C1703wx(interfaceC1670wN, 1);
        }
        C1703wx c1703wxI = ((d00) interfaceC1670wN).i();
        if (c1703wxI != null) {
            if (!c1703wxI.t()) {
                c1703wxI = null;
            }
            if (c1703wxI != null) {
                return c1703wxI;
            }
        }
        return new C1703wx(interfaceC1670wN, 2);
    }
}
