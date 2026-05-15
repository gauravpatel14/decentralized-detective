package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VU2 implements Runnable {
    public final /* synthetic */ Bundle t;
    public final /* synthetic */ TU2 u;
    public final /* synthetic */ TU2 v;
    public final /* synthetic */ long w;
    public final /* synthetic */ C1791yV2 x;

    public VU2(C1791yV2 c1791yV2, Bundle bundle, TU2 tu2, TU2 tu22, long j) {
        this.x = c1791yV2;
        this.t = bundle;
        this.u = tu2;
        this.v = tu22;
        this.w = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = this.t;
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        C1791yV2 c1791yV2 = this.x;
        C0653fY2 c0653fY2 = c1791yV2.a.l;
        C1391rR2.i(c0653fY2);
        c1791yV2.l(this.u, this.v, this.w, true, c0653fY2.i0(null, "screen_view", bundle, null, false));
    }
}
