package defpackage;

import android.widget.PopupWindow;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NQ0 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ OQ0 t;

    public NQ0(OQ0 oq0) {
        this.t = oq0;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.t.c();
    }
}
