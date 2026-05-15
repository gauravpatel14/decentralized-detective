package androidx.fragment.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import defpackage.AbstractC1555uM1;
import defpackage.Rh0;
import defpackage.RunnableC0221Sh0;
import defpackage.jW;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractC1555uM1 {
    public final c c;

    public b(c cVar) {
        this.c = cVar;
    }

    @Override // defpackage.AbstractC1555uM1
    public final void b(ViewGroup viewGroup) {
        c cVar = this.c;
        View view = cVar.a.c.mView;
        view.clearAnimation();
        viewGroup.endViewTransition(view);
        cVar.a.c(this);
    }

    @Override // defpackage.AbstractC1555uM1
    public final void c(ViewGroup viewGroup) {
        c cVar = this.c;
        boolean zA = cVar.a();
        y yVar = cVar.a;
        if (zA) {
            yVar.c(this);
            return;
        }
        Context context = viewGroup.getContext();
        View view = yVar.c.mView;
        Rh0 rh0B = cVar.b(context);
        if (rh0B == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Animation animation = rh0B.a;
        if (animation == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (yVar.a != 1) {
            view.startAnimation(animation);
            yVar.c(this);
        } else {
            viewGroup.startViewTransition(view);
            RunnableC0221Sh0 runnableC0221Sh0 = new RunnableC0221Sh0(animation, viewGroup, view);
            runnableC0221Sh0.setAnimationListener(new jW(yVar, viewGroup, view, this));
            view.startAnimation(runnableC0221Sh0);
        }
    }
}
