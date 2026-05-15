package defpackage;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: w40, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1653w40 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ C1711x40 t;

    public C1653w40(C1711x40 c1711x40) {
        this.t = c1711x40;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C1711x40 c1711x40 = this.t;
        c1711x40.z.b();
        ViewOnLayoutChangeListenerC1594v40 viewOnLayoutChangeListenerC1594v40 = c1711x40.x;
        View view = c1711x40.u;
        view.removeOnLayoutChangeListener(viewOnLayoutChangeListenerC1594v40);
        view.setTag(null);
    }
}
