package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import defpackage.AbstractC1555uM1;
import defpackage.C0375am;
import defpackage.Rh0;
import defpackage.kW;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AbstractC1555uM1 {
    public final c c;
    public AnimatorSet d;

    public d(c cVar) {
        this.c = cVar;
    }

    @Override // defpackage.AbstractC1555uM1
    public final void b(ViewGroup viewGroup) {
        AnimatorSet animatorSet = this.d;
        y yVar = this.c.a;
        if (animatorSet == null) {
            yVar.c(this);
        } else if (yVar.g) {
            animatorSet.reverse();
        } else {
            animatorSet.end();
        }
    }

    @Override // defpackage.AbstractC1555uM1
    public final void c(ViewGroup viewGroup) {
        y yVar = this.c.a;
        AnimatorSet animatorSet = this.d;
        if (animatorSet == null) {
            yVar.c(this);
        } else {
            animatorSet.start();
        }
    }

    @Override // defpackage.AbstractC1555uM1
    public final void d(C0375am c0375am) {
        c cVar = this.c;
        AnimatorSet animatorSet = this.d;
        y yVar = cVar.a;
        if (animatorSet == null) {
            yVar.c(this);
            return;
        }
        if (Build.VERSION.SDK_INT < 34 || !yVar.c.mTransitioning) {
            return;
        }
        long totalDuration = animatorSet.getTotalDuration();
        long j = (long) (c0375am.c * totalDuration);
        if (j == 0) {
            j = 1;
        }
        if (j == totalDuration) {
            j = totalDuration - 1;
        }
        animatorSet.setCurrentPlayTime(j);
    }

    @Override // defpackage.AbstractC1555uM1
    public final void e(ViewGroup viewGroup) {
        c cVar = this.c;
        if (cVar.a()) {
            return;
        }
        Rh0 rh0B = cVar.b(viewGroup.getContext());
        this.d = rh0B != null ? rh0B.b : null;
        y yVar = cVar.a;
        n nVar = yVar.c;
        boolean z = yVar.a == 3;
        View view = nVar.mView;
        viewGroup.startViewTransition(view);
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.addListener(new kW(viewGroup, view, z, yVar, this));
        }
        AnimatorSet animatorSet2 = this.d;
        if (animatorSet2 != null) {
            animatorSet2.setTarget(view);
        }
    }
}
