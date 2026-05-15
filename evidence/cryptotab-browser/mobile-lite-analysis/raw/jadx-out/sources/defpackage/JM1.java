package defpackage;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JM1 {
    public final HashMap a = new HashMap();

    public static void a() {
        SharedPreferences sharedPreferences = AbstractC1440sM.a;
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(sharedPreferences.getStringSet("key_modules_requested_previously", new HashSet()));
        hashSet.addAll(sharedPreferences.getStringSet("key_modules_deferred_requested_previously", new HashSet()));
        Set<String> setB = AbstractC1085mN1.a(AbstractC1499tM.a).b();
        for (String str : hashSet) {
            Gr1.h(setB.contains(str) ? 1 : 0, 3, "Android.FeatureModules.AvailabilityStatus." + str);
        }
        for (String str2 : setB) {
            if (!hashSet.contains(str2)) {
                Gr1.h(2, 3, "Android.FeatureModules.AvailabilityStatus." + str2);
            }
        }
    }

    public static boolean c(String str, String str2) {
        SharedPreferences sharedPreferences = AbstractC1440sM.a;
        Set<String> stringSet = sharedPreferences.getStringSet(str2, new HashSet());
        HashSet hashSet = new HashSet(stringSet);
        hashSet.add(str);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putStringSet(str2, hashSet);
        editorEdit.apply();
        return stringSet.contains(str);
    }

    public final void b(int i, int i2, String str, String str2) {
        HashMap map = this.a;
        if (map.containsKey(str)) {
            IM1 im1 = (IM1) map.get(str);
            long j = im1.b.get(i);
            long j2 = im1.b.get(i2);
            if (j == 0 || j2 == 0) {
                return;
            }
            Gr1.j(j2 - j, "Android.FeatureModules." + (im1.a ? "Cached" : "Uncached") + "AwakeInstallDuration" + str2 + "." + str);
        }
    }
}
