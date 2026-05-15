package defpackage;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: tv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1531tv2 extends H3 implements InterfaceC0641fQ0 {
    public final Context v;
    public final MenuC0775hQ0 w;
    public Xa x;
    public WeakReference y;
    public final /* synthetic */ C1586uv2 z;

    public C1531tv2(C1586uv2 c1586uv2, Context context, Xa xa) {
        this.z = c1586uv2;
        this.v = context;
        this.x = xa;
        MenuC0775hQ0 menuC0775hQ0 = new MenuC0775hQ0(context);
        menuC0775hQ0.l = 1;
        this.w = menuC0775hQ0;
        menuC0775hQ0.e = this;
    }

    @Override // defpackage.InterfaceC0641fQ0
    public final boolean a(MenuC0775hQ0 menuC0775hQ0, MenuItem menuItem) {
        Xa xa = this.x;
        if (xa != null) {
            return xa.a.b(this, menuItem);
        }
        return false;
    }

    @Override // defpackage.InterfaceC0641fQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0) {
        if (this.x == null) {
            return;
        }
        i();
        C3 c3 = this.z.f.w;
        if (c3 != null) {
            c3.l();
        }
    }

    @Override // defpackage.H3
    public final void c() {
        C1586uv2 c1586uv2 = this.z;
        if (c1586uv2.i != this) {
            return;
        }
        if (c1586uv2.p) {
            c1586uv2.j = this;
            c1586uv2.k = this.x;
        } else {
            this.x.a(this);
        }
        this.x = null;
        c1586uv2.u(false);
        ActionBarContextView actionBarContextView = c1586uv2.f;
        if (actionBarContextView.D == null) {
            actionBarContextView.e();
        }
        c1586uv2.c.k(c1586uv2.u);
        c1586uv2.i = null;
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
        return this.w;
    }

    @Override // defpackage.H3
    public final MenuInflater f() {
        return new ZR1(this.v);
    }

    @Override // defpackage.H3
    public final CharSequence g() {
        return this.z.f.C;
    }

    @Override // defpackage.H3
    public final CharSequence h() {
        return this.z.f.B;
    }

    @Override // defpackage.H3
    public final void i() {
        if (this.z.i != this) {
            return;
        }
        MenuC0775hQ0 menuC0775hQ0 = this.w;
        menuC0775hQ0.w();
        try {
            this.x.b(this, menuC0775hQ0);
        } finally {
            menuC0775hQ0.v();
        }
    }

    @Override // defpackage.H3
    public final boolean j() {
        return this.z.f.L;
    }

    @Override // defpackage.H3
    public final void k(View view) {
        this.z.f.h(view);
        this.y = new WeakReference(view);
    }

    @Override // defpackage.H3
    public final void l(int i) {
        m(this.z.a.getResources().getString(i));
    }

    @Override // defpackage.H3
    public final void m(CharSequence charSequence) {
        ActionBarContextView actionBarContextView = this.z.f;
        actionBarContextView.C = charSequence;
        actionBarContextView.d();
    }

    @Override // defpackage.H3
    public final void n(int i) {
        o(this.z.a.getResources().getString(i));
    }

    @Override // defpackage.H3
    public final void o(CharSequence charSequence) {
        ActionBarContextView actionBarContextView = this.z.f;
        actionBarContextView.B = charSequence;
        actionBarContextView.d();
        AbstractC0604eo2.p(charSequence, actionBarContextView);
    }

    @Override // defpackage.H3
    public final void p(boolean z) {
        this.u = z;
        ActionBarContextView actionBarContextView = this.z.f;
        if (z != actionBarContextView.L) {
            actionBarContextView.requestLayout();
        }
        actionBarContextView.L = z;
    }
}
