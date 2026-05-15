package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: jb0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0915jb0 implements Runnable {
    public final /* synthetic */ C1163nb0 t;

    public RunnableC0915jb0(C1163nb0 c1163nb0) {
        this.t = c1163nb0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1163nb0 c1163nb0 = this.t;
        int i = c1163nb0.A;
        ValueAnimator valueAnimator = c1163nb0.z;
        if (i == 1) {
            valueAnimator.cancel();
        } else if (i != 2) {
            return;
        }
        c1163nb0.A = 3;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        valueAnimator.setDuration(500);
        valueAnimator.start();
    }
}
