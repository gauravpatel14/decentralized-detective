package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hV {
    public static final String a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String b(InterfaceC1670wN interfaceC1670wN) {
        Object zv1;
        if (interfaceC1670wN instanceof d00) {
            return interfaceC1670wN.toString();
        }
        try {
            zv1 = interfaceC1670wN + '@' + a(interfaceC1670wN);
        } catch (Throwable th) {
            zv1 = new Zv1(th);
        }
        if (aw1.a(zv1) != null) {
            zv1 = interfaceC1670wN.getClass().getName() + '@' + a(interfaceC1670wN);
        }
        return (String) zv1;
    }
}
