package defpackage;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: xg0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1746xg0 extends E implements ez0, RandomAccess, Yk1 {
    public static final C1746xg0 w;
    public float[] u;
    public int v;

    static {
        C1746xg0 c1746xg0 = new C1746xg0(new float[0], 0);
        w = c1746xg0;
        c1746xg0.t = false;
    }

    public C1746xg0(float[] fArr, int i) {
        this.u = fArr;
        this.v = i;
    }

    @Override // defpackage.fz0
    public final fz0 Y(int i) {
        if (i >= this.v) {
            return new C1746xg0(Arrays.copyOf(this.u, i), this.v);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        float fFloatValue = ((Float) obj).floatValue();
        e();
        if (i < 0 || i > (i2 = this.v)) {
            StringBuilder sbA = AbstractC0672fs1.a(i, "Index:", ", Size:");
            sbA.append(this.v);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        float[] fArr = this.u;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.u, i, fArr2, i + 1, this.v - i);
            this.u = fArr2;
        }
        this.u[i] = fFloatValue;
        this.v++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.E, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        e();
        Charset charset = gz0.a;
        collection.getClass();
        if (!(collection instanceof C1746xg0)) {
            return super.addAll(collection);
        }
        C1746xg0 c1746xg0 = (C1746xg0) collection;
        int i = c1746xg0.v;
        if (i == 0) {
            return false;
        }
        int i2 = this.v;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.u;
        if (i3 > fArr.length) {
            this.u = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(c1746xg0.u, 0, this.u, this.v, c1746xg0.v);
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
        if (!(obj instanceof C1746xg0)) {
            return super.equals(obj);
        }
        C1746xg0 c1746xg0 = (C1746xg0) obj;
        if (this.v != c1746xg0.v) {
            return false;
        }
        float[] fArr = c1746xg0.u;
        for (int i = 0; i < this.v; i++) {
            if (Float.floatToIntBits(this.u[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final void g(float f) {
        e();
        int i = this.v;
        float[] fArr = this.u;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.u = fArr2;
        }
        float[] fArr3 = this.u;
        int i2 = this.v;
        this.v = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        h(i);
        return Float.valueOf(this.u[i]);
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
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.v; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.u[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i = this.v;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.u[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        e();
        h(i);
        float[] fArr = this.u;
        float f = fArr[i];
        if (i < this.v - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.v--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        e();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.u;
        System.arraycopy(fArr, i2, fArr, i, this.v - i2);
        this.v -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        e();
        h(i);
        float[] fArr = this.u;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.v;
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g(((Float) obj).floatValue());
        return true;
    }
}
