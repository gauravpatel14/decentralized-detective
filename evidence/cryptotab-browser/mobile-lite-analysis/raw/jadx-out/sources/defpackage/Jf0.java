package defpackage;

import android.view.Choreographer;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jf0 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ Kf0 t;

    public Jf0(Kf0 kf0) {
        this.t = kf0;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: If0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                Kf0 kf0 = this.a.t;
                Runnable runnable = kf0.b;
                if (runnable != null) {
                    runnable.run();
                    kf0.b = null;
                }
            }
        });
        Kf0 kf0 = this.t;
        if (kf0.a.get() == null) {
            return true;
        }
        ((View) kf0.a.get()).getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
