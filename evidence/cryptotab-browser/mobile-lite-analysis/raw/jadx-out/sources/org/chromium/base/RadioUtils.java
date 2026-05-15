package org.chromium.base;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import defpackage.AbstractC0911ja;
import defpackage.AbstractC1499tM;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class RadioUtils {
    public static Boolean a;
    public static Boolean b;

    public static int getCellDataActivity() {
        TraceEvent traceEventJ = TraceEvent.j("RadioUtils::getCellDataActivity", null);
        try {
            try {
                int dataActivity = ((TelephonyManager) AbstractC1499tM.a.getSystemService("phone")).getDataActivity();
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
                return dataActivity;
            } catch (SecurityException unused) {
                if (traceEventJ == null) {
                    return -1;
                }
                traceEventJ.close();
                return -1;
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    public static int getCellSignalLevel() {
        TraceEvent traceEventJ = TraceEvent.j("RadioUtils::getCellSignalLevel", null);
        try {
            int level = -1;
            try {
                SignalStrength signalStrength = ((TelephonyManager) AbstractC1499tM.a.getSystemService("phone")).getSignalStrength();
                if (signalStrength != null) {
                    level = signalStrength.getLevel();
                }
            } catch (SecurityException unused) {
            }
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return level;
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean isSupported() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        if (a == null) {
            a = Boolean.valueOf(AbstractC0911ja.a(AbstractC1499tM.a, Process.myPid(), Process.myUid(), "android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!a.booleanValue()) {
            return false;
        }
        if (b == null) {
            b = Boolean.valueOf(AbstractC0911ja.a(AbstractC1499tM.a, Process.myPid(), Process.myUid(), "android.permission.ACCESS_WIFI_STATE") == 0);
        }
        return b.booleanValue();
    }

    public static boolean isWifiConnected() {
        TraceEvent traceEventJ = TraceEvent.j("RadioUtils::isWifiConnected", null);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) AbstractC1499tM.a.getSystemService("connectivity");
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
                return false;
            }
            boolean zHasTransport = networkCapabilities.hasTransport(1);
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return zHasTransport;
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
