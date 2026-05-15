package defpackage;

import java.util.List;

/* JADX INFO: renamed from: v23, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1593v23 extends AbstractC1823zD2 {
    public final C1785yQ2 v;

    public C1593v23(C1785yQ2 c1785yQ2) {
        super("internal.logger");
        this.v = c1785yQ2;
        this.u.put("log", new C0749h23(this, false, true));
        this.u.put("silent", new C1812z03("silent"));
        ((AbstractC1823zD2) this.u.get("silent")).h("log", new C0749h23(this, true, true));
        this.u.put("unmonitored", new C1247p13("unmonitored"));
        ((AbstractC1823zD2) this.u.get("unmonitored")).h("log", new C0749h23(this, false, false));
    }

    @Override // defpackage.AbstractC1823zD2
    public final InterfaceC1601vE2 a(IQ2 iq2, List list) {
        return InterfaceC1601vE2.l;
    }
}
