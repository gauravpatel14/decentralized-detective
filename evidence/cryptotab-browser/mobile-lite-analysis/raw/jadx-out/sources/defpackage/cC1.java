package defpackage;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class cC1 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ View u;

    public /* synthetic */ cC1(View view, int i) {
        this.t = i;
        this.u = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                ((SearchView) this.u).s();
                break;
            case 1:
                ((SearchView) this.u).getClass();
                break;
            default:
                SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) this.u;
                if (searchAutoComplete.z) {
                    ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                    searchAutoComplete.z = false;
                }
                break;
        }
    }
}
