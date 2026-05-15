package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class lb0 extends AnimatorListenerAdapter {
    public boolean t = false;
    public final /* synthetic */ C1163nb0 u;

    public lb0(C1163nb0 c1163nb0) {
        this.u = c1163nb0;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.t = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.t) {
            this.t = false;
            return;
        }
        C1163nb0 c1163nb0 = this.u;
        if (((Float) c1163nb0.z.getAnimatedValue()).floatValue() == 0.0f) {
            c1163nb0.A = 0;
            c1163nb0.m(0);
        } else {
            c1163nb0.A = 2;
            c1163nb0.s.invalidate();
        }
    }
}
