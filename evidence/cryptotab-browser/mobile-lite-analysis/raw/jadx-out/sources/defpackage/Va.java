package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Va implements y41, SQ0 {
    public final /* synthetic */ int t;
    public final /* synthetic */ LayoutInflaterFactory2C0658fb u;

    public /* synthetic */ Va(LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb, int i) {
        this.t = i;
        this.u = layoutInflaterFactory2C0658fb;
    }

    @Override // defpackage.SQ0
    public void b(MenuC0775hQ0 menuC0775hQ0, boolean z) {
        C0595eb c0595eb;
        switch (this.t) {
            case 2:
                this.u.s(menuC0775hQ0);
                break;
            default:
                MenuC0775hQ0 menuC0775hQ0K = menuC0775hQ0.k();
                int i = 0;
                boolean z2 = menuC0775hQ0K != menuC0775hQ0;
                if (z2) {
                    menuC0775hQ0 = menuC0775hQ0K;
                }
                LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.u;
                C0595eb[] c0595ebArr = layoutInflaterFactory2C0658fb.f0;
                int length = c0595ebArr != null ? c0595ebArr.length : 0;
                while (true) {
                    if (i >= length) {
                        c0595eb = null;
                    } else {
                        c0595eb = c0595ebArr[i];
                        if (c0595eb == null || c0595eb.h != menuC0775hQ0) {
                            i++;
                        }
                    }
                }
                if (c0595eb != null) {
                    if (!z2) {
                        layoutInflaterFactory2C0658fb.t(c0595eb, z);
                    } else {
                        layoutInflaterFactory2C0658fb.r(c0595eb.a, c0595eb, menuC0775hQ0K);
                        layoutInflaterFactory2C0658fb.t(c0595eb, true);
                    }
                }
                break;
        }
    }

    @Override // defpackage.y41
    public C0383aw2 c(View view, C0383aw2 c0383aw2) {
        boolean z;
        C0383aw2 c0383aw2B;
        AbstractC0228Sv2 c0192Pv2;
        boolean z2;
        boolean z3;
        int iD = c0383aw2.d();
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.u;
        layoutInflaterFactory2C0658fb.getClass();
        int iD2 = c0383aw2.d();
        ActionBarContextView actionBarContextView = layoutInflaterFactory2C0658fb.O;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutInflaterFactory2C0658fb.O.getLayoutParams();
            if (layoutInflaterFactory2C0658fb.O.isShown()) {
                if (layoutInflaterFactory2C0658fb.w0 == null) {
                    layoutInflaterFactory2C0658fb.w0 = new Rect();
                    layoutInflaterFactory2C0658fb.x0 = new Rect();
                }
                Rect rect = layoutInflaterFactory2C0658fb.w0;
                Rect rect2 = layoutInflaterFactory2C0658fb.x0;
                rect.set(c0383aw2.b(), c0383aw2.d(), c0383aw2.c(), c0383aw2.a());
                ViewGroup viewGroup = layoutInflaterFactory2C0658fb.U;
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean z4 = Jp2.a;
                    AbstractC0072Fp2.a(rect, rect2, viewGroup);
                } else {
                    if (!Jp2.a) {
                        Jp2.a = true;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                            Jp2.b = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                Jp2.b.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    Method method = Jp2.b;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect, rect2);
                        } catch (Exception e) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                        }
                    }
                }
                int i = rect.top;
                int i2 = rect.left;
                int i3 = rect.right;
                C0383aw2 c0383aw2G = AbstractC0604eo2.g(layoutInflaterFactory2C0658fb.U);
                int iB = c0383aw2G == null ? 0 : c0383aw2G.b();
                int iC = c0383aw2G == null ? 0 : c0383aw2G.c();
                if (marginLayoutParams.topMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i;
                    marginLayoutParams.leftMargin = i2;
                    marginLayoutParams.rightMargin = i3;
                    z3 = true;
                }
                Context context = layoutInflaterFactory2C0658fb.D;
                if (i <= 0 || layoutInflaterFactory2C0658fb.W != null) {
                    View view2 = layoutInflaterFactory2C0658fb.W;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i4 = marginLayoutParams2.height;
                        int i5 = marginLayoutParams.topMargin;
                        if (i4 != i5 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                            marginLayoutParams2.height = i5;
                            marginLayoutParams2.leftMargin = iB;
                            marginLayoutParams2.rightMargin = iC;
                            layoutInflaterFactory2C0658fb.W.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    layoutInflaterFactory2C0658fb.W = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iC;
                    layoutInflaterFactory2C0658fb.U.addView(layoutInflaterFactory2C0658fb.W, -1, layoutParams);
                }
                View view4 = layoutInflaterFactory2C0658fb.W;
                boolean z5 = view4 != null;
                if (z5 && view4.getVisibility() != 0) {
                    View view5 = layoutInflaterFactory2C0658fb.W;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? context.getColor(AbstractC0084Gp1.abc_decor_view_status_guard_light) : context.getColor(AbstractC0084Gp1.abc_decor_view_status_guard));
                }
                if (!layoutInflaterFactory2C0658fb.b0 && z5) {
                    iD2 = 0;
                }
                z = z5;
                z2 = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (z2) {
                layoutInflaterFactory2C0658fb.O.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = layoutInflaterFactory2C0658fb.W;
        if (view6 != null) {
            view6.setVisibility(z ? 0 : 8);
        }
        if (iD != iD2) {
            int iB2 = c0383aw2.b();
            int iC2 = c0383aw2.c();
            int iA = c0383aw2.a();
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30) {
                c0192Pv2 = new C0215Rv2(c0383aw2);
            } else if (i6 >= 29) {
                c0192Pv2 = new C0192Pv2(c0383aw2);
            } else {
                C0166Nv2 c0166Nv2 = new C0166Nv2(c0383aw2);
                c0166Nv2.c = c0383aw2.f();
                c0192Pv2 = c0166Nv2;
            }
            c0192Pv2.g(bx0.b(iB2, iD2, iC2, iA));
            c0383aw2B = c0192Pv2.b();
        } else {
            c0383aw2B = c0383aw2;
        }
        return AbstractC0604eo2.i(view, c0383aw2B);
    }

    @Override // defpackage.SQ0
    public boolean d(MenuC0775hQ0 menuC0775hQ0) {
        Window.Callback callback;
        switch (this.t) {
            case 2:
                Window.Callback callback2 = this.u.E.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, menuC0775hQ0);
                }
                break;
            default:
                if (menuC0775hQ0 == menuC0775hQ0.k()) {
                    LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = this.u;
                    if (layoutInflaterFactory2C0658fb.Z && (callback = layoutInflaterFactory2C0658fb.E.getCallback()) != null && !layoutInflaterFactory2C0658fb.k0) {
                        callback.onMenuOpened(108, menuC0775hQ0);
                        break;
                    }
                }
                break;
        }
        return true;
    }
}
