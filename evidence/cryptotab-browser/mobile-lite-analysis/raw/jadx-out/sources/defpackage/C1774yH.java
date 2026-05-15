package defpackage;

/* JADX INFO: renamed from: yH, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1774yH extends RC0 implements xk0 {
    public static final C1774yH u = new C1774yH(2);

    @Override // defpackage.xk0
    public final Object i(Object obj, Object obj2) {
        String str = (String) obj;
        InterfaceC0405bO interfaceC0405bO = (InterfaceC0405bO) obj2;
        if (str.length() == 0) {
            return interfaceC0405bO.toString();
        }
        return str + ", " + interfaceC0405bO;
    }
}
