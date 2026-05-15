package defpackage;

import android.view.MenuItem;

/* JADX INFO: renamed from: kb2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0977kb2 implements InterfaceC0790hb2, InterfaceC0641fQ0 {
    public final /* synthetic */ mb2 t;

    public /* synthetic */ C0977kb2(mb2 mb2Var) {
        this.t = mb2Var;
    }

    @Override // defpackage.InterfaceC0641fQ0
    public boolean a(MenuC0775hQ0 menuC0775hQ0, MenuItem menuItem) {
        return false;
    }

    @Override // defpackage.InterfaceC0641fQ0
    public void b(MenuC0775hQ0 menuC0775hQ0) {
        mb2 mb2Var = this.t;
        boolean zU = mb2Var.a.a.u();
        WindowCallbackC0365ab windowCallbackC0365ab = mb2Var.b;
        if (zU) {
            windowCallbackC0365ab.onPanelClosed(108, menuC0775hQ0);
        } else if (windowCallbackC0365ab.onPreparePanel(0, null, menuC0775hQ0)) {
            windowCallbackC0365ab.onMenuOpened(108, menuC0775hQ0);
        }
    }

    @Override // defpackage.InterfaceC0790hb2
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.t.b.t.onMenuItemSelected(0, menuItem);
    }
}
