package defpackage;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: gn1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0734gn1 {
    public static final C0734gn1 c = new C0734gn1();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final TK0 a = new TK0();

    public final Cz1 a(Class cls) {
        Cz1 cz1A;
        RS0 rs0;
        Class cls2;
        gz0.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.b;
        Cz1 cz1 = (Cz1) concurrentHashMap.get(cls);
        if (cz1 != null) {
            return cz1;
        }
        TK0 tk0 = this.a;
        tk0.getClass();
        Class cls3 = Fz1.a;
        if (!AbstractC0003Al0.class.isAssignableFrom(cls) && (cls2 = Fz1.a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
        rq1 rq1VarA = tk0.a.a(cls);
        if ((rq1VarA.d & 2) == 2) {
            boolean zIsAssignableFrom = AbstractC0003Al0.class.isAssignableFrom(cls);
            InterfaceC1787yS0 interfaceC1787yS0 = rq1VarA.a;
            if (zIsAssignableFrom) {
                rs0 = new RS0(Fz1.d, AbstractC1309q90.a, interfaceC1787yS0);
            } else {
                C0373ak2 c0373ak2 = Fz1.b;
                C1252p90 c1252p90 = AbstractC1309q90.b;
                if (c1252p90 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                rs0 = new RS0(c0373ak2, c1252p90, interfaceC1787yS0);
            }
            cz1A = rs0;
        } else if (AbstractC0003Al0.class.isAssignableFrom(cls)) {
            cz1A = rq1VarA.d() == 1 ? MS0.A(rq1VarA, yY0.b, AbstractC0764hG0.b, Fz1.d, AbstractC1309q90.a, BL0.b) : MS0.A(rq1VarA, yY0.b, AbstractC0764hG0.b, Fz1.d, null, BL0.b);
        } else if (rq1VarA.d() == 1) {
            xY0 xy0 = yY0.a;
            C0627fG0 c0627fG0 = AbstractC0764hG0.a;
            C0373ak2 c0373ak22 = Fz1.b;
            C1252p90 c1252p902 = AbstractC1309q90.b;
            if (c1252p902 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            cz1A = MS0.A(rq1VarA, xy0, c0627fG0, c0373ak22, c1252p902, BL0.a);
        } else {
            cz1A = MS0.A(rq1VarA, yY0.a, AbstractC0764hG0.a, Fz1.c, null, BL0.a);
        }
        Cz1 cz12 = (Cz1) concurrentHashMap.putIfAbsent(cls, cz1A);
        return cz12 != null ? cz12 : cz1A;
    }
}
