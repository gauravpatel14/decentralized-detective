package defpackage;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TK0 {
    public static final RK0 b = new RK0();
    public final SK0 a;

    public TK0() {
        xS0 xs0;
        try {
            xs0 = (xS0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            xs0 = b;
        }
        xS0[] xs0Arr = {C1691wl0.a, xs0};
        SK0 sk0 = new SK0();
        sk0.a = xs0Arr;
        Charset charset = gz0.a;
        this.a = sk0;
    }
}
