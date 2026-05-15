package defpackage;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IN1 implements Runnable {
    public final /* synthetic */ StaggeredGridLayoutManager t;

    public IN1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.t = staggeredGridLayoutManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.H0();
    }
}
