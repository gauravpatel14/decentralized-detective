package defpackage;

import com.google.android.gms.internal.play_billing.zzbw;
import com.google.android.gms.internal.play_billing.zzft;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DH2 extends AbstractC1720xG2 {
    public static final boolean e = SP2.e;
    public OH2 a;
    public final byte[] b;
    public final int c;
    public int d;

    public DH2(int i, byte[] bArr) {
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i)));
        }
        this.b = bArr;
        this.d = 0;
        this.c = i;
    }

    public static int p(int i, AbstractC0948kF2 abstractC0948kF2, InterfaceC0773hO2 interfaceC0773hO2) {
        int iS = s(i << 3);
        return abstractC0948kF2.a(interfaceC0773hO2) + iS + iS;
    }

    public static int q(AbstractC0948kF2 abstractC0948kF2, InterfaceC0773hO2 interfaceC0773hO2) {
        int iA = abstractC0948kF2.a(interfaceC0773hO2);
        return s(iA) + iA;
    }

    public static int r(String str) {
        int length;
        try {
            length = AbstractC0776hQ2.c(str);
        } catch (zzft unused) {
            length = str.getBytes(WK2.a).length;
        }
        return s(length) + length;
    }

    public static int s(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int t(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public final void a(byte b) {
        try {
            byte[] bArr = this.b;
            int i = this.d;
            this.d = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void b(int i, byte[] bArr) throws zzbw {
        try {
            System.arraycopy(bArr, 0, this.b, this.d, i);
            this.d += i;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(i)), e2);
        }
    }

    public final void c(int i, C0519dH2 c0519dH2) {
        m((i << 3) | 2);
        m(c0519dH2.j());
        b(c0519dH2.j(), c0519dH2.u);
    }

    public final void d(int i, int i2) {
        m((i << 3) | 5);
        e(i2);
    }

    public final void e(int i) throws zzbw {
        try {
            byte[] bArr = this.b;
            int i2 = this.d;
            int i3 = i2 + 1;
            this.d = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.d = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.d = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.d = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void f(int i, long j) {
        m((i << 3) | 1);
        g(j);
    }

    public final void g(long j) throws zzbw {
        try {
            byte[] bArr = this.b;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.d = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.d = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.d = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.d = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.d = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.d = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.d = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void h(int i, int i2) {
        m(i << 3);
        i(i2);
    }

    public final void i(int i) throws zzbw {
        if (i >= 0) {
            m(i);
        } else {
            o(i);
        }
    }

    public final void j(int i, String str) {
        m((i << 3) | 2);
        int i2 = this.d;
        try {
            int iS = s(str.length() * 3);
            int iS2 = s(str.length());
            byte[] bArr = this.b;
            int i3 = this.c;
            if (iS2 == iS) {
                int i4 = i2 + iS2;
                this.d = i4;
                int iB = AbstractC0776hQ2.b(str, bArr, i4, i3 - i4);
                this.d = i2;
                m((iB - i2) - iS2);
                this.d = iB;
            } else {
                m(AbstractC0776hQ2.c(str));
                int i5 = this.d;
                this.d = AbstractC0776hQ2.b(str, bArr, i5, i3 - i5);
            }
        } catch (zzft unused) {
            this.d = i2;
            byte[] bytes = str.getBytes(WK2.a);
            try {
                int length = bytes.length;
                m(length);
                b(length, bytes);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzbw(e2);
            }
        } catch (IndexOutOfBoundsException e3) {
            throw new zzbw(e3);
        }
    }

    public final void k(int i, int i2) {
        m((i << 3) | i2);
    }

    public final void l(int i, int i2) {
        m(i << 3);
        m(i2);
    }

    public final void m(int i) {
        while (true) {
            int i2 = i & (-128);
            byte[] bArr = this.b;
            if (i2 == 0) {
                int i3 = this.d;
                this.d = i3 + 1;
                bArr[i3] = (byte) i;
                return;
            } else {
                try {
                    int i4 = this.d;
                    this.d = i4 + 1;
                    bArr[i4] = (byte) ((i | 128) & 255);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
                }
            }
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void n(int i, long j) {
        m(i << 3);
        o(j);
    }

    public final void o(long j) throws zzbw {
        byte[] bArr = this.b;
        boolean z = e;
        int i = this.c;
        if (!z || i - this.d < 10) {
            while ((j & (-128)) != 0) {
                try {
                    int i2 = this.d;
                    this.d = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) | 128) & 255);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(i), 1), e2);
                }
            }
            int i3 = this.d;
            this.d = i3 + 1;
            bArr[i3] = (byte) j;
            return;
        }
        while (true) {
            int i4 = (int) j;
            if ((j & (-128)) == 0) {
                int i5 = this.d;
                this.d = i5 + 1;
                SP2.c.d(bArr, SP2.f + ((long) i5), (byte) i4);
                return;
            }
            int i6 = this.d;
            this.d = i6 + 1;
            SP2.c.d(bArr, SP2.f + i6, (byte) ((i4 | 128) & 255));
            j >>>= 7;
        }
    }
}
