package defpackage;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Kf0 {
    public final WeakReference a;
    public Runnable b;
    public boolean c;

    public Kf0(View view, Runnable runnable) {
        this.a = new WeakReference(view);
        this.b = runnable;
    }

    public final void a(boolean z) {
        Hf0 hf0 = new Hf0(this);
        WeakReference weakReference = this.a;
        ((View) weakReference.get()).getViewTreeObserver().addOnDrawListener(hf0);
        if (z) {
            return;
        }
        ((View) weakReference.get()).getViewTreeObserver().addOnPreDrawListener(new Jf0(this));
    }
}
