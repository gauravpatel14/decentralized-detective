package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Trace;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class iY0 {
    public C0908jY0 t;

    public abstract void a();

    public abstract void b(C0908jY0 c0908jY0);

    public final void c() {
        C0908jY0 c0908jY0 = this.t;
        c0908jY0.getClass();
        Trace.beginSection("NetworkChangeNotifierAutoDetect.register");
        try {
            int i = AbstractC1872zv.a;
            if (c0908jY0.j) {
                c0908jY0.b();
            } else {
                boolean z = c0908jY0.m;
                if (z) {
                    c0908jY0.b();
                }
                ConnectivityManager.NetworkCallback networkCallback = c0908jY0.f;
                Handler handler = c0908jY0.b;
                YX0 yx0 = c0908jY0.g;
                if (networkCallback != null) {
                    try {
                        yx0.a.registerDefaultNetworkCallback(networkCallback, handler);
                    } catch (RuntimeException unused) {
                        c0908jY0.f = null;
                    }
                }
                if (c0908jY0.f == null) {
                    c0908jY0.l = AbstractC1499tM.d(AbstractC1499tM.a, c0908jY0, c0908jY0.c) != null;
                }
                c0908jY0.j = true;
                fY0 fy0 = c0908jY0.h;
                if (fy0 != null) {
                    fy0.b();
                    try {
                        NetworkRequest networkRequest = c0908jY0.i;
                        fY0 fy02 = c0908jY0.h;
                        yx0.getClass();
                        LP1 lp1C = LP1.c();
                        try {
                            yx0.a.registerNetworkCallback(networkRequest, fy02, handler);
                            lp1C.close();
                        } catch (Throwable th) {
                            try {
                                lp1C.close();
                            } catch (Throwable unused2) {
                            }
                            throw th;
                        }
                    } catch (RuntimeException unused3) {
                        c0908jY0.n = true;
                        c0908jY0.h = null;
                    }
                    if (!c0908jY0.n && z) {
                        Network[] networkArrD = C0908jY0.d(yx0, null);
                        long[] jArr = new long[networkArrD.length];
                        for (int i2 = 0; i2 < networkArrD.length; i2++) {
                            jArr[i2] = networkArrD[i2].getNetworkHandle();
                        }
                        c0908jY0.d.e(jArr);
                    }
                }
            }
        } finally {
            try {
                Trace.endSection();
            } catch (Throwable unused4) {
            }
        }
    }
}
