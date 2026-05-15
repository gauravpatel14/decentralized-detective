package defpackage;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class iL1 extends AbstractMap {
    public static final /* synthetic */ int z = 0;
    public final int t;
    public boolean w;
    public volatile oL1 x;
    public List u = Collections.emptyList();
    public Map v = Collections.emptyMap();
    public Map y = Collections.emptyMap();

    public iL1(int i) {
        this.t = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.u
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.u
            java.lang.Object r2 = r2.get(r1)
            mL1 r2 = (defpackage.C1080mL1) r2
            java.lang.Comparable r2 = r2.t
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r5 = -r0
            return r5
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.u
            java.lang.Object r3 = r3.get(r2)
            mL1 r3 = (defpackage.C1080mL1) r3
            java.lang.Comparable r3 = r3.t
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iL1.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.w) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i) {
        return (Map.Entry) this.u.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.u.isEmpty()) {
            this.u.clear();
        }
        if (this.v.isEmpty()) {
            return;
        }
        this.v.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.v.containsKey(comparable);
    }

    public final Iterable d() {
        return this.v.isEmpty() ? lL1.b : this.v.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.v.isEmpty() && !(this.v instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.v = treeMap;
            this.y = treeMap.descendingMap();
        }
        return (SortedMap) this.v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.x == null) {
            this.x = new oL1(this);
        }
        return this.x;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iL1)) {
            return super.equals(obj);
        }
        iL1 il1 = (iL1) obj;
        int size = size();
        if (size != il1.size()) {
            return false;
        }
        int size2 = this.u.size();
        if (size2 != il1.u.size()) {
            return ((AbstractSet) entrySet()).equals(il1.entrySet());
        }
        for (int i = 0; i < size2; i++) {
            if (!c(i).equals(il1.c(i))) {
                return false;
            }
        }
        if (size2 != size) {
            return this.v.equals(il1.v);
        }
        return true;
    }

    public final Object f(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((C1080mL1) this.u.get(iA)).setValue(obj);
        }
        b();
        boolean zIsEmpty = this.u.isEmpty();
        int i = this.t;
        if (zIsEmpty && !(this.u instanceof ArrayList)) {
            this.u = new ArrayList(i);
        }
        int i2 = -(iA + 1);
        if (i2 >= i) {
            return e().put(comparable, obj);
        }
        if (this.u.size() == i) {
            C1080mL1 c1080mL1 = (C1080mL1) this.u.remove(i - 1);
            e().put(c1080mL1.t, c1080mL1.u);
        }
        this.u.add(i2, new C1080mL1(this, comparable, obj));
        return null;
    }

    public final Object g(int i) {
        b();
        Object obj = ((C1080mL1) this.u.remove(i)).u;
        if (!this.v.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.u;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new C1080mL1(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((C1080mL1) this.u.get(iA)).u : this.v.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.u.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((C1080mL1) this.u.get(i)).hashCode();
        }
        return this.v.size() > 0 ? iHashCode + this.v.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        yi1.a(obj);
        return f(null, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return g(iA);
        }
        if (this.v.isEmpty()) {
            return null;
        }
        return this.v.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.v.size() + this.u.size();
    }
}
