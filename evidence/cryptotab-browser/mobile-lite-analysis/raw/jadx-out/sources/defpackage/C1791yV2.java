package defpackage;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: yV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1791yV2 extends TO2 {
    public volatile TU2 c;
    public volatile TU2 d;
    public TU2 e;
    public final ConcurrentHashMap f;
    public Activity g;
    public volatile boolean h;
    public volatile TU2 i;
    public TU2 j;
    public boolean k;
    public final Object l;
    public String m;

    public C1791yV2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.l = new Object();
        this.f = new ConcurrentHashMap();
    }

    @Override // defpackage.TO2
    public final boolean j() {
        return false;
    }

    public final void k(Activity activity, TU2 tu2, boolean z) {
        TU2 tu22;
        TU2 tu23 = this.c == null ? this.d : this.c;
        if (tu2.b == null) {
            tu22 = new TU2(tu2.a, activity != null ? o(activity.getClass()) : null, tu2.c, tu2.e, tu2.f);
        } else {
            tu22 = tu2;
        }
        this.d = this.c;
        this.c = tu22;
        long jElapsedRealtime = this.a.n.elapsedRealtime();
        C0899jR2 c0899jR2 = this.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new XU2(this, tu22, tu23, jElapsedRealtime, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(defpackage.TU2 r18, defpackage.TU2 r19, long r20, boolean r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1791yV2.l(TU2, TU2, long, boolean, android.os.Bundle):void");
    }

    public final void m(TU2 tu2, boolean z, long j) {
        C1391rR2 c1391rR2 = this.a;
        c1391rR2.m().j(c1391rR2.n.elapsedRealtime());
        boolean z2 = tu2 != null && tu2.d;
        C0420bX2 c0420bX2 = c1391rR2.k;
        C1391rR2.j(c0420bX2);
        if (!c0420bX2.e.a(j, z2, z) || tu2 == null) {
            return;
        }
        tu2.d = false;
    }

    public final TU2 n(boolean z) {
        h();
        g();
        if (!z) {
            return this.e;
        }
        TU2 tu2 = this.e;
        return tu2 != null ? tu2 : this.j;
    }

    public final String o(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        int length = strArrSplit.length;
        String str = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str.length();
        this.a.getClass();
        return length2 > 100 ? str.substring(0, 100) : str;
    }

    public final void p(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.a.g.r() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f.put(activity, new TU2(bundle2.getLong("id"), bundle2.getString("name"), bundle2.getString("referrer_name")));
    }

    public final TU2 q(Activity activity) {
        Preconditions.checkNotNull(activity);
        TU2 tu2 = (TU2) this.f.get(activity);
        if (tu2 == null) {
            String strO = o(activity.getClass());
            C0653fY2 c0653fY2 = this.a.l;
            C1391rR2.i(c0653fY2);
            TU2 tu22 = new TU2(c0653fY2.f0(), null, strO);
            this.f.put(activity, tu22);
            tu2 = tu22;
        }
        return this.i != null ? this.i : tu2;
    }
}
