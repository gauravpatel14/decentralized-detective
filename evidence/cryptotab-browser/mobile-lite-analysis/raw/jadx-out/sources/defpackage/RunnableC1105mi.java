package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: mi, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1105mi implements Runnable {
    public final /* synthetic */ ViewOnTouchListenerC1138nH0 t;

    public RunnableC1105mi(ViewOnTouchListenerC1138nH0 viewOnTouchListenerC1138nH0) {
        this.t = viewOnTouchListenerC1138nH0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewOnTouchListenerC1138nH0 viewOnTouchListenerC1138nH0 = this.t;
        if (viewOnTouchListenerC1138nH0.H) {
            boolean z = viewOnTouchListenerC1138nH0.F;
            C1044li c1044li = viewOnTouchListenerC1138nH0.t;
            if (z) {
                viewOnTouchListenerC1138nH0.F = false;
                long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                c1044li.e = jCurrentAnimationTimeMillis;
                c1044li.g = -1L;
                c1044li.f = jCurrentAnimationTimeMillis;
                c1044li.h = 0.5f;
            }
            if ((c1044li.g > 0 && AnimationUtils.currentAnimationTimeMillis() > c1044li.g + ((long) c1044li.i)) || !viewOnTouchListenerC1138nH0.e()) {
                viewOnTouchListenerC1138nH0.H = false;
                return;
            }
            boolean z2 = viewOnTouchListenerC1138nH0.G;
            ListView listView = viewOnTouchListenerC1138nH0.v;
            if (z2) {
                viewOnTouchListenerC1138nH0.G = false;
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                listView.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
            if (c1044li.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
            float fA = c1044li.a(jCurrentAnimationTimeMillis2);
            long j = jCurrentAnimationTimeMillis2 - c1044li.f;
            c1044li.f = jCurrentAnimationTimeMillis2;
            viewOnTouchListenerC1138nH0.f32J.scrollListBy((int) (j * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * c1044li.d));
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            listView.postOnAnimation(this);
        }
    }
}
