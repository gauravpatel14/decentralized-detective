package defpackage;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class k6 extends ArrayAdapter {
    public final /* synthetic */ AlertController$RecycleListView t;
    public final /* synthetic */ n6 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k6(n6 n6Var, ContextThemeWrapper contextThemeWrapper, int i, CharSequence[] charSequenceArr, AlertController$RecycleListView alertController$RecycleListView) {
        super(contextThemeWrapper, i, R.id.text1, charSequenceArr);
        this.u = n6Var;
        this.t = alertController$RecycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.u.r;
        if (zArr != null && zArr[i]) {
            this.t.setItemChecked(i, true);
        }
        return view2;
    }
}
