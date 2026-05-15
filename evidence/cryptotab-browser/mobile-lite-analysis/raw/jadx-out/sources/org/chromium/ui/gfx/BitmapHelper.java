package org.chromium.ui.gfx;

import android.graphics.Bitmap;
import android.util.Log;
import defpackage.qq;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class BitmapHelper {
    public static Bitmap createBitmap(int i, int i2, int i3, boolean z) {
        try {
            return Bitmap.createBitmap(i, i2, i3 != 4 ? i3 != 7 ? i3 != 8 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.ALPHA_8 : Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e) {
            if (!z) {
                throw e;
            }
            Log.w("cr_BitmapHelper", "createBitmap OOM-ed", e);
            return null;
        }
    }

    public static int getBitmapFormatForConfig(Bitmap.Config config) {
        int i = qq.a[config.ordinal()];
        int i2 = 1;
        if (i == 1) {
            return 8;
        }
        if (i == 2) {
            return 7;
        }
        if (i != 3) {
            i2 = 4;
            if (i != 4) {
                return 0;
            }
        }
        return i2;
    }

    public static int getByteCount(Bitmap bitmap) {
        return bitmap.getByteCount();
    }
}
