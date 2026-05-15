package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MQ0 implements nI1, TQ0, AdapterView.OnItemClickListener {
    public Rect t;

    public static int l(ListAdapter listAdapter, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public static boolean u(MenuC0775hQ0 menuC0775hQ0) {
        int size = menuC0775hQ0.f.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuC0775hQ0.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.TQ0
    public final boolean c(DQ0 dq0) {
        return false;
    }

    @Override // defpackage.TQ0
    public final boolean e(DQ0 dq0) {
        return false;
    }

    public abstract void k(MenuC0775hQ0 menuC0775hQ0);

    public abstract void m(View view);

    public abstract void n(boolean z);

    public abstract void o(int i);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (eQ0) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (eQ0) listAdapter).t.q((MenuItem) listAdapter.getItem(i), this, !(this instanceof ry) ? 0 : 4);
    }

    public abstract void p(int i);

    public abstract void r(PopupWindow.OnDismissListener onDismissListener);

    public abstract void s(boolean z);

    public abstract void t(int i);

    @Override // defpackage.TQ0
    public final void h(Context context, MenuC0775hQ0 menuC0775hQ0) {
    }
}
