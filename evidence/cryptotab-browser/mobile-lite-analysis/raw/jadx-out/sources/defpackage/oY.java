package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.h;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class oY implements DialogInterface.OnDismissListener {
    public final /* synthetic */ h t;

    public oY(h hVar) {
        this.t = hVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        h hVar = this.t;
        if (hVar.mDialog != null) {
            hVar.onDismiss(hVar.mDialog);
        }
    }
}
