package defpackage;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Eb implements PopupWindow.OnDismissListener {
    public final /* synthetic */ Ab t;
    public final /* synthetic */ Fb u;

    public Eb(Fb fb, Ab ab) {
        this.u = fb;
        this.t = ab;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.u.Z.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.t);
        }
    }
}
