package defpackage;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EX2 {
    public static final C0968kX2 b = new C0968kX2();
    public final CX2 a;

    public EX2() {
        NX2 nx2;
        try {
            nx2 = (NX2) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            nx2 = b;
        }
        CX2 cx2 = new CX2(YV2.a, nx2);
        Charset charset = NW2.a;
        this.a = cx2;
    }
}
