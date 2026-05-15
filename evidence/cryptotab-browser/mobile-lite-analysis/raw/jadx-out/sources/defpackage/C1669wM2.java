package defpackage;

/* JADX INFO: renamed from: wM2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1669wM2 implements InterfaceC1384rN2 {
    public final InterfaceC1384rN2[] a;

    public C1669wM2(InterfaceC1384rN2... interfaceC1384rN2Arr) {
        this.a = interfaceC1384rN2Arr;
    }

    @Override // defpackage.InterfaceC1384rN2
    public final C0640fO2 a(Class cls) {
        for (int i = 0; i < 2; i++) {
            InterfaceC1384rN2 interfaceC1384rN2 = this.a[i];
            if (interfaceC1384rN2.b(cls)) {
                return interfaceC1384rN2.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // defpackage.InterfaceC1384rN2
    public final boolean b(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.a[i].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
