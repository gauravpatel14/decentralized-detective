package defpackage;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: renamed from: yv, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1808yv {
    public static final /* synthetic */ int a = 0;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            AbstractC1758xv.a(30);
        }
        if (i >= 30) {
            AbstractC1758xv.a(31);
        }
        if (i >= 30) {
            AbstractC1758xv.a(33);
        }
        if (i >= 30) {
            AbstractC1758xv.a(1000000);
        }
    }

    public static final boolean a(String str, String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0;
    }

    public static final boolean b() {
        int i = Build.VERSION.SDK_INT;
        return i >= 34 || (i >= 33 && a("UpsideDownCake", Build.VERSION.CODENAME));
    }

    public static final boolean c() {
        int i = Build.VERSION.SDK_INT;
        return i >= 35 || (i >= 34 && a("VanillaIceCream", Build.VERSION.CODENAME));
    }
}
