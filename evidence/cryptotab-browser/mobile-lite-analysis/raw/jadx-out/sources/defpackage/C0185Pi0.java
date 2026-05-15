package defpackage;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.n;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: Pi0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0185Pi0 extends AbstractC0207Ri0 {
    public static boolean z(Transition transition) {
        return (AbstractC0207Ri0.k(transition.getTargetIds()) && AbstractC0207Ri0.k(transition.getTargetNames()) && AbstractC0207Ri0.k(transition.getTargetTypes())) ? false : true;
    }

    public final void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                A(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (z(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transition.addTarget((View) arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget((View) arrayList.get(size2));
        }
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void a(View view, Object obj) {
        ((Transition) obj).addTarget(view);
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void b(Object obj, ArrayList arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                b(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (z(transition) || !AbstractC0207Ri0.k(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.addTarget((View) arrayList.get(i));
            i++;
        }
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void e(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // defpackage.AbstractC0207Ri0
    public final boolean g(Object obj) {
        return obj instanceof Transition;
    }

    @Override // defpackage.AbstractC0207Ri0
    public final Object h(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // defpackage.AbstractC0207Ri0
    public final boolean l() {
        return false;
    }

    @Override // defpackage.AbstractC0207Ri0
    public final boolean m(Object obj) {
        return false;
    }

    @Override // defpackage.AbstractC0207Ri0
    public final Object n(Object obj, Object obj2, Object obj3) {
        Transition ordering = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // defpackage.AbstractC0207Ri0
    public final Object o(Object obj, Object obj2) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        transitionSet.addTransition((Transition) obj2);
        return transitionSet;
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void p(Object obj, View view, ArrayList arrayList) {
        ((Transition) obj).addListener(new C0144Mi0(view, arrayList));
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void q(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((Transition) obj).addListener(new C0158Ni0(this, obj2, arrayList, obj3, arrayList2));
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void s(View view, Object obj) {
        if (view != null) {
            Rect rect = new Rect();
            AbstractC0207Ri0.j(rect, view);
            ((Transition) obj).setEpicenterCallback(new C0129Li0(0, rect));
        }
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void t(Object obj, Rect rect) {
        ((Transition) obj).setEpicenterCallback(new C0129Li0(1, rect));
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void u(n nVar, Object obj, Bx bx, mW mWVar) {
        ((Transition) obj).addListener(new C0171Oi0(mWVar));
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void w(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbstractC0207Ri0.f((View) arrayList.get(i), targets);
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    @Override // defpackage.AbstractC0207Ri0
    public final void x(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            A(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // defpackage.AbstractC0207Ri0
    public final Object y(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }
}
