package defpackage;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import java.util.Iterator;

/* JADX INFO: renamed from: ab2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0366ab2 implements InterfaceC0641fQ0 {
    public final /* synthetic */ Toolbar t;

    public /* synthetic */ C0366ab2(Toolbar toolbar) {
        this.t = toolbar;
    }

    @Override // defpackage.InterfaceC0641fQ0
    public boolean a(MenuC0775hQ0 menuC0775hQ0, MenuItem menuItem) {
        C0977kb2 c0977kb2 = this.t.k0;
        return false;
    }

    @Override // defpackage.InterfaceC0641fQ0
    public void b(MenuC0775hQ0 menuC0775hQ0) {
        Toolbar toolbar = this.t;
        C3 c3 = toolbar.t.M;
        if (c3 == null || !c3.k()) {
            Iterator it = toolbar.c0.b.iterator();
            while (it.hasNext()) {
                ((C0600ei0) it.next()).a.s(menuC0775hQ0);
            }
        }
        C0977kb2 c0977kb2 = toolbar.k0;
        if (c0977kb2 != null) {
            c0977kb2.b(menuC0775hQ0);
        }
    }
}
