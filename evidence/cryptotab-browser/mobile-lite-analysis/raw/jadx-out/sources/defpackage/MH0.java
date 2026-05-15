package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import org.chromium.ui.widget.LoadingView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MH0 extends AnimatorListenerAdapter {
    public final /* synthetic */ LH0 t;

    public MH0(LH0 lh0) {
        this.t = lh0;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        LoadingView loadingView = this.t.u;
        int i = LoadingView.y;
        loadingView.d();
    }
}
