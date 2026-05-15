package defpackage;

import J.N;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
import org.chromium.url.GURL;

/* JADX INFO: renamed from: cm2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0497cm2 {
    public static final Pattern a = Pattern.compile("^(www[0-9]*|web|ftp|wap|home|mobile|amp)\\.");
    public static final ArrayList b = new ArrayList(Arrays.asList("about", "data", "file", "http", "https", "inline", "javascript"));
    public static final ArrayList c = new ArrayList(Arrays.asList("data", "blob", "file", "filesystem", "http", "https"));
    public static final HashSet d = LG.c("cryptotab", "chrome", "chrome-native", "about");

    public static String a(String str, boolean z) {
        return TextUtils.isEmpty(str) ? str : (String) N._O_ZO(2, z, str);
    }

    public static String b(GURL gurl) {
        return (!GURL.k(gurl) && k(gurl)) ? gurl.g() : "";
    }

    public static boolean c(GURL gurl) {
        return gurl.h().equals("android-app") || gurl.h().equals("intent");
    }

    public static boolean d(GURL gurl) {
        if (GURL.k(gurl)) {
            return false;
        }
        return b.contains(gurl.h());
    }

    public static boolean e(GURL gurl) {
        if (gurl.b) {
            return c.contains(gurl.h());
        }
        return false;
    }

    public static boolean f(GURL gurl) {
        return j(gurl.h());
    }

    public static boolean g(GURL gurl) {
        return d.contains(gurl.h());
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return i(AbstractC0058El2.a(str));
    }

    public static boolean i(GURL gurl) {
        if (gurl.b && d.contains(gurl.h())) {
            return "newtab".equals(gurl.e()) || "chrome://new-tab-page/".equals(gurl.j());
        }
        return false;
    }

    public static boolean j(String str) {
        return "http".equals(str) || "https".equals(str);
    }

    public static boolean k(GURL gurl) {
        return gurl != null && gurl.h().equals("tel");
    }

    public static String l(String str) {
        String strTrim = str.trim();
        return strTrim.startsWith("https://") ? strTrim.substring(8) : strTrim.startsWith("http://") ? strTrim.substring(7) : strTrim;
    }
}
