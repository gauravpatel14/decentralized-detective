package defpackage;

import android.content.SharedPreferences;
import java.util.HashMap;

/* JADX INFO: renamed from: ny0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1180ny0 extends AbstractC1239ow {
    public final int d;

    public C1180ny0(AbstractC0080Gb0 abstractC0080Gb0, String str, String str2, int i) {
        super(abstractC0080Gb0, str, str2);
        this.d = i;
    }

    @Override // defpackage.AbstractC1239ow
    public final void b(vH1 vh1) {
        String str = this.c;
        vh1.putInt(a(), this.a.d(this.d, this.b, str));
    }

    public final int c() {
        C1472sw c1472sw = C1472sw.d;
        c1472sw.c();
        String strA = a();
        int i = this.d;
        HashMap map = AbstractC0224Sm2.c;
        synchronized (map) {
            try {
                Integer num = (Integer) map.get(strA);
                if (num != null) {
                    return num.intValue();
                }
                int i2 = c1472sw.a.get();
                Integer numValueOf = null;
                if (i2 != 1) {
                    if (i2 == 2) {
                        SharedPreferences sharedPreferencesB = C1472sw.b();
                        if (sharedPreferencesB.contains(strA)) {
                            numValueOf = Integer.valueOf(sharedPreferencesB.getInt(strA, 0));
                        }
                    } else if (i2 == 3 || i2 == 4) {
                        numValueOf = Integer.valueOf(i);
                    }
                }
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(AbstractC1532tw.a().readInt(strA, i));
                }
                map.put(strA, numValueOf);
                return numValueOf.intValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
