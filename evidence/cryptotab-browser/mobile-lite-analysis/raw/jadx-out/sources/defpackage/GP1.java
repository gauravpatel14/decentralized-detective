package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GP1 {
    public final SharedPreferences a;
    public final gf b = new gf(0);

    public GP1(Context context) {
        boolean zIsEmpty;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.a = sharedPreferences;
        File file = new File(context.getNoBackupFilesDir(), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    zIsEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (zIsEmpty) {
                    return;
                }
                Log.i("FirebaseInstanceId", "App restored, clearing state");
                c();
            }
        } catch (IOException unused) {
        }
    }

    public static String a(String str) {
        return S3.a(new StringBuilder(String.valueOf(str).length() + 6), str, "|S|cre");
    }

    public static String b(String str, String str2, String str3) {
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 4 + String.valueOf(str2).length() + str3.length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    public final synchronized void c() {
        this.b.clear();
        this.a.edit().clear().commit();
    }

    public final synchronized void d(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = a(str);
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences.contains(strA)) {
            String string = sharedPreferences.getString(a(str), null);
            if (string != null) {
                try {
                    jCurrentTimeMillis = Long.parseLong(string);
                } catch (NumberFormatException unused) {
                    jCurrentTimeMillis = 0;
                }
            } else {
                jCurrentTimeMillis = 0;
            }
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(a(str), String.valueOf(jCurrentTimeMillis));
        editorEdit.commit();
        this.b.put(str, Long.valueOf(jCurrentTimeMillis));
    }
}
