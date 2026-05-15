package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class m6 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController$RecycleListView t;
    public final /* synthetic */ q6 u;
    public final /* synthetic */ n6 v;

    public m6(n6 n6Var, AlertController$RecycleListView alertController$RecycleListView, q6 q6Var) {
        this.v = n6Var;
        this.t = alertController$RecycleListView;
        this.u = q6Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        n6 n6Var = this.v;
        boolean[] zArr = n6Var.r;
        AlertController$RecycleListView alertController$RecycleListView = this.t;
        if (zArr != null) {
            zArr[i] = alertController$RecycleListView.isItemChecked(i);
        }
        n6Var.v.onClick(this.u.b, i, alertController$RecycleListView.isItemChecked(i));
    }
}
