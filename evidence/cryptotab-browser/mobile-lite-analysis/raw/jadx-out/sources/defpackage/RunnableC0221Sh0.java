package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: renamed from: Sh0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0221Sh0 extends AnimationSet implements Runnable {
    public final ViewGroup t;
    public final View u;
    public boolean v;
    public boolean w;
    public boolean x;

    public RunnableC0221Sh0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.x = true;
        this.t = viewGroup;
        this.u = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation) {
        this.x = true;
        if (this.v) {
            return !this.w;
        }
        if (!super.getTransformation(j, transformation)) {
            this.v = true;
            ViewTreeObserverOnPreDrawListenerC0447c51.a(this.t, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.v;
        ViewGroup viewGroup = this.t;
        if (z || !this.x) {
            viewGroup.endViewTransition(this.u);
            this.w = true;
        } else {
            this.x = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation, float f) {
        this.x = true;
        if (this.v) {
            return !this.w;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.v = true;
            ViewTreeObserverOnPreDrawListenerC0447c51.a(this.t, this);
        }
        return true;
    }
}
