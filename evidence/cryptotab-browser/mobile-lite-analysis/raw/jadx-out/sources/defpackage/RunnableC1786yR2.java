package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: renamed from: yR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1786yR2 implements Runnable {
    public final /* synthetic */ zzac t;
    public final /* synthetic */ MS2 u;

    public RunnableC1786yR2(MS2 ms2, zzac zzacVar) {
        this.u = ms2;
        this.t = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MS2 ms2 = this.u;
        ms2.t.a();
        zzac zzacVar = this.t;
        Object objF2 = zzacVar.v.f2();
        QX2 qx2 = ms2.t;
        if (objF2 == null) {
            qx2.getClass();
            zzq zzqVarY = qx2.y((String) Preconditions.checkNotNull(zzacVar.t));
            if (zzqVarY != null) {
                qx2.n(zzacVar, zzqVarY);
                return;
            }
            return;
        }
        qx2.getClass();
        zzq zzqVarY2 = qx2.y((String) Preconditions.checkNotNull(zzacVar.t));
        if (zzqVarY2 != null) {
            qx2.q(zzacVar, zzqVarY2);
        }
    }
}
