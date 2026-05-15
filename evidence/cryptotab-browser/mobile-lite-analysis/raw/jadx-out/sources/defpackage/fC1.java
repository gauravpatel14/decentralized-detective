package defpackage;

import android.view.View;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class fC1 implements View.OnClickListener {
    public final /* synthetic */ SearchView t;

    public fC1(SearchView searchView) {
        this.t = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SearchView searchView = this.t;
        if (view == searchView.M) {
            searchView.o();
            return;
        }
        if (view == searchView.O) {
            searchView.n();
            return;
        }
        if (view == searchView.N) {
            searchView.p();
        } else if (view == searchView.P) {
            searchView.getClass();
        } else if (view == searchView.I) {
            searchView.m();
        }
    }
}
