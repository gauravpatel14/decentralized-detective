package defpackage;

import android.view.ViewGroup;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ua implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ LayoutInflaterFactory2C0658fb u;

    public /* synthetic */ Ua(LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb, int i) {
        this.t = i;
        this.u = layoutInflaterFactory2C0658fb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        switch (this.t) {
            case 0:
                LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.u;
                if ((layoutInflaterFactory2C0658fb.t0 & 1) != 0) {
                    layoutInflaterFactory2C0658fb.w(0);
                }
                if ((layoutInflaterFactory2C0658fb.t0 & 4096) != 0) {
                    layoutInflaterFactory2C0658fb.w(108);
                }
                layoutInflaterFactory2C0658fb.s0 = false;
                layoutInflaterFactory2C0658fb.t0 = 0;
                break;
            default:
                LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb2 = this.u;
                layoutInflaterFactory2C0658fb2.P.showAtLocation(layoutInflaterFactory2C0658fb2.O, 55, 0, 0);
                C1050lp2 c1050lp2 = layoutInflaterFactory2C0658fb2.R;
                if (c1050lp2 != null) {
                    c1050lp2.b();
                }
                if (!(layoutInflaterFactory2C0658fb2.T && (viewGroup = layoutInflaterFactory2C0658fb2.U) != null && viewGroup.isLaidOut())) {
                    layoutInflaterFactory2C0658fb2.O.setAlpha(1.0f);
                    layoutInflaterFactory2C0658fb2.O.setVisibility(0);
                } else {
                    layoutInflaterFactory2C0658fb2.O.setAlpha(0.0f);
                    C1050lp2 c1050lp2A = AbstractC0604eo2.a(layoutInflaterFactory2C0658fb2.O);
                    c1050lp2A.a(1.0f);
                    layoutInflaterFactory2C0658fb2.R = c1050lp2A;
                    c1050lp2A.d(new Wa(0, this));
                }
                break;
        }
    }
}
