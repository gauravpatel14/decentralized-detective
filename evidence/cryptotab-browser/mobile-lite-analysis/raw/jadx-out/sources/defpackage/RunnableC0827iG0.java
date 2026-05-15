package defpackage;

import android.widget.ListView;

/* JADX INFO: renamed from: iG0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0827iG0 implements Runnable {
    public final /* synthetic */ C0949kG0 t;

    public RunnableC0827iG0(C0949kG0 c0949kG0) {
        this.t = c0949kG0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListView listView = this.t.x;
        listView.focusableViewAvailable(listView);
    }
}
