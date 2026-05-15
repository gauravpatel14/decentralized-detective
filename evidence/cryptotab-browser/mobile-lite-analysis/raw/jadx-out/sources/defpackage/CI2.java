package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class CI2 {
    public static final /* synthetic */ int a = 0;

    static {
        int i = FI2.a;
    }

    public static OQ2 a(int i, int i2, Cp cp) {
        try {
            xQ2 xq2P = OQ2.p();
            C0708gR2 c0708gR2P = qR2.p();
            int i3 = cp.a;
            c0708gR2P.c();
            qR2.l((qR2) c0708gR2P.u, i3);
            String str = cp.b;
            c0708gR2P.c();
            qR2.m((qR2) c0708gR2P.u, str);
            c0708gR2P.c();
            qR2.o((qR2) c0708gR2P.u, i);
            xq2P.c();
            OQ2.m((OQ2) xq2P.u, (qR2) c0708gR2P.a());
            xq2P.c();
            OQ2.o((OQ2) xq2P.u, i2);
            return (OQ2) xq2P.a();
        } catch (Exception e) {
            AbstractC1659wF2.f("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }

    public static C0412bR2 b(int i) {
        try {
            YQ2 yq2N = C0412bR2.n();
            yq2N.c();
            C0412bR2.m((C0412bR2) yq2N.u, i);
            return (C0412bR2) yq2N.a();
        } catch (Exception e) {
            AbstractC1659wF2.f("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}
