package defpackage;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class QJ2 extends UF2 implements RandomAccess, InterfaceC0952kK2, WN2 {
    public static final QJ2 w = new QJ2(new int[0], 0, false);
    public int[] u;
    public int v;

    public QJ2(int[] iArr, int i, boolean z) {
        super(z);
        this.u = iArr;
        this.v = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        e();
        if (i < 0 || i > (i2 = this.v)) {
            throw new IndexOutOfBoundsException(Vx1.a(i, this.v, "Index:", ", Size:"));
        }
        int i3 = i + 1;
        int[] iArr = this.u;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i3, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.u, i, iArr2, i3, this.v - i);
            this.u = iArr2;
        }
        this.u[i] = iIntValue;
        this.v++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.UF2, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        e();
        Charset charset = WK2.a;
        collection.getClass();
        if (!(collection instanceof QJ2)) {
            return super.addAll(collection);
        }
        QJ2 qj2 = (QJ2) collection;
        int i = qj2.v;
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
        System.arraycopy(qj2.u, 0, this.u, this.v, qj2.v);
        this.v = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // defpackage.InterfaceC1606vK2
    public final /* bridge */ /* synthetic */ InterfaceC1606vK2 c(int i) {
        if (i >= this.v) {
            return new QJ2(Arrays.copyOf(this.u, i), this.v, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // defpackage.UF2, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QJ2)) {
            return super.equals(obj);
        }
        QJ2 qj2 = (QJ2) obj;
        if (this.v != qj2.v) {
            return false;
        }
        int[] iArr = qj2.u;
        for (int i = 0; i < this.v; i++) {
            if (this.u[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int g(int i) {
        i(i);
        return this.u[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        i(i);
        return Integer.valueOf(this.u[i]);
    }

    public final void h(int i) {
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

    @Override // defpackage.UF2, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.v; i2++) {
            i = (i * 31) + this.u[i2];
        }
        return i;
    }

    public final void i(int i) {
        if (i < 0 || i >= this.v) {
            throw new IndexOutOfBoundsException(Vx1.a(i, this.v, "Index:", ", Size:"));
        }
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

    @Override // defpackage.UF2, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        e();
        i(i);
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
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        e();
        i(i);
        int[] iArr = this.u;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.v;
    }

    @Override // defpackage.UF2, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        h(((Integer) obj).intValue());
        return true;
    }
}
