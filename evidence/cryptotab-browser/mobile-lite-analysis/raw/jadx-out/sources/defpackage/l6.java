package defpackage;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class l6 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ q6 t;
    public final /* synthetic */ n6 u;

    public l6(n6 n6Var, q6 q6Var) {
        this.u = n6Var;
        this.t = q6Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        n6 n6Var = this.u;
        DialogInterface.OnClickListener onClickListener = n6Var.p;
        q6 q6Var = this.t;
        onClickListener.onClick(q6Var.b, i);
        if (n6Var.t) {
            return;
        }
        q6Var.b.dismiss();
    }
}
