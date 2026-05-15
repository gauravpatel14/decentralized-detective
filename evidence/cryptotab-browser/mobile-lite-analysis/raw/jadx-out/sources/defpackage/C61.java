package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class C61 {
    public static final char[] a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder((bArr.length * 3) - 1);
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] & 240) >>> 4;
            char[] cArr = a;
            sb.append(cArr[i2]);
            sb.append(cArr[bArr[i] & 15]);
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static ArrayList b(String str) {
        PackageInfo packageInfoC = c(str, 64);
        if (packageInfoC == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(packageInfoC.signatures.length);
        for (Signature signature : packageInfoC.signatures) {
            try {
                arrayList.add(a(MessageDigest.getInstance("SHA256").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()))).getEncoded())));
            } catch (NoSuchAlgorithmException | CertificateException e) {
                Log.w("cr_PackageUtils", "Exception", e);
                return null;
            }
        }
        return arrayList;
    }

    public static PackageInfo c(String str, int i) {
        try {
            return AbstractC1499tM.a.getPackageManager().getPackageInfo(str, i);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int d(String str) {
        PackageInfo packageInfoC = c(str, 0);
        if (packageInfoC != null) {
            return packageInfoC.versionCode;
        }
        return -1;
    }

    public static boolean e(String str) {
        return c(str, 0) != null;
    }
}
