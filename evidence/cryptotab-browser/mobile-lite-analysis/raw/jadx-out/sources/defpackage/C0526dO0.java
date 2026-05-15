package defpackage;

import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import android.util.SparseArray;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: dO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0526dO0 extends UO0 {
    public final String f;
    public final MediaRouter2.RoutingController g;
    public final Messenger h;
    public final Messenger i;
    public final Handler k;
    public OO0 o;
    public final SparseArray j = new SparseArray();
    public final AtomicInteger l = new AtomicInteger(1);
    public final RunnableC0406bO0 m = new Runnable() { // from class: bO0
        @Override // java.lang.Runnable
        public final void run() {
            this.t.n = -1;
        }
    };
    public int n = -1;

    /* JADX WARN: Type inference failed for: r2v3, types: [bO0] */
    public C0526dO0(C0772hO0 c0772hO0, MediaRouter2.RoutingController routingController, String str) {
        Bundle controlHints;
        this.g = routingController;
        this.f = str;
        Messenger messenger = (routingController == null || (controlHints = routingController.getControlHints()) == null) ? null : (Messenger) controlHints.getParcelable("androidx.mediarouter.media.KEY_MESSENGER");
        this.h = messenger;
        this.i = messenger != null ? new Messenger(new HandlerC0466cO0(this)) : null;
        this.k = new Handler(Looper.getMainLooper());
    }

    @Override // defpackage.XO0
    public final void d() {
        this.g.release();
    }

    @Override // defpackage.XO0
    public final void f(int i) {
        MediaRouter2.RoutingController routingController = this.g;
        if (routingController == null) {
            return;
        }
        routingController.setVolume(i);
        this.n = i;
        Handler handler = this.k;
        RunnableC0406bO0 runnableC0406bO0 = this.m;
        handler.removeCallbacks(runnableC0406bO0);
        handler.postDelayed(runnableC0406bO0, 1000L);
    }

    @Override // defpackage.XO0
    public final void i(int i) {
        MediaRouter2.RoutingController routingController = this.g;
        if (routingController == null) {
            return;
        }
        int volume = this.n;
        if (volume < 0) {
            volume = routingController.getVolume();
        }
        int iMax = Math.max(0, Math.min(volume + i, this.g.getVolumeMax()));
        this.n = iMax;
        this.g.setVolume(iMax);
        Handler handler = this.k;
        RunnableC0406bO0 runnableC0406bO0 = this.m;
        handler.removeCallbacks(runnableC0406bO0);
        handler.postDelayed(runnableC0406bO0, 1000L);
    }
}
