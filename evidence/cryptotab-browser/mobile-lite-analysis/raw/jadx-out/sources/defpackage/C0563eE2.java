package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

/* JADX INFO: renamed from: eE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0563eE2 {
    public final C0576eN2 a;
    public final Context b;
    public final VD2 c;
    public PackageInfo d;

    public C0563eE2(Context context, C0576eN2 c0576eN2) {
        VD2 vd2 = new VD2();
        this.a = c0576eN2;
        this.b = context;
        this.c = vd2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        if (r5.a.getName().equals("manifest") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        r4 = r5.a.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCode");
        r5 = r5.a.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCodeMajor");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        if (r4 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
    
        r4 = java.lang.Integer.parseInt(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
    
        if (r5 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0088, code lost:
    
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        r4 = (((long) r4) & 4294967295L) | (((long) java.lang.Integer.parseInt(r5)) << 32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a0, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(defpackage.Xd0.a("Couldn't parse versionCodeMajor to int: ", r12.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(defpackage.Xd0.a("Couldn't parse versionCode to int: ", r12.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c9, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("Manifest entry doesn't contain 'versionCode' attribute.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.io.File[] r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0563eE2.a(java.io.File[]):boolean");
    }

    public final boolean b(File[] fileArr) {
        String absolutePath;
        X509Certificate x509Certificate;
        PackageInfo packageInfoC = c();
        ArrayList<X509Certificate> arrayList = null;
        if (packageInfoC != null && packageInfoC.signatures != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Signature signature : packageInfoC.signatures) {
                try {
                    x509Certificate = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                } catch (CertificateException e) {
                    Log.e("SplitCompat", "Cannot decode certificate.", e);
                    x509Certificate = null;
                }
                if (x509Certificate != null) {
                    arrayList2.add(x509Certificate);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            Log.e("SplitCompat", "No app certificates found.");
            return false;
        }
        int length = fileArr.length;
        loop1: while (true) {
            length--;
            if (length < 0) {
                return true;
            }
            try {
                absolutePath = fileArr[length].getAbsolutePath();
                try {
                    X509Certificate[][] x509CertificateArrA = WT2.a(absolutePath);
                    if (x509CertificateArrA == null || x509CertificateArrA.length == 0 || x509CertificateArrA[0].length == 0) {
                        break;
                    }
                    if (arrayList.isEmpty()) {
                        Log.e("SplitCompat", "No certificates found for app.");
                        break;
                    }
                    for (X509Certificate x509Certificate2 : arrayList) {
                        for (X509Certificate[] x509CertificateArr : x509CertificateArrA) {
                            int i = x509CertificateArr[0].equals(x509Certificate2) ? 0 : i + 1;
                        }
                        Log.i("SplitCompat", "There's an app certificate that doesn't sign the split.");
                    }
                } catch (Exception e2) {
                    Log.e("SplitCompat", "Downloaded split " + absolutePath + " is not signed.", e2);
                }
            } catch (Exception e3) {
                Log.e("SplitCompat", "Split verification error.", e3);
                return false;
            }
        }
        Log.e("SplitCompat", "Downloaded split " + absolutePath + " is not signed.");
        Log.e("SplitCompat", "Split verification failure.");
        return false;
    }

    public final PackageInfo c() {
        Context context = this.b;
        if (this.d == null) {
            try {
                this.d = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return this.d;
    }
}
