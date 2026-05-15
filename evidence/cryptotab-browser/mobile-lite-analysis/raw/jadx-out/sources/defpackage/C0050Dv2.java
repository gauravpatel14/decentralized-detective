package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: renamed from: Dv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0050Dv2 extends AnimatorListenerAdapter {
    public final /* synthetic */ C0134Lv2 t;
    public final /* synthetic */ View u;

    public C0050Dv2(C0134Lv2 c0134Lv2, View view) {
        this.t = c0134Lv2;
        this.u = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        C0134Lv2 c0134Lv2 = this.t;
        c0134Lv2.a.d(1.0f);
        C0086Gv2.e(c0134Lv2, this.u);
    }
}
