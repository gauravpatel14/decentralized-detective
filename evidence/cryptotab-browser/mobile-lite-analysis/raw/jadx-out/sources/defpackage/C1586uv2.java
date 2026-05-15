package defpackage;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: uv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1586uv2 extends AbstractC0508d3 {
    public static final AccelerateInterpolator y = new AccelerateInterpolator();
    public static final DecelerateInterpolator z = new DecelerateInterpolator();
    public Context a;
    public Context b;
    public ActionBarOverlayLayout c;
    public ActionBarContainer d;
    public C0791hd2 e;
    public ActionBarContextView f;
    public final View g;
    public boolean h;
    public C1531tv2 i;
    public C1531tv2 j;
    public Xa k;
    public boolean l;
    public final ArrayList m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public C1173np2 s;
    public boolean t;
    public boolean u;
    public final C1413rv2 v;
    public final C1413rv2 w;
    public final C1471sv2 x;

    public C1586uv2(Activity activity, boolean z2) {
        new ArrayList();
        this.m = new ArrayList();
        this.n = 0;
        this.o = true;
        this.r = true;
        this.v = new C1413rv2(this, 0);
        this.w = new C1413rv2(this, 1);
        this.x = new C1471sv2(this);
        View decorView = activity.getWindow().getDecorView();
        v(decorView);
        if (z2) {
            return;
        }
        this.g = decorView.findViewById(R.id.content);
    }

    @Override // defpackage.AbstractC0508d3
    public final boolean b() {
        C0660fb2 c0660fb2;
        DQ0 dq0;
        C0791hd2 c0791hd2 = this.e;
        if (c0791hd2 == null || (c0660fb2 = c0791hd2.a.i0) == null || (dq0 = c0660fb2.u) == null) {
            return false;
        }
        if (c0660fb2 == null) {
            dq0 = null;
        }
        if (dq0 == null) {
            return true;
        }
        dq0.collapseActionView();
        return true;
    }

    @Override // defpackage.AbstractC0508d3
    public final void c(boolean z2) {
        if (z2 == this.l) {
            return;
        }
        this.l = z2;
        ArrayList arrayList = this.m;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.AbstractC0508d3
    public final int d() {
        return this.e.b;
    }

    @Override // defpackage.AbstractC0508d3
    public final int e() {
        return this.d.getHeight();
    }

    @Override // defpackage.AbstractC0508d3
    public final Context f() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(Ep1.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.a, i);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // defpackage.AbstractC0508d3
    public final void h() {
        w(this.a.getResources().getBoolean(AbstractC0071Fp1.abc_action_bar_embed_tabs));
    }

    @Override // defpackage.AbstractC0508d3
    public final boolean j(int i, KeyEvent keyEvent) {
        MenuC0775hQ0 menuC0775hQ0;
        C1531tv2 c1531tv2 = this.i;
        if (c1531tv2 == null || (menuC0775hQ0 = c1531tv2.w) == null) {
            return false;
        }
        menuC0775hQ0.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuC0775hQ0.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.AbstractC0508d3
    public final void m(boolean z2) {
        if (this.h) {
            return;
        }
        n(z2);
    }

    @Override // defpackage.AbstractC0508d3
    public final void n(boolean z2) {
        int i = z2 ? 4 : 0;
        C0791hd2 c0791hd2 = this.e;
        int i2 = c0791hd2.b;
        this.h = true;
        c0791hd2.a((i & 4) | (i2 & (-5)));
    }

    @Override // defpackage.AbstractC0508d3
    public final void o(int i) {
        this.e.b(i);
    }

    @Override // defpackage.AbstractC0508d3
    public final void p(boolean z2) {
        C1173np2 c1173np2;
        this.t = z2;
        if (z2 || (c1173np2 = this.s) == null) {
            return;
        }
        c1173np2.a();
    }

    @Override // defpackage.AbstractC0508d3
    public final void q(int i) {
        r(this.a.getString(i));
    }

    @Override // defpackage.AbstractC0508d3
    public final void r(String str) {
        C0791hd2 c0791hd2 = this.e;
        c0791hd2.g = true;
        c0791hd2.h = str;
        if ((c0791hd2.b & 8) != 0) {
            Toolbar toolbar = c0791hd2.a;
            toolbar.G(str);
            if (c0791hd2.g) {
                AbstractC0604eo2.p(str, toolbar.getRootView());
            }
        }
    }

    @Override // defpackage.AbstractC0508d3
    public final void s(CharSequence charSequence) {
        C0791hd2 c0791hd2 = this.e;
        if (c0791hd2.g) {
            return;
        }
        c0791hd2.h = charSequence;
        if ((c0791hd2.b & 8) != 0) {
            Toolbar toolbar = c0791hd2.a;
            toolbar.G(charSequence);
            if (c0791hd2.g) {
                AbstractC0604eo2.p(charSequence, toolbar.getRootView());
            }
        }
    }

    @Override // defpackage.AbstractC0508d3
    public final H3 t(Xa xa) {
        C1531tv2 c1531tv2 = this.i;
        if (c1531tv2 != null) {
            c1531tv2.c();
        }
        this.c.k(false);
        this.f.e();
        C1531tv2 c1531tv22 = new C1531tv2(this, this.f.getContext(), xa);
        MenuC0775hQ0 menuC0775hQ0 = c1531tv22.w;
        menuC0775hQ0.w();
        try {
            if (!c1531tv22.x.a.c(c1531tv22, menuC0775hQ0)) {
                return null;
            }
            this.i = c1531tv22;
            c1531tv22.i();
            this.f.c(c1531tv22);
            u(true);
            return c1531tv22;
        } finally {
            menuC0775hQ0.v();
        }
    }

    public final void u(boolean z2) {
        C1050lp2 c1050lp2I;
        C1050lp2 c1050lp2I2;
        if (z2) {
            if (!this.q) {
                this.q = true;
                x(false);
            }
        } else if (this.q) {
            this.q = false;
            x(false);
        }
        if (!this.d.isLaidOut()) {
            if (z2) {
                this.e.a.setVisibility(4);
                this.f.setVisibility(0);
                return;
            } else {
                this.e.a.setVisibility(0);
                this.f.setVisibility(8);
                return;
            }
        }
        if (z2) {
            C0791hd2 c0791hd2 = this.e;
            c1050lp2I = AbstractC0604eo2.a(c0791hd2.a);
            c1050lp2I.a(0.0f);
            c1050lp2I.c(100L);
            c1050lp2I.d(new C0725gd2(c0791hd2, 4));
            c1050lp2I2 = this.f.i(0, 200L);
        } else {
            C0791hd2 c0791hd22 = this.e;
            C1050lp2 c1050lp2A = AbstractC0604eo2.a(c0791hd22.a);
            c1050lp2A.a(1.0f);
            c1050lp2A.c(200L);
            c1050lp2A.d(new C0725gd2(c0791hd22, 0));
            c1050lp2I = this.f.i(8, 100L);
            c1050lp2I2 = c1050lp2A;
        }
        C1173np2 c1173np2 = new C1173np2();
        ArrayList arrayList = c1173np2.a;
        arrayList.add(c1050lp2I);
        View view = (View) c1050lp2I.a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) c1050lp2I2.a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(c1050lp2I2);
        c1173np2.b();
    }

    public final void v(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(AbstractC0132Lp1.decor_content_parent);
        this.c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.Q = this;
            if (actionBarOverlayLayout.getWindowToken() != null) {
                actionBarOverlayLayout.Q.n = actionBarOverlayLayout.u;
                int i = actionBarOverlayLayout.E;
                if (i != 0) {
                    actionBarOverlayLayout.onWindowSystemUiVisibilityChanged(i);
                    WeakHashMap weakHashMap = AbstractC0604eo2.a;
                    actionBarOverlayLayout.requestApplyInsets();
                }
            }
        }
        View viewFindViewById = view.findViewById(AbstractC0132Lp1.action_bar);
        if (!(viewFindViewById instanceof Toolbar)) {
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(viewFindViewById != null ? viewFindViewById.getClass().getSimpleName() : "null"));
        }
        Toolbar toolbar = (Toolbar) viewFindViewById;
        if (toolbar.g0 == null) {
            toolbar.g0 = new C0791hd2(toolbar, true);
        }
        this.e = toolbar.g0;
        this.f = (ActionBarContextView) view.findViewById(AbstractC0132Lp1.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(AbstractC0132Lp1.action_bar_container);
        this.d = actionBarContainer;
        C0791hd2 c0791hd2 = this.e;
        if (c0791hd2 == null || this.f == null || actionBarContainer == null) {
            throw new IllegalStateException(C1586uv2.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = c0791hd2.a.getContext();
        this.a = context;
        if ((this.e.b & 4) != 0) {
            this.h = true;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        this.e.getClass();
        w(context.getResources().getBoolean(AbstractC0071Fp1.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, AbstractC0305Yp1.ActionBar, Ep1.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(AbstractC0305Yp1.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (!actionBarOverlayLayout2.z) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.u = true;
            actionBarOverlayLayout2.k(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0305Yp1.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.d;
            WeakHashMap weakHashMap2 = AbstractC0604eo2.a;
            actionBarContainer2.setElevation(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void w(boolean z2) {
        if (z2) {
            this.d.getClass();
            this.e.getClass();
        } else {
            this.e.getClass();
            this.d.getClass();
        }
        C0791hd2 c0791hd2 = this.e;
        c0791hd2.getClass();
        Toolbar toolbar = c0791hd2.a;
        toolbar.l0 = false;
        toolbar.requestLayout();
        this.c.A = false;
    }

    public final void x(boolean z2) {
        boolean z3 = this.q || !this.p;
        View view = this.g;
        final C1471sv2 c1471sv2 = this.x;
        if (!z3) {
            if (this.r) {
                this.r = false;
                C1173np2 c1173np2 = this.s;
                if (c1173np2 != null) {
                    c1173np2.a();
                }
                int i = this.n;
                C1413rv2 c1413rv2 = this.v;
                if (i != 0 || (!this.t && !z2)) {
                    c1413rv2.a();
                    return;
                }
                this.d.setAlpha(1.0f);
                ActionBarContainer actionBarContainer = this.d;
                actionBarContainer.t = true;
                actionBarContainer.setDescendantFocusability(393216);
                C1173np2 c1173np22 = new C1173np2();
                float f = -this.d.getHeight();
                if (z2) {
                    this.d.getLocationInWindow(new int[]{0, 0});
                    f -= r12[1];
                }
                C1050lp2 c1050lp2A = AbstractC0604eo2.a(this.d);
                c1050lp2A.e(f);
                final View view2 = (View) c1050lp2A.a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(c1471sv2 != null ? new ValueAnimator.AnimatorUpdateListener(view2) { // from class: jp2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) this.t.a.d.getParent()).invalidate();
                        }
                    } : null);
                }
                boolean z4 = c1173np22.e;
                ArrayList arrayList = c1173np22.a;
                if (!z4) {
                    arrayList.add(c1050lp2A);
                }
                if (this.o && view != null) {
                    C1050lp2 c1050lp2A2 = AbstractC0604eo2.a(view);
                    c1050lp2A2.e(f);
                    if (!c1173np22.e) {
                        arrayList.add(c1050lp2A2);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = y;
                boolean z5 = c1173np22.e;
                if (!z5) {
                    c1173np22.c = accelerateInterpolator;
                }
                if (!z5) {
                    c1173np22.b = 250L;
                }
                if (!z5) {
                    c1173np22.d = c1413rv2;
                }
                this.s = c1173np22;
                c1173np22.b();
                return;
            }
            return;
        }
        if (this.r) {
            return;
        }
        this.r = true;
        C1173np2 c1173np23 = this.s;
        if (c1173np23 != null) {
            c1173np23.a();
        }
        this.d.setVisibility(0);
        int i2 = this.n;
        C1413rv2 c1413rv22 = this.w;
        if (i2 == 0 && (this.t || z2)) {
            this.d.setTranslationY(0.0f);
            float f2 = -this.d.getHeight();
            if (z2) {
                this.d.getLocationInWindow(new int[]{0, 0});
                f2 -= r12[1];
            }
            this.d.setTranslationY(f2);
            C1173np2 c1173np24 = new C1173np2();
            C1050lp2 c1050lp2A3 = AbstractC0604eo2.a(this.d);
            c1050lp2A3.e(0.0f);
            final View view3 = (View) c1050lp2A3.a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(c1471sv2 != null ? new ValueAnimator.AnimatorUpdateListener(view3) { // from class: jp2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((View) this.t.a.d.getParent()).invalidate();
                    }
                } : null);
            }
            boolean z6 = c1173np24.e;
            ArrayList arrayList2 = c1173np24.a;
            if (!z6) {
                arrayList2.add(c1050lp2A3);
            }
            if (this.o && view != null) {
                view.setTranslationY(f2);
                C1050lp2 c1050lp2A4 = AbstractC0604eo2.a(view);
                c1050lp2A4.e(0.0f);
                if (!c1173np24.e) {
                    arrayList2.add(c1050lp2A4);
                }
            }
            DecelerateInterpolator decelerateInterpolator = z;
            boolean z7 = c1173np24.e;
            if (!z7) {
                c1173np24.c = decelerateInterpolator;
            }
            if (!z7) {
                c1173np24.b = 250L;
            }
            if (!z7) {
                c1173np24.d = c1413rv22;
            }
            this.s = c1173np24;
            c1173np24.b();
        } else {
            this.d.setAlpha(1.0f);
            this.d.setTranslationY(0.0f);
            if (this.o && view != null) {
                view.setTranslationY(0.0f);
            }
            c1413rv22.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            actionBarOverlayLayout.requestApplyInsets();
        }
    }

    public C1586uv2(Dialog dialog) {
        new ArrayList();
        this.m = new ArrayList();
        this.n = 0;
        this.o = true;
        this.r = true;
        this.v = new C1413rv2(this, 0);
        this.w = new C1413rv2(this, 1);
        this.x = new C1471sv2(this);
        v(dialog.getWindow().getDecorView());
    }
}
