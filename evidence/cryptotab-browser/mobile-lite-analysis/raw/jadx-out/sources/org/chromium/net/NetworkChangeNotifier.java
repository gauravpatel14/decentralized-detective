package org.chromium.net;

import J.N;
import android.net.Network;
import android.os.Trace;
import defpackage.AbstractC1872zv;
import defpackage.C0908jY0;
import defpackage.C1054lt1;
import defpackage.L21;
import defpackage.M21;
import defpackage.TX0;
import defpackage.UX0;
import defpackage.gY0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class NetworkChangeNotifier {
    public static NetworkChangeNotifier f;
    public C0908jY0 c;
    public int d = 0;
    public int e = 0;
    public final ArrayList a = new ArrayList();
    public final M21 b = new M21();

    public static boolean a() {
        return f.getCurrentConnectionType() != 6;
    }

    public static void e(UX0 ux0) {
        f.b.g(ux0);
    }

    public static void fakeConnectionCostChanged(int i) {
        setAutoDetectConnectivityState(false);
        f.b(i);
    }

    public static void fakeConnectionSubtypeChanged(int i) {
        setAutoDetectConnectivityState(false);
        f.c(i);
    }

    public static void fakeDefaultNetwork(long j, int i) {
        setAutoDetectConnectivityState(false);
        f.d(i, j);
    }

    public static void fakeNetworkConnected(long j, int i) {
        setAutoDetectConnectivityState(false);
        NetworkChangeNotifier networkChangeNotifier = f;
        Iterator it = networkChangeNotifier.a.iterator();
        while (it.hasNext()) {
            N._V_IJJO(12, i, ((Long) it.next()).longValue(), j, networkChangeNotifier);
        }
    }

    public static void fakeNetworkDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        NetworkChangeNotifier networkChangeNotifier = f;
        Iterator it = networkChangeNotifier.a.iterator();
        while (it.hasNext()) {
            N._V_JJO(13, ((Long) it.next()).longValue(), j, networkChangeNotifier);
        }
    }

    public static void fakeNetworkSoonToBeDisconnected(long j) {
        setAutoDetectConnectivityState(false);
        NetworkChangeNotifier networkChangeNotifier = f;
        Iterator it = networkChangeNotifier.a.iterator();
        while (it.hasNext()) {
            N._V_JJO(14, ((Long) it.next()).longValue(), j, networkChangeNotifier);
        }
    }

    public static void fakePurgeActiveNetworkList(long[] jArr) {
        setAutoDetectConnectivityState(false);
        NetworkChangeNotifier networkChangeNotifier = f;
        Iterator it = networkChangeNotifier.a.iterator();
        while (it.hasNext()) {
            N._V_JOO(115, ((Long) it.next()).longValue(), networkChangeNotifier, jArr);
        }
    }

    public static void forceConnectivityState(boolean z) {
        setAutoDetectConnectivityState(false);
        NetworkChangeNotifier networkChangeNotifier = f;
        if ((networkChangeNotifier.d != 6) != z) {
            int i = z ? 0 : 6;
            networkChangeNotifier.d = i;
            networkChangeNotifier.d(i, networkChangeNotifier.getCurrentDefaultNetId());
            networkChangeNotifier.c(!z ? 1 : 0);
        }
    }

    public static NetworkChangeNotifier init() {
        if (f == null) {
            f = new NetworkChangeNotifier();
        }
        return f;
    }

    public static void setAutoDetectConnectivityState(boolean z) {
        NetworkChangeNotifier networkChangeNotifier = f;
        C1054lt1 c1054lt1 = new C1054lt1();
        networkChangeNotifier.getClass();
        Trace.beginSection("NetworkChangeNotifier.setAutoDetectConnectivityStateInternal");
        try {
            if (!z) {
                C0908jY0 c0908jY0 = networkChangeNotifier.c;
                if (c0908jY0 != null) {
                    int i = AbstractC1872zv.a;
                    c0908jY0.e.a();
                    c0908jY0.h();
                    networkChangeNotifier.c = null;
                }
            } else if (networkChangeNotifier.c == null) {
                C0908jY0 c0908jY02 = new C0908jY0(new TX0(networkChangeNotifier), c1054lt1);
                networkChangeNotifier.c = c0908jY02;
                c0908jY02.i();
                gY0 gy0E = networkChangeNotifier.c.e();
                int iB = gy0E.b();
                networkChangeNotifier.d = iB;
                networkChangeNotifier.d(iB, networkChangeNotifier.getCurrentDefaultNetId());
                int i2 = gy0E.d ? 2 : 1;
                networkChangeNotifier.e = i2;
                networkChangeNotifier.b(i2);
                networkChangeNotifier.c(gy0E.a());
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

    public void addNativeObserver(long j) {
        this.a.add(Long.valueOf(j));
    }

    public final void b(int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            N._V_IJO(54, i, ((Long) it.next()).longValue(), this);
        }
    }

    public final void c(int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            N._V_IJO(55, i, ((Long) it.next()).longValue(), this);
        }
    }

    public final void d(int i, long j) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            N._V_IJJO(11, i, ((Long) it.next()).longValue(), j, this);
        }
        Iterator it2 = this.b.iterator();
        while (true) {
            L21 l21 = (L21) it2;
            if (!l21.hasNext()) {
                return;
            } else {
                ((UX0) l21.next()).a(i);
            }
        }
    }

    public int getCurrentConnectionCost() {
        return this.e;
    }

    /* JADX WARN: Finally extract failed */
    public int getCurrentConnectionSubtype() {
        Trace.beginSection("NetworkChangeNotifier.getCurrentConnectionSubtype");
        try {
            C0908jY0 c0908jY0 = this.c;
            if (c0908jY0 == null) {
                Trace.endSection();
                return 0;
            }
            c0908jY0.i();
            int iA = this.c.e().a();
            Trace.endSection();
            return iA;
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public int getCurrentConnectionType() {
        return this.d;
    }

    public long getCurrentDefaultNetId() {
        Network networkB;
        C0908jY0 c0908jY0 = this.c;
        if (c0908jY0 == null || (networkB = c0908jY0.g.b()) == null) {
            return -1L;
        }
        return networkB.getNetworkHandle();
    }

    public long[] getCurrentNetworksAndTypes() {
        Trace.beginSection("NetworkChangeNotifierAutoDetect.getCurrentNetworksAndTypes");
        try {
            C0908jY0 c0908jY0 = this.c;
            long[] jArrF = c0908jY0 == null ? new long[0] : c0908jY0.f();
            Trace.endSection();
            return jArrF;
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public boolean registerNetworkCallbackFailed() {
        C0908jY0 c0908jY0 = this.c;
        if (c0908jY0 == null) {
            return false;
        }
        return c0908jY0.n;
    }

    public void removeNativeObserver(long j) {
        this.a.remove(Long.valueOf(j));
    }
}
