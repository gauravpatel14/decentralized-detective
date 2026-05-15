package defpackage;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.gcm.PendingCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: ul0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractServiceC1578ul0 extends Service {
    public final Object t = new Object();
    public int u;
    public ExecutorService v;
    public Messenger w;
    public ComponentName x;
    public C1407rl0 y;
    public C0592eZ2 z;

    public abstract int b(T62 t62);

    public final void c(int i) {
        synchronized (this.t) {
            try {
                this.u = i;
                if (!this.y.b(this.x.getClassName())) {
                    stopSelf(this.u);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d(String str) {
        boolean z;
        boolean z2;
        synchronized (this.t) {
            try {
                C1407rl0 c1407rl0 = this.y;
                String className = this.x.getClassName();
                synchronized (c1407rl0) {
                    try {
                        Map gfVar = (Map) c1407rl0.a.get(className);
                        z = false;
                        if (gfVar == null) {
                            gfVar = new gf(0);
                            c1407rl0.a.put(className, gfVar);
                        }
                        if (gfVar.put(str, Boolean.FALSE) == null) {
                            z = true;
                        }
                    } finally {
                    }
                }
                z2 = !z;
                if (!z) {
                    String packageName = getPackageName();
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 44 + String.valueOf(str).length());
                    sb.append(packageName);
                    sb.append(" ");
                    sb.append(str);
                    sb.append(": Task already running, won't start another");
                    Log.w("GcmTaskService", sb.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if (intent != null && PlatformVersion.isAtLeastLollipop() && "com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) {
            return this.w.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        C1407rl0 c1407rl0;
        super.onCreate();
        synchronized (C1407rl0.class) {
            try {
                if (C1407rl0.b == null) {
                    getApplicationContext();
                    C1407rl0.b = new C1407rl0();
                }
                c1407rl0 = C1407rl0.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.y = c1407rl0;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC1146nN2());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.v = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.w = new Messenger(new HandlerC1467sl0(this, Looper.getMainLooper()));
        this.x = new ComponentName(this, getClass());
        this.z = AbstractC1795yY2.a;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        List<Runnable> listShutdownNow = this.v.shutdownNow();
        if (listShutdownNow.isEmpty()) {
            return;
        }
        int size = listShutdownNow.size();
        StringBuilder sb = new StringBuilder(79);
        sb.append("Shutting down, but not all tasks are finished executing. Remaining: ");
        sb.append(size);
        Log.e("GcmTaskService", sb.toString());
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        try {
            intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
            String action = intent.getAction();
            if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                String stringExtra = intent.getStringExtra("tag");
                Parcelable parcelableExtra = intent.getParcelableExtra("callback");
                Bundle bundleExtra = intent.getBundleExtra("extras");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("triggered_uris");
                long longExtra = intent.getLongExtra("max_exec_duration", 180L);
                if (!(parcelableExtra instanceof PendingCallback)) {
                    String packageName = getPackageName();
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 47 + String.valueOf(stringExtra).length());
                    sb.append(packageName);
                    sb.append(" ");
                    sb.append(stringExtra);
                    sb.append(": Could not process request, invalid callback.");
                    Log.e("GcmTaskService", sb.toString());
                    return 2;
                }
                if (d(stringExtra)) {
                    return 2;
                }
                RunnableC1526tl0 runnableC1526tl0 = new RunnableC1526tl0(this, stringExtra, ((PendingCallback) parcelableExtra).t, bundleExtra, longExtra, parcelableArrayListExtra);
                try {
                    this.v.execute(runnableC1526tl0);
                } catch (RejectedExecutionException e) {
                    Log.e("GcmTaskService", "Executor is shutdown. onDestroy was called but main looper had an unprocessed start task message. The task will be retried with backoff delay.", e);
                    runnableC1526tl0.a(1);
                }
            } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                a();
            } else {
                StringBuilder sb2 = new StringBuilder(String.valueOf(action).length() + 37);
                sb2.append("Unknown action received ");
                sb2.append(action);
                sb2.append(", terminating");
                Log.e("GcmTaskService", sb2.toString());
            }
            return 2;
        } finally {
            c(i2);
        }
    }

    public void a() {
    }
}
