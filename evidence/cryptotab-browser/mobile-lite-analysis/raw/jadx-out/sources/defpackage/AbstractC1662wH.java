package defpackage;

import android.content.Context;
import android.graphics.Color;

/* JADX INFO: renamed from: wH, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1662wH {
    public static int a(float f, int i, int i2) {
        float fE = eM0.e(Color.alpha(i), Color.alpha(i2), f);
        return Color.argb(Math.round(fE), Math.round(eM0.e(Color.red(i) * r0, Color.red(i2) * r1, f) / fE), Math.round(eM0.e(Color.green(i) * r0, Color.green(i2) * r1, f) / fE), Math.round(eM0.e(Color.blue(i) * r0, Color.blue(i2) * r1, f) / fE));
    }

    public static int b(float f, int i, int i2) {
        return Color.rgb(Math.round(eM0.e(Color.red(i), Color.red(i2), f)), Math.round(eM0.e(Color.green(i), Color.green(i2), f)), Math.round(eM0.e(Color.blue(i), Color.blue(i2), f)));
    }

    public static float c(int i) {
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        return ((Math.min(iRed, Math.min(iGreen, iBlue)) + Math.max(iRed, Math.max(iGreen, iBlue))) / 2) / 255.0f;
    }

    public static boolean d(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static int e(float f, int i, int i2) {
        return b((Color.alpha(i2) / 255.0f) * f, i, (-16777216) | i2);
    }

    public static int f(int i, float f) {
        return AbstractC1721xH.i(i, (int) (f * 255.0f));
    }

    public static boolean g(int i) {
        float fRed = Color.red(i) / 255.0f;
        float fGreen = Color.green(i) / 255.0f;
        float fBlue = Color.blue(i) / 255.0f;
        return Math.abs(1.05f / (((((fBlue > 0.03928f ? 1 : (fBlue == 0.03928f ? 0 : -1)) < 0 ? fBlue / 12.92f : (float) Math.pow((double) ((fBlue + 0.055f) / 1.055f), 2.4000000953674316d)) * 0.0722f) + ((((fGreen > 0.03928f ? 1 : (fGreen == 0.03928f ? 0 : -1)) < 0 ? fGreen / 12.92f : (float) Math.pow((double) ((fGreen + 0.055f) / 1.055f), 2.4000000953674316d)) * 0.7152f) + ((fRed < 0.03928f ? fRed / 12.92f : (float) Math.pow((fRed + 0.055f) / 1.055f, 2.4000000953674316d)) * 0.2126f))) + 0.05f)) >= 3.0f;
    }

    public static boolean h(int i) {
        return c(i) > 0.82f;
    }
}
