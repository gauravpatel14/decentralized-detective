package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Mz {
    public final Runnable a;
    public final Handler c;
    public final String d;
    public final String e;
    public final String f;
    public final boolean g;
    public final ArrayDeque b = new ArrayDeque();
    public final Kz h = new Kz();

    public Mz(Handler handler, Runnable runnable, String str, String str2, String str3, boolean z) {
        this.c = handler;
        this.a = runnable;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = z;
    }

    public static void a(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 && i < 34 && !str.equals(context.getPackageName())) {
            try {
                Class.forName("android.webkit.WebViewUpdateService").getDeclaredMethod("getCurrentWebViewPackageName", null).invoke(null, null);
            } catch (Exception e) {
                Log.w("cr_ChildConnAllocator", "workAroundWebViewPackageVisibility failed", e);
            }
        }
        context.getPackageManager().getServiceInfo(new ComponentName(str, str2.concat("0")), 0);
    }

    public static Jz b(Context context, Handler handler, Runnable runnable, String str, String str2, String str3, boolean z) throws PackageManager.NameNotFoundException {
        Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
        int i = bundle != null ? bundle.getInt(str3, -1) : -1;
        if (i < 0) {
            throw new RuntimeException();
        }
        a(context, str, str2);
        return new Jz(handler, runnable, str, str2, z, i);
    }

    public abstract C0619fA c(Context context, Bundle bundle, Iz iz);

    public abstract void d(C0619fA c0619fA);

    public abstract int e();
}
