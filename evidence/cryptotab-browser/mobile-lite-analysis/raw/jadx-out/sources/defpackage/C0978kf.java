package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: kf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0978kf implements Collection, Set, BB0 {
    public int[] t;
    public Object[] u;
    public int v;

    public C0978kf(int i) {
        this.t = AbstractC0699gL.a;
        this.u = AbstractC0699gL.b;
        if (i > 0) {
            this.t = new int[i];
            this.u = new Object[i];
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int iA;
        int i2 = this.v;
        if (obj == null) {
            iA = AbstractC1040lf.a(this, null, 0);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iA = AbstractC1040lf.a(this, obj, iHashCode);
        }
        if (iA >= 0) {
            return false;
        }
        int i3 = ~iA;
        int[] iArr = this.t;
        if (i2 >= iArr.length) {
            int i4 = 8;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.u;
            int[] iArr2 = new int[i4];
            this.t = iArr2;
            this.u = new Object[i4];
            if (i2 != this.v) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                AbstractC1229of.c(objArr, this.u, 0, 0, objArr.length, 6);
            }
        }
        if (i3 < i2) {
            int[] iArr3 = this.t;
            int i5 = i3 + 1;
            AbstractC1229of.a(i5, i3, i2, iArr3, iArr3);
            Object[] objArr2 = this.u;
            AbstractC1229of.b(i5, i3, i2, objArr2, objArr2);
        }
        int i6 = this.v;
        if (i2 == i6) {
            int[] iArr4 = this.t;
            if (i3 < iArr4.length) {
                iArr4[i3] = i;
                this.u[i3] = obj;
                this.v = i6 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.v;
        int i = this.v;
        int[] iArr = this.t;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.u;
            int[] iArr2 = new int[size];
            this.t = iArr2;
            this.u = new Object[size];
            if (i > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, i);
                AbstractC1229of.c(objArr, this.u, 0, 0, this.v, 6);
            }
        }
        if (this.v != i) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.v != 0) {
            this.t = AbstractC0699gL.a;
            this.u = AbstractC0699gL.b;
            this.v = 0;
        }
        if (this.v != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? AbstractC1040lf.a(this, null, 0) : AbstractC1040lf.a(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object e(int i) {
        int i2 = this.v;
        Object[] objArr = this.u;
        Object obj = objArr[i];
        if (i2 <= 1) {
            clear();
        } else {
            int i3 = i2 - 1;
            int[] iArr = this.t;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                if (i < i3) {
                    int i4 = i + 1;
                    AbstractC1229of.a(i, i4, i2, iArr, iArr);
                    Object[] objArr2 = this.u;
                    AbstractC1229of.b(i, i4, i2, objArr2, objArr2);
                }
                this.u[i3] = null;
            } else {
                int i5 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArr2 = new int[i5];
                this.t = iArr2;
                this.u = new Object[i5];
                if (i > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    AbstractC1229of.c(objArr, this.u, 0, 0, i, 6);
                }
                if (i < i3) {
                    int i6 = i + 1;
                    AbstractC1229of.a(i, i6, i2, iArr, this.t);
                    AbstractC1229of.b(i, i6, i2, objArr, this.u);
                }
            }
            if (i2 != this.v) {
                throw new ConcurrentModificationException();
            }
            this.v = i3;
        }
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && this.v == ((Set) obj).size()) {
            try {
                int i = this.v;
                for (int i2 = 0; i2 < i; i2++) {
                    if (((Set) obj).contains(this.u[i2])) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.t;
        int i = this.v;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.v <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C0917jf(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iA = obj == null ? AbstractC1040lf.a(this, null, 0) : AbstractC1040lf.a(this, obj, obj.hashCode());
        if (iA < 0) {
            return false;
        }
        e(iA);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z = false;
        for (int i = this.v - 1; -1 < i; i--) {
            if (!MG.f(collection, this.u[i])) {
                e(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.v;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return AbstractC1229of.d(this.u, 0, this.v);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.v * 14);
        sb.append('{');
        int i = this.v;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.u[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        int i = this.v;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        AbstractC1229of.b(0, 0, this.v, this.u, objArr);
        return objArr;
    }
}
