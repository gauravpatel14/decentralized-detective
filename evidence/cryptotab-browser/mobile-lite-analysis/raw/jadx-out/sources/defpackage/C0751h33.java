package defpackage;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: h33, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0751h33 extends AbstractC1823zD2 {
    public final C0416bV2 v;
    public final HashMap w;

    public C0751h33(C0416bV2 c0416bV2) {
        super("require");
        this.w = new HashMap();
        this.v = c0416bV2;
    }

    @Override // defpackage.AbstractC1823zD2
    public final InterfaceC1601vE2 a(IQ2 iq2, List list) {
        InterfaceC1601vE2 interfaceC1601vE2;
        DS2.g("require", 1, list);
        String strZzi = iq2.b.a(iq2, (InterfaceC1601vE2) list.get(0)).zzi();
        HashMap map = this.w;
        if (map.containsKey(strZzi)) {
            return (InterfaceC1601vE2) map.get(strZzi);
        }
        C0416bV2 c0416bV2 = this.v;
        if (c0416bV2.a.containsKey(strZzi)) {
            try {
                interfaceC1601vE2 = (InterfaceC1601vE2) ((Callable) c0416bV2.a.get(strZzi)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(strZzi)));
            }
        } else {
            interfaceC1601vE2 = InterfaceC1601vE2.l;
        }
        if (interfaceC1601vE2 instanceof AbstractC1823zD2) {
            map.put(strZzi, (AbstractC1823zD2) interfaceC1601vE2);
        }
        return interfaceC1601vE2;
    }
}
