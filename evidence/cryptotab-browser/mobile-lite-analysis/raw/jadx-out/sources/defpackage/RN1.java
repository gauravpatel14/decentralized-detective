package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RN1 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ SN1 t;

    public RN1(SN1 sn1) {
        this.t = sn1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        SN1 sn1 = this.t;
        ViewTreeObserver viewTreeObserver = sn1.H;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                sn1.H = view.getViewTreeObserver();
            }
            sn1.H.removeGlobalOnLayoutListener(sn1.B);
        }
        view.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
