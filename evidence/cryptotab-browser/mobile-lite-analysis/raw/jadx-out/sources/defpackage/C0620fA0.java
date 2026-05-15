package defpackage;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: renamed from: fA0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0620fA0 implements bs1 {
    public final /* synthetic */ nA0 a;

    public C0620fA0(nA0 na0) {
        this.a = na0;
    }

    @Override // defpackage.bs1
    public final void a(MotionEvent motionEvent) {
        nA0 na0 = this.a;
        na0.x.onTouchEvent(motionEvent);
        VelocityTracker velocityTracker = na0.t;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (na0.l == -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int iFindPointerIndex = motionEvent.findPointerIndex(na0.l);
        if (iFindPointerIndex >= 0) {
            na0.l(actionMasked, iFindPointerIndex, motionEvent);
        }
        ps1 ps1Var = na0.c;
        if (ps1Var == null) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (iFindPointerIndex >= 0) {
                    na0.u(na0.o, iFindPointerIndex, motionEvent);
                    na0.r(ps1Var);
                    RecyclerView recyclerView = na0.r;
                    RunnableC0559eA0 runnableC0559eA0 = na0.s;
                    recyclerView.removeCallbacks(runnableC0559eA0);
                    runnableC0559eA0.run();
                    na0.r.invalidate();
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 6) {
                    return;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == na0.l) {
                    na0.l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                    na0.u(na0.o, actionIndex, motionEvent);
                    return;
                }
                return;
            }
            VelocityTracker velocityTracker2 = na0.t;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        }
        na0.t(null, 0);
        na0.l = -1;
    }

    @Override // defpackage.bs1
    public final boolean b(MotionEvent motionEvent) {
        int iFindPointerIndex;
        nA0 na0 = this.a;
        na0.x.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        C0686gA0 c0686gA0 = null;
        if (actionMasked == 0) {
            na0.l = motionEvent.getPointerId(0);
            na0.d = motionEvent.getX();
            na0.e = motionEvent.getY();
            VelocityTracker velocityTracker = na0.t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            na0.t = VelocityTracker.obtain();
            if (na0.c == null) {
                ArrayList arrayList = na0.p;
                if (!arrayList.isEmpty()) {
                    View viewO = na0.o(motionEvent);
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        C0686gA0 c0686gA02 = (C0686gA0) arrayList.get(size);
                        if (c0686gA02.x.t == viewO) {
                            c0686gA0 = c0686gA02;
                            break;
                        }
                        size--;
                    }
                }
                if (c0686gA0 != null) {
                    na0.d -= c0686gA0.B;
                    na0.e -= c0686gA0.C;
                    ps1 ps1Var = c0686gA0.x;
                    na0.n(ps1Var, true);
                    if (na0.a.remove(ps1Var.t)) {
                        na0.m.b(na0.r, ps1Var);
                    }
                    na0.t(ps1Var, c0686gA0.y);
                    na0.u(na0.o, 0, motionEvent);
                }
            }
        } else if (actionMasked == 3 || actionMasked == 1) {
            na0.l = -1;
            na0.t(null, 0);
        } else {
            int i = na0.l;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                na0.l(actionMasked, iFindPointerIndex, motionEvent);
            }
        }
        VelocityTracker velocityTracker2 = na0.t;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return na0.c != null;
    }

    @Override // defpackage.bs1
    public final void e(boolean z) {
        if (z) {
            this.a.t(null, 0);
        }
    }
}
