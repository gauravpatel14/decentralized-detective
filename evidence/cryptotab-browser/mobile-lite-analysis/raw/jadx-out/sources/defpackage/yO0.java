package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import androidx.mediarouter.app.d;
import java.util.HashSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class yO0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ d t;

    public yO0(d dVar) {
        this.t = dVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        d dVar = this.t;
        dVar.X.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        HashSet hashSet = dVar.a0;
        if (hashSet == null || hashSet.size() == 0) {
            dVar.n(true);
            return;
        }
        AnimationAnimationListenerC1840zO0 animationAnimationListenerC1840zO0 = new AnimationAnimationListenerC1840zO0(dVar);
        int firstVisiblePosition = dVar.X.getFirstVisiblePosition();
        boolean z = false;
        for (int i = 0; i < dVar.X.getChildCount(); i++) {
            View childAt = dVar.X.getChildAt(i);
            if (dVar.a0.contains((C0838iP0) dVar.Y.getItem(firstVisiblePosition + i))) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(dVar.B0);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                if (!z) {
                    alphaAnimation.setAnimationListener(animationAnimationListenerC1840zO0);
                    z = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(alphaAnimation);
            }
        }
    }
}
