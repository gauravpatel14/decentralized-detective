package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.Purchase;
import org.json.JSONException;

/* JADX INFO: renamed from: wF2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1659wF2 {
    public static final int a = Runtime.getRuntime().availableProcessors();

    public static int a(String str, Bundle bundle) {
        if (bundle == null) {
            e(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        e(str, "Unexpected type for bundle response code: ".concat(obj.getClass().getName()));
        return 6;
    }

    public static Bundle b(String str, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", str);
        if (z) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        return bundle;
    }

    public static Cp c(String str, Intent intent) {
        if (intent != null) {
            Bp bpA = Cp.a();
            bpA.a = a(str, intent.getExtras());
            bpA.b = d(str, intent.getExtras());
            return bpA.a();
        }
        e("BillingHelper", "Got null intent!");
        Bp bpA2 = Cp.a();
        bpA2.a = 6;
        bpA2.b = "An internal error occurred.";
        return bpA2.a();
    }

    public static String d(String str, Bundle bundle) {
        if (bundle == null) {
            e(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        e(str, "Unexpected type for debug message: ".concat(obj.getClass().getName()));
        return "";
    }

    public static void e(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public static Purchase g(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e) {
            e("BillingHelper", "Got JSONException while parsing purchase data: ".concat(e.toString()));
            return null;
        }
    }
}
