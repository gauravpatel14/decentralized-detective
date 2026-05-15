package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ep {
    public static Method a;

    public static boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i, Handler handler) {
        if (a == null) {
            a = Context.class.getDeclaredMethod("bindServiceAsUser", Intent.class, ServiceConnection.class, Integer.TYPE, Handler.class, UserHandle.class);
        }
        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return ((Boolean) a.invoke(context, intent, serviceConnection, Integer.valueOf(i), handler, Process.myUserHandle())).booleanValue();
    }

    public static boolean b(Context context, Intent intent, ServiceConnection serviceConnection, int i, Handler handler, Wz wz, String str) {
        if (c() && str != null) {
            return context.bindIsolatedService(intent, i, str, wz, serviceConnection);
        }
        try {
            return a(context, intent, serviceConnection, i, handler);
        } catch (ReflectiveOperationException e) {
            try {
                return context.bindService(intent, serviceConnection, i);
            } catch (RuntimeException e2) {
                throw new RuntimeException(e2.getMessage(), e);
            }
        }
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        int i = AbstractC1872zv.a;
        return true;
    }
}
