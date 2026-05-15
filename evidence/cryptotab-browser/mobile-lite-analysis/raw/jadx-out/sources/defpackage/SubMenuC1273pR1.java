package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: pR1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SubMenuC1273pR1 extends MenuC0775hQ0 implements SubMenu {
    public final DQ0 A;
    public final MenuC0775hQ0 z;

    public SubMenuC1273pR1(Context context, MenuC0775hQ0 menuC0775hQ0, DQ0 dq0) {
        super(context);
        this.z = menuC0775hQ0;
        this.A = dq0;
    }

    @Override // defpackage.MenuC0775hQ0
    public final boolean d(DQ0 dq0) {
        return this.z.d(dq0);
    }

    @Override // defpackage.MenuC0775hQ0
    public final boolean e(MenuC0775hQ0 menuC0775hQ0, MenuItem menuItem) {
        return super.e(menuC0775hQ0, menuItem) || this.z.e(menuC0775hQ0, menuItem);
    }

    @Override // defpackage.MenuC0775hQ0
    public final boolean f(DQ0 dq0) {
        return this.z.f(dq0);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override // defpackage.MenuC0775hQ0
    public final String j() {
        DQ0 dq0 = this.A;
        int i = dq0 != null ? dq0.a : 0;
        if (i == 0) {
            return null;
        }
        return AbstractC1214oR1.a(i, "android:menu:actionviewstates:");
    }

    @Override // defpackage.MenuC0775hQ0
    public final MenuC0775hQ0 k() {
        return this.z.k();
    }

    @Override // defpackage.MenuC0775hQ0
    public final boolean m() {
        return this.z.m();
    }

    @Override // defpackage.MenuC0775hQ0
    public final boolean n() {
        return this.z.n();
    }

    @Override // defpackage.MenuC0775hQ0
    public final boolean o() {
        return this.z.o();
    }

    @Override // defpackage.MenuC0775hQ0, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.z.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // defpackage.MenuC0775hQ0, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.z.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        u(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        u(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.A.setIcon(i);
        return this;
    }
}
