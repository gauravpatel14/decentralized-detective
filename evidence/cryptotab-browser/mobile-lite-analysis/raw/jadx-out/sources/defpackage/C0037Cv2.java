package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* JADX INFO: renamed from: Cv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0037Cv2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C0134Lv2 t;
    public final /* synthetic */ C0383aw2 u;
    public final /* synthetic */ C0383aw2 v;
    public final /* synthetic */ int w;
    public final /* synthetic */ View x;

    public C0037Cv2(C0134Lv2 c0134Lv2, C0383aw2 c0383aw2, C0383aw2 c0383aw22, int i, View view) {
        this.t = c0134Lv2;
        this.u = c0383aw2;
        this.v = c0383aw22;
        this.w = i;
        this.x = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AbstractC0228Sv2 c0192Pv2;
        float f;
        C0134Lv2 c0134Lv2;
        float animatedFraction = valueAnimator.getAnimatedFraction();
        C0134Lv2 c0134Lv22 = this.t;
        c0134Lv22.a.d(animatedFraction);
        float fB = c0134Lv22.a.b();
        PathInterpolator pathInterpolator = C0086Gv2.e;
        int i = Build.VERSION.SDK_INT;
        C0383aw2 c0383aw2 = this.u;
        if (i >= 30) {
            c0192Pv2 = new C0215Rv2(c0383aw2);
        } else if (i >= 29) {
            c0192Pv2 = new C0192Pv2(c0383aw2);
        } else {
            C0166Nv2 c0166Nv2 = new C0166Nv2(c0383aw2);
            c0166Nv2.c = c0383aw2.f();
            c0192Pv2 = c0166Nv2;
        }
        int i2 = 1;
        while (i2 <= 256) {
            int i3 = this.w & i2;
            C0307Yv2 c0307Yv2 = c0383aw2.a;
            if (i3 == 0) {
                c0192Pv2.c(i2, c0307Yv2.f(i2));
                f = fB;
                c0134Lv2 = c0134Lv22;
            } else {
                bx0 bx0VarF = c0307Yv2.f(i2);
                bx0 bx0VarF2 = this.v.a.f(i2);
                float f2 = 1.0f - fB;
                int i4 = (int) (((double) ((bx0VarF.a - bx0VarF2.a) * f2)) + 0.5d);
                int i5 = (int) (((double) ((bx0VarF.b - bx0VarF2.b) * f2)) + 0.5d);
                f = fB;
                int i6 = (int) (((double) ((bx0VarF.c - bx0VarF2.c) * f2)) + 0.5d);
                float f3 = (bx0VarF.d - bx0VarF2.d) * f2;
                c0134Lv2 = c0134Lv22;
                c0192Pv2.c(i2, C0383aw2.e(bx0VarF, i4, i5, i6, (int) (((double) f3) + 0.5d)));
            }
            i2 <<= 1;
            fB = f;
            c0134Lv22 = c0134Lv2;
        }
        C0086Gv2.g(this.x, c0192Pv2.b(), Collections.singletonList(c0134Lv22));
    }
}
