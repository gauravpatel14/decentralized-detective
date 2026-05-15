package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C3 implements TQ0 {
    public WQ0 A;
    public B3 B;
    public Drawable C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f1J;
    public final SparseBooleanArray K;
    public C1710x3 L;
    public C1710x3 M;
    public z3 N;
    public C1765y3 O;
    public final C1765y3 P;
    public final Context t;
    public Context u;
    public MenuC0775hQ0 v;
    public final LayoutInflater w;
    public SQ0 x;
    public final int y;
    public final int z;

    public C3(Context context) {
        int i = AbstractC0189Pp1.abc_action_menu_layout;
        int i2 = AbstractC0189Pp1.abc_action_menu_item_layout;
        this.t = context;
        this.w = LayoutInflater.from(context);
        this.y = i;
        this.z = i2;
        this.K = new SparseBooleanArray();
        this.P = new C1765y3(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View a(DQ0 dq0, View view, ViewGroup viewGroup) {
        View actionView = dq0.getActionView();
        if (actionView == null || dq0.e()) {
            VQ0 vq0 = view instanceof VQ0 ? (VQ0) view : (VQ0) this.w.inflate(this.z, viewGroup, false);
            vq0.d(dq0);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) vq0;
            actionMenuItemView.C = (ActionMenuView) this.A;
            if (this.O == null) {
                this.O = new C1765y3(this);
            }
            actionMenuItemView.E = this.O;
            actionView = (View) vq0;
        }
        actionView.setVisibility(dq0.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof F3)) {
            actionView.setLayoutParams(ActionMenuView.n(layoutParams));
        }
        return actionView;
    }

    @Override // defpackage.TQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0, boolean z) {
        g();
        C1710x3 c1710x3 = this.M;
        if (c1710x3 != null && c1710x3.b()) {
            c1710x3.i.dismiss();
        }
        SQ0 sq0 = this.x;
        if (sq0 != null) {
            sq0.b(menuC0775hQ0, z);
        }
    }

    @Override // defpackage.TQ0
    public final boolean c(DQ0 dq0) {
        return false;
    }

    @Override // defpackage.TQ0
    public final void d(SQ0 sq0) {
        throw null;
    }

    @Override // defpackage.TQ0
    public final boolean e(DQ0 dq0) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.TQ0
    public final void f() {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.A;
        ArrayList arrayList = null;
        boolean z = false;
        if (viewGroup != null) {
            MenuC0775hQ0 menuC0775hQ0 = this.v;
            if (menuC0775hQ0 != null) {
                menuC0775hQ0.i();
                ArrayList arrayListL = this.v.l();
                int size = arrayListL.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    DQ0 dq0 = (DQ0) arrayListL.get(i2);
                    if (dq0.f()) {
                        View childAt = viewGroup.getChildAt(i);
                        DQ0 dq0E = childAt instanceof VQ0 ? ((VQ0) childAt).e() : null;
                        View viewA = a(dq0, childAt, viewGroup);
                        if (dq0 != dq0E) {
                            viewA.setPressed(false);
                            viewA.jumpDrawablesToCurrentState();
                        }
                        if (viewA != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewA.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewA);
                            }
                            ((ViewGroup) this.A).addView(viewA, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.B) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.A).requestLayout();
        MenuC0775hQ0 menuC0775hQ02 = this.v;
        if (menuC0775hQ02 != null) {
            menuC0775hQ02.i();
            ArrayList arrayList2 = menuC0775hQ02.i;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                FQ0 fq0 = ((DQ0) arrayList2.get(i3)).A;
            }
        }
        MenuC0775hQ0 menuC0775hQ03 = this.v;
        if (menuC0775hQ03 != null) {
            menuC0775hQ03.i();
            arrayList = menuC0775hQ03.j;
        }
        if (this.E && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !((DQ0) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z = true;
            }
        }
        if (z) {
            if (this.B == null) {
                this.B = new B3(this, this.t);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.B.getParent();
            if (viewGroup3 != this.A) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.B);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.A;
                B3 b3 = this.B;
                actionMenuView.getClass();
                F3 f3M = ActionMenuView.m();
                f3M.a = true;
                actionMenuView.addView(b3, f3M);
            }
        } else {
            B3 b32 = this.B;
            if (b32 != null) {
                Object parent = b32.getParent();
                Object obj = this.A;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.B);
                }
            }
        }
        ((ActionMenuView) this.A).L = this.E;
    }

    public final boolean g() {
        Object obj;
        z3 z3Var = this.N;
        if (z3Var != null && (obj = this.A) != null) {
            ((View) obj).removeCallbacks(z3Var);
            this.N = null;
            return true;
        }
        C1710x3 c1710x3 = this.L;
        if (c1710x3 == null) {
            return false;
        }
        if (c1710x3.b()) {
            c1710x3.i.dismiss();
        }
        return true;
    }

    @Override // defpackage.TQ0
    public final void h(Context context, MenuC0775hQ0 menuC0775hQ0) {
        this.u = context;
        LayoutInflater.from(context);
        this.v = menuC0775hQ0;
        Resources resources = context.getResources();
        if (!this.F) {
            this.E = true;
        }
        int i = 2;
        this.G = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.I = i;
        int measuredWidth = this.G;
        if (this.E) {
            if (this.B == null) {
                B3 b3 = new B3(this, this.t);
                this.B = b3;
                if (this.D) {
                    b3.setImageDrawable(this.C);
                    this.C = null;
                    this.D = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.B.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.B.getMeasuredWidth();
        } else {
            this.B = null;
        }
        this.H = measuredWidth;
        float f = resources.getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.TQ0
    public final boolean i(SubMenuC1273pR1 subMenuC1273pR1) {
        boolean z;
        if (!subMenuC1273pR1.hasVisibleItems()) {
            return false;
        }
        SubMenuC1273pR1 subMenuC1273pR12 = subMenuC1273pR1;
        while (true) {
            MenuC0775hQ0 menuC0775hQ0 = subMenuC1273pR12.z;
            if (menuC0775hQ0 == this.v) {
                break;
            }
            subMenuC1273pR12 = (SubMenuC1273pR1) menuC0775hQ0;
        }
        ViewGroup viewGroup = (ViewGroup) this.A;
        View view = null;
        view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof VQ0) && ((VQ0) childAt).e() == subMenuC1273pR12.A) {
                    view = childAt;
                    break;
                }
                i++;
            }
        }
        if (view == null) {
            return false;
        }
        subMenuC1273pR1.A.getClass();
        int size = subMenuC1273pR1.f.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = false;
                break;
            }
            MenuItem item = subMenuC1273pR1.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i2++;
        }
        C1710x3 c1710x3 = new C1710x3(this, this.u, subMenuC1273pR1, view);
        this.M = c1710x3;
        c1710x3.g = z;
        MQ0 mq0 = c1710x3.i;
        if (mq0 != null) {
            mq0.n(z);
        }
        C1710x3 c1710x32 = this.M;
        if (!c1710x32.b()) {
            if (c1710x32.e == null) {
                throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            }
            c1710x32.d(0, 0, false, false);
        }
        SQ0 sq0 = this.x;
        if (sq0 != null) {
            sq0.d(subMenuC1273pR1);
        }
        return true;
    }

    @Override // defpackage.TQ0
    public final boolean j() {
        int size;
        ArrayList arrayListL;
        int i;
        boolean z;
        MenuC0775hQ0 menuC0775hQ0 = this.v;
        if (menuC0775hQ0 != null) {
            arrayListL = menuC0775hQ0.l();
            size = arrayListL.size();
        } else {
            size = 0;
            arrayListL = null;
        }
        int i2 = this.I;
        int i3 = this.H;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.A;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 2;
            z = true;
            if (i4 >= size) {
                break;
            }
            DQ0 dq0 = (DQ0) arrayListL.get(i4);
            int i7 = dq0.y;
            if ((i7 & 2) == 2) {
                i5++;
            } else if ((i7 & 1) == 1) {
                i6++;
            } else {
                z2 = true;
            }
            if (this.f1J && dq0.C) {
                i2 = 0;
            }
            i4++;
        }
        if (this.E && (z2 || i6 + i5 > i2)) {
            i2--;
        }
        int i8 = i2 - i5;
        SparseBooleanArray sparseBooleanArray = this.K;
        sparseBooleanArray.clear();
        int i9 = 0;
        int i10 = 0;
        while (i9 < size) {
            DQ0 dq02 = (DQ0) arrayListL.get(i9);
            int i11 = dq02.y;
            boolean z3 = (i11 & 2) == i ? z : false;
            int i12 = dq02.b;
            if (z3) {
                View viewA = a(dq02, null, viewGroup);
                viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewA.getMeasuredWidth();
                i3 -= measuredWidth;
                if (i10 == 0) {
                    i10 = measuredWidth;
                }
                if (i12 != 0) {
                    sparseBooleanArray.put(i12, z);
                }
                dq02.g(z);
            } else if ((i11 & 1) == z) {
                boolean z4 = sparseBooleanArray.get(i12);
                boolean z5 = ((i8 > 0 || z4) && i3 > 0) ? z : false;
                if (z5) {
                    View viewA2 = a(dq02, null, viewGroup);
                    viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i3 -= measuredWidth2;
                    if (i10 == 0) {
                        i10 = measuredWidth2;
                    }
                    z5 &= i3 + i10 > 0;
                }
                if (z5 && i12 != 0) {
                    sparseBooleanArray.put(i12, true);
                } else if (z4) {
                    sparseBooleanArray.put(i12, false);
                    for (int i13 = 0; i13 < i9; i13++) {
                        DQ0 dq03 = (DQ0) arrayListL.get(i13);
                        if (dq03.b == i12) {
                            if (dq03.f()) {
                                i8++;
                            }
                            dq03.g(false);
                        }
                    }
                }
                if (z5) {
                    i8--;
                }
                dq02.g(z5);
            } else {
                dq02.g(false);
                i9++;
                i = 2;
                z = true;
            }
            i9++;
            i = 2;
            z = true;
        }
        return z;
    }

    public final boolean k() {
        C1710x3 c1710x3 = this.L;
        return c1710x3 != null && c1710x3.b();
    }

    public final boolean l() {
        MenuC0775hQ0 menuC0775hQ0;
        if (!this.E || k() || (menuC0775hQ0 = this.v) == null || this.A == null || this.N != null) {
            return false;
        }
        menuC0775hQ0.i();
        if (menuC0775hQ0.j.isEmpty()) {
            return false;
        }
        z3 z3Var = new z3(this, new C1710x3(this, this.u, this.v, this.B));
        this.N = z3Var;
        ((View) this.A).post(z3Var);
        return true;
    }
}
