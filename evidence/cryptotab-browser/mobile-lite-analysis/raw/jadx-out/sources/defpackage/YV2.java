package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YV2 implements NX2 {
    public static final YV2 a = new YV2();

    @Override // defpackage.NX2
    public final C0718gY2 a(Class cls) {
        if (!AbstractC1852zW2.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (C0718gY2) AbstractC1852zW2.f(cls.asSubclass(AbstractC1852zW2.class)).k(3);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    @Override // defpackage.NX2
    public final boolean b(Class cls) {
        return AbstractC1852zW2.class.isAssignableFrom(cls);
    }
}
