package defpackage;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: renamed from: hn1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0802hn1 extends E implements RandomAccess {
    public static final C0802hn1 w;
    public Object[] u;
    public int v;

    static {
        C0802hn1 c0802hn1 = new C0802hn1(0, new Object[0]);
        w = c0802hn1;
        c0802hn1.t = false;
    }

    public C0802hn1(int i, Object[] objArr) {
        this.u = objArr;
        this.v = i;
    }

    @Override // defpackage.fz0
    public final fz0 Y(int i) {
        if (i < this.v) {
            throw new IllegalArgumentException();
        }
        return new C0802hn1(this.v, Arrays.copyOf(this.u, i));
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
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

    public final void g(int i) {
        if (i < 0 || i >= this.v) {
            StringBuilder sbA = AbstractC0672fs1.a(i, "Index:", ", Size:");
            sbA.append(this.v);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        g(i);
        return this.u[i];
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.List
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

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        e();
        if (i >= 0 && i <= (i2 = this.v)) {
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
            return;
        }
        StringBuilder sbA = AbstractC0672fs1.a(i, "Index:", ", Size:");
        sbA.append(this.v);
        throw new IndexOutOfBoundsException(sbA.toString());
    }
}
