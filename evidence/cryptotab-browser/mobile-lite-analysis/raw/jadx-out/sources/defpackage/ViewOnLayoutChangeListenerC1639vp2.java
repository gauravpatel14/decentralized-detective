package defpackage;

import J.N;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import java.util.Iterator;
import org.chromium.base.Callback;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: vp2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnLayoutChangeListenerC1639vp2 implements b50, View.OnLayoutChangeListener, Jx {
    public final View t;
    public final Rect u;
    public final Rect v;
    public final SL1 w;
    public final float x;
    public final M21 y;

    public ViewOnLayoutChangeListenerC1639vp2(View view) {
        Rect rect = new Rect();
        this.u = rect;
        Rect rect2 = new Rect();
        this.v = rect2;
        int i = AbstractC1872zv.a;
        this.x = 1.0f;
        this.y = new M21();
        this.t = view;
        view.addOnLayoutChangeListener(this);
        rect2.set(0, 0, view.getWidth(), view.getHeight());
        rect.set(rect2);
        this.w = new SL1();
    }

    @Override // defpackage.b50
    public final void a() {
        if (this.y.isEmpty() || !h()) {
            return;
        }
        i();
    }

    @Override // defpackage.b50
    public final void b(Callback callback) {
        this.y.e(callback);
    }

    @Override // defpackage.b50
    public final void c(Callback callback) {
        this.y.g(callback);
    }

    public long f() {
        return N._J(26);
    }

    public final void g(Rect rect) {
        Rect rect2 = this.u;
        if (rect != null) {
            rect2.union(rect);
        } else {
            View view = this.t;
            rect2.set(0, 0, view.getWidth(), view.getHeight());
        }
    }

    public boolean h() {
        return !this.u.isEmpty();
    }

    public final void i() {
        Rect rect = this.u;
        int i = AbstractC1872zv.a;
        TraceEvent traceEventJ = TraceEvent.j("ViewResourceAdapter:getBitmap", null);
        try {
            if (this.w.a(this.t, new Rect(rect), this.x, this, new Callback() { // from class: up2
                @Override // org.chromium.base.Callback
                /* JADX INFO: renamed from: onResult */
                public final void a0(Object obj) {
                    ViewOnLayoutChangeListenerC1639vp2 viewOnLayoutChangeListenerC1639vp2 = this.t;
                    viewOnLayoutChangeListenerC1639vp2.getClass();
                    int i2 = AbstractC1872zv.a;
                    viewOnLayoutChangeListenerC1639vp2.w.getClass();
                    g50 g50Var = new g50((Bitmap) obj, viewOnLayoutChangeListenerC1639vp2.v, viewOnLayoutChangeListenerC1639vp2.f());
                    Iterator it = viewOnLayoutChangeListenerC1639vp2.y.iterator();
                    while (true) {
                        L21 l21 = (L21) it;
                        if (!l21.hasNext()) {
                            return;
                        } else {
                            ((Callback) l21.next()).a0(g50Var);
                        }
                    }
                }
            })) {
                rect.setEmpty();
            }
            if (traceEventJ != null) {
                traceEventJ.close();
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i3 - i;
        int i10 = i4 - i2;
        int i11 = i8 - i6;
        if (i9 == i7 - i5 && i10 == i11) {
            return;
        }
        this.v.set(0, 0, i9, i10);
        this.u.set(0, 0, i9, i10);
        this.w.getClass();
    }
}
