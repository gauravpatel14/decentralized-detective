package defpackage;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: renamed from: Ev2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0061Ev2 implements Runnable {
    public final /* synthetic */ View t;
    public final /* synthetic */ C0134Lv2 u;
    public final /* synthetic */ C0022Bv2 v;
    public final /* synthetic */ ValueAnimator w;

    public RunnableC0061Ev2(View view, C0134Lv2 c0134Lv2, C0022Bv2 c0022Bv2, ValueAnimator valueAnimator) {
        this.t = view;
        this.u = c0134Lv2;
        this.v = c0022Bv2;
        this.w = valueAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0086Gv2.h(this.t, this.u, this.v);
        this.w.start();
    }
}
