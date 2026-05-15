package defpackage;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: renamed from: tA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1483tA0 implements Sd {
    public final cj0 t;
    public final AA0 u;
    public final C0589eX v;
    public final WeakReference w;

    public C1483tA0(Activity activity, cj0 cj0Var, AA0 aa0) {
        this.t = cj0Var;
        this.u = aa0;
        int i = AbstractC1872zv.a;
        this.v = new C0589eX();
        this.w = new WeakReference(activity);
    }

    public final void a(Window window) {
        cj0 cj0Var = this.t;
        cj0Var.b.set(false);
        if (window != null) {
            try {
                window.removeOnFrameMetricsAvailableListener(cj0Var);
            } catch (IllegalArgumentException unused) {
                Log.e("cr_JankTracker", String.format(Locale.US, "Could not remove listener %s from window %s", cj0Var, window));
            }
        }
    }

    @Override // defpackage.Sd
    public final void e(Activity activity, int i) {
        int i2 = AbstractC1872zv.a;
        BA0 ba0 = BA0.b;
        AA0 aa0 = this.u;
        if (i == 2 || i == 3) {
            if (!aa0.c.getAndSet(true)) {
                Handler handler = AbstractC1819zA0.a;
                handler.post(new RunnableC1713xA0(aa0.a, ba0, true, handler, null));
                handler.postDelayed(aa0.b, 5000L);
            }
            this.t.b.set(true);
            return;
        }
        if (i == 4) {
            if (!aa0.c.getAndSet(true)) {
                Handler handler2 = AbstractC1819zA0.a;
                handler2.post(new RunnableC1713xA0(aa0.a, ba0, true, handler2, null));
                handler2.postDelayed(aa0.b, 5000L);
            }
            a(null);
            return;
        }
        if (i != 5) {
            return;
        }
        if (aa0.c.getAndSet(false)) {
            Handler handler3 = AbstractC1819zA0.a;
            RunnableC1766yA0 runnableC1766yA0 = aa0.b;
            handler3.removeCallbacks(runnableC1766yA0);
            handler3.post(runnableC1766yA0);
        }
        a(null);
    }
}
