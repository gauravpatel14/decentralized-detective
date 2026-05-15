package defpackage;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZX0 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ C0908jY0 a;

    public ZX0(C0908jY0 c0908jY0) {
        this.a = c0908jY0;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        C0908jY0 c0908jY0 = this.a;
        if (c0908jY0.j) {
            c0908jY0.b();
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        onAvailable(null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        onAvailable(null);
    }
}
