package androidx.fragment.app;

import android.view.View;
import defpackage.InterfaceC0564eF0;
import defpackage.InterfaceC0762hF0;
import defpackage.bF0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements InterfaceC0564eF0 {
    public final /* synthetic */ n t;

    public l(n nVar) {
        this.t = nVar;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        View view;
        if (bf0 != bF0.ON_STOP || (view = this.t.mView) == null) {
            return;
        }
        view.cancelPendingInputEvents();
    }
}
