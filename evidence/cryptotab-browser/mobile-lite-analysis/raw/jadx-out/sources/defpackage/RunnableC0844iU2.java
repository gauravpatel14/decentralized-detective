package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: iU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0844iU2 implements Runnable {
    public final /* synthetic */ AtomicReference t;
    public final /* synthetic */ String u;
    public final /* synthetic */ String v;
    public final /* synthetic */ IU2 w;

    public RunnableC0844iU2(IU2 iu2, AtomicReference atomicReference, String str, String str2) {
        this.w = iu2;
        this.t = atomicReference;
        this.u = str;
        this.v = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CW2 cw2S = this.w.a.s();
        cw2S.g();
        cw2S.h();
        cw2S.s(new UV2(cw2S, this.t, this.u, this.v, cw2S.p(false)));
    }
}
