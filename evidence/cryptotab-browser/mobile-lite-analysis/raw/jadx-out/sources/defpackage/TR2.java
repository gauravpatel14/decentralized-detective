package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TR2 implements Runnable {
    public final /* synthetic */ zzq t;
    public final /* synthetic */ MS2 u;

    public TR2(MS2 ms2, zzq zzqVar) {
        this.u = ms2;
        this.t = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MS2 ms2 = this.u;
        ms2.t.a();
        QX2 qx2 = ms2.t;
        qx2.b().g();
        qx2.g();
        zzq zzqVar = this.t;
        Preconditions.checkNotEmpty(zzqVar.t);
        qx2.I(zzqVar);
    }
}
