package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YL2 {
    public final String a;
    public String b;

    public YL2(String str) {
        Preconditions.checkNotEmpty(str, "The log tag cannot be null or empty.");
        this.a = str;
    }

    public final void a(Object... objArr) {
        Log.e(this.a, b("Bundle is null", objArr));
    }

    public final String b(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        if (TextUtils.isEmpty(this.b)) {
            return str;
        }
        String strValueOf = String.valueOf(this.b);
        String strValueOf2 = String.valueOf(str);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }
}
