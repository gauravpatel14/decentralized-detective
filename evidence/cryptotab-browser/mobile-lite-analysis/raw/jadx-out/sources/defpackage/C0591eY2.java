package defpackage;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: renamed from: eY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0591eY2 extends EU2 implements RandomAccess {
    public static final C0591eY2 w;
    public Object[] u;
    public int v;

    static {
        C0591eY2 c0591eY2 = new C0591eY2(0, new Object[0]);
        w = c0591eY2;
        c0591eY2.t = false;
    }

    public C0591eY2(int i, Object[] objArr) {
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
        Object[] objArr = this.u;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.u, i, objArr2, i + 1, this.v - i);
            this.u = objArr2;
        }
        this.u[i] = obj;
        this.v++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.LW2
    public final /* bridge */ /* synthetic */ LW2 c(int i) {
        if (i < this.v) {
            throw new IllegalArgumentException();
        }
        return new C0591eY2(this.v, Arrays.copyOf(this.u, i));
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

    @Override // defpackage.EU2, java.util.AbstractList, java.util.List
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

    @Override // defpackage.EU2, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
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
