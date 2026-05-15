package androidx.fragment.app;

import defpackage.AbstractC1555uM1;
import defpackage.AbstractC1815z41;
import defpackage.C0375am;
import defpackage.Ii0;
import defpackage.InterfaceC1106mi0;
import defpackage.MG;
import defpackage.TG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends AbstractC1815z41 {
    public final /* synthetic */ s d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(s sVar) {
        super(false);
        this.d = sVar;
    }

    @Override // defpackage.AbstractC1815z41
    public final void a() {
        final s sVar = this.d;
        a aVar = sVar.h;
        if (aVar != null) {
            aVar.s = false;
            aVar.f(new Runnable() { // from class: ci0
                @Override // java.lang.Runnable
                public final void run() {
                    Iterator it = sVar.n.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC1106mi0) it.next()).getClass();
                    }
                }
            }, true);
            sVar.h.h();
            sVar.i = true;
            sVar.y(true);
            sVar.D();
            sVar.i = false;
            sVar.h = null;
        }
    }

    @Override // defpackage.AbstractC1815z41
    public final void b() {
        s sVar = this.d;
        sVar.i = true;
        sVar.y(true);
        sVar.i = false;
        if (sVar.h == null) {
            if (sVar.j.a) {
                sVar.O();
                return;
            } else {
                sVar.g.d();
                return;
            }
        }
        ArrayList<InterfaceC1106mi0> arrayList = sVar.n;
        if (!arrayList.isEmpty()) {
            LinkedHashSet<n> linkedHashSet = new LinkedHashSet(s.E(sVar.h));
            for (InterfaceC1106mi0 interfaceC1106mi0 : arrayList) {
                for (n nVar : linkedHashSet) {
                    interfaceC1106mi0.getClass();
                }
            }
        }
        Iterator it = sVar.h.a.iterator();
        while (it.hasNext()) {
            n nVar2 = ((Ii0) it.next()).b;
            if (nVar2 != null) {
                nVar2.mTransitioning = false;
            }
        }
        for (g gVar : sVar.e(new ArrayList(Collections.singletonList(sVar.h)), 0, 1)) {
            ArrayList arrayList2 = gVar.c;
            gVar.m(arrayList2);
            gVar.c(arrayList2);
        }
        Iterator it2 = sVar.h.a.iterator();
        while (it2.hasNext()) {
            n nVar3 = ((Ii0) it2.next()).b;
            if (nVar3 != null && nVar3.mContainer == null) {
                sVar.f(nVar3).g();
            }
        }
        sVar.h = null;
        sVar.d0();
    }

    @Override // defpackage.AbstractC1815z41
    public final void c(C0375am c0375am) {
        s sVar = this.d;
        if (sVar.h != null) {
            Iterator it = sVar.e(new ArrayList(Collections.singletonList(sVar.h)), 0, 1).iterator();
            while (it.hasNext()) {
                ArrayList arrayList = ((g) it.next()).c;
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    TG.e(arrayList2, ((y) it2.next()).k);
                }
                List listK = MG.k(MG.m(arrayList2));
                int size = listK.size();
                for (int i = 0; i < size; i++) {
                    ((AbstractC1555uM1) listK.get(i)).d(c0375am);
                }
            }
            Iterator it3 = sVar.n.iterator();
            while (it3.hasNext()) {
                ((InterfaceC1106mi0) it3.next()).getClass();
            }
        }
    }

    @Override // defpackage.AbstractC1815z41
    public final void d(C0375am c0375am) {
        s sVar = this.d;
        sVar.v();
        sVar.getClass();
        sVar.w(new r(sVar), false);
    }
}
