package defpackage;

import java.math.BigInteger;
import java.util.Locale;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PX2 {
    public final String a;
    public final long b;

    /* JADX WARN: Illegal instructions before constructor call */
    public PX2(QX2 qx2) {
        byte[] bArr = new byte[16];
        qx2.P().o().nextBytes(bArr);
        this(qx2, String.format(Locale.US, "%032x", new BigInteger(1, bArr)));
    }

    public PX2(QX2 qx2, String str) {
        this.a = str;
        this.b = qx2.e().elapsedRealtime();
    }
}
