package defpackage;

import com.google.protobuf.CodedOutputStream$OutOfSpaceException;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BG extends CG {
    public final byte[] c;
    public final int d;
    public int e;
    public final FileOutputStream f;

    public BG(FileOutputStream fileOutputStream, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i, 20);
        this.c = new byte[iMax];
        this.d = iMax;
        this.f = fileOutputStream;
    }

    @Override // defpackage.CG
    public final void A(int i, boolean z) throws IOException {
        Z(11);
        V(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        int i2 = this.e;
        this.e = i2 + 1;
        this.c[i2] = b;
    }

    @Override // defpackage.CG
    public final void B(int i, byte[] bArr) throws IOException {
        Q(i);
        a0(bArr, 0, i);
    }

    @Override // defpackage.CG
    public final void C(int i, C0199Qv c0199Qv) throws IOException {
        O(i, 2);
        D(c0199Qv);
    }

    @Override // defpackage.CG
    public final void D(C0199Qv c0199Qv) throws IOException {
        Q(c0199Qv.size());
        c0199Qv.w(this);
    }

    @Override // defpackage.CG
    public final void E(int i, int i2) throws IOException {
        Z(14);
        V(i, 5);
        T(i2);
    }

    @Override // defpackage.CG
    public final void F(int i) throws IOException {
        Z(4);
        T(i);
    }

    @Override // defpackage.CG
    public final void G(int i, long j) throws IOException {
        Z(18);
        V(i, 1);
        U(j);
    }

    @Override // defpackage.CG
    public final void H(long j) throws IOException {
        Z(8);
        U(j);
    }

    @Override // defpackage.CG
    public final void I(int i, int i2) throws IOException {
        Z(20);
        V(i, 0);
        if (i2 >= 0) {
            W(i2);
        } else {
            X(i2);
        }
    }

    @Override // defpackage.CG
    public final void J(int i) throws IOException {
        if (i >= 0) {
            Q(i);
        } else {
            S(i);
        }
    }

    @Override // defpackage.CG
    public final void K(int i, InterfaceC1787yS0 interfaceC1787yS0, Cz1 cz1) throws IOException {
        O(i, 2);
        Q(((A) interfaceC1787yS0).a(cz1));
        cz1.a(interfaceC1787yS0, this.a);
    }

    @Override // defpackage.CG
    public final void L(InterfaceC1787yS0 interfaceC1787yS0) throws IOException {
        AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) interfaceC1787yS0;
        Q(abstractC0003Al0.h());
        abstractC0003Al0.p(this);
    }

    @Override // defpackage.CG
    public final void M(int i, String str) throws IOException {
        O(i, 2);
        N(str);
    }

    @Override // defpackage.CG
    public final void N(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iV = CG.v(length);
            int i = iV + length;
            int i2 = this.d;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iG = AbstractC0104Im2.a.g(str, bArr, 0, length);
                Q(iG);
                a0(bArr, 0, iG);
                return;
            }
            if (i > i2 - this.e) {
                Y();
            }
            int iV2 = CG.v(str.length());
            int i3 = this.e;
            byte[] bArr2 = this.c;
            try {
                if (iV2 == iV) {
                    int i4 = i3 + iV2;
                    this.e = i4;
                    int iG2 = AbstractC0104Im2.a.g(str, bArr2, i4, i2 - i4);
                    this.e = i3;
                    W((iG2 - i3) - iV2);
                    this.e = iG2;
                } else {
                    int iB = AbstractC0104Im2.b(str);
                    W(iB);
                    this.e = AbstractC0104Im2.a.g(str, bArr2, this.e, iB);
                }
            } catch (Utf8$UnpairedSurrogateException e) {
                this.e = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new CodedOutputStream$OutOfSpaceException(e2);
            }
        } catch (Utf8$UnpairedSurrogateException unused) {
            y(str);
        }
    }

    @Override // defpackage.CG
    public final void O(int i, int i2) throws IOException {
        Q((i << 3) | i2);
    }

    @Override // defpackage.CG
    public final void P(int i, int i2) throws IOException {
        Z(20);
        V(i, 0);
        W(i2);
    }

    @Override // defpackage.CG
    public final void Q(int i) throws IOException {
        Z(5);
        W(i);
    }

    @Override // defpackage.CG
    public final void R(int i, long j) throws IOException {
        Z(20);
        V(i, 0);
        X(j);
    }

    @Override // defpackage.CG
    public final void S(long j) throws IOException {
        Z(10);
        X(j);
    }

    public final void T(int i) {
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        byte[] bArr = this.c;
        bArr[i2] = (byte) (i & 255);
        int i4 = i2 + 2;
        this.e = i4;
        bArr[i3] = (byte) ((i >> 8) & 255);
        int i5 = i2 + 3;
        this.e = i5;
        bArr[i4] = (byte) ((i >> 16) & 255);
        this.e = i2 + 4;
        bArr[i5] = (byte) ((i >> 24) & 255);
    }

    public final void U(long j) {
        int i = this.e;
        int i2 = i + 1;
        this.e = i2;
        byte[] bArr = this.c;
        bArr[i] = (byte) (j & 255);
        int i3 = i + 2;
        this.e = i3;
        bArr[i2] = (byte) ((j >> 8) & 255);
        int i4 = i + 3;
        this.e = i4;
        bArr[i3] = (byte) ((j >> 16) & 255);
        int i5 = i + 4;
        this.e = i5;
        bArr[i4] = (byte) (255 & (j >> 24));
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
    }

    public final void V(int i, int i2) {
        W((i << 3) | i2);
    }

    public final void W(int i) {
        boolean z = CG.b;
        byte[] bArr = this.c;
        if (z) {
            while ((i & (-128)) != 0) {
                int i2 = this.e;
                this.e = i2 + 1;
                AbstractC1633vk2.n(bArr, i2, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            int i3 = this.e;
            this.e = i3 + 1;
            AbstractC1633vk2.n(bArr, i3, (byte) i);
            return;
        }
        while ((i & (-128)) != 0) {
            int i4 = this.e;
            this.e = i4 + 1;
            bArr[i4] = (byte) ((i & 127) | 128);
            i >>>= 7;
        }
        int i5 = this.e;
        this.e = i5 + 1;
        bArr[i5] = (byte) i;
    }

    public final void X(long j) {
        boolean z = CG.b;
        byte[] bArr = this.c;
        if (z) {
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
            int i3 = this.e;
            this.e = i3 + 1;
            bArr[i3] = (byte) ((((int) j) & 127) | 128);
            j >>>= 7;
        }
        int i4 = this.e;
        this.e = i4 + 1;
        bArr[i4] = (byte) j;
    }

    public final void Y() throws IOException {
        this.f.write(this.c, 0, this.e);
        this.e = 0;
    }

    public final void Z(int i) throws IOException {
        if (this.d - this.e < i) {
            Y();
        }
    }

    @Override // defpackage.AbstractC0150Mv
    public final void a(byte[] bArr, int i, int i2) throws IOException {
        a0(bArr, i, i2);
    }

    public final void a0(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.e;
        int i4 = this.d;
        int i5 = i4 - i3;
        byte[] bArr2 = this.c;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.e += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i3, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.e = i4;
        Y();
        if (i7 > i4) {
            this.f.write(bArr, i6, i7);
        } else {
            System.arraycopy(bArr, i6, bArr2, 0, i7);
            this.e = i7;
        }
    }

    @Override // defpackage.CG
    public final void z(byte b) throws IOException {
        if (this.e == this.d) {
            Y();
        }
        int i = this.e;
        this.e = i + 1;
        this.c[i] = b;
    }
}
