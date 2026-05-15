package defpackage;

import android.os.SystemClock;
import java.util.Iterator;
import org.chromium.ui.widget.LoadingView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LH0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ LoadingView u;

    public /* synthetic */ LH0(LoadingView loadingView, int i) {
        this.t = i;
        this.u = loadingView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LoadingView loadingView = this.u;
        switch (this.t) {
            case 0:
                if (loadingView.w) {
                    loadingView.t = SystemClock.elapsedRealtime();
                    loadingView.setVisibility(0);
                    loadingView.setAlpha(1.0f);
                    Iterator it = loadingView.u.iterator();
                    while (it.hasNext()) {
                        ((NH0) it.next()).g0();
                    }
                    break;
                }
                break;
            default:
                int i = LoadingView.y;
                loadingView.animate().alpha(0.0f).setInterpolator(kz0.g).setListener(new MH0(this));
                break;
        }
    }
}
