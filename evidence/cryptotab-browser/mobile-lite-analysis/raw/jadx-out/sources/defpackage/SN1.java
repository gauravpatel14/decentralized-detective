package defpackage;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SN1 extends MQ0 implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public static final int N = AbstractC0189Pp1.abc_popup_menu_item_layout;
    public final RQ0 A;
    public NQ0 D;
    public View E;
    public View F;
    public SQ0 G;
    public ViewTreeObserver H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f4J;
    public int K;
    public boolean M;
    public final Context u;
    public final MenuC0775hQ0 v;
    public final eQ0 w;
    public final boolean x;
    public final int y;
    public final int z;
    public final QN1 B = new QN1(this);
    public final RN1 C = new RN1(this);
    public int L = 0;

    public SN1(int i, MenuC0775hQ0 menuC0775hQ0, Context context, View view, boolean z) {
        this.u = context;
        this.v = menuC0775hQ0;
        this.x = z;
        this.w = new eQ0(menuC0775hQ0, LayoutInflater.from(context), z, N);
        this.z = i;
        Resources resources = context.getResources();
        this.y = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(Hp1.abc_config_prefDialogWidth));
        this.E = view;
        this.A = new RQ0(context, null, i);
        menuC0775hQ0.b(this, context);
    }

    @Override // defpackage.nI1
    public final void a() {
        View view;
        if (q()) {
            return;
        }
        if (this.I || (view = this.E) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.F = view;
        RQ0 rq0 = this.A;
        rq0.S.setOnDismissListener(this);
        rq0.I = this;
        rq0.R = true;
        rq0.S.setFocusable(true);
        View view2 = this.F;
        boolean z = this.H == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.H = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.B);
        }
        view2.addOnAttachStateChangeListener(this.C);
        rq0.H = view2;
        rq0.E = this.L;
        boolean z2 = this.f4J;
        Context context = this.u;
        eQ0 eq0 = this.w;
        if (!z2) {
            this.K = MQ0.l(eq0, context, this.y);
            this.f4J = true;
        }
        rq0.c(this.K);
        rq0.S.setInputMethodMode(2);
        Rect rect = this.t;
        rq0.Q = rect != null ? new Rect(rect) : null;
        rq0.a();
        V30 v30 = rq0.v;
        v30.setOnKeyListener(this);
        if (this.M) {
            MenuC0775hQ0 menuC0775hQ0 = this.v;
            if (menuC0775hQ0.m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(AbstractC0189Pp1.abc_popup_menu_header_item_layout, (ViewGroup) v30, false);
                TextView textView = (TextView) frameLayout.findViewById(R.id.title);
                if (textView != null) {
                    textView.setText(menuC0775hQ0.m);
                }
                frameLayout.setEnabled(false);
                v30.addHeaderView(frameLayout, null, false);
            }
        }
        rq0.A(eq0);
        rq0.a();
    }

    @Override // defpackage.TQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0, boolean z) {
        if (menuC0775hQ0 != this.v) {
            return;
        }
        dismiss();
        SQ0 sq0 = this.G;
        if (sq0 != null) {
            sq0.b(menuC0775hQ0, z);
        }
    }

    @Override // defpackage.TQ0
    public final void d(SQ0 sq0) {
        this.G = sq0;
    }

    @Override // defpackage.nI1
    public final void dismiss() {
        if (q()) {
            this.A.dismiss();
        }
    }

    @Override // defpackage.TQ0
    public final void f() {
        this.f4J = false;
        eQ0 eq0 = this.w;
        if (eq0 != null) {
            eq0.notifyDataSetChanged();
        }
    }

    @Override // defpackage.nI1
    public final V30 g() {
        return this.A.v;
    }

    @Override // defpackage.TQ0
    public final boolean i(SubMenuC1273pR1 subMenuC1273pR1) {
        if (subMenuC1273pR1.hasVisibleItems()) {
            View view = this.F;
            OQ0 oq0 = new OQ0(this.z, subMenuC1273pR1, this.u, view, this.x);
            SQ0 sq0 = this.G;
            oq0.h = sq0;
            MQ0 mq0 = oq0.i;
            if (mq0 != null) {
                mq0.d(sq0);
            }
            boolean zU = MQ0.u(subMenuC1273pR1);
            oq0.g = zU;
            MQ0 mq02 = oq0.i;
            if (mq02 != null) {
                mq02.n(zU);
            }
            oq0.j = this.D;
            this.D = null;
            this.v.c(false);
            RQ0 rq0 = this.A;
            int width = rq0.y;
            int iY = rq0.y();
            if ((Gravity.getAbsoluteGravity(this.L, this.E.getLayoutDirection()) & 7) == 5) {
                width += this.E.getWidth();
            }
            if (!oq0.b()) {
                if (oq0.e != null) {
                    oq0.d(width, iY, true, true);
                }
            }
            SQ0 sq02 = this.G;
            if (sq02 != null) {
                sq02.d(subMenuC1273pR1);
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.TQ0
    public final boolean j() {
        return false;
    }

    @Override // defpackage.MQ0
    public final void m(View view) {
        this.E = view;
    }

    @Override // defpackage.MQ0
    public final void n(boolean z) {
        this.w.v = z;
    }

    @Override // defpackage.MQ0
    public final void o(int i) {
        this.L = i;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.I = true;
        this.v.c(true);
        ViewTreeObserver viewTreeObserver = this.H;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.H = this.F.getViewTreeObserver();
            }
            this.H.removeGlobalOnLayoutListener(this.B);
            this.H = null;
        }
        this.F.removeOnAttachStateChangeListener(this.C);
        NQ0 nq0 = this.D;
        if (nq0 != null) {
            nq0.onDismiss();
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
        this.A.y = i;
    }

    @Override // defpackage.nI1
    public final boolean q() {
        return !this.I && this.A.S.isShowing();
    }

    @Override // defpackage.MQ0
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.D = (NQ0) onDismissListener;
    }

    @Override // defpackage.MQ0
    public final void s(boolean z) {
        this.M = z;
    }

    @Override // defpackage.MQ0
    public final void t(int i) {
        this.A.v(i);
    }

    @Override // defpackage.MQ0
    public final void k(MenuC0775hQ0 menuC0775hQ0) {
    }
}
