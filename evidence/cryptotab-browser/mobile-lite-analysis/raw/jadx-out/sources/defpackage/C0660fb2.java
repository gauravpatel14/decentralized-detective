package defpackage;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* JADX INFO: renamed from: fb2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0660fb2 implements TQ0 {
    public MenuC0775hQ0 t;
    public DQ0 u;
    public final /* synthetic */ Toolbar v;

    public C0660fb2(Toolbar toolbar) {
        this.v = toolbar;
    }

    @Override // defpackage.TQ0
    public final boolean c(DQ0 dq0) {
        Toolbar toolbar = this.v;
        KeyEvent.Callback callback = toolbar.B;
        if (callback instanceof FG) {
            ((FG) callback).f();
        }
        toolbar.removeView(toolbar.B);
        toolbar.removeView(toolbar.A);
        toolbar.B = null;
        ArrayList arrayList = toolbar.a0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.u = null;
        toolbar.requestLayout();
        dq0.C = false;
        dq0.n.p(false);
        toolbar.J();
        return true;
    }

    @Override // defpackage.TQ0
    public final boolean e(DQ0 dq0) {
        Toolbar toolbar = this.v;
        if (toolbar.A == null) {
            C1285pb c1285pb = new C1285pb(toolbar.getContext(), null, Ep1.toolbarNavigationButtonStyle);
            toolbar.A = c1285pb;
            c1285pb.setImageDrawable(toolbar.y);
            toolbar.A.setContentDescription(toolbar.z);
            C0724gb2 c0724gb2H = Toolbar.h();
            c0724gb2H.a = (toolbar.G & 112) | 8388611;
            c0724gb2H.b = 2;
            toolbar.A.setLayoutParams(c0724gb2H);
            toolbar.A.setOnClickListener(new ViewOnClickListenerC0487cb2(toolbar));
        }
        ViewParent parent = toolbar.A.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.A);
            }
            toolbar.addView(toolbar.A);
        }
        View actionView = dq0.getActionView();
        toolbar.B = actionView;
        this.u = dq0;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.B);
            }
            C0724gb2 c0724gb2H2 = Toolbar.h();
            c0724gb2H2.a = 8388611 | (toolbar.G & 112);
            c0724gb2H2.b = 2;
            toolbar.B.setLayoutParams(c0724gb2H2);
            toolbar.addView(toolbar.B);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((C0724gb2) childAt.getLayoutParams()).b != 2 && childAt != toolbar.t) {
                toolbar.removeViewAt(childCount);
                toolbar.a0.add(childAt);
            }
        }
        toolbar.requestLayout();
        dq0.C = true;
        dq0.n.p(false);
        KeyEvent.Callback callback = toolbar.B;
        if (callback instanceof FG) {
            ((FG) callback).b();
        }
        toolbar.J();
        return true;
    }

    @Override // defpackage.TQ0
    public final void f() {
        if (this.u != null) {
            MenuC0775hQ0 menuC0775hQ0 = this.t;
            if (menuC0775hQ0 != null) {
                int size = menuC0775hQ0.f.size();
                for (int i = 0; i < size; i++) {
                    if (this.t.getItem(i) == this.u) {
                        return;
                    }
                }
            }
            c(this.u);
        }
    }

    @Override // defpackage.TQ0
    public final void h(Context context, MenuC0775hQ0 menuC0775hQ0) {
        DQ0 dq0;
        MenuC0775hQ0 menuC0775hQ02 = this.t;
        if (menuC0775hQ02 != null && (dq0 = this.u) != null) {
            menuC0775hQ02.d(dq0);
        }
        this.t = menuC0775hQ0;
    }

    @Override // defpackage.TQ0
    public final boolean i(SubMenuC1273pR1 subMenuC1273pR1) {
        return false;
    }

    @Override // defpackage.TQ0
    public final boolean j() {
        return false;
    }

    @Override // defpackage.TQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0, boolean z) {
    }
}
