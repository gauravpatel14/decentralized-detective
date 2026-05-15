package defpackage;

import com.google.android.gms.internal.play_billing.zzdc;

/* JADX INFO: renamed from: lG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1013lG2 {
    public static int a(byte[] bArr, int i, C0628fG2 c0628fG2) throws zzdc {
        int iG = g(bArr, i, c0628fG2);
        int i2 = c0628fG2.a;
        if (i2 < 0) {
            throw zzdc.b();
        }
        if (i2 > bArr.length - iG) {
            throw zzdc.d();
        }
        if (i2 == 0) {
            c0628fG2.c = C0519dH2.v;
            return iG;
        }
        c0628fG2.c = C0519dH2.p(bArr, iG, i2);
        return iG + i2;
    }

    public static int b(int i, byte[] bArr) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int c(InterfaceC0773hO2 interfaceC0773hO2, byte[] bArr, int i, int i2, int i3, C0628fG2 c0628fG2) throws zzdc {
        LJ2 lj2A = interfaceC0773hO2.a();
        int iK = k(lj2A, interfaceC0773hO2, bArr, i, i2, i3, c0628fG2);
        interfaceC0773hO2.b(lj2A);
        c0628fG2.c = lj2A;
        return iK;
    }

    public static int d(InterfaceC0773hO2 interfaceC0773hO2, int i, byte[] bArr, int i2, int i3, InterfaceC1606vK2 interfaceC1606vK2, C0628fG2 c0628fG2) throws zzdc {
        LJ2 lj2A = interfaceC0773hO2.a();
        int iL = l(lj2A, interfaceC0773hO2, bArr, i2, i3, c0628fG2);
        interfaceC0773hO2.b(lj2A);
        c0628fG2.c = lj2A;
        interfaceC1606vK2.add(lj2A);
        while (iL < i3) {
            int iG = g(bArr, iL, c0628fG2);
            if (i != c0628fG2.a) {
                break;
            }
            LJ2 lj2A2 = interfaceC0773hO2.a();
            int iL2 = l(lj2A2, interfaceC0773hO2, bArr, iG, i3, c0628fG2);
            interfaceC0773hO2.b(lj2A2);
            c0628fG2.c = lj2A2;
            interfaceC1606vK2.add(lj2A2);
            iL = iL2;
        }
        return iL;
    }

    public static int e(byte[] bArr, int i, InterfaceC1606vK2 interfaceC1606vK2, C0628fG2 c0628fG2) throws zzdc {
        QJ2 qj2 = (QJ2) interfaceC1606vK2;
        int iG = g(bArr, i, c0628fG2);
        int i2 = c0628fG2.a + iG;
        while (iG < i2) {
            iG = g(bArr, iG, c0628fG2);
            qj2.h(c0628fG2.a);
        }
        if (iG == i2) {
            return iG;
        }
        throw zzdc.d();
    }

    public static int f(int i, byte[] bArr, int i2, int i3, C1088mP2 c1088mP2, C0628fG2 c0628fG2) throws zzdc {
        if ((i >>> 3) == 0) {
            throw new zzdc("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iJ = j(bArr, i2, c0628fG2);
            c1088mP2.c(i, Long.valueOf(c0628fG2.b));
            return iJ;
        }
        if (i4 == 1) {
            c1088mP2.c(i, Long.valueOf(m(i2, bArr)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iG = g(bArr, i2, c0628fG2);
            int i5 = c0628fG2.a;
            if (i5 < 0) {
                throw zzdc.b();
            }
            if (i5 > bArr.length - iG) {
                throw zzdc.d();
            }
            if (i5 == 0) {
                c1088mP2.c(i, C0519dH2.v);
            } else {
                c1088mP2.c(i, C0519dH2.p(bArr, iG, i5));
            }
            return iG + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzdc("Protocol message contained an invalid tag (zero).");
            }
            c1088mP2.c(i, Integer.valueOf(b(i2, bArr)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        C1088mP2 c1088mP2B = C1088mP2.b();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iG2 = g(bArr, i2, c0628fG2);
            int i8 = c0628fG2.a;
            i7 = i8;
            if (i8 == i6) {
                i2 = iG2;
                break;
            }
            int iF = f(i7, bArr, iG2, i3, c1088mP2B, c0628fG2);
            i7 = i8;
            i2 = iF;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzdc.c();
        }
        c1088mP2.c(i, c1088mP2B);
        return i2;
    }

    public static int g(byte[] bArr, int i, C0628fG2 c0628fG2) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return h(b, bArr, i2, c0628fG2);
        }
        c0628fG2.a = b;
        return i2;
    }

    public static int h(int i, byte[] bArr, int i2, C0628fG2 c0628fG2) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            c0628fG2.a = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            c0628fG2.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            c0628fG2.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            c0628fG2.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c0628fG2.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int i(int i, byte[] bArr, int i2, int i3, InterfaceC1606vK2 interfaceC1606vK2, C0628fG2 c0628fG2) {
        QJ2 qj2 = (QJ2) interfaceC1606vK2;
        int iG = g(bArr, i2, c0628fG2);
        qj2.h(c0628fG2.a);
        while (iG < i3) {
            int iG2 = g(bArr, iG, c0628fG2);
            if (i != c0628fG2.a) {
                break;
            }
            iG = g(bArr, iG2, c0628fG2);
            qj2.h(c0628fG2.a);
        }
        return iG;
    }

    public static int j(byte[] bArr, int i, C0628fG2 c0628fG2) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            c0628fG2.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        c0628fG2.b = j2;
        return i3;
    }

    public static int k(Object obj, InterfaceC0773hO2 interfaceC0773hO2, byte[] bArr, int i, int i2, int i3, C0628fG2 c0628fG2) throws zzdc {
        int iT = ((GN2) interfaceC0773hO2).t(obj, bArr, i, i2, i3, c0628fG2);
        c0628fG2.c = obj;
        return iT;
    }

    public static int l(Object obj, InterfaceC0773hO2 interfaceC0773hO2, byte[] bArr, int i, int i2, C0628fG2 c0628fG2) throws zzdc {
        int iH = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iH = h(i3, bArr, iH, c0628fG2);
            i3 = c0628fG2.a;
        }
        int i4 = iH;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzdc.d();
        }
        int i5 = i3 + i4;
        interfaceC0773hO2.j(obj, bArr, i4, i5, c0628fG2);
        c0628fG2.c = obj;
        return i5;
    }

    public static long m(int i, byte[] bArr) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
