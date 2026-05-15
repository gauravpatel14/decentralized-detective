package defpackage;

import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ab implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int t;
    public final /* synthetic */ Object u;

    public /* synthetic */ Ab(int i, Object obj) {
        this.t = i;
        this.u = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.t) {
            case 0:
                AppCompatSpinner appCompatSpinner = (AppCompatSpinner) this.u;
                if (!appCompatSpinner.y.q()) {
                    appCompatSpinner.y.p(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
                break;
            default:
                Fb fb = (Fb) this.u;
                AppCompatSpinner appCompatSpinner2 = fb.Z;
                fb.getClass();
                if (appCompatSpinner2.isAttachedToWindow() && appCompatSpinner2.getGlobalVisibleRect(fb.X)) {
                    fb.d();
                    fb.a();
                } else {
                    fb.dismiss();
                }
                break;
        }
    }
}
