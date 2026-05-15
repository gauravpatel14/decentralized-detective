package org.chromium.net;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.Log;
import defpackage.AbstractC0108Iw2;
import defpackage.AbstractC0911ja;
import defpackage.AbstractC1499tM;
import defpackage.U7;
import defpackage.b92;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLConnection;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AndroidNetworkLibrary {
    public static Boolean a;
    public static Boolean b;

    public static DnsStatus a(Network network) {
        ConnectivityManager connectivityManager;
        if (a == null) {
            a = Boolean.valueOf(AbstractC0911ja.a(AbstractC1499tM.a, Process.myPid(), Process.myUid(), "android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!a.booleanValue() || (connectivityManager = (ConnectivityManager) AbstractC1499tM.a.getSystemService("connectivity")) == null) {
            return null;
        }
        if (network == null) {
            network = connectivityManager.getActiveNetwork();
        }
        if (network == null) {
            return null;
        }
        try {
            LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
            if (linkProperties == null) {
                return null;
            }
            List<InetAddress> dnsServers = linkProperties.getDnsServers();
            String domains = linkProperties.getDomains();
            return Build.VERSION.SDK_INT >= 28 ? new DnsStatus(dnsServers, linkProperties.isPrivateDnsActive(), linkProperties.getPrivateDnsServerName(), domains) : new DnsStatus(dnsServers, false, "", domains);
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static void addTestRootCertificate(byte[] bArr) {
        Object obj = AbstractC0108Iw2.j;
        synchronized (obj) {
            AbstractC0108Iw2.c();
        }
        X509Certificate x509Certificate = (X509Certificate) AbstractC0108Iw2.a.generateCertificate(new ByteArrayInputStream(bArr));
        synchronized (obj) {
            AbstractC0108Iw2.d();
            KeyStore keyStore = AbstractC0108Iw2.e;
            keyStore.setCertificateEntry("root_cert_" + Integer.toString(keyStore.size()), x509Certificate);
            AbstractC0108Iw2.d();
            AbstractC0108Iw2.d = AbstractC0108Iw2.b(AbstractC0108Iw2.e);
        }
    }

    public static WifiInfo b() {
        TransportInfo transportInfo;
        if (!c()) {
            Intent intentD = AbstractC1499tM.d(AbstractC1499tM.a, null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
            if (intentD != null) {
                return (WifiInfo) intentD.getParcelableExtra("wifiInfo");
            }
            return null;
        }
        if (Build.VERSION.SDK_INT < 31) {
            return ((WifiManager) AbstractC1499tM.a.getSystemService("wifi")).getConnectionInfo();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) AbstractC1499tM.a.getSystemService("connectivity");
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasTransport(1) && (transportInfo = networkCapabilities.getTransportInfo()) != null && (transportInfo instanceof WifiInfo)) {
                return (WifiInfo) transportInfo;
            }
        }
        return null;
    }

    public static boolean c() {
        if (b == null) {
            b = Boolean.valueOf(AbstractC0911ja.a(AbstractC1499tM.a, Process.myPid(), Process.myUid(), "android.permission.ACCESS_WIFI_STATE") == 0);
        }
        return b.booleanValue();
    }

    public static void clearTestRootCertificates() {
        synchronized (AbstractC0108Iw2.j) {
            AbstractC0108Iw2.d();
            try {
                AbstractC0108Iw2.e.load(null);
                AbstractC0108Iw2.d();
                AbstractC0108Iw2.d = AbstractC0108Iw2.b(AbstractC0108Iw2.e);
            } catch (IOException unused) {
            }
        }
    }

    public static DnsStatus getCurrentDnsStatus() {
        return a(null);
    }

    public static DnsStatus getDnsStatusForNetwork(long j) {
        try {
            return a(Network.fromNetworkHandle(j));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static boolean getIsCaptivePortal() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) AbstractC1499tM.a.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(17)) ? false : true;
    }

    public static boolean getIsRoaming() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AbstractC1499tM.a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isRoaming();
    }

    public static String getMimeTypeFromExtension(String str) {
        return URLConnection.guessContentTypeFromName("foo." + str);
    }

    public static String getNetworkOperator() {
        TelephonyManager telephonyManager = (TelephonyManager) AbstractC1499tM.a.getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getNetworkOperator();
    }

    public static byte[][] getUserAddedRoots() {
        ArrayList arrayList = new ArrayList();
        Object obj = AbstractC0108Iw2.j;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    AbstractC0108Iw2.c();
                }
            } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
                return new byte[0][];
            }
        }
        KeyStore keyStore = AbstractC0108Iw2.f;
        if (keyStore == null) {
            return new byte[0][];
        }
        try {
            Enumeration<String> enumerationAliases = keyStore.aliases();
            while (enumerationAliases.hasMoreElements()) {
                String strNextElement = enumerationAliases.nextElement();
                if (strNextElement.startsWith("user:")) {
                    try {
                        Certificate certificate = AbstractC0108Iw2.f.getCertificate(strNextElement);
                        if (certificate instanceof X509Certificate) {
                            arrayList.add(((X509Certificate) certificate).getEncoded());
                        } else {
                            Log.w("cr_X509Util", "alias: " + strNextElement + " is not a X509 Cert, skipping");
                        }
                    } catch (KeyStoreException e) {
                        Log.e("cr_X509Util", String.format(Locale.US, "Error reading cert with alias %s, error: %s", strNextElement), e);
                    } catch (CertificateEncodingException e2) {
                        Log.e("cr_X509Util", String.format(Locale.US, "Error encoding cert with alias %s, error: %s", strNextElement), e2);
                    }
                }
            }
            return (byte[][]) arrayList.toArray(new byte[0][]);
        } catch (KeyStoreException e3) {
            Log.e("cr_X509Util", "Error reading cert aliases: %s", e3);
            return new byte[0][];
        }
    }

    public static String getWifiSSID() {
        String ssid;
        WifiInfo wifiInfoB = b();
        return (wifiInfoB == null || (ssid = wifiInfoB.getSSID()) == null || ssid.equals("<unknown ssid>")) ? "" : ssid;
    }

    public static int getWifiSignalLevel(int i) {
        int intExtra;
        int iCalculateSignalLevel;
        Context context = AbstractC1499tM.a;
        if (context == null || context.getContentResolver() == null) {
            return -1;
        }
        if (c()) {
            WifiInfo wifiInfoB = b();
            if (wifiInfoB == null) {
                return -1;
            }
            intExtra = wifiInfoB.getRssi();
        } else {
            try {
                Intent intentD = AbstractC1499tM.d(AbstractC1499tM.a, null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
                if (intentD == null) {
                    return -1;
                }
                intExtra = intentD.getIntExtra("newRssi", Integer.MIN_VALUE);
            } catch (IllegalArgumentException unused) {
            }
        }
        if (intExtra != Integer.MIN_VALUE && (iCalculateSignalLevel = WifiManager.calculateSignalLevel(intExtra, i)) >= 0 && iCalculateSignalLevel < i) {
            return iCalculateSignalLevel;
        }
        return -1;
    }

    public static boolean haveOnlyLoopbackAddresses() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            Log.w("AndroidNetworkLibrary", "could not get network interfaces: " + e);
            return false;
        }
    }

    public static boolean isCleartextPermitted(String str) {
        try {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        } catch (IllegalArgumentException unused) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }
    }

    public static boolean reportBadDefaultNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) AbstractC1499tM.a.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        connectivityManager.reportNetworkConnectivity(null, false);
        return true;
    }

    public static void tagSocket(int i, int i2, int i3) throws IOException {
        int threadStatsTag = TrafficStats.getThreadStatsTag();
        if (i3 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(i3);
        }
        if (i2 != -1) {
            try {
                b92.a.invoke(null, Integer.valueOf(i2));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e2);
            }
        }
        ParcelFileDescriptor parcelFileDescriptorAdoptFd = ParcelFileDescriptor.adoptFd(i);
        U7 u7 = new U7(parcelFileDescriptorAdoptFd.getFileDescriptor());
        TrafficStats.tagSocket(u7);
        u7.close();
        parcelFileDescriptorAdoptFd.detachFd();
        if (i3 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(threadStatsTag);
        }
        if (i2 != -1) {
            try {
                b92.b.invoke(null, null);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e4);
            }
        }
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        try {
            return AbstractC0108Iw2.g(bArr, str, str2);
        } catch (IllegalArgumentException unused) {
            return new AndroidCertVerifyResult(-1);
        } catch (KeyStoreException unused2) {
            return new AndroidCertVerifyResult(-1);
        } catch (NoSuchAlgorithmException unused3) {
            return new AndroidCertVerifyResult(-1);
        }
    }
}
