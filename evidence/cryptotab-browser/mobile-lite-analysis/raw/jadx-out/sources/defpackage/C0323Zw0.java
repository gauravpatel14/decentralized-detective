package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: Zw0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0323Zw0 implements y41 {
    public final Lt0 A;
    public int B;
    public C0383aw2 D;
    public final M21 w;
    public final C0264Vw0 x;
    public final M21 y = new M21();
    public final ArrayList z = new ArrayList();
    public final Rect t = new Rect();
    public final Rect u = new Rect();
    public final Rect C = new Rect();
    public int v = 0;

    public C0323Zw0(Lt0 lt0) {
        this.A = lt0;
        M21 m21 = new M21();
        this.w = m21;
        C0264Vw0 c0264Vw0 = new C0264Vw0();
        this.x = c0264Vw0;
        m21.e(c0264Vw0);
        Uw0 uw0 = new Uw0(this);
        View view = (View) lt0.get();
        if (view == null) {
            return;
        }
        if (view.getRootWindowInsets() != null) {
            this.D = C0383aw2.g(null, view.getRootWindowInsets());
        }
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(new C0107Iv2(uw0));
        } else {
            PathInterpolator pathInterpolator = C0086Gv2.e;
            Object tag = view.getTag(AbstractC0132Lp1.tag_on_apply_window_listener);
            ViewOnApplyWindowInsetsListenerC0075Fv2 viewOnApplyWindowInsetsListenerC0075Fv2 = new ViewOnApplyWindowInsetsListenerC0075Fv2(view, uw0);
            view.setTag(AbstractC0132Lp1.tag_window_insets_animation_callback, viewOnApplyWindowInsetsListenerC0075Fv2);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(viewOnApplyWindowInsetsListenerC0075Fv2);
            }
        }
        AbstractC0604eo2.q(view, this);
    }

    public final void a() {
        Rect rect = new Rect(this.C);
        rect.bottom += this.B;
        Rect rect2 = this.u;
        if (rect.equals(rect2)) {
            return;
        }
        rect2.set(rect);
        Iterator it = this.w.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((Ww0) l21.next()).a(new Rect(rect2));
            }
        }
    }

    @Override // defpackage.y41
    public final C0383aw2 c(View view, C0383aw2 c0383aw2) {
        int iA;
        this.D = c0383aw2;
        v00 v00VarE = c0383aw2.a.e();
        Rect rect = new Rect();
        if (v00VarE != null) {
            int i = Build.VERSION.SDK_INT;
            rect.set(i >= 28 ? u00.b(v00VarE.a) : 0, i >= 28 ? u00.d(v00VarE.a) : 0, i >= 28 ? u00.c(v00VarE.a) : 0, i >= 28 ? u00.a(v00VarE.a) : 0);
        }
        this.C.set(rect);
        a();
        Lt0 lt0 = this.A;
        View view2 = (View) lt0.get();
        if (view2 != null) {
            Iterator it = this.z.iterator();
            while (it.hasNext()) {
                c0383aw2 = ((Yw0) it.next()).c(view2, c0383aw2);
            }
        }
        View view3 = (View) lt0.get();
        M21 m21 = this.w;
        if (view3 != null && this.v != (iA = EC0.a(view3))) {
            this.v = iA;
            Iterator it2 = m21.iterator();
            while (true) {
                L21 l21 = (L21) it2;
                if (!l21.hasNext()) {
                    break;
                }
                ((Ww0) l21.next()).m(this.v);
            }
        }
        bx0 bx0VarF = c0383aw2.a.f(7);
        Rect rect2 = this.t;
        int i2 = rect2.left;
        int i3 = bx0VarF.a;
        int i4 = bx0VarF.b;
        int i5 = bx0VarF.c;
        int i6 = bx0VarF.d;
        if (i2 != i3 || rect2.top != i4 || rect2.right != i5 || rect2.bottom != i6) {
            rect2.set(i3, i4, i5, i6);
            Iterator it3 = m21.iterator();
            while (true) {
                L21 l212 = (L21) it3;
                if (!l212.hasNext()) {
                    break;
                }
                ((Ww0) l212.next()).h();
            }
        }
        return C0383aw2.g(null, view.onApplyWindowInsets(c0383aw2.f()));
    }
}
