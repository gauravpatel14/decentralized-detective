package defpackage;

import com.google.protobuf.CodedOutputStream$OutOfSpaceException;
import com.google.protobuf.Utf8$UnpairedSurrogateException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AG extends CG {
    public final byte[] c;
    public final int d;
    public int e;

    public AG(int i, byte[] bArr) {
        if (((bArr.length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }
        this.c = bArr;
        this.e = 0;
        this.d = i;
    }

    @Override // defpackage.CG
    public final void A(int i, boolean z) throws CodedOutputStream$OutOfSpaceException {
        O(i, 0);
        z(z ? (byte) 1 : (byte) 0);
    }

    @Override // defpackage.CG
    public final void B(int i, byte[] bArr) throws CodedOutputStream$OutOfSpaceException {
        Q(i);
        U(bArr, 0, i);
    }

    @Override // defpackage.CG
    public final void C(int i, C0199Qv c0199Qv) throws CodedOutputStream$OutOfSpaceException {
        O(i, 2);
        D(c0199Qv);
    }

    @Override // defpackage.CG
    public final void D(C0199Qv c0199Qv) throws CodedOutputStream$OutOfSpaceException {
        Q(c0199Qv.size());
        c0199Qv.w(this);
    }

    @Override // defpackage.CG
    public final void E(int i, int i2) throws CodedOutputStream$OutOfSpaceException {
        O(i, 5);
        F(i2);
    }

    @Override // defpackage.CG
    public final void F(int i) throws CodedOutputStream$OutOfSpaceException {
        try {
            byte[] bArr = this.c;
            int i2 = this.e;
            int i3 = i2 + 1;
            this.e = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.e = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.e = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.e = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
        }
    }

    @Override // defpackage.CG
    public final void G(int i, long j) throws CodedOutputStream$OutOfSpaceException {
        O(i, 1);
        H(j);
    }

    @Override // defpackage.CG
    public final void H(long j) throws CodedOutputStream$OutOfSpaceException {
        try {
            byte[] bArr = this.c;
            int i = this.e;
            int i2 = i + 1;
            this.e = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.e = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.e = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.e = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.e = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.e = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.e = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.e = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
        }
    }

    @Override // defpackage.CG
    public final void I(int i, int i2) throws CodedOutputStream$OutOfSpaceException {
        O(i, 0);
        J(i2);
    }

    @Override // defpackage.CG
    public final void J(int i) throws CodedOutputStream$OutOfSpaceException {
        if (i >= 0) {
            Q(i);
        } else {
            S(i);
        }
    }

    @Override // defpackage.CG
    public final void K(int i, InterfaceC1787yS0 interfaceC1787yS0, Cz1 cz1) throws CodedOutputStream$OutOfSpaceException {
        O(i, 2);
        Q(((A) interfaceC1787yS0).a(cz1));
        cz1.a(interfaceC1787yS0, this.a);
    }

    @Override // defpackage.CG
    public final void L(InterfaceC1787yS0 interfaceC1787yS0) throws CodedOutputStream$OutOfSpaceException {
        AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) interfaceC1787yS0;
        Q(abstractC0003Al0.h());
        abstractC0003Al0.p(this);
    }

    @Override // defpackage.CG
    public final void M(int i, String str) throws CodedOutputStream$OutOfSpaceException {
        O(i, 2);
        N(str);
    }

    @Override // defpackage.CG
    public final void N(String str) throws CodedOutputStream$OutOfSpaceException {
        int i = this.e;
        try {
            int iV = CG.v(str.length() * 3);
            int iV2 = CG.v(str.length());
            byte[] bArr = this.c;
            if (iV2 == iV) {
                int i2 = i + iV2;
                this.e = i2;
                int iG = AbstractC0104Im2.a.g(str, bArr, i2, T());
                this.e = i;
                Q((iG - i) - iV2);
                this.e = iG;
            } else {
                Q(AbstractC0104Im2.b(str));
                this.e = AbstractC0104Im2.a.g(str, bArr, this.e, T());
            }
        } catch (Utf8$UnpairedSurrogateException unused) {
            this.e = i;
            y(str);
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(e);
        }
    }

    @Override // defpackage.CG
    public final void O(int i, int i2) throws CodedOutputStream$OutOfSpaceException {
        Q((i << 3) | i2);
    }

    @Override // defpackage.CG
    public final void P(int i, int i2) throws CodedOutputStream$OutOfSpaceException {
        O(i, 0);
        Q(i2);
    }

    @Override // defpackage.CG
    public final void Q(int i) throws CodedOutputStream$OutOfSpaceException {
        while (true) {
            int i2 = i & (-128);
            byte[] bArr = this.c;
            if (i2 == 0) {
                int i3 = this.e;
                this.e = i3 + 1;
                bArr[i3] = (byte) i;
                return;
            } else {
                try {
                    int i4 = this.e;
                    this.e = i4 + 1;
                    bArr[i4] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                }
            }
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
        }
    }

    @Override // defpackage.CG
    public final void R(int i, long j) throws CodedOutputStream$OutOfSpaceException {
        O(i, 0);
        S(j);
    }

    @Override // defpackage.CG
    public final void S(long j) throws CodedOutputStream$OutOfSpaceException {
        byte[] bArr = this.c;
        if (CG.b && T() >= 10) {
            while ((j & (-128)) != 0) {
                int i = this.e;
                this.e = i + 1;
                AbstractC1633vk2.n(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            int i2 = this.e;
            this.e = i2 + 1;
            AbstractC1633vk2.n(bArr, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                int i3 = this.e;
                this.e = i3 + 1;
                bArr[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }
        int i4 = this.e;
        this.e = i4 + 1;
        bArr[i4] = (byte) j;
    }

    public final int T() {
        return this.d - this.e;
    }

    public final void U(byte[] bArr, int i, int i2) throws CodedOutputStream$OutOfSpaceException {
        try {
            System.arraycopy(bArr, i, this.c, this.e, i2);
            this.e += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i2)), e);
        }
    }

    @Override // defpackage.AbstractC0150Mv
    public final void a(byte[] bArr, int i, int i2) throws CodedOutputStream$OutOfSpaceException {
        U(bArr, i, i2);
    }

    @Override // defpackage.CG
    public final void z(byte b) throws CodedOutputStream$OutOfSpaceException {
        try {
            byte[] bArr = this.c;
            int i = this.e;
            this.e = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
        }
    }
}
