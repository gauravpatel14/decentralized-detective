package defpackage;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class A70 extends Service {
    public final ExecutorService t;
    public BinderC1587uw2 u;
    public final Object v;
    public int w;
    public int x;

    public A70() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Firebase-Messaging-Intent-Handle"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.t = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.v = new Object();
        this.x = 0;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            synchronized (AbstractC0073Fq2.b) {
                try {
                    if (AbstractC0073Fq2.c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                        AbstractC0073Fq2.c.c();
                    }
                } finally {
                }
            }
        }
        synchronized (this.v) {
            try {
                int i = this.x - 1;
                this.x = i;
                if (i == 0) {
                    stopSelfResult(this.w);
                }
            } finally {
            }
        }
    }

    public abstract void b(Intent intent);

    public final C0939k33 c(final Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            final H62 h62 = new H62();
            this.t.execute(new Runnable(this, intent, h62) { // from class: w70
                public final A70 t;
                public final Intent u;
                public final H62 v;

                {
                    this.t = this;
                    this.u = intent;
                    this.v = h62;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Intent intent2 = this.u;
                    H62 h622 = this.v;
                    A70 a70 = this.t;
                    a70.getClass();
                    try {
                        a70.b(intent2);
                    } finally {
                        h622.b(null);
                    }
                }
            });
            return h62.a;
        }
        if (YS0.b(intent)) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                m7 m7Var = (m7) C0488cf0.c().b(m7.class);
                if (m7Var != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    n7 n7Var = (n7) m7Var;
                    if (!kI2.b.contains("fcm")) {
                        AN2 an2 = n7Var.a.a;
                        an2.getClass();
                        an2.b(new C1265pM2(an2, stringExtra));
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("source", "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    n7Var.a("fcm", "_cmp", bundle);
                } else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            }
            YS0.a("_no", intent);
        }
        return Y62.e(null);
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (this.u == null) {
                this.u = new BinderC1587uw2(new z70(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.u;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.t.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i, int i2) {
        synchronized (this.v) {
            this.w = i2;
            this.x++;
        }
        Intent intent2 = (Intent) TE1.a().d.poll();
        if (intent2 == null) {
            a(intent);
            return 2;
        }
        C0939k33 c0939k33C = c(intent2);
        if (c0939k33C.j()) {
            a(intent);
            return 2;
        }
        c0939k33C.m(x70.t, new N41(this, intent) { // from class: y70
            public final A70 a;
            public final Intent b;

            {
                this.a = this;
                this.b = intent;
            }

            @Override // defpackage.N41
            public final void onComplete(G62 g62) {
                this.a.a(this.b);
            }
        });
        return 3;
    }
}
