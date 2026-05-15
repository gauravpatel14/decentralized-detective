package defpackage;

import com.google.android.gms.internal.play_billing.zzdb;
import com.google.android.gms.internal.play_billing.zzdc;
import java.util.Arrays;

/* JADX INFO: renamed from: mP2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1088mP2 {
    public static final C1088mP2 f = new C1088mP2(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public C1088mP2(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static C1088mP2 b() {
        return new C1088mP2(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iS;
        int iT;
        int iS2;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iS3 = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = this.b[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.c[i2]).getClass();
                    iS2 = DH2.s(i4 << 3) + 8;
                } else if (i5 == 2) {
                    int i6 = i4 << 3;
                    C0519dH2 c0519dH2 = (C0519dH2) this.c[i2];
                    int iS4 = DH2.s(i6);
                    int iJ = c0519dH2.j();
                    iS3 = DH2.s(iJ) + iJ + iS4 + iS3;
                } else if (i5 == 3) {
                    int iS5 = DH2.s(i4 << 3);
                    iS = iS5 + iS5;
                    iT = ((C1088mP2) this.c[i2]).a();
                } else {
                    if (i5 != 5) {
                        int i7 = zzdc.t;
                        throw new IllegalStateException(new zzdb("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.c[i2]).getClass();
                    iS2 = DH2.s(i4 << 3) + 4;
                }
                iS3 = iS2 + iS3;
            } else {
                int i8 = i4 << 3;
                long jLongValue = ((Long) this.c[i2]).longValue();
                iS = DH2.s(i8);
                iT = DH2.t(jLongValue);
            }
            iS3 = iT + iS + iS3;
        }
        this.d = iS3;
        return iS3;
    }

    public final void c(int i, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        e(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    public final void d(OH2 oh2) {
        if (this.a != 0) {
            for (int i = 0; i < this.a; i++) {
                int i2 = this.b[i];
                Object obj = this.c[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    oh2.p(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    oh2.l(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    oh2.g(i4, (C0519dH2) obj);
                } else if (i3 == 3) {
                    oh2.a.k(i4, 3);
                    ((C1088mP2) obj).d(oh2);
                    oh2.a.k(i4, 4);
                } else {
                    if (i3 != 5) {
                        int i5 = zzdc.t;
                        throw new RuntimeException(new zzdb("Protocol message tag had invalid wire type."));
                    }
                    oh2.k(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void e(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i2 = this.a;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C1088mP2)) {
            return false;
        }
        C1088mP2 c1088mP2 = (C1088mP2) obj;
        int i = this.a;
        if (i == c1088mP2.a) {
            int[] iArr = this.b;
            int[] iArr2 = c1088mP2.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = c1088mP2.c;
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
        int i2 = i + 527;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.c;
        int i6 = this.a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }
}
