package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: ab, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowCallbackC0365ab implements Window.Callback {
    public final Window.Callback t;
    public C0977kb2 u;
    public boolean v;
    public boolean w;
    public boolean x;
    public final /* synthetic */ LayoutInflaterFactory2C0658fb y;

    public WindowCallbackC0365ab(LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb, Window.Callback callback) {
        this.y = layoutInflaterFactory2C0658fb;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.t = callback;
    }

    public final void a(Window.Callback callback) {
        try {
            this.v = true;
            callback.onContentChanged();
        } finally {
            this.v = false;
        }
    }

    public final boolean b(int i, Menu menu) {
        return this.t.onMenuOpened(i, menu);
    }

    public final void c(int i, Menu menu) {
        this.t.onPanelClosed(i, menu);
    }

    public final void d(List list, Menu menu, int i) {
        this.t.onProvideKeyboardShortcuts(list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.t.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = this.w;
        Window.Callback callback = this.t;
        return z ? callback.dispatchKeyEvent(keyEvent) : this.y.v(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (this.t.dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.y;
        layoutInflaterFactory2C0658fb.B();
        AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
        if (abstractC0508d3 != null && abstractC0508d3.j(keyCode, keyEvent)) {
            return true;
        }
        C0595eb c0595eb = layoutInflaterFactory2C0658fb.g0;
        if (c0595eb != null && layoutInflaterFactory2C0658fb.G(c0595eb, keyEvent.getKeyCode(), keyEvent)) {
            C0595eb c0595eb2 = layoutInflaterFactory2C0658fb.g0;
            if (c0595eb2 == null) {
                return true;
            }
            c0595eb2.l = true;
            return true;
        }
        if (layoutInflaterFactory2C0658fb.g0 == null) {
            C0595eb c0595ebA = layoutInflaterFactory2C0658fb.A(0);
            layoutInflaterFactory2C0658fb.H(c0595ebA, keyEvent);
            boolean zG = layoutInflaterFactory2C0658fb.G(c0595ebA, keyEvent.getKeyCode(), keyEvent);
            c0595ebA.k = false;
            if (zG) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.t.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.t.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.t.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.t.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.t.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.t.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.v) {
            this.t.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof MenuC0775hQ0)) {
            return this.t.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        C0977kb2 c0977kb2 = this.u;
        if (c0977kb2 != null) {
            c0977kb2.getClass();
            View view = i == 0 ? new View(c0977kb2.t.a.a.getContext()) : null;
            if (view != null) {
                return view;
            }
        }
        return this.t.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.t.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.t.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        b(i, menu);
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.y;
        if (i == 108) {
            layoutInflaterFactory2C0658fb.B();
            AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
            if (abstractC0508d3 != null) {
                abstractC0508d3.c(true);
            }
        } else {
            layoutInflaterFactory2C0658fb.getClass();
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.x) {
            this.t.onPanelClosed(i, menu);
            return;
        }
        c(i, menu);
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.y;
        if (i == 108) {
            layoutInflaterFactory2C0658fb.B();
            AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
            if (abstractC0508d3 != null) {
                abstractC0508d3.c(false);
                return;
            }
            return;
        }
        if (i != 0) {
            layoutInflaterFactory2C0658fb.getClass();
            return;
        }
        C0595eb c0595ebA = layoutInflaterFactory2C0658fb.A(i);
        if (c0595ebA.m) {
            layoutInflaterFactory2C0658fb.t(c0595ebA, false);
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        this.t.onPointerCaptureChanged(z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        MenuC0775hQ0 menuC0775hQ0 = menu instanceof MenuC0775hQ0 ? (MenuC0775hQ0) menu : null;
        if (i == 0 && menuC0775hQ0 == null) {
            return false;
        }
        if (menuC0775hQ0 != null) {
            menuC0775hQ0.x = true;
        }
        C0977kb2 c0977kb2 = this.u;
        if (c0977kb2 != null && i == 0) {
            mb2 mb2Var = c0977kb2.t;
            if (!mb2Var.d) {
                mb2Var.a.l = true;
                mb2Var.d = true;
            }
        }
        boolean zOnPreparePanel = this.t.onPreparePanel(i, view, menu);
        if (menuC0775hQ0 != null) {
            menuC0775hQ0.x = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        MenuC0775hQ0 menuC0775hQ0 = this.y.A(0).h;
        if (menuC0775hQ0 != null) {
            d(list, menuC0775hQ0, i);
        } else {
            d(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.t.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.t.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.t.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        ViewGroup viewGroup;
        int i2 = 1;
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.y;
        if (!layoutInflaterFactory2C0658fb.S || i != 0) {
            return this.t.onWindowStartingActionMode(callback, i);
        }
        VR1 vr1 = new VR1(layoutInflaterFactory2C0658fb.D, callback);
        H3 h3 = layoutInflaterFactory2C0658fb.N;
        if (h3 != null) {
            h3.c();
        }
        Xa xa = new Xa(layoutInflaterFactory2C0658fb, vr1);
        layoutInflaterFactory2C0658fb.B();
        AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
        if (abstractC0508d3 != null) {
            layoutInflaterFactory2C0658fb.N = abstractC0508d3.t(xa);
        }
        if (layoutInflaterFactory2C0658fb.N == null) {
            C1050lp2 c1050lp2 = layoutInflaterFactory2C0658fb.R;
            if (c1050lp2 != null) {
                c1050lp2.b();
            }
            H3 h32 = layoutInflaterFactory2C0658fb.N;
            if (h32 != null) {
                h32.c();
            }
            if (layoutInflaterFactory2C0658fb.O == null) {
                boolean z = layoutInflaterFactory2C0658fb.c0;
                Context context = layoutInflaterFactory2C0658fb.D;
                if (z) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(Ep1.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        C1264pM c1264pM = new C1264pM(0, context);
                        c1264pM.getTheme().setTo(themeNewTheme);
                        context = c1264pM;
                    }
                    layoutInflaterFactory2C0658fb.O = new ActionBarContextView(context, null);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, Ep1.actionModePopupWindowStyle);
                    layoutInflaterFactory2C0658fb.P = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    layoutInflaterFactory2C0658fb.P.setContentView(layoutInflaterFactory2C0658fb.O);
                    layoutInflaterFactory2C0658fb.P.setWidth(-1);
                    context.getTheme().resolveAttribute(Ep1.actionBarSize, typedValue, true);
                    layoutInflaterFactory2C0658fb.O.x = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
                    layoutInflaterFactory2C0658fb.P.setHeight(-2);
                    layoutInflaterFactory2C0658fb.Q = new Ua(layoutInflaterFactory2C0658fb, i2);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) layoutInflaterFactory2C0658fb.U.findViewById(AbstractC0132Lp1.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        layoutInflaterFactory2C0658fb.B();
                        AbstractC0508d3 abstractC0508d32 = layoutInflaterFactory2C0658fb.H;
                        Context contextF = abstractC0508d32 != null ? abstractC0508d32.f() : null;
                        if (contextF != null) {
                            context = contextF;
                        }
                        viewStubCompat.w = LayoutInflater.from(context);
                        layoutInflaterFactory2C0658fb.O = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (layoutInflaterFactory2C0658fb.O != null) {
                C1050lp2 c1050lp22 = layoutInflaterFactory2C0658fb.R;
                if (c1050lp22 != null) {
                    c1050lp22.b();
                }
                layoutInflaterFactory2C0658fb.O.e();
                Context context2 = layoutInflaterFactory2C0658fb.O.getContext();
                ActionBarContextView actionBarContextView = layoutInflaterFactory2C0658fb.O;
                ON1 on1 = new ON1();
                on1.v = context2;
                on1.w = actionBarContextView;
                on1.x = xa;
                MenuC0775hQ0 menuC0775hQ0 = new MenuC0775hQ0(actionBarContextView.getContext());
                menuC0775hQ0.l = 1;
                on1.A = menuC0775hQ0;
                menuC0775hQ0.e = on1;
                if (xa.a.c(on1, menuC0775hQ0)) {
                    on1.i();
                    layoutInflaterFactory2C0658fb.O.c(on1);
                    layoutInflaterFactory2C0658fb.N = on1;
                    if (layoutInflaterFactory2C0658fb.T && (viewGroup = layoutInflaterFactory2C0658fb.U) != null && viewGroup.isLaidOut()) {
                        layoutInflaterFactory2C0658fb.O.setAlpha(0.0f);
                        C1050lp2 c1050lp2A = AbstractC0604eo2.a(layoutInflaterFactory2C0658fb.O);
                        c1050lp2A.a(1.0f);
                        layoutInflaterFactory2C0658fb.R = c1050lp2A;
                        c1050lp2A.d(new Wa(i2, layoutInflaterFactory2C0658fb));
                    } else {
                        layoutInflaterFactory2C0658fb.O.setAlpha(1.0f);
                        layoutInflaterFactory2C0658fb.O.setVisibility(0);
                        if (layoutInflaterFactory2C0658fb.O.getParent() instanceof View) {
                            View view = (View) layoutInflaterFactory2C0658fb.O.getParent();
                            WeakHashMap weakHashMap = AbstractC0604eo2.a;
                            view.requestApplyInsets();
                        }
                    }
                    if (layoutInflaterFactory2C0658fb.P != null) {
                        layoutInflaterFactory2C0658fb.E.getDecorView().post(layoutInflaterFactory2C0658fb.Q);
                    }
                } else {
                    layoutInflaterFactory2C0658fb.N = null;
                }
            }
            layoutInflaterFactory2C0658fb.J();
            layoutInflaterFactory2C0658fb.N = layoutInflaterFactory2C0658fb.N;
        }
        layoutInflaterFactory2C0658fb.J();
        H3 h33 = layoutInflaterFactory2C0658fb.N;
        if (h33 != null) {
            return vr1.a(h33);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.t.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
