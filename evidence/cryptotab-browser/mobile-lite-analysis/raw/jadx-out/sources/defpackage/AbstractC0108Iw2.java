package defpackage;

import J.N;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.util.Log;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.chromium.net.AndroidCertVerifyResult;

/* JADX INFO: renamed from: Iw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0108Iw2 {
    public static CertificateFactory a;
    public static X509TrustManagerExtensions b;
    public static C0096Hw2 c;
    public static X509TrustManagerExtensions d;
    public static KeyStore e;
    public static KeyStore f;
    public static File g;
    public static HashSet h;
    public static boolean i;
    public static final Object j = new Object();
    public static final char[] k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a() {
        synchronized (j) {
            b = null;
            h = null;
            c();
        }
        N._V(39);
    }

    public static X509TrustManagerExtensions b(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        try {
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    try {
                        return new X509TrustManagerExtensions((X509TrustManager) trustManager);
                    } catch (IllegalArgumentException e2) {
                        Log.e("cr_X509Util", "Error creating trust manager (" + trustManager.getClass().getName() + "): " + e2);
                    }
                }
            }
            Log.e("cr_X509Util", "Could not find suitable trust manager");
            return null;
        } catch (RuntimeException e3) {
            Log.e("cr_X509Util", "TrustManagerFactory.getTrustManagers() unexpectedly threw: %s", e3);
            throw new KeyStoreException(e3);
        }
    }

    public static void c() throws NoSuchAlgorithmException, CertificateException {
        if (a == null) {
            a = CertificateFactory.getInstance("X.509");
        }
        if (b == null) {
            b = b(null);
        }
        if (!i) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
                f = keyStore;
                try {
                    keyStore.load(null);
                } catch (IOException unused) {
                }
                g = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
            } catch (KeyStoreException unused2) {
            }
            i = true;
        }
        if (h == null) {
            h = new HashSet();
        }
        if (c == null) {
            c = new C0096Hw2();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.security.action.KEYCHAIN_CHANGED");
            intentFilter.addAction("android.security.action.KEY_ACCESS_CHANGED");
            intentFilter.addAction("android.security.action.TRUST_STORE_CHANGED");
            AbstractC1499tM.d(AbstractC1499tM.a, c, intentFilter);
        }
    }

    public static void d() throws NoSuchAlgorithmException, KeyStoreException, CertificateException {
        if (e == null) {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            e = keyStore;
            try {
                keyStore.load(null);
            } catch (IOException unused) {
            }
        }
        if (d == null) {
            d = b(e);
        }
    }

    public static boolean e(X509Certificate x509Certificate) throws KeyStoreException {
        if (f == null) {
            return false;
        }
        Pair pair = new Pair(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
        if (h.contains(pair)) {
            return true;
        }
        byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(x509Certificate.getSubjectX500Principal().getEncoded());
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 2;
            char[] cArr2 = k;
            byte b2 = bArrDigest[3 - i2];
            cArr[i3] = cArr2[(b2 >> 4) & 15];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        String str = new String(cArr);
        int i4 = 0;
        while (true) {
            String str2 = str + "." + i4;
            if (!new File(g, str2).exists()) {
                return false;
            }
            Certificate certificate = f.getCertificate("system:" + str2);
            if (certificate != null) {
                if (certificate instanceof X509Certificate) {
                    X509Certificate x509Certificate2 = (X509Certificate) certificate;
                    if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                        h.add(pair);
                        return true;
                    }
                } else {
                    Log.e("cr_X509Util", "Anchor " + str2 + " not an X509Certificate: " + certificate.getClass().getName());
                }
            }
            i4++;
        }
    }

    public static boolean f(X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> extendedKeyUsage;
        try {
            extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
        } catch (NullPointerException unused) {
        }
        if (extendedKeyUsage == null) {
            return true;
        }
        for (String str : extendedKeyUsage) {
            if (str.equals("1.3.6.1.5.5.7.3.1") || str.equals("2.5.29.37.0") || str.equals("2.16.840.1.113730.4.1") || str.equals("1.3.6.1.4.1.311.10.3.3")) {
                return true;
            }
        }
        return false;
    }

    public static AndroidCertVerifyResult g(byte[][] bArr, String str, String str2) {
        List<X509Certificate> listCheckServerTrusted;
        if (bArr != null && bArr.length != 0) {
            if (bArr[0] != null) {
                try {
                    Object obj = j;
                    synchronized (obj) {
                        c();
                    }
                    ArrayList arrayList = new ArrayList();
                    try {
                        byte[] bArr2 = bArr[0];
                        synchronized (obj) {
                            c();
                        }
                        arrayList.add((X509Certificate) a.generateCertificate(new ByteArrayInputStream(bArr2)));
                        for (int i2 = 1; i2 < bArr.length; i2++) {
                            try {
                                byte[] bArr3 = bArr[i2];
                                synchronized (j) {
                                    c();
                                }
                                arrayList.add((X509Certificate) a.generateCertificate(new ByteArrayInputStream(bArr3)));
                            } catch (CertificateException unused) {
                                Log.w("cr_X509Util", "intermediate " + i2 + " failed parsing");
                            }
                        }
                        X509Certificate[] x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                        try {
                            x509CertificateArr[0].checkValidity();
                            if (!f(x509CertificateArr[0])) {
                                return new AndroidCertVerifyResult(-6);
                            }
                            synchronized (j) {
                                X509TrustManagerExtensions x509TrustManagerExtensions = b;
                                try {
                                } catch (CertificateException e2) {
                                    X509TrustManagerExtensions x509TrustManagerExtensions2 = d;
                                    if (x509TrustManagerExtensions2 != null) {
                                        try {
                                            listCheckServerTrusted = x509TrustManagerExtensions2.checkServerTrusted(x509CertificateArr, str, str2);
                                        } catch (RuntimeException e3) {
                                            Log.e("cr_X509Util", "checkServerTrusted() unexpectedly threw: %s", e3);
                                            throw new CertificateException(e3);
                                        }
                                    } else {
                                        listCheckServerTrusted = null;
                                    }
                                    if (listCheckServerTrusted == null) {
                                        Log.i("cr_X509Util", "Failed to validate the certificate chain, error: " + e2.getMessage());
                                        return new AndroidCertVerifyResult(-2);
                                    }
                                }
                                if (x509TrustManagerExtensions == null) {
                                    return new AndroidCertVerifyResult(-1);
                                }
                                try {
                                    listCheckServerTrusted = x509TrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, str2);
                                    return new AndroidCertVerifyResult(listCheckServerTrusted, listCheckServerTrusted.size() > 0 ? e(listCheckServerTrusted.get(listCheckServerTrusted.size() - 1)) : false);
                                } catch (RuntimeException e4) {
                                    Log.e("cr_X509Util", "checkServerTrusted() unexpectedly threw: %s", e4);
                                    throw new CertificateException(e4);
                                }
                            }
                        } catch (CertificateExpiredException unused2) {
                            return new AndroidCertVerifyResult(-3);
                        } catch (CertificateNotYetValidException unused3) {
                            return new AndroidCertVerifyResult(-4);
                        } catch (CertificateException unused4) {
                            return new AndroidCertVerifyResult(-1);
                        }
                    } catch (CertificateException unused5) {
                        return new AndroidCertVerifyResult(-5);
                    }
                } catch (CertificateException unused6) {
                    return new AndroidCertVerifyResult(-1);
                }
            }
        }
        throw new IllegalArgumentException(Xd0.a("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=", Arrays.deepToString(bArr)));
    }
}
