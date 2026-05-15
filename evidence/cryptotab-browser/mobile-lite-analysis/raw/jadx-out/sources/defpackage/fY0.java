package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Trace;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class fY0 extends ConnectivityManager.NetworkCallback {
    public Network a;
    public final /* synthetic */ C0908jY0 b;

    public fY0(C0908jY0 c0908jY0) {
        this.b = c0908jY0;
    }

    public final boolean a(Network network, NetworkCapabilities networkCapabilities) {
        Network network2 = this.a;
        if ((network2 == null || network2.equals(network)) && networkCapabilities != null) {
            if (networkCapabilities.hasTransport(4)) {
                this.b.g.getClass();
                if (!YX0.g(network)) {
                }
            }
            return false;
        }
        return true;
    }

    public final void b() {
        NetworkCapabilities networkCapabilitiesC;
        C0908jY0 c0908jY0 = this.b;
        Trace.beginSection("NetworkChangeNotifierAutoDetect.initializeVpnInPlace");
        try {
            Network[] networkArrD = C0908jY0.d(c0908jY0.g, null);
            this.a = null;
            if (networkArrD.length == 1 && (networkCapabilitiesC = c0908jY0.g.c(networkArrD[0])) != null && networkCapabilitiesC.hasTransport(4)) {
                this.a = networkArrD[0];
            }
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        Network network2;
        C0908jY0 c0908jY0 = this.b;
        TraceEvent traceEventJ = TraceEvent.j("NetworkChangeNotifierCallback::onAvailable", null);
        try {
            NetworkCapabilities networkCapabilitiesC = c0908jY0.g.c(network);
            if (a(network, networkCapabilitiesC)) {
                if (traceEventJ != null) {
                    traceEventJ.close();
                    return;
                }
                return;
            }
            boolean z = networkCapabilitiesC.hasTransport(4) && ((network2 = this.a) == null || !network.equals(network2));
            if (z) {
                this.a = network;
            }
            c0908jY0.g(new aY0(this, network.getNetworkHandle(), c0908jY0.g.a(network), z));
            if (traceEventJ != null) {
                traceEventJ.close();
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        C0908jY0 c0908jY0 = this.b;
        TraceEvent traceEventJ = TraceEvent.j("NetworkChangeNotifierCallback::onCapabilitiesChanged", null);
        try {
            if (a(network, networkCapabilities)) {
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
            } else {
                c0908jY0.g(new bY0(this, network.getNetworkHandle(), c0908jY0.g.a(network)));
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLosing(Network network, int i) {
        C0908jY0 c0908jY0 = this.b;
        TraceEvent traceEventJ = TraceEvent.j("NetworkChangeNotifierCallback::onLosing", null);
        try {
            if (a(network, c0908jY0.g.c(network))) {
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
            } else {
                c0908jY0.g(new cY0(this, network.getNetworkHandle()));
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        C0908jY0 c0908jY0 = this.b;
        TraceEvent traceEventJ = TraceEvent.j("NetworkChangeNotifierCallback::onLost", null);
        try {
            Network network2 = this.a;
            if (network2 != null && !network2.equals(network)) {
                if (traceEventJ != null) {
                    traceEventJ.close();
                    return;
                }
                return;
            }
            c0908jY0.g(new dY0(this, network));
            if (this.a != null) {
                this.a = null;
                for (Network network3 : C0908jY0.d(c0908jY0.g, network)) {
                    onAvailable(network3);
                }
                c0908jY0.i();
                c0908jY0.g(new eY0(this, c0908jY0.e().b()));
            }
            if (traceEventJ != null) {
                traceEventJ.close();
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
