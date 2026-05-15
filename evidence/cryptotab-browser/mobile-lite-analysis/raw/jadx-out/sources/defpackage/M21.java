package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class M21 implements Iterable {
    public int u;
    public int v;
    public boolean w;
    public final ArrayList t = new ArrayList();
    public final boolean x = true;

    public M21() {
        new c92();
    }

    public final void clear() {
        if (this.x) {
            int i = AbstractC1872zv.a;
        }
        this.v = 0;
        int i2 = this.u;
        ArrayList arrayList = this.t;
        if (i2 == 0) {
            arrayList.clear();
            return;
        }
        int size = arrayList.size();
        this.w |= size != 0;
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.set(i3, null);
        }
    }

    public final boolean e(Object obj) {
        if (this.x) {
            int i = AbstractC1872zv.a;
        }
        if (obj == null) {
            return false;
        }
        ArrayList arrayList = this.t;
        if (arrayList.contains(obj)) {
            return false;
        }
        arrayList.add(obj);
        this.v++;
        return true;
    }

    public final boolean f(Object obj) {
        if (this.x) {
            int i = AbstractC1872zv.a;
        }
        return this.t.contains(obj);
    }

    public final boolean g(Object obj) {
        ArrayList arrayList;
        int iIndexOf;
        if (this.x) {
            int i = AbstractC1872zv.a;
        }
        if (obj == null || (iIndexOf = (arrayList = this.t).indexOf(obj)) == -1) {
            return false;
        }
        if (this.u == 0) {
            arrayList.remove(iIndexOf);
        } else {
            this.w = true;
            arrayList.set(iIndexOf, null);
        }
        this.v--;
        return true;
    }

    public final L21 h() {
        if (this.x) {
            int i = AbstractC1872zv.a;
        }
        return new L21(this);
    }

    public final boolean isEmpty() {
        if (this.x) {
            int i = AbstractC1872zv.a;
        }
        return this.v == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        if (this.x) {
            int i = AbstractC1872zv.a;
        }
        return new L21(this);
    }
}
