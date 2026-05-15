package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ry extends MQ0 implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int T = AbstractC0189Pp1.abc_cascading_menu_item_layout;
    public View G;
    public View H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f37J;
    public boolean K;
    public int L;
    public int M;
    public boolean O;
    public SQ0 P;
    public ViewTreeObserver Q;
    public NQ0 R;
    public boolean S;
    public final Context u;
    public final int v;
    public final int w;
    public final boolean x;
    public final Handler y;
    public final ArrayList z = new ArrayList();
    public final ArrayList A = new ArrayList();
    public final ViewTreeObserverOnGlobalLayoutListenerC1117my B = new ViewTreeObserverOnGlobalLayoutListenerC1117my(this);
    public final ViewOnAttachStateChangeListenerC1179ny C = new ViewOnAttachStateChangeListenerC1179ny(this);
    public final C1300py D = new C1300py(this);
    public int E = 0;
    public int F = 0;
    public boolean N = false;

    public ry(int i, Context context, View view, boolean z) {
        this.u = context;
        this.G = view;
        this.w = i;
        this.x = z;
        this.I = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.v = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(Hp1.abc_config_prefDialogWidth));
        this.y = new Handler();
    }

    @Override // defpackage.nI1
    public final void a() {
        if (q()) {
            return;
        }
        ArrayList arrayList = this.z;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            v((MenuC0775hQ0) it.next());
        }
        arrayList.clear();
        View view = this.G;
        this.H = view;
        if (view != null) {
            boolean z = this.Q == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.Q = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.B);
            }
            this.H.addOnAttachStateChangeListener(this.C);
        }
    }

    @Override // defpackage.TQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0, boolean z) {
        ArrayList arrayList = this.A;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuC0775hQ0 == ((C1358qy) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((C1358qy) arrayList.get(i2)).b.c(false);
        }
        C1358qy c1358qy = (C1358qy) arrayList.remove(i);
        c1358qy.b.r(this);
        boolean z2 = this.S;
        RQ0 rq0 = c1358qy.a;
        if (z2) {
            rq0.S.setExitTransition(null);
            rq0.S.setAnimationStyle(0);
        }
        rq0.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.I = ((C1358qy) arrayList.get(size2 - 1)).c;
        } else {
            this.I = this.G.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((C1358qy) arrayList.get(0)).b.c(false);
                return;
            }
            return;
        }
        dismiss();
        SQ0 sq0 = this.P;
        if (sq0 != null) {
            sq0.b(menuC0775hQ0, true);
        }
        ViewTreeObserver viewTreeObserver = this.Q;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.Q.removeGlobalOnLayoutListener(this.B);
            }
            this.Q = null;
        }
        this.H.removeOnAttachStateChangeListener(this.C);
        this.R.onDismiss();
    }

    @Override // defpackage.TQ0
    public final void d(SQ0 sq0) {
        this.P = sq0;
    }

    @Override // defpackage.nI1
    public final void dismiss() {
        ArrayList arrayList = this.A;
        int size = arrayList.size();
        if (size > 0) {
            C1358qy[] c1358qyArr = (C1358qy[]) arrayList.toArray(new C1358qy[size]);
            for (int i = size - 1; i >= 0; i--) {
                C1358qy c1358qy = c1358qyArr[i];
                if (c1358qy.a.S.isShowing()) {
                    c1358qy.a.dismiss();
                }
            }
        }
    }

    @Override // defpackage.TQ0
    public final void f() {
        Iterator it = this.A.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((C1358qy) it.next()).a.v.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((eQ0) adapter).notifyDataSetChanged();
        }
    }

    @Override // defpackage.nI1
    public final V30 g() {
        ArrayList arrayList = this.A;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C1358qy) arrayList.get(arrayList.size() - 1)).a.v;
    }

    @Override // defpackage.TQ0
    public final boolean i(SubMenuC1273pR1 subMenuC1273pR1) {
        for (C1358qy c1358qy : this.A) {
            if (subMenuC1273pR1 == c1358qy.b) {
                c1358qy.a.v.requestFocus();
                return true;
            }
        }
        if (!subMenuC1273pR1.hasVisibleItems()) {
            return false;
        }
        k(subMenuC1273pR1);
        SQ0 sq0 = this.P;
        if (sq0 != null) {
            sq0.d(subMenuC1273pR1);
        }
        return true;
    }

    @Override // defpackage.TQ0
    public final boolean j() {
        return false;
    }

    @Override // defpackage.MQ0
    public final void k(MenuC0775hQ0 menuC0775hQ0) {
        menuC0775hQ0.b(this, this.u);
        if (q()) {
            v(menuC0775hQ0);
        } else {
            this.z.add(menuC0775hQ0);
        }
    }

    @Override // defpackage.MQ0
    public final void m(View view) {
        if (this.G != view) {
            this.G = view;
            this.F = Gravity.getAbsoluteGravity(this.E, view.getLayoutDirection());
        }
    }

    @Override // defpackage.MQ0
    public final void n(boolean z) {
        this.N = z;
    }

    @Override // defpackage.MQ0
    public final void o(int i) {
        if (this.E != i) {
            this.E = i;
            this.F = Gravity.getAbsoluteGravity(i, this.G.getLayoutDirection());
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C1358qy c1358qy;
        ArrayList arrayList = this.A;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c1358qy = null;
                break;
            }
            c1358qy = (C1358qy) arrayList.get(i);
            if (!c1358qy.a.S.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (c1358qy != null) {
            c1358qy.b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // defpackage.MQ0
    public final void p(int i) {
        this.f37J = true;
        this.L = i;
    }

    @Override // defpackage.nI1
    public final boolean q() {
        ArrayList arrayList = this.A;
        return arrayList.size() > 0 && ((C1358qy) arrayList.get(0)).a.S.isShowing();
    }

    @Override // defpackage.MQ0
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.R = (NQ0) onDismissListener;
    }

    @Override // defpackage.MQ0
    public final void s(boolean z) {
        this.O = z;
    }

    @Override // defpackage.MQ0
    public final void t(int i) {
        this.K = true;
        this.M = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(defpackage.MenuC0775hQ0 r18) {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ry.v(hQ0):void");
    }
}
