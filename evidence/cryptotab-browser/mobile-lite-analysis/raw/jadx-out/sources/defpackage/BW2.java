package defpackage;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BW2 extends EU2 implements RandomAccess, HW2, InterfaceC0421bY2 {
    public static final BW2 w;
    public int[] u;
    public int v;

    static {
        BW2 bw2 = new BW2(new int[0], 0);
        w = bw2;
        bw2.t = false;
    }

    public BW2(int[] iArr, int i) {
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

    @Override // defpackage.EU2, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        e();
        Charset charset = NW2.a;
        collection.getClass();
        if (!(collection instanceof BW2)) {
            return super.addAll(collection);
        }
        BW2 bw2 = (BW2) collection;
        int i = bw2.v;
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
        System.arraycopy(bw2.u, 0, this.u, this.v, bw2.v);
        this.v = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // defpackage.LW2
    public final LW2 c(int i) {
        if (i >= this.v) {
            return new BW2(Arrays.copyOf(this.u, i), this.v);
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
        if (!(obj instanceof BW2)) {
            return super.equals(obj);
        }
        BW2 bw2 = (BW2) obj;
        if (this.v != bw2.v) {
            return false;
        }
        int[] iArr = bw2.u;
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
    public final /* synthetic */ Object get(int i) {
        h(i);
        return Integer.valueOf(this.u[i]);
    }

    public final void h(int i) {
        if (i < 0 || i >= this.v) {
            throw new IndexOutOfBoundsException(Vx1.a(i, this.v, "Index:", ", Size:"));
        }
    }

    @Override // defpackage.EU2, java.util.AbstractList, java.util.Collection, java.util.List
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

    @Override // defpackage.EU2, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
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
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
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

    @Override // defpackage.EU2, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Integer) obj).intValue());
        return true;
    }
}
