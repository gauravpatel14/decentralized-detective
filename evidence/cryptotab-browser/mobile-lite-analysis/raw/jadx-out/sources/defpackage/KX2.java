package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzaw;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class KX2 implements Runnable {
    public final /* synthetic */ String t;
    public final /* synthetic */ Bundle u;
    public final /* synthetic */ MX2 v;

    public KX2(MX2 mx2, String str, Bundle bundle) {
        this.v = mx2;
        this.t = str;
        this.u = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        MX2 mx2 = this.v;
        C0653fY2 c0653fY2P = mx2.a.P();
        QX2 qx2 = mx2.a;
        long jCurrentTimeMillis = qx2.e().currentTimeMillis();
        qx2.j((zzaw) Preconditions.checkNotNull(c0653fY2P.j0(this.t, "_err", this.u, "auto", jCurrentTimeMillis, false)), this.t);
    }
}
