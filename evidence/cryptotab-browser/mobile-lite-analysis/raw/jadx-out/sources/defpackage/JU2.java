package defpackage;

import com.google.android.gms.internal.measurement.zzkm;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class JU2 {
    public static int a(byte[] bArr, int i, HU2 hu2) throws zzkm {
        int iJ = j(bArr, i, hu2);
        int i2 = hu2.a;
        if (i2 < 0) {
            throw zzkm.b();
        }
        if (i2 > bArr.length - iJ) {
            throw zzkm.d();
        }
        if (i2 == 0) {
            hu2.c = WU2.v;
            return iJ;
        }
        hu2.c = WU2.p(bArr, iJ, i2);
        return iJ + i2;
    }

    public static int b(int i, byte[] bArr) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int c(InterfaceC0784hY2 interfaceC0784hY2, byte[] bArr, int i, int i2, int i3, HU2 hu2) {
        UX2 ux2 = (UX2) interfaceC0784hY2;
        Object objA = ux2.a();
        int iY = ux2.y(objA, bArr, i, i2, i3, hu2);
        ux2.b(objA);
        hu2.c = objA;
        return iY;
    }

    public static int d(InterfaceC0784hY2 interfaceC0784hY2, byte[] bArr, int i, int i2, HU2 hu2) throws zzkm {
        int iK = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iK = k(i3, bArr, iK, hu2);
            i3 = hu2.a;
        }
        int i4 = iK;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzkm.d();
        }
        Object objA = interfaceC0784hY2.a();
        int i5 = i3 + i4;
        interfaceC0784hY2.i(objA, bArr, i4, i5, hu2);
        interfaceC0784hY2.b(objA);
        hu2.c = objA;
        return i5;
    }

    public static int e(InterfaceC0784hY2 interfaceC0784hY2, int i, byte[] bArr, int i2, int i3, LW2 lw2, HU2 hu2) throws zzkm {
        int iD = d(interfaceC0784hY2, bArr, i2, i3, hu2);
        lw2.add(hu2.c);
        while (iD < i3) {
            int iJ = j(bArr, iD, hu2);
            if (i != hu2.a) {
                break;
            }
            iD = d(interfaceC0784hY2, bArr, iJ, i3, hu2);
            lw2.add(hu2.c);
        }
        return iD;
    }

    public static int f(byte[] bArr, int i, LW2 lw2, HU2 hu2) throws zzkm {
        BW2 bw2 = (BW2) lw2;
        int iJ = j(bArr, i, hu2);
        int i2 = hu2.a + iJ;
        while (iJ < i2) {
            iJ = j(bArr, iJ, hu2);
            bw2.g(hu2.a);
        }
        if (iJ == i2) {
            return iJ;
        }
        throw zzkm.d();
    }

    public static int g(byte[] bArr, int i, HU2 hu2) throws zzkm {
        int iJ = j(bArr, i, hu2);
        int i2 = hu2.a;
        if (i2 < 0) {
            throw zzkm.b();
        }
        if (i2 == 0) {
            hu2.c = "";
            return iJ;
        }
        hu2.c = new String(bArr, iJ, i2, NW2.a);
        return iJ + i2;
    }

    public static int h(byte[] bArr, int i, HU2 hu2) throws zzkm {
        int iJ = j(bArr, i, hu2);
        int i2 = hu2.a;
        if (i2 < 0) {
            throw zzkm.b();
        }
        if (i2 == 0) {
            hu2.c = "";
            return iJ;
        }
        PY2 py2 = AbstractC0850iZ2.a;
        int length = bArr.length;
        if ((iJ | i2 | ((length - iJ) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iJ), Integer.valueOf(i2)));
        }
        int i3 = iJ + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (iJ < i3) {
            byte b = bArr[iJ];
            if (b < 0) {
                break;
            }
            iJ++;
            cArr[i4] = (char) b;
            i4++;
        }
        while (iJ < i3) {
            int i5 = iJ + 1;
            byte b2 = bArr[iJ];
            if (b2 >= 0) {
                cArr[i4] = (char) b2;
                i4++;
                iJ = i5;
                while (iJ < i3) {
                    byte b3 = bArr[iJ];
                    if (b3 >= 0) {
                        iJ++;
                        cArr[i4] = (char) b3;
                        i4++;
                    }
                }
            } else {
                if (b2 >= -32) {
                    if (b2 < -16) {
                        if (i5 >= i3 - 1) {
                            throw zzkm.a();
                        }
                        int i6 = iJ + 2;
                        iJ += 3;
                        int i7 = i4 + 1;
                        byte b4 = bArr[i5];
                        byte b5 = bArr[i6];
                        if (!OY2.a(b4)) {
                            if (b2 == -32) {
                                if (b4 >= -96) {
                                    b2 = -32;
                                }
                            }
                            if (b2 == -19) {
                                if (b4 < -96) {
                                    b2 = -19;
                                }
                            }
                            if (!OY2.a(b5)) {
                                cArr[i4] = (char) (((b4 & 63) << 6) | ((b2 & 15) << 12) | (b5 & 63));
                                i4 = i7;
                            }
                        }
                        throw zzkm.a();
                    }
                    if (i5 >= i3 - 2) {
                        throw zzkm.a();
                    }
                    int i8 = iJ + 2;
                    int i9 = iJ + 3;
                    iJ += 4;
                    byte b6 = bArr[i5];
                    byte b7 = bArr[i8];
                    byte b8 = bArr[i9];
                    if (!OY2.a(b6)) {
                        if ((((b6 + 112) + (b2 << 28)) >> 30) == 0 && !OY2.a(b7) && !OY2.a(b8)) {
                            int i10 = ((b6 & 63) << 12) | ((b2 & 7) << 18) | ((b7 & 63) << 6) | (b8 & 63);
                            cArr[i4] = (char) ((i10 >>> 10) + 55232);
                            cArr[i4 + 1] = (char) ((i10 & 1023) + 56320);
                            i4 += 2;
                        }
                    }
                    throw zzkm.a();
                }
                if (i5 >= i3) {
                    throw zzkm.a();
                }
                iJ += 2;
                int i11 = i4 + 1;
                byte b9 = bArr[i5];
                if (b2 < -62 || OY2.a(b9)) {
                    throw zzkm.a();
                }
                cArr[i4] = (char) ((b9 & 63) | ((b2 & 31) << 6));
                i4 = i11;
            }
        }
        hu2.c = new String(cArr, 0, i4);
        return i3;
    }

    public static int i(int i, byte[] bArr, int i2, int i3, EY2 ey2, HU2 hu2) throws zzkm {
        if ((i >>> 3) == 0) {
            throw new zzkm("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iM = m(bArr, i2, hu2);
            ey2.c(i, Long.valueOf(hu2.b));
            return iM;
        }
        if (i4 == 1) {
            ey2.c(i, Long.valueOf(n(i2, bArr)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iJ = j(bArr, i2, hu2);
            int i5 = hu2.a;
            if (i5 < 0) {
                throw zzkm.b();
            }
            if (i5 > bArr.length - iJ) {
                throw zzkm.d();
            }
            if (i5 == 0) {
                ey2.c(i, WU2.v);
            } else {
                ey2.c(i, WU2.p(bArr, iJ, i5));
            }
            return iJ + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzkm("Protocol message contained an invalid tag (zero).");
            }
            ey2.c(i, Integer.valueOf(b(i2, bArr)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        EY2 ey2B = EY2.b();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iJ2 = j(bArr, i2, hu2);
            int i8 = hu2.a;
            if (i8 == i6) {
                i7 = i8;
                i2 = iJ2;
                break;
            }
            i7 = i8;
            i2 = i(i8, bArr, iJ2, i3, ey2B, hu2);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzkm.c();
        }
        ey2.c(i, ey2B);
        return i2;
    }

    public static int j(byte[] bArr, int i, HU2 hu2) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return k(b, bArr, i2, hu2);
        }
        hu2.a = b;
        return i2;
    }

    public static int k(int i, byte[] bArr, int i2, HU2 hu2) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            hu2.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            hu2.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            hu2.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            hu2.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                hu2.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int l(int i, byte[] bArr, int i2, int i3, LW2 lw2, HU2 hu2) {
        BW2 bw2 = (BW2) lw2;
        int iJ = j(bArr, i2, hu2);
        bw2.g(hu2.a);
        while (iJ < i3) {
            int iJ2 = j(bArr, iJ, hu2);
            if (i != hu2.a) {
                break;
            }
            iJ = j(bArr, iJ2, hu2);
            bw2.g(hu2.a);
        }
        return iJ;
    }

    public static int m(byte[] bArr, int i, HU2 hu2) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            hu2.b = j;
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
        hu2.b = j2;
        return i3;
    }

    public static long n(int i, byte[] bArr) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
