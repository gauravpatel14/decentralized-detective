package defpackage;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dI implements ViewTreeObserver.OnDrawListener, Runnable, Executor {
    public final long t = SystemClock.uptimeMillis() + ((long) 10000);
    public Runnable u;
    public boolean v;
    public final /* synthetic */ iI w;

    public dI(iI iIVar) {
        this.w = iIVar;
    }

    public final void a(View view) {
        if (this.v) {
            return;
        }
        this.v = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.u = runnable;
        View decorView = this.w.getWindow().getDecorView();
        if (!this.v) {
            decorView.postOnAnimation(new VH(2, this));
        } else if (lz0.a(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z;
        Runnable runnable = this.u;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.t) {
                this.v = false;
                this.w.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.u = null;
        C0731gk0 c0731gk0 = (C0731gk0) this.w.z.getValue();
        synchronized (c0731gk0.a) {
            z = c0731gk0.b;
        }
        if (z) {
            this.v = false;
            this.w.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.w.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
