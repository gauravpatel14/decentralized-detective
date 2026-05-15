package defpackage;

import android.widget.PopupWindow;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class p7 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ ViewOnTouchListenerC1482t7 t;

    public p7(ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7) {
        this.t = viewOnTouchListenerC1482t7;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewOnTouchListenerC1482t7 viewOnTouchListenerC1482t7 = this.t;
        if (viewOnTouchListenerC1482t7.K) {
            return;
        }
        viewOnTouchListenerC1482t7.v.removeCallbacks(viewOnTouchListenerC1482t7.A);
        Iterator it = viewOnTouchListenerC1482t7.C.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                viewOnTouchListenerC1482t7.z.b();
                viewOnTouchListenerC1482t7.x.b();
                return;
            }
            ((PopupWindow.OnDismissListener) l21.next()).onDismiss();
        }
    }
}
