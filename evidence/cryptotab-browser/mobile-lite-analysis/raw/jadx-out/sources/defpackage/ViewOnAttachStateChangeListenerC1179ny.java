package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: ny, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC1179ny implements View.OnAttachStateChangeListener {
    public final /* synthetic */ ry t;

    public ViewOnAttachStateChangeListenerC1179ny(ry ryVar) {
        this.t = ryVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ry ryVar = this.t;
        ViewTreeObserver viewTreeObserver = ryVar.Q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                ryVar.Q = view.getViewTreeObserver();
            }
            ryVar.Q.removeGlobalOnLayoutListener(ryVar.B);
        }
        view.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
