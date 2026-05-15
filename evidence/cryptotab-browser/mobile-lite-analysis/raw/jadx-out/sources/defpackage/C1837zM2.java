package defpackage;

import java.nio.charset.Charset;

/* JADX INFO: renamed from: zM2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1837zM2 {
    public static final C1326qM2 b = new C1326qM2();
    public final C1669wM2 a;

    public C1837zM2() {
        InterfaceC1384rN2 interfaceC1384rN2;
        try {
            interfaceC1384rN2 = (InterfaceC1384rN2) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            interfaceC1384rN2 = b;
        }
        C1669wM2 c1669wM2 = new C1669wM2(nJ2.a, interfaceC1384rN2);
        Charset charset = WK2.a;
        this.a = c1669wM2;
    }
}
