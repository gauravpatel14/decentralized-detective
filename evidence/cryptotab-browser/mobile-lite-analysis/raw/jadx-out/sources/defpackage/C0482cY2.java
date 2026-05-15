package defpackage;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: cY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0482cY2 {
    public static final C0482cY2 c = new C0482cY2();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final EX2 a = new EX2();

    public final InterfaceC0784hY2 a(Class cls) {
        WX2 wx2;
        Class cls2;
        Charset charset = NW2.a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.b;
        InterfaceC0784hY2 interfaceC0784hY2A = (InterfaceC0784hY2) concurrentHashMap.get(cls);
        if (interfaceC0784hY2A == null) {
            EX2 ex2 = this.a;
            ex2.getClass();
            Class cls3 = AbstractC0849iY2.a;
            if (!AbstractC1852zW2.class.isAssignableFrom(cls) && (cls2 = AbstractC0849iY2.a) != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
            C0718gY2 c0718gY2A = ex2.a.a(cls);
            if ((c0718gY2A.d & 2) == 2) {
                boolean zIsAssignableFrom = AbstractC1852zW2.class.isAssignableFrom(cls);
                CU2 cu2 = c0718gY2A.a;
                if (zIsAssignableFrom) {
                    wx2 = new WX2(AbstractC0849iY2.d, PV2.a, cu2);
                } else {
                    FY2 fy2 = AbstractC0849iY2.b;
                    NV2 nv2 = PV2.b;
                    if (nv2 == null) {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                    wx2 = new WX2(fy2, nv2, cu2);
                }
                interfaceC0784hY2A = wx2;
            } else if (AbstractC1852zW2.class.isAssignableFrom(cls)) {
                if (c0718gY2A.b() == 1) {
                    int i = ZX2.a;
                    interfaceC0784hY2A = UX2.A(c0718gY2A, AbstractC0716gX2.b, AbstractC0849iY2.d, PV2.a, LX2.b);
                } else {
                    int i2 = ZX2.a;
                    interfaceC0784hY2A = UX2.A(c0718gY2A, AbstractC0716gX2.b, AbstractC0849iY2.d, null, LX2.b);
                }
            } else if (c0718gY2A.b() == 1) {
                int i3 = ZX2.a;
                C0361aX2 c0361aX2 = AbstractC0716gX2.a;
                FY2 fy22 = AbstractC0849iY2.b;
                NV2 nv22 = PV2.b;
                if (nv22 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                interfaceC0784hY2A = UX2.A(c0718gY2A, c0361aX2, fy22, nv22, LX2.a);
            } else {
                int i4 = ZX2.a;
                interfaceC0784hY2A = UX2.A(c0718gY2A, AbstractC0716gX2.a, AbstractC0849iY2.c, null, LX2.a);
            }
            InterfaceC0784hY2 interfaceC0784hY2 = (InterfaceC0784hY2) concurrentHashMap.putIfAbsent(cls, interfaceC0784hY2A);
            if (interfaceC0784hY2 != null) {
                return interfaceC0784hY2;
            }
        }
        return interfaceC0784hY2A;
    }
}
