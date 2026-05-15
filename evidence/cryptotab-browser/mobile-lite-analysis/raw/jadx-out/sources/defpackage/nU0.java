package defpackage;

import android.util.Pair;
import android.util.SparseArray;
import android.widget.BaseAdapter;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class nU0 extends BaseAdapter {
    public final QJ0 t;
    public final SparseArray u = new SparseArray();

    public nU0(QJ0 qj0) {
        this.t = qj0;
        qj0.l(new C1092mU0(this));
    }

    public final void a(int i, RJ0 rj0, InterfaceC0436bn1 interfaceC0436bn1) {
        this.u.put(i, new Pair(rj0, interfaceC0436bn1));
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.t.u.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.t.u.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return ((PJ0) this.t.u.get(i)).a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00db  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nU0.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return Math.max(1, this.u.size());
    }
}
