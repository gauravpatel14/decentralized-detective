package defpackage;

/* JADX INFO: renamed from: wl0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1691wl0 implements xS0 {
    public static final C1691wl0 a = new C1691wl0();

    @Override // defpackage.xS0
    public final rq1 a(Class cls) {
        if (!AbstractC0003Al0.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (rq1) AbstractC0003Al0.g(cls.asSubclass(AbstractC0003Al0.class)).f(EnumC1862zl0.v, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    @Override // defpackage.xS0
    public final boolean b(Class cls) {
        return AbstractC0003Al0.class.isAssignableFrom(cls);
    }
}
