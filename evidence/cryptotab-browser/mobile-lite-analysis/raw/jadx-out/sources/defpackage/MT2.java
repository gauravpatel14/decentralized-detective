package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzlo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MT2 implements Runnable {
    public final /* synthetic */ Bundle t;
    public final /* synthetic */ IU2 u;

    public MT2(IU2 iu2, Bundle bundle) {
        this.u = iu2;
        this.t = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IU2 iu2 = this.u;
        iu2.g();
        iu2.h();
        Bundle bundle = this.t;
        Preconditions.checkNotNull(bundle);
        String strCheckNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        C1391rR2 c1391rR2 = iu2.a;
        if (!c1391rR2.g()) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzlo zzloVar = new zzlo(0L, null, strCheckNotEmpty, "");
        try {
            C0653fY2 c0653fY2 = c1391rR2.l;
            C1391rR2.i(c0653fY2);
            c1391rR2.s().l(new zzac(bundle.getString("app_id"), "", zzloVar, bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), c0653fY2.j0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
