package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Sj1 {
    public static String a(String str, String str2) {
        try {
            return AbstractC1440sM.a.getString(str, str2);
        } catch (Exception e) {
            Log.e("cr_Preferences", "Get string error for key: " + str, e);
            return str2;
        }
    }

    public static void b(String str, String str2) {
        try {
            AbstractC1440sM.a.edit().putString(str, str2).apply();
        } catch (Exception e) {
            Log.e("cr_Preferences", "Set string error for key: " + str, e);
        }
    }
}
