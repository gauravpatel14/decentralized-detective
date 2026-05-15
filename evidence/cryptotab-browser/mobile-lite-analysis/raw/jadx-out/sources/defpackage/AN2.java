package defpackage;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AN2 {
    public static volatile AN2 g;
    public final Clock a = DefaultClock.getInstance();
    public final ExecutorService b;
    public final Qc c;
    public int d;
    public boolean e;
    public volatile DI2 f;

    public AN2(Context context, Bundle bundle) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new AL2());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.b = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.c = new Qc(this);
        new ArrayList();
        try {
            RU2.b(context, WQ2.a(context));
        } catch (IllegalStateException unused) {
        }
        b(new C0891jK2(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w("FA", "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new C1839zN2(this));
        }
    }

    public static AN2 c(Context context, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (g == null) {
            synchronized (AN2.class) {
                try {
                    if (g == null) {
                        g = new AN2(context, bundle);
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public final void a(Exception exc, boolean z, boolean z2) {
        this.e |= z;
        if (z) {
            Log.w("FA", "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            b(new C1553uL2(this, "Error with data collection. Data lost.", exc));
        }
        Log.w("FA", "Error with data collection. Data lost.", exc);
    }

    public final void b(AbstractRunnableC1610vM2 abstractRunnableC1610vM2) {
        this.b.execute(abstractRunnableC1610vM2);
    }
}
