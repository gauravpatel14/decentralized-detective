package defpackage;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s00 {
    public static Point a(String str, Display display) {
        String str2;
        if (display.getDisplayId() == 0) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str2 = (String) cls.getMethod("get", String.class).invoke(cls, str);
            } catch (Exception unused) {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    String[] strArrSplit = str2.trim().split("x", -1);
                    if (strArrSplit.length == 2) {
                        int i = Integer.parseInt(strArrSplit[0]);
                        int i2 = Integer.parseInt(strArrSplit[1]);
                        if (i > 0 && i2 > 0) {
                            return new Point(i, i2);
                        }
                    }
                    throw new NumberFormatException();
                } catch (NumberFormatException unused2) {
                }
            }
        }
        return null;
    }
}
