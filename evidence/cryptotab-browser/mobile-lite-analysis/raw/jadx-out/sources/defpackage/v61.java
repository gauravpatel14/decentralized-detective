package defpackage;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.TransactionTooLargeException;
import android.util.Log;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v61 {
    public static final Intent a = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", null));

    public static boolean a(Intent intent, int i) {
        return !c(intent, i).isEmpty();
    }

    public static void b(RuntimeException runtimeException, Intent intent) {
        if (!(runtimeException instanceof NullPointerException) && !(runtimeException.getCause() instanceof TransactionTooLargeException)) {
            throw runtimeException;
        }
        Log.e("cr_PackageManagerUtils", "Could not resolve Activity for intent " + intent.toString(), runtimeException);
    }

    public static List c(Intent intent, int i) {
        try {
            LP1 lp1C = LP1.c();
            try {
                List<ResolveInfo> listQueryIntentActivities = AbstractC1499tM.a.getPackageManager().queryIntentActivities(intent, i);
                lp1C.close();
                return listQueryIntentActivities;
            } catch (Throwable th) {
                try {
                    lp1C.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (RuntimeException e) {
            b(e, intent);
            return Collections.emptyList();
        }
    }

    public static ResolveInfo d(Intent intent, int i) {
        try {
            LP1 lp1D = LP1.d();
            try {
                ResolveInfo resolveInfoResolveActivity = AbstractC1499tM.a.getPackageManager().resolveActivity(intent, i);
                lp1D.close();
                return resolveInfoResolveActivity;
            } catch (Throwable th) {
                try {
                    lp1D.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (RuntimeException e) {
            b(e, intent);
            return null;
        }
    }

    public static ResolveInfo e() {
        return d(a, 65536);
    }
}
