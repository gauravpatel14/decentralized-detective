package defpackage;

import com.google.protobuf.InvalidProtocolBufferException;

/* JADX INFO: renamed from: Xe, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0282Xe {
    public static int A(byte[] bArr, int i, We we) throws InvalidProtocolBufferException {
        int iG = G(bArr, i, we);
        int i2 = we.a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.f();
        }
        if (i2 == 0) {
            we.c = "";
            return iG;
        }
        we.c = new String(bArr, iG, i2, gz0.a);
        return iG + i2;
    }

    public static int B(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        int iG = G(bArr, i2, we);
        int i4 = we.a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.f();
        }
        if (i4 == 0) {
            fz0Var.add("");
        } else {
            fz0Var.add(new String(bArr, iG, i4, gz0.a));
            iG += i4;
        }
        while (iG < i3) {
            int iG2 = G(bArr, iG, we);
            if (i != we.a) {
                break;
            }
            iG = G(bArr, iG2, we);
            int i5 = we.a;
            if (i5 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            if (i5 == 0) {
                fz0Var.add("");
            } else {
                fz0Var.add(new String(bArr, iG, i5, gz0.a));
                iG += i5;
            }
        }
        return iG;
    }

    public static int C(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        int iG = G(bArr, i2, we);
        int i4 = we.a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.f();
        }
        if (i4 == 0) {
            fz0Var.add("");
        } else {
            int i5 = iG + i4;
            if (!AbstractC0104Im2.a.i(bArr, iG, i5)) {
                throw InvalidProtocolBufferException.b();
            }
            fz0Var.add(new String(bArr, iG, i4, gz0.a));
            iG = i5;
        }
        while (iG < i3) {
            int iG2 = G(bArr, iG, we);
            if (i != we.a) {
                break;
            }
            iG = G(bArr, iG2, we);
            int i6 = we.a;
            if (i6 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            if (i6 == 0) {
                fz0Var.add("");
            } else {
                int i7 = iG + i6;
                if (!AbstractC0104Im2.a.i(bArr, iG, i7)) {
                    throw InvalidProtocolBufferException.b();
                }
                fz0Var.add(new String(bArr, iG, i6, gz0.a));
                iG = i7;
            }
        }
        return iG;
    }

    public static int D(byte[] bArr, int i, We we) throws InvalidProtocolBufferException {
        int iG = G(bArr, i, we);
        int i2 = we.a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.f();
        }
        if (i2 == 0) {
            we.c = "";
            return iG;
        }
        we.c = AbstractC0104Im2.a.e(bArr, iG, i2);
        return iG + i2;
    }

    public static int E(int i, byte[] bArr, int i2, int i3, Zj2 zj2, We we) {
        if ((i >>> 3) == 0) {
            throw InvalidProtocolBufferException.a();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int I = I(bArr, i2, we);
            zj2.c(i, Long.valueOf(we.b));
            return I;
        }
        if (i4 == 1) {
            zj2.c(i, Long.valueOf(h(i2, bArr)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iG = G(bArr, i2, we);
            int i5 = we.a;
            if (i5 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            if (i5 > bArr.length - iG) {
                throw InvalidProtocolBufferException.j();
            }
            if (i5 == 0) {
                zj2.c(i, C0199Qv.v);
            } else {
                zj2.c(i, C0199Qv.l(bArr, iG, i5));
            }
            return iG + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw InvalidProtocolBufferException.a();
            }
            zj2.c(i, Integer.valueOf(f(i2, bArr)));
            return i2 + 4;
        }
        Zj2 zj2B = Zj2.b();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iG2 = G(bArr, i2, we);
            int i8 = we.a;
            if (i8 == i6) {
                i7 = i8;
                i2 = iG2;
                break;
            }
            i7 = i8;
            i2 = E(i8, bArr, iG2, i3, zj2B, we);
        }
        if (i2 > i3 || i7 != i6) {
            throw InvalidProtocolBufferException.i();
        }
        zj2.c(i, zj2B);
        return i2;
    }

    public static int F(int i, byte[] bArr, int i2, We we) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            we.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            we.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            we.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            we.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                we.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int G(byte[] bArr, int i, We we) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return F(b, bArr, i2, we);
        }
        we.a = b;
        return i2;
    }

    public static int H(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        C1118my0 c1118my0 = (C1118my0) fz0Var;
        int iG = G(bArr, i2, we);
        c1118my0.g(we.a);
        while (iG < i3) {
            int iG2 = G(bArr, iG, we);
            if (i != we.a) {
                break;
            }
            iG = G(bArr, iG2, we);
            c1118my0.g(we.a);
        }
        return iG;
    }

    public static int I(byte[] bArr, int i, We we) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            we.b = j;
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
        we.b = j2;
        return i3;
    }

    public static int J(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) fz0Var;
        int I = I(bArr, i2, we);
        abstractC1077mJ0.g(we.b);
        while (I < i3) {
            int iG = G(bArr, I, we);
            if (i != we.a) {
                break;
            }
            I = I(bArr, iG, we);
            abstractC1077mJ0.g(we.b);
        }
        return I;
    }

    public static int K(int i, byte[] bArr, int i2, int i3, We we) {
        if ((i >>> 3) == 0) {
            throw InvalidProtocolBufferException.a();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return I(bArr, i2, we);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return G(bArr, i2, we) + we.a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw InvalidProtocolBufferException.a();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = G(bArr, i2, we);
            i6 = we.a;
            if (i6 == i5) {
                break;
            }
            i2 = K(i6, bArr, i2, i3, we);
        }
        if (i2 > i3 || i6 != i5) {
            throw InvalidProtocolBufferException.i();
        }
        return i2;
    }

    public static int a(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        AbstractC0164Nt abstractC0164Nt = (AbstractC0164Nt) fz0Var;
        int I = I(bArr, i2, we);
        abstractC0164Nt.g(we.b != 0);
        while (I < i3) {
            int iG = G(bArr, I, we);
            if (i != we.a) {
                break;
            }
            I = I(bArr, iG, we);
            abstractC0164Nt.g(we.b != 0);
        }
        return I;
    }

    public static int b(byte[] bArr, int i, We we) {
        int iG = G(bArr, i, we);
        int i2 = we.a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.f();
        }
        if (i2 > bArr.length - iG) {
            throw InvalidProtocolBufferException.j();
        }
        if (i2 == 0) {
            we.c = C0199Qv.v;
            return iG;
        }
        we.c = C0199Qv.l(bArr, iG, i2);
        return iG + i2;
    }

    public static int c(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        int iG = G(bArr, i2, we);
        int i4 = we.a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.f();
        }
        if (i4 > bArr.length - iG) {
            throw InvalidProtocolBufferException.j();
        }
        if (i4 == 0) {
            fz0Var.add(C0199Qv.v);
        } else {
            fz0Var.add(C0199Qv.l(bArr, iG, i4));
            iG += i4;
        }
        while (iG < i3) {
            int iG2 = G(bArr, iG, we);
            if (i != we.a) {
                break;
            }
            iG = G(bArr, iG2, we);
            int i5 = we.a;
            if (i5 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            if (i5 > bArr.length - iG) {
                throw InvalidProtocolBufferException.j();
            }
            if (i5 == 0) {
                fz0Var.add(C0199Qv.v);
            } else {
                fz0Var.add(C0199Qv.l(bArr, iG, i5));
                iG += i5;
            }
        }
        return iG;
    }

    public static double d(int i, byte[] bArr) {
        return Double.longBitsToDouble(h(i, bArr));
    }

    public static int e(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        AbstractC0876j10 abstractC0876j10 = (AbstractC0876j10) fz0Var;
        abstractC0876j10.g(d(i2, bArr));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int iG = G(bArr, i4, we);
            if (i != we.a) {
                break;
            }
            abstractC0876j10.g(Double.longBitsToDouble(h(iG, bArr)));
            i4 = iG + 8;
        }
        return i4;
    }

    public static int f(int i, byte[] bArr) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int g(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        C1118my0 c1118my0 = (C1118my0) fz0Var;
        c1118my0.g(f(i2, bArr));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int iG = G(bArr, i4, we);
            if (i != we.a) {
                break;
            }
            c1118my0.g(f(iG, bArr));
            i4 = iG + 4;
        }
        return i4;
    }

    public static long h(int i, byte[] bArr) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int i(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) fz0Var;
        abstractC1077mJ0.g(h(i2, bArr));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int iG = G(bArr, i4, we);
            if (i != we.a) {
                break;
            }
            abstractC1077mJ0.g(h(iG, bArr));
            i4 = iG + 8;
        }
        return i4;
    }

    public static float j(int i, byte[] bArr) {
        return Float.intBitsToFloat(f(i, bArr));
    }

    public static int k(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        C1746xg0 c1746xg0 = (C1746xg0) fz0Var;
        c1746xg0.g(j(i2, bArr));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int iG = G(bArr, i4, we);
            if (i != we.a) {
                break;
            }
            c1746xg0.g(Float.intBitsToFloat(f(iG, bArr)));
            i4 = iG + 4;
        }
        return i4;
    }

    public static int l(Cz1 cz1, byte[] bArr, int i, int i2, int i3, We we) {
        MS0 ms0 = (MS0) cz1;
        Object objJ = ms0.j();
        int iH = ms0.H(objJ, bArr, i, i2, i3, we);
        ms0.d(objJ);
        we.c = objJ;
        return iH;
    }

    public static int m(Cz1 cz1, int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        int i4 = (i & (-8)) | 4;
        int iL = l(cz1, bArr, i2, i3, i4, we);
        fz0Var.add(we.c);
        while (iL < i3) {
            int iG = G(bArr, iL, we);
            if (i != we.a) {
                break;
            }
            iL = l(cz1, bArr, iG, i3, i4, we);
            fz0Var.add(we.c);
        }
        return iL;
    }

    public static int n(Cz1 cz1, byte[] bArr, int i, int i2, We we) {
        int iF = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iF = F(i3, bArr, iF, we);
            i3 = we.a;
        }
        int i4 = iF;
        if (i3 < 0 || i3 > i2 - i4) {
            throw InvalidProtocolBufferException.j();
        }
        Object objJ = cz1.j();
        int i5 = i3 + i4;
        cz1.g(objJ, bArr, i4, i5, we);
        cz1.d(objJ);
        we.c = objJ;
        return i5;
    }

    public static int o(Cz1 cz1, int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        int iN = n(cz1, bArr, i2, i3, we);
        fz0Var.add(we.c);
        while (iN < i3) {
            int iG = G(bArr, iN, we);
            if (i != we.a) {
                break;
            }
            iN = n(cz1, bArr, iG, i3, we);
            fz0Var.add(we.c);
        }
        return iN;
    }

    public static int p(byte[] bArr, int i, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        AbstractC0164Nt abstractC0164Nt = (AbstractC0164Nt) fz0Var;
        int iG = G(bArr, i, we);
        int i2 = we.a + iG;
        while (iG < i2) {
            iG = I(bArr, iG, we);
            abstractC0164Nt.g(we.b != 0);
        }
        if (iG == i2) {
            return iG;
        }
        throw InvalidProtocolBufferException.j();
    }

    public static int q(byte[] bArr, int i, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        AbstractC0876j10 abstractC0876j10 = (AbstractC0876j10) fz0Var;
        int iG = G(bArr, i, we);
        int i2 = we.a + iG;
        while (iG < i2) {
            abstractC0876j10.g(Double.longBitsToDouble(h(iG, bArr)));
            iG += 8;
        }
        if (iG == i2) {
            return iG;
        }
        throw InvalidProtocolBufferException.j();
    }

    public static int r(byte[] bArr, int i, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        C1118my0 c1118my0 = (C1118my0) fz0Var;
        int iG = G(bArr, i, we);
        int i2 = we.a + iG;
        while (iG < i2) {
            c1118my0.g(f(iG, bArr));
            iG += 4;
        }
        if (iG == i2) {
            return iG;
        }
        throw InvalidProtocolBufferException.j();
    }

    public static int s(byte[] bArr, int i, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) fz0Var;
        int iG = G(bArr, i, we);
        int i2 = we.a + iG;
        while (iG < i2) {
            abstractC1077mJ0.g(h(iG, bArr));
            iG += 8;
        }
        if (iG == i2) {
            return iG;
        }
        throw InvalidProtocolBufferException.j();
    }

    public static int t(byte[] bArr, int i, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        C1746xg0 c1746xg0 = (C1746xg0) fz0Var;
        int iG = G(bArr, i, we);
        int i2 = we.a + iG;
        while (iG < i2) {
            c1746xg0.g(Float.intBitsToFloat(f(iG, bArr)));
            iG += 4;
        }
        if (iG == i2) {
            return iG;
        }
        throw InvalidProtocolBufferException.j();
    }

    public static int u(byte[] bArr, int i, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        C1118my0 c1118my0 = (C1118my0) fz0Var;
        int iG = G(bArr, i, we);
        int i2 = we.a + iG;
        while (iG < i2) {
            iG = G(bArr, iG, we);
            c1118my0.g(yG.b(we.a));
        }
        if (iG == i2) {
            return iG;
        }
        throw InvalidProtocolBufferException.j();
    }

    public static int v(byte[] bArr, int i, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) fz0Var;
        int iG = G(bArr, i, we);
        int i2 = we.a + iG;
        while (iG < i2) {
            iG = I(bArr, iG, we);
            abstractC1077mJ0.g(yG.c(we.b));
        }
        if (iG == i2) {
            return iG;
        }
        throw InvalidProtocolBufferException.j();
    }

    public static int w(byte[] bArr, int i, fz0 fz0Var, We we) {
        C1118my0 c1118my0 = (C1118my0) fz0Var;
        int iG = G(bArr, i, we);
        int i2 = we.a + iG;
        while (iG < i2) {
            iG = G(bArr, iG, we);
            c1118my0.g(we.a);
        }
        if (iG == i2) {
            return iG;
        }
        throw InvalidProtocolBufferException.j();
    }

    public static int x(byte[] bArr, int i, fz0 fz0Var, We we) throws InvalidProtocolBufferException {
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) fz0Var;
        int iG = G(bArr, i, we);
        int i2 = we.a + iG;
        while (iG < i2) {
            iG = I(bArr, iG, we);
            abstractC1077mJ0.g(we.b);
        }
        if (iG == i2) {
            return iG;
        }
        throw InvalidProtocolBufferException.j();
    }

    public static int y(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        C1118my0 c1118my0 = (C1118my0) fz0Var;
        int iG = G(bArr, i2, we);
        c1118my0.g(yG.b(we.a));
        while (iG < i3) {
            int iG2 = G(bArr, iG, we);
            if (i != we.a) {
                break;
            }
            iG = G(bArr, iG2, we);
            c1118my0.g(yG.b(we.a));
        }
        return iG;
    }

    public static int z(int i, byte[] bArr, int i2, int i3, fz0 fz0Var, We we) {
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) fz0Var;
        int I = I(bArr, i2, we);
        abstractC1077mJ0.g(yG.c(we.b));
        while (I < i3) {
            int iG = G(bArr, I, we);
            if (i != we.a) {
                break;
            }
            I = I(bArr, iG, we);
            abstractC1077mJ0.g(yG.c(we.b));
        }
        return I;
    }
}
