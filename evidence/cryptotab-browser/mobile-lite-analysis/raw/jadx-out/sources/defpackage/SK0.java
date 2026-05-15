package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SK0 implements xS0 {
    public xS0[] a;

    @Override // defpackage.xS0
    public final rq1 a(Class cls) {
        for (xS0 xs0 : this.a) {
            if (xs0.b(cls)) {
                return xs0.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // defpackage.xS0
    public final boolean b(Class cls) {
        for (xS0 xs0 : this.a) {
            if (xs0.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
