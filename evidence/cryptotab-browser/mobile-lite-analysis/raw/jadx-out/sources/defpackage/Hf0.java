package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Hf0 implements ViewTreeObserver.OnDrawListener {
    public final /* synthetic */ Kf0 t;

    public Hf0(Kf0 kf0) {
        this.t = kf0;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        Kf0 kf0 = this.t;
        if (kf0.c) {
            return;
        }
        kf0.c = true;
        Runnable runnable = kf0.b;
        if (runnable != null) {
            runnable.run();
            kf0.b = null;
        }
        PostTask.c(6, new Runnable() { // from class: Gf0
            @Override // java.lang.Runnable
            public final void run() {
                Hf0 hf0 = this.t;
                Kf0 kf02 = hf0.t;
                if (kf02.a.get() == null) {
                    return;
                }
                ((View) kf02.a.get()).getViewTreeObserver().removeOnDrawListener(hf0);
            }
        });
    }
}
