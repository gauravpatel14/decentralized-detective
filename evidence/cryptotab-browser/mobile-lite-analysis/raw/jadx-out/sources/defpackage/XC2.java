package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.iid.MessengerCompat;
import com.google.android.gms.iid.zzaa;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XC2 {
    public static final NC2 g;
    public static String h;
    public static boolean i;
    public static int j;
    public static C1194oD2 k;
    public Context a;
    public gf b;
    public Messenger c;
    public Messenger d;
    public MessengerCompat e;
    public PendingIntent f;

    static {
        C1428sC2.a().getClass();
        g = new NC2();
        h = null;
        i = false;
        j = 0;
        k = null;
    }

    public static void b(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message messageObtain = Message.obtain();
            messageObtain.obj = obj2;
            try {
                messenger.send(messageObtain);
            } catch (RemoteException e) {
                String strValueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                sb.append("Failed to send response ");
                sb.append(strValueOf);
                Log.w("InstanceID", sb.toString());
            }
        }
    }

    public static boolean d(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            try {
                h = packageManager.getApplicationInfo(str, 0).packageName;
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        StringBuilder sb = new StringBuilder(str2.length() + String.valueOf(str).length() + 56);
        sb.append("Possible malicious package ");
        sb.append(str);
        sb.append(" declares ");
        sb.append(str2);
        sb.append(" without permission");
        Log.w("InstanceID", sb.toString());
        return false;
    }

    public static String f(Bundle bundle) {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string == null) {
            string = bundle.getString("unregistered");
        }
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("error");
        if (string2 != null) {
            throw new IOException(string2);
        }
        String strValueOf = String.valueOf(bundle);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 29);
        sb.append("Unexpected response from GCM ");
        sb.append(strValueOf);
        Log.w("InstanceID", sb.toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public static String h(Context context) {
        String str = h;
        if (str != null) {
            return str;
        }
        Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (!PlatformVersion.isAtLeastO()) {
            Iterator<ResolveInfo> it = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
            while (it.hasNext()) {
                if (d(packageManager, it.next().serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                    i = false;
                    return h;
                }
            }
        }
        Iterator<ResolveInfo> it2 = packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
        while (it2.hasNext()) {
            if (d(packageManager, it2.next().activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                i = true;
                return h;
            }
        }
        Log.w("InstanceID", "Failed to resolve IID implementation package, falling back");
        try {
            h = packageManager.getApplicationInfo("com.google.android.gms", 0).packageName;
            i = PlatformVersion.isAtLeastO();
            return h;
        } catch (PackageManager.NameNotFoundException unused) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                try {
                    String str2 = packageManager.getApplicationInfo("com.google.android.gsf", 0).packageName;
                    h = str2;
                    i = false;
                    return str2;
                } catch (PackageManager.NameNotFoundException unused2) {
                    Log.w("InstanceID", "Google Play services is missing, unable to get tokens");
                    return null;
                }
            }
            Log.w("InstanceID", "Google Play services is missing, unable to get tokens");
            return null;
        }
    }

    public final Bundle a(Bundle bundle, KeyPair keyPair) throws IOException {
        int i2;
        String str;
        int i3;
        C0939k33 c0939k33;
        Context context = this.a;
        try {
            i2 = context.getPackageManager().getPackageInfo(h(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            i2 = -1;
        }
        bundle.putString("gmsv", Integer.toString(i2));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(C0201Qx0.e(this.a)));
        Context context2 = this.a;
        try {
            str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(strValueOf);
            Log.w("InstanceID", sb.toString());
            str = null;
        }
        bundle.putString("app_ver_name", str);
        bundle.putString("cliv", "iid-12451000");
        bundle.putString("appid", C0201Qx0.c(keyPair));
        if (i2 < 12000000) {
            Bundle bundleG = g(bundle);
            if (bundleG == null || !bundleG.containsKey("google.messenger")) {
                return bundleG;
            }
            Bundle bundleG2 = g(bundle);
            if (bundleG2 == null || !bundleG2.containsKey("google.messenger")) {
                return bundleG2;
            }
            return null;
        }
        g.getClass();
        Q13 q13 = new Q13(this.a);
        synchronized (q13) {
            i3 = q13.d;
            q13.d = i3 + 1;
        }
        C0759hC2 c0759hC2 = new C0759hC2(i3, bundle);
        synchronized (q13) {
            try {
                if (!q13.c.b(c0759hC2)) {
                    ServiceConnectionC1305q23 serviceConnectionC1305q23 = new ServiceConnectionC1305q23(q13);
                    q13.c = serviceConnectionC1305q23;
                    serviceConnectionC1305q23.b(c0759hC2);
                }
                c0939k33 = c0759hC2.b.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            return (Bundle) Y62.a(c0939k33);
        } catch (InterruptedException | ExecutionException e2) {
            if (!(e2.getCause() instanceof zzaa) || ((zzaa) e2.getCause()).t != 4) {
                return null;
            }
            Bundle bundleG3 = g(bundle);
            if (bundleG3 == null || !bundleG3.containsKey("google.messenger")) {
                return bundleG3;
            }
            Bundle bundleG4 = g(bundle);
            if (bundleG4 == null || !bundleG4.containsKey("google.messenger")) {
                return bundleG4;
            }
            return null;
        }
    }

    public final void c(Object obj, String str) {
        synchronized (XC2.class) {
            Object obj2 = this.b.get(str);
            this.b.put(str, obj);
            b(obj2, obj);
        }
    }

    public final void e(Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
            String stringExtra = intent.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("unregistered");
            }
            if (stringExtra != null) {
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    Bundle extras = intent.getExtras();
                    extras.putString("registration_id", strGroup2);
                    c(extras, strGroup);
                    return;
                }
                return;
            }
            String stringExtra2 = intent.getStringExtra("error");
            if (stringExtra2 == null) {
                String strValueOf = String.valueOf(intent.getExtras());
                StringBuilder sb = new StringBuilder(strValueOf.length() + 49);
                sb.append("Unexpected response, no error or registration id ");
                sb.append(strValueOf);
                Log.w("InstanceID", sb.toString());
                return;
            }
            String str = null;
            if (stringExtra2.startsWith("|")) {
                String[] strArrSplit = stringExtra2.split("\\|");
                if (!"ID".equals(strArrSplit[1])) {
                    Log.w("InstanceID", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                }
                if (strArrSplit.length > 2) {
                    str = strArrSplit[2];
                    stringExtra2 = strArrSplit[3];
                    if (stringExtra2.startsWith(":")) {
                        stringExtra2 = stringExtra2.substring(1);
                    }
                } else {
                    stringExtra2 = "UNKNOWN";
                }
                intent.putExtra("error", stringExtra2);
            }
            if (str != null) {
                c(stringExtra2, str);
                return;
            }
            synchronized (XC2.class) {
                try {
                    for (String str2 : (df) this.b.keySet()) {
                        Object obj = this.b.get(str2);
                        this.b.put(str2, stringExtra2);
                        b(obj, stringExtra2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle g(android.os.Bundle r9) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.XC2.g(android.os.Bundle):android.os.Bundle");
    }
}
