package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: cG0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0456cG0 extends B implements RandomAccess, Serializable {
    public static final C0456cG0 w;
    public Object[] t;
    public int u;
    public boolean v;

    static {
        C0456cG0 c0456cG0 = new C0456cG0(0);
        c0456cG0.v = true;
        w = c0456cG0;
    }

    public C0456cG0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.t = new Object[i];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        s();
        int i = this.u;
        ((AbstractList) this).modCount++;
        t(i, 1);
        this.t[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        s();
        int size = collection.size();
        l(this.u, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        s();
        v(0, this.u);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            if (!AbstractC0517dG0.a(this.t, 0, this.u, (List) obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.B
    public final int f() {
        return this.u;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.u;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        return this.t[i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.t;
        int i = this.u;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    @Override // defpackage.B
    public final Object i(int i) {
        s();
        int i2 = this.u;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        return u(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.u; i++) {
            if (lz0.a(this.t[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.u == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void l(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        t(i, i2);
        Iterator it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.t[i + i3] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.u - 1; i >= 0; i--) {
            if (lz0.a(this.t[i], obj)) {
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
        t(i, 1);
        this.t[i] = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        s();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            i(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        s();
        return w(0, this.u, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        s();
        return w(0, this.u, collection, true) > 0;
    }

    public final void s() {
        if (this.v) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        s();
        int i2 = this.u;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        Object[] objArr = this.t;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        z.a(i, i2, this.u);
        return new C0396bG0(this.t, i, i2 - i, null, this);
    }

    public final void t(int i, int i2) {
        int i3 = this.u + i2;
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.t;
        if (i3 > objArr.length) {
            int length = objArr.length;
            int i4 = length + (length >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - 2147483639 > 0) {
                i4 = i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            this.t = Arrays.copyOf(objArr, i4);
        }
        Object[] objArr2 = this.t;
        AbstractC1229of.b(i + i2, i, this.u, objArr2, objArr2);
        this.u += i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        int length = objArr.length;
        int i = this.u;
        if (length < i) {
            return Arrays.copyOfRange(this.t, 0, i, objArr.getClass());
        }
        AbstractC1229of.b(0, 0, i, this.t, objArr);
        int i2 = this.u;
        if (i2 < objArr.length) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return AbstractC0517dG0.b(this.t, 0, this.u, this);
    }

    public final Object u(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.t;
        Object obj = objArr[i];
        AbstractC1229of.b(i, i + 1, this.u, objArr, objArr);
        Object[] objArr2 = this.t;
        int i2 = this.u;
        objArr2[i2 - 1] = null;
        this.u = i2 - 1;
        return obj;
    }

    public final void v(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.t;
        AbstractC1229of.b(i, i + i2, this.u, objArr, objArr);
        Object[] objArr2 = this.t;
        int i3 = this.u;
        AbstractC0517dG0.c(objArr2, i3 - i2, i3);
        this.u -= i2;
    }

    public final int w(int i, int i2, Collection collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.t[i5]) == z) {
                Object[] objArr = this.t;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.t;
        AbstractC1229of.b(i + i4, i2 + i, this.u, objArr2, objArr2);
        Object[] objArr3 = this.t;
        int i7 = this.u;
        AbstractC0517dG0.c(objArr3, i7 - i6, i7);
        if (i6 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.u -= i6;
        return i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i2 = this.u;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        return new C0340aG0(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        s();
        int i2 = this.u;
        if (i >= 0 && i <= i2) {
            int size = collection.size();
            l(i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        s();
        int i2 = this.u;
        if (i >= 0 && i <= i2) {
            ((AbstractList) this).modCount++;
            t(i, 1);
            this.t[i] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return AbstractC1229of.d(this.t, 0, this.u);
    }
}
