package defpackage;

import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: Nv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0166Nv2 extends AbstractC0228Sv2 {
    public static Field e = null;
    public static boolean f = false;
    public static Constructor g = null;
    public static boolean h = false;
    public WindowInsets c;
    public bx0 d;

    @Override // defpackage.AbstractC0228Sv2
    public final C0383aw2 b() {
        a();
        C0383aw2 c0383aw2G = C0383aw2.g(null, this.c);
        bx0[] bx0VarArr = this.b;
        C0307Yv2 c0307Yv2 = c0383aw2G.a;
        c0307Yv2.p(bx0VarArr);
        c0307Yv2.r(this.d);
        return c0383aw2G;
    }

    @Override // defpackage.AbstractC0228Sv2
    public final void e(bx0 bx0Var) {
        this.d = bx0Var;
    }

    @Override // defpackage.AbstractC0228Sv2
    public final void g(bx0 bx0Var) {
        WindowInsets windowInsets = this.c;
        if (windowInsets != null) {
            int i = bx0Var.d;
            this.c = windowInsets.replaceSystemWindowInsets(bx0Var.a, bx0Var.b, bx0Var.c, i);
        }
    }
}
