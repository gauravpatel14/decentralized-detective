package defpackage;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class UJ1 {
    public int[] t;
    public Object[] u;
    public int v;

    public UJ1(int i) {
        this.t = i == 0 ? AbstractC0699gL.a : new int[i];
        this.u = i == 0 ? AbstractC0699gL.b : new Object[i << 1];
    }

    public final int a(Object obj) {
        int i = this.v * 2;
        Object[] objArr = this.u;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i) {
        int i2 = this.v;
        int[] iArr = this.t;
        if (iArr.length < i) {
            this.t = Arrays.copyOf(iArr, i);
            this.u = Arrays.copyOf(this.u, i * 2);
        }
        if (this.v != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i, Object obj) {
        int i2 = this.v;
        if (i2 == 0) {
            return -1;
        }
        int iA = AbstractC0699gL.a(i2, i, this.t);
        if (iA < 0 || lz0.a(obj, this.u[iA << 1])) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.t[i3] == i) {
            if (lz0.a(obj, this.u[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.t[i4] == i; i4--) {
            if (lz0.a(obj, this.u[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public final void clear() {
        if (this.v > 0) {
            this.t = AbstractC0699gL.a;
            this.u = AbstractC0699gL.b;
            this.v = 0;
        }
        if (this.v > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj.hashCode(), obj);
    }

    public final int e() {
        int i = this.v;
        if (i == 0) {
            return -1;
        }
        int iA = AbstractC0699gL.a(i, 0, this.t);
        if (iA < 0 || this.u[iA << 1] == null) {
            return iA;
        }
        int i2 = iA + 1;
        while (i2 < i && this.t[i2] == 0) {
            if (this.u[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iA - 1; i3 >= 0 && this.t[i3] == 0; i3--) {
            if (this.u[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof UJ1) {
                int i = this.v;
                if (i != ((UJ1) obj).v) {
                    return false;
                }
                UJ1 uj1 = (UJ1) obj;
                for (int i2 = 0; i2 < i; i2++) {
                    Object objF = f(i2);
                    Object objI = i(i2);
                    Object obj2 = uj1.get(objF);
                    if (objI == null) {
                        if (obj2 != null || !uj1.containsKey(objF)) {
                            return false;
                        }
                    } else if (!objI.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.v != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.v;
            for (int i4 = 0; i4 < i3; i4++) {
                Object objF2 = f(i4);
                Object objI2 = i(i4);
                Object obj3 = ((Map) obj).get(objF2);
                if (objI2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!objI2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i) {
        boolean z = false;
        if (i >= 0 && i < this.v) {
            z = true;
        }
        if (z) {
            return this.u[i << 1];
        }
        AbstractC1588ux1.a("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public final Object g(int i) {
        if (!(i >= 0 && i < this.v)) {
            AbstractC1588ux1.a("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        Object[] objArr = this.u;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.v;
        if (i3 <= 1) {
            clear();
        } else {
            int i4 = i3 - 1;
            int[] iArr = this.t;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i4) {
                    int i5 = i + 1;
                    AbstractC1229of.a(i, i5, i3, iArr, iArr);
                    Object[] objArr2 = this.u;
                    AbstractC1229of.b(i2, i5 << 1, i3 << 1, objArr2, objArr2);
                }
                Object[] objArr3 = this.u;
                int i6 = i4 << 1;
                objArr3[i6] = null;
                objArr3[i6 + 1] = null;
            } else {
                int i7 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                this.t = Arrays.copyOf(iArr, i7);
                this.u = Arrays.copyOf(this.u, i7 << 1);
                if (i3 != this.v) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    AbstractC1229of.a(0, 0, i, iArr, this.t);
                    AbstractC1229of.b(0, 0, i2, objArr, this.u);
                }
                if (i < i4) {
                    int i8 = i + 1;
                    AbstractC1229of.a(i, i8, i3, iArr, this.t);
                    AbstractC1229of.b(i2, i8 << 1, i3 << 1, objArr, this.u);
                }
            }
            if (i3 != this.v) {
                throw new ConcurrentModificationException();
            }
            this.v = i4;
        }
        return obj;
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.u[(iD << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.u[(iD << 1) + 1] : obj2;
    }

    public final Object h(int i, Object obj) {
        boolean z = false;
        if (i >= 0 && i < this.v) {
            z = true;
        }
        if (!z) {
            AbstractC1588ux1.a("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.u;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final int hashCode() {
        int[] iArr = this.t;
        Object[] objArr = this.u;
        int i = this.v;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i) {
        boolean z = false;
        if (i >= 0 && i < this.v) {
            z = true;
        }
        if (z) {
            return this.u[(i << 1) + 1];
        }
        AbstractC1588ux1.a("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public final boolean isEmpty() {
        return this.v <= 0;
    }

    public final Object put(Object obj, Object obj2) {
        int i = this.v;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(iHashCode, obj) : e();
        if (iC >= 0) {
            int i2 = (iC << 1) + 1;
            Object[] objArr = this.u;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~iC;
        int[] iArr = this.t;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            this.t = Arrays.copyOf(iArr, i4);
            this.u = Arrays.copyOf(this.u, i4 << 1);
            if (i != this.v) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.t;
            int i5 = i3 + 1;
            AbstractC1229of.a(i5, i3, i, iArr2, iArr2);
            Object[] objArr2 = this.u;
            AbstractC1229of.b(i5 << 1, i3 << 1, this.v << 1, objArr2, objArr2);
        }
        int i6 = this.v;
        if (i == i6) {
            int[] iArr3 = this.t;
            if (i3 < iArr3.length) {
                iArr3[i3] = iHashCode;
                Object[] objArr3 = this.u;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.v = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return g(iD);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD, obj2);
        }
        return null;
    }

    public final int size() {
        return this.v;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.v * 28);
        sb.append('{');
        int i = this.v;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objF = f(i2);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objI = i(i2);
            if (objI != sb) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !lz0.a(obj2, i(iD))) {
            return false;
        }
        g(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !lz0.a(obj2, i(iD))) {
            return false;
        }
        h(iD, obj3);
        return true;
    }
}
