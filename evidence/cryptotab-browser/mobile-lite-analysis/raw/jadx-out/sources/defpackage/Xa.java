package defpackage;

import android.view.Menu;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Xa {
    public final VR1 a;
    public final /* synthetic */ LayoutInflaterFactory2C0658fb b;

    public Xa(LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb, VR1 vr1) {
        this.b = layoutInflaterFactory2C0658fb;
        this.a = vr1;
    }

    public final void a(H3 h3) {
        VR1 vr1 = this.a;
        vr1.a.onDestroyActionMode(vr1.a(h3));
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.b;
        if (layoutInflaterFactory2C0658fb.P != null) {
            layoutInflaterFactory2C0658fb.E.getDecorView().removeCallbacks(layoutInflaterFactory2C0658fb.Q);
        }
        if (layoutInflaterFactory2C0658fb.O != null) {
            C1050lp2 c1050lp2 = layoutInflaterFactory2C0658fb.R;
            if (c1050lp2 != null) {
                c1050lp2.b();
            }
            C1050lp2 c1050lp2A = AbstractC0604eo2.a(layoutInflaterFactory2C0658fb.O);
            c1050lp2A.a(0.0f);
            layoutInflaterFactory2C0658fb.R = c1050lp2A;
            c1050lp2A.d(new Wa(2, this));
        }
        layoutInflaterFactory2C0658fb.N = null;
        ViewGroup viewGroup = layoutInflaterFactory2C0658fb.U;
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        viewGroup.requestApplyInsets();
        layoutInflaterFactory2C0658fb.J();
    }

    public final boolean b(H3 h3, MenuC0775hQ0 menuC0775hQ0) {
        ViewGroup viewGroup = this.b.U;
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        viewGroup.requestApplyInsets();
        VR1 vr1 = this.a;
        WR1 wr1A = vr1.a(h3);
        UJ1 uj1 = vr1.d;
        Menu xq0 = (Menu) uj1.get(menuC0775hQ0);
        if (xq0 == null) {
            xq0 = new XQ0(vr1.b, menuC0775hQ0);
            uj1.put(menuC0775hQ0, xq0);
        }
        return vr1.a.onPrepareActionMode(wr1A, xq0);
    }
}
