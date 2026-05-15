package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.h;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class nY implements DialogInterface.OnCancelListener {
    public final /* synthetic */ h t;

    public nY(h hVar) {
        this.t = hVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        h hVar = this.t;
        if (hVar.mDialog != null) {
            hVar.onCancel(hVar.mDialog);
        }
    }
}
