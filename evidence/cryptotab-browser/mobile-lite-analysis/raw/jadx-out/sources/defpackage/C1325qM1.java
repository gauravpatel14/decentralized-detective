package defpackage;

import java.util.Arrays;

/* JADX INFO: renamed from: qM1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1325qM1 implements Cloneable {
    public /* synthetic */ int[] t;
    public /* synthetic */ Object[] u;
    public /* synthetic */ int v;

    public C1325qM1() {
        int i;
        int i2 = 4;
        while (true) {
            i = 40;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (40 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 4;
        this.t = new int[i4];
        this.u = new Object[i4];
    }

    public final void a(int i, Object obj) {
        int i2 = this.v;
        if (i2 != 0 && i <= this.t[i2 - 1]) {
            c(i, obj);
            return;
        }
        if (i2 >= this.t.length) {
            int i3 = (i2 + 1) * 4;
            int i4 = 4;
            while (true) {
                if (i4 >= 32) {
                    break;
                }
                int i5 = (1 << i4) - 12;
                if (i3 <= i5) {
                    i3 = i5;
                    break;
                }
                i4++;
            }
            int i6 = i3 / 4;
            this.t = Arrays.copyOf(this.t, i6);
            this.u = Arrays.copyOf(this.u, i6);
        }
        this.t[i2] = i;
        this.u[i2] = obj;
        this.v = i2 + 1;
    }

    public final Object b(int i) {
        Object obj;
        int iA = AbstractC0699gL.a(this.v, i, this.t);
        if (iA < 0 || (obj = this.u[iA]) == AbstractC1381rM1.a) {
            return null;
        }
        return obj;
    }

    public final void c(int i, Object obj) {
        int iA = AbstractC0699gL.a(this.v, i, this.t);
        if (iA >= 0) {
            this.u[iA] = obj;
            return;
        }
        int i2 = ~iA;
        int i3 = this.v;
        if (i2 < i3) {
            Object[] objArr = this.u;
            if (objArr[i2] == AbstractC1381rM1.a) {
                this.t[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (i3 >= this.t.length) {
            int i4 = (i3 + 1) * 4;
            int i5 = 4;
            while (true) {
                if (i5 >= 32) {
                    break;
                }
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
                i5++;
            }
            int i7 = i4 / 4;
            this.t = Arrays.copyOf(this.t, i7);
            this.u = Arrays.copyOf(this.u, i7);
        }
        int i8 = this.v;
        if (i8 - i2 != 0) {
            int[] iArr = this.t;
            int i9 = i2 + 1;
            AbstractC1229of.a(i9, i2, i8, iArr, iArr);
            Object[] objArr2 = this.u;
            AbstractC1229of.b(i9, i2, this.v, objArr2, objArr2);
        }
        this.t[i2] = i;
        this.u[i2] = obj;
        this.v++;
    }

    public final Object clone() {
        C1325qM1 c1325qM1 = (C1325qM1) super.clone();
        c1325qM1.t = (int[]) this.t.clone();
        c1325qM1.u = (Object[]) this.u.clone();
        return c1325qM1;
    }

    public final String toString() {
        int i = this.v;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        int i2 = this.v;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(this.t[i3]);
            sb.append('=');
            Object obj = this.u[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
