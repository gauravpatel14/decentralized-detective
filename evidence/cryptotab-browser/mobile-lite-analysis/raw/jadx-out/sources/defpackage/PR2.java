package defpackage;

import com.google.android.gms.measurement.internal.zzq;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PR2 implements Runnable {
    public final /* synthetic */ zzq t;
    public final /* synthetic */ MS2 u;

    public PR2(MS2 ms2, zzq zzqVar) {
        this.u = ms2;
        this.t = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MS2 ms2 = this.u;
        ms2.t.a();
        ms2.t.p(this.t);
    }
}
