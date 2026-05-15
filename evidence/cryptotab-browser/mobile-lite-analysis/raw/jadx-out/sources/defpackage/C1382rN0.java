package defpackage;

import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: rN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1382rN0 {
    public static final char[] d = "0123456789ABCDEF".toCharArray();
    public final byte[] a;
    public byte[] b;
    public byte[] c;

    public C1382rN0(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.a = bArr;
        this.b = bArr2;
        this.c = bArr3;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] >>> 4;
            char[] cArr = d;
            sb.append(cArr[i2]);
            sb.append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public final String toString() {
        return new String(this.a, StandardCharsets.UTF_8);
    }
}
