package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: renamed from: tM, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1499tM {
    public static Context a;

    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static String b() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : (String) Class.forName("android.app.ActivityThread").getMethod("currentProcessName", null).invoke(null, null);
    }

    public static void c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str) {
        context.registerReceiver(broadcastReceiver, intentFilter, str, null, 2);
    }

    public static Intent d(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return context.registerReceiver(broadcastReceiver, intentFilter, null, null, 0);
    }
}
