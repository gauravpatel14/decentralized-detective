package defpackage;

import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzmz;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BV2 extends MU2 {
    public static final boolean e = NY2.e;
    public FV2 a;
    public final byte[] b;
    public final int c;
    public int d;

    public BV2(int i, byte[] bArr) {
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i)));
        }
        this.b = bArr;
        this.d = 0;
        this.c = i;
    }

    public static int a(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int b(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int o(int i, CU2 cu2, InterfaceC0784hY2 interfaceC0784hY2) {
        int iA = a(i << 3);
        int i2 = iA + iA;
        AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) cu2;
        int iC = abstractC1852zW2.zzd;
        if (iC == -1) {
            iC = interfaceC0784hY2.c(cu2);
            abstractC1852zW2.zzd = iC;
        }
        return i2 + iC;
    }

    public static int p(int i) {
        if (i >= 0) {
            return a(i);
        }
        return 10;
    }

    public static int q(String str) {
        int length;
        try {
            length = AbstractC0850iZ2.c(str);
        } catch (zzmz unused) {
            length = str.getBytes(NW2.a).length;
        }
        return a(length) + length;
    }

    public static int r(int i) {
        return a(i << 3);
    }

    public final void c(byte b) {
        try {
            byte[] bArr = this.b;
            int i = this.d;
            this.d = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void d(int i, byte[] bArr) throws zzjh {
        try {
            System.arraycopy(bArr, 0, this.b, this.d, i);
            this.d += i;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(i)), e2);
        }
    }

    public final void e(int i, WU2 wu2) {
        l((i << 3) | 2);
        l(wu2.j());
        d(wu2.j(), wu2.u);
    }

    public final void f(int i, int i2) {
        l((i << 3) | 5);
        g(i2);
    }

    public final void g(int i) throws zzjh {
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
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void h(int i, long j) {
        l((i << 3) | 1);
        i(j);
    }

    public final void i(long j) throws zzjh {
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
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void j(int i, String str) throws zzjh {
        l((i << 3) | 2);
        int i2 = this.d;
        try {
            int iA = a(str.length() * 3);
            int iA2 = a(str.length());
            byte[] bArr = this.b;
            int i3 = this.c;
            if (iA2 == iA) {
                int i4 = i2 + iA2;
                this.d = i4;
                int iB = AbstractC0850iZ2.b(str, bArr, i4, i3 - i4);
                this.d = i2;
                l((iB - i2) - iA2);
                this.d = iB;
            } else {
                l(AbstractC0850iZ2.c(str));
                int i5 = this.d;
                this.d = AbstractC0850iZ2.b(str, bArr, i5, i3 - i5);
            }
        } catch (zzmz unused) {
            this.d = i2;
            byte[] bytes = str.getBytes(NW2.a);
            try {
                int length = bytes.length;
                l(length);
                d(length, bytes);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzjh(e2);
            }
        } catch (IndexOutOfBoundsException e3) {
            throw new zzjh(e3);
        }
    }

    public final void k(int i, int i2) {
        l((i << 3) | i2);
    }

    public final void l(int i) {
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
                    bArr[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
                }
            }
            throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e2);
        }
    }

    public final void m(int i, long j) {
        l(i << 3);
        n(j);
    }

    public final void n(long j) {
        byte[] bArr = this.b;
        boolean z = e;
        int i = this.c;
        if (!z || i - this.d < 10) {
            while ((j & (-128)) != 0) {
                try {
                    int i2 = this.d;
                    this.d = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzjh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(i), 1), e2);
                }
            }
            int i3 = this.d;
            this.d = i3 + 1;
            bArr[i3] = (byte) j;
            return;
        }
        while ((j & (-128)) != 0) {
            int i4 = this.d;
            this.d = i4 + 1;
            NY2.c.d(bArr, NY2.f + ((long) i4), (byte) ((((int) j) & 127) | 128));
            j >>>= 7;
        }
        int i5 = this.d;
        this.d = i5 + 1;
        NY2.c.d(bArr, NY2.f + ((long) i5), (byte) j);
    }
}
