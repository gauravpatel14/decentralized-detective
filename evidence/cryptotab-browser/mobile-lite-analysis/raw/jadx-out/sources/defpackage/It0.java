package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class It0 extends Ft0 implements List, RandomAccess {
    public static final Gt0 u = new Gt0(C1112mt1.x, 0);

    public static C1112mt1 u(int i, Object[] objArr) {
        return i == 0 ? C1112mt1.x : new C1112mt1(i, objArr);
    }

    public static C1112mt1 v(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(AbstractC1214oR1.a(i, "at index "));
            }
        }
        return u(objArr.length, objArr);
    }

    public static It0 w(Collection collection) {
        if (!(collection instanceof Ft0)) {
            return v(collection.toArray());
        }
        It0 it0F = ((Ft0) collection).f();
        if (!it0F.s()) {
            return it0F;
        }
        Object[] array = it0F.toArray(Ft0.t);
        return u(array.length, array);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.Ft0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        Object next;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(list instanceof RandomAccess)) {
                    Iterator it = list.iterator();
                    for (Object obj2 : this) {
                        if (it.hasNext() && (r3 == (next = it.next()) || (obj2 != null && obj2.equals(next)))) {
                        }
                    }
                    return !it.hasNext();
                }
                for (int i = 0; i < size; i++) {
                    Object obj3 = get(i);
                    Object obj4 = list.get(i);
                    if (obj3 == obj4 || (obj3 != null && obj3.equals(obj4))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // defpackage.Ft0
    public int i(Object[] objArr) {
        int size = size();
        for (int i = 0; i < size; i++) {
            objArr[i] = get(i);
        }
        return size;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // defpackage.Ft0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.Ft0
    /* JADX INFO: renamed from: t */
    public final AbstractC0494ck2 iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public final Gt0 listIterator(int i) {
        size();
        return isEmpty() ? u : new Gt0(this, i);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: y */
    public It0 subList(int i, int i2) {
        size();
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? C1112mt1.x : new Ht0(this, i, i3);
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // defpackage.Ft0
    public final It0 f() {
        return this;
    }
}
