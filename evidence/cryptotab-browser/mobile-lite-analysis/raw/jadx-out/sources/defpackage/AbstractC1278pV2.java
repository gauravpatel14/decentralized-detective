package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: renamed from: pV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1278pV2 {
    public static SharedPreferences a;

    public static SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            try {
                if (a == null) {
                    a = (SharedPreferences) VM2.a(new CallableC1516tW2(context));
                }
                sharedPreferences = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }
}
