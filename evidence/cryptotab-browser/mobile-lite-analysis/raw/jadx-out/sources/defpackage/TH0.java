package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TH0 {
    public static final TH0 b = new TH0(new UH0(new LocaleList(new Locale[0])));
    public final UH0 a;

    public TH0(UH0 uh0) {
        this.a = uh0;
    }

    public static TH0 a(String str) {
        if (str == null || str.isEmpty()) {
            return b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            int i2 = SH0.a;
            localeArr[i] = Locale.forLanguageTag(str2);
        }
        return new TH0(new UH0(new LocaleList(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TH0) {
            if (this.a.equals(((TH0) obj).a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a.a.hashCode();
    }

    public final String toString() {
        return this.a.a.toString();
    }
}
