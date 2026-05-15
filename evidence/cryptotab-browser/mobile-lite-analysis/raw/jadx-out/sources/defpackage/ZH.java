package defpackage;

import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ZH implements InterfaceC0564eF0 {
    public final /* synthetic */ J41 t;
    public final /* synthetic */ iI u;

    public /* synthetic */ ZH(iI iIVar, J41 j41) {
        this.t = j41;
        this.u = iIVar;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        if (bf0 == bF0.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = bI.a(this.u);
            J41 j41 = this.t;
            j41.e = onBackInvokedDispatcherA;
            j41.e(j41.g);
        }
    }
}
