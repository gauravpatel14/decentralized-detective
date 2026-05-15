package defpackage;

import android.view.animation.Animation;
import androidx.mediarouter.app.d;

/* JADX INFO: renamed from: zO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationAnimationListenerC1840zO0 implements Animation.AnimationListener {
    public final /* synthetic */ d a;

    public AnimationAnimationListenerC1840zO0(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.a.n(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
