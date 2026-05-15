package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.animation.Animation;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Rh0 {
    public final Animation a;
    public final AnimatorSet b;

    public Rh0(Animation animation) {
        this.a = animation;
        this.b = null;
    }

    public Rh0(Animator animator) {
        this.a = null;
        AnimatorSet animatorSet = new AnimatorSet();
        this.b = animatorSet;
        animatorSet.play(animator);
    }
}
