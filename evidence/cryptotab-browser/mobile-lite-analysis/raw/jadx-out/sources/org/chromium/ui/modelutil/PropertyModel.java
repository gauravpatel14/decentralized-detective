package org.chromium.ui.modelutil;

import defpackage.AbstractC0197Qm1;
import defpackage.AbstractC1872zv;
import defpackage.C0130Lm1;
import defpackage.C0159Nm1;
import defpackage.C0172Om1;
import defpackage.C0186Pm1;
import defpackage.C0209Rm1;
import defpackage.C0223Sm1;
import defpackage.C0236Tm1;
import defpackage.C0257Vm1;
import defpackage.C0272Wm1;
import defpackage.C0289Xm1;
import defpackage.InterfaceC0546dn1;
import defpackage.L21;
import defpackage.M21;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PropertyModel {
    public final M21 a;
    public final HashMap b;
    public final HashMap c;

    public PropertyModel(HashMap map, HashMap map2) {
        this.a = new M21();
        this.b = map;
        this.c = map2;
    }

    public static HashMap b(AbstractC0197Qm1[] abstractC0197Qm1Arr) {
        HashMap map = new HashMap();
        for (AbstractC0197Qm1 abstractC0197Qm1 : abstractC0197Qm1Arr) {
            if (map.containsKey(abstractC0197Qm1)) {
                throw new IllegalArgumentException("Duplicate key: " + abstractC0197Qm1);
            }
            map.put(abstractC0197Qm1, null);
        }
        return map;
    }

    public static AbstractC0197Qm1[] c(AbstractC0197Qm1[] abstractC0197Qm1Arr, AbstractC0197Qm1[] abstractC0197Qm1Arr2) {
        AbstractC0197Qm1[] abstractC0197Qm1Arr3 = new AbstractC0197Qm1[abstractC0197Qm1Arr.length + abstractC0197Qm1Arr2.length];
        System.arraycopy(abstractC0197Qm1Arr, 0, abstractC0197Qm1Arr3, 0, abstractC0197Qm1Arr.length);
        System.arraycopy(abstractC0197Qm1Arr2, 0, abstractC0197Qm1Arr3, abstractC0197Qm1Arr.length, abstractC0197Qm1Arr2.length);
        return abstractC0197Qm1Arr3;
    }

    public final void a(InterfaceC0546dn1 interfaceC0546dn1) {
        this.a.e(interfaceC0546dn1);
    }

    public final float d(C0223Sm1 c0223Sm1) {
        int i = AbstractC1872zv.a;
        C0159Nm1 c0159Nm1 = (C0159Nm1) this.b.get(c0223Sm1);
        if (c0159Nm1 == null) {
            return 0.0f;
        }
        return c0159Nm1.a;
    }

    public final int e(C0236Tm1 c0236Tm1) {
        int i = AbstractC1872zv.a;
        C0172Om1 c0172Om1 = (C0172Om1) this.b.get(c0236Tm1);
        if (c0172Om1 == null) {
            return 0;
        }
        return c0172Om1.a;
    }

    public final long f(C0223Sm1 c0223Sm1) {
        int i = AbstractC1872zv.a;
        C0186Pm1 c0186Pm1 = (C0186Pm1) this.b.get(c0223Sm1);
        if (c0186Pm1 == null) {
            return 0L;
        }
        return c0186Pm1.a;
    }

    public final Object g(C0223Sm1 c0223Sm1) {
        int i = AbstractC1872zv.a;
        C0209Rm1 c0209Rm1 = (C0209Rm1) this.b.get(c0223Sm1);
        if (c0209Rm1 == null) {
            return null;
        }
        return c0209Rm1.a;
    }

    public final boolean h(C0223Sm1 c0223Sm1) {
        int i = AbstractC1872zv.a;
        C0130Lm1 c0130Lm1 = (C0130Lm1) this.b.get(c0223Sm1);
        if (c0130Lm1 == null) {
            return false;
        }
        return c0130Lm1.a;
    }

    public final ArrayList i() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            if (entry.getValue() != null) {
                arrayList.add((AbstractC0197Qm1) entry.getKey());
            }
        }
        return arrayList;
    }

    public final void j(AbstractC0197Qm1 abstractC0197Qm1) {
        Iterator it = this.a.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((InterfaceC0546dn1) l21.next()).a(this, abstractC0197Qm1);
            }
        }
    }

    public final void k(InterfaceC0546dn1 interfaceC0546dn1) {
        this.a.g(interfaceC0546dn1);
    }

    public final void l(C0223Sm1 c0223Sm1, float f) {
        int i = AbstractC1872zv.a;
        HashMap map = this.b;
        C0159Nm1 c0159Nm1 = (C0159Nm1) map.get(c0223Sm1);
        if (c0159Nm1 == null) {
            c0159Nm1 = new C0159Nm1();
            map.put(c0223Sm1, c0159Nm1);
        } else if (c0159Nm1.a == f) {
            return;
        }
        c0159Nm1.a = f;
        j(c0223Sm1);
    }

    public final void m(C0223Sm1 c0223Sm1, long j) {
        int i = AbstractC1872zv.a;
        HashMap map = this.b;
        C0186Pm1 c0186Pm1 = (C0186Pm1) map.get(c0223Sm1);
        if (c0186Pm1 == null) {
            c0186Pm1 = new C0186Pm1();
            map.put(c0223Sm1, c0186Pm1);
        } else if (c0186Pm1.a == j) {
            return;
        }
        c0186Pm1.a = j;
        j(c0223Sm1);
    }

    public final void n(C0257Vm1 c0257Vm1, boolean z) {
        int i = AbstractC1872zv.a;
        HashMap map = this.b;
        C0130Lm1 c0130Lm1 = (C0130Lm1) map.get(c0257Vm1);
        if (c0130Lm1 == null) {
            c0130Lm1 = new C0130Lm1();
            map.put(c0257Vm1, c0130Lm1);
        } else if (c0130Lm1.a == z) {
            return;
        }
        c0130Lm1.a = z;
        j(c0257Vm1);
    }

    public final void o(C0272Wm1 c0272Wm1, int i) {
        int i2 = AbstractC1872zv.a;
        HashMap map = this.b;
        C0172Om1 c0172Om1 = (C0172Om1) map.get(c0272Wm1);
        if (c0172Om1 == null) {
            c0172Om1 = new C0172Om1();
            map.put(c0272Wm1, c0172Om1);
        } else if (c0172Om1.a == i) {
            return;
        }
        c0172Om1.a = i;
        j(c0272Wm1);
    }

    public final void p(C0289Xm1 c0289Xm1, Object obj) {
        int i = AbstractC1872zv.a;
        HashMap map = this.b;
        C0209Rm1 c0209Rm1 = (C0209Rm1) map.get(c0289Xm1);
        if (c0209Rm1 == null) {
            c0209Rm1 = new C0209Rm1();
            map.put(c0289Xm1, c0209Rm1);
        } else if (!c0289Xm1.b && Objects.equals(c0209Rm1.a, obj)) {
            return;
        }
        c0209Rm1.a = obj;
        j(c0289Xm1);
    }

    public PropertyModel(AbstractC0197Qm1... abstractC0197Qm1Arr) {
        this(b(abstractC0197Qm1Arr), null);
    }

    public PropertyModel(List list) {
        this(b((AbstractC0197Qm1[]) list.toArray(new AbstractC0197Qm1[list.size()])), null);
    }
}
