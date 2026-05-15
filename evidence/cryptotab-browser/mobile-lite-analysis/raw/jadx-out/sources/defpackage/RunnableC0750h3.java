package defpackage;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: renamed from: h3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0750h3 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ ActionBarOverlayLayout u;

    public /* synthetic */ RunnableC0750h3(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.t = i;
        this.u = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.u;
                actionBarOverlayLayout.d();
                actionBarOverlayLayout.S = actionBarOverlayLayout.w.animate().translationY(0.0f).setListener(actionBarOverlayLayout.T);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.u;
                actionBarOverlayLayout2.d();
                actionBarOverlayLayout2.S = actionBarOverlayLayout2.w.animate().translationY(-actionBarOverlayLayout2.w.getHeight()).setListener(actionBarOverlayLayout2.T);
                break;
        }
    }
}
