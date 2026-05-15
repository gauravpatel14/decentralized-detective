package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class kA0 extends GestureDetector.SimpleOnGestureListener {
    public boolean a = true;
    public final /* synthetic */ nA0 b;

    public kA0(nA0 na0) {
        this.b = na0;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        nA0 na0;
        View viewO;
        ps1 ps1VarM;
        if (!this.a || (viewO = (na0 = this.b).o(motionEvent)) == null || (ps1VarM = na0.r.M(viewO)) == null) {
            return;
        }
        AbstractC0882jA0 abstractC0882jA0 = na0.m;
        RecyclerView recyclerView = na0.r;
        if ((AbstractC0882jA0.c(abstractC0882jA0.e(recyclerView, ps1VarM), recyclerView.getLayoutDirection()) & 16711680) != 0) {
            int pointerId = motionEvent.getPointerId(0);
            int i = na0.l;
            if (pointerId == i) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                na0.d = x;
                na0.e = y;
                na0.i = 0.0f;
                na0.h = 0.0f;
                if (na0.m.i()) {
                    na0.t(ps1VarM, 2);
                }
            }
        }
    }
}
