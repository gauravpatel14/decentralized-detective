package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: zU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1848zU2 {
    public static InterfaceC1394rU2 a(InterfaceC1394rU2 interfaceC1394rU2) {
        if ((interfaceC1394rU2 instanceof C1621vU2) || (interfaceC1394rU2 instanceof C1512tU2)) {
            return interfaceC1394rU2;
        }
        if (interfaceC1394rU2 instanceof Serializable) {
            return new C1512tU2(interfaceC1394rU2);
        }
        C1621vU2 c1621vU2 = new C1621vU2();
        c1621vU2.t = interfaceC1394rU2;
        return c1621vU2;
    }
}
