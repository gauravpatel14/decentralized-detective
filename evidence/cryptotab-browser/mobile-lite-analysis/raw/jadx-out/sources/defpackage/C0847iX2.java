package defpackage;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: iX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0847iX2 extends EU2 implements RandomAccess, JW2, InterfaceC0421bY2 {
    public static final C0847iX2 w;
    public long[] u;
    public int v;

    static {
        C0847iX2 c0847iX2 = new C0847iX2(new long[0], 0);
        w = c0847iX2;
        c0847iX2.t = false;
    }

    public C0847iX2(long[] jArr, int i) {
        this.u = jArr;
        this.v = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        e();
        if (i < 0 || i > (i2 = this.v)) {
            throw new IndexOutOfBoundsException(Vx1.a(i, this.v, "Index:", ", Size:"));
        }
        long[] jArr = this.u;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.u, i, jArr2, i + 1, this.v - i);
            this.u = jArr2;
        }
        this.u[i] = jLongValue;
        this.v++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.EU2, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        e();
        Charset charset = NW2.a;
        collection.getClass();
        if (!(collection instanceof C0847iX2)) {
            return super.addAll(collection);
        }
        C0847iX2 c0847iX2 = (C0847iX2) collection;
        int i = c0847iX2.v;
        if (i == 0) {
            return false;
        }
        int i2 = this.v;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.u;
        if (i3 > jArr.length) {
            this.u = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(c0847iX2.u, 0, this.u, this.v, c0847iX2.v);
        this.v = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // defpackage.LW2
    public final LW2 c(int i) {
        if (i >= this.v) {
            return new C0847iX2(Arrays.copyOf(this.u, i), this.v);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // defpackage.EU2, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0847iX2)) {
            return super.equals(obj);
        }
        C0847iX2 c0847iX2 = (C0847iX2) obj;
        if (this.v != c0847iX2.v) {
            return false;
        }
        long[] jArr = c0847iX2.u;
        for (int i = 0; i < this.v; i++) {
            if (this.u[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void g(long j) {
        e();
        int i = this.v;
        long[] jArr = this.u;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.u = jArr2;
        }
        long[] jArr3 = this.u;
        int i2 = this.v;
        this.v = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        h(i);
        return Long.valueOf(this.u[i]);
    }

    public final void h(int i) {
        if (i < 0 || i >= this.v) {
            throw new IndexOutOfBoundsException(Vx1.a(i, this.v, "Index:", ", Size:"));
        }
    }

    @Override // defpackage.EU2, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.v; i++) {
            iA = (iA * 31) + NW2.a(this.u[i]);
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.v;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.u[i2] == jLongValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // defpackage.EU2, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        e();
        h(i);
        long[] jArr = this.u;
        long j = jArr[i];
        if (i < this.v - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.v--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        e();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.u;
        System.arraycopy(jArr, i2, jArr, i, this.v - i2);
        this.v -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        e();
        h(i);
        long[] jArr = this.u;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.v;
    }

    @Override // defpackage.EU2, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Long) obj).longValue());
        return true;
    }
}
