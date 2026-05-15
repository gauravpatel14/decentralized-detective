package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FG0 extends nU0 {
    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        for (int i = 0; i < this.t.u.size(); i++) {
            if (!isEnabled(i)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.nU0, android.widget.Adapter
    public final long getItemId(int i) {
        return ((PJ0) this.t.u.get(i)).b.e(GG0.h);
    }

    @Override // defpackage.nU0, android.widget.Adapter
    public final View getView(final int i, View view, final ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        view2.setOnClickListener(new View.OnClickListener() { // from class: EG0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ArrayList arrayList = this.t.t.u;
                ((ListView) viewGroup).performItemClick(view3, i, ((PJ0) arrayList.get(r1)).b.e(GG0.h));
            }
        });
        view2.setEnabled(isEnabled(i));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        return getItemViewType(i) != 0 && ((PJ0) this.t.u.get(i)).b.h(GG0.k);
    }
}
