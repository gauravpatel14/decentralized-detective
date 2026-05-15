package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WV extends AnimatorListenerAdapter {
    public final /* synthetic */ int t;
    public final /* synthetic */ XV u;
    public final /* synthetic */ ViewPropertyAnimator v;
    public final /* synthetic */ View w;
    public final /* synthetic */ ZV x;

    public /* synthetic */ WV(ZV zv, XV xv, ViewPropertyAnimator viewPropertyAnimator, View view, int i) {
        this.t = i;
        this.x = zv;
        this.u = xv;
        this.v = viewPropertyAnimator;
        this.w = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.t) {
            case 0:
                this.v.setListener(null);
                View view = this.w;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                XV xv = this.u;
                ps1 ps1Var = xv.a;
                ZV zv = this.x;
                zv.g(ps1Var);
                zv.r.remove(xv.a);
                zv.n();
                break;
            default:
                this.v.setListener(null);
                View view2 = this.w;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                XV xv2 = this.u;
                ps1 ps1Var2 = xv2.b;
                ZV zv2 = this.x;
                zv2.g(ps1Var2);
                zv2.r.remove(xv2.b);
                zv2.n();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.t) {
            case 0:
                ps1 ps1Var = this.u.a;
                this.x.getClass();
                break;
            default:
                ps1 ps1Var2 = this.u.b;
                this.x.getClass();
                break;
        }
    }
}
