package defpackage;

/* JADX INFO: renamed from: h00, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0746h00 {
    public static final boolean a(int i) {
        return i == 1 || i == 2;
    }

    public static final void b(C1703wx c1703wx, InterfaceC1670wN interfaceC1670wN, boolean z) {
        Object objH = c1703wx.h();
        Throwable thE = c1703wx.e(objH);
        Object zv1 = thE != null ? new Zv1(thE) : c1703wx.f(objH);
        if (!z) {
            interfaceC1670wN.d(zv1);
            return;
        }
        d00 d00Var = (d00) interfaceC1670wN;
        yN yNVar = d00Var.x;
        InterfaceC0577eO interfaceC0577eO = yNVar.u;
        Object objB = U82.b(interfaceC0577eO, d00Var.z);
        C0082Gj2 c0082Gj2B = objB != U82.a ? gO.b(yNVar, interfaceC0577eO, objB) : null;
        try {
            d00Var.x.d(zv1);
        } finally {
            if (c0082Gj2B == null || c0082Gj2B.N()) {
                U82.a(interfaceC0577eO, objB);
            }
        }
    }
}
