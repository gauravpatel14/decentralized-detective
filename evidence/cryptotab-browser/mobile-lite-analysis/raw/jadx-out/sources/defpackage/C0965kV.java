package defpackage;

import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: renamed from: kV, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0965kV {
    public final ER0 a;
    public final int b;
    public final C0903jV c;

    public C0965kV(ER0 er0) {
        this(er0, new C0903jV(er0.b.size(), er0.a.limit()), 0);
    }

    public final void a() {
        this.c.c--;
    }

    public final void b() {
        C0903jV c0903jV = this.c;
        long j = c0903jV.c + 1;
        c0903jV.c = j;
        if (j >= 100) {
            throw new DeserializationException("Recursion depth limit exceeded.");
        }
    }

    public final MT c(MT[] mtArr) {
        MT mt;
        MT mtF = f();
        int length = mtArr.length - 1;
        MT mt2 = mtArr[length];
        int i = mt2.b;
        int i2 = mtF.a;
        int i3 = mtF.b;
        if (i3 <= i) {
            while (true) {
                if (length < 0) {
                    mt = null;
                    break;
                }
                mt = mtArr[length];
                if (i3 >= mt.b) {
                    break;
                }
                length--;
            }
            if (mt == null || mt.a != i2) {
                throw new DeserializationException("Header doesn't correspond to any known version.");
            }
        } else if (i2 < mt2.a) {
            throw new DeserializationException("Message newer than the last known version cannot be shorter than required by the last known version.");
        }
        return mtF;
    }

    public final boolean d(int i, int i2) {
        w(i, 1);
        w(i, 1);
        return (this.a.a.get(this.b + i) & (1 << i2)) != 0;
    }

    public final byte[] e(int i, int i2, int i3) {
        C0965kV c0965kVR = r(i, Ip.a(i2));
        if (c0965kVR == null) {
            return null;
        }
        byte[] bArr = new byte[c0965kVR.h(i3, 1L).b];
        ER0 er0 = c0965kVR.a;
        er0.a.get(bArr);
        return bArr;
    }

    public final MT f() {
        int i = this.b;
        C0903jV c0903jV = this.c;
        c0903jV.a(i, i + 8);
        MT mtG = g(0, false);
        c0903jV.a(i + 8, i + mtG.a);
        return mtG;
    }

    public final MT g(int i, boolean z) {
        int iN = n(i);
        int iN2 = n(i + 4);
        if (iN < 0) {
            throw new DeserializationException("Negative size. Unsigned integers are not valid for java.");
        }
        if (iN2 >= 0 || (z && iN2 == -1)) {
            return new MT(iN, iN2);
        }
        throw new DeserializationException("Negative elements or version. Unsigned integers are not valid for java.");
    }

    public final MT h(int i, long j) {
        MT mtF = f();
        int i2 = mtF.b;
        if (mtF.a < (j * ((long) i2)) + 8) {
            throw new DeserializationException("Array header is incorrect.");
        }
        if (i == -1 || i2 == i) {
            return mtF;
        }
        throw new DeserializationException("Incorrect array length. Expected: " + i + ", but got: " + i2 + ".");
    }

    public final void i() {
        MT mtF = f();
        if (mtF.a != 24) {
            throw new DeserializationException("Incorrect header for map. The size is incorrect.");
        }
        if (mtF.b != 0) {
            throw new DeserializationException("Incorrect header for map. The version is incorrect.");
        }
    }

    public final MT j(int i) {
        MT mtG = g(i, true);
        int i2 = mtG.a;
        if (i2 == 0) {
            int i3 = mtG.b;
            if (i3 != 0) {
                throw new DeserializationException(AbstractC1214oR1.a(i3, "Unexpected version tag for a null union. Expecting 0, found: "));
            }
        } else if (i2 != 16) {
            throw new DeserializationException("Unexpected size of an union. The size must be 0 for a null union, or 16 for a non-null union.");
        }
        return mtG;
    }

    public final double k(int i) {
        w(i, 8);
        return this.a.a.getDouble(this.b + i);
    }

    public final float l(int i) {
        w(i, 4);
        return this.a.a.getFloat(this.b + i);
    }

    public final float[] m(int i, int i2) {
        C0965kV c0965kVR = r(i, Ip.a(1));
        if (c0965kVR == null) {
            return null;
        }
        float[] fArr = new float[c0965kVR.h(i2, 4L).b];
        ER0 er0 = c0965kVR.a;
        er0.a.asFloatBuffer().get(fArr);
        return fArr;
    }

    public final int n(int i) {
        w(i, 4);
        return this.a.a.getInt(this.b + i);
    }

    public final bz0 o(int i) {
        return new bz0(v(i, false).a1());
    }

    public final int[] p(int i, int i2) {
        C0965kV c0965kVR = r(i, Ip.a(i2));
        if (c0965kVR == null) {
            return null;
        }
        int[] iArr = new int[c0965kVR.h(-1, 4L).b];
        ER0 er0 = c0965kVR.a;
        er0.a.asIntBuffer().get(iArr);
        return iArr;
    }

    public final long q(int i) {
        w(i, 8);
        return this.a.a.getLong(this.b + i);
    }

    public final C0965kV r(int i, boolean z) {
        int i2 = this.b + i;
        long jQ = q(i);
        if (jQ != 0) {
            return new C0965kV(this.a, this.c, (int) (((long) i2) + jQ));
        }
        if (z) {
            return null;
        }
        throw new DeserializationException("Trying to decode null pointer for a non-nullable type.");
    }

    public final Ky0 s(int i, boolean z, Ly0 ly0) {
        FS0 fs0A1 = v(i, z).a1();
        if (fs0A1.f()) {
            return ly0.a(fs0A1, n(i + 4));
        }
        return null;
    }

    public final short t(int i) {
        w(i, 2);
        return this.a.a.getShort(this.b + i);
    }

    public final String u(int i, boolean z) {
        byte[] bArrE = e(i, z ? 1 : 0, -1);
        if (bArrE == null) {
            return null;
        }
        return new String(bArrE, Charset.forName("utf8"));
    }

    public final InterfaceC1749xk2 v(int i, boolean z) {
        InterfaceC1409rn0 interfaceC1409rn0;
        int iN = n(i);
        if (iN != -1) {
            C0903jV c0903jV = this.c;
            if (iN < c0903jV.a) {
                throw new DeserializationException("Trying to access handle out of order.");
            }
            if (iN >= c0903jV.e) {
                throw new DeserializationException("Trying to access non present handle.");
            }
            c0903jV.a = iN + 1;
            interfaceC1409rn0 = (InterfaceC1409rn0) this.a.b.get(iN);
        } else {
            if (!z) {
                throw new DeserializationException("Trying to decode an invalid handle for a non-nullable type.");
            }
            interfaceC1409rn0 = pz0.t;
        }
        return interfaceC1409rn0.s0();
    }

    public final void w(int i, int i2) {
        if (this.a.a.limit() < i + i2) {
            throw new DeserializationException("Buffer is smaller than expected.");
        }
    }

    public C0965kV(ER0 er0, C0903jV c0903jV, int i) {
        this.a = er0;
        er0.a.order(ByteOrder.LITTLE_ENDIAN);
        this.b = i;
        this.c = c0903jV;
    }
}
