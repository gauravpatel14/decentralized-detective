package defpackage;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gz0 {
    public static final Charset a;
    public static final byte[] b;

    static {
        Charset.forName("US-ASCII");
        a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        yG.f(bArr, 0, 0, false);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static AbstractC0003Al0 c(Object obj, Object obj2) {
        AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) ((InterfaceC1787yS0) obj);
        C1750xl0 c1750xl0 = (C1750xl0) abstractC0003Al0.f(EnumC1862zl0.x, null, null);
        c1750xl0.c(abstractC0003Al0);
        InterfaceC1787yS0 interfaceC1787yS0 = (InterfaceC1787yS0) obj2;
        if (!c1750xl0.t.getClass().isInstance(interfaceC1787yS0)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        c1750xl0.c((AbstractC0003Al0) ((A) interfaceC1787yS0));
        return c1750xl0.a();
    }
}
