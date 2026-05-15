package defpackage;

import android.view.MenuItem;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IQ0 implements MenuItem.OnMenuItemClickListener {
    public final MenuItem.OnMenuItemClickListener t;
    public final /* synthetic */ JQ0 u;

    public IQ0(JQ0 jq0, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.u = jq0;
        this.t = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.t.onMenuItemClick(this.u.c(menuItem));
    }
}
