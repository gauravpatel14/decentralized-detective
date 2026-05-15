package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EJ0 implements Cloneable {
    public /* synthetic */ boolean t;
    public /* synthetic */ long[] u;
    public /* synthetic */ Object[] v;
    public /* synthetic */ int w;

    public EJ0() {
        int i;
        int i2 = 4;
        while (true) {
            i = 80;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (80 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 8;
        this.u = new long[i4];
        this.v = new Object[i4];
    }

    public final void a() {
        int i = this.w;
        Object[] objArr = this.v;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.w = 0;
        this.t = false;
    }

    public final Object b(long j) {
        Object obj;
        int iB = AbstractC0699gL.b(this.u, this.w, j);
        if (iB < 0 || (obj = this.v[iB]) == FJ0.a) {
            return null;
        }
        return obj;
    }

    public final int c(long j) {
        if (this.t) {
            int i = this.w;
            long[] jArr = this.u;
            Object[] objArr = this.v;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != FJ0.a) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.t = false;
            this.w = i2;
        }
        return AbstractC0699gL.b(this.u, this.w, j);
    }

    public final Object clone() {
        EJ0 ej0 = (EJ0) super.clone();
        ej0.u = (long[]) this.u.clone();
        ej0.v = (Object[]) this.v.clone();
        return ej0;
    }

    public final long d(int i) {
        if (!(i >= 0 && i < this.w)) {
            AbstractC1588ux1.a("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.t) {
            int i2 = this.w;
            long[] jArr = this.u;
            Object[] objArr = this.v;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != FJ0.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.t = false;
            this.w = i3;
        }
        return this.u[i];
    }

    public final void e(long j, Object obj) {
        int iB = AbstractC0699gL.b(this.u, this.w, j);
        if (iB >= 0) {
            this.v[iB] = obj;
            return;
        }
        int i = ~iB;
        int i2 = this.w;
        Object obj2 = FJ0.a;
        if (i < i2) {
            Object[] objArr = this.v;
            if (objArr[i] == obj2) {
                this.u[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.t) {
            long[] jArr = this.u;
            if (i2 >= jArr.length) {
                Object[] objArr2 = this.v;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj3 = objArr2[i4];
                    if (obj3 != obj2) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr2[i3] = obj3;
                            objArr2[i4] = null;
                        }
                        i3++;
                    }
                }
                this.t = false;
                this.w = i3;
                i = ~AbstractC0699gL.b(this.u, i3, j);
            }
        }
        int i5 = this.w;
        if (i5 >= this.u.length) {
            int i6 = (i5 + 1) * 8;
            int i7 = 4;
            while (true) {
                if (i7 >= 32) {
                    break;
                }
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
                i7++;
            }
            int i9 = i6 / 8;
            this.u = Arrays.copyOf(this.u, i9);
            this.v = Arrays.copyOf(this.v, i9);
        }
        int i10 = this.w - i;
        if (i10 != 0) {
            long[] jArr2 = this.u;
            int i11 = i + 1;
            System.arraycopy(jArr2, i, jArr2, i11, i10);
            Object[] objArr3 = this.v;
            AbstractC1229of.b(i11, i, this.w, objArr3, objArr3);
        }
        this.u[i] = j;
        this.v[i] = obj;
        this.w++;
    }

    public final void f(long j) {
        int iB = AbstractC0699gL.b(this.u, this.w, j);
        if (iB >= 0) {
            Object[] objArr = this.v;
            Object obj = objArr[iB];
            Object obj2 = FJ0.a;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.t = true;
            }
        }
    }

    public final int g() {
        if (this.t) {
            int i = this.w;
            long[] jArr = this.u;
            Object[] objArr = this.v;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != FJ0.a) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.t = false;
            this.w = i2;
        }
        return this.w;
    }

    public final Object h(int i) {
        if (!(i >= 0 && i < this.w)) {
            AbstractC1588ux1.a("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.t) {
            int i2 = this.w;
            long[] jArr = this.u;
            Object[] objArr = this.v;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != FJ0.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.t = false;
            this.w = i3;
        }
        return this.v[i];
    }

    public final String toString() {
        if (g() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.w * 28);
        sb.append('{');
        int i = this.w;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(d(i2));
            sb.append('=');
            Object objH = h(i2);
            if (objH != sb) {
                sb.append(objH);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
