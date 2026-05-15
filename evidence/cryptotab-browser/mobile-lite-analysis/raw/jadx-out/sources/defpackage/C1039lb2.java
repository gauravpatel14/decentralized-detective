package defpackage;

import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: renamed from: lb2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1039lb2 implements SQ0 {
    public boolean t;
    public final /* synthetic */ mb2 u;

    public C1039lb2(mb2 mb2Var) {
        this.u = mb2Var;
    }

    @Override // defpackage.SQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0, boolean z) {
        C3 c3;
        if (this.t) {
            return;
        }
        this.t = true;
        mb2 mb2Var = this.u;
        ActionMenuView actionMenuView = mb2Var.a.a.t;
        if (actionMenuView != null && (c3 = actionMenuView.M) != null) {
            c3.g();
            C1710x3 c1710x3 = c3.M;
            if (c1710x3 != null && c1710x3.b()) {
                c1710x3.i.dismiss();
            }
        }
        mb2Var.b.onPanelClosed(108, menuC0775hQ0);
        this.t = false;
    }

    @Override // defpackage.SQ0
    public final boolean d(MenuC0775hQ0 menuC0775hQ0) {
        this.u.b.onMenuOpened(108, menuC0775hQ0);
        return true;
    }
}
