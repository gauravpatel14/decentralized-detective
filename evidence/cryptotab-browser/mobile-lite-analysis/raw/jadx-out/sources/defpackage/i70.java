package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.chromium.mojo.bindings.SerializationException;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class i70 {
    public final int a;
    public final h70 b;

    public i70(CoreImpl coreImpl, int i) {
        this(new h70(coreImpl, i));
    }

    public final void a(int i, float f) {
        this.b.b.putFloat(this.a + i, f);
    }

    public final void b(int i, int i2) {
        this.b.b.putInt(this.a + i2, i);
    }

    public final void c(int i, int i2, int[] iArr) {
        if (iArr == null) {
            p(i, Ip.a(i2));
        } else {
            r(4, iArr.length, i, -1).b.b.asIntBuffer().put(iArr);
        }
    }

    public final void d(int i, long j) {
        this.b.b.putLong(this.a + i, j);
    }

    public final void e(int i, bz0 bz0Var) {
        if (bz0Var == null) {
            o(i, false);
        } else {
            if (this.b.a == null) {
                throw new UnsupportedOperationException("The encoder has been created without a Core. It can't encode an interface.");
            }
            h(bz0Var.t.n1(), i, false);
        }
    }

    public final void f(int i, boolean z, int i2) {
        if (z) {
            h70 h70Var = this.b;
            ByteBuffer byteBuffer = h70Var.b;
            int i3 = this.a + i;
            h70Var.b.put(i3, (byte) (byteBuffer.get(i3) | ((byte) (1 << i2))));
        }
    }

    public final void g(MT mt) {
        int i = (mt.a + 7) & (-8);
        h70 h70Var = this.b;
        h70Var.d += i;
        if (h70Var.b.capacity() < h70Var.d) {
            int iCapacity = h70Var.b.capacity();
            do {
                iCapacity *= 2;
            } while (iCapacity < h70Var.d);
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iCapacity);
            byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
            ByteBuffer byteBuffer = h70Var.b;
            byteBufferAllocateDirect.put(h70Var.b);
            h70Var.b = byteBufferAllocateDirect;
        }
        b(mt.a, 0);
        b(mt.b, 4);
    }

    public final void h(InterfaceC1409rn0 interfaceC1409rn0, int i, boolean z) {
        if (interfaceC1409rn0 == null || !interfaceC1409rn0.f()) {
            o(i, z);
            return;
        }
        h70 h70Var = this.b;
        b(h70Var.c.size(), i);
        h70Var.c.add(interfaceC1409rn0);
    }

    public final void i(Ny0 ny0, int i, boolean z, Ly0 ly0) {
        if (ny0 == null) {
            o(i, z);
            b(0, i + 4);
            return;
        }
        CoreImpl coreImpl = this.b.a;
        if (coreImpl == null) {
            throw new UnsupportedOperationException("The encoder has been created without a Core. It can't encode an interface.");
        }
        if (ny0 instanceof Ky0) {
            Jy0 jy0A = ((Ky0) ny0).a();
            h(((InterfaceC1527tn0) jy0A.u).F1(), i, z);
            b(jy0A.v, i + 4);
        } else {
            J81 j81B = coreImpl.b(null);
            ly0.b(ny0, (FS0) j81B.a);
            h((InterfaceC1409rn0) j81B.b, i, z);
            b(0, i + 4);
        }
    }

    public final void j(WQ1 wq1, int i, boolean z) {
        if (wq1 == null) {
            p(i, z);
        } else {
            d(i, ((long) this.b.d) - ((long) (this.a + i)));
            wq1.a(this);
        }
    }

    public final void k(AbstractC0287Xj2 abstractC0287Xj2, int i, boolean z) {
        if (abstractC0287Xj2 == null && !z) {
            throw new SerializationException("Trying to encode a null pointer for a non-nullable type.");
        }
        if (abstractC0287Xj2 != null) {
            abstractC0287Xj2.a(this, i);
        } else {
            d(i, 0L);
            d(i + 8, 0L);
        }
    }

    public final void l(String str, int i, boolean z) {
        if (str == null) {
            p(i, z);
        } else {
            n(str.getBytes(Charset.forName("utf8")), i, z ? 1 : 0, -1);
        }
    }

    public final void m(short s, int i) {
        this.b.b.putShort(this.a + i, s);
    }

    public final void n(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null) {
            p(i, Ip.a(i2));
        } else {
            r(1, bArr.length, i, i3).b.b.put(bArr);
        }
    }

    public final void o(int i, boolean z) {
        if (!z) {
            throw new SerializationException("Trying to encode an invalid handle for a non-nullable type.");
        }
        this.b.b.putInt(this.a + i, -1);
    }

    public final void p(int i, boolean z) {
        if (!z) {
            throw new SerializationException("Trying to encode a null pointer for a non-nullable type.");
        }
        this.b.b.putLong(this.a + i, 0L);
    }

    public final i70 q(int i, int i2, int i3, int i4) {
        if (i4 != -1 && i4 != i2) {
            throw new SerializationException("Trying to encode a fixed array of incorrect length.");
        }
        d(i3, ((long) this.b.d) - ((long) (this.a + i3)));
        return s(new MT((i * i2) + 8, i2));
    }

    public final i70 r(int i, int i2, int i3, int i4) {
        i70 i70VarQ = q(i, i2, i3, i4);
        return i70VarQ;
    }

    public final i70 s(MT mt) {
        i70 i70Var = new i70(this.b);
        i70Var.g(mt);
        return i70Var;
    }

    public final ER0 t() {
        h70 h70Var = this.b;
        return new ER0(h70Var.b, h70Var.c);
    }

    public i70(h70 h70Var) {
        this.b = h70Var;
        this.a = h70Var.d;
    }
}
