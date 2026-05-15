package defpackage;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.base.TraceEvent;
import org.chromium.base.shared_preferences.SharedPreferencesManager;

/* JADX INFO: renamed from: sw, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1472sw {
    public static final C1472sw d;
    public AtomicInteger a;
    public AtomicBoolean b;
    public AtomicBoolean c;

    static {
        C1472sw c1472sw = new C1472sw();
        c1472sw.a = new AtomicInteger(0);
        c1472sw.b = new AtomicBoolean(false);
        c1472sw.c = new AtomicBoolean(false);
        d = c1472sw;
    }

    public static void a(C1472sw c1472sw) {
        c1472sw.getClass();
        TraceEvent.a("writeSafeValues", null);
        SharedPreferences.Editor editorEdit = b().edit();
        editorEdit.clear();
        HashMap map = AbstractC0224Sm2.a;
        synchronized (map) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    editorEdit.putBoolean((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
                }
            } finally {
            }
        }
        HashMap map2 = AbstractC0224Sm2.c;
        synchronized (map2) {
            try {
                for (Map.Entry entry2 : map2.entrySet()) {
                    editorEdit.putInt((String) entry2.getKey(), ((Integer) entry2.getValue()).intValue());
                }
            } finally {
            }
        }
        HashMap map3 = AbstractC0224Sm2.d;
        synchronized (map3) {
            try {
                for (Map.Entry entry3 : map3.entrySet()) {
                    editorEdit.putLong((String) entry3.getKey(), Double.doubleToRawLongBits(((Double) entry3.getValue()).doubleValue()));
                }
            } finally {
            }
        }
        HashMap map4 = AbstractC0224Sm2.b;
        synchronized (map4) {
            try {
                for (Map.Entry entry4 : map4.entrySet()) {
                    editorEdit.putString((String) entry4.getKey(), (String) entry4.getValue());
                }
            } finally {
            }
        }
        editorEdit.putString("Chrome.Flags.SafeValuesVersion", "128.0.6613.148");
        editorEdit.apply();
        TraceEvent.b("writeSafeValues");
    }

    public static SharedPreferences b() {
        return AbstractC1499tM.a.getSharedPreferences("org.chromium.chrome.browser.flags.SafeModeValues", 0);
    }

    public static boolean d() {
        int i = AbstractC1872zv.a;
        int i2 = AbstractC1532tw.a().readInt("Chrome.Flags.SafeModeRunsLeft", 0);
        if (i2 > 0) {
            AbstractC1532tw.a().getClass();
            SharedPreferencesManager.j(i2 - 1, "Chrome.Flags.SafeModeRunsLeft");
            Log.e("cr_Flags", "Enter Safe Mode for CachedFlags, " + i2 + " runs left.");
            return true;
        }
        int i3 = AbstractC1532tw.a().readInt("Chrome.Flags.CrashStreakBeforeCache", 0);
        Gr1.h(i3, 50, "Variations.SafeModeCachedFlags.Streak.Crashes");
        if (i3 < 2) {
            return false;
        }
        AbstractC1532tw.a().getClass();
        SharedPreferencesManager.j(1, "Chrome.Flags.SafeModeRunsLeft");
        Log.e("cr_Flags", "Enter Safe Mode for CachedFlags, crash streak is " + i3 + ".");
        return true;
    }

    public final void c() {
        synchronized (this.a) {
            try {
                if (this.a.get() != 0) {
                    return;
                }
                if (d()) {
                    String string = b().getString("Chrome.Flags.SafeValuesVersion", "");
                    int i = string.isEmpty() ? 4 : !string.equals("128.0.6613.148") ? 3 : 2;
                    this.a.set(i);
                    Gr1.h(i, 5, "Variations.SafeModeCachedFlags.Engaged");
                } else {
                    this.a.set(1);
                    Gr1.h(1, 5, "Variations.SafeModeCachedFlags.Engaged");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
