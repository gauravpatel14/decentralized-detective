package defpackage;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: my0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1118my0 extends E implements RandomAccess, Yk1 {
    public static final /* synthetic */ int w = 0;
    public int[] u;
    public int v;

    static {
        new C1118my0(new int[0], 0).t = false;
    }

    public C1118my0(int[] iArr, int i) {
        this.u = iArr;
        this.v = i;
    }

    @Override // defpackage.fz0
    public final fz0 Y(int i) {
        if (i >= this.v) {
            return new C1118my0(Arrays.copyOf(this.u, i), this.v);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        e();
        if (i < 0 || i > (i2 = this.v)) {
            StringBuilder sbA = AbstractC0672fs1.a(i, "Index:", ", Size:");
            sbA.append(this.v);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        int[] iArr = this.u;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.u, i, iArr2, i + 1, this.v - i);
            this.u = iArr2;
        }
        this.u[i] = iIntValue;
        this.v++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.E, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        e();
        Charset charset = gz0.a;
        collection.getClass();
        if (!(collection instanceof C1118my0)) {
            return super.addAll(collection);
        }
        C1118my0 c1118my0 = (C1118my0) collection;
        int i = c1118my0.v;
        if (i == 0) {
            return false;
        }
        int i2 = this.v;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.u;
        if (i3 > iArr.length) {
            this.u = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(c1118my0.u, 0, this.u, this.v, c1118my0.v);
        this.v = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1118my0)) {
            return super.equals(obj);
        }
        C1118my0 c1118my0 = (C1118my0) obj;
        if (this.v != c1118my0.v) {
            return false;
        }
        int[] iArr = c1118my0.u;
        for (int i = 0; i < this.v; i++) {
            if (this.u[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i) {
        e();
        int i2 = this.v;
        int[] iArr = this.u;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.u = iArr2;
        }
        int[] iArr3 = this.u;
        int i3 = this.v;
        this.v = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        h(i);
        return Integer.valueOf(this.u[i]);
    }

    public final void h(int i) {
        if (i < 0 || i >= this.v) {
            StringBuilder sbA = AbstractC0672fs1.a(i, "Index:", ", Size:");
            sbA.append(this.v);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.v; i2++) {
            i = (i * 31) + this.u[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.v;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.u[i2] == iIntValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        e();
        h(i);
        int[] iArr = this.u;
        int i2 = iArr[i];
        if (i < this.v - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.v--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        e();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.u;
        System.arraycopy(iArr, i2, iArr, i, this.v - i2);
        this.v -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        e();
        h(i);
        int[] iArr = this.u;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.v;
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Integer) obj).intValue());
        return true;
    }
}
