package defpackage;

import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzkm;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EY2 {
    public static final EY2 f = new EY2(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public EY2(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static EY2 b() {
        return new EY2(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iA;
        int iB;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iA2 = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = this.b[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.c[i2]).getClass();
                    iA2 = SX2.a(i4 << 3, 8, iA2);
                } else if (i5 == 2) {
                    WU2 wu2 = (WU2) this.c[i2];
                    int iA3 = BV2.a(i4 << 3);
                    int iJ = wu2.j();
                    iA2 = SX2.b(iJ, iJ, iA3, iA2);
                } else if (i5 == 3) {
                    int iR = BV2.r(i4);
                    iA = iR + iR;
                    iB = ((EY2) this.c[i2]).a();
                } else {
                    if (i5 != 5) {
                        int i6 = zzkm.t;
                        throw new IllegalStateException(new zzkl("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.c[i2]).getClass();
                    iA2 = SX2.a(i4 << 3, 4, iA2);
                }
            } else {
                long jLongValue = ((Long) this.c[i2]).longValue();
                iA = BV2.a(i4 << 3);
                iB = BV2.b(jLongValue);
            }
            iA2 = iB + iA + iA2;
        }
        this.d = iA2;
        return iA2;
    }

    public final void c(int i, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.a;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.b = Arrays.copyOf(iArr, i3);
            this.c = Arrays.copyOf(this.c, i3);
        }
        int[] iArr2 = this.b;
        int i4 = this.a;
        iArr2[i4] = i;
        this.c[i4] = obj;
        this.a = i4 + 1;
    }

    public final void d(FV2 fv2) {
        if (this.a != 0) {
            for (int i = 0; i < this.a; i++) {
                int i2 = this.b[i];
                Object obj = this.c[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    fv2.n(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    fv2.j(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    fv2.f(i3, (WU2) obj);
                } else if (i4 == 3) {
                    fv2.a.k(i3, 3);
                    ((EY2) obj).d(fv2);
                    fv2.a.k(i3, 4);
                } else {
                    if (i4 != 5) {
                        int i5 = zzkm.t;
                        throw new RuntimeException(new zzkl("Protocol message tag had invalid wire type."));
                    }
                    fv2.i(i3, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EY2)) {
            return false;
        }
        EY2 ey2 = (EY2) obj;
        int i = this.a;
        if (i == ey2.a) {
            int[] iArr = this.b;
            int[] iArr2 = ey2.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = ey2.c;
                    int i3 = this.a;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.c;
        int i6 = this.a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }
}
