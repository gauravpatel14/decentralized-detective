package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: renamed from: gA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0686gA0 implements Animator.AnimatorListener {
    public boolean A;
    public float B;
    public float C;
    public boolean D = false;
    public boolean E = false;
    public float F;
    public final /* synthetic */ int G;
    public final /* synthetic */ ps1 H;
    public final /* synthetic */ nA0 I;
    public final float t;
    public final float u;
    public final float v;
    public final float w;
    public final ps1 x;
    public final int y;
    public final ValueAnimator z;

    public C0686gA0(nA0 na0, ps1 ps1Var, int i, float f, float f2, float f3, float f4, int i2, ps1 ps1Var2) {
        this.I = na0;
        this.G = i2;
        this.H = ps1Var2;
        this.y = i;
        this.x = ps1Var;
        this.t = f;
        this.u = f2;
        this.v = f3;
        this.w = f4;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new lA0(this));
        valueAnimatorOfFloat.setTarget(ps1Var.t);
        valueAnimatorOfFloat.addListener(this);
        this.F = 0.0f;
    }

    public final void a(Animator animator) {
        if (!this.E) {
            this.x.s(true);
        }
        this.E = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.F = 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        a(animator);
        if (this.D) {
            return;
        }
        int i = this.G;
        ps1 ps1Var = this.H;
        nA0 na0 = this.I;
        if (i <= 0) {
            na0.m.b(na0.r, ps1Var);
        } else {
            na0.a.add(ps1Var.t);
            this.A = true;
            if (i > 0) {
                na0.r.post(new RunnableC0755hA0(na0, this, i));
            }
        }
        View view = na0.w;
        View view2 = ps1Var.t;
        if (view == view2) {
            na0.s(view2);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
