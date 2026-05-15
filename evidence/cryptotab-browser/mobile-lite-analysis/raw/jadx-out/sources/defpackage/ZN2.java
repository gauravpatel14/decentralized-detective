package defpackage;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZN2 {
    public static final ZN2 c = new ZN2();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final C1837zM2 a = new C1837zM2();

    public final InterfaceC0773hO2 a(Class cls) {
        HN2 hn2;
        Class cls2;
        Charset charset = WK2.a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.b;
        InterfaceC0773hO2 interfaceC0773hO2U = (InterfaceC0773hO2) concurrentHashMap.get(cls);
        if (interfaceC0773hO2U == null) {
            C1837zM2 c1837zM2 = this.a;
            c1837zM2.getClass();
            Class cls3 = AbstractC1025lO2.a;
            if (!LJ2.class.isAssignableFrom(cls) && (cls2 = AbstractC1025lO2.a) != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
            C0640fO2 c0640fO2A = c1837zM2.a.a(cls);
            if ((c0640fO2A.d & 2) == 2) {
                boolean zIsAssignableFrom = LJ2.class.isAssignableFrom(cls);
                AbstractC0948kF2 abstractC0948kF2 = c0640fO2A.a;
                if (zIsAssignableFrom) {
                    hn2 = new HN2(AbstractC1025lO2.c, SI2.a, abstractC0948kF2);
                } else {
                    C1331qP2 c1331qP2 = AbstractC1025lO2.b;
                    OI2 oi2 = SI2.b;
                    if (oi2 == null) {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                    hn2 = new HN2(c1331qP2, oi2, abstractC0948kF2);
                }
                interfaceC0773hO2U = hn2;
            } else if (LJ2.class.isAssignableFrom(cls)) {
                if (c0640fO2A.b() - 1 != 1) {
                    int i = SN2.a;
                    ZL2 zl2 = AbstractC0769hM2.b;
                    C1331qP2 c1331qP22 = AbstractC1025lO2.c;
                    OI2 oi22 = SI2.a;
                    int i2 = MM2.a;
                    interfaceC0773hO2U = GN2.u(c0640fO2A, zl2, c1331qP22, oi22);
                } else {
                    int i3 = SN2.a;
                    ZL2 zl22 = AbstractC0769hM2.b;
                    C1331qP2 c1331qP23 = AbstractC1025lO2.c;
                    int i4 = MM2.a;
                    interfaceC0773hO2U = GN2.u(c0640fO2A, zl22, c1331qP23, null);
                }
            } else if (c0640fO2A.b() - 1 != 1) {
                int i5 = SN2.a;
                SL2 sl2 = AbstractC0769hM2.a;
                C1331qP2 c1331qP24 = AbstractC1025lO2.b;
                OI2 oi23 = SI2.b;
                if (oi23 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                int i6 = MM2.a;
                interfaceC0773hO2U = GN2.u(c0640fO2A, sl2, c1331qP24, oi23);
            } else {
                int i7 = SN2.a;
                SL2 sl22 = AbstractC0769hM2.a;
                C1331qP2 c1331qP25 = AbstractC1025lO2.b;
                int i8 = MM2.a;
                interfaceC0773hO2U = GN2.u(c0640fO2A, sl22, c1331qP25, null);
            }
            InterfaceC0773hO2 interfaceC0773hO2 = (InterfaceC0773hO2) concurrentHashMap.putIfAbsent(cls, interfaceC0773hO2U);
            if (interfaceC0773hO2 != null) {
                return interfaceC0773hO2;
            }
        }
        return interfaceC0773hO2U;
    }
}
