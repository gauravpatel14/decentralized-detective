package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.d;
import androidx.fragment.app.y;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class kW extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup t;
    public final /* synthetic */ View u;
    public final /* synthetic */ boolean v;
    public final /* synthetic */ y w;
    public final /* synthetic */ d x;

    public kW(ViewGroup viewGroup, View view, boolean z, y yVar, d dVar) {
        this.t = viewGroup;
        this.u = view;
        this.v = z;
        this.w = yVar;
        this.x = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.t;
        View view = this.u;
        viewGroup.endViewTransition(view);
        if (this.v) {
            AbstractC1609vM1.a(this.w.a, view, viewGroup);
        }
        d dVar = this.x;
        dVar.c.a.c(dVar);
    }
}
