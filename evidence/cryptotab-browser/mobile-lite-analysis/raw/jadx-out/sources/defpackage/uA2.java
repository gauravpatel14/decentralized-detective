package defpackage;

import android.app.Dialog;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.api.internal.zabw;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class uA2 extends zabw {
    public final /* synthetic */ Dialog a;
    public final /* synthetic */ g b;

    public uA2(g gVar, Dialog dialog) {
        this.b = gVar;
        this.a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        this.b.u.zad();
        Dialog dialog = this.a;
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
