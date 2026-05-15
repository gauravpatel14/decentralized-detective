package defpackage;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class rU0 implements Runnable {
    public final /* synthetic */ Object t;
    public final /* synthetic */ RunnableC1164ng u;

    public rU0(RunnableC1164ng runnableC1164ng, Object obj) {
        this.u = runnableC1164ng;
        this.t = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RunnableC1164ng runnableC1164ng = this.u;
        Object obj = this.t;
        if (runnableC1164ng.v.get()) {
            AbstractC1230og abstractC1230og = runnableC1164ng.x;
            if (abstractC1230og.h == runnableC1164ng) {
                SystemClock.uptimeMillis();
                abstractC1230og.h = null;
                abstractC1230og.b();
            }
        } else {
            AbstractC1230og abstractC1230og2 = runnableC1164ng.x;
            if (abstractC1230og2.g != runnableC1164ng) {
                if (abstractC1230og2.h == runnableC1164ng) {
                    SystemClock.uptimeMillis();
                    abstractC1230og2.h = null;
                    abstractC1230og2.b();
                }
            } else if (!abstractC1230og2.c) {
                SystemClock.uptimeMillis();
                abstractC1230og2.g = null;
                FH0 fh0 = abstractC1230og2.a;
                if (fh0 != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        fh0.h(obj);
                    } else {
                        if (Log.isLoggable("LoaderManager", 4)) {
                            Log.i("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
                        }
                        fh0.i(obj);
                    }
                }
            }
        }
        runnableC1164ng.u = 3;
    }
}
