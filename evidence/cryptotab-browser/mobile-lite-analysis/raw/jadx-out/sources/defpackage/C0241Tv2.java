package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: renamed from: Tv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0241Tv2 extends C0307Yv2 {
    public static boolean i = false;
    public static Method j;
    public static Class k;
    public static Field l;
    public static Field m;
    public final WindowInsets c;
    public bx0[] d;
    public bx0 e;
    public C0383aw2 f;
    public bx0 g;
    public bx0 h;

    public C0241Tv2(C0383aw2 c0383aw2, WindowInsets windowInsets) {
        super(c0383aw2);
        this.e = null;
        this.c = windowInsets;
        this.h = null;
    }

    @Override // defpackage.C0307Yv2
    public final C0383aw2 b() {
        return C0383aw2.g(null, this.c.consumeStableInsets());
    }

    @Override // defpackage.C0307Yv2
    public final C0383aw2 c() {
        return C0383aw2.g(null, this.c.consumeSystemWindowInsets());
    }

    @Override // defpackage.C0307Yv2
    public void d(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        bx0 bx0VarB = null;
        if (!i) {
            try {
                j = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                k = cls;
                l = cls.getDeclaredField("mVisibleInsets");
                m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                l.setAccessible(true);
                m.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            i = true;
        }
        Method method = j;
        if (method != null && k != null && l != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                } else {
                    Rect rect = (Rect) l.get(m.get(objInvoke));
                    if (rect != null) {
                        bx0VarB = bx0.b(rect.left, rect.top, rect.right, rect.bottom);
                    }
                }
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
        }
        if (bx0VarB == null) {
            bx0VarB = bx0.e;
        }
        this.g = bx0VarB;
    }

    @Override // defpackage.C0307Yv2
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.g, ((C0241Tv2) obj).g);
        }
        return false;
    }

    @Override // defpackage.C0307Yv2
    public bx0 f(int i2) {
        bx0 bx0VarA = bx0.e;
        for (int i3 = 1; i3 <= 256; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                bx0VarA = bx0.a(bx0VarA, s(i3));
            }
        }
        return bx0VarA;
    }

    @Override // defpackage.C0307Yv2
    public final bx0 h() {
        if (this.h == null) {
            WindowInsets windowInsets = this.c;
            this.h = bx0.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.h;
    }

    @Override // defpackage.C0307Yv2
    public final bx0 j() {
        if (this.e == null) {
            WindowInsets windowInsets = this.c;
            this.e = bx0.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.e;
    }

    @Override // defpackage.C0307Yv2
    public C0383aw2 l(int i2, int i3, int i4, int i5) {
        AbstractC0228Sv2 c0192Pv2;
        C0383aw2 c0383aw2G = C0383aw2.g(null, this.c);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            c0192Pv2 = new C0215Rv2(c0383aw2G);
        } else if (i6 >= 29) {
            c0192Pv2 = new C0192Pv2(c0383aw2G);
        } else {
            C0166Nv2 c0166Nv2 = new C0166Nv2(c0383aw2G);
            c0166Nv2.c = c0383aw2G.f();
            c0192Pv2 = c0166Nv2;
        }
        c0192Pv2.g(C0383aw2.e(j(), i2, i3, i4, i5));
        c0192Pv2.e(C0383aw2.e(h(), i2, i3, i4, i5));
        return c0192Pv2.b();
    }

    @Override // defpackage.C0307Yv2
    public final boolean m() {
        return this.c.isConsumed();
    }

    @Override // defpackage.C0307Yv2
    public final boolean n() {
        return this.c.isRound();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x002d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x002e A[SYNTHETIC] */
    @Override // defpackage.C0307Yv2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o(int r6) {
        /*
            r5 = this;
            r0 = 1
            r1 = r0
        L2:
            r2 = 256(0x100, float:3.59E-43)
            if (r1 > r2) goto L31
            r2 = r6 & r1
            if (r2 != 0) goto Lb
            goto L2e
        Lb:
            r2 = 0
            if (r1 == r0) goto L20
            r3 = 2
            if (r1 == r3) goto L20
            r3 = 4
            if (r1 == r3) goto L1e
            r3 = 8
            if (r1 == r3) goto L20
            r3 = 128(0x80, float:1.8E-43)
            if (r1 == r3) goto L20
            r3 = r0
            goto L2b
        L1e:
            r3 = r2
            goto L2b
        L20:
            bx0 r3 = r5.s(r1)
            bx0 r4 = defpackage.bx0.e
            boolean r3 = r3.equals(r4)
            r3 = r3 ^ r0
        L2b:
            if (r3 != 0) goto L2e
            return r2
        L2e:
            int r1 = r1 << 1
            goto L2
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0241Tv2.o(int):boolean");
    }

    @Override // defpackage.C0307Yv2
    public final void p(bx0[] bx0VarArr) {
        this.d = bx0VarArr;
    }

    @Override // defpackage.C0307Yv2
    public final void q(C0383aw2 c0383aw2) {
        this.f = c0383aw2;
    }

    @Override // defpackage.C0307Yv2
    public void r(bx0 bx0Var) {
        this.h = bx0Var;
    }

    public final bx0 s(int i2) {
        bx0 bx0VarH;
        int i3;
        if (i2 == 1) {
            return bx0.b(0, j().b, 0, 0);
        }
        if (i2 == 2) {
            bx0 bx0VarJ = j();
            C0383aw2 c0383aw2 = this.f;
            bx0VarH = c0383aw2 != null ? c0383aw2.a.h() : null;
            int iMin = bx0VarJ.d;
            if (bx0VarH != null) {
                iMin = Math.min(iMin, bx0VarH.d);
            }
            return bx0.b(bx0VarJ.a, 0, bx0VarJ.c, iMin);
        }
        bx0 bx0Var = bx0.e;
        if (i2 == 8) {
            bx0[] bx0VarArr = this.d;
            bx0VarH = bx0VarArr != null ? bx0VarArr[3] : null;
            if (bx0VarH != null) {
                return bx0VarH;
            }
            bx0 bx0VarJ2 = j();
            C0383aw2 c0383aw22 = this.f;
            bx0 bx0VarH2 = c0383aw22 != null ? c0383aw22.a.h() : bx0Var;
            int i4 = bx0VarJ2.d;
            if (i4 > bx0VarH2.d) {
                return bx0.b(0, 0, 0, i4);
            }
            bx0 bx0Var2 = this.g;
            return (bx0Var2 == null || bx0Var2.equals(bx0Var) || (i3 = this.g.d) <= bx0VarH2.d) ? bx0Var : bx0.b(0, 0, 0, i3);
        }
        if (i2 == 16) {
            return i();
        }
        if (i2 == 32) {
            return g();
        }
        if (i2 == 64) {
            return k();
        }
        if (i2 != 128) {
            return bx0Var;
        }
        C0383aw2 c0383aw23 = this.f;
        v00 v00VarE = c0383aw23 != null ? c0383aw23.a.e() : e();
        if (v00VarE == null) {
            return bx0Var;
        }
        int i5 = Build.VERSION.SDK_INT;
        return bx0.b(i5 >= 28 ? u00.b(v00VarE.a) : 0, i5 >= 28 ? u00.d(v00VarE.a) : 0, i5 >= 28 ? u00.c(v00VarE.a) : 0, i5 >= 28 ? u00.a(v00VarE.a) : 0);
    }
}
