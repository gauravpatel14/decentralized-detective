package defpackage;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NW2 {
    public static final Charset a;
    public static final byte[] b;

    static {
        Charset.forName("US-ASCII");
        a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static AbstractC1852zW2 b(Object obj, Object obj2) {
        AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) ((CU2) obj);
        AbstractC0360aW2 abstractC0360aW2 = (AbstractC0360aW2) abstractC1852zW2.k(5);
        abstractC0360aW2.b(abstractC1852zW2);
        CU2 cu2 = (CU2) obj2;
        if (!abstractC0360aW2.t.getClass().isInstance(cu2)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        abstractC0360aW2.b((AbstractC1852zW2) cu2);
        return abstractC0360aW2.e();
    }
}
