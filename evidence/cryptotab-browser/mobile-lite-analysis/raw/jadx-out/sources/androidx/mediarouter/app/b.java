package androidx.mediarouter.app;

import android.view.animation.Animation;
import defpackage.Q51;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Animation.AnimationListener {
    public final /* synthetic */ d a;

    public b(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        d dVar = this.a;
        OverlayListView overlayListView = dVar.X;
        for (Q51 q51 : overlayListView.t) {
            if (!q51.j) {
                q51.i = overlayListView.getDrawingTime();
                q51.j = true;
            }
        }
        dVar.X.postDelayed(dVar.H0, dVar.A0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }
}
