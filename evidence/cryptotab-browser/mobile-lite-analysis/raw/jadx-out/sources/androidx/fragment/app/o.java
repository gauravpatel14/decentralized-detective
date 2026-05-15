package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements View.OnAttachStateChangeListener {
    public final /* synthetic */ u t;
    public final /* synthetic */ p u;

    public o(p pVar, u uVar) {
        this.u = pVar;
        this.t = uVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        u uVar = this.t;
        uVar.g();
        g.j((ViewGroup) uVar.c.mView.getParent(), this.u.t).i();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
