package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mb0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C1163nb0 t;

    public mb0(C1163nb0 c1163nb0) {
        this.t = c1163nb0;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        C1163nb0 c1163nb0 = this.t;
        c1163nb0.c.setAlpha(iFloatValue);
        c1163nb0.d.setAlpha(iFloatValue);
        c1163nb0.s.invalidate();
    }
}
