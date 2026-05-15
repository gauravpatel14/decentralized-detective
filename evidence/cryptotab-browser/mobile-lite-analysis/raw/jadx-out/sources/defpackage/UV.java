package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UV extends AnimatorListenerAdapter {
    public final /* synthetic */ int t = 1;
    public final /* synthetic */ ps1 u;
    public final /* synthetic */ View v;
    public final /* synthetic */ ViewPropertyAnimator w;
    public final /* synthetic */ ZV x;

    public UV(ZV zv, ps1 ps1Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.x = zv;
        this.u = ps1Var;
        this.w = viewPropertyAnimator;
        this.v = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.t) {
            case 1:
                this.v.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.t) {
            case 0:
                this.w.setListener(null);
                this.v.setAlpha(1.0f);
                ZV zv = this.x;
                ps1 ps1Var = this.u;
                zv.g(ps1Var);
                zv.q.remove(ps1Var);
                zv.n();
                break;
            default:
                this.w.setListener(null);
                ZV zv2 = this.x;
                ps1 ps1Var2 = this.u;
                zv2.g(ps1Var2);
                zv2.o.remove(ps1Var2);
                zv2.n();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.t) {
            case 0:
                this.x.getClass();
                break;
            default:
                this.x.getClass();
                break;
        }
    }

    public UV(ZV zv, ps1 ps1Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.x = zv;
        this.u = ps1Var;
        this.v = view;
        this.w = viewPropertyAnimator;
    }
}
