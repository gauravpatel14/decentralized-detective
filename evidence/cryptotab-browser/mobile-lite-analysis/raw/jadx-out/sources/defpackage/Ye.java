package defpackage;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ye extends B {
    public static final Object[] w = new Object[0];
    public int t;
    public Object[] u = w;
    public int v;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2 = this.v;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        v();
        l(this.v + 1);
        int iU = u(this.t + i);
        int i3 = this.v;
        if (i < ((i3 + 1) >> 1)) {
            int length = iU == 0 ? this.u.length - 1 : iU - 1;
            int i4 = this.t;
            int length2 = i4 == 0 ? this.u.length - 1 : i4 - 1;
            if (length >= i4) {
                Object[] objArr = this.u;
                objArr[length2] = objArr[i4];
                AbstractC1229of.b(i4, i4 + 1, length + 1, objArr, objArr);
            } else {
                Object[] objArr2 = this.u;
                AbstractC1229of.b(i4 - 1, i4, objArr2.length, objArr2, objArr2);
                Object[] objArr3 = this.u;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC1229of.b(0, 1, length + 1, objArr3, objArr3);
            }
            this.u[length] = obj;
            this.t = length2;
        } else {
            int iU2 = u(i3 + this.t);
            if (iU < iU2) {
                Object[] objArr4 = this.u;
                AbstractC1229of.b(iU + 1, iU, iU2, objArr4, objArr4);
            } else {
                Object[] objArr5 = this.u;
                AbstractC1229of.b(1, 0, iU2, objArr5, objArr5);
                Object[] objArr6 = this.u;
                objArr6[0] = objArr6[objArr6.length - 1];
                AbstractC1229of.b(iU + 1, iU, objArr6.length - 1, objArr6, objArr6);
            }
            this.u[iU] = obj;
        }
        this.v++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        int i2 = this.v;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.v) {
            return addAll(collection);
        }
        v();
        l(collection.size() + this.v);
        int iU = u(this.v + this.t);
        int iU2 = u(this.t + i);
        int size = collection.size();
        if (i < ((this.v + 1) >> 1)) {
            int i3 = this.t;
            int length = i3 - size;
            if (iU2 < i3) {
                Object[] objArr = this.u;
                AbstractC1229of.b(length, i3, objArr.length, objArr, objArr);
                if (size >= iU2) {
                    Object[] objArr2 = this.u;
                    AbstractC1229of.b(objArr2.length - size, 0, iU2, objArr2, objArr2);
                } else {
                    Object[] objArr3 = this.u;
                    AbstractC1229of.b(objArr3.length - size, 0, size, objArr3, objArr3);
                    Object[] objArr4 = this.u;
                    AbstractC1229of.b(0, size, iU2, objArr4, objArr4);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.u;
                AbstractC1229of.b(length, i3, iU2, objArr5, objArr5);
            } else {
                Object[] objArr6 = this.u;
                length += objArr6.length;
                int i4 = iU2 - i3;
                int length2 = objArr6.length - length;
                if (length2 >= i4) {
                    AbstractC1229of.b(length, i3, iU2, objArr6, objArr6);
                } else {
                    AbstractC1229of.b(length, i3, i3 + length2, objArr6, objArr6);
                    Object[] objArr7 = this.u;
                    AbstractC1229of.b(0, this.t + length2, iU2, objArr7, objArr7);
                }
            }
            this.t = length;
            j(s(iU2 - size), collection);
        } else {
            int i5 = iU2 + size;
            if (iU2 < iU) {
                int i6 = size + iU;
                Object[] objArr8 = this.u;
                if (i6 <= objArr8.length) {
                    AbstractC1229of.b(i5, iU2, iU, objArr8, objArr8);
                } else if (i5 >= objArr8.length) {
                    AbstractC1229of.b(i5 - objArr8.length, iU2, iU, objArr8, objArr8);
                } else {
                    int length3 = iU - (i6 - objArr8.length);
                    AbstractC1229of.b(0, length3, iU, objArr8, objArr8);
                    Object[] objArr9 = this.u;
                    AbstractC1229of.b(i5, iU2, length3, objArr9, objArr9);
                }
            } else {
                Object[] objArr10 = this.u;
                AbstractC1229of.b(size, 0, iU, objArr10, objArr10);
                Object[] objArr11 = this.u;
                if (i5 >= objArr11.length) {
                    AbstractC1229of.b(i5 - objArr11.length, iU2, objArr11.length, objArr11, objArr11);
                } else {
                    AbstractC1229of.b(0, objArr11.length - size, objArr11.length, objArr11, objArr11);
                    Object[] objArr12 = this.u;
                    AbstractC1229of.b(i5, iU2, objArr12.length - size, objArr12, objArr12);
                }
            }
            j(iU2, collection);
        }
        return true;
    }

    public final void addFirst(Object obj) {
        v();
        l(this.v + 1);
        int length = this.t;
        if (length == 0) {
            length = this.u.length;
        }
        int i = length - 1;
        this.t = i;
        this.u[i] = obj;
        this.v++;
    }

    public final void addLast(Object obj) {
        v();
        l(f() + 1);
        this.u[u(f() + this.t)] = obj;
        this.v = f() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            v();
            t(this.t, u(f() + this.t));
        }
        this.t = 0;
        this.v = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // defpackage.B
    public final int f() {
        return this.v;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int iF = f();
        if (i < 0 || i >= iF) {
            throw new IndexOutOfBoundsException(Vx1.a(i, iF, "index: ", ", size: "));
        }
        return this.u[u(this.t + i)];
    }

    @Override // defpackage.B
    public final Object i(int i) {
        int i2 = this.v;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(Vx1.a(i, i2, "index: ", ", size: "));
        }
        if (i == OG.c(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        v();
        int iU = u(this.t + i);
        Object[] objArr = this.u;
        Object obj = objArr[iU];
        if (i < (this.v >> 1)) {
            int i3 = this.t;
            if (iU >= i3) {
                AbstractC1229of.b(i3 + 1, i3, iU, objArr, objArr);
            } else {
                AbstractC1229of.b(1, 0, iU, objArr, objArr);
                Object[] objArr2 = this.u;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i4 = this.t;
                AbstractC1229of.b(i4 + 1, i4, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.u;
            int i5 = this.t;
            objArr3[i5] = null;
            this.t = p(i5);
        } else {
            int iU2 = u(OG.c(this) + this.t);
            if (iU <= iU2) {
                Object[] objArr4 = this.u;
                AbstractC1229of.b(iU, iU + 1, iU2 + 1, objArr4, objArr4);
            } else {
                Object[] objArr5 = this.u;
                AbstractC1229of.b(iU, iU + 1, objArr5.length, objArr5, objArr5);
                Object[] objArr6 = this.u;
                objArr6[objArr6.length - 1] = objArr6[0];
                AbstractC1229of.b(0, 1, iU2 + 1, objArr6, objArr6);
            }
            this.u[iU2] = null;
        }
        this.v--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iU = u(f() + this.t);
        int length = this.t;
        if (length < iU) {
            while (length < iU) {
                if (lz0.a(obj, this.u[length])) {
                    i = this.t;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iU) {
            return -1;
        }
        int length2 = this.u.length;
        while (true) {
            if (length >= length2) {
                for (int i2 = 0; i2 < iU; i2++) {
                    if (lz0.a(obj, this.u[i2])) {
                        length = i2 + this.u.length;
                        i = this.t;
                    }
                }
                return -1;
            }
            if (lz0.a(obj, this.u[length])) {
                i = this.t;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return f() == 0;
    }

    public final void j(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.u.length;
        while (i < length && it.hasNext()) {
            this.u[i] = it.next();
            i++;
        }
        int i2 = this.t;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.u[i3] = it.next();
        }
        this.v = collection.size() + f();
    }

    public final void l(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.u;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == w) {
            if (i < 10) {
                i = 10;
            }
            this.u = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        AbstractC1229of.b(0, this.t, objArr.length, objArr, objArr2);
        Object[] objArr3 = this.u;
        int length2 = objArr3.length;
        int i3 = this.t;
        AbstractC1229of.b(length2 - i3, 0, i3, objArr3, objArr2);
        this.t = 0;
        this.u = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iU = u(f() + this.t);
        int i2 = this.t;
        if (i2 < iU) {
            length = iU - 1;
            if (i2 <= length) {
                while (!lz0.a(obj, this.u[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.t;
                return length - i;
            }
            return -1;
        }
        if (i2 > iU) {
            int i3 = iU - 1;
            while (true) {
                if (-1 >= i3) {
                    length = this.u.length - 1;
                    int i4 = this.t;
                    if (i4 <= length) {
                        while (!lz0.a(obj, this.u[length])) {
                            if (length != i4) {
                                length--;
                            }
                        }
                        i = this.t;
                    }
                } else {
                    if (lz0.a(obj, this.u[i3])) {
                        length = i3 + this.u.length;
                        i = this.t;
                        break;
                    }
                    i3--;
                }
            }
        }
        return -1;
    }

    public final int p(int i) {
        if (i == this.u.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        i(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iU;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.u.length != 0) {
            int iU2 = u(f() + this.t);
            int i = this.t;
            if (i < iU2) {
                iU = i;
                while (i < iU2) {
                    Object obj = this.u[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.u[iU] = obj;
                        iU++;
                    }
                    i++;
                }
                Arrays.fill(this.u, iU, iU2, (Object) null);
            } else {
                int length = this.u.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.u;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.u[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iU = u(i2);
                for (int i3 = 0; i3 < iU2; i3++) {
                    Object[] objArr2 = this.u;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.u[iU] = obj3;
                        iU = p(iU);
                    }
                }
                z = z2;
            }
            if (z) {
                v();
                this.v = s(iU - this.t);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        v();
        Object[] objArr = this.u;
        int i = this.t;
        Object obj = objArr[i];
        objArr[i] = null;
        this.t = p(i);
        this.v = f() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        v();
        int iU = u(OG.c(this) + this.t);
        Object[] objArr = this.u;
        Object obj = objArr[iU];
        objArr[iU] = null;
        this.v = f() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        z.a(i, i2, this.v);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.v) {
            clear();
            return;
        }
        if (i3 == 1) {
            i(i);
            return;
        }
        v();
        if (i < this.v - i2) {
            int iU = u((i - 1) + this.t);
            int iU2 = u((i2 - 1) + this.t);
            while (i > 0) {
                int i4 = iU + 1;
                int iMin = Math.min(i, Math.min(i4, iU2 + 1));
                Object[] objArr = this.u;
                int i5 = iU2 - iMin;
                int i6 = iU - iMin;
                AbstractC1229of.b(i5 + 1, i6 + 1, i4, objArr, objArr);
                iU = s(i6);
                iU2 = s(i5);
                i -= iMin;
            }
            int iU3 = u(this.t + i3);
            t(this.t, iU3);
            this.t = iU3;
        } else {
            int iU4 = u(this.t + i2);
            int iU5 = u(this.t + i);
            int i7 = this.v;
            while (true) {
                i7 -= i2;
                if (i7 <= 0) {
                    break;
                }
                Object[] objArr2 = this.u;
                i2 = Math.min(i7, Math.min(objArr2.length - iU4, objArr2.length - iU5));
                Object[] objArr3 = this.u;
                int i8 = iU4 + i2;
                AbstractC1229of.b(iU5, iU4, i8, objArr3, objArr3);
                iU4 = u(i8);
                iU5 = u(iU5 + i2);
            }
            int iU6 = u(this.v + this.t);
            t(s(iU6 - i3), iU6);
        }
        this.v -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iU;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.u.length != 0) {
            int iU2 = u(f() + this.t);
            int i = this.t;
            if (i < iU2) {
                iU = i;
                while (i < iU2) {
                    Object obj = this.u[i];
                    if (collection.contains(obj)) {
                        this.u[iU] = obj;
                        iU++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                Arrays.fill(this.u, iU, iU2, (Object) null);
            } else {
                int length = this.u.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.u;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.u[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iU = u(i2);
                for (int i3 = 0; i3 < iU2; i3++) {
                    Object[] objArr2 = this.u;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        this.u[iU] = obj3;
                        iU = p(iU);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                v();
                this.v = s(iU - this.t);
            }
        }
        return z;
    }

    public final int s(int i) {
        return i < 0 ? i + this.u.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iF = f();
        if (i < 0 || i >= iF) {
            throw new IndexOutOfBoundsException(Vx1.a(i, iF, "index: ", ", size: "));
        }
        int iU = u(this.t + i);
        Object[] objArr = this.u;
        Object obj2 = objArr[iU];
        objArr[iU] = obj;
        return obj2;
    }

    public final void t(int i, int i2) {
        if (i < i2) {
            Arrays.fill(this.u, i, i2, (Object) null);
            return;
        }
        Object[] objArr = this.u;
        Arrays.fill(objArr, i, objArr.length, (Object) null);
        Arrays.fill(this.u, 0, i2, (Object) null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[f()]);
    }

    public final int u(int i) {
        Object[] objArr = this.u;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void v() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        int length = objArr.length;
        int i = this.v;
        if (length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        int iU = u(this.v + this.t);
        int i2 = this.t;
        if (i2 < iU) {
            AbstractC1229of.c(this.u, objArr, 0, i2, iU, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.u;
            AbstractC1229of.b(0, this.t, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.u;
            AbstractC1229of.b(objArr3.length - this.t, 0, iU, objArr3, objArr);
        }
        int i3 = this.v;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        v();
        l(collection.size() + f());
        j(u(f() + this.t), collection);
        return true;
    }
}
