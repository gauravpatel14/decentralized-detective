package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZL2 extends AbstractC0769hM2 {
    @Override // defpackage.AbstractC0769hM2
    public final void a(long j, Object obj) {
        UF2 uf2 = (UF2) ((InterfaceC1606vK2) SP2.i(j, obj));
        if (uf2.t) {
            uf2.t = false;
        }
    }

    @Override // defpackage.AbstractC0769hM2
    public final void b(long j, Object obj, Object obj2) {
        InterfaceC1606vK2 interfaceC1606vK2C = (InterfaceC1606vK2) SP2.i(j, obj);
        InterfaceC1606vK2 interfaceC1606vK2 = (InterfaceC1606vK2) SP2.i(j, obj2);
        int size = interfaceC1606vK2C.size();
        int size2 = interfaceC1606vK2.size();
        if (size > 0 && size2 > 0) {
            if (!((UF2) interfaceC1606vK2C).t) {
                interfaceC1606vK2C = interfaceC1606vK2C.c(size2 + size);
            }
            interfaceC1606vK2C.addAll(interfaceC1606vK2);
        }
        if (size > 0) {
            interfaceC1606vK2 = interfaceC1606vK2C;
        }
        SP2.p(j, obj, interfaceC1606vK2);
    }
}
