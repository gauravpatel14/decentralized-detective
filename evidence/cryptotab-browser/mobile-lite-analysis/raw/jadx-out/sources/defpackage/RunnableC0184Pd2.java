package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: renamed from: Pd2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0184Pd2 implements Runnable {
    public static Boolean A;
    public static final Object y = new Object();
    public static Boolean z;
    public final Context t;
    public final ZS0 u;
    public final PowerManager.WakeLock v;
    public final C0155Nd2 w;
    public final long x;

    public RunnableC0184Pd2(C0155Nd2 c0155Nd2, Context context, ZS0 zs0, long j) {
        this.w = c0155Nd2;
        this.t = context;
        this.x = j;
        this.u = zs0;
        this.v = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean a(Context context) {
        boolean zBooleanValue;
        synchronized (y) {
            try {
                Boolean bool = A;
                zBooleanValue = (bool == null && bool == null) ? context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 : bool.booleanValue();
                A = Boolean.valueOf(zBooleanValue);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public static boolean b(Context context) {
        boolean zBooleanValue;
        synchronized (y) {
            try {
                Boolean bool = z;
                zBooleanValue = (bool == null && bool == null) ? context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0 : bool.booleanValue();
                z = Boolean.valueOf(zBooleanValue);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public final synchronized boolean c() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.t.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0155Nd2 c0155Nd2 = this.w;
        Context context = this.t;
        boolean zB = b(context);
        PowerManager.WakeLock wakeLock = this.v;
        if (zB) {
            wakeLock.acquire(lK.a);
        }
        try {
            try {
                c0155Nd2.d(true);
                if (!this.u.d()) {
                    c0155Nd2.d(false);
                    if (b(context)) {
                        try {
                            wakeLock.release();
                            return;
                        } catch (RuntimeException unused) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                            return;
                        }
                    }
                    return;
                }
                if (!a(context) || c()) {
                    if (c0155Nd2.e()) {
                        c0155Nd2.d(false);
                    } else {
                        c0155Nd2.f(this.x);
                    }
                    if (b(context)) {
                        try {
                            wakeLock.release();
                            return;
                        } catch (RuntimeException unused2) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                            return;
                        }
                    }
                    return;
                }
                C0170Od2 c0170Od2 = new C0170Od2();
                c0170Od2.a = this;
                context.registerReceiver(c0170Od2, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                if (b(context)) {
                    try {
                        wakeLock.release();
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } catch (IOException e) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.e("FirebaseMessaging", strValueOf.length() != 0 ? "Failed to sync topics. Won't retry sync. ".concat(strValueOf) : new String("Failed to sync topics. Won't retry sync. "));
                c0155Nd2.d(false);
                if (b(context)) {
                    try {
                        wakeLock.release();
                    } catch (RuntimeException unused4) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (Throwable th) {
            if (b(context)) {
                try {
                    wakeLock.release();
                } catch (RuntimeException unused5) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
