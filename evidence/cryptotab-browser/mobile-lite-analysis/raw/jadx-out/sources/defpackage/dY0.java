package defpackage;

import android.net.Network;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dY0 implements Runnable {
    public final /* synthetic */ Network t;
    public final /* synthetic */ fY0 u;

    public dY0(fY0 fy0, Network network) {
        this.u = fy0;
        this.t = network;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.u.b.d.f(this.t.getNetworkHandle());
    }
}
