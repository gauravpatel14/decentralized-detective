package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Qx0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0201Qx0 {
    public static final NC2 c;
    public static final gf d;
    public static final long e;
    public static RD2 f;
    public static XC2 g;
    public static String h;
    public Context a;
    public String b;

    static {
        C1428sC2.a().getClass();
        c = new NC2();
        d = new gf(0);
        e = TimeUnit.DAYS.toMillis(7L);
    }

    public static synchronized C0201Qx0 b(Context context, Bundle bundle) {
        C0201Qx0 c0201Qx0;
        try {
            String string = bundle.getString("subtype");
            if (string == null) {
                string = "";
            }
            Context applicationContext = context.getApplicationContext();
            if (f == null) {
                String packageName = applicationContext.getPackageName();
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 73);
                sb.append("Instance ID SDK is deprecated, ");
                sb.append(packageName);
                sb.append(" should update to use Firebase Instance ID");
                Log.w("InstanceID", sb.toString());
                f = new RD2(applicationContext);
                XC2 xc2 = new XC2();
                xc2.b = new gf(0);
                xc2.a = applicationContext;
                g = xc2;
            }
            h = Integer.toString(e(applicationContext));
            gf gfVar = d;
            c0201Qx0 = (C0201Qx0) gfVar.get(string);
            if (c0201Qx0 == null) {
                c0201Qx0 = new C0201Qx0();
                c0201Qx0.b = "";
                c0201Qx0.a = applicationContext.getApplicationContext();
                c0201Qx0.b = string;
                gfVar.put(string, c0201Qx0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return c0201Qx0;
    }

    public static String c(KeyPair keyPair) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            bArrDigest[0] = (byte) ((bArrDigest[0] & 15) + 112);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("InstanceID", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    public static int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(strValueOf);
            Log.w("InstanceID", sb.toString());
            return 0;
        }
    }

    public final void a() throws IOException {
        d("*", "*");
        RD2 rd2 = f;
        String str = this.b;
        synchronized (rd2) {
            rd2.d.remove(str);
        }
        File fileI = C0483cZ2.i(rd2.b, str);
        if (fileI.exists()) {
            fileI.delete();
        }
        String strConcat = String.valueOf(str).concat("|");
        synchronized (rd2) {
            try {
                SharedPreferences.Editor editorEdit = rd2.a.edit();
                for (String str2 : rd2.a.getAll().keySet()) {
                    if (str2.startsWith(strConcat)) {
                        editorEdit.remove(str2);
                    }
                }
                editorEdit.commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str, String str2) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        RD2 rd2 = f;
        String str3 = this.b;
        synchronized (rd2) {
            SharedPreferences.Editor editorEdit = rd2.a.edit();
            editorEdit.remove(RD2.a(str3, str, str2));
            editorEdit.remove(RD2.b(str3, str, str2));
            editorEdit.commit();
        }
        Bundle bundle = new Bundle();
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.b) ? str : this.b);
        if (!"".equals(this.b)) {
            str = this.b;
        }
        bundle.putString("X-subtype", str);
        XC2.f(g.a(bundle, f.d(this.b).a));
    }
}
