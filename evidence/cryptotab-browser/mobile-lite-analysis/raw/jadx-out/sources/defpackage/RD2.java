package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.iid.zzp;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RD2 {
    public final SharedPreferences a;
    public final Context b;
    public final C0483cZ2 c;
    public final gf d;

    public RD2(Context context) {
        C0483cZ2 c0483cZ2 = new C0483cZ2();
        this.d = new gf(0);
        this.b = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.a = sharedPreferences;
        this.c = c0483cZ2;
        File file = new File(context.getNoBackupFilesDir(), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || sharedPreferences.getAll().isEmpty()) {
                return;
            }
            Log.i("InstanceID/Store", "App restored, clearing state");
            AbstractServiceC0279Wx0.a(context, this);
        } catch (IOException unused) {
        }
    }

    public static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + String.valueOf(str2).length() + String.valueOf(str).length() + 4);
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    public static String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + String.valueOf(str2).length() + String.valueOf(str).length() + 14);
        sb.append(str);
        sb.append("|T-timestamp|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    public static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder(str2.length() + String.valueOf(str).length() + 3);
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized KZ2 d(String str) {
        KZ2 kz2E;
        KZ2 kz2 = (KZ2) this.d.get(str);
        if (kz2 != null) {
            return kz2;
        }
        try {
            C0483cZ2 c0483cZ2 = this.c;
            Context context = this.b;
            c0483cZ2.getClass();
            kz2E = C0483cZ2.g(context, str);
            if (kz2E == null) {
                kz2E = C0483cZ2.e(context, str);
            }
        } catch (zzp unused) {
            Log.w("InstanceID/Store", "Stored data is corrupt, generating new identity");
            AbstractServiceC0279Wx0.a(this.b, this);
            C0483cZ2 c0483cZ22 = this.c;
            Context context2 = this.b;
            c0483cZ22.getClass();
            kz2E = C0483cZ2.e(context2, str);
        }
        this.d.put(str, kz2E);
        return kz2E;
    }
}
