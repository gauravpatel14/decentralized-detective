package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zza;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class hx1 {
    public static int h;
    public static PendingIntent i;
    public final Context b;
    public final N13 c;
    public final ScheduledThreadPoolExecutor d;
    public Messenger f;
    public zza g;
    public final UJ1 a = new UJ1(0);
    public final Messenger e = new Messenger(new D33(this, Looper.getMainLooper()));

    public hx1(Context context) {
        this.b = context;
        this.c = new N13(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.d = scheduledThreadPoolExecutor;
    }

    public final C0939k33 a(final Bundle bundle) {
        int i2;
        int i3;
        PackageInfo packageInfo;
        N13 n13 = this.c;
        synchronized (n13) {
            try {
                if (n13.b == 0) {
                    try {
                        packageInfo = Wrappers.packageManager(n13.a).getPackageInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e) {
                        String strValueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
                        sb.append("Failed to find package ");
                        sb.append(strValueOf);
                        Log.w("Metadata", sb.toString());
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        n13.b = packageInfo.versionCode;
                    }
                }
                i2 = n13.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i2 < 12000000) {
            return this.c.a() != 0 ? c(bundle).n(U33.t, new xN(this, bundle) { // from class: Q23
                public final hx1 a;
                public final Bundle b;

                {
                    this.a = this;
                    this.b = bundle;
                }

                @Override // defpackage.xN
                public final Object a(G62 g62) {
                    Bundle bundle2;
                    hx1 hx1Var = this.a;
                    hx1Var.getClass();
                    if (!g62.k() || (bundle2 = (Bundle) g62.h()) == null || !bundle2.containsKey("google.messenger")) {
                        return g62;
                    }
                    C0939k33 c0939k33C = hx1Var.c(this.b);
                    U33 u33 = U33.t;
                    C1064m33 c1064m33 = C1064m33.a;
                    c0939k33C.getClass();
                    C0939k33 c0939k33 = new C0939k33();
                    c0939k33C.b.a(new D03(u33, c1064m33, c0939k33));
                    c0939k33C.s();
                    return c0939k33;
                }
            }) : Y62.d(new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        C0836iN2 c0836iN2A = C0836iN2.a(this.b);
        synchronized (c0836iN2A) {
            i3 = c0836iN2A.d;
            c0836iN2A.d = i3 + 1;
        }
        return c0836iN2A.b(new C0388b23(i3, 1, bundle)).f(U33.t, C1248p23.a);
    }

    public final void b(String str, Bundle bundle) {
        synchronized (this.a) {
            try {
                H62 h62 = (H62) this.a.remove(str);
                if (h62 != null) {
                    h62.b(bundle);
                } else {
                    String strValueOf = String.valueOf(str);
                    Log.w("Rpc", strValueOf.length() != 0 ? "Missing callback for ".concat(strValueOf) : new String("Missing callback for "));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.C0939k33 c(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hx1.c(android.os.Bundle):k33");
    }
}
