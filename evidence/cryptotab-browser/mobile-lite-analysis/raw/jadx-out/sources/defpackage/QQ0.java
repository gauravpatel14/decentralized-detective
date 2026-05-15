package defpackage;

import android.content.Context;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class QQ0 extends V30 {
    public final int F;
    public final int G;
    public RQ0 H;
    public DQ0 I;

    public QQ0(Context context, boolean z) {
        super(context, z);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.F = 21;
            this.G = 22;
        } else {
            this.F = 22;
            this.G = 21;
        }
    }

    @Override // defpackage.V30, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        eQ0 eq0;
        int headersCount;
        C1300py c1300py;
        C1300py c1300py2;
        int iPointToPosition;
        int i;
        if (this.H != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                eq0 = (eQ0) headerViewListAdapter.getWrappedAdapter();
            } else {
                eq0 = (eQ0) adapter;
                headersCount = 0;
            }
            DQ0 dq0B = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= eq0.getCount()) ? null : eq0.getItem(i);
            DQ0 dq0 = this.I;
            if (dq0 != dq0B) {
                MenuC0775hQ0 menuC0775hQ0 = eq0.t;
                if (dq0 != null && (c1300py2 = this.H.V) != null) {
                    c1300py2.a.y.removeCallbacksAndMessages(menuC0775hQ0);
                }
                this.I = dq0B;
                if (dq0B != null && (c1300py = this.H.V) != null) {
                    ry ryVar = c1300py.a;
                    ryVar.y.removeCallbacksAndMessages(null);
                    ArrayList arrayList = ryVar.A;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i2 = -1;
                            break;
                        }
                        if (menuC0775hQ0 == ((C1358qy) arrayList.get(i2)).b) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 != -1) {
                        int i3 = i2 + 1;
                        ryVar.y.postAtTime(new RunnableC1242oy(c1300py, i3 < arrayList.size() ? (C1358qy) arrayList.get(i3) : null, dq0B, menuC0775hQ0), menuC0775hQ0, SystemClock.uptimeMillis() + 200);
                    }
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.F) {
            if (listMenuItemView.isEnabled() && listMenuItemView.t.hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.G) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (eQ0) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (eQ0) adapter).t.c(false);
        return true;
    }
}
