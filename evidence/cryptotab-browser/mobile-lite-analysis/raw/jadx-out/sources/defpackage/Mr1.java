package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Mr1 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ RecyclerView u;

    public /* synthetic */ Mr1(int i, RecyclerView recyclerView) {
        this.t = i;
        this.u = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                RecyclerView recyclerView = this.u;
                if (recyclerView.O && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.M) {
                        recyclerView.requestLayout();
                    } else if (!recyclerView.R) {
                        recyclerView.q();
                    } else {
                        recyclerView.Q = true;
                    }
                    break;
                }
                break;
            default:
                RecyclerView recyclerView2 = this.u;
                WJ1 wj1 = recyclerView2.j0;
                if (wj1 != null) {
                    wj1.l();
                }
                recyclerView2.H0 = false;
                break;
        }
    }
}
