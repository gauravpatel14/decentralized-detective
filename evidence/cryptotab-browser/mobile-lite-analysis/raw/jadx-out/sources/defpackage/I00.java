package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowInsets;
import android.view.WindowManager;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class I00 {
    public static int a(Context context) {
        Context context2;
        o00 o00VarA = o00.a(context);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 && i < 33 && (context2 = ((jg1) o00VarA).r) != null) {
            context = context2;
        }
        if (i >= 30) {
            Rect bounds = ((WindowManager) context.getSystemService("window")).getMaximumWindowMetrics().getBounds();
            return (int) ((Math.min(bounds.right - bounds.left, bounds.bottom - bounds.top) / o00VarA.d) + 0.5f);
        }
        Point point = o00VarA.c;
        int i2 = point.x;
        int i3 = point.y;
        if (i2 >= i3) {
            i2 = i3;
        }
        return (int) ((i2 / o00VarA.d) + 0.5f);
    }

    public static int b(int i, Context context) {
        context.getResources().getValue(Hp1.automotive_ui_scale_factor, new TypedValue(), true);
        return ((int) Math.ceil(((int) (i * r0.getFloat())) / 20.0f)) * 20;
    }

    public static void c(Context context, Configuration configuration) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int iB = b(displayMetrics.densityDpi, context);
        float f = iB / displayMetrics.densityDpi;
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (Build.VERSION.SDK_INT >= 30) {
            Insets insets = windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.systemBars());
            i2 = (i2 - insets.top) - insets.bottom;
            i = (i - insets.left) - insets.right;
        }
        configuration.densityDpi = iB;
        configuration.screenWidthDp = Math.round(i / (displayMetrics.density * f));
        int iRound = Math.round(i2 / (displayMetrics.density * f));
        configuration.screenHeightDp = iRound;
        configuration.smallestScreenWidthDp = Math.min(configuration.screenWidthDp, iRound);
    }

    public static void d(Context context, DisplayMetrics displayMetrics) {
        int iB = b(displayMetrics.densityDpi, context);
        float f = iB / displayMetrics.densityDpi;
        displayMetrics.density *= f;
        displayMetrics.densityDpi = iB;
        displayMetrics.xdpi *= f;
        displayMetrics.ydpi *= f;
    }
}
