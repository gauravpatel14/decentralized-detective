package defpackage;

import android.os.Handler;
import android.widget.AbsListView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XG0 implements AbsListView.OnScrollListener {
    public final /* synthetic */ ZG0 a;

    public XG0(ZG0 zg0) {
        this.a = zg0;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            ZG0 zg0 = this.a;
            if (zg0.S.getInputMethodMode() == 2 || zg0.S.getContentView() == null) {
                return;
            }
            Handler handler = zg0.O;
            VG0 vg0 = zg0.K;
            handler.removeCallbacks(vg0);
            vg0.run();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
