package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class lA0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C0686gA0 t;

    public lA0(C0686gA0 c0686gA0) {
        this.t = c0686gA0;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.t.F = valueAnimator.getAnimatedFraction();
    }
}
