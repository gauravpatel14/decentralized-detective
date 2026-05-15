package defpackage;

import android.content.SharedPreferences;
import java.util.HashMap;
import org.chromium.base.shared_preferences.SharedPreferencesManager;

/* JADX INFO: renamed from: pw, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1298pw extends AbstractC0921jg0 {
    public final boolean c;
    public String d;

    public C1298pw(AbstractC0080Gb0 abstractC0080Gb0, String str) {
        super(abstractC0080Gb0, str);
        this.c = false;
    }

    public final boolean a() {
        C1472sw c1472sw = C1472sw.d;
        c1472sw.c();
        if (this.d == null) {
            this.d = AbstractC1532tw.a.b(this.b);
        }
        String str = this.d;
        HashMap map = AbstractC0224Sm2.a;
        synchronized (map) {
            try {
                Boolean bool = (Boolean) map.get(str);
                if (bool != null) {
                    return bool.booleanValue();
                }
                boolean z = this.c;
                int i = c1472sw.a.get();
                Boolean boolValueOf = null;
                if (i != 1) {
                    if (i == 2) {
                        SharedPreferences sharedPreferencesB = C1472sw.b();
                        if (sharedPreferencesB.contains(str)) {
                            boolValueOf = Boolean.valueOf(sharedPreferencesB.getBoolean(str, false));
                        }
                    } else if (i == 3 || i == 4) {
                        boolValueOf = Boolean.valueOf(z);
                    }
                }
                if (boolValueOf == null) {
                    SharedPreferencesManager sharedPreferencesManagerA = AbstractC1532tw.a();
                    boolValueOf = sharedPreferencesManagerA.contains(str) ? Boolean.valueOf(sharedPreferencesManagerA.readBoolean(str, false)) : Boolean.valueOf(this.c);
                }
                map.put(str, boolValueOf);
                return boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C1298pw(String str, boolean z) {
        super(CC.b, str);
        int i = AbstractC1872zv.a;
        this.c = z;
    }
}
