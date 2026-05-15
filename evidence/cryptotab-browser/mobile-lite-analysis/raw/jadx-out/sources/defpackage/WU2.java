package defpackage;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class WU2 implements Iterable, Serializable {
    public static final WU2 v = new WU2(NW2.b);
    public int t = 0;
    public final byte[] u;

    static {
        int i = FU2.a;
    }

    public WU2(byte[] bArr) {
        bArr.getClass();
        this.u = bArr;
    }

    public static int l(int i, int i2, int i3) {
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

    public static WU2 p(byte[] bArr, int i, int i2) {
        l(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new WU2(bArr2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WU2) || j() != ((WU2) obj).j()) {
            return false;
        }
        if (j() == 0) {
            return true;
        }
        if (!(obj instanceof WU2)) {
            return obj.equals(this);
        }
        WU2 wu2 = (WU2) obj;
        int i = this.t;
        int i2 = wu2.t;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int iJ = j();
        if (iJ > wu2.j()) {
            throw new IllegalArgumentException("Length too large: " + iJ + j());
        }
        if (iJ > wu2.j()) {
            throw new IllegalArgumentException(Vx1.a(iJ, wu2.j(), "Ran off end of other: 0, ", ", "));
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < iJ) {
            if (this.u[i3] != wu2.u[i4]) {
                return false;
            }
            i3++;
            i4++;
        }
        return true;
    }

    public byte f(int i) {
        return this.u[i];
    }

    public final int hashCode() {
        int i = this.t;
        if (i != 0) {
            return i;
        }
        int iJ = j();
        int i2 = iJ;
        for (int i3 = 0; i3 < iJ; i3++) {
            i2 = (i2 * 31) + this.u[i3];
        }
        if (i2 == 0) {
            i2 = 1;
        }
        this.t = i2;
        return i2;
    }

    public byte i(int i) {
        return this.u[i];
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new OU2(this);
    }

    public int j() {
        return this.u.length;
    }

    public final String toString() {
        String strConcat;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iJ = j();
        if (j() <= 50) {
            strConcat = DY2.a(this);
        } else {
            int iL = l(0, 47, j());
            strConcat = DY2.a(iL == 0 ? v : new SU2(iL, this.u)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iJ);
        sb.append(" contents=\"");
        return S3.a(sb, strConcat, "\">");
    }
}
