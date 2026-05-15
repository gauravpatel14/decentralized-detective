package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class kF1 extends C implements Serializable {
    public static final kF1 u;
    public final C1438sL0 t;

    static {
        C1438sL0 c1438sL0 = C1438sL0.G;
        u = new kF1(C1438sL0.G);
    }

    public kF1(C1438sL0 c1438sL0) {
        this.t = c1438sL0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.t.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        this.t.b();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.t.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.t.containsKey(obj);
    }

    @Override // defpackage.C
    public final int f() {
        return this.t.B;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.t.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        C1438sL0 c1438sL0 = this.t;
        c1438sL0.getClass();
        return new C1322qL0(c1438sL0, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        C1438sL0 c1438sL0 = this.t;
        c1438sL0.b();
        int i = c1438sL0.i(obj);
        if (i < 0) {
            return false;
        }
        c1438sL0.p(i);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        this.t.b();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        this.t.b();
        return super.retainAll(collection);
    }

    public kF1() {
        this(new C1438sL0());
    }
}
