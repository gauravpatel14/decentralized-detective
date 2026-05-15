package defpackage;

import com.google.android.gms.measurement.internal.zzq;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: lU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1030lU2 implements Runnable {
    public final /* synthetic */ AtomicReference t;
    public final /* synthetic */ String u;
    public final /* synthetic */ String v;
    public final /* synthetic */ boolean w;
    public final /* synthetic */ IU2 x;

    public RunnableC1030lU2(IU2 iu2, AtomicReference atomicReference, String str, String str2, boolean z) {
        this.x = iu2;
        this.t = atomicReference;
        this.u = str;
        this.v = str2;
        this.w = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CW2 cw2S = this.x.a.s();
        cw2S.g();
        cw2S.h();
        zzq zzqVarP = cw2S.p(false);
        cw2S.s(new XV2(cw2S, this.t, this.u, this.v, zzqVarP, this.w));
    }
}
