package defpackage;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TG0 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ ZG0 t;

    public TG0(ZG0 zg0) {
        this.t = zg0;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        V30 v30;
        if (i == -1 || (v30 = this.t.v) == null) {
            return;
        }
        v30.A = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
