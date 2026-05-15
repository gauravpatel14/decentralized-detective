package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzlo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class KT2 implements Runnable {
    public final /* synthetic */ Bundle t;
    public final /* synthetic */ IU2 u;

    public KT2(IU2 iu2, Bundle bundle) {
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
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        C1391rR2 c1391rR2 = iu2.a;
        boolean zG = c1391rR2.g();
        C0653fY2 c0653fY2 = c1391rR2.l;
        if (!zG) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzlo zzloVar = new zzlo(bundle.getLong("triggered_timestamp"), bundle.get("value"), string, string2);
        try {
            C1391rR2.i(c0653fY2);
            zzaw zzawVarJ0 = c0653fY2.j0(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true);
            C1391rR2.i(c0653fY2);
            zzaw zzawVarJ02 = c0653fY2.j0(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true);
            C1391rR2.i(c0653fY2);
            c1391rR2.s().l(new zzac(bundle.getString("app_id"), string2, zzloVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), zzawVarJ02, bundle.getLong("trigger_timeout"), zzawVarJ0, bundle.getLong("time_to_live"), c0653fY2.j0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
