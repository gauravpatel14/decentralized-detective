package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ET2 extends LT2 {
    @Override // defpackage.LT2
    public final Object a(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            String str2 = this.a.b;
            Log.e("PhenotypeFlag", "Invalid double value for " + this.b + ": " + str);
            return null;
        }
    }
}
