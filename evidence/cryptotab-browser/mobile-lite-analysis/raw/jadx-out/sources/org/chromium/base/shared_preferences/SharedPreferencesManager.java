package org.chromium.base.shared_preferences;

import android.content.SharedPreferences;
import defpackage.AbstractC1440sM;
import defpackage.AbstractC1872zv;
import defpackage.HB0;
import defpackage.vH1;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class SharedPreferencesManager {
    public static final SharedPreferencesManager a;

    static {
        int i = AbstractC1872zv.a;
        a = new SharedPreferencesManager();
    }

    public static void a(String str, String str2) {
        HashSet hashSet = new HashSet(AbstractC1440sM.a.getStringSet(str, Collections.emptySet()));
        hashSet.add(str2);
        l(str, hashSet);
    }

    public static HashMap d(HB0 hb0) {
        Map<String, ?> all = AbstractC1440sM.a.getAll();
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(hb0.a)) {
                map.put(key, entry.getValue());
            }
        }
        return map;
    }

    public static long e(String str) {
        return AbstractC1440sM.a.getLong(str, 0L);
    }

    public static Set f(String str) {
        return g(str, Collections.emptySet());
    }

    public static Set g(String str, Set set) {
        Set<String> stringSet = AbstractC1440sM.a.getStringSet(str, set);
        if (stringSet != null) {
            return Collections.unmodifiableSet(stringSet);
        }
        return null;
    }

    public static void h(String str, String str2) {
        HashSet hashSet = new HashSet(AbstractC1440sM.a.getStringSet(str, Collections.emptySet()));
        if (hashSet.remove(str2)) {
            l(str, hashSet);
        }
    }

    public static void j(int i, String str) {
        SharedPreferences.Editor editorEdit = AbstractC1440sM.a.edit();
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    public static void l(String str, Set set) {
        SharedPreferences.Editor editorEdit = AbstractC1440sM.a.edit();
        editorEdit.putStringSet(str, set);
        editorEdit.apply();
    }

    public final vH1 b() {
        return new vH1(this, AbstractC1440sM.a.edit());
    }

    public final void c(String str) {
        j(readInt(str, 0) + 1, str);
    }

    public boolean contains(String str) {
        return AbstractC1440sM.a.contains(str);
    }

    public final void i(String str, boolean z) {
        vH1 vh1B = b();
        vh1B.putBoolean(str, z);
        vh1B.apply();
    }

    public final void k(long j, String str) {
        vH1 vh1B = b();
        vh1B.putLong(str, j);
        vh1B.apply();
    }

    public boolean readBoolean(String str, boolean z) {
        return AbstractC1440sM.a.getBoolean(str, z);
    }

    public int readInt(String str, int i) {
        return AbstractC1440sM.a.getInt(str, i);
    }

    public String readString(String str, String str2) {
        return AbstractC1440sM.a.getString(str, str2);
    }

    public void removeKey(String str) {
        vH1 vh1B = b();
        vh1B.remove(str);
        vh1B.apply();
    }

    public void writeString(String str, String str2) {
        vH1 vh1B = b();
        vh1B.putString(str, str2);
        vh1B.apply();
    }
}
