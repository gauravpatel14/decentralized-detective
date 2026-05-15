package defpackage;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mb2 extends AbstractC0508d3 {
    public final C0791hd2 a;
    public final WindowCallbackC0365ab b;
    public final C0977kb2 c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final ArrayList g = new ArrayList();
    public final RunnableC0916jb2 h = new RunnableC0916jb2(this);

    public mb2(Toolbar toolbar, CharSequence charSequence, WindowCallbackC0365ab windowCallbackC0365ab) {
        C0977kb2 c0977kb2 = new C0977kb2(this);
        C0791hd2 c0791hd2 = new C0791hd2(toolbar, false);
        this.a = c0791hd2;
        this.b = windowCallbackC0365ab;
        c0791hd2.k = windowCallbackC0365ab;
        toolbar.e0 = c0977kb2;
        if (!c0791hd2.g) {
            c0791hd2.h = charSequence;
            if ((c0791hd2.b & 8) != 0) {
                Toolbar toolbar2 = c0791hd2.a;
                toolbar2.G(charSequence);
                if (c0791hd2.g) {
                    AbstractC0604eo2.p(charSequence, toolbar2.getRootView());
                }
            }
        }
        this.c = new C0977kb2(this);
    }

    @Override // defpackage.AbstractC0508d3
    public final boolean a() {
        return this.a.a.r();
    }

    @Override // defpackage.AbstractC0508d3
    public final boolean b() {
        DQ0 dq0;
        C0660fb2 c0660fb2 = this.a.a.i0;
        if (c0660fb2 == null || (dq0 = c0660fb2.u) == null) {
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
    public final void c(boolean z) {
        if (z == this.f) {
            return;
        }
        this.f = z;
        ArrayList arrayList = this.g;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.AbstractC0508d3
    public final int d() {
        return this.a.b;
    }

    @Override // defpackage.AbstractC0508d3
    public final int e() {
        return this.a.a.getHeight();
    }

    @Override // defpackage.AbstractC0508d3
    public final Context f() {
        return this.a.a.getContext();
    }

    @Override // defpackage.AbstractC0508d3
    public final boolean g() {
        C0791hd2 c0791hd2 = this.a;
        Toolbar toolbar = c0791hd2.a;
        RunnableC0916jb2 runnableC0916jb2 = this.h;
        toolbar.removeCallbacks(runnableC0916jb2);
        Toolbar toolbar2 = c0791hd2.a;
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        toolbar2.postOnAnimation(runnableC0916jb2);
        return true;
    }

    @Override // defpackage.AbstractC0508d3
    public final void i() {
        this.a.a.removeCallbacks(this.h);
    }

    @Override // defpackage.AbstractC0508d3
    public final boolean j(int i, KeyEvent keyEvent) {
        MenuC0775hQ0 menuC0775hQ0U = u();
        if (menuC0775hQ0U == null) {
            return false;
        }
        menuC0775hQ0U.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuC0775hQ0U.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.AbstractC0508d3
    public final boolean k(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            l();
        }
        return true;
    }

    @Override // defpackage.AbstractC0508d3
    public final boolean l() {
        return this.a.a.I();
    }

    @Override // defpackage.AbstractC0508d3
    public final void n(boolean z) {
        int i = z ? 4 : 0;
        C0791hd2 c0791hd2 = this.a;
        c0791hd2.a((i & 4) | (c0791hd2.b & (-5)));
    }

    @Override // defpackage.AbstractC0508d3
    public final void o(int i) {
        this.a.b(i);
    }

    @Override // defpackage.AbstractC0508d3
    public final void q(int i) {
        C0791hd2 c0791hd2 = this.a;
        CharSequence text = i != 0 ? c0791hd2.a.getContext().getText(i) : null;
        c0791hd2.g = true;
        c0791hd2.h = text;
        if ((c0791hd2.b & 8) != 0) {
            Toolbar toolbar = c0791hd2.a;
            toolbar.G(text);
            if (c0791hd2.g) {
                AbstractC0604eo2.p(text, toolbar.getRootView());
            }
        }
    }

    @Override // defpackage.AbstractC0508d3
    public final void r(String str) {
        C0791hd2 c0791hd2 = this.a;
        c0791hd2.g = true;
        c0791hd2.h = "";
        if ((c0791hd2.b & 8) != 0) {
            Toolbar toolbar = c0791hd2.a;
            toolbar.G("");
            if (c0791hd2.g) {
                AbstractC0604eo2.p("", toolbar.getRootView());
            }
        }
    }

    @Override // defpackage.AbstractC0508d3
    public final void s(CharSequence charSequence) {
        C0791hd2 c0791hd2 = this.a;
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

    public final MenuC0775hQ0 u() {
        boolean z = this.e;
        C0791hd2 c0791hd2 = this.a;
        if (!z) {
            C1039lb2 c1039lb2 = new C1039lb2(this);
            C0977kb2 c0977kb2 = new C0977kb2(this);
            Toolbar toolbar = c0791hd2.a;
            toolbar.j0 = c1039lb2;
            toolbar.k0 = c0977kb2;
            ActionMenuView actionMenuView = toolbar.t;
            if (actionMenuView != null) {
                actionMenuView.N = c1039lb2;
                actionMenuView.O = c0977kb2;
            }
            this.e = true;
        }
        return c0791hd2.a.o();
    }

    @Override // defpackage.AbstractC0508d3
    public final void h() {
    }

    @Override // defpackage.AbstractC0508d3
    public final void m(boolean z) {
    }

    @Override // defpackage.AbstractC0508d3
    public final void p(boolean z) {
    }
}
