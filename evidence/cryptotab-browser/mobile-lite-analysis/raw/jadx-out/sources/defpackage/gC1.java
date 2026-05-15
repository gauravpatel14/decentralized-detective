package defpackage;

import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gC1 implements View.OnKeyListener {
    public final /* synthetic */ SearchView t;

    public gC1(SearchView searchView) {
        this.t = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        this.t.getClass();
        return false;
    }
}
