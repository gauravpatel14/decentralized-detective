package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Eb0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0055Eb0 {
    public static final Object c = new Object();
    public static ServiceConnectionC1809yw2 d;
    public final Context a;
    public final Executor b;

    public C0055Eb0(Context context) {
        this.a = context;
        this.b = ExecutorC0000Ab0.t;
    }

    public static C0939k33 a(Context context, Intent intent) {
        ServiceConnectionC1809yw2 serviceConnectionC1809yw2;
        C0939k33 c0939k33;
        synchronized (c) {
            try {
                if (d == null) {
                    d = new ServiceConnectionC1809yw2(context);
                }
                serviceConnectionC1809yw2 = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (serviceConnectionC1809yw2) {
            final C1759xw2 c1759xw2 = new C1759xw2(intent);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = serviceConnectionC1809yw2.v;
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledThreadPoolExecutor.schedule(new Runnable(c1759xw2) { // from class: vw2
                public final C1759xw2 t;

                {
                    this.t = c1759xw2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    C1759xw2 c1759xw22 = this.t;
                    String action = c1759xw22.a.getAction();
                    StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
                    sb.append("Service took too long to process intent: ");
                    sb.append(action);
                    sb.append(" App may get closed.");
                    Log.w("FirebaseInstanceId", sb.toString());
                    c1759xw22.b.d(null);
                }
            }, 9000L, TimeUnit.MILLISECONDS);
            c1759xw2.b.a.m(scheduledThreadPoolExecutor, new N41(scheduledFutureSchedule) { // from class: ww2
                public final ScheduledFuture a;

                {
                    this.a = scheduledFutureSchedule;
                }

                @Override // defpackage.N41
                public final void onComplete(G62 g62) {
                    this.a.cancel(false);
                }
            });
            serviceConnectionC1809yw2.w.add(c1759xw2);
            serviceConnectionC1809yw2.a();
            c0939k33 = c1759xw2.b.a;
        }
        return c0939k33.f(ExecutorC0857if0.t, C0041Db0.b);
    }

    public final C0939k33 b(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        boolean zIsAtLeastO = PlatformVersion.isAtLeastO();
        final Context context = this.a;
        if (zIsAtLeastO && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        int flags = intent.getFlags() & 268435456;
        if (z && flags == 0) {
            return a(context, intent);
        }
        Callable callable = new Callable(context, intent) { // from class: Bb0
            public final Context a;
            public final Intent b;

            {
                this.a = context;
                this.b = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                ServiceInfo serviceInfo;
                String str2;
                int i;
                Context context2 = this.a;
                Intent intent2 = this.b;
                TE1 te1A = TE1.a();
                te1A.d.offer(intent2);
                Intent intent3 = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent3.setPackage(context2.getPackageName());
                synchronized (te1A) {
                    try {
                        str = te1A.a;
                        if (str == null) {
                            ResolveInfo resolveInfoResolveService = context2.getPackageManager().resolveService(intent3, 0);
                            if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
                                Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
                            } else {
                                if (context2.getPackageName().equals(serviceInfo.packageName) && (str2 = serviceInfo.name) != null) {
                                    if (str2.startsWith(".")) {
                                        String strValueOf = String.valueOf(context2.getPackageName());
                                        String strValueOf2 = String.valueOf(serviceInfo.name);
                                        te1A.a = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                                    } else {
                                        te1A.a = serviceInfo.name;
                                    }
                                    str = te1A.a;
                                }
                                String str3 = serviceInfo.packageName;
                                String str4 = serviceInfo.name;
                                StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 94 + String.valueOf(str4).length());
                                sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                                sb.append(str3);
                                sb.append("/");
                                sb.append(str4);
                                Log.e("FirebaseInstanceId", sb.toString());
                            }
                            str = null;
                        }
                    } finally {
                    }
                }
                if (str != null) {
                    intent3.setClassName(context2.getPackageName(), str);
                }
                try {
                    if ((te1A.c(context2) ? AbstractC0073Fq2.a(context2, intent3) : context2.startService(intent3)) == null) {
                        Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                        i = 404;
                    } else {
                        i = -1;
                    }
                } catch (IllegalStateException e) {
                    String strValueOf3 = String.valueOf(e);
                    StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 45);
                    sb2.append("Failed to start service while in background: ");
                    sb2.append(strValueOf3);
                    Log.e("FirebaseInstanceId", sb2.toString());
                    i = 402;
                } catch (SecurityException e2) {
                    Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e2);
                    i = 401;
                }
                return Integer.valueOf(i);
            }
        };
        Executor executor = this.b;
        return Y62.c(executor, callable).n(executor, new xN(context, intent) { // from class: Cb0
            public final Context a;
            public final Intent b;

            {
                this.a = context;
                this.b = intent;
            }

            @Override // defpackage.xN
            public final Object a(G62 g62) {
                return (PlatformVersion.isAtLeastO() && ((Integer) g62.h()).intValue() == 402) ? C0055Eb0.a(this.a, this.b).f(ExecutorC0857if0.t, C0041Db0.c) : g62;
            }
        });
    }

    public C0055Eb0(Context context, ThreadPoolExecutor threadPoolExecutor) {
        this.a = context;
        this.b = threadPoolExecutor;
    }
}
