package defpackage;

import androidx.fragment.app.h;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mY implements Runnable {
    public final /* synthetic */ h t;

    public mY(h hVar) {
        this.t = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.t;
        hVar.mOnDismissListener.onDismiss(hVar.mDialog);
    }
}
