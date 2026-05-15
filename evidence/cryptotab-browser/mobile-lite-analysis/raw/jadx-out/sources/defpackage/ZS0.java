package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZS0 {
    public final Context a;
    public String b;
    public String c;
    public int d;
    public int e = 0;

    public ZS0(Context context) {
        this.a = context;
    }

    public static String b(C0488cf0 c0488cf0) {
        c0488cf0.a();
        C0001Af0 c0001Af0 = c0488cf0.c;
        String str = c0001Af0.e;
        if (str != null) {
            return str;
        }
        c0488cf0.a();
        String str2 = c0001Af0.b;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] strArrSplit = str2.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public final synchronized String a() {
        try {
            if (this.b == null) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    public final PackageInfo c(String str) {
        try {
            return this.a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
            sb.append("Failed to find package ");
            sb.append(strValueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[Catch: all -> 0x0025, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000a, B:10:0x001b, B:15:0x0027, B:17:0x002d, B:19:0x003f, B:22:0x0046, B:25:0x004b, B:27:0x005e, B:30:0x0065, B:33:0x006a, B:35:0x0077, B:36:0x007b), top: B:44:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.e     // Catch: java.lang.Throwable -> L25
            r1 = 1
            r2 = 0
            if (r0 == 0) goto La
            monitor-exit(r5)
            goto L7f
        La:
            android.content.Context r0 = r5.a     // Catch: java.lang.Throwable -> L25
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L25
            java.lang.String r3 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r4 = "com.google.android.gms"
            int r3 = r0.checkPermission(r3, r4)     // Catch: java.lang.Throwable -> L25
            r4 = -1
            if (r3 != r4) goto L27
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r3 = "Google Play services missing or without correct permission."
            android.util.Log.e(r0, r3)     // Catch: java.lang.Throwable -> L25
            monitor-exit(r5)
            r0 = r2
            goto L7f
        L25:
            r0 = move-exception
            goto L83
        L27:
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()     // Catch: java.lang.Throwable -> L25
            if (r3 != 0) goto L4b
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "com.google.android.c2dm.intent.REGISTER"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "com.google.android.gms"
            r3.setPackage(r4)     // Catch: java.lang.Throwable -> L25
            java.util.List r3 = r0.queryIntentServices(r3, r2)     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L4b
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L25
            if (r3 > 0) goto L46
            goto L4b
        L46:
            r5.e = r1     // Catch: java.lang.Throwable -> L25
            monitor-exit(r5)
            r0 = r1
            goto L7f
        L4b:
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "com.google.iid.TOKEN_REQUEST"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "com.google.android.gms"
            r3.setPackage(r4)     // Catch: java.lang.Throwable -> L25
            java.util.List r0 = r0.queryBroadcastReceivers(r3, r2)     // Catch: java.lang.Throwable -> L25
            r3 = 2
            if (r0 == 0) goto L6a
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L25
            if (r0 > 0) goto L65
            goto L6a
        L65:
            r5.e = r3     // Catch: java.lang.Throwable -> L25
            monitor-exit(r5)
            r0 = r3
            goto L7f
        L6a:
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r4 = "Failed to resolve IID implementation package, falling back"
            android.util.Log.w(r0, r4)     // Catch: java.lang.Throwable -> L25
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L7b
            r5.e = r3     // Catch: java.lang.Throwable -> L25
            r0 = r3
            goto L7e
        L7b:
            r5.e = r1     // Catch: java.lang.Throwable -> L25
            r0 = r1
        L7e:
            monitor-exit(r5)
        L7f:
            if (r0 == 0) goto L82
            return r1
        L82:
            return r2
        L83:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L25
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ZS0.d():boolean");
    }

    public final synchronized void e() {
        PackageInfo packageInfoC = c(this.a.getPackageName());
        if (packageInfoC != null) {
            this.b = Integer.toString(packageInfoC.versionCode);
            this.c = packageInfoC.versionName;
        }
    }
}
