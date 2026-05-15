package defpackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.StrictMode;
import android.view.Display;
import android.widget.TextView;
import java.util.ArrayList;

/* JADX INFO: renamed from: ja, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0911ja {
    public static int a(Context context, int i, int i2, String str) {
        try {
            return context.checkPermission(str, i, i2);
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    public static Drawable b(Resources resources, int i, int i2) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return i2 == 0 ? resources.getDrawable(i, null) : resources.getDrawableForDensity(i, i2, null);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static ArrayList c(Activity activity) {
        DisplayManager displayManager;
        if (Build.VERSION.SDK_INT < 29) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        if (activity != null && (displayManager = (DisplayManager) activity.getSystemService("display")) != null) {
            Display[] displays = displayManager.getDisplays();
            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
            for (Display display : displays) {
                if (display.getState() == 2 && activityManager.isActivityStartAllowedOnDisplay(activity, display.getDisplayId(), new Intent(activity, activity.getClass()))) {
                    arrayList.add(Integer.valueOf(display.getDisplayId()));
                }
            }
        }
        return arrayList;
    }

    public static void d(ActivityOptions activityOptions) {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        activityOptions.setPendingIntentBackgroundActivityStartMode(1);
    }

    public static void e(TextView textView, int i) {
        textView.setTextAppearance(textView.getContext(), i);
    }
}
