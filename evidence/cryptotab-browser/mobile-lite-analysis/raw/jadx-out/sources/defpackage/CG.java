package defpackage;

import com.google.protobuf.CodedOutputStream$OutOfSpaceException;
import com.google.protobuf.Utf8$UnpairedSurrogateException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CG extends AbstractC0150Mv {
    public static final boolean b = AbstractC1633vk2.d;
    public DG a;

    public static int b(int i) {
        return t(i) + 1;
    }

    public static int c(int i, C0199Qv c0199Qv) {
        return d(c0199Qv) + t(i);
    }

    public static int d(C0199Qv c0199Qv) {
        int size = c0199Qv.size();
        return v(size) + size;
    }

    public static int e(int i) {
        return t(i) + 8;
    }

    public static int f(int i, int i2) {
        return l(i2) + t(i);
    }

    public static int g(int i) {
        return t(i) + 4;
    }

    public static int h(int i) {
        return t(i) + 8;
    }

    public static int i(int i) {
        return t(i) + 4;
    }

    public static int j(int i, InterfaceC1787yS0 interfaceC1787yS0, Cz1 cz1) {
        return ((A) interfaceC1787yS0).a(cz1) + (t(i) * 2);
    }

    public static int k(int i, int i2) {
        return l(i2) + t(i);
    }

    public static int l(int i) {
        if (i >= 0) {
            return v(i);
        }
        return 10;
    }

    public static int m(int i, long j) {
        return x(j) + t(i);
    }

    public static int n(int i) {
        return t(i) + 4;
    }

    public static int o(int i) {
        return t(i) + 8;
    }

    public static int p(int i, int i2) {
        return v((i2 >> 31) ^ (i2 << 1)) + t(i);
    }

    public static int q(int i, long j) {
        return x((j >> 63) ^ (j << 1)) + t(i);
    }

    public static int r(int i, String str) {
        return s(str) + t(i);
    }

    public static int s(String str) {
        int length;
        try {
            length = AbstractC0104Im2.b(str);
        } catch (Utf8$UnpairedSurrogateException unused) {
            length = str.getBytes(gz0.a).length;
        }
        return v(length) + length;
    }

    public static int t(int i) {
        return v(i << 3);
    }

    public static int u(int i, int i2) {
        return v(i2) + t(i);
    }

    public static int v(int i) {
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

    public static int w(int i, long j) {
        return x(j) + t(i);
    }

    public static int x(long j) {
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

    public abstract void A(int i, boolean z);

    public abstract void B(int i, byte[] bArr);

    public abstract void C(int i, C0199Qv c0199Qv);

    public abstract void D(C0199Qv c0199Qv);

    public abstract void E(int i, int i2);

    public abstract void F(int i);

    public abstract void G(int i, long j);

    public abstract void H(long j);

    public abstract void I(int i, int i2);

    public abstract void J(int i);

    public abstract void K(int i, InterfaceC1787yS0 interfaceC1787yS0, Cz1 cz1);

    public abstract void L(InterfaceC1787yS0 interfaceC1787yS0);

    public abstract void M(int i, String str);

    public abstract void N(String str);

    public abstract void O(int i, int i2);

    public abstract void P(int i, int i2);

    public abstract void Q(int i);

    public abstract void R(int i, long j);

    public abstract void S(long j);

    public final void y(String str) throws CodedOutputStream$OutOfSpaceException {
        byte[] bytes = str.getBytes(gz0.a);
        try {
            Q(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(e);
        }
    }

    public abstract void z(byte b2);
}
