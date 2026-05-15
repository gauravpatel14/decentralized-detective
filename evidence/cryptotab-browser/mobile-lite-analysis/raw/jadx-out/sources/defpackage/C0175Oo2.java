package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: renamed from: Oo2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0175Oo2 implements y41 {
    public final Rect t = new Rect();
    public final /* synthetic */ ViewPager u;

    public C0175Oo2(ViewPager viewPager) {
        this.u = viewPager;
    }

    @Override // defpackage.y41
    public final C0383aw2 c(View view, C0383aw2 c0383aw2) {
        AbstractC0228Sv2 c0192Pv2;
        C0383aw2 c0383aw2I = AbstractC0604eo2.i(view, c0383aw2);
        if (c0383aw2I.a.m()) {
            return c0383aw2I;
        }
        int iB = c0383aw2I.b();
        Rect rect = this.t;
        rect.left = iB;
        rect.top = c0383aw2I.d();
        rect.right = c0383aw2I.c();
        rect.bottom = c0383aw2I.a();
        ViewPager viewPager = this.u;
        int childCount = viewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0383aw2 c0383aw2B = AbstractC0604eo2.b(viewPager.getChildAt(i), c0383aw2I);
            rect.left = Math.min(c0383aw2B.b(), rect.left);
            rect.top = Math.min(c0383aw2B.d(), rect.top);
            rect.right = Math.min(c0383aw2B.c(), rect.right);
            rect.bottom = Math.min(c0383aw2B.a(), rect.bottom);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            c0192Pv2 = new C0215Rv2(c0383aw2I);
        } else if (i2 >= 29) {
            c0192Pv2 = new C0192Pv2(c0383aw2I);
        } else {
            C0166Nv2 c0166Nv2 = new C0166Nv2(c0383aw2I);
            c0166Nv2.c = c0383aw2I.f();
            c0192Pv2 = c0166Nv2;
        }
        c0192Pv2.g(bx0.b(rect.left, rect.top, rect.right, rect.bottom));
        return c0192Pv2.b();
    }
}
