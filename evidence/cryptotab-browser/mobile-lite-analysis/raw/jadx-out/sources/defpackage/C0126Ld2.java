package defpackage;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: Ld2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0126Ld2 {
    public static WeakReference b;
    public xH1 a;

    public final synchronized C0030Cd2 a() {
        String str;
        C0030Cd2 c0030Cd2;
        xH1 xh1 = this.a;
        synchronized (xh1.d) {
            str = (String) xh1.d.peek();
        }
        Pattern pattern = C0030Cd2.d;
        c0030Cd2 = null;
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("!", -1);
            if (strArrSplit.length == 2) {
                c0030Cd2 = new C0030Cd2(strArrSplit[0], strArrSplit[1]);
            }
        }
        return c0030Cd2;
    }
}
