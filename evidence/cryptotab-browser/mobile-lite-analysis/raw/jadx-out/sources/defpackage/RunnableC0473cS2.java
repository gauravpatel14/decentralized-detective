package defpackage;

import com.google.android.gms.measurement.internal.zzaw;

/* JADX INFO: renamed from: cS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0473cS2 implements Runnable {
    public final /* synthetic */ zzaw t;
    public final /* synthetic */ String u;
    public final /* synthetic */ MS2 v;

    public RunnableC0473cS2(MS2 ms2, zzaw zzawVar, String str) {
        this.v = ms2;
        this.t = zzawVar;
        this.u = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        MS2 ms2 = this.v;
        ms2.t.a();
        ms2.t.j(this.t, this.u);
    }
}
