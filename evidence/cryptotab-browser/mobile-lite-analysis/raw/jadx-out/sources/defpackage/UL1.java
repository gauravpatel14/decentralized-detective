package defpackage;

import android.R;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class UL1 {
    public final View a;

    public UL1(View view) {
        this.a = view;
    }

    public void a() {
        View view = this.a;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void b() {
        final View viewFindViewById;
        View view = this.a;
        if (view == null) {
            return;
        }
        if (view.isInEditMode() || view.onCheckIsTextEditor()) {
            view.requestFocus();
            viewFindViewById = view;
        } else {
            viewFindViewById = view.getRootView().findFocus();
        }
        if (viewFindViewById == null) {
            viewFindViewById = view.getRootView().findViewById(R.id.content);
        }
        if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
            return;
        }
        viewFindViewById.post(new Runnable() { // from class: TL1
            @Override // java.lang.Runnable
            public final void run() {
                View view2 = viewFindViewById;
                ((InputMethodManager) view2.getContext().getSystemService("input_method")).showSoftInput(view2, 0);
            }
        });
    }
}
