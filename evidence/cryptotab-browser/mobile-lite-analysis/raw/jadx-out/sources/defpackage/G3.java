package defpackage;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class G3 implements InterfaceC0641fQ0 {
    public final /* synthetic */ ActionMenuView t;

    public G3(ActionMenuView actionMenuView) {
        this.t = actionMenuView;
    }

    @Override // defpackage.InterfaceC0641fQ0
    public final boolean a(MenuC0775hQ0 menuC0775hQ0, MenuItem menuItem) {
        boolean z;
        boolean zOnMenuItemClick;
        C0366ab2 c0366ab2 = this.t.T;
        if (c0366ab2 == null) {
            return false;
        }
        Toolbar toolbar = c0366ab2.t;
        Iterator it = toolbar.c0.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (((C0600ei0) it.next()).a.o(menuItem)) {
                z = true;
                break;
            }
        }
        if (z) {
            zOnMenuItemClick = true;
        } else {
            InterfaceC0790hb2 interfaceC0790hb2 = toolbar.e0;
            zOnMenuItemClick = interfaceC0790hb2 != null ? interfaceC0790hb2.onMenuItemClick(menuItem) : false;
        }
        return zOnMenuItemClick;
    }

    @Override // defpackage.InterfaceC0641fQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0) {
        InterfaceC0641fQ0 interfaceC0641fQ0 = this.t.O;
        if (interfaceC0641fQ0 != null) {
            interfaceC0641fQ0.b(menuC0775hQ0);
        }
    }
}
