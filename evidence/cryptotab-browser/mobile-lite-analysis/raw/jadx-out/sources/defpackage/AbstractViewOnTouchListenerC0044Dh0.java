package defpackage;

import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: Dh0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0044Dh0 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public int A;
    public final int[] B = new int[2];
    public final float t;
    public final int u;
    public final int v;
    public final View w;
    public Ch0 x;
    public Ch0 y;
    public boolean z;

    public AbstractViewOnTouchListenerC0044Dh0(View view) {
        this.w = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.t = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.u = tapTimeout;
        this.v = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        Ch0 ch0 = this.y;
        View view = this.w;
        if (ch0 != null) {
            view.removeCallbacks(ch0);
        }
        Ch0 ch02 = this.x;
        if (ch02 != null) {
            view.removeCallbacks(ch02);
        }
    }

    public abstract nI1 b();

    public abstract boolean c();

    public boolean d() {
        nI1 ni1B = b();
        if (ni1B == null || !ni1B.q()) {
            return true;
        }
        ni1B.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractViewOnTouchListenerC0044Dh0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.z = false;
        this.A = -1;
        Ch0 ch0 = this.x;
        if (ch0 != null) {
            this.w.removeCallbacks(ch0);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
