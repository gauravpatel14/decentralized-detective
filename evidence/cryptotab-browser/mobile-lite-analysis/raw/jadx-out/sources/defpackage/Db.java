package defpackage;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Db implements AdapterView.OnItemClickListener {
    public final /* synthetic */ Fb t;

    public Db(Fb fb) {
        this.t = fb;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Fb fb = this.t;
        fb.Z.setSelection(i);
        if (fb.Z.getOnItemClickListener() != null) {
            fb.Z.performItemClick(view, i, fb.W.getItemId(i));
        }
        fb.dismiss();
    }
}
