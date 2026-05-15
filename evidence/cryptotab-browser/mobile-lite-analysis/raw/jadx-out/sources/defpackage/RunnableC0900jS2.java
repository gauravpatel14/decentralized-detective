package defpackage;

import com.google.android.gms.measurement.internal.zzlo;
import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: renamed from: jS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0900jS2 implements Runnable {
    public final /* synthetic */ zzlo t;
    public final /* synthetic */ zzq u;
    public final /* synthetic */ MS2 v;

    public RunnableC0900jS2(MS2 ms2, zzlo zzloVar, zzq zzqVar) {
        this.v = ms2;
        this.t = zzloVar;
        this.u = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MS2 ms2 = this.v;
        ms2.t.a();
        zzlo zzloVar = this.t;
        Object objF2 = zzloVar.f2();
        QX2 qx2 = ms2.t;
        zzq zzqVar = this.u;
        if (objF2 == null) {
            qx2.o(zzloVar, zzqVar);
        } else {
            qx2.s(zzloVar, zzqVar);
        }
    }
}
