package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: renamed from: hD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0760hD2 extends AbstractC1543uC2 implements List, RandomAccess {
    public static final OC2 u = new OC2(C1769yD2.x, 0);

    public static C1769yD2 t(int i, Object[] objArr) {
        return i == 0 ? C1769yD2.x : new C1769yD2(i, objArr);
    }

    public static AbstractC0760hD2 u(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return v((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return C1769yD2.x;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            Object[] objArr = {next};
            AbstractC1313qD2.a(1, objArr);
            return t(1, objArr);
        }
        FC2 fc2 = new FC2();
        fc2.a = new Object[4];
        fc2.b = 0;
        fc2.a(next);
        while (it.hasNext()) {
            fc2.a(it.next());
        }
        fc2.c = true;
        return t(fc2.b, fc2.a);
    }

    public static AbstractC0760hD2 v(Collection collection) {
        if (!(collection instanceof AbstractC1543uC2)) {
            Object[] array = collection.toArray();
            int length = array.length;
            AbstractC1313qD2.a(length, array);
            return t(length, array);
        }
        AbstractC0760hD2 abstractC0760hD2 = (AbstractC0760hD2) ((AbstractC1543uC2) collection);
        abstractC0760hD2.getClass();
        if (!abstractC0760hD2.l()) {
            return abstractC0760hD2;
        }
        Object[] array2 = abstractC0760hD2.toArray(AbstractC1543uC2.t);
        return t(array2.length, array2);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        Object next;
        Object next2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        Object obj2 = get(i);
                        Object obj3 = list.get(i);
                        if (obj2 == obj3 || (obj2 != null && obj2.equals(obj3))) {
                        }
                    }
                    return true;
                }
                OC2 oc2ListIterator = listIterator(0);
                Iterator it = list.iterator();
                while (true) {
                    if (oc2ListIterator.hasNext()) {
                        if (!it.hasNext() || ((next = oc2ListIterator.next()) != (next2 = it.next()) && (next == null || !next.equals(next2)))) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // defpackage.AbstractC1543uC2
    public int f(Object[] objArr) {
        int size = size();
        for (int i = 0; i < size; i++) {
            objArr[i] = get(i);
        }
        return size;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
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
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: s */
    public AbstractC0760hD2 subList(int i, int i2) {
        f23.c(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? C1769yD2.x : new YC2(this, i, i3);
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final OC2 listIterator(int i) {
        f23.b(i, size());
        return isEmpty() ? u : new OC2(this, i);
    }
}
