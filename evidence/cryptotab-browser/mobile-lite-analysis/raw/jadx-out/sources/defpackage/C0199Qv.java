package defpackage;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: Qv, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0199Qv implements Iterable, Serializable {
    public static final C0199Qv v = new C0199Qv(gz0.b);
    public static final C0180Ov w;
    public int t = 0;
    public final byte[] u;

    static {
        w = AbstractC1541u7.a() ? new C0180Ov(1) : new C0180Ov(0);
    }

    public C0199Qv(byte[] bArr) {
        bArr.getClass();
        this.u = bArr;
    }

    public static int j(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i >= 0) {
            if (i2 < i) {
                throw new IndexOutOfBoundsException(Vx1.a(i, i2, "Beginning index larger than ending index: ", ", "));
            }
            throw new IndexOutOfBoundsException(Vx1.a(i2, i3, "End index: ", " >= "));
        }
        throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
    }

    public static C0199Qv l(byte[] bArr, int i, int i2) {
        byte[] bArrCopyOfRange;
        j(i, i + i2, bArr.length);
        switch (w.a) {
            case 0:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2 + i);
                break;
            default:
                bArrCopyOfRange = new byte[i2];
                System.arraycopy(bArr, i, bArrCopyOfRange, 0, i2);
                break;
        }
        return new C0199Qv(bArrCopyOfRange);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0199Qv) || size() != ((C0199Qv) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof C0199Qv)) {
            return obj.equals(this);
        }
        C0199Qv c0199Qv = (C0199Qv) obj;
        int i = this.t;
        int i2 = c0199Qv.t;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int size = size();
        if (size > c0199Qv.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > c0199Qv.size()) {
            StringBuilder sbA = AbstractC0672fs1.a(size, "Ran off end of other: 0, ", ", ");
            sbA.append(c0199Qv.size());
            throw new IllegalArgumentException(sbA.toString());
        }
        int iS = s() + size;
        int iS2 = s();
        int iS3 = c0199Qv.s();
        while (iS2 < iS) {
            if (this.u[iS2] != c0199Qv.u[iS3]) {
                return false;
            }
            iS2++;
            iS3++;
        }
        return true;
    }

    public final ByteBuffer f() {
        return ByteBuffer.wrap(this.u, s(), size()).asReadOnlyBuffer();
    }

    public final int hashCode() {
        int i = this.t;
        if (i != 0) {
            return i;
        }
        int size = size();
        int iS = s();
        Charset charset = gz0.a;
        int i2 = size;
        for (int i3 = iS; i3 < iS + size; i3++) {
            i2 = (i2 * 31) + this.u[i3];
        }
        int i4 = i2 != 0 ? i2 : 1;
        this.t = i4;
        return i4;
    }

    public byte i(int i) {
        return this.u[i];
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0165Nv(this);
    }

    public void p(int i, byte[] bArr) {
        System.arraycopy(this.u, 0, bArr, 0, i);
    }

    public int s() {
        return 0;
    }

    public int size() {
        return this.u.length;
    }

    public byte t(int i) {
        return this.u[i];
    }

    public final String toString() {
        C0199Qv c0191Pv;
        String string;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = V72.a(this);
        } else {
            StringBuilder sb = new StringBuilder();
            int iJ = j(0, 47, size());
            if (iJ == 0) {
                c0191Pv = v;
            } else {
                c0191Pv = new C0191Pv(this.u, s(), iJ);
            }
            sb.append(V72.a(c0191Pv));
            sb.append("...");
            string = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("<ByteString@");
        sb2.append(hexString);
        sb2.append(" size=");
        sb2.append(size);
        sb2.append(" contents=\"");
        return S3.a(sb2, string, "\">");
    }

    public final byte[] u() {
        int size = size();
        if (size == 0) {
            return gz0.b;
        }
        byte[] bArr = new byte[size];
        p(size, bArr);
        return bArr;
    }

    public final String v() {
        Charset charset = gz0.a;
        return new String(this.u, s(), size(), charset);
    }

    public final void w(CG cg) {
        cg.a(this.u, s(), size());
    }
}
