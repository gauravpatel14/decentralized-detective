package defpackage;

import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ei0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View t;

    public Ei0(View view) {
        this.t = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        View view2 = this.t;
        view2.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        view2.requestApplyInsets();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
