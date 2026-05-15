package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jd {
    public int[] a;

    public static Jd a(String str) {
        String[] strArrSplit;
        int length;
        Jd jd = new Jd();
        jd.a = new int[0];
        if (TextUtils.isEmpty(str) || (length = (strArrSplit = str.split("\\.")).length) == 0) {
            return jd;
        }
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            try {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            } catch (NumberFormatException unused) {
                int i2 = AbstractC1872zv.a;
            }
        }
        jd.a = iArr;
        return jd;
    }
}
