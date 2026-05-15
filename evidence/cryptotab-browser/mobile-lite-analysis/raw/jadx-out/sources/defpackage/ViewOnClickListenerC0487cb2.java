package defpackage;

import android.view.View;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: renamed from: cb2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0487cb2 implements View.OnClickListener {
    public final /* synthetic */ Toolbar t;

    public ViewOnClickListenerC0487cb2(Toolbar toolbar) {
        this.t = toolbar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0660fb2 c0660fb2 = this.t.i0;
        DQ0 dq0 = c0660fb2 == null ? null : c0660fb2.u;
        if (dq0 != null) {
            dq0.collapseActionView();
        }
    }
}
