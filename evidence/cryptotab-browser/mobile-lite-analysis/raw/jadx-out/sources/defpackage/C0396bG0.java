package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: bG0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0396bG0 extends B implements RandomAccess, Serializable {
    public Object[] t;
    public final int u;
    public int v;
    public final C0396bG0 w;
    public final C0456cG0 x;

    public C0396bG0(Object[] objArr, int i, int i2, C0396bG0 c0396bG0, C0456cG0 c0456cG0) {
        this.t = objArr;
        this.u = i;
        this.v = i2;
        this.w = c0396bG0;
        this.x = c0456cG0;
        ((AbstractList) this).modCount = ((AbstractList) c0456cG0).modCount;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        t();
        s();
        p(this.u + this.v, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        t();
        s();
        int size = collection.size();
        l(this.u + this.v, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        t();
        s();
        v(this.u, this.v);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        s();
        if (obj != this) {
            if (obj instanceof List) {
                if (AbstractC0517dG0.a(this.t, this.u, this.v, (List) obj)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.B
    public final int f() {
        s();
        return this.v;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        s();
        int i2 = this.v;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        return this.t[this.u + i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        s();
        Object[] objArr = this.t;
        int i = this.v;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[this.u + i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // defpackage.B
    public final Object i(int i) {
        t();
        s();
        int i2 = this.v;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        return u(this.u + i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        s();
        for (int i = 0; i < this.v; i++) {
            if (lz0.a(this.t[this.u + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        s();
        return this.v == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void l(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        C0456cG0 c0456cG0 = this.x;
        C0396bG0 c0396bG0 = this.w;
        if (c0396bG0 != null) {
            c0396bG0.l(i, collection, i2);
        } else {
            C0456cG0 c0456cG02 = C0456cG0.w;
            c0456cG0.l(i, collection, i2);
        }
        this.t = c0456cG0.t;
        this.v += i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        s();
        for (int i = this.v - 1; i >= 0; i--) {
            if (lz0.a(this.t[this.u + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final void p(int i, Object obj) {
        ((AbstractList) this).modCount++;
        C0456cG0 c0456cG0 = this.x;
        C0396bG0 c0396bG0 = this.w;
        if (c0396bG0 != null) {
            c0396bG0.p(i, obj);
        } else {
            C0456cG0 c0456cG02 = C0456cG0.w;
            c0456cG0.p(i, obj);
        }
        this.t = c0456cG0.t;
        this.v++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        t();
        s();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            i(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        t();
        s();
        return w(this.u, this.v, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        t();
        s();
        return w(this.u, this.v, collection, true) > 0;
    }

    public final void s() {
        if (((AbstractList) this.x).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        t();
        s();
        int i2 = this.v;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        Object[] objArr = this.t;
        int i3 = this.u;
        Object obj2 = objArr[i3 + i];
        objArr[i3 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        z.a(i, i2, this.v);
        return new C0396bG0(this.t, this.u + i, i2 - i, this, this.x);
    }

    public final void t() {
        if (this.x.v) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        s();
        int length = objArr.length;
        int i = this.v;
        int i2 = this.u;
        if (length < i) {
            return Arrays.copyOfRange(this.t, i2, i + i2, objArr.getClass());
        }
        AbstractC1229of.b(0, i2, i + i2, this.t, objArr);
        int i3 = this.v;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        s();
        return AbstractC0517dG0.b(this.t, this.u, this.v, this);
    }

    public final Object u(int i) {
        Object objU;
        ((AbstractList) this).modCount++;
        C0396bG0 c0396bG0 = this.w;
        if (c0396bG0 != null) {
            objU = c0396bG0.u(i);
        } else {
            C0456cG0 c0456cG0 = C0456cG0.w;
            objU = this.x.u(i);
        }
        this.v--;
        return objU;
    }

    public final void v(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        C0396bG0 c0396bG0 = this.w;
        if (c0396bG0 != null) {
            c0396bG0.v(i, i2);
        } else {
            C0456cG0 c0456cG0 = C0456cG0.w;
            this.x.v(i, i2);
        }
        this.v -= i2;
    }

    public final int w(int i, int i2, Collection collection, boolean z) {
        int iW;
        C0396bG0 c0396bG0 = this.w;
        if (c0396bG0 != null) {
            iW = c0396bG0.w(i, i2, collection, z);
        } else {
            C0456cG0 c0456cG0 = C0456cG0.w;
            iW = this.x.w(i, i2, collection, z);
        }
        if (iW > 0) {
            ((AbstractList) this).modCount++;
        }
        this.v -= iW;
        return iW;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        s();
        int i2 = this.v;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        return new C0340aG0(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        t();
        s();
        int i2 = this.v;
        if (i >= 0 && i <= i2) {
            p(this.u + i, obj);
            return;
        }
        throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        t();
        s();
        int i2 = this.v;
        if (i >= 0 && i <= i2) {
            int size = collection.size();
            l(this.u + i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        s();
        Object[] objArr = this.t;
        int i = this.v;
        int i2 = this.u;
        return AbstractC1229of.d(objArr, i2, i + i2);
    }
}
