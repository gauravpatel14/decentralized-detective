package org.chromium.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import defpackage.AbstractC0305Yp1;
import defpackage.L21;
import defpackage.Lf;
import defpackage.M21;
import defpackage.Mf;
import defpackage.Of;
import defpackage.Pf;
import defpackage.Qf;
import java.util.Iterator;
import org.chromium.base.Callback;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AsyncViewStub extends View implements Pf {
    public int t;
    public View u;
    public final Qf v;
    public final M21 w;
    public boolean x;

    public AsyncViewStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = new M21();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.AsyncViewStub);
        this.t = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.AsyncViewStub_layout, 0);
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
        Context context2 = getContext();
        Qf qf = new Qf();
        Lf lf = new Lf(qf);
        qf.a = new Mf(context2);
        qf.b = new Handler(Looper.myLooper(), lf);
        qf.c = Of.v;
        this.v = qf;
    }

    /* JADX WARN: Finally extract failed */
    public final void a(View view, ViewGroup viewGroup) {
        this.u = view;
        TraceEvent traceEventJ = TraceEvent.j("AsyncViewStub.replaceSelfWithView", null);
        try {
            int iIndexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(view, iIndexOfChild, layoutParams);
            } else {
                viewGroup.addView(view, iIndexOfChild);
            }
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            M21 m21 = this.w;
            traceEventJ = TraceEvent.j("AsyncViewStub.callListeners", null);
            try {
                Iterator it = m21.iterator();
                while (true) {
                    L21 l21 = (L21) it;
                    if (!l21.hasNext()) {
                        break;
                    } else {
                        ((Callback) l21.next()).a0(view);
                    }
                }
                m21.clear();
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
            } finally {
                if (traceEventJ != null) {
                    try {
                        traceEventJ.close();
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }
}
