package defpackage;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ON1 extends H3 implements InterfaceC0641fQ0 {
    public MenuC0775hQ0 A;
    public Context v;
    public ActionBarContextView w;
    public Xa x;
    public WeakReference y;
    public boolean z;

    @Override // defpackage.InterfaceC0641fQ0
    public final boolean a(MenuC0775hQ0 menuC0775hQ0, MenuItem menuItem) {
        return this.x.a.b(this, menuItem);
    }

    @Override // defpackage.InterfaceC0641fQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0) {
        i();
        C3 c3 = this.w.w;
        if (c3 != null) {
            c3.l();
        }
    }

    @Override // defpackage.H3
    public final void c() {
        if (this.z) {
            return;
        }
        this.z = true;
        this.x.a(this);
    }

    @Override // defpackage.H3
    public final View d() {
        WeakReference weakReference = this.y;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // defpackage.H3
    public final MenuC0775hQ0 e() {
        return this.A;
    }

    @Override // defpackage.H3
    public final MenuInflater f() {
        return new ZR1(this.w.getContext());
    }

    @Override // defpackage.H3
    public final CharSequence g() {
        return this.w.C;
    }

    @Override // defpackage.H3
    public final CharSequence h() {
        return this.w.B;
    }

    @Override // defpackage.H3
    public final void i() {
        this.x.b(this, this.A);
    }

    @Override // defpackage.H3
    public final boolean j() {
        return this.w.L;
    }

    @Override // defpackage.H3
    public final void k(View view) {
        this.w.h(view);
        this.y = view != null ? new WeakReference(view) : null;
    }

    @Override // defpackage.H3
    public final void l(int i) {
        m(this.v.getString(i));
    }

    @Override // defpackage.H3
    public final void m(CharSequence charSequence) {
        ActionBarContextView actionBarContextView = this.w;
        actionBarContextView.C = charSequence;
        actionBarContextView.d();
    }

    @Override // defpackage.H3
    public final void n(int i) {
        o(this.v.getString(i));
    }

    @Override // defpackage.H3
    public final void o(CharSequence charSequence) {
        ActionBarContextView actionBarContextView = this.w;
        actionBarContextView.B = charSequence;
        actionBarContextView.d();
        AbstractC0604eo2.p(charSequence, actionBarContextView);
    }

    @Override // defpackage.H3
    public final void p(boolean z) {
        this.u = z;
        ActionBarContextView actionBarContextView = this.w;
        if (z != actionBarContextView.L) {
            actionBarContextView.requestLayout();
        }
        actionBarContextView.L = z;
    }
}
