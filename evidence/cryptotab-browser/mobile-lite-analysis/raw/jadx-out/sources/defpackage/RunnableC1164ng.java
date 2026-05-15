package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: ng, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1164ng implements Runnable {
    public static Handler y;
    public final /* synthetic */ AbstractC1230og x;
    public volatile int u = 1;
    public final AtomicBoolean v = new AtomicBoolean();
    public final AtomicBoolean w = new AtomicBoolean();
    public final qU0 t = new qU0(this, new pU0(this));

    public RunnableC1164ng(AbstractC1230og abstractC1230og) {
        this.x = abstractC1230og;
    }

    public final void a(Object obj) {
        Handler handler;
        synchronized (RunnableC1164ng.class) {
            try {
                if (y == null) {
                    y = new Handler(Looper.getMainLooper());
                }
                handler = y;
            } catch (Throwable th) {
                throw th;
            }
        }
        handler.post(new rU0(this, obj));
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.x.b();
    }
}
