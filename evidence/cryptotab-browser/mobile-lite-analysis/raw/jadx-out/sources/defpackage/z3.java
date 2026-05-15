package defpackage;

import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class z3 implements Runnable {
    public final C1710x3 t;
    public final /* synthetic */ C3 u;

    public z3(C3 c3, C1710x3 c1710x3) {
        this.u = c3;
        this.t = c1710x3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0641fQ0 interfaceC0641fQ0;
        C3 c3 = this.u;
        MenuC0775hQ0 menuC0775hQ0 = c3.v;
        if (menuC0775hQ0 != null && (interfaceC0641fQ0 = menuC0775hQ0.e) != null) {
            interfaceC0641fQ0.b(menuC0775hQ0);
        }
        View view = (View) c3.A;
        if (view != null && view.getWindowToken() != null) {
            C1710x3 c1710x3 = this.t;
            if (c1710x3.b()) {
                c3.L = c1710x3;
            } else if (c1710x3.e != null) {
                c1710x3.d(0, 0, false, false);
                c3.L = c1710x3;
            }
        }
        c3.N = null;
    }
}
