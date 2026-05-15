package defpackage;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Za2 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Toolbar u;

    public /* synthetic */ Za2(Toolbar toolbar, int i) {
        this.t = i;
        this.u = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                C0660fb2 c0660fb2 = this.u.i0;
                DQ0 dq0 = c0660fb2 == null ? null : c0660fb2.u;
                if (dq0 != null) {
                    dq0.collapseActionView();
                }
                break;
            default:
                Toolbar toolbar = this.u;
                Iterator it = toolbar.d0.iterator();
                while (it.hasNext()) {
                    toolbar.o().removeItem(((MenuItem) it.next()).getItemId());
                }
                MenuC0775hQ0 menuC0775hQ0O = toolbar.o();
                ArrayList arrayListM = toolbar.m();
                ZR1 zr1 = new ZR1(toolbar.getContext());
                Iterator it2 = toolbar.c0.b.iterator();
                while (it2.hasNext()) {
                    ((C0600ei0) it2.next()).a.j(menuC0775hQ0O, zr1);
                }
                ArrayList arrayListM2 = toolbar.m();
                arrayListM2.removeAll(arrayListM);
                toolbar.d0 = arrayListM2;
                break;
        }
    }
}
