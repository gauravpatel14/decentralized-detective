package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dU1 implements Runnable {
    public final long t;
    public final PowerManager.WakeLock u;
    public final FirebaseInstanceId v;
    public final ThreadPoolExecutor w = AbstractC0918jf0.a();

    public dU1(FirebaseInstanceId firebaseInstanceId, long j) {
        this.v = firebaseInstanceId;
        this.t = j;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.u = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public final Context a() {
        C0488cf0 c0488cf0 = this.v.b;
        c0488cf0.a();
        return c0488cf0.a;
    }

    public final void b(String str) {
        C0488cf0 c0488cf0 = this.v.b;
        c0488cf0.a();
        if ("[DEFAULT]".equals(c0488cf0.b)) {
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new C0055Eb0(a(), this.w).b(intent);
        }
    }

    public final boolean c() throws IOException {
        FirebaseInstanceId firebaseInstanceId = this.v;
        FP1 fp1G = firebaseInstanceId.g(ZS0.b(firebaseInstanceId.b), "*");
        if (!firebaseInstanceId.i(fp1G)) {
            return true;
        }
        try {
            String strB = firebaseInstanceId.b();
            if (strB == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (fp1G == null || !strB.equals(fp1G.a)) {
                b(strB);
            }
            return true;
        } catch (IOException e) {
            String message = e.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                if (e.getMessage() != null) {
                    throw e;
                }
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            String message2 = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message2).length() + 52);
            sb.append("Token retrieval failed: ");
            sb.append(message2);
            sb.append(". Will retry token retrieval");
            Log.w("FirebaseInstanceId", sb.toString());
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseInstanceId firebaseInstanceId = this.v;
        boolean zC = TE1.a().c(a());
        PowerManager.WakeLock wakeLock = this.u;
        if (zC) {
            wakeLock.acquire();
        }
        try {
            try {
                synchronized (firebaseInstanceId) {
                    firebaseInstanceId.g = true;
                }
                if (!firebaseInstanceId.c.d()) {
                    synchronized (firebaseInstanceId) {
                        firebaseInstanceId.g = false;
                    }
                    if (TE1.a().c(a())) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                if (TE1.a().b(a())) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
                    NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                        cU1 cu1 = new cU1();
                        cu1.a = this;
                        GP1 gp1 = FirebaseInstanceId.i;
                        cu1.a.a().registerReceiver(cu1, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        if (TE1.a().c(a())) {
                            wakeLock.release();
                            return;
                        }
                        return;
                    }
                }
                if (c()) {
                    synchronized (firebaseInstanceId) {
                        firebaseInstanceId.g = false;
                    }
                } else {
                    firebaseInstanceId.h(this.t);
                }
                if (TE1.a().c(a())) {
                    wakeLock.release();
                }
            } catch (IOException e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                synchronized (firebaseInstanceId) {
                    firebaseInstanceId.g = false;
                    if (TE1.a().c(a())) {
                        wakeLock.release();
                    }
                }
            }
        } catch (Throwable th) {
            if (TE1.a().c(a())) {
                wakeLock.release();
            }
            throw th;
        }
    }
}
