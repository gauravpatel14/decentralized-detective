package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CX2 implements NX2 {
    public final NX2[] a;

    public CX2(NX2... nx2Arr) {
        this.a = nx2Arr;
    }

    @Override // defpackage.NX2
    public final C0718gY2 a(Class cls) {
        for (int i = 0; i < 2; i++) {
            NX2 nx2 = this.a[i];
            if (nx2.b(cls)) {
                return nx2.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // defpackage.NX2
    public final boolean b(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.a[i].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
