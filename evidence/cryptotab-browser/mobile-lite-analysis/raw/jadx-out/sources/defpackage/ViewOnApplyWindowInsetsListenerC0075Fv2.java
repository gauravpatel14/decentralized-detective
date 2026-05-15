package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import java.util.Objects;

/* JADX INFO: renamed from: Fv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnApplyWindowInsetsListenerC0075Fv2 implements View.OnApplyWindowInsetsListener {
    public final Uw0 t;
    public C0383aw2 u;

    public ViewOnApplyWindowInsetsListenerC0075Fv2(View view, Uw0 uw0) {
        C0383aw2 c0383aw2B;
        AbstractC0228Sv2 c0192Pv2;
        this.t = uw0;
        C0383aw2 c0383aw2G = AbstractC0604eo2.g(view);
        if (c0383aw2G != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                c0192Pv2 = new C0215Rv2(c0383aw2G);
            } else if (i >= 29) {
                c0192Pv2 = new C0192Pv2(c0383aw2G);
            } else {
                C0166Nv2 c0166Nv2 = new C0166Nv2(c0383aw2G);
                c0166Nv2.c = c0383aw2G.f();
                c0192Pv2 = c0166Nv2;
            }
            c0383aw2B = c0192Pv2.b();
        } else {
            c0383aw2B = null;
        }
        this.u = c0383aw2B;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        C0307Yv2 c0307Yv2;
        Interpolator interpolator;
        if (!view.isLaidOut()) {
            this.u = C0383aw2.g(view, windowInsets);
            return C0086Gv2.i(view, windowInsets);
        }
        C0383aw2 c0383aw2G = C0383aw2.g(view, windowInsets);
        if (this.u == null) {
            this.u = AbstractC0604eo2.g(view);
        }
        if (this.u == null) {
            this.u = c0383aw2G;
            return C0086Gv2.i(view, windowInsets);
        }
        Uw0 uw0J = C0086Gv2.j(view);
        if (uw0J != null && Objects.equals(uw0J.a, windowInsets)) {
            return C0086Gv2.i(view, windowInsets);
        }
        C0383aw2 c0383aw2 = this.u;
        int i = 1;
        int i2 = 0;
        while (true) {
            c0307Yv2 = c0383aw2G.a;
            if (i > 256) {
                break;
            }
            if (!c0307Yv2.f(i).equals(c0383aw2.a.f(i))) {
                i2 |= i;
            }
            i <<= 1;
        }
        if (i2 == 0) {
            return C0086Gv2.i(view, windowInsets);
        }
        C0383aw2 c0383aw22 = this.u;
        if ((i2 & 8) != 0) {
            interpolator = c0307Yv2.f(8).d > c0383aw22.a.f(8).d ? C0086Gv2.e : C0086Gv2.f;
        } else {
            interpolator = C0086Gv2.g;
        }
        C0134Lv2 c0134Lv2 = new C0134Lv2(i2, interpolator, 160L);
        c0134Lv2.a.d(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(c0134Lv2.a.a());
        bx0 bx0VarF = c0307Yv2.f(i2);
        bx0 bx0VarF2 = c0383aw22.a.f(i2);
        int i3 = bx0VarF.a;
        int i4 = bx0VarF2.a;
        int iMin = Math.min(i3, i4);
        int i5 = bx0VarF.b;
        int i6 = bx0VarF2.b;
        int iMin2 = Math.min(i5, i6);
        int i7 = bx0VarF.c;
        int i8 = bx0VarF2.c;
        int i9 = i2;
        int iMin3 = Math.min(i7, i8);
        int i10 = bx0VarF.d;
        int i11 = bx0VarF2.d;
        C0022Bv2 c0022Bv2 = new C0022Bv2(bx0.b(iMin, iMin2, iMin3, Math.min(i10, i11)), bx0.b(Math.max(i3, i4), Math.max(i5, i6), Math.max(i7, i8), Math.max(i10, i11)));
        C0086Gv2.f(view, c0134Lv2, windowInsets, false);
        duration.addUpdateListener(new C0037Cv2(c0134Lv2, c0383aw2G, c0383aw22, i9, view));
        duration.addListener(new C0050Dv2(c0134Lv2, view));
        ViewTreeObserverOnPreDrawListenerC0447c51.a(view, new RunnableC0061Ev2(view, c0134Lv2, c0022Bv2, duration));
        this.u = c0383aw2G;
        return C0086Gv2.i(view, windowInsets);
    }
}
