package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VV extends AnimatorListenerAdapter {
    public final /* synthetic */ ps1 t;
    public final /* synthetic */ int u;
    public final /* synthetic */ View v;
    public final /* synthetic */ int w;
    public final /* synthetic */ ViewPropertyAnimator x;
    public final /* synthetic */ ZV y;

    public VV(ZV zv, ps1 ps1Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.y = zv;
        this.t = ps1Var;
        this.u = i;
        this.v = view;
        this.w = i2;
        this.x = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.u;
        View view = this.v;
        if (i != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.w != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.x.setListener(null);
        ZV zv = this.y;
        ps1 ps1Var = this.t;
        zv.g(ps1Var);
        zv.p.remove(ps1Var);
        zv.n();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.y.getClass();
    }
}
