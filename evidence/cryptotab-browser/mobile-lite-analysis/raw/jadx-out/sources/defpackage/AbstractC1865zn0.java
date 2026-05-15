package defpackage;

/* JADX INFO: renamed from: zn0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1865zn0 {
    public static final char[] t = "0123456789abcdef".toCharArray();

    public final boolean equals(Object obj) {
        if (!(obj instanceof AbstractC1865zn0)) {
            return false;
        }
        AbstractC1865zn0 abstractC1865zn0 = (AbstractC1865zn0) obj;
        abstractC1865zn0.getClass();
        return ((C1804yn0) this).u == ((C1804yn0) abstractC1865zn0).u;
    }

    public final int hashCode() {
        return ((C1804yn0) this).u;
    }

    public final String toString() {
        int i = ((C1804yn0) this).u;
        byte[] bArr = {(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
        StringBuilder sb = new StringBuilder(8);
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = bArr[i2];
            char[] cArr = t;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }
}
