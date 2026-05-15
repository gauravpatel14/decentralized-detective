package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: bi2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0432bi2 {
    public final Context a;
    public final HashMap b = new HashMap();

    public C0432bi2(Context context) {
        this.a = context.getApplicationContext();
    }

    public static Intent a(Context context, Uri uri, HashSet hashSet, boolean z) {
        boolean zB;
        if (hashSet.size() == 0) {
            return null;
        }
        Intent intent = new Intent();
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        String str = null;
        while (it.hasNext()) {
            String str2 = it.next().activityInfo.packageName;
            Iterator it2 = hashSet.iterator();
            while (true) {
                if (it2.hasNext()) {
                    try {
                        zB = (Build.VERSION.SDK_INT >= 28 ? new p61() : new q61()).b(str2, context.getPackageManager(), ((Pa2) it2.next()).a);
                    } catch (PackageManager.NameNotFoundException | IOException e) {
                        Log.e("PackageIdentity", "Could not check if package matches token.", e);
                        zB = false;
                    }
                    if (zB) {
                        str = str2;
                        break;
                    }
                }
            }
        }
        if (str == null) {
            if (z) {
                Log.w("TWAConnectionPool", "No TWA candidates for " + uri + " have been registered.");
            }
            return null;
        }
        Intent intent2 = new Intent();
        intent2.setPackage(str);
        intent2.setAction("android.support.customtabs.trusted.TRUSTED_WEB_ACTIVITY_SERVICE");
        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent2, 131072);
        if (resolveInfoResolveService == null) {
            if (z) {
                Log.w("TWAConnectionPool", "Could not find TWAService for ".concat(str));
            }
            return null;
        }
        if (z) {
            Log.i("TWAConnectionPool", "Found " + resolveInfoResolveService.serviceInfo.name + " to handle request for " + uri);
        }
        Intent intent3 = new Intent();
        intent3.setComponent(new ComponentName(str, resolveInfoResolveService.serviceInfo.name));
        return intent3;
    }
}
