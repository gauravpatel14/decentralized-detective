package defpackage;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: renamed from: mm0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1108mm0 {
    public final C0488cf0 a;
    public final ZS0 b;
    public final hx1 c;
    public final InterfaceC0988kn1 d;
    public final InterfaceC0988kn1 e;
    public final of0 f;

    public C1108mm0(C0488cf0 c0488cf0, ZS0 zs0, InterfaceC0988kn1 interfaceC0988kn1, InterfaceC0988kn1 interfaceC0988kn12, of0 of0Var) {
        c0488cf0.a();
        hx1 hx1Var = new hx1(c0488cf0.a);
        this.a = c0488cf0;
        this.b = zs0;
        this.c = hx1Var;
        this.d = interfaceC0988kn1;
        this.e = interfaceC0988kn12;
        this.f = of0Var;
    }

    public final C0939k33 a(String str, String str2, String str3, Bundle bundle) {
        int i;
        String str4;
        String strEncodeToString;
        boolean zG;
        int i2;
        PackageInfo packageInfoC;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        C0488cf0 c0488cf0 = this.a;
        c0488cf0.a();
        bundle.putString("gmp_app_id", c0488cf0.c.b);
        ZS0 zs0 = this.b;
        synchronized (zs0) {
            try {
                if (zs0.d == 0 && (packageInfoC = zs0.c("com.google.android.gms")) != null) {
                    zs0.d = packageInfoC.versionCode;
                }
                i = zs0.d;
            } finally {
            }
        }
        bundle.putString("gmsv", Integer.toString(i));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.b.a());
        ZS0 zs02 = this.b;
        synchronized (zs02) {
            try {
                if (zs02.c == null) {
                    zs02.e();
                }
                str4 = zs02.c;
            } finally {
            }
        }
        bundle.putString("app_ver_name", str4);
        C0488cf0 c0488cf02 = this.a;
        c0488cf02.a();
        try {
            strEncodeToString = Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(c0488cf02.b.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            strEncodeToString = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", strEncodeToString);
        try {
            String str5 = ((C1462si) Y62.a(((nf0) this.f).e())).a;
            if (TextUtils.isEmpty(str5)) {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", str5);
            }
        } catch (InterruptedException e) {
            e = e;
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        } catch (ExecutionException e2) {
            e = e2;
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        bundle.putString("cliv", "fiid-21.0.1");
        Ln0 ln0 = (Ln0) this.e.get();
        C1680wW c1680wW = (C1680wW) this.d.get();
        if (ln0 != null && c1680wW != null) {
            RV rv = (RV) ln0;
            synchronized (rv) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Mn0 mn0 = (Mn0) rv.a.get();
                synchronized (mn0) {
                    zG = mn0.g(jCurrentTimeMillis);
                }
                if (zG) {
                    synchronized (mn0) {
                        String strD = mn0.d(System.currentTimeMillis());
                        mn0.a.edit().putString("last-used-date", strD).commit();
                        mn0.f(strD);
                    }
                    i2 = 3;
                } else {
                    i2 = 1;
                }
            }
            if (i2 != 1) {
                bundle.putString("Firebase-Client-Log-Type", Integer.toString(aM1.b(i2)));
                bundle.putString("Firebase-Client", c1680wW.a());
            }
        }
        return this.c.a(bundle);
    }
}
