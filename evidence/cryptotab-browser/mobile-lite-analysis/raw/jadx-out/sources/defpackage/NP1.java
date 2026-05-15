package defpackage;

import android.content.SharedPreferences;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NP1 extends AbstractC1239ow {
    public final String d;

    public NP1(String str, String str2, String str3) {
        super(CC.b, str, str2);
        this.d = str3;
    }

    @Override // defpackage.AbstractC1239ow
    public final void b(vH1 vh1) {
        String strB = this.a.b(this.b, this.c);
        String strA = a();
        if (strB.isEmpty()) {
            strB = this.d;
        }
        vh1.putString(strA, strB);
    }

    public final String c() {
        C1472sw c1472sw = C1472sw.d;
        c1472sw.c();
        String strA = a();
        String str = this.d;
        HashMap map = AbstractC0224Sm2.b;
        synchronized (map) {
            try {
                String str2 = (String) map.get(strA);
                if (str2 != null) {
                    return str2;
                }
                int i = c1472sw.a.get();
                String string = null;
                if (i != 1) {
                    if (i == 2) {
                        SharedPreferences sharedPreferencesB = C1472sw.b();
                        if (sharedPreferencesB.contains(strA)) {
                            string = sharedPreferencesB.getString(strA, null);
                        }
                    } else if (i == 3 || i == 4) {
                        string = str;
                    }
                }
                if (string == null) {
                    string = AbstractC1532tw.a().readString(strA, str);
                }
                map.put(strA, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
