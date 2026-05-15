package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ch0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ AbstractViewOnTouchListenerC0044Dh0 u;

    public /* synthetic */ Ch0(AbstractViewOnTouchListenerC0044Dh0 abstractViewOnTouchListenerC0044Dh0, int i) {
        this.t = i;
        this.u = abstractViewOnTouchListenerC0044Dh0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                ViewParent parent = this.u.w.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                AbstractViewOnTouchListenerC0044Dh0 abstractViewOnTouchListenerC0044Dh0 = this.u;
                abstractViewOnTouchListenerC0044Dh0.a();
                View view = abstractViewOnTouchListenerC0044Dh0.w;
                if (view.isEnabled() && !view.isLongClickable() && abstractViewOnTouchListenerC0044Dh0.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    abstractViewOnTouchListenerC0044Dh0.z = true;
                    break;
                }
                break;
        }
    }
}
