package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TW2 implements Runnable {
    public final long t;
    public final long u;
    public final /* synthetic */ UW2 v;

    public TW2(UW2 uw2, long j, long j2) {
        this.v = uw2;
        this.t = j;
        this.u = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0899jR2 c0899jR2 = this.v.b.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new Runnable() { // from class: SW2
            @Override // java.lang.Runnable
            public final void run() {
                TW2 tw2 = this.t;
                UW2 uw2 = tw2.v;
                uw2.b.g();
                C0420bX2 c0420bX2 = uw2.b;
                WO2 wo2 = c0420bX2.a.i;
                C1391rR2.k(wo2);
                wo2.m.a("Application going to the background");
                C1391rR2 c1391rR2 = c0420bX2.a;
                TP2 tp2 = c1391rR2.h;
                C1391rR2.i(tp2);
                tp2.p.a(true);
                Bundle bundle = new Bundle();
                if (!c1391rR2.g.r()) {
                    YW2 yw2 = c0420bX2.e;
                    yw2.c.a();
                    yw2.a(tw2.u, false, false);
                }
                IU2 iu2 = c1391rR2.p;
                C1391rR2.j(iu2);
                iu2.o(tw2.t, bundle, "auto", "_ab");
            }
        });
    }
}
