package defpackage;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TF2 implements Comparator {
    public final /* synthetic */ AbstractC1823zD2 a;
    public final /* synthetic */ IQ2 b;

    public TF2(AbstractC1823zD2 abstractC1823zD2, IQ2 iq2) {
        this.a = abstractC1823zD2;
        this.b = iq2;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        InterfaceC1601vE2 interfaceC1601vE2 = (InterfaceC1601vE2) obj;
        InterfaceC1601vE2 interfaceC1601vE22 = (InterfaceC1601vE2) obj2;
        if (interfaceC1601vE2 instanceof UE2) {
            return !(interfaceC1601vE22 instanceof UE2) ? 1 : 0;
        }
        if (interfaceC1601vE22 instanceof UE2) {
            return -1;
        }
        AbstractC1823zD2 abstractC1823zD2 = this.a;
        return abstractC1823zD2 == null ? interfaceC1601vE2.zzi().compareTo(interfaceC1601vE22.zzi()) : (int) DS2.a(abstractC1823zD2.a(this.b, Arrays.asList(interfaceC1601vE2, interfaceC1601vE22)).b().doubleValue());
    }
}
