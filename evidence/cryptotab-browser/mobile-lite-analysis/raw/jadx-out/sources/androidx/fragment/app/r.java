package androidx.fragment.app;

import defpackage.Ii0;
import defpackage.InterfaceC1106mi0;
import defpackage.InterfaceC1166ni0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements InterfaceC1166ni0 {
    public final /* synthetic */ s a;

    public r(s sVar) {
        this.a = sVar;
    }

    @Override // defpackage.InterfaceC1166ni0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        s sVar = this.a;
        ArrayList arrayList3 = sVar.d;
        a aVar = (a) arrayList3.get(arrayList3.size() - 1);
        sVar.h = aVar;
        Iterator it = aVar.a.iterator();
        while (it.hasNext()) {
            n nVar = ((Ii0) it.next()).b;
            if (nVar != null) {
                nVar.mTransitioning = true;
            }
        }
        boolean zQ = sVar.Q(arrayList, arrayList2, -1, 0);
        if (!sVar.n.isEmpty() && arrayList.size() > 0) {
            ((Boolean) arrayList2.get(arrayList.size() - 1)).getClass();
            LinkedHashSet<n> linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(s.E((a) it2.next()));
            }
            for (InterfaceC1106mi0 interfaceC1106mi0 : sVar.n) {
                for (n nVar2 : linkedHashSet) {
                    interfaceC1106mi0.getClass();
                }
            }
        }
        return zQ;
    }
}
