package defpackage;

import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: renamed from: wR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1674wR2 implements Runnable {
    public final /* synthetic */ zzac t;
    public final /* synthetic */ zzq u;
    public final /* synthetic */ MS2 v;

    public RunnableC1674wR2(MS2 ms2, zzac zzacVar, zzq zzqVar) {
        this.v = ms2;
        this.t = zzacVar;
        this.u = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MS2 ms2 = this.v;
        ms2.t.a();
        zzac zzacVar = this.t;
        Object objF2 = zzacVar.v.f2();
        QX2 qx2 = ms2.t;
        zzq zzqVar = this.u;
        if (objF2 == null) {
            qx2.n(zzacVar, zzqVar);
        } else {
            qx2.q(zzacVar, zzqVar);
        }
    }
}
