package defpackage;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zy0 {
    public static ComponentName a;
    public static final Object b = new Object();

    public static void a(Intent intent) {
        if (e(AbstractC1499tM.a, intent)) {
            intent.putExtra("trusted_application_code_extra", b());
        }
    }

    public static PendingIntent b() {
        Intent intent = new Intent();
        Context context = AbstractC1499tM.a;
        String packageName = context.getPackageName();
        synchronized (b) {
            try {
                if (a == null) {
                    a = new ComponentName(packageName, "FakeClass");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        intent.setComponent(a);
        return PendingIntent.getActivity(context, 0, intent, 67108864);
    }

    public static ArrayList c(String str, Intent intent) {
        try {
            return intent.getParcelableArrayListExtra(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getParcelableArrayListExtra failed on intent " + intent);
            return null;
        }
    }

    public static int d(boolean z) {
        if (z) {
            return (!z || Build.VERSION.SDK_INT < 31) ? 0 : 33554432;
        }
        return 67108864;
    }

    public static boolean e(Context context, Intent intent) {
        boolean zIsEmpty = TextUtils.isEmpty(intent.getPackage());
        boolean z = !zIsEmpty && context.getPackageName().equals(intent.getPackage());
        boolean z2 = intent.getComponent() != null;
        if (z2 && context.getPackageName().equals(intent.getComponent().getPackageName())) {
            if (zIsEmpty) {
                return true;
            }
            return z;
        }
        if (z) {
            return !z2;
        }
        return false;
    }

    public static boolean f(Intent intent) {
        return intent != null && TextUtils.equals(intent.getAction(), "android.intent.action.MAIN") && intent.hasCategory("android.intent.category.LAUNCHER") && (intent.getFlags() & 1048576) == 0;
    }

    public static boolean g(Intent intent) {
        PendingIntent pendingIntent;
        if (intent == null || (pendingIntent = (PendingIntent) p("trusted_application_code_extra", intent)) == null) {
            return false;
        }
        return b().equals(pendingIntent);
    }

    public static boolean h(Bundle bundle, String str, boolean z) {
        try {
            return bundle.getBoolean(str, z);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getBoolean failed on bundle " + bundle);
            return z;
        }
    }

    public static boolean i(Intent intent, String str, boolean z) {
        try {
            return intent.getBooleanExtra(str, z);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getBooleanExtra failed on intent " + intent);
            return z;
        }
    }

    public static Bundle j(String str, Intent intent) {
        try {
            return intent.getBundleExtra(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getBundleExtra failed on intent " + intent);
            return null;
        }
    }

    public static byte[] k(String str, Intent intent) {
        try {
            return intent.getByteArrayExtra(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getByteArrayExtra failed on intent " + intent);
            return null;
        }
    }

    public static int l(String str, int i, Bundle bundle) {
        try {
            return bundle.getInt(str, i);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getInt failed on bundle " + bundle);
            return i;
        }
    }

    public static int m(int i, String str, Intent intent) {
        try {
            return intent.getIntExtra(str, i);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getIntExtra failed on intent " + intent);
            return i;
        }
    }

    public static long n(String str, Intent intent) {
        try {
            return intent.getLongExtra(str, 2147483648L);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getLongExtra failed on intent " + intent);
            return 2147483648L;
        }
    }

    public static Parcelable o(String str, Bundle bundle) {
        try {
            return bundle.getParcelable(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getParcelable failed on bundle " + bundle);
            return null;
        }
    }

    public static Parcelable p(String str, Intent intent) {
        try {
            return intent.getParcelableExtra(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getParcelableExtra failed on intent " + intent);
            return null;
        }
    }

    public static Serializable q(String str, Intent intent) {
        try {
            return intent.getSerializableExtra(str);
        } catch (ClassCastException e) {
            Log.e("cr_IntentUtils", "Invalide class for Serializable: ".concat(str), e);
            return null;
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getSerializableExtra failed on intent " + intent);
            return null;
        }
    }

    public static String r(String str, Bundle bundle) {
        try {
            return bundle.getString(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getString failed on bundle " + bundle);
            return null;
        }
    }

    public static ArrayList s(String str, Intent intent) {
        try {
            return intent.getStringArrayListExtra(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getStringArrayListExtra failed on intent " + intent);
            return null;
        }
    }

    public static String t(String str, Intent intent) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "getStringExtra failed on intent " + intent);
            return null;
        }
    }

    public static boolean u(String str, Intent intent) {
        try {
            return intent.hasExtra(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "hasExtra failed on intent " + intent);
            return false;
        }
    }

    public static void v(String str, Intent intent) {
        try {
            intent.removeExtra(str);
        } catch (Throwable unused) {
            Log.e("cr_IntentUtils", "removeExtra failed on intent " + intent);
        }
    }

    public static boolean w(Context context, Intent intent, Bundle bundle) {
        try {
            context.startActivity(intent, bundle);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static Intent x(Intent intent) {
        if (Build.VERSION.SDK_INT >= 33) {
            return intent;
        }
        if (intent == null) {
            return null;
        }
        try {
            intent.getBooleanExtra("TriggerUnparcel", false);
            return intent;
        } catch (BadParcelableException e) {
            Log.e("cr_IntentUtils", "Invalid incoming intent.", e);
            return intent.replaceExtras((Bundle) null);
        } catch (RuntimeException e2) {
            if (!(e2.getCause() instanceof ClassNotFoundException)) {
                throw e2;
            }
            Log.e("cr_IntentUtils", "Invalid incoming intent.", e2);
            return intent.replaceExtras((Bundle) null);
        }
    }
}
