package defpackage;

import android.transition.Transition;
import java.util.ArrayList;

/* JADX INFO: renamed from: Ni0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0158Ni0 implements Transition.TransitionListener {
    public final /* synthetic */ Object t;
    public final /* synthetic */ ArrayList u;
    public final /* synthetic */ Object v;
    public final /* synthetic */ ArrayList w;
    public final /* synthetic */ C0185Pi0 x;

    public C0158Ni0(C0185Pi0 c0185Pi0, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.x = c0185Pi0;
        this.t = obj;
        this.u = arrayList;
        this.v = obj2;
        this.w = arrayList2;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        C0185Pi0 c0185Pi0 = this.x;
        Object obj = this.t;
        if (obj != null) {
            c0185Pi0.A(obj, this.u, null);
        }
        Object obj2 = this.v;
        if (obj2 != null) {
            c0185Pi0.A(obj2, this.w, null);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }
}
