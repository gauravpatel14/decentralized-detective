package org.chromium.chrome.browser.base;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import defpackage.AbstractC1499tM;
import defpackage.Gr1;
import defpackage.OM1;
import org.chromium.base.BundleUtils;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class SplitCompatAppComponentFactory extends AppComponentFactory {
    public static int a = -2;

    public static ClassLoader a(ClassLoader classLoader, String str) {
        Context context = AbstractC1499tM.a;
        if (context == null) {
            Log.e("cr_SplitCompat", "Unexpected null Context when instantiating component: " + str);
            return classLoader;
        }
        ClassLoader classLoader2 = SplitCompatAppComponentFactory.class.getClassLoader();
        ClassLoader classLoader3 = context.getClassLoader();
        if (!classLoader.equals(classLoader3)) {
            Boolean bool = BundleUtils.a;
            try {
                try {
                    Class.forName(str, false, classLoader2);
                } catch (ClassNotFoundException unused) {
                }
            } catch (ClassNotFoundException unused2) {
                Class.forName(str, false, classLoader3);
                Log.w("cr_SplitCompat", "Mismatched ClassLoaders between Application and component: " + str);
                return classLoader3;
            }
        }
        return classLoader;
    }

    public static void b(int i) {
        if (a > -1) {
            return;
        }
        a = i;
        if (SplitChromeApplication.e()) {
            Gr1.h(i, 4, "Startup.Android.BrowserProcessCreationReason");
        }
    }

    public final Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) {
        b(0);
        SplitChromeApplication.c("chrome");
        return super.instantiateActivity(a(classLoader, str), str, intent);
    }

    public final ContentProvider instantiateProvider(ClassLoader classLoader, String str) {
        if (a == -2) {
            a = -1;
            PostTask.c(7, new OM1());
        }
        return super.instantiateProvider(a(classLoader, str), str);
    }

    public final BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) {
        b(3);
        SplitChromeApplication.c("chrome");
        return super.instantiateReceiver(a(classLoader, str), str, intent);
    }

    public final Service instantiateService(ClassLoader classLoader, String str, Intent intent) {
        b(1);
        return super.instantiateService(classLoader, str, intent);
    }
}
