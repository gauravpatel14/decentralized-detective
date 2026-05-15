package defpackage;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZW2 {
    public final /* synthetic */ C0420bX2 a;

    public ZW2(C0420bX2 c0420bX2) {
        this.a = c0420bX2;
    }

    public final void a() {
        C0420bX2 c0420bX2 = this.a;
        c0420bX2.g();
        C1391rR2 c1391rR2 = c0420bX2.a;
        TP2 tp2 = c1391rR2.h;
        C1391rR2.i(tp2);
        if (tp2.n(c1391rR2.n.currentTimeMillis())) {
            TP2 tp22 = c1391rR2.h;
            C1391rR2.i(tp22);
            tp22.k.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.n.a("Detected application was in foreground");
                c(c1391rR2.n.currentTimeMillis(), false);
            }
        }
    }

    public final void b(long j, boolean z) {
        C0420bX2 c0420bX2 = this.a;
        c0420bX2.g();
        c0420bX2.k();
        C1391rR2 c1391rR2 = c0420bX2.a;
        TP2 tp2 = c1391rR2.h;
        C1391rR2.i(tp2);
        if (tp2.n(j)) {
            TP2 tp22 = c1391rR2.h;
            C1391rR2.i(tp22);
            tp22.k.a(true);
            Y03.a();
            if (c1391rR2.g.p(null, AbstractC0579eO2.C0)) {
                c1391rR2.o().m();
            }
        }
        TP2 tp23 = c1391rR2.h;
        C1391rR2.i(tp23);
        tp23.n.b(j);
        TP2 tp24 = c1391rR2.h;
        C1391rR2.i(tp24);
        if (tp24.k.b()) {
            c(j, z);
        }
    }

    public final void c(long j, boolean z) {
        C0420bX2 c0420bX2 = this.a;
        c0420bX2.g();
        C1391rR2 c1391rR2 = c0420bX2.a;
        if (c1391rR2.g()) {
            TP2 tp2 = c1391rR2.h;
            C1391rR2.i(tp2);
            tp2.n.b(j);
            long jElapsedRealtime = c1391rR2.n.elapsedRealtime();
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.b(Long.valueOf(jElapsedRealtime), "Session started, time");
            long j2 = j / 1000;
            Long lValueOf = Long.valueOf(j2);
            IU2 iu2 = c1391rR2.p;
            C1391rR2.j(iu2);
            iu2.w(j, lValueOf, "auto", "_sid");
            TP2 tp22 = c1391rR2.h;
            C1391rR2.i(tp22);
            tp22.k.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j2);
            if (c1391rR2.g.p(null, AbstractC0579eO2.Z) && z) {
                bundle.putLong("_aib", 1L);
            }
            IU2 iu22 = c1391rR2.p;
            C1391rR2.j(iu22);
            iu22.o(j, bundle, "auto", "_s");
            ((VZ2) UZ2.u.t.zza()).getClass();
            if (c1391rR2.g.p(null, AbstractC0579eO2.c0)) {
                TP2 tp23 = c1391rR2.h;
                C1391rR2.i(tp23);
                String strA = tp23.s.a();
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strA);
                IU2 iu23 = c1391rR2.p;
                C1391rR2.j(iu23);
                iu23.o(j, bundle2, "auto", "_ssr");
            }
        }
    }
}
