package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CT2 extends LT2 {
    @Override // defpackage.LT2
    public final Object a(String str) {
        if (lS2.b.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (lS2.c.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String str2 = this.a.b;
        Log.e("PhenotypeFlag", "Invalid boolean value for " + this.b + ": " + str);
        return null;
    }
}
