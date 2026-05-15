package defpackage;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: renamed from: bO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0407bO2 extends UF2 implements RandomAccess {
    public static final C0407bO2 w = new C0407bO2(new Object[0], 0, false);
    public Object[] u;
    public int v;

    public C0407bO2(Object[] objArr, int i, boolean z) {
        super(z);
        this.u = objArr;
        this.v = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        e();
        if (i < 0 || i > (i2 = this.v)) {
            throw new IndexOutOfBoundsException(Vx1.a(i, this.v, "Index:", ", Size:"));
        }
        int i3 = i + 1;
        Object[] objArr = this.u;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i3, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.u, i, objArr2, i3, this.v - i);
            this.u = objArr2;
        }
        this.u[i] = obj;
        this.v++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.InterfaceC1606vK2
    public final /* bridge */ /* synthetic */ InterfaceC1606vK2 c(int i) {
        if (i >= this.v) {
            return new C0407bO2(Arrays.copyOf(this.u, i), this.v, true);
        }
        throw new IllegalArgumentException();
    }

    public final void g(int i) {
        if (i < 0 || i >= this.v) {
            throw new IndexOutOfBoundsException(Vx1.a(i, this.v, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        g(i);
        return this.u[i];
    }

    @Override // defpackage.UF2, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        e();
        g(i);
        Object[] objArr = this.u;
        Object obj = objArr[i];
        if (i < this.v - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.v--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        e();
        g(i);
        Object[] objArr = this.u;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.v;
    }

    @Override // defpackage.UF2, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        e();
        int i = this.v;
        Object[] objArr = this.u;
        if (i == objArr.length) {
            this.u = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.u;
        int i2 = this.v;
        this.v = i2 + 1;
        objArr2[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
