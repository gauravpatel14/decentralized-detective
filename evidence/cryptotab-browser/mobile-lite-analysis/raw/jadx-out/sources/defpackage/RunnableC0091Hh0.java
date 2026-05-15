package defpackage;

import androidx.fragment.app.g;
import androidx.fragment.app.n;

/* JADX INFO: renamed from: Hh0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0091Hh0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ Object u;

    public /* synthetic */ RunnableC0091Hh0(int i, Object obj) {
        this.t = i;
        this.u = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                ((n) this.u).startPostponedEnterTransition();
                break;
            case 1:
                ((n) this.u).callStartTransitionListener(false);
                break;
            default:
                g gVar = (g) this.u;
                if (!gVar.b.isEmpty()) {
                    gVar.e();
                }
                break;
        }
    }
}
