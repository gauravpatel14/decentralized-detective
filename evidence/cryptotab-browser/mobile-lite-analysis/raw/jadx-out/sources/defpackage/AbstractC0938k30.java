package defpackage;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import org.chromium.url.GURL;

/* JADX INFO: renamed from: k30, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0938k30 {
    public static final int[] a = {AbstractC0275Wp1.download_ui_kb, AbstractC0275Wp1.download_ui_mb, AbstractC0275Wp1.download_ui_gb};

    public static long a(String str, String str2, String str3, String str4, long j, GURL gurl, GURL gurl2) {
        try {
            return ((DownloadManager) AbstractC1499tM.a.getSystemService("download")).addCompletedDownload(str, str2, true, str3, str4, j, !new Z01(r0).b.areNotificationsEnabled(), d(gurl.i()), GURL.k(gurl2) ? null : Uri.parse(gurl2.i()));
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static String b(int i, GURL gurl) {
        if (GURL.k(gurl)) {
            return null;
        }
        String strD = AbstractC0058El2.d(1, gurl);
        return strD.length() <= i ? strD : AbstractC0497cm2.a(gurl.i(), false);
    }

    public static String c(Context context, int[] iArr, long j) {
        int i;
        float f;
        float f2;
        if (j / 1048576 < 1) {
            i = iArr[0];
            f = j;
            f2 = 1024.0f;
        } else if (j / 1073741824 < 1) {
            i = iArr[1];
            f = j;
            f2 = 1048576.0f;
        } else {
            i = iArr[2];
            f = j;
            f2 = 1.0737418E9f;
        }
        return context.getResources().getString(i, Float.valueOf(f / f2));
    }

    public static Uri d(String str) {
        Uri uri = TextUtils.isEmpty(str) ? null : Uri.parse(str);
        if (uri != null) {
            String scheme = uri.normalizeScheme().getScheme();
            if (scheme == null) {
                return null;
            }
            if (!scheme.equals("https") && !scheme.equals("http")) {
                return null;
            }
        }
        return uri;
    }
}
