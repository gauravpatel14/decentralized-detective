package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: c51, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0447c51 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View t;
    public ViewTreeObserver u;
    public final Runnable v;

    public ViewTreeObserverOnPreDrawListenerC0447c51(View view, Runnable runnable) {
        this.t = view;
        this.u = view.getViewTreeObserver();
        this.v = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        ViewTreeObserverOnPreDrawListenerC0447c51 viewTreeObserverOnPreDrawListenerC0447c51 = new ViewTreeObserverOnPreDrawListenerC0447c51(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0447c51);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0447c51);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.u.isAlive();
        View view = this.t;
        if (zIsAlive) {
            this.u.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.v.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.u = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.u.isAlive();
        View view2 = this.t;
        if (zIsAlive) {
            this.u.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
