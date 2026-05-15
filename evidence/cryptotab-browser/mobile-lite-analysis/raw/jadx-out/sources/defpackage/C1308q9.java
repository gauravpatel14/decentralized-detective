package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

/* JADX INFO: renamed from: q9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1308q9 extends AnimatorListenerAdapter {
    public final /* synthetic */ t9 t;

    public C1308q9(t9 t9Var) {
        this.t = t9Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        t9 t9Var = this.t;
        ArrayList arrayList = new ArrayList(t9Var.x);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC0754h9) arrayList.get(i)).b(t9Var);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        t9 t9Var = this.t;
        ArrayList arrayList = new ArrayList(t9Var.x);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC0754h9) arrayList.get(i)).c(t9Var);
        }
    }
}
