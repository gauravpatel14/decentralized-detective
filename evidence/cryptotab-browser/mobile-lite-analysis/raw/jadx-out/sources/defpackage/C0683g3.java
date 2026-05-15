package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: renamed from: g3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0683g3 extends AnimatorListenerAdapter {
    public final /* synthetic */ ActionBarOverlayLayout t;

    public C0683g3(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.t = actionBarOverlayLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.t;
        actionBarOverlayLayout.S = null;
        actionBarOverlayLayout.C = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.t;
        actionBarOverlayLayout.S = null;
        actionBarOverlayLayout.C = false;
    }
}
