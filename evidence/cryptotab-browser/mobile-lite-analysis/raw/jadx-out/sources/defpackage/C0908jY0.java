package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import java.util.Arrays;
import org.chromium.net.NetworkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter;

/* JADX INFO: renamed from: jY0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0908jY0 extends BroadcastReceiver {
    public static final /* synthetic */ int o = 0;
    public final Looper a;
    public final Handler b;
    public final NetworkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter c;
    public final hY0 d;
    public final iY0 e;
    public ConnectivityManager.NetworkCallback f;
    public final YX0 g;
    public fY0 h;
    public final NetworkRequest i;
    public boolean j;
    public gY0 k;
    public boolean l;
    public final boolean m;
    public boolean n;

    public C0908jY0(hY0 hy0, iY0 iy0) {
        Trace.beginSection("NetworkChangeNotifierAutoDetect.constructor");
        try {
            Looper looperMyLooper = Looper.myLooper();
            this.a = looperMyLooper;
            this.b = new Handler(looperMyLooper);
            this.d = hy0;
            this.g = new YX0(AbstractC1499tM.a);
            int i = Build.VERSION.SDK_INT;
            this.h = new fY0(this);
            this.i = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
            if (i >= 30) {
                this.f = new XX0(this);
            } else {
                this.f = i >= 28 ? new ZX0(this) : null;
            }
            i();
            NetworkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter networkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter = new NetworkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter();
            networkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.c = networkChangeNotifierAutoDetect$NetworkConnectivityIntentFilter;
            this.l = false;
            this.m = false;
            this.e = iy0;
            iy0.b(this);
            this.m = true;
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(int r4, int r5) {
        /*
            r0 = 0
            r1 = 4
            r2 = 5
            if (r4 == 0) goto L1f
            r3 = 1
            if (r4 == r3) goto L1d
            if (r4 == r1) goto L1f
            if (r4 == r2) goto L1f
            r5 = 6
            if (r4 == r5) goto L1b
            r5 = 7
            if (r4 == r5) goto L19
            r5 = 9
            if (r4 == r5) goto L17
            goto L2d
        L17:
            r0 = r3
            goto L2d
        L19:
            r0 = r5
            goto L2d
        L1b:
            r0 = r2
            goto L2d
        L1d:
            r0 = 2
            goto L2d
        L1f:
            r4 = 20
            if (r5 == r4) goto L2b
            switch(r5) {
                case 1: goto L29;
                case 2: goto L29;
                case 3: goto L27;
                case 4: goto L29;
                case 5: goto L27;
                case 6: goto L27;
                case 7: goto L29;
                case 8: goto L27;
                case 9: goto L27;
                case 10: goto L27;
                case 11: goto L29;
                case 12: goto L27;
                case 13: goto L1b;
                case 14: goto L27;
                case 15: goto L27;
                default: goto L26;
            }
        L26:
            goto L2d
        L27:
            r0 = r1
            goto L2d
        L29:
            r0 = 3
            goto L2d
        L2b:
            r0 = 8
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0908jY0.a(int, int):int");
    }

    public static Network[] d(YX0 yx0, Network network) {
        NetworkCapabilities networkCapabilitiesC;
        Network[] allNetworks = yx0.a.getAllNetworks();
        if (allNetworks == null) {
            allNetworks = new Network[0];
        }
        int i = 0;
        for (Network network2 : allNetworks) {
            if (!network2.equals(network) && (networkCapabilitiesC = yx0.c(network2)) != null && networkCapabilitiesC.hasCapability(12)) {
                if (!networkCapabilitiesC.hasTransport(4)) {
                    allNetworks[i] = network2;
                    i++;
                } else if (YX0.g(network2)) {
                    return new Network[]{network2};
                }
            }
        }
        return (Network[]) Arrays.copyOf(allNetworks, i);
    }

    public final void b() {
        Trace.beginSection("NetworkChangeNotifierAutoDetect.connectionTypeChanged");
        try {
            c(this.g.e());
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.gY0 r7) {
        /*
            r6 = this;
            int r0 = r7.b()
            gY0 r1 = r6.k
            int r1 = r1.b()
            hY0 r2 = r6.d
            if (r0 != r1) goto L2c
            gY0 r0 = r6.k
            java.lang.String r0 = r0.e
            java.lang.String r1 = r7.e
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L2c
            gY0 r0 = r6.k
            boolean r1 = r0.f
            boolean r3 = r7.f
            if (r3 != r1) goto L2c
            java.lang.String r0 = r0.g
            java.lang.String r1 = r7.g
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L33
        L2c:
            int r0 = r7.b()
            r2.a(r0)
        L33:
            int r0 = r7.b()
            gY0 r1 = r6.k
            int r1 = r1.b()
            if (r0 != r1) goto L4b
            int r0 = r7.a()
            gY0 r1 = r6.k
            int r1 = r1.a()
            if (r0 == r1) goto L52
        L4b:
            int r0 = r7.a()
            r2.c(r0)
        L52:
            r0 = 1
            r1 = 2
            boolean r3 = r7.d
            if (r3 == 0) goto L5a
            r4 = r1
            goto L5b
        L5a:
            r4 = r0
        L5b:
            gY0 r5 = r6.k
            boolean r5 = r5.d
            if (r5 == 0) goto L63
            r5 = r1
            goto L64
        L63:
            r5 = r0
        L64:
            if (r4 == r5) goto L6c
            if (r3 == 0) goto L69
            r0 = r1
        L69:
            r2.d(r0)
        L6c:
            r6.k = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0908jY0.c(gY0):void");
    }

    public final gY0 e() {
        Trace.beginSection("NetworkChangeNotifierAutoDetect.getCurrentNetworkState");
        try {
            gY0 gy0 = this.k;
            Trace.endSection();
            return gy0;
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final long[] f() {
        YX0 yx0 = this.g;
        Trace.beginSection("NetworkChangeNotifierAutoDetect.getNetworksAndTypes");
        try {
            Network[] networkArrD = d(yx0, null);
            long[] jArr = new long[networkArrD.length * 2];
            int i = 0;
            for (Network network : networkArrD) {
                int i2 = i + 1;
                jArr[i] = network.getNetworkHandle();
                i += 2;
                jArr[i2] = yx0.a(r6);
            }
            Trace.endSection();
            return jArr;
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final void g(final Runnable runnable) {
        if (this.a == Looper.myLooper()) {
            runnable.run();
        } else {
            this.b.post(new Runnable() { // from class: VX0
                @Override // java.lang.Runnable
                public final void run() {
                    if (this.t.j) {
                        runnable.run();
                    }
                }
            });
        }
    }

    public final void h() {
        int i = AbstractC1872zv.a;
        if (this.j) {
            this.j = false;
            fY0 fy0 = this.h;
            YX0 yx0 = this.g;
            if (fy0 != null) {
                yx0.a.unregisterNetworkCallback(fy0);
            }
            ConnectivityManager.NetworkCallback networkCallback = this.f;
            if (networkCallback != null) {
                yx0.a.unregisterNetworkCallback(networkCallback);
            } else {
                AbstractC1499tM.a.unregisterReceiver(this);
            }
        }
    }

    public final void i() {
        Trace.beginSection("NetworkChangeNotifierAutoDetect.updateCurrentNetworkState");
        try {
            this.k = this.g.e();
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        g(new WX0(this));
    }
}
