package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import java.io.IOException;
import java.net.Socket;
import org.chromium.base.ApplicationStatus;
import org.chromium.net.AndroidNetworkLibrary;
import org.chromium.net.DnsStatus;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YX0 {
    public final ConnectivityManager a;

    public YX0(Context context) {
        this.a = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static boolean g(Network network) {
        Socket socket = new Socket();
        try {
            LP1 lp1B = LP1.b();
            try {
                try {
                    network.bindSocket(socket);
                    lp1B.close();
                    try {
                        socket.close();
                        return true;
                    } catch (IOException unused) {
                        return true;
                    }
                } catch (Throwable th) {
                    try {
                        lp1B.close();
                    } catch (Throwable unused2) {
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                return false;
            }
        } catch (IOException unused4) {
            socket.close();
            return false;
        } catch (Throwable th2) {
            try {
                socket.close();
            } catch (IOException unused5) {
            }
            throw th2;
        }
    }

    public final int a(Network network) {
        NetworkInfo networkInfoD = d(network);
        if (networkInfoD == null || !networkInfoD.isConnected()) {
            return 6;
        }
        return C0908jY0.a(networkInfoD.getType(), networkInfoD.getSubtype());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.net.Network b() {
        /*
            r10 = this;
            android.net.ConnectivityManager r0 = r10.a
            android.net.Network r1 = r0.getActiveNetwork()
            if (r1 == 0) goto L9
            return r1
        L9:
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            r2 = 0
            if (r0 != 0) goto L11
            return r2
        L11:
            android.net.Network[] r3 = defpackage.C0908jY0.d(r10, r2)
            int r4 = r3.length
            r5 = 0
        L17:
            if (r5 >= r4) goto L66
            r6 = r3[r5]
            android.net.NetworkInfo r7 = r10.f(r6)
            if (r7 == 0) goto L63
            int r8 = r7.getType()
            int r9 = r0.getType()
            if (r8 == r9) goto L33
            int r8 = r7.getType()
            r9 = 17
            if (r8 != r9) goto L63
        L33:
            if (r1 == 0) goto L51
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 29
            if (r8 < r9) goto L51
            android.net.NetworkInfo$DetailedState r7 = r7.getDetailedState()
            android.net.NetworkInfo$DetailedState r8 = android.net.NetworkInfo.DetailedState.CONNECTING
            if (r7 != r8) goto L44
            goto L63
        L44:
            android.net.NetworkInfo r7 = r10.f(r1)
            if (r7 == 0) goto L51
            android.net.NetworkInfo$DetailedState r7 = r7.getDetailedState()
            if (r7 != r8) goto L51
            r1 = r2
        L51:
            if (r1 == 0) goto L62
            int r1 = defpackage.C0908jY0.o
            java.lang.String r1 = "cr_"
            java.lang.String r7 = "jY0"
            java.lang.String r1 = r1.concat(r7)
            java.lang.String r7 = "There should not be multiple connected networks of the same type. At least as of Android Marshmallow this is not supported. If this becomes supported this assertion may trigger."
            android.util.Log.e(r1, r7)
        L62:
            r1 = r6
        L63:
            int r5 = r5 + 1
            goto L17
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.YX0.b():android.net.Network");
    }

    public final NetworkCapabilities c(Network network) {
        for (int i = 0; i < 2; i++) {
            try {
                return this.a.getNetworkCapabilities(network);
            } catch (SecurityException unused) {
            }
        }
        return null;
    }

    public final NetworkInfo d(Network network) {
        NetworkInfo networkInfoF = f(network);
        return (networkInfoF == null || networkInfoF.getType() != 17) ? networkInfoF : this.a.getActiveNetworkInfo();
    }

    public final gY0 e() {
        Network networkB = b();
        NetworkInfo networkInfoD = d(networkB);
        if (networkInfoD == null || (!networkInfoD.isConnected() && (networkInfoD.getDetailedState() != NetworkInfo.DetailedState.BLOCKED || ApplicationStatus.getStateForApplication() != 1))) {
            networkInfoD = null;
        }
        if (networkInfoD == null) {
            return new gY0(false, -1, -1, false, null, false, "");
        }
        if (networkB != null) {
            NetworkCapabilities networkCapabilitiesC = c(networkB);
            boolean z = (networkCapabilitiesC == null || networkCapabilitiesC.hasCapability(11)) ? false : true;
            DnsStatus dnsStatusA = AndroidNetworkLibrary.a(networkB);
            return dnsStatusA == null ? new gY0(true, networkInfoD.getType(), networkInfoD.getSubtype(), z, String.valueOf(networkB.getNetworkHandle()), false, "") : new gY0(true, networkInfoD.getType(), networkInfoD.getSubtype(), z, String.valueOf(networkB.getNetworkHandle()), dnsStatusA.getPrivateDnsActive(), dnsStatusA.getPrivateDnsServerName());
        }
        if (networkInfoD.getType() != 1) {
            return new gY0(true, networkInfoD.getType(), networkInfoD.getSubtype(), false, null, false, "");
        }
        if (networkInfoD.getExtraInfo() != null && !"".equals(networkInfoD.getExtraInfo())) {
            return new gY0(true, networkInfoD.getType(), networkInfoD.getSubtype(), false, networkInfoD.getExtraInfo(), false, "");
        }
        networkInfoD.getType();
        networkInfoD.getSubtype();
        throw null;
    }

    public final NetworkInfo f(Network network) {
        ConnectivityManager connectivityManager = this.a;
        try {
            try {
                return connectivityManager.getNetworkInfo(network);
            } catch (NullPointerException unused) {
                return null;
            }
        } catch (NullPointerException unused2) {
            return connectivityManager.getNetworkInfo(network);
        }
    }
}
