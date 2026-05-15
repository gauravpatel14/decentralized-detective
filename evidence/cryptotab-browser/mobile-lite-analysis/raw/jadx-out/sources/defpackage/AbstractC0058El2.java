package defpackage;

import J.N;
import android.text.TextUtils;
import org.chromium.url.GURL;

/* JADX INFO: renamed from: El2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0058El2 {
    public static GURL a(String str) {
        if (TextUtils.isEmpty(str)) {
            return GURL.emptyGURL();
        }
        GURL.c();
        return (GURL) N._O_O(59, str);
    }

    public static String b(GURL gurl) {
        return (String) N._O_O(64, gurl);
    }

    public static String c(int i, String str) {
        return (String) N._O_IO(3, i, str);
    }

    public static String d(int i, GURL gurl) {
        return gurl == null ? "" : (String) N._O_IO(4, i, gurl);
    }
}
