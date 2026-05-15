package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import org.chromium.ui.base.WindowAndroid;

/* JADX INFO: renamed from: hv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0808hv2 extends AnimatorListenerAdapter {
    public final /* synthetic */ WindowAndroid t;

    public C0808hv2(WindowAndroid windowAndroid) {
        this.t = windowAndroid;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        animator.removeListener(this);
        WindowAndroid windowAndroid = this.t;
        windowAndroid.A.remove(animator);
        if (windowAndroid.A.isEmpty()) {
            windowAndroid.B.setWillNotDraw(true);
        }
    }
}
