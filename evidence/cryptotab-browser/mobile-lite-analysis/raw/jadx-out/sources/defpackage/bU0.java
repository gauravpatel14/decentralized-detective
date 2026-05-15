package defpackage;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bU0 {
    public final SparseArray a;
    public final HashSet b;
    public final AbstractC0356aU0 c;
    public AbstractC0356aU0 d;
    public int e;
    public int f;
    public boolean g;
    public final M21 h;
    public final HashMap i;
    public final Ve1 j;

    public bU0(AbstractC0356aU0 abstractC0356aU0) {
        SparseArray sparseArray = new SparseArray();
        this.a = sparseArray;
        this.b = new HashSet();
        this.h = new M21();
        HashMap map = new HashMap();
        this.i = map;
        this.j = new Ve1();
        this.c = abstractC0356aU0;
        sparseArray.put(1, abstractC0356aU0);
        final int i = 0;
        map.put(1, new Sa2(new Runnable(this) { // from class: XT0
            public final /* synthetic */ bU0 u;

            {
                this.u = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.u.i(1);
                        break;
                    default:
                        this.u.i(0);
                        break;
                }
            }
        }));
        final int i2 = 1;
        map.put(0, new Sa2(new Runnable(this) { // from class: XT0
            public final /* synthetic */ bU0 u;

            {
                this.u = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.u.i(1);
                        break;
                    default:
                        this.u.i(0);
                        break;
                }
            }
        }));
    }

    public final void a(ZT0 zt0) {
        this.h.e(zt0);
    }

    public final void b() {
        for (int i = 0; i <= 1; i++) {
            e(i, 10);
        }
        if (g()) {
            c(10, this.d.u);
        }
        this.h.clear();
    }

    public final void c(int i, PropertyModel propertyModel) {
        if (propertyModel == null) {
            return;
        }
        if (i != 7 && i != 5) {
        }
        AbstractC0356aU0 abstractC0356aU0 = this.d;
        C0223Sm1 c0223Sm1 = fU0.a;
        M21 m21 = this.h;
        if (abstractC0356aU0 == null || propertyModel != abstractC0356aU0.u) {
            HashMap map = this.j.a;
            for (Map.Entry entry : map.entrySet()) {
                List list = (List) entry.getValue();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2) == propertyModel) {
                        list.remove(i2);
                        if (list.isEmpty()) {
                            map.remove(entry.getKey());
                        }
                        ((dU0) propertyModel.g(c0223Sm1)).a(i);
                        Iterator it = m21.iterator();
                        while (true) {
                            L21 l21 = (L21) it;
                            if (!l21.hasNext()) {
                                f();
                                return;
                            }
                            ((ZT0) l21.next()).n();
                        }
                    }
                }
            }
            return;
        }
        if (!g() || this.g) {
            return;
        }
        this.g = true;
        ((dU0) propertyModel.g(c0223Sm1)).a(i);
        AbstractC0356aU0.a(this.d, null, null, null);
        Iterator it2 = m21.iterator();
        while (true) {
            L21 l212 = (L21) it2;
            if (!l212.hasNext()) {
                this.d = null;
                this.f = 1;
                this.g = false;
                f();
                l();
                return;
            }
            ((ZT0) l212.next()).n();
        }
    }

    public final void d(int i) {
        e(0, i);
        if (g() && this.e == 0) {
            c(i, this.d.u);
        }
    }

    public final void e(int i, int i2) {
        int i3 = 1;
        while (true) {
            Ve1 ve1 = this.j;
            if (i3 > 3) {
                ve1.getClass();
                return;
            }
            ve1.getClass();
            Integer numValueOf = Integer.valueOf((i * 10) + i3);
            HashMap map = ve1.a;
            List list = (List) map.get(numValueOf);
            if (list != null) {
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((dU0) ((PropertyModel) list.get(i4)).g(fU0.a)).a(i2);
                    Iterator it = this.h.iterator();
                    while (true) {
                        L21 l21 = (L21) it;
                        if (l21.hasNext()) {
                            ((ZT0) l21.next()).n();
                        }
                    }
                    f();
                }
                map.remove(numValueOf);
            }
            i3++;
        }
    }

    public final void f() {
        Iterator it = this.j.a.entrySet().iterator();
        while (it.hasNext()) {
            if (!((List) ((Map.Entry) it.next()).getValue()).isEmpty()) {
                return;
            }
        }
        Iterator it2 = this.h.iterator();
        while (true) {
            L21 l21 = (L21) it2;
            if (!l21.hasNext()) {
                return;
            } else {
                ((ZT0) l21.next()).k();
            }
        }
    }

    public final boolean g() {
        return this.d != null;
    }

    public final void h(ZT0 zt0) {
        this.h.g(zt0);
    }

    public final void i(int i) {
        if (((Sa2) this.i.get(Integer.valueOf(i))).b()) {
            return;
        }
        this.b.remove(Integer.valueOf(i));
        if (g()) {
            return;
        }
        l();
    }

    public final void j(int i, int i2, PropertyModel propertyModel, boolean z) {
        if (CH.c().e("enable-screenshot-ui-mode")) {
            return;
        }
        Ve1 ve1 = this.j;
        if (i2 == 3) {
            if (g() && this.f >= i2) {
                ve1.a(i, i2, propertyModel, z);
                return;
            }
        } else if (this.b.contains(Integer.valueOf(i)) || (g() && this.f >= i2)) {
            ve1.a(i, i2, propertyModel, z);
            return;
        }
        if (g()) {
            AbstractC0356aU0 abstractC0356aU0 = this.d;
            PropertyModel propertyModel2 = abstractC0356aU0.u;
            AbstractC0356aU0.a(abstractC0356aU0, null, null, null);
            this.d = null;
            ve1.a(this.e, this.f, propertyModel2, true);
        }
        this.e = i;
        this.f = i2;
        AbstractC0356aU0 abstractC0356aU02 = (AbstractC0356aU0) this.a.get(i, this.c);
        this.d = abstractC0356aU02;
        AbstractC0356aU0.a(abstractC0356aU02, propertyModel, new YT0(this, propertyModel, 0), new YT0(this, propertyModel, 1));
        Iterator it = this.h.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((ZT0) l21.next()).l(propertyModel);
            }
        }
    }

    public final void k(int i, PropertyModel propertyModel, boolean z) {
        int i2 = 1;
        if (i != 0 && i == 1) {
            i2 = 2;
        }
        j(i, i2, propertyModel, z);
    }

    public final void l() {
        Ue1 ue1;
        HashSet hashSet = this.b;
        Ve1 ve1 = this.j;
        ve1.getClass();
        int i = 3;
        while (true) {
            if (i < 1) {
                ue1 = null;
                break;
            }
            for (int i2 = 1; i2 >= 0; i2--) {
                if (!hashSet.contains(Integer.valueOf(i2))) {
                    Integer numValueOf = Integer.valueOf((i2 * 10) + i);
                    HashMap map = ve1.a;
                    List list = (List) map.get(numValueOf);
                    if (list != null && !list.isEmpty()) {
                        PropertyModel propertyModel = (PropertyModel) list.get(0);
                        list.remove(0);
                        if (list.isEmpty()) {
                            map.remove(numValueOf);
                        }
                        ue1 = new Ue1(i2, i, propertyModel);
                    }
                }
            }
            i--;
        }
        if (ue1 == null) {
            return;
        }
        j(ue1.b, ue1.c, ue1.a, false);
    }

    public final int m(int i) {
        this.b.add(Integer.valueOf(i));
        if (g() && i == this.e && this.f != 3) {
            AbstractC0356aU0 abstractC0356aU0 = this.d;
            PropertyModel propertyModel = abstractC0356aU0.u;
            AbstractC0356aU0.a(abstractC0356aU0, null, null, null);
            this.d = null;
            this.j.a(this.e, this.f, propertyModel, true);
            l();
        }
        return ((Sa2) this.i.get(Integer.valueOf(i))).a();
    }
}
