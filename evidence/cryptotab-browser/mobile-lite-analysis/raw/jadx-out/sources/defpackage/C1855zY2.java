package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: zY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1855zY2 extends AbstractC1823zD2 {
    public final /* synthetic */ PQ2 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1855zY2(PQ2 pq2) {
        super("getValue");
        this.v = pq2;
    }

    @Override // defpackage.AbstractC1823zD2
    public final InterfaceC1601vE2 a(IQ2 iq2, List list) {
        DS2.g("getValue", 2, list);
        InterfaceC1601vE2 interfaceC1601vE2A = iq2.b.a(iq2, (InterfaceC1601vE2) list.get(0));
        InterfaceC1601vE2 interfaceC1601vE2A2 = iq2.b.a(iq2, (InterfaceC1601vE2) list.get(1));
        String strZzi = interfaceC1601vE2A.zzi();
        PQ2 pq2 = this.v;
        Map map = (Map) pq2.b.d.get(pq2.a);
        String str = (map == null || !map.containsKey(strZzi)) ? null : (String) map.get(strZzi);
        return str != null ? new OE2(str) : interfaceC1601vE2A2;
    }
}
