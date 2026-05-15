package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.protobuf.InvalidProtocolBufferException;

/* JADX INFO: renamed from: wG, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1660wG extends yG {
    public final byte[] c;
    public int d;
    public int e;
    public int f;
    public final int g;
    public int h;
    public int i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public C1660wG(byte[] bArr, int i, int i2, boolean z) {
        this.c = bArr;
        this.d = i2 + i;
        this.f = i;
        this.g = i;
    }

    @Override // defpackage.yG
    public final long A() {
        return F();
    }

    @Override // defpackage.yG
    public final boolean B(int i) throws InvalidProtocolBufferException {
        int iY;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            int i4 = this.d - this.f;
            byte[] bArr = this.c;
            if (i4 >= 10) {
                while (i3 < 10) {
                    int i5 = this.f;
                    this.f = i5 + 1;
                    if (bArr[i5] < 0) {
                        i3++;
                    }
                }
                throw InvalidProtocolBufferException.d();
            }
            while (i3 < 10) {
                int i6 = this.f;
                if (i6 == this.d) {
                    throw InvalidProtocolBufferException.j();
                }
                this.f = i6 + 1;
                if (bArr[i6] < 0) {
                    i3++;
                }
            }
            throw InvalidProtocolBufferException.d();
            return true;
        }
        if (i2 == 1) {
            I(8);
            return true;
        }
        if (i2 == 2) {
            I(E());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            I(4);
            return true;
        }
        do {
            iY = y();
            if (iY == 0) {
                break;
            }
        } while (B(iY));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int C() throws InvalidProtocolBufferException {
        int i = this.f;
        if (this.d - i < 4) {
            throw InvalidProtocolBufferException.j();
        }
        this.f = i + 4;
        byte[] bArr = this.c;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long D() throws InvalidProtocolBufferException {
        int i = this.f;
        if (this.d - i < 8) {
            throw InvalidProtocolBufferException.j();
        }
        this.f = i + 8;
        byte[] bArr = this.c;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int E() {
        int i;
        int i2 = this.f;
        int i3 = this.d;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.c;
            byte b = bArr[i2];
            if (b >= 0) {
                this.f = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.f = i5;
                return i;
            }
        }
        return (int) G();
    }

    public final long F() {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.f;
        int i2 = this.d;
        if (i2 != i) {
            int i3 = i + 1;
            byte[] bArr = this.c;
            byte b = bArr[i];
            if (b >= 0) {
                this.f = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            j4 = (-2080896) ^ i9;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                i8 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i8]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i8 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i10 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i10;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j4 = j2 ^ j7;
                            }
                            j = j3 ^ j6;
                        }
                        i4 = i8;
                        j = j4;
                    }
                }
                this.f = i4;
                return j;
            }
        }
        return G();
    }

    public final long G() throws InvalidProtocolBufferException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.f;
            if (i2 == this.d) {
                throw InvalidProtocolBufferException.j();
            }
            this.f = i2 + 1;
            byte b = this.c[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.d();
    }

    public final void H() {
        int i = this.d + this.e;
        this.d = i;
        int i2 = i - this.g;
        int i3 = this.i;
        if (i2 <= i3) {
            this.e = 0;
            return;
        }
        int i4 = i2 - i3;
        this.e = i4;
        this.d = i - i4;
    }

    public final void I(int i) throws InvalidProtocolBufferException {
        if (i >= 0) {
            int i2 = this.d;
            int i3 = this.f;
            if (i <= i2 - i3) {
                this.f = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw InvalidProtocolBufferException.j();
        }
        throw InvalidProtocolBufferException.f();
    }

    @Override // defpackage.yG
    public final void a(int i) throws InvalidProtocolBufferException {
        if (this.h != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // defpackage.yG
    public final int d() {
        return this.f - this.g;
    }

    @Override // defpackage.yG
    public final boolean e() {
        return this.f == this.d;
    }

    @Override // defpackage.yG
    public final void h(int i) {
        this.i = i;
        H();
    }

    @Override // defpackage.yG
    public final int i(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.f();
        }
        int iD = d() + i;
        if (iD < 0) {
            throw InvalidProtocolBufferException.i();
        }
        int i2 = this.i;
        if (iD > i2) {
            throw InvalidProtocolBufferException.j();
        }
        this.i = iD;
        H();
        return i2;
    }

    @Override // defpackage.yG
    public final boolean j() {
        return F() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // defpackage.yG
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.C0199Qv k() throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            r4 = this;
            byte[] r0 = r4.c
            int r1 = r4.E()
            if (r1 <= 0) goto L19
            int r2 = r4.d
            int r3 = r4.f
            int r2 = r2 - r3
            if (r1 > r2) goto L19
            Qv r0 = defpackage.C0199Qv.l(r0, r3, r1)
            int r2 = r4.f
            int r2 = r2 + r1
            r4.f = r2
            return r0
        L19:
            if (r1 != 0) goto L1e
            Qv r0 = defpackage.C0199Qv.v
            return r0
        L1e:
            if (r1 <= 0) goto L2f
            int r2 = r4.d
            int r3 = r4.f
            int r2 = r2 - r3
            if (r1 > r2) goto L2f
            int r1 = r1 + r3
            r4.f = r1
            byte[] r0 = java.util.Arrays.copyOfRange(r0, r3, r1)
            goto L35
        L2f:
            if (r1 > 0) goto L42
            if (r1 != 0) goto L3d
            byte[] r0 = defpackage.gz0.b
        L35:
            Qv r1 = defpackage.C0199Qv.v
            Qv r1 = new Qv
            r1.<init>(r0)
            return r1
        L3d:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.f()
            throw r0
        L42:
            com.google.protobuf.InvalidProtocolBufferException r0 = com.google.protobuf.InvalidProtocolBufferException.j()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1660wG.k():Qv");
    }

    @Override // defpackage.yG
    public final double l() {
        return Double.longBitsToDouble(D());
    }

    @Override // defpackage.yG
    public final int m() {
        return E();
    }

    @Override // defpackage.yG
    public final int n() {
        return C();
    }

    @Override // defpackage.yG
    public final long o() {
        return D();
    }

    @Override // defpackage.yG
    public final float p() {
        return Float.intBitsToFloat(C());
    }

    @Override // defpackage.yG
    public final int q() {
        return E();
    }

    @Override // defpackage.yG
    public final long r() {
        return F();
    }

    @Override // defpackage.yG
    public final int s() {
        return C();
    }

    @Override // defpackage.yG
    public final long t() {
        return D();
    }

    @Override // defpackage.yG
    public final int u() {
        return yG.b(E());
    }

    @Override // defpackage.yG
    public final long v() {
        return yG.c(F());
    }

    @Override // defpackage.yG
    public final String w() throws InvalidProtocolBufferException {
        int iE = E();
        if (iE > 0) {
            int i = this.d;
            int i2 = this.f;
            if (iE <= i - i2) {
                String str = new String(this.c, i2, iE, gz0.a);
                this.f += iE;
                return str;
            }
        }
        if (iE == 0) {
            return "";
        }
        if (iE < 0) {
            throw InvalidProtocolBufferException.f();
        }
        throw InvalidProtocolBufferException.j();
    }

    @Override // defpackage.yG
    public final String x() throws InvalidProtocolBufferException {
        int iE = E();
        if (iE > 0) {
            int i = this.d;
            int i2 = this.f;
            if (iE <= i - i2) {
                String strE = AbstractC0104Im2.a.e(this.c, i2, iE);
                this.f += iE;
                return strE;
            }
        }
        if (iE == 0) {
            return "";
        }
        if (iE <= 0) {
            throw InvalidProtocolBufferException.f();
        }
        throw InvalidProtocolBufferException.j();
    }

    @Override // defpackage.yG
    public final int y() throws InvalidProtocolBufferException {
        if (e()) {
            this.h = 0;
            return 0;
        }
        int iE = E();
        this.h = iE;
        if ((iE >>> 3) != 0) {
            return iE;
        }
        throw InvalidProtocolBufferException.a();
    }

    @Override // defpackage.yG
    public final int z() {
        return E();
    }
}
