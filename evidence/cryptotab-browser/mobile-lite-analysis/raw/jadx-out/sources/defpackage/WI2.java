package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WI2 implements FI2 {
    public VR2 b;
    public final C0460cJ2 c;

    public WI2(Context context, VR2 vr2) {
        this.c = new C0460cJ2(context);
        this.b = vr2;
    }

    public final void a(OQ2 oq2) {
        if (oq2 == null) {
            return;
        }
        try {
            PS2 ps2P = TS2.p();
            VR2 vr2 = this.b;
            ps2P.c();
            TS2.m((TS2) ps2P.u, vr2);
            ps2P.c();
            TS2.n((TS2) ps2P.u, oq2);
            this.c.a((TS2) ps2P.a());
        } catch (Throwable th) {
            AbstractC1659wF2.f("BillingLogger", "Unable to log.", th);
        }
    }

    public final void b(C0412bR2 c0412bR2) {
        if (c0412bR2 == null) {
            return;
        }
        try {
            PS2 ps2P = TS2.p();
            VR2 vr2 = this.b;
            ps2P.c();
            TS2.m((TS2) ps2P.u, vr2);
            ps2P.c();
            TS2.o((TS2) ps2P.u, c0412bR2);
            this.c.a((TS2) ps2P.a());
        } catch (Throwable th) {
            AbstractC1659wF2.f("BillingLogger", "Unable to log.", th);
        }
    }
}
