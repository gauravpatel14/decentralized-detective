package defpackage;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VR1 {
    public final ActionMode.Callback a;
    public final Context b;
    public final ArrayList c = new ArrayList();
    public final UJ1 d = new UJ1(0);

    public VR1(Context context, ActionMode.Callback callback) {
        this.b = context;
        this.a = callback;
    }

    public final WR1 a(H3 h3) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            WR1 wr1 = (WR1) arrayList.get(i);
            if (wr1 != null && wr1.b == h3) {
                return wr1;
            }
        }
        WR1 wr12 = new WR1(this.b, h3);
        arrayList.add(wr12);
        return wr12;
    }

    public final boolean b(H3 h3, MenuItem menuItem) {
        return this.a.onActionItemClicked(a(h3), new JQ0(this.b, (aS1) menuItem));
    }

    public final boolean c(H3 h3, MenuC0775hQ0 menuC0775hQ0) {
        WR1 wr1A = a(h3);
        UJ1 uj1 = this.d;
        Menu xq0 = (Menu) uj1.get(menuC0775hQ0);
        if (xq0 == null) {
            xq0 = new XQ0(this.b, menuC0775hQ0);
            uj1.put(menuC0775hQ0, xq0);
        }
        return this.a.onCreateActionMode(wr1A, xq0);
    }
}
