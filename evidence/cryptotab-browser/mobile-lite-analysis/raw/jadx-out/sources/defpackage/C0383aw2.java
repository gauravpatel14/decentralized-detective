package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: renamed from: aw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0383aw2 {
    public static final C0383aw2 b;
    public final C0307Yv2 a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            b = C0296Xv2.q;
        } else {
            b = C0307Yv2.b;
        }
    }

    public C0383aw2(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.a = new C0296Xv2(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.a = new C0278Wv2(this, windowInsets);
        } else if (i >= 28) {
            this.a = new C0263Vv2(this, windowInsets);
        } else {
            this.a = new C0241Tv2(this, windowInsets);
        }
    }

    public static bx0 e(bx0 bx0Var, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, bx0Var.a - i);
        int iMax2 = Math.max(0, bx0Var.b - i2);
        int iMax3 = Math.max(0, bx0Var.c - i3);
        int iMax4 = Math.max(0, bx0Var.d - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? bx0Var : bx0.b(iMax, iMax2, iMax3, iMax4);
    }

    public static C0383aw2 g(View view, WindowInsets windowInsets) {
        C0383aw2 c0383aw2 = new C0383aw2(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            C0383aw2 c0383aw2G = AbstractC0604eo2.g(view);
            C0307Yv2 c0307Yv2 = c0383aw2.a;
            c0307Yv2.q(c0383aw2G);
            c0307Yv2.d(view.getRootView());
        }
        return c0383aw2;
    }

    public final int a() {
        return this.a.j().d;
    }

    public final int b() {
        return this.a.j().a;
    }

    public final int c() {
        return this.a.j().c;
    }

    public final int d() {
        return this.a.j().b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0383aw2)) {
            return false;
        }
        return Objects.equals(this.a, ((C0383aw2) obj).a);
    }

    public final WindowInsets f() {
        C0307Yv2 c0307Yv2 = this.a;
        if (c0307Yv2 instanceof C0241Tv2) {
            return ((C0241Tv2) c0307Yv2).c;
        }
        return null;
    }

    public final int hashCode() {
        C0307Yv2 c0307Yv2 = this.a;
        if (c0307Yv2 == null) {
            return 0;
        }
        return c0307Yv2.hashCode();
    }

    public C0383aw2() {
        this.a = new C0307Yv2(this);
    }
}
