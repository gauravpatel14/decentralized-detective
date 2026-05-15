package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class nJ2 implements InterfaceC1384rN2 {
    public static final nJ2 a = new nJ2();

    @Override // defpackage.InterfaceC1384rN2
    public final C0640fO2 a(Class cls) {
        if (!LJ2.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (C0640fO2) LJ2.d(cls.asSubclass(LJ2.class)).k(3);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    @Override // defpackage.InterfaceC1384rN2
    public final boolean b(Class cls) {
        return LJ2.class.isAssignableFrom(cls);
    }
}
