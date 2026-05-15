package defpackage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: renamed from: sM, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1440sM {
    public static final SharedPreferences a;

    static {
        LP1 lp1D = LP1.d();
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AbstractC1499tM.a);
            lp1D.close();
            a = defaultSharedPreferences;
        } catch (Throwable th) {
            try {
                lp1D.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }
}
