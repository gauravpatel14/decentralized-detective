package defpackage;

import android.content.Context;
import android.view.MenuItem;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Wn {
    public final Context a;
    public UJ1 b;

    public Wn(Context context) {
        this.a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof aS1)) {
            return menuItem;
        }
        aS1 as1 = (aS1) menuItem;
        if (this.b == null) {
            this.b = new UJ1(0);
        }
        MenuItem menuItem2 = (MenuItem) this.b.get(as1);
        if (menuItem2 != null) {
            return menuItem2;
        }
        JQ0 jq0 = new JQ0(this.a, as1);
        this.b.put(as1, jq0);
        return jq0;
    }
}
