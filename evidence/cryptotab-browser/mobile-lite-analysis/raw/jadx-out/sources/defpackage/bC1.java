package defpackage;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bC1 implements TextWatcher {
    public final /* synthetic */ SearchView t;

    public bC1(SearchView searchView) {
        this.t = searchView;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SearchView searchView = this.t;
        TextUtils.isEmpty(searchView.I.getText());
        searchView.N.setVisibility(8);
        searchView.P.setVisibility(8);
        searchView.r();
        searchView.L.setVisibility(8);
        if (searchView.c0 != null && !TextUtils.equals(charSequence, searchView.k0)) {
            searchView.c0.onQueryTextChange(charSequence.toString());
        }
        searchView.k0 = charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
