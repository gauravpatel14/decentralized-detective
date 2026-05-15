package defpackage;

import android.view.View;
import androidx.fragment.app.h;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class pY implements K21 {
    public final /* synthetic */ h a;

    public pY(h hVar) {
        this.a = hVar;
    }

    @Override // defpackage.K21
    public final void a(Object obj) {
        if (((InterfaceC0762hF0) obj) != null) {
            h hVar = this.a;
            if (hVar.mShowsDialog) {
                View viewRequireView = hVar.requireView();
                if (viewRequireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if (hVar.mDialog != null) {
                    hVar.mDialog.setContentView(viewRequireView);
                }
            }
        }
    }
}
