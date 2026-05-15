package defpackage;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XX0 extends ConnectivityManager.NetworkCallback {
    public LinkProperties a;
    public NetworkCapabilities b;
    public final /* synthetic */ C0908jY0 c;

    public XX0(C0908jY0 c0908jY0) {
        this.c = c0908jY0;
    }

    public final gY0 a(Network network) {
        int i;
        int subtype;
        int type;
        if (!this.b.hasTransport(1) && !this.b.hasTransport(5)) {
            boolean zHasTransport = this.b.hasTransport(0);
            C0908jY0 c0908jY0 = this.c;
            if (zHasTransport) {
                NetworkInfo networkInfoF = c0908jY0.g.f(network);
                subtype = networkInfoF != null ? networkInfoF.getSubtype() : -1;
                i = 0;
            } else {
                if (this.b.hasTransport(3)) {
                    type = 9;
                } else if (this.b.hasTransport(2)) {
                    type = 7;
                } else if (this.b.hasTransport(4)) {
                    NetworkInfo networkInfoD = c0908jY0.g.d(network);
                    type = networkInfoD != null ? networkInfoD.getType() : 17;
                } else {
                    i = -1;
                    subtype = -1;
                }
                i = type;
            }
            return new gY0(true, i, subtype, !this.b.hasCapability(11), String.valueOf(network.getNetworkHandle()), this.a.isPrivateDnsActive(), this.a.getPrivateDnsServerName());
        }
        i = 1;
        subtype = -1;
        return new gY0(true, i, subtype, !this.b.hasCapability(11), String.valueOf(network.getNetworkHandle()), this.a.isPrivateDnsActive(), this.a.getPrivateDnsServerName());
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.a = null;
        this.b = null;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        this.b = networkCapabilities;
        C0908jY0 c0908jY0 = this.c;
        if (!c0908jY0.j || this.a == null || networkCapabilities == null) {
            return;
        }
        c0908jY0.c(a(network));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        this.a = linkProperties;
        C0908jY0 c0908jY0 = this.c;
        if (!c0908jY0.j || linkProperties == null || this.b == null) {
            return;
        }
        c0908jY0.c(a(network));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.a = null;
        this.b = null;
        C0908jY0 c0908jY0 = this.c;
        if (c0908jY0.j) {
            c0908jY0.c(new gY0(false, -1, -1, false, null, false, ""));
        }
    }
}
