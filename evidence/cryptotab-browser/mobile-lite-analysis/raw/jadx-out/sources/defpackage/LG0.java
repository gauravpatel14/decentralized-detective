package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LG0 extends SG0 implements YJ1 {
    public final ArrayList u = new ArrayList();

    @Override // defpackage.YJ1
    public final Object get(int i) {
        return this.u.get(i);
    }

    @Override // defpackage.YJ1, java.lang.Iterable
    public final Iterator iterator() {
        return this.u.iterator();
    }

    public final void s(Object obj) {
        ArrayList arrayList = this.u;
        arrayList.add(obj);
        o(arrayList.size() - 1, 1);
    }

    @Override // defpackage.YJ1
    public final int size() {
        return this.u.size();
    }

    public void t(int i, PJ0 pj0) {
        this.u.add(i, pj0);
        o(i, 1);
    }

    public final void u() {
        ArrayList arrayList = this.u;
        if (arrayList.size() > 0) {
            x(0, arrayList.size());
        }
    }

    public final void v(int i, int i2) {
        ArrayList arrayList = this.u;
        Object objRemove = arrayList.remove(i);
        if (i2 == arrayList.size()) {
            arrayList.add(objRemove);
        } else {
            arrayList.add(i2, objRemove);
        }
        m(i, i2);
    }

    public Object w(int i) {
        Object objRemove = this.u.remove(i);
        p(i, 1);
        return objRemove;
    }

    public void x(int i, int i2) {
        this.u.subList(i, i + i2).clear();
        p(i, i2);
    }

    public void y(List list) {
        ArrayList arrayList = this.u;
        int size = arrayList.size();
        int size2 = list.size();
        arrayList.clear();
        arrayList.addAll(list);
        int iMin = Math.min(size, size2);
        if (iMin > 0) {
            n(0, iMin, null);
        }
        if (size2 > size) {
            o(iMin, size2 - size);
        } else if (size2 < size) {
            p(iMin, size - size2);
        }
    }

    public final void z(int i, Object obj) {
        this.u.set(i, obj);
        n(i, 1, null);
    }
}
