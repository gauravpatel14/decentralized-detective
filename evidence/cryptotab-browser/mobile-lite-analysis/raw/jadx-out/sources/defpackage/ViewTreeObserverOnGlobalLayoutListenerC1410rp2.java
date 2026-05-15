package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: rp2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ViewTreeObserverOnGlobalLayoutListenerC1410rp2 extends Lr1 implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    public ViewTreeObserver A;
    public boolean B;
    public final View x;
    public final int[] v = {-1, -1};
    public final Rect w = new Rect();
    public int y = -1;
    public int z = -1;

    public ViewTreeObserverOnGlobalLayoutListenerC1410rp2(View view) {
        this.x = view;
    }

    @Override // defpackage.Lr1
    public final void a(ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7) {
        View view = this.x;
        view.addOnAttachStateChangeListener(this);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        this.A = viewTreeObserver;
        viewTreeObserver.addOnGlobalLayoutListener(this);
        this.A.addOnPreDrawListener(this);
        c(false);
        this.u = viewOnTouchListenerC1482t7;
    }

    @Override // defpackage.Lr1
    public final void b() {
        this.x.removeOnAttachStateChangeListener(this);
        ViewTreeObserver viewTreeObserver = this.A;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            this.A.removeOnGlobalLayoutListener(this);
            this.A.removeOnPreDrawListener(this);
        }
        this.A = null;
        this.u = null;
    }

    public final void c(boolean z) {
        int[] iArr = this.v;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = this.y;
        int i4 = this.z;
        View view = this.x;
        view.getLocationInWindow(iArr);
        iArr[0] = Math.max(iArr[0], 0);
        iArr[1] = Math.max(iArr[1], 0);
        this.y = view.getWidth();
        int height = view.getHeight();
        this.z = height;
        if (!z && iArr[0] == i && iArr[1] == i2 && this.y == i3 && height == i4) {
            return;
        }
        int i5 = iArr[0];
        Rect rect = this.t;
        rect.left = i5;
        rect.top = iArr[1];
        rect.right = view.getWidth() + i5;
        int height2 = view.getHeight() + rect.top;
        rect.bottom = height2;
        int i6 = rect.left;
        Rect rect2 = this.w;
        rect.left = i6 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom = height2 - rect2.bottom;
        if (!this.B) {
            boolean z2 = view.getLayoutDirection() == 1;
            int i7 = rect.left;
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            rect.left = i7 + (z2 ? view.getPaddingEnd() : view.getPaddingStart());
            rect.right -= z2 ? view.getPaddingStart() : view.getPaddingEnd();
            rect.top = view.getPaddingTop() + rect.top;
            rect.bottom -= view.getPaddingBottom();
        }
        rect.right = Math.max(rect.left, rect.right);
        rect.bottom = Math.max(rect.top, rect.bottom);
        rect.right = Math.min(rect.right, view.getRootView().getWidth());
        rect.bottom = Math.min(rect.bottom, view.getRootView().getHeight());
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = this.u;
        if (viewOnTouchListenerC1482t7 != null) {
            viewOnTouchListenerC1482t7.h();
        }
    }

    public final void d(boolean z) {
        if (z == this.B) {
            return;
        }
        this.B = z;
        c(true);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7;
        if (this.x.isShown() || (viewOnTouchListenerC1482t7 = this.u) == null) {
            return;
        }
        viewOnTouchListenerC1482t7.b();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (this.x.isShown()) {
            c(false);
            return true;
        }
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = this.u;
        if (viewOnTouchListenerC1482t7 == null) {
            return true;
        }
        viewOnTouchListenerC1482t7.b();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = this.u;
        if (viewOnTouchListenerC1482t7 != null) {
            viewOnTouchListenerC1482t7.b();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
