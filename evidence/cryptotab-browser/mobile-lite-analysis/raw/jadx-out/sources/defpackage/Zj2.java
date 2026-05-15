package defpackage;

import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Zj2 {
    public static final Zj2 f = new Zj2(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public Zj2(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static Zj2 b() {
        return new Zj2(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iW;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = this.b[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 == 0) {
                iW = CG.w(i4, ((Long) this.c[i2]).longValue());
            } else if (i5 == 1) {
                ((Long) this.c[i2]).getClass();
                iW = CG.h(i4);
            } else if (i5 == 2) {
                iW = CG.c(i4, (C0199Qv) this.c[i2]);
            } else if (i5 == 3) {
                iA = ((Zj2) this.c[i2]).a() + (CG.t(i4) * 2) + iA;
            } else {
                if (i5 != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.c());
                }
                ((Integer) this.c[i2]).getClass();
                iW = CG.g(i4);
            }
            iA = iW + iA;
        }
        this.d = iA;
        return iA;
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

    public final void d(DG dg) {
        if (this.a == 0) {
            return;
        }
        dg.getClass();
        for (int i = 0; i < this.a; i++) {
            int i2 = this.b[i];
            Object obj = this.c[i];
            int i3 = i2 >>> 3;
            int i4 = i2 & 7;
            if (i4 == 0) {
                dg.j(i3, ((Long) obj).longValue());
            } else if (i4 == 1) {
                dg.f(i3, ((Long) obj).longValue());
            } else if (i4 == 2) {
                dg.b(i3, (C0199Qv) obj);
            } else if (i4 == 3) {
                CG cg = dg.a;
                cg.O(i3, 3);
                ((Zj2) obj).d(dg);
                cg.O(i3, 4);
            } else {
                if (i4 != 5) {
                    throw new RuntimeException(InvalidProtocolBufferException.c());
                }
                dg.e(i3, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Zj2)) {
            return false;
        }
        Zj2 zj2 = (Zj2) obj;
        int i = this.a;
        if (i == zj2.a) {
            int[] iArr = this.b;
            int[] iArr2 = zj2.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = zj2.c;
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
        int i2 = (527 + i) * 31;
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
