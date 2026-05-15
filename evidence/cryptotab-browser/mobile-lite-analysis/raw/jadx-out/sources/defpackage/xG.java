package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.protobuf.InvalidProtocolBufferException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class xG extends yG {
    public final ByteBuffer c;
    public final long d;
    public long e;
    public long f;
    public final long g;
    public int h;
    public int i;
    public int j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public xG(ByteBuffer byteBuffer, boolean z) {
        this.c = byteBuffer;
        long j = AbstractC1633vk2.b.j(AbstractC1633vk2.f, byteBuffer);
        this.d = j;
        this.e = ((long) byteBuffer.limit()) + j;
        long jPosition = j + ((long) byteBuffer.position());
        this.f = jPosition;
        this.g = jPosition;
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
            if (I() >= 10) {
                while (i3 < 10) {
                    long j = this.f;
                    this.f = j + 1;
                    if (AbstractC1633vk2.b.e(j) < 0) {
                        i3++;
                    }
                }
                throw InvalidProtocolBufferException.d();
            }
            while (i3 < 10) {
                long j2 = this.f;
                if (j2 == this.e) {
                    throw InvalidProtocolBufferException.j();
                }
                this.f = j2 + 1;
                if (AbstractC1633vk2.b.e(j2) < 0) {
                    i3++;
                }
            }
            throw InvalidProtocolBufferException.d();
            return true;
        }
        if (i2 == 1) {
            J(8);
            return true;
        }
        if (i2 == 2) {
            J(E());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            J(4);
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
        long j = this.f;
        if (this.e - j < 4) {
            throw InvalidProtocolBufferException.j();
        }
        this.f = 4 + j;
        AbstractC1577uk2 abstractC1577uk2 = AbstractC1633vk2.b;
        return ((abstractC1577uk2.e(j + 3) & 255) << 24) | (abstractC1577uk2.e(j) & 255) | ((abstractC1577uk2.e(1 + j) & 255) << 8) | ((abstractC1577uk2.e(2 + j) & 255) << 16);
    }

    public final long D() throws InvalidProtocolBufferException {
        long j = this.f;
        if (this.e - j < 8) {
            throw InvalidProtocolBufferException.j();
        }
        this.f = 8 + j;
        AbstractC1577uk2 abstractC1577uk2 = AbstractC1633vk2.b;
        return ((((long) abstractC1577uk2.e(j + 7)) & 255) << 56) | (((long) abstractC1577uk2.e(j)) & 255) | ((((long) abstractC1577uk2.e(1 + j)) & 255) << 8) | ((((long) abstractC1577uk2.e(2 + j)) & 255) << 16) | ((((long) abstractC1577uk2.e(3 + j)) & 255) << 24) | ((((long) abstractC1577uk2.e(4 + j)) & 255) << 32) | ((((long) abstractC1577uk2.e(5 + j)) & 255) << 40) | ((((long) abstractC1577uk2.e(6 + j)) & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        if (r4.e(r8) < 0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[PHI: r6
      0x0099: PHI (r6v7 long) = (r6v6 long), (r6v8 long), (r6v10 long) binds: [B:25:0x006d, B:29:0x0080, B:33:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int E() {
        /*
            r12 = this;
            long r0 = r12.f
            long r2 = r12.e
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto La
            goto L93
        La:
            r2 = 1
            long r2 = r2 + r0
            uk2 r4 = defpackage.AbstractC1633vk2.b
            byte r5 = r4.e(r0)
            if (r5 < 0) goto L18
            r12.f = r2
            return r5
        L18:
            long r6 = r12.e
            long r6 = r6 - r2
            r8 = 9
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L23
            goto L93
        L23:
            r6 = 2
            long r6 = r6 + r0
            byte r2 = r4.e(r2)
            int r2 = r2 << 7
            r2 = r2 ^ r5
            if (r2 >= 0) goto L33
            r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
            goto La0
        L33:
            r10 = 3
            long r10 = r10 + r0
            byte r3 = r4.e(r6)
            int r3 = r3 << 14
            r2 = r2 ^ r3
            if (r2 < 0) goto L43
            r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
        L41:
            r6 = r10
            goto La0
        L43:
            r5 = 4
            long r6 = r0 + r5
            byte r3 = r4.e(r10)
            int r3 = r3 << 21
            r2 = r2 ^ r3
            if (r2 >= 0) goto L55
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto La0
        L55:
            r10 = 5
            long r10 = r10 + r0
            byte r3 = r4.e(r6)
            int r5 = r3 << 28
            r2 = r2 ^ r5
            r5 = 266354560(0xfe03f80, float:2.2112565E-29)
            r2 = r2 ^ r5
            if (r3 >= 0) goto L9e
            r5 = 6
            long r6 = r0 + r5
            byte r3 = r4.e(r10)
            if (r3 >= 0) goto L99
            r10 = 7
            long r10 = r10 + r0
            byte r3 = r4.e(r6)
            if (r3 >= 0) goto L9e
            r5 = 8
            long r6 = r0 + r5
            byte r3 = r4.e(r10)
            if (r3 >= 0) goto L99
            long r8 = r8 + r0
            byte r3 = r4.e(r6)
            if (r3 >= 0) goto L9b
            r5 = 10
            long r6 = r0 + r5
            byte r0 = r4.e(r8)
            if (r0 >= 0) goto L99
        L93:
            long r0 = r12.G()
            int r0 = (int) r0
            return r0
        L99:
            r0 = r2
            goto La0
        L9b:
            r0 = r2
            r6 = r8
            goto La0
        L9e:
            r0 = r2
            goto L41
        La0:
            r12.f = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xG.E():int");
    }

    public final long F() {
        long j;
        long j2;
        long j3;
        int i;
        long j4 = this.f;
        if (this.e != j4) {
            long j5 = 1 + j4;
            AbstractC1577uk2 abstractC1577uk2 = AbstractC1633vk2.b;
            byte bE = abstractC1577uk2.e(j4);
            if (bE >= 0) {
                this.f = j5;
                return bE;
            }
            if (this.e - j5 >= 9) {
                long j6 = 2 + j4;
                int iE = (abstractC1577uk2.e(j5) << 7) ^ bE;
                if (iE >= 0) {
                    long j7 = 3 + j4;
                    int iE2 = iE ^ (abstractC1577uk2.e(j6) << 14);
                    if (iE2 >= 0) {
                        j = iE2 ^ 16256;
                    } else {
                        j6 = j4 + 4;
                        int iE3 = iE2 ^ (abstractC1577uk2.e(j7) << 21);
                        if (iE3 < 0) {
                            i = (-2080896) ^ iE3;
                        } else {
                            j7 = 5 + j4;
                            long jE = ((long) iE3) ^ (((long) abstractC1577uk2.e(j6)) << 28);
                            if (jE < 0) {
                                long j8 = 6 + j4;
                                long jE2 = jE ^ (((long) abstractC1577uk2.e(j7)) << 35);
                                if (jE2 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    j7 = 7 + j4;
                                    jE = jE2 ^ (((long) abstractC1577uk2.e(j8)) << 42);
                                    if (jE >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        j8 = 8 + j4;
                                        jE2 = jE ^ (((long) abstractC1577uk2.e(j7)) << 49);
                                        if (jE2 >= 0) {
                                            long j9 = j4 + 9;
                                            long jE3 = (jE2 ^ (((long) abstractC1577uk2.e(j8)) << 56)) ^ 71499008037633920L;
                                            if (jE3 < 0) {
                                                long j10 = j4 + 10;
                                                if (abstractC1577uk2.e(j9) >= 0) {
                                                    j6 = j10;
                                                    j = jE3;
                                                }
                                            } else {
                                                j = jE3;
                                                j6 = j9;
                                            }
                                            this.f = j6;
                                            return j;
                                        }
                                        j2 = -558586000294016L;
                                    }
                                }
                                j = j2 ^ jE2;
                                j6 = j8;
                                this.f = j6;
                                return j;
                            }
                            j3 = 266354560;
                            j = j3 ^ jE;
                        }
                    }
                    j6 = j7;
                    this.f = j6;
                    return j;
                }
                i = iE ^ (-128);
                j = i;
                this.f = j6;
                return j;
            }
        }
        return G();
    }

    public final long G() throws InvalidProtocolBufferException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            long j2 = this.f;
            if (j2 == this.e) {
                throw InvalidProtocolBufferException.j();
            }
            this.f = 1 + j2;
            byte bE = AbstractC1633vk2.b.e(j2);
            j |= ((long) (bE & 127)) << i;
            if ((bE & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.d();
    }

    public final void H() {
        long j = this.e + ((long) this.h);
        this.e = j;
        int i = (int) (j - this.g);
        int i2 = this.j;
        if (i <= i2) {
            this.h = 0;
            return;
        }
        int i3 = i - i2;
        this.h = i3;
        this.e = j - ((long) i3);
    }

    public final int I() {
        return (int) (this.e - this.f);
    }

    public final void J(int i) throws InvalidProtocolBufferException {
        if (i >= 0 && i <= I()) {
            this.f += (long) i;
        } else {
            if (i >= 0) {
                throw InvalidProtocolBufferException.j();
            }
            throw InvalidProtocolBufferException.f();
        }
    }

    @Override // defpackage.yG
    public final void a(int i) throws InvalidProtocolBufferException {
        if (this.i != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // defpackage.yG
    public final int d() {
        return (int) (this.f - this.g);
    }

    @Override // defpackage.yG
    public final boolean e() {
        return this.f == this.e;
    }

    @Override // defpackage.yG
    public final void h(int i) {
        this.j = i;
        H();
    }

    @Override // defpackage.yG
    public final int i(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.f();
        }
        int iD = d() + i;
        int i2 = this.j;
        if (iD > i2) {
            throw InvalidProtocolBufferException.j();
        }
        this.j = iD;
        H();
        return i2;
    }

    @Override // defpackage.yG
    public final boolean j() {
        return F() != 0;
    }

    @Override // defpackage.yG
    public final C0199Qv k() throws InvalidProtocolBufferException {
        int iE = E();
        if (iE <= 0 || iE > I()) {
            if (iE == 0) {
                return C0199Qv.v;
            }
            if (iE < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }
        byte[] bArr = new byte[iE];
        long j = iE;
        AbstractC1633vk2.b.c(this.f, bArr, j);
        this.f += j;
        C0199Qv c0199Qv = C0199Qv.v;
        return new C0199Qv(bArr);
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
        if (iE <= 0 || iE > I()) {
            if (iE == 0) {
                return "";
            }
            if (iE < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }
        byte[] bArr = new byte[iE];
        long j = iE;
        AbstractC1633vk2.b.c(this.f, bArr, j);
        String str = new String(bArr, gz0.a);
        this.f += j;
        return str;
    }

    @Override // defpackage.yG
    public final String x() throws InvalidProtocolBufferException {
        String strF;
        long j;
        long j2;
        int iE = E();
        if (iE <= 0 || iE > I()) {
            if (iE == 0) {
                return "";
            }
            if (iE <= 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.j();
        }
        int i = (int) (this.f - this.d);
        C0093Hm2 c0093Hm2 = AbstractC0104Im2.a;
        c0093Hm2.getClass();
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer.hasArray()) {
            strF = c0093Hm2.e(byteBuffer.array(), byteBuffer.arrayOffset() + i, iE);
        } else if (byteBuffer.isDirect()) {
            switch (c0093Hm2.a) {
                case 0:
                    strF = C0093Hm2.f(byteBuffer, i, iE);
                    break;
                default:
                    if ((i | iE | ((byteBuffer.limit() - i) - iE)) < 0) {
                        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(iE)));
                    }
                    long j3 = AbstractC1633vk2.b.j(AbstractC1633vk2.f, byteBuffer) + ((long) i);
                    long j4 = ((long) iE) + j3;
                    char[] cArr = new char[iE];
                    int i2 = 0;
                    while (true) {
                        j = 1;
                        if (j3 < j4) {
                            byte bE = AbstractC1633vk2.b.e(j3);
                            if (C0093Hm2.b(bE)) {
                                j3++;
                                cArr[i2] = (char) bE;
                                i2++;
                            }
                        }
                    }
                    int i3 = i2;
                    while (j3 < j4) {
                        long j5 = j3 + j;
                        AbstractC1577uk2 abstractC1577uk2 = AbstractC1633vk2.b;
                        byte bE2 = abstractC1577uk2.e(j3);
                        if (C0093Hm2.b(bE2)) {
                            int i4 = i3 + 1;
                            cArr[i3] = (char) bE2;
                            while (j5 < j4) {
                                byte bE3 = AbstractC1633vk2.b.e(j5);
                                if (C0093Hm2.b(bE3)) {
                                    j5 += j;
                                    cArr[i4] = (char) bE3;
                                    i4++;
                                } else {
                                    i3 = i4;
                                    j2 = j4;
                                    j3 = j5;
                                }
                            }
                            i3 = i4;
                            j2 = j4;
                            j3 = j5;
                        } else {
                            if (!(bE2 < -32)) {
                                if (bE2 < -16) {
                                    if (j5 >= j4 - j) {
                                        throw InvalidProtocolBufferException.b();
                                    }
                                    long j6 = j3 + 2;
                                    j3 += 3;
                                    C0093Hm2.d(bE2, abstractC1577uk2.e(j5), abstractC1577uk2.e(j6), cArr, i3);
                                    j2 = j4;
                                    i3++;
                                } else {
                                    if (j5 >= j4 - 2) {
                                        throw InvalidProtocolBufferException.b();
                                    }
                                    byte bE4 = abstractC1577uk2.e(j5);
                                    j2 = j4;
                                    long j7 = j3 + 3;
                                    byte bE5 = abstractC1577uk2.e(j3 + 2);
                                    j3 += 4;
                                    C0093Hm2.a(bE2, bE4, bE5, abstractC1577uk2.e(j7), cArr, i3);
                                    i3 += 2;
                                }
                            } else {
                                if (j5 >= j4) {
                                    throw InvalidProtocolBufferException.b();
                                }
                                j3 += 2;
                                C0093Hm2.c(bE2, abstractC1577uk2.e(j5), cArr, i3);
                                j2 = j4;
                                i3++;
                            }
                        }
                        j4 = j2;
                        j = 1;
                    }
                    strF = new String(cArr, 0, i3);
                    break;
                    break;
            }
        } else {
            strF = C0093Hm2.f(byteBuffer, i, iE);
        }
        this.f += (long) iE;
        return strF;
    }

    @Override // defpackage.yG
    public final int y() throws InvalidProtocolBufferException {
        if (e()) {
            this.i = 0;
            return 0;
        }
        int iE = E();
        this.i = iE;
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
