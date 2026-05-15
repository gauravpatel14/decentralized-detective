package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YW2 {
    public long a;
    public long b;
    public final WW2 c;
    public final /* synthetic */ C0420bX2 d;

    public YW2(C0420bX2 c0420bX2) {
        this.d = c0420bX2;
        this.c = new WW2(this, c0420bX2.a);
        long jElapsedRealtime = c0420bX2.a.n.elapsedRealtime();
        this.a = jElapsedRealtime;
        this.b = jElapsedRealtime;
    }

    public final boolean a(long j, boolean z, boolean z2) {
        C0420bX2 c0420bX2 = this.d;
        c0420bX2.g();
        c0420bX2.h();
        ((InterfaceC0747h03) C0680g03.u.t.zza()).getClass();
        C1391rR2 c1391rR2 = c0420bX2.a;
        if (!c1391rR2.g.p(null, AbstractC0579eO2.d0)) {
            TP2 tp2 = c1391rR2.h;
            C1391rR2.i(tp2);
            tp2.n.b(c1391rR2.n.currentTimeMillis());
        } else if (c1391rR2.g()) {
            TP2 tp22 = c1391rR2.h;
            C1391rR2.i(tp22);
            tp22.n.b(c1391rR2.n.currentTimeMillis());
        }
        long j2 = j - this.a;
        if (!z && j2 < 1000) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.b(Long.valueOf(j2), "Screen exposed for less than 1000 ms. Event not sent. time");
            return false;
        }
        if (!z2) {
            j2 = j - this.b;
            this.b = j;
        }
        WO2 wo22 = c1391rR2.i;
        C1391rR2.k(wo22);
        wo22.n.b(Long.valueOf(j2), "Recording user engagement, ms");
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        boolean zR = c1391rR2.g.r();
        C1791yV2 c1791yV2 = c1391rR2.o;
        C1391rR2.j(c1791yV2);
        C0653fY2.s(c1791yV2.n(!zR), bundle, true);
        if (!z2) {
            IU2 iu2 = c1391rR2.p;
            C1391rR2.j(iu2);
            iu2.n("auto", "_e", bundle);
        }
        this.a = j;
        WW2 ww2 = this.c;
        ww2.a();
        ww2.c(3600000L);
        return true;
    }
}
