package defpackage;

import android.content.SharedPreferences;
import java.util.HashMap;

/* JADX INFO: renamed from: Ot, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0179Ot extends AbstractC1239ow {
    public final boolean d;

    public C0179Ot(AbstractC0080Gb0 abstractC0080Gb0, String str, String str2, boolean z) {
        super(abstractC0080Gb0, str, str2);
        this.d = z;
    }

    @Override // defpackage.AbstractC1239ow
    public final void b(vH1 vh1) {
        vh1.putBoolean(a(), this.a.c(this.b, this.c, this.d));
    }

    public final boolean c() {
        C1472sw c1472sw = C1472sw.d;
        c1472sw.c();
        String strA = a();
        boolean z = this.d;
        HashMap map = AbstractC0224Sm2.a;
        synchronized (map) {
            try {
                Boolean bool = (Boolean) map.get(strA);
                if (bool != null) {
                    return bool.booleanValue();
                }
                int i = c1472sw.a.get();
                Boolean boolValueOf = null;
                if (i != 1) {
                    if (i == 2) {
                        SharedPreferences sharedPreferencesB = C1472sw.b();
                        if (sharedPreferencesB.contains(strA)) {
                            boolValueOf = Boolean.valueOf(sharedPreferencesB.getBoolean(strA, false));
                        }
                    } else if (i == 3 || i == 4) {
                        boolValueOf = Boolean.valueOf(z);
                    }
                }
                if (boolValueOf == null) {
                    boolValueOf = Boolean.valueOf(AbstractC1532tw.a().readBoolean(strA, z));
                }
                map.put(strA, boolValueOf);
                return boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
