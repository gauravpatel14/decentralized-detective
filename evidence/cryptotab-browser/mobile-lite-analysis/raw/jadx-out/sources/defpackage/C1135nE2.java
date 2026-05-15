package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: nE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1135nE2 extends AbstractC1823zD2 {
    public final ArrayList v;
    public final ArrayList w;
    public final IQ2 x;

    public C1135nE2(C1135nE2 c1135nE2) {
        super(c1135nE2.t);
        ArrayList arrayList = new ArrayList(c1135nE2.v.size());
        this.v = arrayList;
        arrayList.addAll(c1135nE2.v);
        ArrayList arrayList2 = new ArrayList(c1135nE2.w.size());
        this.w = arrayList2;
        arrayList2.addAll(c1135nE2.w);
        this.x = c1135nE2.x;
    }

    @Override // defpackage.AbstractC1823zD2
    public final InterfaceC1601vE2 a(IQ2 iq2, List list) {
        UE2 ue2;
        IQ2 iq2A = this.x.a();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.v;
            int size = arrayList.size();
            ue2 = InterfaceC1601vE2.l;
            if (i >= size) {
                break;
            }
            if (i < list.size()) {
                iq2A.e((String) arrayList.get(i), iq2.b.a(iq2, (InterfaceC1601vE2) list.get(i)));
            } else {
                iq2A.e((String) arrayList.get(i), ue2);
            }
            i++;
        }
        for (InterfaceC1601vE2 interfaceC1601vE2 : this.w) {
            C0693gF2 c0693gF2 = iq2A.b;
            InterfaceC1601vE2 interfaceC1601vE2A = c0693gF2.a(iq2A, interfaceC1601vE2);
            if (interfaceC1601vE2A instanceof C1717xE2) {
                interfaceC1601vE2A = c0693gF2.a(iq2A, interfaceC1601vE2);
            }
            if (interfaceC1601vE2A instanceof C0823iD2) {
                return ((C0823iD2) interfaceC1601vE2A).t;
            }
        }
        return ue2;
    }

    @Override // defpackage.AbstractC1823zD2, defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 zzd() {
        return new C1135nE2(this);
    }

    public C1135nE2(String str, ArrayList arrayList, List list, IQ2 iq2) {
        super(str);
        this.v = new ArrayList();
        this.x = iq2;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.v.add(((InterfaceC1601vE2) it.next()).zzi());
            }
        }
        this.w = new ArrayList(list);
    }
}
